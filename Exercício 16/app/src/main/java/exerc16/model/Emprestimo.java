package exerc16.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Emprestimo {
    
    private Livro livro;
    private Pessoa responsavel;
    private LocalDateTime dateTime;

}
