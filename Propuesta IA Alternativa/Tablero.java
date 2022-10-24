import java.util.*;

public interface Tablero <Move> 
{
    Marca ObtenerTurno();

    Tablero <Move> Movimiento (Move Localizacion); //Realiza una Marca en la Localizacion.

    List <Move> MovimientosPermitidos(); //Obtener los Movimientos Posibles.

    boolean HaGanado();

    default boolean EsEmpate()
    {
        return !HaGanado() && MovimientosPermitidos().isEmpty(); //No hay movimientos posibles y nadie ha ganado; es Empate.
    };

    double Evaluar (Marca Jugador);
}
