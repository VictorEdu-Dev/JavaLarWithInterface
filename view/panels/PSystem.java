package panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


@SuppressWarnings("serial")
public class PSystem extends JPanel {
	private static final int width = 990;
	private static final int height = 708;
	
	private JLabel java;
	private JLabel python;
	private JLabel javaScript;
	private JLabel rubyOnRails;
	private JLabel php;
	private JLabel cSharp;
	private JLabel cPlusPlus;
	private JLabel cLanguage;
	
	public PSystem() {
		iniatilizeSystem();
	}

//	protected void paintComponent (Graphics g) {
//		super.paintComponent(g);
//		
//		int tam = 236/5;
//		
//		int width = getWidth();
//		int height = getHeight();
//		
//		g.setColor(Color.GRAY);
//		
//		for (int y = 0; y < height; y+= tam) {
//			g.drawLine(0, y, width, y);
//		}
//		
//		for (int x = 0; x < width; x += tam) {
//			g.drawLine(x, 0, x, height);
//		}	
//	}
	
	// Inicializa o painel
	private void iniatilizeSystem() {	
		setLayout(null);
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		setBackground(Color.decode("#FFE4B5"));
		setPreferredSize(new Dimension(width, height));
		revalidate();
		
		initializeObjectsPlanet();
		adjustPlanets();
		addPlanets();
	}
	
	// Adiciona planetas ao painel
		private void addPlanets() {
			add(java);
			add(python);
			add(javaScript);
			add(rubyOnRails);
			add(php);
			add(cSharp);
			add(cPlusPlus);
			add(cLanguage);
		}

	// Chame métodos que criam planetas
	private void adjustPlanets() {
		createJava();
		createPython();
		createJavaScript();
		createRubyOnRails();
		createPHP();
		createCSharp();
		createCPlusPlus();
		createCLanguage();
	}

	// Inicializa os objetos planeta
	private void initializeObjectsPlanet() {
		java = new JLabel();
		python = new JLabel();
		javaScript = new JLabel();
		rubyOnRails = new JLabel();
		php = new JLabel();
		cSharp = new JLabel();
		cPlusPlus = new JLabel();
		cLanguage = new JLabel();
	}
	

	// Determina atributos de cada planeta
	private void createJava() {
		java.setSize(50, 50);
		
		int pWidth = this.getWidth() / 2 - java.getWidth() / 2;
		int pHeidht = this.getHeight() / 2 - java.getHeight() / 2;
		
		java.setLocation(pWidth, pHeidht);
		java.setHorizontalAlignment(SwingConstants.CENTER);
		java.setVerticalAlignment(SwingConstants.CENTER);
		java.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

		ImageIcon icon = imageProcess("view/panels/planets/java.png", 
				java.getWidth(), java.getHeight());
		
		java.setIcon(icon);
	}

	private void createPython() {
		python.setSize(40, 40);
		
		int pWidth = this.getWidth() / 2 - python.getWidth() / 2;
		int pHeidht = this.getHeight() / 2 - java.getHeight() / 2 
				- python.getHeight() - 5;
		
		python.setLocation(pWidth, pHeidht);
		python.setHorizontalAlignment(SwingConstants.CENTER);
		python.setVerticalAlignment(SwingConstants.CENTER);
		python.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		ImageIcon icon = imageProcess("view/panels/planets/python.png", 
				python.getWidth(), python.getHeight());
		
		python.setIcon(icon);
	}
	
	private void createJavaScript() {
		javaScript.setSize(40, 40);
		
		int pWidth = this.getWidth() / 2 - javaScript.getWidth() / 2;
		int pHeidht = this.getHeight() / 2 - java.getHeight() / 2 
				- python.getHeight() - javaScript.getHeight() - 10;
		
		javaScript.setLocation(pWidth, pHeidht);
		javaScript.setHorizontalAlignment(SwingConstants.CENTER);
		javaScript.setVerticalAlignment(SwingConstants.CENTER);
		javaScript.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		ImageIcon icon = imageProcess("view/panels/planets/javaScript.png", 
				javaScript.getWidth(), javaScript.getHeight());
		
		javaScript.setIcon(icon);
	}
	
