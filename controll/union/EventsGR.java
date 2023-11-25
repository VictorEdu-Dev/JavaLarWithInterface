package union;

import java.util.ArrayList;
import java.util.List;

import connection.DataBaseConnection;
import connection.DataInsert;
import planets.AstroLinguagem;
import planets.Meteoro;

public class EventsGR extends DataInsert {
	private EventsJavaLar eventsJavaLar;

	public EventsGR(EventsJavaLar eventsJavaLar) {
		this.eventsJavaLar = eventsJavaLar;
	}

	public void openConnection() {
		DataBaseConnection database = new DataBaseConnection("da_java.mysql.dbaas.com.br", "da_java", "da_java", "Tecnicas*2023@");
		setConnection(database.getConnection());
	}

	public void insertData() {
		adicionarInfo(eventsJavaLar.getRegister().getNome(), Integer.valueOf(eventsJavaLar.getRegister().getMatricula())); // Registro Nome e Matrícula
		addFileName(eventsJavaLar.getReadFile().getNomeArquivo()); // Registro do Nome de Arquivo Lido
		
		callThreadsAddData();
		openConnection();
		saveReport();
		
		System.out.println("Dados registrados!");
	}

	private void callThreadsAddData() {
		List<Thread> threads = new ArrayList<>();
		
		Thread threadPlanet = new Thread(new Runnable() {	
			@Override
			public void run() {
				addDataPlanets();
			}
		});
		
		Thread threadBug = new Thread(new Runnable() {	
			@Override
			public void run() {
				addBugData();
			}
		});
		
		Thread threadDev = new Thread(new Runnable() {	
			@Override
			public void run() {
				addDevData();
			}
		});
		threads.add(threadPlanet);
		threads.add(threadBug);
		threads.add(threadDev);
		
		for (Thread thread : threads) {
			thread.start();
		}
		
		try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}

	private void addDataPlanets() {
		List<AstroLinguagem> astros = new ArrayList<>();
		astros.addAll(eventsJavaLar.getInter().getInit().getAstrosRemoved());
		astros.addAll(eventsJavaLar.getInter().getInit().getAstros());

		for (AstroLinguagem astro : astros) {
			String atributo = astro.getNome();
			if (atributo.equals("Python")) {
				setBugPython(astro.getNumBugsColididos());
				setDevPython(astro.getNumDevsColididos());
				setvPython(astro.getVelocidadeDeTranslacao());
			}
		}

		for (AstroLinguagem astro : astros) {
			String atributo = astro.getNome();
			if (atributo.equals("JavaScript")) {
				setBugJavaScript(astro.getNumBugsColididos());
				setDevJavaScript(astro.getNumDevsColididos());
				setvJavaScript(astro.getVelocidadeDeTranslacao());
			}
		}

		for (AstroLinguagem astro : astros) {
			String atributo = astro.getNome();
			if (atributo.equals("Ruby on Rails")) {
				setBugRuby(astro.getNumBugsColididos());
				setDevRuby(astro.getNumDevsColididos());
				setvRuby(astro.getVelocidadeDeTranslacao());
			}
		}

		for (AstroLinguagem astro : astros) {
			String atributo = astro.getNome();
			if (atributo.equals("PHP")) {
				setBugPHP(astro.getNumBugsColididos());
				setDevPHP(astro.getNumDevsColididos());
				setvPHP(astro.getVelocidadeDeTranslacao());
			}
		}

		for (AstroLinguagem astro : astros) {
			String atributo = astro.getNome();
			if (atributo.equals("C++")) {
				setBugCPlusPlus(astro.getNumBugsColididos());
				setDevCPlusPlus(astro.getNumDevsColididos());
				setvCPlusPlus(astro.getVelocidadeDeTranslacao());
			}
		}

		for (AstroLinguagem astro : astros) {
			String atributo = astro.getNome();
			if (atributo.equals("C#")) {
				setBugCSharp(astro.getNumBugsColididos());
				setDevCSharp(astro.getNumDevsColididos());
				setvCSharp(astro.getVelocidadeDeTranslacao());
			}
		}

		for (AstroLinguagem astro : astros) {
			String atributo = astro.getNome();
			if (atributo.equals("C")) {
				setBugC(astro.getNumBugsColididos());
				setDevC(astro.getNumDevsColididos());
				setvC(astro.getVelocidadeDeTranslacao());
			}
		}
	}

	private void addBugData() {
		int q1 = 0;
		int q2 = 0;
		int q3 = 0; 
		int q4 = 0;

		for (Meteoro objeto : eventsJavaLar.getInter().getInit().getBugs()) {
			int posX = objeto.getCoordX();
			int posY = objeto.getCoordY();

			if (posX >= 1 && posX <= 15 && posY >= 1 && posY <= 15) {
				if (posX <= 7 && posY <= 7) {
					q1++;
				} else if (posX > 7 && posY <= 7) {
					q2++;
				} else if (posX <= 7 && posY > 7) {
					q3++;
				} else {
					q4++;
				}
			}

			setBugQ1(q1);
			setBugQ2(q2);
			setBugQ3(q3);
			setBugQ4(q4);

		}
	}

	private void addDevData() {
		int q1 = 0;
		int q2 = 0;
		int q3 = 0; 
		int q4 = 0;

		for (Meteoro objeto : eventsJavaLar.getInter().getInit().getDevs()) {
			int posX = objeto.getCoordX();
			int posY = objeto.getCoordY();

			if (posX >= 1 && posX <= 15 && posY >= 1 && posY <= 15) {
				if (posX <= 7 && posY <= 7) {
					q1++;
				} else if (posX > 7 && posY <= 7) {
					q2++;
				} else if (posX <= 7 && posY > 7) {
					q3++;
				} else {
					q4++;
				}
			}

			setDevQ1(q1);
			setDevQ2(q2);
			setDevQ3(q3);
			setDevQ4(q4);

		}	
	}

}
