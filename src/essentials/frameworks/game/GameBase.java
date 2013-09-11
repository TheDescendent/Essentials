package essentials.frameworks.game;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.DataBufferInt;

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

	public abstract void update();

	public abstract void render();

	public abstract void start();

	public abstract void stop();

	public void startGameThread(Runnable target, String name) {
		running = true;
		if (name == null) thread = new Thread(target, "Display");
		else thread = new Thread(target, name);
		thread.start();
	}

	public void stopGameThread() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void running() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / ups;
		double delta = 0;
		int frames = 0, updates = 0;

		requestFocus();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frame.setTitle(title + " | fps: " + frames + ", ups: " + updates);
				frames = 0;
				updates = 0;
			}
		}

	}

}
