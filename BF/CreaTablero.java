package BF;

public class CreaTablero {

	public int[][] Tablero (int n){
		int [][] t = new int [n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				t[i][j] = 0;
			}
		}
		rellena(t);
		return t;
	}

	private void rellena(int[][] t) {
	 int nave = 5;
		while (nave > 1) {
			
			int a = (int)Math.floor(Math.random() * t.length), b = (int)Math.floor(Math.random() * t.length), c = (int)Math.floor(Math.random() * 4);
			//a = coordenada x       b = coordenada y     c = uso en el switch
			
			switch (c) {  // 0 arriba    1 derecha    2 abajo    3 izquierda 
			
			case 0 : if(nave <= b+1) {
						if(disponibilidad1(t, nave, a, b) && b >=0) {
							for( int i = nave; i > 0; i--) {
								t[a][b] = 1;
								b--;
							}
							nave--;
						}
					}
					break;
					
			case 1 : if(nave <= (t.length -(a+1)) && a < t.length) {
						if(disponibilidad2(t, nave, a, b)) {
							for( int i = nave; i > 0; i--) {
								t[a][b] = 1;
								a++;
							}
							nave--;
						}
					}
					break;
					
			case 2 : if(nave <= (t.length -(b+1)) && b < t.length) {
						if(disponibilidad3(t, nave, a, b)) {
							for( int i = nave; i > 0; i--) {
								t[a][b] = 1;
								b++;
							}
							nave--;
						}
					}
					break;
			case 3 : if(nave <= a+1) {
						if(disponibilidad4(t, nave, a, b) && a >= 0) {
							for( int i = nave; i > 0; i--) {
								t[a][b] = 1;
								a--;
							}
							nave--;
						}
					}
					break;
			}
		}
		
	}


	private boolean disponibilidad1(int[][] t, int n, int a, int b) {
		for( int i = n; i > 0; i--) {
			if(b>=0) {
				if(t[a][b] != 0) {
					return false;
				}
				b--;
			}
		}
		return true;
	}
	
	private boolean disponibilidad2(int[][] t, int n, int a, int b) {
		for( int i = n; i > 0; i--) {
			if(a< t.length) {
				if(t[a][b] != 0) {
					return false;
				}
				a++;
			}
		}
		return true;
	}
	private boolean disponibilidad3(int[][] t, int n, int a, int b) {
		for( int i = n; i > 0; i--) {
			if(b< t.length) {
				if(t[a][b] != 0) {
					return false;
				}
				b++;
			}
		}
		return true;
	}
	
	private boolean disponibilidad4(int[][] t, int n, int a, int b) {
		for( int i = n; i > 0; i--) {
			if(a>= 0) {
				if(t[a][b] != 0) {
					return false;
				}
				a--;
			}
		}
		return true;
	}

}
