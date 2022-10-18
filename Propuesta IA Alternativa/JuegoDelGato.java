import java.util.*;

public class JuegoDelGato 
{
    private Scanner Teclado = new Scanner (System.in);
    private GatoTablero Tablero = new GatoTablero();
    
    public JuegoDelGato ()
    {

    }

    public Integer ObtenerMovimientoDelJugador ()
    {
        Integer Movimiento = -1;

        while (!Tablero.getLegalMoves().contains(Movimiento)) //Mientras hayan Movimientos Legales, se ha de seguir ejecutando.
        {
            System.out.print ("Ingrese el Numero de Casilla del 0 al 8 donde desea colocar su Marca: ");
            Movimiento = Teclado.nextInt();
        }
        
        return Movimiento;
    }

    public void JugarGato ()
    {
        while (true)
        {
            //Movimiento del Jugador.
            Integer MovimientoDelJugador = ObtenerMovimientoDelJugador();
            Tablero = (GatoTablero) Tablero.Movimiento(MovimientoDelJugador);

            System.out.println (Tablero);

            if (Tablero.HaGanado())
            {
                System.out.println ("Jugador ha ganado a la IA.");
                break;
            }
            else if (Tablero.EsEmpate())
            {
                System.out.println ("Empate.");
                break;
            }
            //Movimiento de la IA.
            Integer MovimientoDeLaIA = MiniMax.EncontrarElMejorMovimientoClaroQueSi (Tablero, 9);
            Tablero = (GatoTablero) Tablero.Movimiento(MovimientoDeLaIA);

            System.out.println (Tablero);

            if (Tablero.HaGanado())
            {
                System.out.println ("IA ha ganado al Jugador.");
                break;
            }
            else if (Tablero.EsEmpate())
            {
                System.out.println ("Empate.");
                break;
            }
        }
    }    
}
