package exerc7;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    
    public static List<Integer> calcularSequencia(int size){
        ArrayList<Integer> sequencia = new ArrayList<>();
        sequencia.add(0);
        sequencia.add(1);

        for (int i= 0; i<size-1; i++){
            int ultimoIndex = sequencia.size() - 1;
            int proximoValor = sequencia.get(ultimoIndex) + sequencia.get(ultimoIndex - 1);
            sequencia.add(proximoValor);
        }
        return sequencia;
    }

    public static String calcularSequenciaString(int size){

        List<Integer> sequencia = calcularSequencia(size);

        List<String> sequenciaString = sequencia.stream()
                                      .map(String::valueOf)
                                      .toList();

        return String.join(" ", sequenciaString);
    }

}
