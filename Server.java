import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;

import javax.swing.JFrame;


//SERVER JAVA CHE FA DA MAIN

//RISOLVI PROBLEMA DOMENICA
//ora disegna sia i blocchi che lo sfondo (guarda commento sotto)    V
//ma solo uno alla volta
//disegna carri iniziale  V
//disegna blocchi V

//RISOLVI LUNEDI
//movimento carro con action listener e implementa il repaint a intervalli regolari
public class Server { 
    final static int xInizialeCarro1 = 600;
    final static int yInizialeCarro1 = 550;
    final static int xInizialeCarro2 = 100;
    final static int yInizialeCarro2 = 550;
	public static void main(String[] args) throws IOException {
        Client carro1 = new Client("images/giocatore1_tank_up.png", xInizialeCarro1, yInizialeCarro1);
        Client carro2 = new Client("images/giocatore2_tank_up.png", xInizialeCarro2, yInizialeCarro2);

        JFrame objGrafica = new JFrame();
        GestioneGioco gc = new GestioneGioco();
        gc.addClientCarro(carro1);
        gc.addClientCarro(carro2);

        objGrafica.setBounds(10, 10, 800, 630);
		objGrafica.setTitle("Carri armati 2D");	
        objGrafica.setResizable(false);
		
		objGrafica.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		objGrafica.add(gc);
		objGrafica.setVisible(true);
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
