package essentials.tools.containers.graphics.images;

import java.awt.image.ColorModel;
import java.awt.image.IndexColorModel;
import java.awt.image.WritableRaster;
import java.util.Hashtable;

import essentials.frameworks.game.tools.Sprite;

public class BufferedImage extends java.awt.image.BufferedImage {

	private int[] rgb;

	public BufferedImage(ColorModel cm, WritableRaster raster, boolean isRasterPremultiplied, Hashtable<?, ?> properties) {
		super(cm, raster, isRasterPremultiplied, properties);
		// TODO Auto-generated constructor stub
	}

	public BufferedImage(int width, int height, int imageType) {
		super(width, height, imageType);
		// TODO Auto-generated constructor stub
	}

	public BufferedImage(int width, int height, int imageType, IndexColorModel cm) {
		super(width, height, imageType, cm);
		// TODO Auto-generated constructor stub
	}

	public static java.awt.image.BufferedImage castToAwtBufferedImage(BufferedImage image) {
		java.awt.image.BufferedImage img = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
		int[] RGB = new int[image.getWidth() * image.getHeight()];
		image.getRGB(0, 0, image.getWidth(), image.getHeight(), RGB, 0, image.getWidth());
		img.setRGB(0, 0, image.getWidth(), image.getHeight(), RGB, 0, image.getWidth());
		return img;
	}

	public static BufferedImage castAwtBufferedImage(java.awt.image.BufferedImage image) {
		BufferedImage img = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
		int[] RGB = new int[image.getWidth() * image.getHeight()];
		image.getRGB(0, 0, image.getWidth(), image.getHeight(), RGB, 0, image.getWidth());
		img.setRGB(0, 0, image.getWidth(), image.getHeight(), RGB, 0, image.getWidth());
		return img;
	}

	public static BufferedImage castSprite(Sprite sprite) {
		BufferedImage img = new BufferedImage(sprite.getSize().width, sprite.getSize().height, BufferedImage.TYPE_INT_RGB);
		int[] RGB = new int[sprite.getSize().width * sprite.getSize().height];
		for (int pixel : sprite.getPixels())
			RGB[pixel] = sprite.getPixels()[pixel];
		img.setRGB(img.getWidth(), img.getHeight(), RGB);
		return img;
	}

	public void setRGB(int w, int h, int[] rgb) {
		setRGB(0, 0, w, h, rgb, 0, w);
	}

	public int[] getArray() {
		return rgb;
	}

}
