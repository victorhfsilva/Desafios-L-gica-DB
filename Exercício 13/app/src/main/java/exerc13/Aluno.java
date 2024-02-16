package exerc13;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
public class Aluno {
    private String nome;

    private List<Double> notas;
    
    public Aluno(String nome, List<Double> notas) throws ExcecaoParametroInvalido {
        this.nome = nome;
        this.notas = notas;

        boolean notasSaoValidas = notas.stream().filter(nota -> nota < 0 || nota > 10).toList().isEmpty();
    
        if(!notasSaoValidas) {
            throw new ExcecaoParametroInvalido("Nota Invalida");
        }
    }

    public Aluno(String nome) {
        this.nome = nome;
        this.notas = new ArrayList<>();
    }

    public void insertNota(double nota) throws ExcecaoParametroInvalido {
        if (nota >= 0 && nota <= 10) {
            notas.add(nota);
        } else {
            throw new ExcecaoParametroInvalido("Nota Invalida");
        }
        
    }

    public double getMedia() {
        return notas.stream().reduce(0.0, Double::sum)/notas.size();
    }

    public Status getStatus() {
        double media = getMedia();
        if(media > 6.0) return Status.APROVADO;
        if(media >= 4 && media <= 6.0) return Status.VERIFICACAO_SUPLEMENTAR;
        else return Status.REPROVADO;
    }
    
}
