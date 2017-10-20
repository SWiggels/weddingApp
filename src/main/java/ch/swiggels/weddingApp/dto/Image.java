package ch.swiggels.weddingApp.dto;

import lombok.Data;

@Data
public class Image {
	public String thumbs = new String();
	public String images = new String();

	public Image() {
		//		addPhoto("image 1", "Image alt 1", "pic1.jpg");
		//		addPhoto("image 2", "Image alt 1", "4432.jpg");
		//		addPhoto("image 3", "Image alt 1", "4934.jpg");
		//		addPhoto("image 4", "Image alt 1", "5042.jpg");
		//		addPhoto("image 5", "Image alt 1", "5395.jpg");
		addPhoto("5395.jpg");
		addPhoto("4432.jpg");
		addPhoto("4934.jpg");
		addPhoto("5042.jpg");
		addPhoto("4444.jpg");

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
