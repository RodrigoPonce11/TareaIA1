public enum GatoMarca implements Marca //Es un Enum para implementar las Categorias X-O-V. Es mas seguro que una Variable.
{
    X, O, V; //Valors posibles: X | O | V [Vacio].

    @Override
    public String toString()
    {
        switch (this)
        {
            case X:
                return "X";
            case O:
                return "O";
            default: //Caso por defecto, retorna Casilla Vacia.
                return " ";
        }
    }

    @Override
    public GatoMarca Opuesto() //Esto cambia la Marca que se esta jugando en tiempo real, es decir; si jugo la X ahora cambia a O.
    {
        switch (this)
        {
            case X: //Si el jugador tiene el valor X el siguiente turno toma el valor O.
                return O;
            case O: //Si el jugador tiene el valor O el siguiente turno toma el valor X.
                return X;
            default:
                return V;
        }
    }
}