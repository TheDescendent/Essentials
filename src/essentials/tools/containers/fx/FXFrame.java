package essentials.tools.containers.fx;

import java.awt.HeadlessException;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;

import javax.swing.JFrame;

public class FXFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean fxPanelInit = false;
	private Group root;
	private Scene scene;

	public FXFrame() throws HeadlessException {
		super();
		frameInit();
	}

	public void initAndShow(final JFXPanel fxPanel, int width, int height) {
		// This method is invoked on the EDT thread
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width, height);
		setLocationRelativeTo(null);
		setVisible(true);

		add(fxPanel);
		Platform.runLater(new Runnable() {
			public void run() {
				scene = createScene();
				fxPanel.setScene(scene);
			}
		});
		fxPanelInit = true;

	}

	public void initAndShow(final JFXPanel fxPanel) {
		// This method is invoked on the EDT thread
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

		add(fxPanel);

		Platform.runLater(new Runnable() {
			public void run() {
				scene = createScene();
				fxPanel.setScene(scene);
			}
		});
		fxPanelInit = true;
	}
	
	public void addMenuBar(MenuBar mb) {
		root.getChildren().addAll(mb);
	}
	
	public void addNode(Node node) {
		getGroup().getChildren().add(node);
	}

	private Scene createScene() {
		root = new Group();
		Scene scene = new Scene(root);
		return scene;
	}

	public boolean isFxPanelInit() {
		return fxPanelInit;
	}

	public Scene getScene() {
		return scene;
	}
	
	public Group getGroup() {
		return root;
	}

}
