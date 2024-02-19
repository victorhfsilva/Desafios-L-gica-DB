package exerc18;

public class MotoPartidaPedal extends Moto {
    
    private boolean aceleradorPuxado;

    public MotoPartidaPedal(int velMax) {
        super(velMax);
    }

    public void ligar() {
        if(isAceleradorPuxado()) {
            setLigado(true);
            logger.info("O(a) " + this.getClass().getSimpleName() + " foi ligado.");
        } else {
            logger.warning("A moto não pode ser ligada sem antes puxar o acelerador.");
        }
        
    }

    public boolean isAceleradorPuxado() {
        return this.aceleradorPuxado;
    }

    public void puxarAcelerador() {
        this.aceleradorPuxado = true;
    }

    public void despuxarAcelerador() {
        this.aceleradorPuxado = false;
    }
    
}
