package essentials.tools.containers.fx;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class FXPanel extends JFXPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Group root;
	private Scene scene;

	public void initFX(JFXPanel fxPanel) {
		// This method is invoked on the JavaFX thread
		scene = createScene();
		fxPanel.setScene(scene);
	}

	private Scene createScene() {
		root = new Group();
		Scene scene = new Scene(root, Color.ALICEBLUE);
		return scene;
	}

}
