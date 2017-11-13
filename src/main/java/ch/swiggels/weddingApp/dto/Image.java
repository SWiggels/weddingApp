package ch.swiggels.weddingApp.dto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import lombok.Data;

@Data
public class Image {

	private String thumbs = new String();
	private String images = new String();

	public Image() throws IOException {
		Files.walk(Paths.get("src/main/resources/static/assets/data_images/resized")).filter(Files::isRegularFile)
				.filter(p -> p.getFileName().toString().endsWith(".jpg"))
				.filter(p -> !p.getFileName().toString().startsWith("t_")).map(Path::toFile).collect(Collectors.toList())
				.forEach(p -> this.addPhoto(p.getName()));
		;
		//collect.forEach(p -> this.addPhoto(p.getName()));
		//		addPhoto("image 1", "Image alt 1", "pic1.jpg");
		//		addPhoto("4444.jpg");
		System.out.println("done");

	}

	public void addPhoto(String name) {
		String title = "";
		String alt = "";
		StringBuilder thumb = new StringBuilder("<li><a href=\"#\" rel=\"nofollow\" title=\"" + title
				+ "\"><img src=\"assets/data_images/thumbs/t_" + name + "\" alt=\"" + alt + "\" /></a></li>");
		StringBuilder image = new StringBuilder("<div class=\"sliderkit-panel\">\r\n    <img src=\"assets/data_images/resized/"
				+ name + "\" alt=\"" + alt
				+ "\" />\r\n    <div class=\"sliderkit-panel-textbox\">\r\n        <div class=\"sliderkit-panel-text\">\r\n            <h4>"
				+ alt + "</h4>\r\n            <p>" + alt
				+ "</p>\r\n        </div>\r\n        <div class=\"sliderkit-panel-overlay\"></div>\r\n    </div>\r\n</div>");
		this.thumbs = this.thumbs + thumb.toString();
		this.images = this.images + image.toString();

	}

	public void addPhoto(String title, String alt, String name) {
		StringBuilder thumb = new StringBuilder("<li><a href=\"#\" rel=\"nofollow\" title=\"" + title
				+ "\"><img src=\"assets/data_images/thumbs/t_" + name + "\" alt=\"" + alt + "\" /></a></li>");
		StringBuilder image = new StringBuilder("<div class=\"sliderkit-panel\">\r\n    <img src=\"assets/data_images/resized/"
				+ name + "\" alt=\"" + alt
				+ "\" />\r\n    <div class=\"sliderkit-panel-textbox\">\r\n        <div class=\"sliderkit-panel-text\">\r\n            <h4>"
				+ alt + "</h4>\r\n            <p>" + alt
				+ "</p>\r\n        </div>\r\n        <div class=\"sliderkit-panel-overlay\"></div>\r\n    </div>\r\n</div>");
		this.thumbs = this.thumbs + thumb.toString();
		this.images = this.images + image.toString();

	}

}
