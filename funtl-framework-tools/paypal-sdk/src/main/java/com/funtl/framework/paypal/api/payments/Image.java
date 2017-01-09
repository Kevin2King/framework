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

package com.funtl.framework.paypal.api.payments;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.funtl.framework.paypal.base.rest.PayPalModel;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Image extends PayPalModel {

	/**
	 * Image as base64 encoded String
	 */
	private String image;

	/**
	 * Default Constructor
	 */
	public Image() {
	}

	/**
	 * Saves the image to a file.
	 *
	 * @param fileName filename ending with .png
	 * @return boolean true if write successful. false, otherwise.
	 * @throws IOException
	 */
	public boolean saveToFile(String fileName) throws IOException {
		byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(this.image);
		BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageBytes));
		return ImageIO.write(img, "png", new File(fileName));
	}
}
