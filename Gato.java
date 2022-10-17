public class Gato
{
    public Gato ()
    {
        
        
    }

    public void start (IA ia1, IA ia2)
    {
        //Generación de Tablero.
        int[][] tablero = new int [3][3];
        for (int i = 0; i<tablero.length ; i++)
        {
            for (int j = 0; j<tablero.length ; j++)
            {
            	tablero[i][j] = 0;
            }
        }

        //Inicio del Juego. Se iran pasando el mismo tablero e iran tomando las desiciones en base a eso.
        while(juegoTerminado (tablero) == false)
        {
            ia1.jugar(tablero);
            ia2.jugar(tablero);
        }
    }

    public boolean juegoTerminado (int [][] tablero)
    {
        //Ir revisando el Tablero para ver si se ha completado el Juego.
        return false;
    }
}