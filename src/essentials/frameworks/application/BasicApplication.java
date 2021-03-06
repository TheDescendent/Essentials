package essentials.frameworks.application;

import essentials.tools.containers.orginal.Frame;
import essentials.tools.containers.orginal.Panel;
import essentials.tools.containers.orginal.components.MenuBar;

public class BasicApplication {

	protected Frame frame;
	protected Panel panel;
	protected int width, height;

	protected MenuBar menubar;

	protected void init(int width, int height) {
		frame = new Frame();
		panel = new Panel();
		this.width = width;
		this.height = height;
	}

	protected void addMenu() {
		menubar = new MenuBar(MenuBar.Skin.skin1);
		//frame.add(menubar);
	}

}
