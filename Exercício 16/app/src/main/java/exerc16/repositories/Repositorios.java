package exerc16.repositories;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Repositorios {
    
    public PessoasRepositorio pessoasRepositorio;

    public EmprestimosRepositorio emprestimosRepositorio;
}
