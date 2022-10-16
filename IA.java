
public class IA {
    public static void main (String[]args){
    	int[][] t = new int [3][3];
        for (int i = 0; i<t.length ; i++){
            for (int j = 0; j<t.length ; j++){
            	t[i][j] = 0;
            }
        }
    	ia(t);
    }

    private static void ia (int[][] t){       
    	int ju = 5, nj = 0, cona = 0, conb = 0, ia = 1;      // cona = cantidad de 1   conb = cantidad de 2
    	
        for (int i = 0; i<t.length ; i++){
            for (int j = 0; j<t.length ; j++){
    
            	if(t[i][j] != 0) {                 // si no entra entonces ju = 0 - empieza la IA c
            		nj++;
            		if(t[i][j] ==1) {             
            			cona ++;
            		}else {
            			conb ++;
            		}
            	}
            }
        }
        if(cona > conb) {  // si cona es mayor que con b entonces ia es segunda  en caso de ser iguales es primero por lo tanto no entra 
        	ia = 2;
        }
        if(nj > 0) {
        	ju = d(t, ia);
        }
        
        switch (ju){ 
        
        	case 1 :    t[0][0] = ia;
        				break;
        		
        	case 2 :	t[0][1] = ia;
						break;
        		
        	case 3 :	t[0][2] = ia;
						break;
        		
        	case 4 :	t[1][0] = ia;
						break;
        	
        	case 5 :	t[1][1] = ia;
						break;
        		
        	case 6 :	t[1][2] = ia;
						break;
        		
        	case 7 :	t[2][0] = ia;
						break;
        		
        	case 8 :	t[2][1] = ia;
						break;
        		
        	case 9 :    t[2][1] = ia;
						break;
        		
        }
        

    }

