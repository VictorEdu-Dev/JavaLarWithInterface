package planets;

public abstract class AstroLinguagem {
		private String nome;
		private int posX;
		private int posY;
		private int velocidadeDeTranslacao;
		private int dias;
		private int anos;
		
		private int limitXLeft;
		private int limitXRigth;
		private int limitYUp;
		private int limitYDown;

		private int numBugsColididos;
		private int numDevsColididos;
		private boolean explodiu;
		
		public AstroLinguagem(String nome, int posX, int posY, int velocidadeDeTranslacao) {
	        this.nome = nome;
			this.posX = posX;
	        this.posY = posY;
	        this.velocidadeDeTranslacao = velocidadeDeTranslacao;
	    }
		
		// Getters e setters para uso posterior
		public void setNumBugsColididos() {
			this.numBugsColididos += 1;
		}

		public int getNumBugsColididos() {
			return numBugsColididos;
		}
		
		public int getNumDevsColididos() {
			return numDevsColididos;
		}
		
		public void setNumDevsColididos() {
			this.numDevsColididos += 1;
		}
		public boolean getExplodiu() {
			return explodiu;
		}

		public void setExplodiu(boolean explodiu) {
			this.explodiu = explodiu;
		}
		
		public abstract String getResumo();
		
		public int getVelocidadeDeTranslacao() {
			return velocidadeDeTranslacao;
		}

		public void setVelocidadeDeTranslacao(int velocidadeDeTranslacao) {
		    this.velocidadeDeTranslacao += velocidadeDeTranslacao;
		}

		public String getNome() {
			return nome;
		}

		public int getPosX() {
			return posX;
		}

		public int getPosY() {
			return posY;
		}

		public void setPosX(int posX) {
		    this.posX += posX;
		}

		public void setPosY(int posY) {
		    this.posY += posY;
		}

		public int getLimitXLeft() {
			return limitXLeft;
		}

		public int getLimitXRigth() {
			return limitXRigth;
		}

		public int getLimitYUp() {
			return limitYUp;
		}

		public int getLimitYDown() {
			return limitYDown;
		}

		public void setLimitXLeft(int limitXLeft) {
			this.limitXLeft = limitXLeft;
		}

		public void setLimitXRigth(int limitXRigth) {
			this.limitXRigth = limitXRigth;
		}

		public void setLimitYUp(int limitYUp) {
			this.limitYUp = limitYUp;
		}

		public void setLimitYDown(int limitYDown) {
			this.limitYDown = limitYDown;
		}

		public int getDias() {
			return dias;
		}

		public void setDias(int dias) {
			this.dias = dias;
		}

		public int getAnos() {
			return anos;
		}

		public void setAnos(int anos) {
			this.anos = anos;
		}
		

		
}