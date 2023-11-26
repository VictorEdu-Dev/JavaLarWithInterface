package frame;

import java.awt.Component;
import java.awt.Font;
import java.awt.Point;

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
    
    private Boolean isRegister;

    public DRegister() {
        lblNome = createLabel("NOME");
        lblMatricula = createLabel("MATRÍCULA");
        coord = new Coordinates(getParent().getX(), getParent().getY());
        dimension = new Coordinates(getParent().getWidth(), getParent().getHeight());
        
        setIsRegister(false);
    }

	public void initDialog() {
		initComponents();
        layoutComponents();
        centerOnFrame();
        addEventOk();
        addEventCancelar();
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

    public Boolean isRegister() {
		return isRegister;
	}

	public void setIsRegister(Boolean isRegister) {
		this.isRegister = isRegister;
	}

	public String getNome() {
		return nome;
	}

	public String getMatricula() {
		return matricula;
	}

	private void addEventOk() {
        btnRegistrar.addActionListener(e -> {
            nome = txtNome.getText();
            matricula = txtMatricula.getText();
            setIsRegister(true);
            MessageJavaLar.PROCESSING_SYSTEM.showMessageSpecial(getName() + " registrado!");
            dispose();
        });
    }
	
	private void addEventCancelar() {
		btnCancelar.addActionListener(e -> {
        	nome = null;
        	matricula = null;
            setIsRegister(false);
            MessageJavaLar.OPERATION_CANCELED.showMessage();
            dispose();
        });
	}
	}