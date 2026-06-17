package com.productsservice.microservice.utils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.multipart.MultipartFile;

public class FilesUtils {

	public static String saveFile(String fileName, MultipartFile file) throws Exception {

		Path uploadPath = Paths.get("uploads/product-images");

		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}

		String fileCode = RandomStringUtils.randomAlphanumeric(8);

		Path filePath = uploadPath.resolve(fileCode + "_" + fileName);

		Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

		return fileCode + "_" + fileName;
	}
}
