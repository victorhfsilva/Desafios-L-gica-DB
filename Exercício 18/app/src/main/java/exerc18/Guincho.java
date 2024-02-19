package exerc18;

public class Guincho extends Automovel {

    public Guincho(int velMax) {
        super(4, velMax);
    }
    
    public Guincho() {
        super(4, 140); 
    }
    
    public void carregar(Transportavel automovel){
        logger.info("O Guincho esta carregando o(a) " + automovel.getClass().getName() +".");
    }
}
