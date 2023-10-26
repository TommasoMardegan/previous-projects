import java.awt.Color;

import javax.swing.JFrame;


//SERVER JAVA CHE FA DA MAIN
public class Server {
	public static void main(String[] args) {
        //creo il frame per la grafica
		JFrame objGrafica =new JFrame();
		GestioneGioco gc = new GestioneGioco();
        gc.disegnaSfondo(objGrafica);
	}
    //invio la risposta al client
    public static void inviaRisposta() {

    }
    //ricevo la richiesta dal client
    public static void riceviRichiesta() {

    }
    //public void valido l'operazione client
    public void validaOperazione() {

    }
}
