package panels.planets;

@SuppressWarnings("serial")
public class LMeteor extends LPlanet {
	private int x;
	private int y;

	public LMeteor(String imageUrl, int x, int y) {
		super(imageUrl);
		this.x = x;
		this.y = y;
	}

	public int getPosX() {
		return x;
	}

	public int getPosY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

}


