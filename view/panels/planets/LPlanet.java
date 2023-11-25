package panels.planets;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class LPlanet extends JLabel {
	private String nome;
	private String tipo;
	
	public LPlanet(String imageUrl) {
		this.nome = imageUrl;
		this.tipo = "PLANETA";
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

	// Caracteriza o ícone do planeta
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

}
