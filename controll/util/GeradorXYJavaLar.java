package util;
import java.util.Random;

public class GeradorXYJavaLar {
	protected int maxX;
	protected int minX;
	protected int maxY;
	protected int minY;
	protected int pBlockedX;
	protected int pblockedY;
	protected Random random;
	
	public GeradorXYJavaLar(int maxX, int minX, int maxY, int minY) {
		this.maxX = maxX;
		this.minX = minX;
		this.maxY = maxY;
		this.minY = minY;
		this.random = new Random();
		this.pBlockedX = -1;
        this.pblockedY = -1; 
	}

	
	public int[] gerarCoordenadas() {
	    int coordX;
	    int coordY;
	    do {
	        coordX = random.nextInt(maxX - minX + 1) + minX;
	        coordY = random.nextInt(maxY - minY + 1) + minY;
	    } while (coordX == pBlockedX && coordY == pblockedY || (coordX == 8 && coordY == 8));

	    pBlockedX = coordX;
	    pblockedY = coordY;

	    return new int[]{coordX, coordY};
	}
}