	private static int d(int[][] t, int ia) {
		
    	int turno = 1, d = 0;
    	
        for (int i = 0; i<t.length ; i++){
            for (int j = 0; j<t.length ; j++){
            	
            	if(t[i][j] != 0 ) {                 // si entra es porque alguien jugo
            		turno++;
            	}
            }
        }
		switch(turno) {

			case 1:                                             //ia = 2

				if (t[1][1] == 1) {
					int e = (int) (Math.random() * 4) + 1;
					switch (e) {

						case 1:
							d = 1;
							break;

						case 2:
							d = 3;
							break;

						case 3:
							d = 7;
							break;

						case 4:
							d = 9;
							break;

					}
				} else {
					d = 5;
				}
				break;

			case 2:                                            //ia = 1

				int e;
				if (t[0][0] == 2 || t[0][2] == 2 || t[2][0] == 2 || t[2][2] == 2) {    // si el rival esta en una esquina se busca empate (asumiendo que no cometa errores)
					e = 0;
					if (t[0][0] == 2) {        // defino que esquina es en la que esta la jugada del rival
						e = 1;
					}
					if (t[0][2] == 2) {
						e = 2;
					}
					if (t[2][0] == 2) {
						e = 3;
					}
					if (t[2][2] == 2) {
						e = 4;
					}

					switch (e) {                              //Segun la esquina escojo uno de sus lados para que su siguiente jugada no pueda ser una linea
						case 1:									//1  (posicion)
							e = (int) (Math.random() * 2) + 1;
							if (e == 1) {
								d = 2;
							}else {
								d = 4;
							}
							break;

						case 2:									//3
							e = (int) (Math.random() * 2) + 1;
							if (e == 1) {
								d = 2;
							}else {
								d = 6;
							}
							break;

						case 3:									//7
							e = (int) (Math.random() * 2) + 1;
							if (e == 1) {
								d = 4;
							}else {
								d = 8;
							}
							break;

						case 4:									//9
							e = (int) (Math.random() * 2) + 1;
							if (e == 1) {
								d = 6;
							}else {
								d = 8;
							}
							break;
					}


				} else {                                                               // si el rival esta en un lado se busca victoria con doble esquina
					e = 0;
					if (t[0][1] == 2) {        // defino que posicion es en la que esta la jugada del rival
						e = 1;
					}
					if (t[1][0] == 2) {
						e = 2;
					}
					if (t[1][2] == 2) {
						e = 3;
					}
					if (t[2][1] == 2) {
						e = 4;
					}
					switch (e) {                              //Segun el lado escojo una de sus esquinas para buscar la victoria en el siguiente turno
						case 1:									// 2
							e = (int) (Math.random() * 2) + 1;
							if (e == 1) {
								d = 1;
							}else {
								d = 3;
							}
							break;

						case 2:                               // 4
							e = (int) (Math.random() * 2) + 1;
							if (e == 1) {
								d = 1;
							}else {
								d = 7;
							}
							break;

						case 3:                               // 6
							e = (int) (Math.random() * 2) + 1;
							if (e == 1) {
								d = 3;
							}else {
								d = 9;
							}
							break;

						case 4:                               // 8
							e = (int) (Math.random() * 2) + 1;
							if (e == 1) {
								d = 7;
							}else {
								d = 9;
							}
							break;
					}
				}
				break;

			case 3:                                            //ia  = 2

				if(t[1][1] == 1){                              // rival tiene el centro, se debe bloquear si o si
					e = 0;
					int cont = 0;
					for(int i = 0; i < t.length; i++){
						for(int j = 0; j < t.length; j++){
							cont++;
							if(t[i][j] == 1 && cont != 5){
								e = cont;
							}
						}
					}
					switch (e){          // se revisara si no se dio una jugada al lado opuesto en que la ia jugo, si no se jugara defendiendo, de ser el caso se jugara buscando armar una linea
						case 1:
							d = 9;
							if(t[2][2] == 2){                                //compruebo si jugo en el opuesto a mi primer jugada
								e = (int) (Math.random() * 4) + 1;           //escojo una de las 4 opciones en donde podria formar una linea
								switch (e){
									case 1:
										d = 3;
										break;
									case 2:
										d = 6;
										break;
									case 3:
										d = 7;
										break;
									case 4:
										d = 8;
										break;
								}
							}
							break;

						case 2:
							d = 8;
							if(t[2][1] == 2){
								e = (int) (Math.random() * 2) + 1;
								switch (e){
									case 1:
										d = 7;
										break;
									case 2:
										d = 9;
										break;
								}
							}
							break;
						case 3:
							d = 7;
							if(t[2][0] == 2){
								e = (int) (Math.random() * 4) + 1;           //escojo una de las 4 opciones en donde podria formar una linea
								switch (e){
									case 1:
										d = 1;
										break;
									case 2:
										d = 4;
										break;
									case 3:
										d = 8;
										break;
									case 4:
										d = 9;
										break;
								}
							}
							break;
						case 4:
							d = 6;
							if(t[1][2] == 2){
								e = (int) (Math.random() * 2) + 1;
								switch (e){
									case 1:
										d = 3;
										break;
									case 2:
										d = 9;
										break;
								}
							}
							break;
						case 6:
							d = 4;
							if(t[1][0] == 2){
								e = (int) (Math.random() * 2) + 1;
								switch (e){
									case 1:
										d = 1;
										break;
									case 2:
										d = 7;
										break;
								}
							}
							break;
						case 7:
							d = 3;
							if(t[0][2] == 2){
								e = (int) (Math.random() * 4) + 1;           //escojo una de las 4 opciones en donde podria formar una linea
								switch (e){
									case 1:
										d = 1;
										break;
									case 2:
										d = 2;
										break;
									case 3:
										d = 6;
										break;
									case 4:
										d = 9;
										break;
								}
							}
							break;

						case 8:
							d = 2;
							if(t[0][1] == 2){
								e = (int) (Math.random() * 2) + 1;
								switch (e){
									case 1:
										d = 1;
										break;
									case 2:
										d = 3;
										break;
								}
							}
							break;
						case 9:
							d = 1;
							if(t[0][0] == 2){
								e = (int) (Math.random() * 4) + 1;           //escojo una de las 4 opciones en donde podria formar una linea
								switch (e){
									case 1:
										d = 2;
										break;
									case 2:
										d = 3;
										break;
									case 3:
										d = 4;
										break;
									case 4:
										d = 7;
										break;
								}
							}
							break;
					}

				}else{                                         // ia tiene el centro

						//terminar
				}

				break;

			case 4:                                            //ia = 1
				break;

			case 5:                                            //ia = 2
				break;

			case 6:                                            //ia = 1
				break;

			case 7:                                            //ia = 2
				break;

			case 8:                                            //ia = 1
				break;

			case 9:                                            //ia = 2
				break;

		}
		return d;
	}
}
