/**
 * classe Carro che gestisce il singolo carroarmato
 */
public class Carro {
    public String letteraCarro = "";
    public String urlCarro = "";
    public int xGiocatore;
    public int yGiocatore;
    public Carro(String _urlCarro, String _letteraCarro, int xIniziale, int yIniziale) {
        this.urlCarro = _urlCarro;
        this.xGiocatore = xIniziale;
        this.yGiocatore = yIniziale;
        this.letteraCarro = _letteraCarro;
    }
}
