package ch.swiggels.weddingApp;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnailator;

public class ImageConverter {
	public static void makeThumbs() throws IOException {
		List<File> filesInFolder = Files.walk(Paths.get("src/main/resources/static/assets/data_images/"))
				.filter(Files::isRegularFile).filter(p -> p.getFileName().toString().endsWith(".jpg"))
				.filter(p -> !p.getFileName().toString().startsWith("t_")).map(Path::toFile).collect(Collectors.toList());
		for (File file : filesInFolder) {
			File smallFile = new File("src/main/resources/static/assets/data_images/resized/" + file.getName());
			BufferedImage smallThumb = Thumbnailator.createThumbnail(file, 800, 685);
			ImageIO.write(smallThumb, "jpg", smallFile);
			File thumbFile = new File("src/main/resources/static/assets/data_images/thumbs/t_" + file.getName());
			BufferedImage thumb = Thumbnailator.createThumbnail(file, 75, 50);
			ImageIO.write(thumb, "jpg", thumbFile);
		}

	}

	public static void renameFiles() throws IOException {
		List<File> filesInFolder = Files.walk(Paths.get("src/main/resources/static/assets/data_images/resized"))
				.filter(Files::isRegularFile).filter(p -> p.getFileName().toString().endsWith(".jpg"))
				.filter(p -> !p.getFileName().toString().startsWith("t_")).map(Path::toFile).filter(p -> p.getName().length() > 8)
				.collect(Collectors.toList());
		for (File file : filesInFolder) {
			String origFileName = file.getName();
			String fileName = origFileName.substring(12, 16);
			file.renameTo(new File("src/main/resources/static/assets/data_images/resized/" + fileName + ".jpg"));
		}

	}

	public static void renameThumbs() throws IOException {
		List<File> filesInFolder = Files.walk(Paths.get("src/main/resources/static/assets/data_images/thumbs"))
				.filter(Files::isRegularFile).filter(p -> p.getFileName().toString().endsWith(".jpg"))
				.filter(p -> p.getFileName().toString().startsWith("t_")).map(Path::toFile).filter(p -> p.getName().length() > 8)
				.collect(Collectors.toList());
		for (File file : filesInFolder) {
			String origFileName = file.getName();
			String fileName = origFileName.substring(14, 18);
			file.renameTo(new File("src/main/resources/static/assets/data_images/thumbs/t_" + fileName + ".jpg"));
		}

	}

	public static void addtThumbs() throws IOException {
		List<File> filesInFolder = Files.walk(Paths.get("src/main/resources/static/assets/data_images/thumbs"))
				.filter(Files::isRegularFile).filter(p -> p.getFileName().toString().endsWith(".jpg"))
				.filter(p -> !p.getFileName().toString().startsWith("t_")).map(Path::toFile).collect(Collectors.toList());
		for (File file : filesInFolder) {
			file.renameTo(new File("src/main/resources/static/assets/data_images/thumbs/t_" + file.getName()));
		}

	}
}
