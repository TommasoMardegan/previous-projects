import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Client {
    public int xGiocatore;
    public int yGiocatore;
    public Client() {

    }

    //invia la richiesta al server
    public static void inviaRichiesta() {

    }
    //attende la risposta dal server
    public static void attendiRisposta() {
        
    }
    //gestisce i movimenti e gli spari
    private class listenerAzione implements KeyListener {	
        //controllo il tasto premuto
		public void keyPressed(KeyEvent e) {
            if(e.getKeyCode()== KeyEvent.VK_M)
            {
            }
            if(e.getKeyCode()== KeyEvent.VK_W)
            {
            }
            if(e.getKeyCode()== KeyEvent.VK_S)
            {
            }
            if(e.getKeyCode()== KeyEvent.VK_A)
            {
            }
            if(e.getKeyCode()== KeyEvent.VK_D)
            {
            }
        }
        public void keyTyped(KeyEvent e) {}
		public void keyReleased(KeyEvent e) {}		
    }
}

