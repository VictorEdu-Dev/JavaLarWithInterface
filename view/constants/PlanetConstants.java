package constants;

public enum PlanetConstants {
	JAVA("Java"),
	PYTHON("Python"),
	JAVASCRIPT("JavaScript"),
	PHP("PHP"),
	RUBY("Ruby on Rails"),
	CPLUSPLUS("c++"),
	CSHARP("C#"),
	C("C");

	private String imageURL;
	
	PlanetConstants(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getImageURL() {
		return imageURL;
	}
}
