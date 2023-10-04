import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        //uso la hashmap per memorizzare gli uffici
        Map<String, Ufficio> uffici = new HashMap<>();
        File file = new File("uffici.tsv");
        //controllo se il file esiste e in tal caso carico i dati dal file tsv (uso le tabulazioni)
        if(file.exists()) {
            caricaDipendentiDaFile(uffici, "uffici.tsv");
        }
        
        //visualizzo tutti gli uffici e dipendenti
        visualizzaUfficiEDipendenti(uffici);

        /*
         * creazione uffici
         * creazione dipendenti
         * assegnazioni dei dipendenti agli uffici
         */
        Dipendente dipendente1 = new Dipendente("Mario", "Rossi", "Via Roma 123", "01/01/1980", "01/01/2020", 40, "Vendite");
        Dipendente dipendente2 = new Dipendente("Anna", "Verdi", "Via Milano 456", "15/05/1990", "01/2018", 35, "Programmazione");
        Dipendente dipendente3 = new Dipendente("Francesco", "Totti", "Via Milano 456", "15/05/1990", "01/2018", 35, "Consulenza info.");
        Dipendente dipendente4 = new Dipendente("Luigi", "Capuana", "Via Milano 456", "15/05/1990", "01/2018", 35, "Consulenza info.");

        Ufficio ufficio1 = new Ufficio("Vendite", "Piano 1", "A1", 5, "Responsabile1");
        ufficio1.aggiungiDipendente(dipendente1);

        Ufficio ufficio2 = new Ufficio("Programmazione", "Piano 1", "A1", 20, "Responsabile1");
        ufficio2.aggiungiDipendente(dipendente2);

        Ufficio ufficio3 = new Ufficio("Consulenza info.", "Piano 1", "A1", 20, "Responsabile1");
        ufficio3.aggiungiDipendente(dipendente4);
        ufficio3.aggiungiDipendente(dipendente3);

        uffici.put(ufficio1.getNomeUfficio(), ufficio1);
        uffici.put(ufficio2.getNomeUfficio(), ufficio2);
        uffici.put(ufficio3.getNomeUfficio(), ufficio3);
        //scrivo su file i nuovi dati
        try (PrintWriter writer = new PrintWriter(new FileWriter("uffici.tsv", true))) {
            //scorro tutti gli uffici
            for (Ufficio ufficio : uffici.values()) {
                //scrivo l'ufficio
                writer.println("Ufficio\t" + ufficio.getPiano() + "\t" + ufficio.getNumeroPostazioni() + "\t" + ufficio.getNomeUfficio() + "\t" + ufficio.getSiglaLocale() + "\t" + ufficio.getNomeResponsabileUfficio());
                //scrivo i dipendenti
                for (Dipendente dip : ufficio.getDipendenti()) {
                     writer.println("Dipendente\t" + dip.getDataNascita() + "\t" + dip.getDataAssunzione() + "\t" + dip.getOreSettimanali() + "\t" + dip.getNome() + "\t" + dip.getCognome() + "\t" + dip.getIndirizzoResidenza() + "\t" + dip.getUfficioAppartenenza());
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //visualizzo nella console tutti gli uffici con i rispettivi dipendenti
    public static void visualizzaUfficiEDipendenti(Map<String, Ufficio> uffici) {
        //scorro tutti gli uffici (prendendo i valori della hashmap)
        for (Ufficio ufficio : uffici.values()) {
            System.out.println("Ufficio:");
            System.out.println("Nome: " + ufficio.getNomeUfficio());
            System.out.println("Piano: " + ufficio.getPiano());
            System.out.println("Sigla Locale: " + ufficio.getSiglaLocale());
            System.out.println("Numero postazioni: " + ufficio.getNumeroPostazioni());
            System.out.println("Responsabile: " + ufficio.getNomeResponsabileUfficio());
            //visualizzo i dipendenti dell'ufficio
            System.out.println("Dipendenti:" + "\n");
            for (Dipendente dip : ufficio.getDipendenti()) {
                System.out.println("Nome: " + dip.getNome());
                System.out.println("Cognome: " + dip.getCognome());
                System.out.println("Data di Nascita: " + dip.getDataNascita());
                System.out.println("Data di Assunzione: " + dip.getDataAssunzione());
                System.out.println("Indirizzo Residenza: " + dip.getIndirizzoResidenza());
                System.out.println("Ore Settimanali: " + dip.getOreSettimanali());
                System.out.println("Ufficio appartenenza: " + dip.getUfficioAppartenenza() + "\n");
            }
        }
    }

    //carico i dati da file sul programma
    public static void caricaDipendentiDaFile(Map<String, Ufficio> uffici, String nomeFile) {
        //leggo il file
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeFile))) {
            String line;
            Ufficio ufficioCorrente = null;

            //se la linea esiste allora splitto per il tab
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                //controllo sulla lunghezza del vettore ottenuto sulla split
                if (parts.length < 2) {
                    continue;
                }

                //ottengo se si tratta di un ufficio o diepndente
                String tipo = parts[0];

                if (tipo.equals("Ufficio")) {  
                    //se ho un ufficio lo inserisco nella hashmap con chiave e oggetto
                    if (ufficioCorrente != null) {
                        //non ci sono duplicati perchè la chiave è il nome
                        uffici.put(ufficioCorrente.getNomeUfficio(), ufficioCorrente);
                    }
                    //ottengo i dati dell'ufficio corrente 
                    String piano = parts[1];
                    int numeroPostazioni = Integer.parseInt(parts[2]);
                    String nomeUfficio = parts[3];
                    String siglaLocale = parts[4];
                    String nomeResponsabileUfficio = parts[5];
                    //ufficio.getPiano() + "\t" + ufficio.getNumeroPostazioni() + "\t" + ufficio.getNomeUfficio() + "\t" + ufficio.getSiglaLocale() + "\t" + ufficio.getNomeResponsabileUfficio()
                    ufficioCorrente = new Ufficio(nomeUfficio, piano, siglaLocale, numeroPostazioni, nomeResponsabileUfficio);
                //faccio la stessa cosa per il dipendete aggiungendolo al suo ufficio
                } else if (tipo.equals("Dipendente") && ufficioCorrente != null) {
                    //ottengo i dati
                    String dataNascita = parts[1];
                    String dataAssunzione = parts[2];
                    int oreSettimanali = Integer.parseInt(parts[3]);
                    String nome = parts[4];
                    String cognome = parts[5];
                    String indirizzoResidenza = parts[6];
                    String ufficioAppartenenza = parts[7];
                    //creo il dipendente
                    Dipendente dipendente = new Dipendente(nome, cognome, dataNascita, dataAssunzione, indirizzoResidenza, oreSettimanali, ufficioAppartenenza);
                    //lo aggiungo all'ufficio
                    ufficioCorrente.aggiungiDipendente(dipendente);
                }
            }
            if (ufficioCorrente != null) {
                uffici.put(ufficioCorrente.getNomeUfficio(), ufficioCorrente);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}