package com.funtl.framework.core.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 条形码工具类
 * Created by 李卫民 on 2016/8/24.
 */
public class BarCodeUtils {
    private static final String FORMAT = "JPG";

    /**
     * 条形码编码
     */
    public static BufferedImage encode(String contents, int width, int height) {
        int codeWidth = 3 + // start guard
                (7 * 6) + // left bars
                5 + // middle guard
                (7 * 6) + // right bars
                3; // end guard
        codeWidth = Math.max(codeWidth, width);
        try {
            // 原为13位Long型数字（BarcodeFormat.EAN_13），现为128位
            BitMatrix bitMatrix = new MultiFormatWriter().encode(contents, BarcodeFormat.CODE_128, codeWidth, height, null);
            return MatrixToImageWriter.toBufferedImage(bitMatrix);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 条形码编码（字节码）
     */
    public static byte[] encodeBytes(String content, int width, int height) {
        try {
            BufferedImage image = encode(content, width, height);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ImageIO.write(image, FORMAT, out);
            return out.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 条形码解码
     */
    public static String decode(BufferedImage image) {
        Result result = null;
        try {
            if (image == null) {
                System.out.println("the decode image may be not exit.");
            }
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            result = new MultiFormatReader().decode(bitmap, null);
            return result.getText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
