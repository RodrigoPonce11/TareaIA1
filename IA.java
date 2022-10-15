
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
		
	    	case 1 :                                             //ia = 2
	    		
	    		if(t[1][1] == 1) {
	    			int e = (int)(Math.random() * 4)+1;
	    			switch(e) {
	    			
		    			case 1: d = 1;
		    					break;
		    					
		    			case 2: d = 3;
		    					break;
		    					
		    			case 3: d = 7;
		    					break;
		    					
		    			case 4: d = 9;
		    					break;
		    					
		    		}
	    		}else {
	    			d = 5;
	    		}
	    		break;
	    		
	    	case 2 :                                            //ia = 1
	    		break;
	    		
	    	case 3 :                                            //ia  = 2
	    		break;
	    		
	    	case 4 :                                            //ia = 1
	    		break;
	    		
	    	case 5 :      										//ia = 2                           
	    		break;
	    		
	    	case 6 :											//ia = 1
	    		break;
	    		
	    	case 7 :											//ia = 2
	    		break;
	    		
	    	case 8 :											//ia = 1
	    		break;
	    		
	    	case 9 :											//ia = 2
	    		break;
	    		
		}
		return d;
	}
}
