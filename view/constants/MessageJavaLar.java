package constants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import frame.DMessageTemp;
import panels.dialog.DCustom;

public enum MessageJavaLar {
	NO_USERS_MESSAGE {
		public void showMessage() {
			JOptionPane.showMessageDialog(
					null, "Registre-se primeiro!",
					"Usuário não cadastrado", JOptionPane.INFORMATION_MESSAGE
					);
		}

	},
	NO_FILES_READ_MESSAGE {
		public void showMessage() {
			JOptionPane.showMessageDialog(
					null, "Não há instantes a serem lidos. Por favor, leia um novo arquivo de entrada!",
					"Nenhum arquivo escolhido", JOptionPane.INFORMATION_MESSAGE
					);
		}

	},
	SUCCESS_GENERATE_REPORT {
		public void showMessage() {
			JOptionPane.showMessageDialog(
					null, "Relatório gerado com sucesso!",
					"Informação", JOptionPane.INFORMATION_MESSAGE
					);
		}

	},

	GAME_COMPLETED_MESSAGE {
		public void showMessage() {
			JOptionPane.showMessageDialog(
					null, "Não há mais planetas no JavaLar. Por favor, inicie um novo jogo!",
					"Você zerou o jogo", JOptionPane.INFORMATION_MESSAGE
					);
		}
	},

	NO_USER_DATA_READ_MESSAGE {
		public void showMessage() {
			JOptionPane.showMessageDialog(null, "Por favor, leia dados de outros participantes!", 
					"Nenhum dado de terceiros lido", JOptionPane.INFORMATION_MESSAGE);
		}	
	},

	USER_REGISTERED_MESSAGE {
		public void showMessage() {
			JOptionPane.showMessageDialog(null, "Já existe um usuário cadastrado!", 
					"Registro identificado", JOptionPane.INFORMATION_MESSAGE);
		}
	}, 

	NOT_RUN_YET {
		public void showMessage() {
			JOptionPane.showMessageDialog(null, "Por favor, registre-se ou inicie o jogo!", 
					"Nenhuma execução identificada", JOptionPane.INFORMATION_MESSAGE);
		}
	},

	ELEMENT_NOT_ADDED {
		public void showMessage() {
			JOptionPane.showMessageDialog(null, "Bug ou dev não adicionados ao sistema!", 
					"Informação", JOptionPane.INFORMATION_MESSAGE);
		}

	},

	ELEMENT_REMOVED {
		public void showMessage() {
		}

		public void showMessageSpecial(String object) {
			new DMessageTemp(object + " explodiu!");
		}
	},

	PROCESSING_SYSTEM {
		public void showMessage() {
			new DMessageTemp("Processando instantes...");

		}
	},

	READ_FILE_OTHERS_USERS {
		public void showMessage() {
			JOptionPane pane = new JOptionPane("Aguarde, por favor...", JOptionPane.INFORMATION_MESSAGE);
			JDialog dialog = pane.createDialog(null, "Lendo dados de terceiros...");

			Timer timer = new Timer(5000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dialog.dispose();
				}
			});

			timer.setRepeats(false);
			timer.start();

			dialog.setVisible(true);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		public void showMessageSpecial(Boolean verify) {
			boolean processoTerminado = verify;

			if (processoTerminado) {
				JOptionPane.showMessageDialog(null, "Dados de terceiros lidos com sucesso!", 
						"Informação", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao buscar dados!", 
						"Informação", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}, 

	SUCCESS_GENERATE_FILE_OUT {
		public void showMessageSpecial(String url) {
			new DCustom("Arquivo de saída gerado com sucesso!", "Informação", url);
		}
		public void showMessage() {
		}
	},
	
	FAILURE_OPEN_DIR {

		@Override
		public void showMessage() {
			JOptionPane.showMessageDialog(null, "Erro abrir diretório ou abertura de diretório não suportada.", 
					"Erro", JOptionPane.INFORMATION_MESSAGE);
		}
		
	},
	
	OPERATION_CANCELED {
		public void showMessage() {
			JOptionPane.showMessageDialog(null, "Operação Cancelada!", 
					"Informação", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}, 
	
	WAIT_GENERATE_REPORT {
		public void showMessage() {
			JOptionPane pane = new JOptionPane("Gerando relatório. Aguarde...", JOptionPane.INFORMATION_MESSAGE);
			JDialog dialog = pane.createDialog(null, "Informação");

			Timer timer = new Timer(5000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dialog.dispose();
				}
			});

			timer.setRepeats(false);
			timer.start();

			dialog.setVisible(true);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	},
	
	RESTART_MESSAGE {
		public int showMessageReturn() {
			return JOptionPane.showConfirmDialog(null, "Tem certeza que deseja reiniciar o jogo?", "Confirmação", JOptionPane.YES_NO_OPTION);
		}

		@Override
		public void showMessage() {
		}
		
	};

	public abstract void showMessage();
	public void showMessageSpecial(String object) {
	}
	public void showMessageSpecial(Boolean verify) {
	}
	public int showMessageReturn() {
		return 0;
	}
	public void abrirURL(String url) {
	}

}
