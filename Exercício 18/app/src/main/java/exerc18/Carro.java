package exerc18;

public class Carro extends Automovel implements Transportavel{

    public Carro(int velMax) {
        super(4, velMax);
    }

    public Carro() {
        super(4, 180);
    }

}
