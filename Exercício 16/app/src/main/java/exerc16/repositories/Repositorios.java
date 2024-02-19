package exerc16.repositories;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.Objects;

public class Repositorios {
    
    private PessoasRepositorio pessoasRepositorio;

    private EmprestimosRepositorio emprestimosRepositorio;

    public Repositorios(PessoasRepositorio pessoasRepositorio, EmprestimosRepositorio emprestimosRepositorio) {
        this.pessoasRepositorio = pessoasRepositorio;
        this.emprestimosRepositorio = emprestimosRepositorio;
    }

    public PessoasRepositorio getPessoasRepositorio() {
        return this.pessoasRepositorio;
    }

    public EmprestimosRepositorio getEmprestimosRepositorio() {
        return this.emprestimosRepositorio;
    }
    
}
