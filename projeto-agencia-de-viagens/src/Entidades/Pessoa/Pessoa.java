package Entidades.Pessoa;
import Interfaces.IPessoa;
import java.io.Serializable;

public class Pessoa implements IPessoa, Serializable  {
    
    private String nome, cpf, sexo;
    private int idade;
    
    public Pessoa( String nome, String cpf, String sexo, int idade){
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.idade = idade;
    }
    
    @Override
    public String getNome(){
        return nome;
    }
    
    @Override
    public String getCPF(){
        return cpf;
    }
    
    @Override 
    public int getIdade(){
        return idade;
    }
   
    public static boolean validaCPF(String cpf) {
        String regex = "^[0-9]{11}$"; // Define como o CPF será válido (11 dígitos). ^ e $ delimita o início e fim da string, para garantir a validação da string toda.
        return cpf.matches(regex); // Matches -> Verifica se o CPF está de acordo com o definido na linha de cima.
    }
}