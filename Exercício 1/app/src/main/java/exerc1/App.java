package exerc1;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Insira o nome da Pessoa: ");
        String nome = scanner.nextLine();

        System.out.println("Insira a idade da Pessoa: ");
        String idade = scanner.nextLine();

        try {
            int idadeInt = Integer.parseInt(idade);
            Pessoa pessoa = new Pessoa(nome, idadeInt);
            
            if (pessoa.isMaiorDeIdade()){
                System.out.println("A pessoa de nome " + nome + " e maior de idade.");
            } else {
                System.out.println("A pessoa de nome " + nome + " nao e maior de idade.");
            }

        } catch (NumberFormatException ex) {
            System.err.println("Idade Inválida");
        }

    }
}
