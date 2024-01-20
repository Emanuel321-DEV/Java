package Entidades;

import Entidades.Pessoa.Usuario;
import Entidades.Produto.Hospedagem;
import Entidades.Produto.Passagem;
import Entidades.Produto.Produto;
import Entidades.Pagamento.FormaPagamento;
import Entidades.Produto.Atracao;
import java.util.ArrayList;

public class Venda {

    private ArrayList<Produto> produtos;
    private double precoTotal;
    private FormaPagamento formaDePagamento;
    private Usuario usuario;
    private String dataVenda;

    public Venda(ArrayList<Produto> produtos, Usuario usuario, String dataVenda) {
        this.produtos = produtos;
        this.usuario = usuario;
        this.dataVenda = dataVenda;
        calcularPrecoTotal();
    }
    
    public Usuario getUsuario(){
        return usuario;
    }
    
    public String getDataDaVenda(){
        return dataVenda;
    }
    
    public double getPrecoTotal(){
        return precoTotal;
    }
    
    public boolean setFormaPagamento(FormaPagamento formaEscolhida) {
        this.formaDePagamento = formaEscolhida;
        return true;
    }
    
    public FormaPagamento getFormaPagamento(){
        return formaDePagamento;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }
    
    private void calcularPrecoTotal() {
        precoTotal = 0.0;
        for (Produto produto : produtos) {
            precoTotal += produto.getPreco();
        }
    }
    
    public void mostraDados() {
        for (Produto produto1 : produtos) {
            if (produto1 instanceof Hospedagem) {
                System.out.println("Hospedagem: ");
                System.out.println((((Hospedagem) produto1).toString()));
            } else if (produto1 instanceof Passagem) {
                System.out.println("Passagem: ");
                System.out.println((((Passagem) produto1).emitePassagem()));
            } else if(produto1 instanceof Atracao){
                System.out.println("Atracao: ");
                System.out.println((((Atracao) produto1).toString()));
            } 
        }
    }

}
