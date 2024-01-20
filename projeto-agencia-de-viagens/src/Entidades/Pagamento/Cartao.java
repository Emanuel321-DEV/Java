package Entidades.Pagamento;

import Entidades.Pagamento.FormaPagamento;

public class Cartao extends FormaPagamento {

    private String numero;
    private String nomeTitular;
    private String vencimento;
    private String cvv;

    public Cartao(String cpf, String nomeTitular, String vencimento, String cvv, String numero) {
        super(cpf);
        this.numero = numero;
        this.nomeTitular = nomeTitular;
        this.vencimento = vencimento;
        this.cvv = cvv;
    }

    @Override
    public String getInfoPagamento() {
        String dados = "CPF: " + super.getInfoPagamento() + "\n" + "Numero: " + this.numero + "\n" + "Nome do Titular: " + this.nomeTitular + "\n" + "Vencimento: " + this.vencimento + "\n" + "Cvv: " + this.cvv;
        return dados;
    }
}