	private void createRubyOnRails() {
		rubyOnRails.setSize(40, 40);
		
		int pWidth = this.getWidth() / 2 - rubyOnRails.getWidth() / 2;
		int pHeidht = this.getHeight() / 2 - java.getHeight() / 2 
				- python.getHeight() - javaScript.getHeight() 
				- rubyOnRails.getHeight() - 15;
		
		rubyOnRails.setLocation(pWidth, pHeidht);
		rubyOnRails.setHorizontalAlignment(SwingConstants.CENTER);
		rubyOnRails.setVerticalAlignment(SwingConstants.CENTER);
		rubyOnRails.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		ImageIcon icon = imageProcess("view/panels/planets/ruby.png", 
				rubyOnRails.getWidth(), rubyOnRails.getHeight());
		
		rubyOnRails.setIcon(icon);
	}
	
	private void createPHP() {
		php.setSize(40, 40);
		
		int pWidth = this.getWidth() / 2 - php.getWidth() / 2;
		int pHeidht = this.getHeight() / 2 - java.getHeight() / 2 
				- python.getHeight() - javaScript.getHeight() 
				- rubyOnRails.getHeight() - php.getHeight() - 20;
		
		php.setLocation(pWidth, pHeidht);
		php.setHorizontalAlignment(SwingConstants.CENTER);
		php.setVerticalAlignment(SwingConstants.CENTER);
		php.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		ImageIcon icon = imageProcess("view/panels/planets/php.png", 
				php.getWidth(), php.getHeight());
		
		php.setIcon(icon);
	}
	
	private void createCSharp() {
		cSharp.setSize(40, 40);
		
		int pWidth = this.getWidth() / 2 - cSharp.getWidth() / 2;
		int pHeidht = this.getHeight() / 2 - java.getHeight() / 2 
				- python.getHeight() - javaScript.getHeight()
				- rubyOnRails.getHeight() - php.getHeight()
				- cSharp.getHeight() - 25;
		
		cSharp.setLocation(pWidth, pHeidht);
		cSharp.setHorizontalAlignment(SwingConstants.CENTER);
		cSharp.setVerticalAlignment(SwingConstants.CENTER);
		cSharp.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		ImageIcon icon = imageProcess("view/panels/planets/cSharp.png", 
				cSharp.getWidth(), cSharp.getHeight());
		
		cSharp.setIcon(icon);
	}
	
	private void createCPlusPlus() {
		cPlusPlus.setSize(40, 40);
		
		int pWidth = this.getWidth() / 2 - cPlusPlus.getWidth() / 2;
		int pHeidht = this.getHeight() / 2 - java.getHeight() / 2 
				- python.getHeight() - javaScript.getHeight()
				- rubyOnRails.getHeight() - php.getHeight()
				- cSharp.getHeight() - cLanguage.getHeight() - cPlusPlus.getHeight() - 30;
		
		cPlusPlus.setLocation(pWidth, pHeidht);
		cPlusPlus.setHorizontalAlignment(SwingConstants.CENTER);
		cPlusPlus.setVerticalAlignment(SwingConstants.CENTER);
		cPlusPlus.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		ImageIcon icon = imageProcess("view/panels/planets/cPlusPlus.png", 
				cPlusPlus.getWidth(), cPlusPlus.getHeight());
		
		cPlusPlus.setIcon(icon);
	}
	
	
	private void createCLanguage() {
		cLanguage.setSize(40, 40);
		
		int pWidth = this.getWidth() / 2 - cLanguage.getWidth() / 2;
		int pHeidht = this.getHeight() / 2 - java.getHeight() / 2 
				- python.getHeight() - javaScript.getHeight()
				- rubyOnRails.getHeight() - php.getHeight()
				- cSharp.getHeight() - cLanguage.getHeight() 
				- cPlusPlus.getHeight() - 35;
		
		cLanguage.setLocation(pWidth, pHeidht);
		cLanguage.setHorizontalAlignment(SwingConstants.CENTER);
		cLanguage.setVerticalAlignment(SwingConstants.CENTER);
		cLanguage.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		ImageIcon icon = imageProcess("view/panels/planets/cLanguage.png", 
				cLanguage.getWidth(), cLanguage.getHeight());
		
		cLanguage.setIcon(icon);
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
}
