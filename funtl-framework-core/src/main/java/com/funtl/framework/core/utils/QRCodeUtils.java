/*
 * Copyright 2015-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.funtl.framework.core.utils;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;
import java.util.Hashtable;
import java.util.Random;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * 二维码工具类
 * Created by 李卫民 on 2016/8/24.
 */
public class QRCodeUtils {
	private static final String CHARSET = "utf-8";
	private static final String FORMAT = "JPG";

	/**
	 * 创建二维码
	 *
	 * @param size         二维码尺寸
	 * @param content      二维码内容
	 * @param logoPath     Logo地址
	 * @param needCompress 是否压缩
	 * @return
	 * @throws Exception
	 */
	private static BufferedImage createImage(int size, String content, String logoPath, boolean needCompress) throws Exception {
		Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
		hints.put(EncodeHintType.MARGIN, 1);
		BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, size, size, hints);
		int width = bitMatrix.getWidth();
		int height = bitMatrix.getHeight();
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
			}
		}
		if (logoPath == null || "".equals(logoPath)) {
			return image;
		}
		// 插入图片
		QRCodeUtils.insertImage(size, image, logoPath, needCompress);
		return image;
	}

	/**
	 * 插入LOGO
	 *
	 * @param size         二维码尺寸
	 * @param source       二维码图片
	 * @param logoPath     LOGO图片地址
	 * @param needCompress 是否压缩
	 * @throws Exception
	 */
	private static void insertImage(int size, BufferedImage source, String logoPath, boolean needCompress) throws Exception {
		int logoWidth = size / 5; //设置logo图片宽度为二维码图片的五分之一
		int logoHeight = size / 5; //设置logo图片高度为二维码图片的五分之一

		Image src = ImageIO.read(new URL(logoPath));
		int width = src.getWidth(null);
		int height = src.getHeight(null);
		if (needCompress) { // 压缩LOGO
			if (width > logoWidth) {
				width = logoWidth;
			}
			if (height > logoHeight) {
				height = logoHeight;
			}
			Image image = src.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics g = tag.getGraphics();
			g.drawImage(image, 0, 0, null); // 绘制缩小后的图
			g.dispose();
			src = image;
		}
		// 插入LOGO
		Graphics2D graph = source.createGraphics();
		int x = (size - width) / 2;
		int y = (size - height) / 2;
		graph.drawImage(src, x, y, width, height, null);
		Shape shape = new RoundRectangle2D.Float(x, y, width, width, 6, 6);
		graph.setStroke(new BasicStroke(3f));
		graph.draw(shape);
		graph.dispose();
	}

	/**
	 * 生成二维码(内嵌LOGO)
	 * 二维码文件名随机，文件名可能会有重复
	 *
	 * @param size         二维码尺寸
	 * @param content      内容
	 * @param logoPath     LOGO地址
	 * @param destPath     存放目录
	 * @param needCompress 是否压缩LOGO
	 * @throws Exception
	 */
	public static String encode(int size, String content, String logoPath, String destPath, boolean needCompress) throws Exception {
		BufferedImage image = QRCodeUtils.createImage(size, content, logoPath, needCompress);
		mkdirs(destPath);
		String fileName = new Random().nextInt(99999999) + "." + FORMAT.toLowerCase();
		ImageIO.write(image, FORMAT, new File(destPath + "/" + fileName));
		return fileName;
	}

	/**
	 * 生成二维码(内嵌LOGO)
	 * 调用者指定二维码文件名
	 *
	 * @param size         二维码尺寸
	 * @param content      内容
	 * @param logoPath     LOGO地址
	 * @param destPath     存放目录
	 * @param fileName     二维码文件名
	 * @param needCompress 是否压缩LOGO
	 * @throws Exception
	 */
	public static String encode(int size, String content, String logoPath, String destPath, String fileName, boolean needCompress) throws Exception {
		BufferedImage image = QRCodeUtils.createImage(size, content, logoPath, needCompress);
		mkdirs(destPath);
		fileName = fileName.substring(0, fileName.indexOf(".") > 0 ? fileName.indexOf(".") : fileName.length()) + "." + FORMAT.toLowerCase();
		ImageIO.write(image, FORMAT, new File(destPath + "/" + fileName));
		return fileName;
	}

	/**
	 * 当文件夹不存在时，mkdirs会自动创建多层目录，区别于mkdir．
	 * (mkdir如果父目录不存在则会抛出异常)
	 *
	 * @param destPath 存放目录
	 */
	public static void mkdirs(String destPath) {
		File file = new File(destPath);
		if (!file.exists() && !file.isDirectory()) {
			file.mkdirs();
		}
	}

	/**
	 * 生成二维码(内嵌LOGO)
	 *
	 * @param size     二维码尺寸
	 * @param content  内容
	 * @param logoPath LOGO地址
	 * @param destPath 存储地址
	 * @throws Exception
	 */
	public static String encode(int size, String content, String logoPath, String destPath) throws Exception {
		return QRCodeUtils.encode(size, content, logoPath, destPath, false);
	}

	/**
	 * 生成二维码
	 *
	 * @param size         二维码尺寸
	 * @param content      内容
	 * @param destPath     存储地址
	 * @param needCompress 是否压缩LOGO
	 * @throws Exception
	 */
	public static String encode(int size, String content, String destPath, boolean needCompress) throws Exception {
		return QRCodeUtils.encode(size, content, null, destPath, needCompress);
	}

	/**
	 * 生成二维码
	 *
	 * @param size     二维码尺寸
	 * @param content  内容
	 * @param destPath 存储地址
	 * @throws Exception
	 */
	public static String encode(int size, String content, String destPath) throws Exception {
		return QRCodeUtils.encode(size, content, null, destPath, false);
	}

	/**
	 * 生成二维码(内嵌LOGO)
	 *
	 * @param size         二维码尺寸
	 * @param content      内容
	 * @param logoPath     LOGO地址
	 * @param output       输出流
	 * @param needCompress 是否压缩LOGO
	 * @throws Exception
	 */
	public static void encode(int size, String content, String logoPath, OutputStream output, boolean needCompress) throws Exception {
		BufferedImage image = QRCodeUtils.createImage(size, content, logoPath, needCompress);
		ImageIO.write(image, FORMAT, output);
	}

	/**
	 * 生成二维码
	 *
	 * @param size    二维码尺寸
	 * @param content 内容
	 * @param output  输出流
	 * @throws Exception
	 */
	public static void encode(int size, String content, OutputStream output) throws Exception {
		QRCodeUtils.encode(size, content, null, output, false);
	}

	/**
	 * 生成二维码（字节码）
	 *
	 * @param size
	 * @param content
	 * @param logPath
	 * @return
	 */
	public static byte[] encodeBytes(int size, String content, String logPath) {
		try {
			BufferedImage image = createImage(size, content, logPath, true);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			ImageIO.write(image, FORMAT, out);
			return out.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 解析二维码
	 *
	 * @param file 二维码图片
	 * @return
	 * @throws Exception
	 */
	public static String decode(File file) throws Exception {
		BufferedImage image;
		image = ImageIO.read(file);
		if (image == null) {
			return null;
		}
		BufferedImageLuminanceSource source = new BufferedImageLuminanceSource(image);
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
		Result result;
		Hashtable<DecodeHintType, Object> hints = new Hashtable<DecodeHintType, Object>();
		hints.put(DecodeHintType.CHARACTER_SET, CHARSET);
		result = new MultiFormatReader().decode(bitmap, hints);
		String resultStr = result.getText();
		return resultStr;
	}

	/**
	 * 解析二维码
	 *
	 * @param path 二维码图片地址
	 * @return
	 * @throws Exception
	 */
	public static String decode(String path) throws Exception {
		return QRCodeUtils.decode(new File(path));
	}

	public static void main(String[] args) throws Exception {
		String text = "http://www.baidu.com";
		//不含Logo
		//QRCodeUtil.encode(text, null, "e:\\", true);
		//含Logo，不指定二维码图片名
		//QRCodeUtil.encode(text, "e:\\csdn.jpg", "e:\\", true);
		//含Logo，指定二维码图片名
		QRCodeUtils.encode(300, text, "e:\\csdn.jpg", "e:\\", "qrcode", true);
	}
}
