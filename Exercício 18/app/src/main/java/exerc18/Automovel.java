package exerc18;

import java.util.logging.Logger;

public class Automovel {
    private int numRodas;
    private int velMax;
    private boolean ligado;
    protected Logger logger = Logger.getLogger(Automovel.class.getName());

    public Automovel(int numRodas, int velMax) {
        this.numRodas = numRodas;
        this.velMax = velMax;
        this.ligado = false;
    }

    public void ligar() {
        setLigado(true);
        logger.info("O(a) " + this.getClass().getSimpleName() + " foi ligado.");
    }

    public void desligar() {
        setLigado(false);
        logger.info("O(a) " + this.getClass().getSimpleName() + " foi desligado.");
    }

    public int getNumRodas() {
        return this.numRodas;
    }

    public void setNumRodas(int numRodas) {
        this.numRodas = numRodas;
    }

    public int getVelMax() {
        return this.velMax;
    }

    public void setVelMax(int velMax) {
        this.velMax = velMax;
    }

    public boolean isLigado() {
        return this.ligado;
    }

    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

}
