package essentials.frameworks.game.tools;

import java.awt.Dimension;

public class Sprite {

	private int[] pixels;
	private final int width, height;
	private int x, y;

	private Dimension size;

	private SpriteSheet sheet;

	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		height = width = size;
		this.sheet = sheet;
		this.x = x * width;
		this.y = y * height;

		this.size = new Dimension(width, height);
		pixels = new int[width * height];
		load();
	}

	public Sprite(int width, int height, int color) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		size = new Dimension(width, height);
		setColor(color);
	}

	private void load() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				pixels[x + y * width] = sheet.getPixels()[(x + this.x) + (y + this.y) * sheet.getSize().width];
			}
		}
	}

	public void setColor(int color) {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = color;
		}
	}

	public Dimension getSize() {
		return size;
	}

	public int[] getPixels() {
		return pixels;
	}
}
