package panels;

import java.awt.Color;
import java.awt.Component;
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

	private ArrayList<LPlanet> dataMatrix;
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

	
	// Resolver problema de concorrencia das threads
	// Atualizar bugs e devs
	public void addBugs() {
		for (LMeteor lMeteor : dataBug) {
			setPanels(lMeteor, lMeteor.getPosY(), lMeteor.getPosX());
		}
	}

	public void addDevs() { 
		for (LMeteor lMeteor : dataDev) {
			setPanels(lMeteor, lMeteor.getPosY(), lMeteor.getPosX());
		}
	}

	// Chame métodos que criam planetas
	private void adjustPlanets() {
		dataMatrix = new ArrayList<>();

		getDataMatrix().add(0, new LPlanet("Java"));
		getDataMatrix().add(1, new LPlanet("Python"));
		getDataMatrix().add(2, new LPlanet("JavaScript"));
		getDataMatrix().add(3, new LPlanet("Ruby on Rails"));
		getDataMatrix().add(4, new LPlanet("PHP"));
		getDataMatrix().add(5, new LPlanet("C#"));
		getDataMatrix().add(6, new LPlanet("C++"));
		getDataMatrix().add(7, new LPlanet("C"));
		
	}
	
	public void definePriorizy() {
	    for (JPanel[] panelRow : panels) {
	        for (JPanel panel : panelRow) {
	            if (panel != null && panel.getComponents().length > 0) {
	                for (Component component : panel.getComponents()) {
	                    if (component instanceof LPlanet) {
	                        LPlanet planet = (LPlanet) component;
	                        if ("PLANETA".equals(planet.getTipo())) {
	                            panel.setComponentZOrder(planet, 0);
	                        }
	                    }
	                }
	            }
	        }
	    }
	    revalidate();
	    repaint();
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

	public ArrayList<LPlanet> getDataMatrix() {
		return dataMatrix;
	}

	public ArrayList<LMeteor> getDataBug() {
		return dataBug;
	}

	public ArrayList<LMeteor> getDataDev() {
		return dataDev;
	}
}
