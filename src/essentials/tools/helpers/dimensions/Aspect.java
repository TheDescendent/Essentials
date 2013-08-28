package essentials.tools.helpers.dimensions;

import essentials.tools.workers.math.formulas.Euclidean;

public class Aspect {

	public enum RatioType {
		DEFUALT(5, 4, false), SQUARE(1, 1, false), WIDE(16, 9, false), PHONE(9, 16, false), CUSTOM(-1, -1, true);

		private int aspect1, aspect2;
		private final boolean custom;

		RatioType(int aspect1, int aspect2, boolean bool) {
			this.aspect1 = aspect1;
			this.aspect2 = aspect2;
			custom = bool;
		}

		void setRatio(int aspect1, int aspect2) {
			if (custom) {
				this.aspect1 = aspect1;
				this.aspect2 = aspect2;

			}
		}

		int getAspect1() {
			return aspect1;
		}

		int getAspect2() {
			return aspect2;
		}

	}

	private RatioType ratio;
	public int width, height;

	public Aspect() {
		width = height = -1;
	}

	public Aspect(int width, int height) {
		this.width = width;
		this.height = height;

		ratio = RatioType.CUSTOM;
		ratio.setRatio(width * Euclidean.gcd(width, height), height * Euclidean.gcd(width, height));
		updateAspect(ratio.getAspect1(), ratio.getAspect2());

	}

	public Aspect(int width, int height, RatioType ratioType) {
		this.width = width;
		this.height = height;

		ratio = ratioType;
		updateAspect(ratio.getAspect1(), ratio.getAspect2());

	}

	public void setRatioType(RatioType ratio) {
		this.ratio = ratio;
		updateAspect(ratio.getAspect1(), ratio.getAspect2());
	}

	public void setCustomRatio(int aspect1, int aspect2) {
		ratio.setRatio(aspect1, aspect2);
		updateAspect(ratio.getAspect1(), ratio.getAspect2());
	}

	private void updateAspect(int ratioAspect1, int ratioAspect2) {
		if (width <= 0 && height > 0) height = width / ratioAspect1 * ratioAspect2;
		if (height <= 0 && width > 0) width = height * ratioAspect2 / ratioAspect1;
	}

}
