package exerc16.repositories;

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
