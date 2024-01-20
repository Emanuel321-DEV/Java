package Entidades.Pessoa;


import java.io.Serializable;

public class Usuario extends Pessoa implements Serializable {
    private String email, senha, telefone;
    private boolean usuarioAdm = false;

    public Usuario(String email, String senha, String nome, String cpf, String telefone, String sexo, int idade){
        super(nome, cpf, sexo, idade);
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
    }
    
    public Usuario(String email, String senha, String nome, String cpf, String telefone, String sexo, int idade, boolean isSuperUser){
        super(nome, cpf, sexo, idade);
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getSenha(){
        return senha;
    }
    
    @Override
    public String toString(){
        return super.getNome() + " - " + super.getCPF();
    }
    
    public void setValidaTelefone(String telefone){
        if (telefone.length() != 9) {
            System.out.println("\n****************************************************************");
            System.out.println("Erro ao cadastrar: O telefone deve conter exatamente 9 dígitos.");
            System.out.println("******************************************************************");
        }
    }

    public static boolean validaEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[a-z]+\\.(com|com\\.br|br)$"; //Define como o email será válido (letras maiúsculas, minúsculas, números, caracteres especiais; Domínio deve ser @ e string em minúsculo; Deve conter, .com//.com.br//.br
        return email.matches(regex);
    }
   
}