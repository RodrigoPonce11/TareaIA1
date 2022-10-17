public class Main
{
    public static void main (String [] args)
    {
        IA IA_1 = new IA ();
        IA IA_2 = new IA ();

        Gato Gato = new Gato();

        Gato.Start(IA_1, IA_2); 
    }
}
