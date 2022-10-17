public class Main
{
    public static void main (String [] args)
    {
        IA ia1 = new IA ();
        IA ia2 = new IA ();

        Gato gato = new Gato();

        gato.start(ia1, ia2); 
    }
}
