package essentials.frameworks.game;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.DataBufferInt;

import javax.swing.JProgressBar;

import essentials.tools.containers.graphics.images.BufferedImage;
import essentials.tools.containers.orginal.Frame;

public abstract class GameBase extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum GameState {
		playing
	}

	protected GameState gameState = GameState.playing;
	protected static JProgressBar loadingBar;

	protected Frame frame;
	protected int width = 300, height = width / 16 * 9, scale = 2;
	protected Dimension size;
	protected String title;

	protected Thread thread;
	protected boolean running;

	protected int ups;

	protected BufferedImage image;
	protected int[] pixels;
	
	protected abstract void load();

	protected void construct(int width, int height, int scale) {
		this.width = width;
		this.height = height;
		this.scale = scale;

		frame = new Frame();
		size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		setSize(getPreferredSize());

		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	}

	public abstract void start();

	public abstract void stop();

	public abstract void update();

	public abstract void render();

}
