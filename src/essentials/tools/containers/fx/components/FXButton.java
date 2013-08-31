package essentials.tools.containers.fx.components;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;

public class FXButton extends Button {

	public FXButton() {
		super();
	}

	public void setSize(int width, int height) {
		setMinSize(width, height);
	}

	public void setLocation(int x, int y) {
		setLayoutX(x);
		setLayoutY(y);
	}

	public void addShadow(final DropShadow shadow) {
		addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				setEffect(shadow);
			}
		});
		addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				setEffect(null);
			}
		});
	}

}
