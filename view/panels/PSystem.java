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

import panels.planets.LMeteor;
import panels.planets.LPlanet;
import panels.planets.PCellGrid;

@SuppressWarnings("serial")
public class PSystem extends JPanel {
	private static final int width = 708;
	private static final int height = 708;

	private ArrayList<JLabel> dataMatrix;
	private ArrayList<LMeteor> dataBug;
	private ArrayList<LMeteor> dataDev;
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
		dataBug = new ArrayList<>();
		dataDev = new ArrayList<>();
		
		setPanels(getDataMatrix().get(0), 8, 8);
		setPanels(getDataMatrix().get(1), 7, 8);
		setPanels(getDataMatrix().get(2), 6, 8);
		setPanels(getDataMatrix().get(3), 5, 8);
		setPanels(getDataMatrix().get(4), 4, 8);
		setPanels(getDataMatrix().get(5), 3, 8);
		setPanels(getDataMatrix().get(6), 2, 8);
		setPanels(getDataMatrix().get(7), 1, 8);
	}
	
	// Atualizar bugs e devs
	public void addMeteors() {
		for (LMeteor lMeteor : dataBug) {
			setPanels(lMeteor, lMeteor.getPosY(), lMeteor.getPosX());
			System.out.println(lMeteor.getPosX() + " "+lMeteor.getPosY());
		}
		for (LMeteor lMeteor : dataDev) {
			setPanels(lMeteor, lMeteor.getPosY(), lMeteor.getPosX());
		}
	}
	
	// Chame métodos que criam planetas
	private void adjustPlanets() {
		dataMatrix = new ArrayList<>();
		
		getDataMatrix().add(0, new LPlanet("java"));
		getDataMatrix().add(1, new LPlanet("python"));
		getDataMatrix().add(2, new LPlanet("javaScript"));
		getDataMatrix().add(3, new LPlanet("ruby"));
		getDataMatrix().add(4, new LPlanet("php"));
		getDataMatrix().add(5, new LPlanet("cSharp"));
		getDataMatrix().add(6, new LPlanet("cPlusPlus"));
		getDataMatrix().add(7, new LPlanet("cLanguage"));
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
	
	public PCellGrid[][] getPanels() {
		return panels;
	}
	
	public void setPanels(JLabel label, int row, int column) {
		this.panels[row][column].add(label);
	}

	public ArrayList<JLabel> getDataMatrix() {
		return dataMatrix;
	}

	public ArrayList<LMeteor> getDataBug() {
		return dataBug;
	}

	public ArrayList<LMeteor> getDataDev() {
		return dataDev;
	}
}
