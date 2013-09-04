package essentials.tools.helpers.shapes;

import java.awt.Color;

import essentials.tools.helpers.dimensions.Aspect;
import essentials.tools.helpers.vectors.Vector3D;

public class Rectangle {

	private String id;
	private Aspect size;
	private Vector3D location;
	private int speed;
	private Color color;

	private void init() {
		id = "Rectangle";
		size = new Aspect();
		location = new Vector3D();
	}

	public Rectangle() {
		init();
	}

	public Rectangle(String id) {
		init();
		this.id = id;
	}

	public Rectangle(int width, int height) {
		init();
		size.width = width;
		size.height = height;
	}

	public Rectangle(String id, int width, int height) {
		init();
		this.id = id;
		size.width = width;
		size.height = height;
	}

	public Vector3D getLocation() {
		return location;
	}

	public Aspect getSize() {
		return size;
	}

	public String getId() {
		return id;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
