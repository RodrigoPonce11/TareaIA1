public class JuegoDelGatoIAvsIA
{
    private GatoTablero Tablero = new GatoTablero();
    
    public JuegoDelGatoIAvsIA ()
    {

    }

    public void JugarGato ()
    {
        while (true)
        {
            //Movimiento de la IA1.
            Integer MovimientoDeLaIA1 = MiniMax.EncontrarElMejorMovimientoClaroQueSi (Tablero, 9);
            Tablero = (GatoTablero) Tablero.Movimiento(MovimientoDeLaIA1);

            System.out.println("Movimiento de la IA1:");
            System.out.println (Tablero);

            if (Tablero.HaGanado())
            {
                System.out.println ("IA1 ha ganado.");
                break;
            }
            else if (Tablero.EsEmpate())
            {
                System.out.println ("Empate.");
                break;
            }
            //Movimiento de la IA2.
            Integer MovimientoDeLaIA2 = MiniMax.EncontrarElMejorMovimientoClaroQueSi (Tablero, 9);
            Tablero = (GatoTablero) Tablero.Movimiento(MovimientoDeLaIA2);

            System.out.println("Movimiento de la IA2:");
            System.out.println (Tablero);

            if (Tablero.HaGanado())
            {
                System.out.println ("IA2 ha ganado.");
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