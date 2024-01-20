package Entidades.Pagamento;

import Entidades.Pagamento.FormaPagamento;

public class Boleto extends FormaPagamento {
    private String email;
    
    public Boleto(String cpf, String email){
        super(cpf);
        this.email = email;
    }
    
    public String getEmail() {
        return email;
    }
    
    @Override
    public String getInfoPagamento(){
        return "CPF: " + super.getInfoPagamento() + "\n" + "Email: " + this.email;
    }
}