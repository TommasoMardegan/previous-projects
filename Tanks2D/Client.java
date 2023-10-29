import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Client implements KeyListener{
    public String urlCarro = "";
    public int xGiocatore;
    public int yGiocatore;
    public Client(String _urlCarro, int xIniziale, int yIniziale) {
        //valori iniziali del carro
        this.urlCarro = _urlCarro;
        this.xGiocatore = xIniziale;
        this.yGiocatore = yIniziale;
    }
    //invia la richiesta al server
    public static void inviaRichiesta() {

    }
    //attende la risposta dal server
    public static void attendiRisposta() {
        
    }
    //gestisce i movimenti e gli spari
    private class listenerAzione  {	
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
    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
    }
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }
}

