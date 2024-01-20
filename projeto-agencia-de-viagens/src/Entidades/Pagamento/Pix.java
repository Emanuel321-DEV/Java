package Entidades.Pagamento;

public class Pix extends FormaPagamento {

    private String nome;

    public Pix(String cpf, String nome) {
        super(cpf);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String getInfoPagamento() {
        return "CPF: " + super.getInfoPagamento() + "\n" + "Nome: " + this.nome;
    }
}