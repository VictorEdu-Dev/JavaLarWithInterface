package panels;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PSystem extends JPanel {
	private static final int width = 1000;
	private static final int heigth = 708;
	
	public PSystem() {
		setLayout(null);
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		setBackground(Color.decode("#FFE4B5"));
		setPreferredSize(new Dimension(width, heigth));
	}
}
