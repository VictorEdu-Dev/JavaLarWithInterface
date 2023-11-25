package panels.planets;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import util.Coordinates;

@SuppressWarnings("serial")
public class LMeteor extends JLabel {
	private String nome;
	private String tipo;
	private Coordinates coord;

	public LMeteor(String imageUrl, int x, int y) {
		this.nome = imageUrl;
		this.tipo = "METEORO";
		coord = new Coordinates(x, y);
		adjustPlanet(imageUrl);
	}

	public void adjustPlanet(String imageUrl) {
		setSize(35, 35);
		setAlignmentX(CENTER_ALIGNMENT);
		setAlignmentY(CENTER_ALIGNMENT);

		ImageIcon icon = imageProcess("view/panels/planets/"+ imageUrl +".png", 
				getWidth(), getHeight());
		
		setIcon(icon);
	}

	public static ImageIcon imageProcess(String url, int width, int height) {
		ImageIcon icon = new ImageIcon(url);
		Image resizedImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(resizedImage);
		return resizedIcon;
	}
	
	public String getNome() {
		return nome;
	}

	public String getTipo() {
		return tipo;
	}
	
	public int getPosX() {
		return coord.getX();
	}

	public int getPosY() {
		return coord.getY();
	}

	public void setX(int x) {
		this.coord.setX(x);;
	}

	public void setY(int y) {
		this.coord.setY(y);
	}
}


