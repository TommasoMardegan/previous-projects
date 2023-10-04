import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

//classe ufficio
class Ufficio {
    private String nomeUfficio;
    private String piano;
    private String siglaLocale;
    private int numeroPostazioni;
    private String nomeResponsabileUfficio;
    private List<Dipendente> dipendenti = new ArrayList<>();

    public Ufficio(String nomeUfficio, String piano, String siglaLocale, int numeroPostazioni, String nomeResponsabileUfficio) {
        this.nomeUfficio = nomeUfficio;
        this.piano = piano;
        this.siglaLocale = siglaLocale;
        this.numeroPostazioni = numeroPostazioni;
        this.nomeResponsabileUfficio = nomeResponsabileUfficio;
    }
    //meotodo per aggiungere un dipendente all'ufficio
    public void aggiungiDipendente(Dipendente dipendente) {
        dipendenti.add(dipendente);
    }

    public String getNomeUfficio() {
        return nomeUfficio;
    }

    public void setNomeUfficio(String nomeUfficio) {
        this.nomeUfficio = nomeUfficio;
    }

    public String getPiano() {
        return piano;
    }

    public void setPiano(String piano) {
        this.piano = piano;
    }

    public String getSiglaLocale() {
        return siglaLocale;
    }

    public void setSiglaLocale(String siglaLocale) {
        this.siglaLocale = siglaLocale;
    }

    public String getNomeResponsabileUfficio() {
        return nomeResponsabileUfficio;
    }

    public void setNomeResponsabileUfficio(String nomeResponsabileUfficio) {
        this.nomeResponsabileUfficio = nomeResponsabileUfficio;
    }

    public List<Dipendente> getDipendenti() {
        return dipendenti;
    }

    public void setDipendenti(List<Dipendente> dipendenti) {
        this.dipendenti = dipendenti;
    }
    public int getNumeroPostazioni() {
        return this.numeroPostazioni;
    }
}