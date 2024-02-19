package exerc17;

import java.util.ArrayList;
import java.util.List;

public class Arvore {
    
    private Pessoa filho;

    public Arvore(Pessoa filho) {
        this.filho = filho;
    }
    
    public List<Pessoa> buscarPorRelativoDeHierarquiaN(int n){
        List<Pessoa> nAvos = new ArrayList<>();
        buscarPorRelativoDeHierarquiaNRecursivo(filho, n, nAvos);
        return nAvos;
    }

    private void buscarPorRelativoDeHierarquiaNRecursivo(Pessoa atual, int n, List<Pessoa> nAvos) {
        if (atual == null || n < 0) {
            return;
        }

        if (n == 0) {
            nAvos.add(atual);
            return;
        }

        buscarPorRelativoDeHierarquiaNRecursivo(atual.getMae(), n - 1, nAvos);
        buscarPorRelativoDeHierarquiaNRecursivo(atual.getPai(), n - 1, nAvos);
    }
}
