package panels.planets;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PCellGrid extends JPanel {
	private float opacity;
	private static final int rows = 16;
	private static final int columns = 16;

	public PCellGrid() {
		adjustCell();
	}

	private void adjustCell() {
		setOpaque(true);
		setBackground(Color.BLACK);
		setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
		setOpacity(0.7f);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();

		AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity);
		g2d.setComposite(alphaComposite);

		super.paintComponent(g2d);

		g2d.dispose();
	}

	public static PCellGrid[][] createGrid(JComponent comp) {
		PCellGrid[][] panels = new PCellGrid[rows][columns];
		for (int i = 1; i < rows; i++) {
			for(int j = 1; j < columns; j++) {
				panels[i][j] = new PCellGrid();
				comp.add(panels[i][j]);
			}
		}

		return panels;
	}

	public static int getRows() {
		return rows;
	}

	public static int getColumns() {
		return columns;
	}

	public float getOpacity() {
		return opacity;
	}

	public void setOpacity(float opacity) {
		this.opacity = opacity;
	}

}
