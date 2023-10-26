import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//CLASSE PER LA GESTIONE DEL GIOCO DA PARTE DEL SERVER
//faccio un solo metodo per il disegna che ridisegna tutto
public class GestioneGioco {
    Blocco bl;
    public GestioneGioco() {
        bl = new Blocco();
    }
    public void disegnaSfondo(JFrame _objGrafica) {
        _objGrafica.setBounds(10, 10, 1000, 800); //dimesione frame
        _objGrafica.setTitle("Carri Armati 2D");
        _objGrafica.setResizable(false);
        _objGrafica.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Immagine di sfondo:
        ImageIcon imageIcon = new ImageIcon("images/sfondoCitta2.jpeg");
        Image image = imageIcon.getImage();

        int newWidth = 800; //larghezza immagine
        int newHeight = 800; //altezza immagine
        Image newImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

        ImageIcon newImageIcon = new ImageIcon(newImage);
        JLabel backgroundLabel = new JLabel(newImageIcon);
        
        //Pannello del punteggio:
        JPanel punteggioPanel = new JPanel();
        punteggioPanel.setLayout(new BorderLayout());
        punteggioPanel.setBackground(Color.BLACK);

        //titolo del pannello
        JLabel punteggioLabel = new JLabel("Punteggio");
        punteggioLabel.setForeground(Color.WHITE);

        punteggioPanel.add(punteggioLabel, BorderLayout.NORTH);

        Font titleFont = new Font("SansSerif", Font.BOLD, 24); // Cambia le dimensioni del font come preferisci
        punteggioLabel.setFont(titleFont);
        //aggiungo pannello e immagine di sfondo al frame
        _objGrafica.getContentPane().setLayout(new BorderLayout());
        _objGrafica.getContentPane().add(backgroundLabel, BorderLayout.CENTER);
        _objGrafica.getContentPane().add(punteggioPanel, BorderLayout.EAST);

        _objGrafica.pack();
        _objGrafica.setVisible(true);
    }
    //disegna il giocatore
    public void disegnaGiocatore() {

    }
    //controllo se il tank è colpito
    public void controllaSeColpito() {

    }
    //metodo principale che avvia il gioco 
    public void Gioca() {

    }
    //controllo le vite del player
    public void controllaVite() {

    }
    //controllo la posizione per validarla o meno
    public void controllaPosizione() {

    }
    //disegna la tabella delle informazioni come vite e punteggio
    public void disegnaTabellaInfo() {

    }
}
