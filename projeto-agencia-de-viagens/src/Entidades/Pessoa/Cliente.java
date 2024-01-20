package Entidades.Pessoa;

public class Cliente extends Pessoa {

    private String observacao;
    
    public Cliente(String observacao, String nome, String cpf,  String sexo, int idade){
        super(nome, cpf, sexo, idade);
        this.observacao = observacao;
    }
    
    @Override
    public String getNome(){
        return super.getNome();
    }
    
    public String getCpf(){
        return super.getCPF();
    }
    
    public String getObservacao(){
        return observacao;
    }
}