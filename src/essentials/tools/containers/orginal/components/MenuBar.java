package essentials.tools.containers.orginal.components;

import java.awt.Graphics;
import java.util.ArrayList;

import essentials.frameworks.game.tools.Sprite;
import essentials.frameworks.game.tools.SpriteSheet;
import essentials.tools.containers.graphics.images.BufferedImage;

public class MenuBar {

	public enum Skin {
		skin1("res//MenuBarSkin1.png"), skin2(""), skin3(""), skin4(""), skin5(""), skin6(""), skin7(""), skin("", true);

		String path;
		boolean custom;
		ArrayList<BufferedImage> tabs = new ArrayList<BufferedImage>();

		Skin(String skinPath) {
			path = skinPath;
			SpriteSheet sheet = new SpriteSheet(skinPath, 120, 24);
			tabs.add(BufferedImage.castSprite(new Sprite(0, 0, 24, sheet)));
			tabs.add(BufferedImage.castSprite(new Sprite(1, 0, 24, sheet)));
			tabs.add(BufferedImage.castSprite(new Sprite(2, 0, 24, sheet)));
		}

		Skin(String skinPath, boolean custom) {
			path = skinPath;
			this.custom = custom;
		}

		void setPath(String path) {
			if (custom) this.path = path;
		}

		ArrayList<BufferedImage> getTabs() {
			return tabs;
		}

	}

	private Skin skin;

	public MenuBar() {
		skin = Skin.skin1;
	}

	public MenuBar(Skin skin) {
		this.skin = skin;
	}

	public void setSkin(Skin skin) {
		this.skin = skin;
	}

	public Skin getSkin() {
		return skin;
	}
}
