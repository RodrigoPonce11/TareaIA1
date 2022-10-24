public class Main
{    
    public static void main (String [] args)
    {
        //TEST II [Desarrollo | No experimental, aun] - CONTRA UN USUARIO HUMANO
        //JuegoDelGatoIAvsUsuario Gato = new JuegoDelGatoIAvsUsuario ();
        //Gato.JugarGato();

        //TEST III [Desarrollo | No experimental, aun] - IA VS IA
        //JuegoDelGatoIAvsIA Gato2 = new JuegoDelGatoIAvsIA ();
        //Gato2.JugarGato();


        /*Por que cuando es Agente vs Agente debe jugar siempre con la funcion que Maximiza y no Max vs Min? 

            Esto es debido a que solo existe una Instancia de Agente presente en este Programa, por lo que si se hace un Max vs Min
            con una Función Reflejo de "ObtenerElMejorMovimientoClaroQueSi" una optara por tomar los PEORES Movimientos para si
            misma.*/
    }
}