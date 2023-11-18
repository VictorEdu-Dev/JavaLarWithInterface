package panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PSystem extends JPanel {
	private static final int width = 990;
	private static final int height = 708;
	private static final int rows = 16;
	private static final int columns = 16;

	private ArrayList<JLabel> dataMatrix;
	private JPanel[][] panels;

	public PSystem() {
		iniatilizeSystem();
	}

	// Inicializa o painel
	private void iniatilizeSystem() {
		configurePanel();
		initializeObjectsPlanet();
		createGrid();
		adjustPlanets();
		addPlanets();
	}

	private void configurePanel() {
		setLayout(new GridLayout(15, 15));
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		setBackground(Color.decode("#FFE4B5"));
		setPreferredSize(new Dimension(width, height));
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
		initializeComponents("java");
		initializeComponents("python");
		initializeComponents("javaScript");
		initializeComponents("ruby");
		initializeComponents("php");
		initializeComponents("cSharp");
		initializeComponents("cPlusPlus");
		initializeComponents("cLanguage");
	}

	// Inicializa os objetos planeta
	private void initializeObjectsPlanet() {
		dataMatrix = new ArrayList<>();
	}

	// Cria um efeito de grade com paineis
	private void createGrid() {
		panels = new JPanel[rows][columns];
		for (int i = 1; i < rows; i++) {
			for(int j = 1; j < columns; j++) {
				panels[i][j] = new JPanel();
				panels[i][j].setLayout(null);
				panels[i][j].setBackground(Color.LIGHT_GRAY);
				panels[i][j].setPreferredSize(new Dimension(40, 40));
				panels[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				this.add(panels[i][j]);
			}
		}
	}

	private void initializeComponents(String imageUrl) {
		JLabel label = new JLabel();
		
		label.setSize(40, 40);
		label.setLocation(12, 4);
		
		ImageIcon icon = imageProcess("view/panels/planets/"+ imageUrl +".png", 
				label.getWidth(), label.getHeight());
		
		label.setIcon(icon);
		this.dataMatrix.add(label);
	}

	// Caracteriza o ícone do planeta
	public static ImageIcon imageProcess(String url, int width, int height) {
		ImageIcon icon = new ImageIcon(url);
		Image resizedImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(resizedImage);
		return resizedIcon;
	}

	// Getters para acesso posterior
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public static int getRow() {
		return rows;
	}

	public static int getColumns() {
		return columns;
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
}
