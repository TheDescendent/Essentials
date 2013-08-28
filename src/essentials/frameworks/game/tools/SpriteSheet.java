package essentials.frameworks.game.tools;


import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	private int[] pixels;
	private final int width, height;
	private String path;

	private Dimension size;

	public SpriteSheet(String path, int size) {
		width = height = size;
		this.path = path;
		pixels = new int[width * height];

		this.size = new Dimension(width, height);
		load();
	}

	public SpriteSheet(String path, int width, int height) {
		this.width = width;
		this.height = height;
		this.path = path;
		pixels = new int[width * height];

		size = new Dimension(width, height);

		load();
	}

	private void load() {
		try {
			BufferedImage img = ImageIO.read(SpriteSheet.class.getResource(path));
			img.getRGB(0, 0, img.getWidth(), img.getHeight(), pixels, 0, img.getWidth());
		} catch (IOException e) {
		}
	}

	public int[] getPixels() {
		return pixels;
	}

	public Dimension getSize() {
		return size;
	}
}
