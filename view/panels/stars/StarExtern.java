package panels.stars;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import panels.PSystem;

@SuppressWarnings("serial")
public class StarExtern extends JLabel {
	private int positionX;
	private int positionY;

	public StarExtern(int positionX, int positionY, String type) {
		setSize(40, 40);
		setLocation(positionX, positionY);
		setHorizontalAlignment(SwingConstants.CENTER);
		setVerticalAlignment(SwingConstants.CENTER);
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

		ImageIcon icon = PSystem.imageProcess("view/panels/planets/"+ type +".png", 
				getWidth(), getHeight());

		setIcon(icon);
	}


	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

}


