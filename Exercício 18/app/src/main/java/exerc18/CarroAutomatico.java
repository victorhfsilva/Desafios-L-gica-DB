package exerc18;

public class CarroAutomatico extends Carro {

    private boolean freioPressionado;

    public CarroAutomatico(int velMax) {
        super(velMax);
    }
    
    public CarroAutomatico() {
        super(140);
    }

    public void ligar() {
        if(isFreioPressionado()) {
            setLigado(true);
            logger.info("O(a) " + this.getClass().getSimpleName() + " foi ligado.");
        } else {
            logger.warning("O carro não pode ser ligado com o freio despressionado.");
        }  
    }

    public boolean isFreioPressionado() {
        return this.freioPressionado;
    }

    public void pressionarFreio() {
        this.freioPressionado = true;
    }

    public void despressionarFreio() {
        this.freioPressionado = false;
    }

}
