package panels.dialog;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import constants.MessageJavaLar;
import panels.planets.LPlanet;

@SuppressWarnings("serial")
public class DCustom extends JDialog {
	private JButton btnNewButton;

	public DCustom(String mensagem, String titulo, String url) {
		super((Frame) null, titulo, true);
		setTitle("Informação");
		initComponents(mensagem, url);
	}

	private void initComponents(String mensagem, String url) {

		JButton button = new JButton("OK");
		button.setBounds(0, 138, 284, 23);
		button.setFont(new Font("Arial", Font.PLAIN, 12));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(null);
		panel.add(button);

		getContentPane().add(panel);

		btnNewButton = new JButton();
		btnNewButton.setBounds(239, 98, 30, 30);
		ImageIcon icon = LPlanet.imageProcess("C:\\Central de Desenvolvimento\\Java\\Desktop\\Workspace"
				+ "\\JavaLarSystemInterface\\Projeto\\view\\panels\\dialog\\iconDir.png", 
				10, 10);
		btnNewButton.setIcon(icon);
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);

		getBtnNewButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirURL(url);
				dispose();
			}
		});

		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Abrir diretório do arquivo:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 10));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(83, 105, 147, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Arquivo gerado com sucesso!");
		lblNewLabel_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(41, 60, 189, 14);
		panel.add(lblNewLabel_1);
		
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public void abrirURL(String caminhoArquivo) {
		try {
			abrirDiretorio(converterDiretorioParaURI(obterDiretorioDoArquivo(caminhoArquivo)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void abrirDiretorio(URI uri) {
		try {
			if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
				Desktop.getDesktop().browse(uri);
			} else {
				MessageJavaLar.FAILURE_OPEN_DIR.showMessage();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String obterDiretorioDoArquivo(String caminhoArquivo) {
		File arquivo = new File(caminhoArquivo);
		return arquivo.getParent();
	}

	public static URI converterDiretorioParaURI(String caminho) throws Exception {
		Path path = Paths.get(caminho);
		return path.toUri();
	}

	public JButton getBtnNewButton() {
		return btnNewButton;
	}
}

