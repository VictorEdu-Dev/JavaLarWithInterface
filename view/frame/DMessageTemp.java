package frame;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.Timer;

public class DMessageTemp {
	private String mensagem;

	public DMessageTemp(String mensagem) {
		this.mensagem = mensagem;
		showMessageTemp();
	}

	public void showMessageTemp() {
		SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
			JDialog dialog;
			@Override
			protected Void doInBackground() {
				JOptionPane optionPane = new JOptionPane(mensagem, JOptionPane.PLAIN_MESSAGE);
				dialog = optionPane.createDialog(null, "Aviso");

				Timer timer = new Timer(2000, e -> dialog.dispose());
				timer.setRepeats(false);
				timer.start();

				dialog.setSize(190, 120);
				dialog.setLocation(-10, 588); 
				dialog.setModal(false);
				dialog.setVisible(true);
				return null;
			}
		};
		worker.execute();
	}
}
