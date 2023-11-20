package panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import panels.planets.LPlanet;
import panels.planets.PCellGrid;

@SuppressWarnings("serial")
public class PSystem extends JPanel {
	private static final int width = 708;
	private static final int height = 708;

	private ArrayList<JLabel> dataMatrix;
	private ArrayList<JLabel> dataBug;
	private ArrayList<JLabel> dataDev;
	private PCellGrid[][] panels;
	private Image image;

	public PSystem() {
		iniatilizeSystem();
	}

	// Inicializa o painel
	private void iniatilizeSystem() {
		configurePanel();
		adjustPlanets();
		addPlanets();
	}

	private void configurePanel() {
		setLayout(new GridLayout(15, 15));
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 5, true));
		setBackground(Color.decode("#FFE4B5"));
		setPreferredSize(new Dimension(width, height));
		image = Toolkit.getDefaultToolkit().getImage(
				"C:\\Central de Desenvolvimento\\Java\\"
				+ "Desktop\\Workspace\\JavaLarSystemInterface\\"
				+ "Arquivos\\frame\\javaLar.png"
				);
		revalidate();
		repaint();
	}

	// Adiciona planetas ao painel
	private void addPlanets() {
		/*
		 * Cada entidade é adicionada a um 
		 * vetor que representa um plano x, 
		 * y bidimensional. Na ordem em que
		 * existem na lista, são adicioandas
		 * ao painel pelo seu índice corres-
		 * pondente.
		 * */
		panels = PCellGrid.createGrid(this);
		
		panels[8][8].add(dataMatrix.get(0));
		panels[7][8].add(dataMatrix.get(1));
		panels[6][8].add(dataMatrix.get(2));
		panels[5][8].add(dataMatrix.get(3));
		panels[4][8].add(dataMatrix.get(4));
		panels[3][8].add(dataMatrix.get(5));
		panels[2][8].add(dataMatrix.get(6));
		panels[1][8].add(dataMatrix.get(7));
	}

	// Chame métodos que criam planetas
	private void adjustPlanets() {
		dataMatrix = new ArrayList<>();
		
		dataMatrix.add(new LPlanet("java"));
		dataMatrix.add(new LPlanet("python"));
		dataMatrix.add(new LPlanet("javaScript"));
		dataMatrix.add(new LPlanet("ruby"));
		dataMatrix.add(new LPlanet("php"));
		dataMatrix.add(new LPlanet("cSharp"));
		dataMatrix.add(new LPlanet("cPlusPlus"));
		dataMatrix.add(new LPlanet("cLanguage"));
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (image != null) {
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
	}

	// Getters para acesso posterior
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public JPanel[][] getPanels() {
		return panels;
	}
	
	public void setPanels(JLabel label, int x, int y) {
		this.panels[x][y].add(label);
	}

	public ArrayList<JLabel> getDataMatrix() {
		return dataMatrix;
	}

	public ArrayList<JLabel> getDataBug() {
		return dataBug;
	}

	public ArrayList<JLabel> getDataDev() {
		return dataDev;
	}
}
