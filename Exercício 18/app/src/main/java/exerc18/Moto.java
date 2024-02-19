package exerc18;

public class Moto extends Automovel implements Transportavel{

    public Moto(int velMax) {
        super(2, velMax);
    }
    
    public Moto() {
        super(2, 160);
    }
}
