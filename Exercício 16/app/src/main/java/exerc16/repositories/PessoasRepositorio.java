package exerc16.repositories;

import java.util.ArrayList;
import java.util.List;

import exerc16.exceptions.EntidadeNaoEncontrada;
import exerc16.model.Pessoa;

public class PessoasRepositorio {
    
    private List<Pessoa> pessoas = new ArrayList<>();

    public void adicionar(Pessoa pessoa){
        pessoas.add(pessoa);
    }

    public void editar(int index, Pessoa pessoa){
        pessoas.set(index, pessoa);
    }

    public void remover(Pessoa pessoa) throws EntidadeNaoEncontrada{
        if (pessoas.contains(pessoa)) {
            pessoas.remove(pessoa);
        } else {
            throw new EntidadeNaoEncontrada("Pessoa não foi encontrada no repositório");
        }
        
    }

    public int getIndex(Pessoa pessoa){
        return pessoas.indexOf(pessoa);
    }

    public boolean contains(Pessoa pessoa){
        return pessoas.contains(pessoa);
    }
}
