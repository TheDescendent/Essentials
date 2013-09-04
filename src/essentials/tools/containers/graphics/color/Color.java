package essentials.tools.containers.graphics.color;

import java.awt.color.ColorSpace;

public class Color extends java.awt.Color {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Color(ColorSpace cspace, float[] components, float alpha) {
		super(cspace, components, alpha);
		// TODO Auto-generated constructor stub
	}

	public Color(float r, float g, float b) {
		super(r, g, b);
		// TODO Auto-generated constructor stub
	}

	public Color(float r, float g, float b, float a) {
		super(r, g, b, a);
		// TODO Auto-generated constructor stub
	}

	public Color(int rgb) {
		super(rgb);
		// TODO Auto-generated constructor stub
	}

	public Color(int rgba, boolean hasalpha) {
		super(rgba, hasalpha);
		// TODO Auto-generated constructor stub
	}

	public Color(int r, int g, int b) {
		super(r, g, b);
		// TODO Auto-generated constructor stub
	}

	public Color(int r, int g, int b, int a) {
		super(r, g, b, a);
		// TODO Auto-generated constructor stub
	}

	public static int toHex(java.awt.Color color) {
		String red = Integer.toHexString(color.getRed());
		String green = Integer.toHexString(color.getGreen());
		String blue = Integer.toHexString(color.getBlue());

		@SuppressWarnings("unused")
		String alpha = Integer.toHexString(color.getAlpha());

		if (red.length() < 2) red += "0";
		if (green.length() < 2) green += "0";
		if (blue.length() < 2) blue += "0";

		return Integer.parseInt(red + green + blue, 16);
	}

	public static java.awt.Color toAwtColor(Color gray) {
		return new java.awt.Color(gray.getRed(), gray.getGreen(), gray.getBlue());
	}
}
