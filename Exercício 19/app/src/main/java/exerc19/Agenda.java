package exerc19;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Agenda {
    
    private List<Contato> contatos = new ArrayList<>();

    public List<Contato> getContatos() {
        return this.contatos;
    }

    public Contato getByNome(String nome) throws EntidadeNaoEncontrada{
        Optional<Contato> contato = contatos.stream().filter(e -> e.getNome().equals(nome)).findFirst();
        if (contato.isPresent()){
            return contato.get();
        } else {
            throw new EntidadeNaoEncontrada(nome + " não foi encontrado(a) na agenda.");
        }
    }

    public Contato getByNumero(String numero) throws EntidadeNaoEncontrada{
        Optional<Contato> contato = contatos.stream().filter(e -> e.getNumero().equals(numero)).findFirst();
        if (contato.isPresent()){
            return contato.get();
        } else {
            throw new EntidadeNaoEncontrada(numero + " não foi encontrado(a) na agenda.");
        }
    }

    public void adicionar(Contato contato){
        contatos.add(contato);
    }

    public int getIndex(Contato contato){
        return contatos.indexOf(contato);
    }

    public void remover(Contato contato) throws EntidadeNaoEncontrada{
        if (contatos.contains(contato)){
            contatos.remove(contato);
        } else {
            throw new EntidadeNaoEncontrada("O contato não foi encontrado(a) na agenda.");
        }
    }

    public void remover(int index) throws EntidadeNaoEncontrada{
        if (index < contatos.size()){
            contatos.remove(index);
        } else {
            throw new EntidadeNaoEncontrada("O index não foi encontrado(a) na agenda.");
        }
    }

    public void editar(int index, Contato novoContato) throws EntidadeNaoEncontrada{
        if (index < contatos.size()){
            contatos.set(index, novoContato);
        } else {
            throw new EntidadeNaoEncontrada("O index não foi encontrado(a) na agenda.");
        }
    }
}
