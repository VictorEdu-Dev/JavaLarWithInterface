package panels.planets;

public enum MeteorConstants {
	BUG("bug"),
	DEV("dev");

	private String imageURL;
	
	MeteorConstants(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getImageURL() {
		return imageURL;
	}
}
