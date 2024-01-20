package Repositorios;

import Entidades.Pagamento.*;
import Entidades.Produto.*;
import Entidades.Venda;
import Interfaces.IRepositorio;
import java.util.ArrayList;
import java.util.HashMap;

public class VendasRepositorio implements IRepositorio {

    private ArrayList<Venda> vendas = new ArrayList<>();

    public void relatorioVendasDoMes(String mes) {

        String mesVenda;
        int contador = 1;
        int contagemVendas = 0;

        System.out.println("\n==========================================================================================\n");
        System.out.println("                             Relatório de Vendas no mes " + mes);
        

        for (Venda venda : vendas) {

            String data = venda.getDataDaVenda();
            String[] array = data.split("/");
            mesVenda = array[1];

            if (mes.equals(mesVenda)) {

                System.out.println("VENDA " + contador + "\n");
                System.out.println("Cliente: " + venda.getUsuario().toString());
                System.out.println("Produtos: ");
                for (Produto produto : venda.getProdutos()) {
                    if (produto instanceof Hospedagem) {
                        System.out.println(" - Hospedagem");
                    } else if (produto instanceof Passagem) {
                        System.out.println(" - Passagem");
                    } else if (produto instanceof Atracao) {
                        System.out.println(" - Atracao");
                    }
                }

                System.out.println("Data da venda: " + venda.getDataDaVenda());
                System.out.println("Preco total: " + venda.getPrecoTotal());

                if (venda.getFormaPagamento() instanceof Cartao) {
                    System.out.println("Forma de Pagamento: Cartao");
                } else if (venda.getFormaPagamento() instanceof Boleto) {
                    System.out.println("Forma de Pagamento: Boleto ");
                } else if (venda.getFormaPagamento() instanceof Pix) {
                    System.out.println("Forma de Pagamento: PIX");
                }
                contagemVendas++;
                contador++;
            }
        }
        System.out.println("\nTotal de vendas: " + contagemVendas);
        System.out.println("\n==================================================================================");
    }

    public void relatorioProdutoMaisVendidoDoMes(String mes) {

        int contadorHosp = 0;
        int contadorPass = 0;
        int contadorAtra = 0;

        String mesVenda;

        for (Venda venda : vendas) {
            String data = venda.getDataDaVenda();
            String[] array = data.split("/");
            mesVenda = array[1];

            if (mes.equals(mesVenda)) {
                for (Produto produto : venda.getProdutos()) {
                    if (produto instanceof Hospedagem) {
                        contadorHosp++;
                    } else if (produto instanceof Passagem) {
                        contadorPass++;
                    } else if (produto instanceof Atracao) {
                        contadorAtra++;
                    }
                }
            }
        }
        
        System.out.println("==================================================================================");
        System.out.println("                Produto campeao de vendas do mês " + mes + "\n");
        if (contadorHosp > contadorPass || contadorHosp > contadorAtra) {
            System.out.println("Produto: Hospedagem");
            System.out.println("Total de vendas: " + contadorHosp);
        } else if (contadorPass > contadorHosp || contadorPass > contadorAtra) {
            System.out.println("Produto: Passagem");
            System.out.println("Total de vendas: " + contadorPass);
        } else {
            System.out.println("Produto: Atracao");
            System.out.println("Total de vendas: " + contadorAtra);
        }
        
        System.out.println("\n==================================================================================");
    }

    public void relatorioCidadesMaisVisitadas() {
        HashMap<String, Integer> cidadesMaisVisitadas = new HashMap<>();

        for (Venda venda : vendas) {
            for (Produto produto : venda.getProdutos()) {
                if (produto instanceof Passagem) {
                    String cidade = ((Passagem) produto).getTrecho().getCidadeDestinoNome();
                    if (cidadesMaisVisitadas.containsKey(cidade)) {
                        int visitasAnteriores = cidadesMaisVisitadas.get(cidade);
                        cidadesMaisVisitadas.put(cidade, visitasAnteriores + 1);
                    } else {
                        cidadesMaisVisitadas.put(cidade, 1);
                    }
                }
            }
        }
        System.out.println("===============================================================================");
        System.out.println("\nCidade mais visitadas:\n");

        for (String cidade : cidadesMaisVisitadas.keySet()) {
            int visitas = cidadesMaisVisitadas.get(cidade);
            
            System.out.println(cidade + ": " + visitas);
        }
        
        System.out.println("===============================================================================");
    }

    @Override
    public ArrayList<Venda> getDados() {
        return vendas;
    }

    @Override
    public boolean setDados(Object obj) {
        try {
            Venda venda = (Venda) obj;
            vendas.add(venda);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    @Override
    public void mostraDados() {
        System.out.println("\nVENDAS CADASTRADAS");
        int contador = 1;
        for (Venda venda : vendas) {
            System.out.println(contador + " - " + venda.toString());
            contador++;
        }
    }
}
