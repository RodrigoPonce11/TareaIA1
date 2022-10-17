public class Gato
{
    public Gato ()
    {
        
        
    }

    public void Start (IA IA_1, IA IA_2)
    {
        //Generación de Tablero.
        int[][] Tablero = new int [3][3];
        for (int i = 0; i<Tablero.length ; i++)
        {
            for (int j = 0; j<Tablero.length ; j++)
            {
            	Tablero[i][j] = 0;
            }
        }

        //Inicio del Juego. Se iran pasando el mismo tablero e iran tomando las desiciones en base a eso.
        //While NINGUNO HA GANADO || NO SE HA CONCRETADO UN EMPATE
        IA_1.ia(Tablero); //Para que esto funcione correctamente se debe quitar el STATIC de la funcion actualmente llamada "ia"
        IA_2.ia(Tablero);
        //END WHILE
    }
}