package exerc9;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    
    public static List<Integer> calcularSequencia(int maximum){
        ArrayList<Integer> sequencia = new ArrayList<>();
        sequencia.add(0);
        sequencia.add(1);

        int proximoValor = sequencia.get(1) + sequencia.get(0);

        while(proximoValor <= maximum){
            sequencia.add(proximoValor);

            int ultimoIndex = sequencia.size() - 1;
            proximoValor = sequencia.get(ultimoIndex) + sequencia.get(ultimoIndex - 1);
        }

        return sequencia;
    }

    public static String calcularSequenciaString(int maximum){

        List<Integer> sequencia = calcularSequencia(maximum);

        List<String> sequenciaString = sequencia.stream()
                                      .map(String::valueOf)
                                      .toList();

        return String.join(" ", sequenciaString);
    }

}
