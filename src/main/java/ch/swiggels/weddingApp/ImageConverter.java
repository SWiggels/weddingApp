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
}
