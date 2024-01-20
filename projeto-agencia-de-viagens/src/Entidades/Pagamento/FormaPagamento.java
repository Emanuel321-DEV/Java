package Entidades.Pagamento;
public class FormaPagamento {
    private String cpf;
    
    public FormaPagamento(String cpf){
        this.cpf = cpf;
    }
    
    public String getInfoPagamento(){
        return cpf;
    }
}