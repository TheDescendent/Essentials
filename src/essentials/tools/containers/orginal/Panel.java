package essentials.tools.containers.orginal;

import java.awt.Graphics;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import essentials.tools.containers.graphics.images.BufferedImage;
import essentials.tools.helpers.dimensions.Aspect;

public class Panel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Graphics g;
	private BufferedImage background, Foreground;

	/*****************************************************************
	 * 
	 * GUI rendering
	 * 
	 *****************************************************************/
	public void assignGraphics(Graphics g) {
		this.g = g;
	}

	public Graphics getAssignGraphics() {
		return g;
	}

	public void render() {
		if (background != null) renderBackground();
		if (Foreground != null) renderForeground();
	}

	private void renderBackground() {
		g.drawImage(background, 0, 0, background.getWidth(), background.getHeight(), null);
	}

	private void renderForeground() {
		g.drawImage(background, 0, 0, background.getWidth(), background.getHeight(), null);
	}

	public void setBackground(int color, Aspect size) {
		if (size != null) background = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_RGB);
		else background = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		for (int i = 0; i < background.getArray().length; i++)
			background.getArray()[i] = color;
		background.setRGB(background.getWidth(), background.getHeight(), background.getArray());

	}

	public void setBackground(Class<?> main, String path) {
		try {
			background = BufferedImage.castAwtBufferedImage(ImageIO.read(main.getResource(path)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
