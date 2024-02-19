package exerc16.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import exerc16.exceptions.EntidadeNaoEncontrada;
import exerc16.model.Emprestimo;
import exerc16.model.Livro;

public class EmprestimosRepositorio {

    private List<Emprestimo> emprestimos = new ArrayList<>();

    public void adicionar(Emprestimo emprestimo){
        emprestimos.add(emprestimo);
    }

    public void editar(int index, Emprestimo emprestimo){
        emprestimos.set(index, emprestimo);
    }

    public void remover(Emprestimo emprestimo){
        emprestimos.remove(emprestimo);
    }

    public int getIndex(Emprestimo emprestimo){
        return emprestimos.indexOf(emprestimo);
    }

    public Emprestimo getEmprestimo(Livro livro) throws EntidadeNaoEncontrada{
        Optional<Emprestimo> emprestimo = emprestimos
                                        .stream()
                                        .filter(e -> e.getLivro().equals(livro))
                                        .findFirst();
        if(emprestimo.isPresent()) {
            return emprestimo.get();
        } else {
            throw new EntidadeNaoEncontrada("Emprestimo nao foi encotrado.");
        }
    }

    public boolean contains(Emprestimo emprestimo){
        return emprestimos.contains(emprestimo);
    }
}
