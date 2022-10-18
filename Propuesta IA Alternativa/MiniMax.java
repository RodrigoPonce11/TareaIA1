public class MiniMax
{
    public static <Move> double MinMax (Tablero<Move> Tablero, boolean SoyElMax, Marca JugadorInicial, int ProfundidadMaxima)
    {
        //SoyElMax es para saber si busco el Max o el Mini. Si soy el Max entonces busco los Maximos para ganar.
        //Caso Inicial
        if (Tablero.HaGanado() || Tablero.EsEmpate() || ProfundidadMaxima == 0)
        {
            return Tablero.Evaluar(JugadorInicial);
        }

        //Implementación Recursiva de Minimax
        if (SoyElMax) //Soy el Max.
        {
            double v = Double.NEGATIVE_INFINITY; //Es la mejor de las Evaluaciones para Maximizar.

            for (Move Movimiento : Tablero.getLegalMoves())
            {
                //Evaluo a partir del Siguiente Movimiento Hipotetico, todo esto es "Predecir", Anticiparse. Tomo el Lugar del Otro.
                //De manera Hipotetica, asi que ahora soy el Minimizador, por eso el segundo parametro es False.
                double Resultado = MinMax (Tablero.Movimiento(Movimiento), false, JugadorInicial, ProfundidadMaxima -1);
                //ProfundiadMaxima -1 pues estoy bajando en el Arbol de Posibilidades en Profunidad.

                v = Math.max(v, Resultado); //v es ahora el Maximo entre NegInfinite y el Resultado.
            }
            return v;
        }
        else //Soy el Min, debo minimizar.
        {
            double v = Double.POSITIVE_INFINITY; //Es la mejor de las Evaluaciones para Minimizar.

            for (Move Movimiento : Tablero.getLegalMoves())
            {
                //Evaluo a partir del Siguiente Movimiento Hipotetico, todo esto es "Predecir", Anticiparse. Tomo el Lugar del Otro.
                //De manera Hipotetica, asi que ahora soy el Max, por eso el segundo parametro es ahora; True.
                double Resultado = MinMax (Tablero.Movimiento(Movimiento), true, JugadorInicial, ProfundidadMaxima -1);
                //ProfundiadMaxima -1 pues estoy bajando en el Arbol de Posibilidades en Profunidad.

                v = Math.min(v, Resultado); //v es ahora el Minimo entre PosInfinite y el Resultado.
            }
            return v;
        }
    }

    public static <Move> Move EncontrarElMejorMovimientoClaroQueSi (Tablero <Move> Tablero, int ProfundiadMaxima)
    {
        double MejorValor = Double.NEGATIVE_INFINITY; //EL mejor movimiento del Adversario, oh no.

        Move MejorMovimiento = null; //Aun no tengo un Mejor Movimiento.

        for (Move Movimiento : Tablero.getLegalMoves()) //Itera Hipoteticos movimientos.
        {
            //Ejecuta MiniMax con el Oponente, por eso NO es el Max.
            double Resultado = MinMax (Tablero.Movimiento(Movimiento), false, Tablero.ObtenerTurno(), ProfundiadMaxima);

            if (Resultado > MejorValor) //Oh, he encontrado el mejor Resultado. 
            {                           //El Mejor Movimiento es el que, entre todos, dio el mejor resultado en esto.
                MejorValor = Resultado;
                MejorMovimiento = Movimiento;
            }
        }

        return MejorMovimiento;
    }

    //Para IA vs IA, implementar Encontrar Mejor Movimiento para IA 2, la cual buscara el Min.
    public static <Move> Move EncontrarElMejorMovimientoClaroQueSiIAAlter (Tablero <Move> Tablero, int ProfundiadMaxima)
    {
        double MejorValor = Double.NEGATIVE_INFINITY; //EL mejor movimiento del Adversario, oh no.

        Move MejorMovimiento = null; //Aun no tengo un Mejor Movimiento.

        for (Move Movimiento : Tablero.getLegalMoves()) //Itera Hipoteticos movimientos.
        {
            //Ejecuta MiniMax con el Oponente, por eso ES el Max.
            double Resultado = MinMax (Tablero.Movimiento(Movimiento), false, Tablero.ObtenerTurno(), ProfundiadMaxima);

            if (Resultado > MejorValor) //Oh, he encontrado el mejor Resultado. 
            {                           //El Mejor Movimiento es el que, entre todos, dio el mejor resultado en esto.
                MejorValor = Resultado;
                MejorMovimiento = Movimiento;
            }
        }

        return MejorMovimiento;
    }
}