import java.util.*;
import java.util.List;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import java.awt.*;

import javax.swing.*;
import javax.swing.Timer;

//CLASSE PER LA GESTIONE DEL GIOCO DA PARTE DEL SERVER
//faccio un solo metodo per il disegna che ridisegna tutto
public class GestioneGioco extends JPanel {
    gestioneBlocchi gestioneBl;
    List<Client> listaCarri;
    final static int WIDTH_PUNTEGGIO = 140;
    final static int HEIGH_PUNTEGGIO = 600;
    final static int X_TITOLO = 655;
    final static int Y_TITOLO = 30;
    public GestioneGioco() throws IOException { 
        gestioneBl = new gestioneBlocchi();
		setFocusable(true);
        this.listaCarri = new ArrayList();
    } 
    public void addClientCarro(Client clientCarro) {
        this.listaCarri.add(clientCarro);
    }
    //disegno lo sfondo usando il parametro graphics 
    public void disegnaSfondoGraphics(Graphics g) { 
        //immagine di sfondo
        ImageIcon imageIcon = new ImageIcon("images/sfondoCitta3.png");
        Image sfondo = imageIcon.getImage();
        g.drawImage(sfondo, 0, 0, getWidth(), getHeight(), this);
    
        //pannello del punteggio
        g.setColor(Color.GRAY);
        g.fillRect(650, 0, WIDTH_PUNTEGGIO, HEIGH_PUNTEGGIO);
    
        //titolo del pannello del punteggio
        g.setColor(Color.BLACK); 
        g.setFont(new Font("Arial", Font.BOLD, 16)); 
        String titolo = "Punteggio e vite";
        g.drawString(titolo, X_TITOLO, Y_TITOLO);
    }

    //per adesso senza keylistener o timer è richiamato una sola volta
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            disegnaSfondoGraphics(g);
            disegnaBlocchi(g);
            disegnaGiocatori(g);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //disegna il giocatore
    public void disegnaGiocatori(Graphics g) {
        for (Client clientCarro : listaCarri) {
            ImageIcon giocatore= new ImageIcon(clientCarro.urlCarro);
            giocatore.paintIcon(this, g, clientCarro.xGiocatore, clientCarro.yGiocatore);
        }
    }
    public void disegnaBlocchi(Graphics g) throws IOException {
        //disegno i blocchi
		gestioneBl.disegna(this, g);
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



    /* 
    public void disegnaSfondo(JFrame _objGrafica) throws IOException {
        _objGrafica.setBounds(10, 10, 1000, 800); //dimesione frame
        _objGrafica.setTitle("Carri Armati 2D");
        _objGrafica.setResizable(false);
        _objGrafica.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // draw solid bricks

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

        Font titleFont = new Font("SansSerif", Font.BOLD, 24); 
        punteggioLabel.setFont(titleFont);
        //aggiungo pannello e immagine di sfondo al frame
        _objGrafica.getContentPane().setLayout(new BorderLayout());
        _objGrafica.getContentPane().add(backgroundLabel, BorderLayout.CENTER);
        _objGrafica.getContentPane().add(punteggioPanel, BorderLayout.EAST);

        _objGrafica.pack();
        _objGrafica.setVisible(true);
    }*/