package BF;

public class IAR {
	
	public static void main (String[]args) {
		CreaTablero ct = new CreaTablero();
		int [][] t = ct.Tablero(5);
		for(int i = 0; i < t.length; i++) {
			for(int j = 0; j < t.length; j++) {
				System.out.print(t[i][j]);
			}
			System.out.println();
		}
	}

}
