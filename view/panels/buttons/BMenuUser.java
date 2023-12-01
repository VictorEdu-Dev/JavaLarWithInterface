package panels.buttons;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class BMenuUser extends JButton {
	private String id;
	
	public BMenuUser(String text) {
		adjustButton(text);
	}
	
	public BMenuUser(String text, String color) {
		adjustButton(text);
		setBackground(Color.decode(color));
	}

	private void adjustButton(String text) {
		setText(text);
		setFont(new Font("Arial", Font.BOLD, 14));
		setForeground(Color.BLACK);
		setBackground(Color.decode("#BED9FF"));	
	}

	public String getId() {
		return id;
	}
}
