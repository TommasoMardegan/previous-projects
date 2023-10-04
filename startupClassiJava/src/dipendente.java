import java.io.BufferedReader;

//classe dipendente
class Dipendente {
    private String nome;
    private String cognome;
    private String indirizzoResidenza;
    private String dataNascita;
    private String dataAssunzione;
    private int oreSettimanali;
    private String ufficioAppartenenza;

    public Dipendente(String nome, String cognome, String indirizzoResidenza, String dataNascita, String dataAssunzione, int oreSettimanali, String ufficioAppartenenza) {
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzoResidenza = indirizzoResidenza;
        this.dataNascita = dataNascita;
        this.dataAssunzione = dataAssunzione;
        this.oreSettimanali = oreSettimanali;
        this.ufficioAppartenenza = ufficioAppartenenza;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getIndirizzoResidenza() {
        return indirizzoResidenza;
    }

    public void setIndirizzoResidenza(String indirizzoResidenza) {
        this.indirizzoResidenza = indirizzoResidenza;
    }

    public String getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getDataAssunzione() {
        return dataAssunzione;
    }

    public void setDataAssunzione(String dataAssunzione) {
        this.dataAssunzione = dataAssunzione;
    }

    public int getOreSettimanali() {
        return oreSettimanali;
    }

    public void setOreSettimanali(int oreSettimanali) {
        this.oreSettimanali = oreSettimanali;
    }
    public String getUfficioAppartenenza() {
        return this.ufficioAppartenenza;
    }
}