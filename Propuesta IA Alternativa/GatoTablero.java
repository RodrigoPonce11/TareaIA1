import java.util.*;

public class GatoTablero implements Tablero <Integer>
{
    private static final int NumeroCasillas = 9; //Constante definida de numero de Casillas.
    
    private GatoMarca[] Posicion;

    private GatoMarca Turno;

    GatoTablero () //Constructor sin Parametros.
    {
        Posicion = new GatoMarca[NumeroCasillas];
        Turno = GatoMarca.X;

        //Llenar con Casillas Vacias el Tablero
        Arrays.fill(Posicion, GatoMarca.V);
    }

    GatoTablero (GatoMarca[] Posicion, GatoMarca Turno) //Constructor con Parametros.
    {
        this.Posicion = Posicion;
        this.Turno = Turno;
    }

    @Override //Override es por el Header [Interface].
    public Marca ObtenerTurno ()
    {
        return this.Turno;
    }

    @Override
    public Tablero <Integer> Movimiento (Integer Localizacion) //Como se hace un Movimiento. Copia el Tablero para c/Jugada.
    {
        GatoMarca[] TempPosicion = Arrays.copyOf(Posicion, Posicion.length);
        TempPosicion[Localizacion] = Turno;

        return new GatoTablero(TempPosicion, Turno.Opuesto()); //Con c/Movimiento se modifica una Copia del Tablero. 
                                                               //Retorna listo para el otro Jugador con la otra Marca.
    }

    @Override
    public List <Integer> MovimientosPermitidos () //Movimientos Legales en el Tablero
    {
        var MovimientosLegales = new ArrayList<Integer>();
        //Todas aquellas Casillas aun Vacias son Legales.
        for (int i = 0; i < Posicion.length; i++) //Recorre el Tablero.
        {
            if (Posicion[i] == GatoMarca.V) //Pregunta si la Casilla en el Tablero esta Vacia.
            {
                MovimientosLegales.add(i); //Añade a la Casilla Disponible como un Movimiento Legal.
            }
        }
        
        return MovimientosLegales;
    }

    @Override
    public boolean HaGanado () //Utiliza a RevisarLinea. Verifica si ha ganado.
    {
        return RevisarLinea (0, 1, 2) || RevisarLinea (3, 4, 5) || RevisarLinea (6, 7, 8) ||
               RevisarLinea (0, 3, 6) || RevisarLinea (1, 4, 7) || RevisarLinea (2, 5, 8) ||
               RevisarLinea (0, 4, 8) || RevisarLinea (2, 4, 6); 
               //Revisa si hay una Victoria en c/Linea o Diagonal Posible.
               
    }

   
    public boolean RevisarLinea (int C1, int C2, int C3) //Revisa si hay 3 Marcas iguales en 3 Posiciones.
    {
        return Posicion[C1] == Posicion[C2] && Posicion[C2] == Posicion [C3] //Retorna True o False si son o no las 3 iguales.
               && Posicion[C1] != GatoMarca.V; //Asegurarse de que NO son Casillas Vacias.
    }

    @Override
    public double Evaluar (Marca Jugador) //Evalua desde el punto de vista de la IA si es Ganadora, Perdedora o Empate.
    {
        if (HaGanado() && Turno == Jugador) //Si hay Victoria presente y el Turno corresponde al Oponente.
        {
            return -1;
        }
        else if (HaGanado() && Turno != Jugador) //Si hay Victoria presente y el Turno corresponde a mi [Siendo yo la IA].
        {
            return 1;
        }
        else
        {
            return 0; //Empate, retorna 0.
        }
    }

    @Override
    public String toString () //Para Imprimir el Tablero.
    {
        StringBuilder SB = new StringBuilder(); //Tipo de Dato que es un String Modificable.

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                SB.append(Posicion [i * 3 + j].toString()); //Mediante el SB se construlle el Tablero como Matriz operando I como Fila y J como Col.
                //Para mejor visualizacion en Consola, ver si es Fila/Col Par para asi decidir si debe tener Linea Divisiora.
                if (j != 2) //Si la Columna es DISTINTA de 2; dibujar Linea Divisora.
                {
                    SB.append("|");
                }
            }
            //Separar las Lineas cuando se muestren, asi se ve como una Matriz. Usar Separador del Sistema Operativo.
            SB.append(System.lineSeparator());
            if (i != 2) //Si la Fila es DISTINTA de 2; dibujar Linea Divisora.
            {
                SB.append("-----");
                SB.append(System.lineSeparator());
            }
        }

        return SB.toString();
    }
}