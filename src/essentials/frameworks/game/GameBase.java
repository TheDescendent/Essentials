package essentials.frameworks.game;

import java.awt.Dimension;
import java.awt.image.DataBufferInt;

import essentials.tools.containers.Frame;
import essentials.tools.containers.graphics.images.BufferedImage;

public abstract class GameBase implements Runnable {

	protected Frame frame;
	protected int width, height, scale;
	protected Dimension size;
	protected String title;

	protected Thread thread;
	protected boolean running;

	protected int ups;

	protected BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	protected int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

	public abstract void start();

	public abstract void stop();

	public abstract void update();

	public abstract void render();
}
