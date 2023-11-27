package frame;

import java.awt.Component;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import constants.MessageJavaLar;
import panels.buttons.BMenuUser;
import util.Coordinates;

@SuppressWarnings("serial")
public class DRegister extends JDialog {
	private JTextField txtNome;
	private JTextField txtMatricula;

	private JLabel lblNome;
	private JLabel lblMatricula;

	private BMenuUser btnRegistrar;
	private BMenuUser btnCancelar;

	protected Coordinates coord;
	protected Coordinates dimension;

	private String nome;
	private String matricula;

	private boolean isRegister;

	public DRegister() {
		initializeDRegister();
		setIsRegister(false);
	}

	private void initializeDRegister() {
		lblNome = createLabel("NOME");
		lblMatricula = createLabel("MATRÍCULA");
		coord = new Coordinates(getParent().getX(), getParent().getY());
		dimension = new Coordinates(getParent().getWidth(), getParent().getHeight());
	}

	public void initDialog() {
		initComponents();
		layoutComponents();
		centerOnFrame();
		addEventListeners();
		setVisible(true);
	}

	private void initComponents() {
		txtNome = createTextField();
		txtMatricula = createTextField();
		btnRegistrar = createButton("Registrar");
		btnCancelar = createButton("Cancelar");
	}

	private JLabel createLabel(String text) {
		JLabel label = new JLabel(text);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial", Font.PLAIN, 12));
		return label;
	}

	private JTextField createTextField() {
		JTextField textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 12));
		textField.setColumns(10);
		return textField;
	}

	private BMenuUser createButton(String text) {
		BMenuUser button = new BMenuUser(text);
		button.setFont(new Font("Arial", Font.BOLD, 12));
		return button;
	}

	private void layoutComponents() {
		getContentPane().setLayout(null);

		addComponent(txtNome, 35, 36, 315, 35);
		addComponent(txtMatricula, 35, 107, 315, 35);
		addComponent(btnRegistrar, 35, 154, 113, 35);
		addComponent(btnCancelar, 235, 154, 113, 35);

		addComponent(lblNome, 164, 11, 73, 14);
		addComponent(lblMatricula, 164, 82, 73, 14);

		setFont(new Font("Arial", Font.PLAIN, 12));
		setTitle("Registrar usuário");
		setResizable(false);
		setSize(400, 250);
		setLocation(centerOnFrame());
	}

	private void addComponent(Component component, int x, int y, int width, int height) {
		component.setBounds(x, y, width, height);
		getContentPane().add(component);
	}

	private Point centerOnFrame() {
		int x = coord.getX() + (dimension.getX() + getWidth());
		int y = coord.getY() + (dimension.getY() + getHeight());
		return new Point(x, y);
	}

	private void addEventListeners() {
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleRegistrarButton();
			}
		});

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleCancelarButton();
			}
		});
	}

	private void handleRegistrarButton() {
		setIsRegister(true);
		setNome(txtNome.getText().trim());
		setMatricula(txtMatricula.getText().trim());
		String nomeRegistrado = getNome();
		setVisible(false);
		MessageJavaLar.PROCESSING_SYSTEM.showMessageSpecial(nomeRegistrado + " registrado!");
	}

	private void handleCancelarButton() {
		setVisible(false);
		dispose(); 
		MessageJavaLar.OPERATION_CANCELED.showMessage();
	}


	public boolean isRegister() {
		return isRegister;
	}

	public void setIsRegister(boolean isRegister) {
		this.isRegister = isRegister;
	}

	public String getNome() {
		return nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public BMenuUser getBtnRegistrar() {
		return btnRegistrar;
	}

	public BMenuUser getBtnCancelar() {
		return btnCancelar;
	}
}