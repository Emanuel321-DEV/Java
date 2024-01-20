package agenciadeviagens;

import Entidades.Venda;
import Entidades.Pessoa.*;
import Entidades.Pagamento.*;
import Entidades.Produto.*;
import Entidades.*;
import Repositorios.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Date;

public class Main {

    public static void main(String a[]) {
        UsuariosRepositorio usuariosRepo = new UsuariosRepositorio();
        Scanner s = new Scanner(System.in);

        int menu = 0;
        do {
            printMenuPrincipal();
            menu = s.nextInt();

            switch (menu) {
                case 1:
                    Usuario u = cadastraUsuario();
                    usuariosRepo.setDados(u);
                    break;
                case 2:
                    List<Usuario> usuarios = usuariosRepo.getDados();
                    Usuario usuario;
                    int retornarMenu = 0;
                    do {
                        usuario = realizaLogin(usuarios);
                        if (usuario != null) {
                            exibeMenuPassagem(usuario);
                        } else {
                            System.out.println("1 - Tentar novamente");
                            System.out.println("2 - Retornar ao menu principal");
                            retornarMenu = s.nextInt();
                        }
                    } while (usuario == null || retornarMenu == 2);
                    break;
                case 3:
                    System.out.println("\nEncerrando programa... ");
                    return;
            }
        } while (menu != 3);
    }

    public static Usuario cadastraUsuario() {

        String nome, sexo, cpf, email, senha, confirmaSenha, telefone;
        int idade;

        System.out.println("\n========================================================================================================\n");
        System.out.println("                                        Cadastro de Usuario");
        System.out.println("\n========================================================================================================\n");

        System.out.println("Nome completo:");
        Scanner s = new Scanner(System.in);
        nome = s.nextLine();

        System.out.println("\nInforme sua idade: (Ex: 20)");
        idade = s.nextInt();
        s.nextLine();

        System.out.println("\nInforme seu genero: (Masculino / Feminino)");
        sexo = s.nextLine();

        do {
            System.out.println("\nDigite o CPF: (somente os numeros) "); //Captura o CPF e dispara mensagens de erro caso não siga as regras de negócio.
            cpf = s.nextLine();
            try {
                if (!Pessoa.validaCPF(cpf)) {
                    System.out.println("\n*************************************************************************\n");
                    System.out.println("             Erro: CPF inválido, insira somente os dígitos.");
                    System.out.println("\n*************************************************************************");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("\nErro ao cadastrar: " + e.getMessage());
            }
        } while (!Usuario.validaCPF(cpf));

        do {
            System.out.println("\nEmail: "); //Captura o email e dispara mensagens de erro caso não siga as regras de negócio.
            email = s.nextLine();

            try {
                if (!Usuario.validaEmail(email)) {
                    System.out.println("\n*************************************************************************\n");
                    System.out.println("       Erro: Email invalido, digite novamente conferindo a escrita.");
                    System.out.println("\n*************************************************************************");
                }
            } catch (IllegalArgumentException e1) {
                System.out.println("\nErro ao cadastrar: " + e1.getMessage());
            }
        } while (!Usuario.validaEmail(email));

        do {
            System.out.println("\nSenha de acesso: ");
            senha = s.nextLine();

            System.out.println("\nConfirme a senha de acesso: ");
            confirmaSenha = s.nextLine();

            if (!senha.equals(confirmaSenha)) {
                System.out.println("\n*************************************************************************\n");
                System.out.println("           As senhas nao coincidem. Por favor, digite novamente."); //Pede para repetir a senha enquanto não forem iguais.
                System.out.println("\n*************************************************************************");
            }
        } while (!senha.equals(confirmaSenha));

        do {
            System.out.println("\nTelefone de contato: (somente 9 digitos) ");
            telefone = s.nextLine();

            if (telefone.length() != 9) {
                System.out.println("\n*************************************************************************\n");
                System.out.println("      Erro ao cadastrar: O telefone deve conter exatamente 9 digitos.");
                System.out.println("\n*************************************************************************");
            }
        } while (telefone.length() != 9);

        Usuario u = new Usuario(email, senha, nome, cpf, telefone, sexo, idade);
        return u;
    }

    public static Usuario realizaLogin(List<Usuario> usuarios) {
        Scanner s = new Scanner(System.in);
   
        System.out.println("\nInforme o seu email:");
        String emailInformado = s.nextLine();

        System.out.println("\nInforme a sua senha:");
        String senhaInformada = s.nextLine();
        
        
        Login login = new Login();

        Usuario usuarioValido = login.validate(usuarios, emailInformado, senhaInformada);
       
        return usuarioValido;
    }

    public static boolean exibeMenuPassagem(Usuario usuario) {
        CidadesRepositorio cidadesRepo = new CidadesRepositorio();
        AtracoesRepositorio atracoesRepo = new AtracoesRepositorio();
        AeroportosRepositorio aeroportosRepo = new AeroportosRepositorio();
        HoteisRepositorio hoteisRepo = new HoteisRepositorio();
        VendasRepositorio vendas = new VendasRepositorio();

        Scanner s = new Scanner(System.in);
        Date d = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dataAtual = dateFormat.format(d);

        int opcao;
        do {
            printMenuLogin();
            ArrayList<Cidade> cidades = cidadesRepo.getDados();

            opcao = s.nextInt();

            switch (opcao) {
                case 1:
                    printMenuCadastro();
                    int submenu = 5;
                    int cidadeEscolhida;
                    do {
                        printMenuCadastro();
                        submenu = s.nextInt();
                        s.nextLine(); // Consome a quebra de linha pendente

                        switch (submenu) {
                            case 1:
                                System.out.println("\nCADASTRO DE CIDADES ");

                                System.out.println("\nInforme o nome da cidade:");
                                String nome = s.nextLine();

                                System.out.println("\nInforme o estado da cidade: ");
                                String estado = s.nextLine();

                                System.out.println("\nInforme o pais da cidade: ");
                                String pais = s.nextLine();

                                Cidade c = new Cidade(nome, estado, pais);
                                cidadesRepo.setDados(c);

                                // Necessario cadastrar uma atracao, aeroporto e hotel para a cidade recém criada //
                                System.out.println("Cadastre uma atracao para a cidade:\n");
                                Atracao atracaoCidade = atracaoCadastro(c);
                                atracoesRepo.setDados(atracaoCidade);

                                System.out.println("Cadastre um hotel para a cidade\n");
                                Hotel hotelCidade = hotelCadastro(c);
                                hoteisRepo.setDados(hotelCidade);

                                System.out.println("Cadastre um aeroporto para a cidade\n");
                                Aeroporto aeroportoCidade = aeroportoCadastro(c);
                                aeroportosRepo.setDados(aeroportoCidade);

                                break;
                            case 2:
                                System.out.println("\nA qual cidade essa atracao pertence?\n");
                                cidadesRepo.mostraDados();

                                cidadeEscolhida = s.nextInt();
                                s.nextLine();

                                Cidade cidadeAtracao = cidades.get(cidadeEscolhida - 1);
                                Atracao at = atracaoCadastro(cidadeAtracao);
                                atracoesRepo.setDados(at);
                                break;
                            case 3:
                                System.out.println("\nInforme a cidade em que o Hotel esta localizado:\n");
                                cidadesRepo.mostraDados();
                                cidadeEscolhida = s.nextInt();
                                s.nextLine(); // Consome a quebra de linha
                                Cidade cidadeHotel = cidades.get(cidadeEscolhida - 1);
                                Hotel hotel = hotelCadastro(cidadeHotel);
                                hoteisRepo.setDados(hotel);

                                break;
                            case 4:
                                System.out.println("\nInforme a cidade em que o aeroporto esta localizado:\n");
                                cidadesRepo.mostraDados();

                                cidadeEscolhida = s.nextInt();
                                s.nextLine(); //Consome a quebra de linha
                                Cidade cidadeAeroporto = cidades.get(cidadeEscolhida - 1);
                                Aeroporto aeroporto = aeroportoCadastro(cidadeAeroporto);

                                aeroportosRepo.setDados(aeroporto);

                                break;
                            case 5:
                                System.out.println("\nRetornando ao menu principal...");
                                break;
                        }

                    } while (submenu != 5);

                    break;
                case 2:
                    do {
                        printMenuVisualizacao();
                        submenu = s.nextInt();

                        switch (submenu) {
                            case 1:
                                System.out.println("\nCIDADES CADASTRADAS\n");
                                cidadesRepo.mostraDados();
                                break;
                            case 2:
                                System.out.println("\nATRACOES CADASTRADAS\n");
                                atracoesRepo.mostraDados();
                                break;
                            case 3:
                                System.out.println("\nHOTEIS CADASTRADOS\n");
                                hoteisRepo.mostraDados();
                                break;
                            case 4:
                                System.out.println("\nAEROPORTOS CADASTRADOS\n");
                                aeroportosRepo.mostraDados();
                                break;
                            case 5:
                                System.out.println("\nRetornando ao menu principal...");
                                break;
                        }
                    } while (submenu != 5);
                    break;
                case 3:
                    System.out.println("\nDados de suas compras: ");
                    for (Venda venda : vendas.getDados()) {
                        venda.mostraDados();
                    }
                    break;
                case 4:
                    System.out.println("\nCOMPRA DE PACOTE\n");
                    System.out.println("Informe a Cidade de Origem:\n");
                    cidadesRepo.mostraDados();

                    int cidadeOrigemOpcao = s.nextInt() - 1;
                    Cidade cidadeOrigem = cidades.get(cidadeOrigemOpcao);

                    System.out.println("\nInforme a Cidade de Destino:\n");
                    cidadesRepo.mostraDados(cidadeOrigem);

                    int cidadeDestinoOpcao = s.nextInt() - 1;
                    Cidade cidadeDestino = cidades.get(cidadeDestinoOpcao);

                    System.out.println("\nInforme uma data de Ida: (DD/MM/YYYY)");
                    String dataIda = s.next();

                    System.out.println("\nInforme o nro de passageiros:");
                    int nroPassageiros = s.nextInt();

                    Pacote pacote = new Pacote();
                    ArrayList<Trecho> trechosDisponiveis = new ArrayList<>();

                    ArrayList<Aeroporto> aeroportosOrigem = aeroportosRepo.getAeroportosDaCidade(cidadeOrigem);
                    ArrayList<Aeroporto> aeroportosDestino = aeroportosRepo.getAeroportosDaCidade(cidadeDestino);

                    Trecho t = new Trecho(cidadeOrigem, cidadeDestino, aeroportosOrigem.get(0), aeroportosDestino.get(0), dataIda, "09:00");
                    Trecho t2 = new Trecho(cidadeOrigem, cidadeDestino, aeroportosOrigem.get(0), aeroportosDestino.get(0), dataIda, "12:00");

                    trechosDisponiveis.add(t);
                    trechosDisponiveis.add(t2);

                    System.out.println("\nEscolha um de nossos trechos disponiveis: (1 ou 2)");

                    int contador = 1;
                    for (Trecho trech : trechosDisponiveis) {
                        System.out.println("\nTrecho " + contador);
                        trech.mostraTrecho();
                        contador++;
                    }

                    int trechoDisponivelEscolha = s.nextInt() -1;
                    Trecho trecho = trechosDisponiveis.get(trechoDisponivelEscolha);
                    
                    ArrayList<Cliente> passageiros = getClientesDados(nroPassageiros, "Passageiro");
                    
                    System.out.println("\nEscolha uma de nossas atracoes disponiveis:\n");

                    ArrayList<Atracao> atracoes = atracoesRepo.getAtracoesDaCidade(cidadeDestino);
                    ArrayList<Atracao> atracoesEscolhidas = new ArrayList<>();

                    int adicionarMaisAtracoes = 1;
                    boolean atracoesAcabaram = false;
                    
                    while (adicionarMaisAtracoes == 1 && !atracoesAcabaram) {
                        contador = 1;
                        
                        for (Atracao atracao : atracoes) {
                            if (!atracoesEscolhidas.contains(atracao)) {
                                
                                System.out.println((contador) + " - " + atracao.toString());
                            }
                            contador++;
                        }

                        atracoesEscolhidas.add(atracoes.get(s.nextInt() - 1));

                        System.out.println("\nDeseja adicionar mais alguma atracao?\n");
                        System.out.println("1 - Sim");
                        System.out.println("2 - Nao");
                        adicionarMaisAtracoes = s.nextInt();
                        atracoesAcabaram = atracoes.size() == atracoesEscolhidas.size();
                        if (atracoesAcabaram) {
                            System.out.println("\nDesculpe, nao ha mais atracoes disponiveis!");
                        }
                    }

                    System.out.println("\nEscolha um de nossos hoteis:\n");
                    ArrayList<Hotel> hoteis = hoteisRepo.getHoteisDaCidade(cidadeDestino);

                    contador = 1;
                    for (Hotel hotei : hoteis) {
                        System.out.println(contador + " - " + hotei.toString() + "\n");
                        contador++;
                    }

                    int hotelEscolhidoOp = s.nextInt() - 1;
                    Hotel hotelEscolhido = hoteis.get(hotelEscolhidoOp);

                    System.out.println("\nInforme o nro de quartos que deseja alugar:");
                    int nroQuartos = s.nextInt();

                    System.out.println("\nInforme a data inicio de sua hospedagem: ");
                    String dataInicio = s.next();

                    System.out.println("\nInforme a data final de sua hospedagem:");
                    String dataFinal = s.next();
                    Hospedagem hospedagem = new Hospedagem(dataInicio, dataFinal, cidadeOrigem, nroPassageiros, nroQuartos, hotelEscolhido);

                    
                    hospedagem.setClientes(passageiros);

                    ArrayList<Passagem> passagens = new ArrayList<>();
                    // Para cada passageiro criar uma passagem
                    for (Cliente passageiro : passageiros) {
                        Passagem passagem = new Passagem(passageiro, trecho);
                        passagens.add(passagem);
                    }

                    pacote.setAtracao(atracoesEscolhidas);
                    pacote.setPassagens(passagens);
                    pacote.setHospedagem(hospedagem);

                    ArrayList<Produto> produtosComprados = new ArrayList<>();

                    produtosComprados.add(pacote.getHospedagens());
                    produtosComprados.addAll(pacote.getPassagens());
                    produtosComprados.addAll(pacote.getAtracoes());

                    Venda venda = new Venda(produtosComprados, usuario, dataAtual);

                    FormaPagamento formaDePagamento = getPagamentoDados();
                    venda.setFormaPagamento(formaDePagamento);
                    vendas.setDados(venda);

                    System.out.println("\n******************** Sua compra foi realizada com sucesso! ********************\n");
                    System.out.println("Escolha uma das opcoes:\n");
                    int opcaoVenda = 0;
                    do {
                        System.out.println("1 - Emitir Passagens");
                        System.out.println("2 - Emitir relatorio de viagem");
                        System.out.println("3 - Retornar ao menu");
                        opcaoVenda = s.nextInt();

                        switch (opcaoVenda) {
                            case 1:
                                System.out.println("======================================== PASSAGENS ========================================");
                                pacote.emitePassagens();
                                System.out.println("===========================================================================================\n");
                                break;
                            case 2:
                                System.out.println("======================================== PACOTE ========================================\n");
                                pacote.emitePacoteCompleto();
                                System.out.println("===========================================================================================");
                                break;
                        }

                    } while (opcaoVenda != 3);
                    break;
                case 5:
                    System.out.println("\nCompra de Hospedagem");
                    System.out.println("Informe a data de entrada: (DD/MM/YYYY)");
                    String dataEntrada = s.next();

                    System.out.println("\nInforme a data de saida: (DD/MM/YYYY)");
                    String dataSaida = s.next();

                    System.out.println("\nInforme a cidade em que deseja se hospedar:\n");
                    for (int i = 0; i < cidades.size(); i++) {
                        System.out.println((i + 1) + " - " + cidades.get(i).toString());
                    }

                    int cidadeHospedagemOpcao = s.nextInt() - 1;
                    Cidade cidadeHospedagem = cidades.get(cidadeHospedagemOpcao);

                    hoteis = hoteisRepo.getHoteisDaCidade(cidadeHospedagem);
                    System.out.println("\nEscolha um dos hoteis disponiveis:");
                    for (int i = 0; i < hoteis.size(); i++) {
                        System.out.println((i + 1) + " - " + hoteis.get(i).toString());
                    }
                    
                    int hotelOpcao = s.nextInt() - 1;
                    Hotel hotel = hoteis.get(hotelOpcao);
                    System.out.println("\nInforme o nro de pessoas:");
                    int nroPessoasHospedagem = s.nextInt();

                    System.out.println("\nInforme o nro de quartos:");
                    int nroDeQuartos = s.nextInt();
                    s.nextLine();

                    Hospedagem h1 = new Hospedagem(dataEntrada, dataSaida, cidadeHospedagem, nroPessoasHospedagem, nroDeQuartos, hotel);
                    ArrayList<Cliente> clientes = getClientesDados(nroPessoasHospedagem, " Hospede");

                    ArrayList<Produto> produtos = new ArrayList<>();
                    produtos.add(h1);
                    h1.setClientes(clientes);
                    Venda v1 = new Venda(produtos, usuario, dataAtual);
                    FormaPagamento formaDePagamentoHospedagem = getPagamentoDados();

                    v1.setFormaPagamento(formaDePagamentoHospedagem);
                    System.out.println("\n******************* Sua hospedagem foi realizada com sucesso! *******************\n");

                    System.out.println("Dados da hospedagem: \n");
                    System.out.println(h1.toString());
                    vendas.setDados(v1);
                    break;
                case 6:
                    System.out.println("\nCompra de Passagem");

                    System.out.println("\nInforme a Cidade de Origem:\n");
                    for (int i = 0; i < cidades.size(); i++) {
                        System.out.println((i + 1) + " - " + cidades.get(i).getNome());
                    }

                    int cidadeOrigemOp = s.nextInt() - 1;
                    Cidade cidadeOrigemO = cidades.get(cidadeOrigemOp);

                    System.out.println("\nInforme a Cidade de Destino:\n");
                    for (int i = 0; i < cidades.size(); i++) {
                        if (i != cidadeOrigemOp) {
                            System.out.println((i + 1) + " - " + cidades.get(i).getNome());
                        }
                    }

                    int cidadeDestinoOp = s.nextInt() - 1;
                    Cidade cidadeDestinoO = cidades.get(cidadeDestinoOp);

                    System.out.println("\nInforme uma data de Ida: (DD/MM/YYYY)");
                    String dataIdaOp = s.next();

                    System.out.println("\nInforme o nro de passageiros:");
                    int nroPassageirosOp = s.nextInt();

                    ArrayList<Cliente> passageiross = getClientesDados(nroPassageirosOp, " Passageiro");

                    trechosDisponiveis = new ArrayList<>();

                    aeroportosOrigem = aeroportosRepo.getAeroportosDaCidade(cidadeOrigemO);
                    aeroportosDestino = aeroportosRepo.getAeroportosDaCidade(cidadeDestinoO);

                    t = new Trecho(cidadeOrigemO, cidadeDestinoO, aeroportosOrigem.get(0), aeroportosDestino.get(0), dataIdaOp, "09:00");
                    t2 = new Trecho(cidadeOrigemO, cidadeDestinoO, aeroportosOrigem.get(0), aeroportosDestino.get(0), dataIdaOp, "12:00");

                    trechosDisponiveis.add(t);
                    trechosDisponiveis.add(t2);

                    System.out.println("\nEscolha um de nossos trechos disponiveis: 1 ou 2 \n");

                    contador = 1;
                    for (Trecho trech : trechosDisponiveis) {
                        System.out.println("Trecho " + contador);
                        trech.mostraTrecho();
                        contador++;
                    }

                    trechoDisponivelEscolha = s.nextInt() - 1;
                    trecho = trechosDisponiveis.get(trechoDisponivelEscolha);

                    ArrayList<Produto> passagenss = new ArrayList<>();
                    for (int i = 0; i < nroPassageirosOp; i++) {
                        Passagem passagem = new Passagem(passageiross.get(i), trecho);
                        passagenss.add(passagem);
                    }

                    Venda v = new Venda(passagenss, usuario, dataAtual);
                    FormaPagamento formaDePagamentoPassagem = getPagamentoDados();

                    v.setFormaPagamento(formaDePagamentoPassagem);
                    System.out.println("\n******************* Sua Passagem foi comprada com sucesso! *******************\n");
                    ArrayList<Produto> passagensCompradas = v.getProdutos();
                    System.out.println("Emissão de passagem: ");

                    for (Produto passagemComprada : passagensCompradas) {
                        Passagem passagem = (Passagem) passagemComprada;
                        System.out.println(passagem.emitePassagem());
                    }

                    vendas.setDados(v);
                    break;
                case 7:

                    int relatorioOp = 0;

                    while (relatorioOp != 4) {
                        System.out.println("\nQual relatorio vc deseja visualizar?\n");
                        System.out.println("1 - Total de vendas realizadas em determinado mês");
                        System.out.println("2 - Cidades mais visitadas");
                        System.out.println("3 - Produto mais vendido em determinado mês");
                        System.out.println("4 - Sair");
                        relatorioOp = s.nextInt();
                        switch (relatorioOp) {
                            case 1:
                                System.out.println("\nInforme o mes (Exemplo: 04)");
                                String mes = s.next();
                                vendas.relatorioVendasDoMes(mes);
                                break;
                            case 2:
                                vendas.relatorioCidadesMaisVisitadas();
                                break;
                            case 3:
                                System.out.println("\nInforme o mes: (Exemplo: 04)");
                                mes = s.next();
                                vendas.relatorioProdutoMaisVendidoDoMes(mes);
                                break;
                        }
                    }
                    break;
                case 8:
                    System.out.println("\n========================================================================================================\n");
                    System.out.println("                                        Encerrando atividade...");
                    System.out.println("\n========================================================================================================\n");
                    break;
                default:
                    System.out.println("\nOpcao invalida!\n");
            }

        } while (opcao != 8);
        return true;
    }

    public static ArrayList<Cliente> getClientesDados(int numClientes, String tipoCliente) {

        Scanner s = new Scanner(System.in);

        ArrayList<Cliente> clientes = new ArrayList<>();
        System.out.println("\nInforme os dados dos passageiros\n");

        for (int i = 0; i < numClientes; i++) {
            System.out.println((i+1) + "º" + tipoCliente + "\n");

            System.out.println("Nome:");
            String nome = s.nextLine();

            System.out.println("\nCPF: ");
            String cpf = s.next();

            System.out.println("\nIdade: (Ex: 20)");
            int idade = s.nextInt();

            System.out.println("\nSexo: (Masculino | Feminino)");
            String sexo = s.next();
            s.nextLine();

            System.out.println("\nDeseja informar alguma necessidade especial para o passageiro? (EX: Sim, precisa de assento especial ou Nao)");
            String obs = s.nextLine();
            clientes.add(new Cliente(obs, nome, cpf, sexo, idade));
        }

        return clientes;
    }

    public static FormaPagamento getPagamentoDados() {
        Scanner s = new Scanner(System.in);
        try {
            int opcao = 0;
            do {
                FormaPagamento formaDePagamento = null;
                System.out.println("\nInforme um dos meios de pagamento");
                System.out.println("1 - Cartao");
                System.out.println("2 - Boleto");
                System.out.println("3 - PIX");
                opcao = s.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.println("\nInforme o CPF do titular");
                        String cpf = s.next();
                        s.nextLine(); // Consome o caractere da linha anterior

                        System.out.println("\nInforme o nome do titular");
                        String nomeTitular = s.nextLine();

                        System.out.println("\nInforme a data de vencimento do cartao (DD/MM/YYYY)");
                        String vencimento = s.next();

                        System.out.println("\nInforme o CVV");
                        String CVV = s.next();

                        System.out.println("\nInforme o nro do cartao ");
                        String nroCartao = s.next();

                        Cartao cartao = new Cartao(cpf, nomeTitular, vencimento, CVV, nroCartao);
                        formaDePagamento = cartao;
                        break;
                    case 2:
                        System.out.println("\nInforme o CPF do Titular");
                        String cpfBoleto = s.next();

                        System.out.println("\nInforme o email do responsavel");
                        String email = s.next();

                        Boleto boleto = new Boleto(cpfBoleto, email);
                        formaDePagamento = boleto;
                        break;
                    case 3:
                        System.out.println("\nInforme o CPF do responsavel");
                        String cpfPix = s.next();

                        System.out.println("\nInforme o nome do resposavel");
                        String nomeResponsavel = s.nextLine();
                        s.nextLine();
                        Pix pix = new Pix(cpfPix, nomeResponsavel);
                        formaDePagamento = pix;
                        break;
                }
                return formaDePagamento;
            } while (opcao != 1 && opcao != 2 && opcao != 3);
        } catch (InputMismatchException exception) {
            System.out.println("\n******************************************************************\n");
            System.out.println("Erro: Formato Digitado nao eh valido");
            System.out.println("\n******************************************************************\n");
            return null;
        }
    }

    public static Atracao atracaoCadastro(Cidade cidade) {
        Scanner s = new Scanner(System.in);
        System.out.println("\nInforme o nome da atracao:");

        String nomeAtracao = s.nextLine();

        Atracao at = new Atracao(cidade, nomeAtracao);
        return at;
    }

    public static Hotel hotelCadastro(Cidade cidade) {
        Scanner s = new Scanner(System.in);
        System.out.println("Informe o nome do Hotel:");
        String nomeHotel = s.nextLine();

        System.out.println("\nInforme o nro de estrelas do hotel:");
        int nroEtrelas = s.nextInt();

        System.out.println("\nInforme o valor da diaria:");
        double valorDiaria = s.nextDouble();

        Hotel hotel = new Hotel(nomeHotel, cidade, nroEtrelas, valorDiaria);

        return hotel;
    }

    public static Aeroporto aeroportoCadastro(Cidade cidade) {
        Scanner s = new Scanner(System.in);
        System.out.println("Informe o nome do aeroporto:");
        String nomeAeroporto = s.nextLine();

        Aeroporto aeroporto = new Aeroporto(nomeAeroporto, cidade);
        return aeroporto;
    }

    // ################################################### PRINTS ABAIXO #############################################################
    public static void printMenuPrincipal() {
        System.out.println("\n========================================================================================================\n");
        System.out.println("                                             Menu Principal");
        System.out.println("\n========================================================================================================\n");
        System.out.println("Escolha uma das opcoes:\n");
        System.out.println("1 - Cadastro de Usuario");
        System.out.println("2 - Login de Usuario ");
        System.out.println("3 - Finalizar Programa");
    }

    public static void printMenuCadastro() {
        System.out.println("\n========================================================================================================\n");
        System.out.println("                                        Menu de Cadastro");
        System.out.println("\n========================================================================================================\n");
        System.out.println("Escolha uma das opcoes: ");
        System.out.println("1 - Cadastrar Cidades");
        System.out.println("2 - Cadastrar Atracoes");
        System.out.println("3 - Cadastrar Hoteis");
        System.out.println("4 - Cadastrar Aeroportos");
        System.out.println("5 - Retornar ao Menu Principal");
    }

    public static void printMenuVisualizacao() {
        System.out.println("\n========================================================================================================\n");
        System.out.println("                                        Menu de Visualizacoes");
        System.out.println("\n========================================================================================================\n");
        System.out.println("Escolha uma das opcoes: ");
        System.out.println("1 - Visualizar Cidades");
        System.out.println("2 - Visualizar Atracoes");
        System.out.println("3 - Visualizar Hoteis");
        System.out.println("4 - Visualizar Aeroportos");
        System.out.println("5 - Retornar ao Menu Principal");
    }

    public static void printMenuLogin() {
        System.out.println("\n========================================================================================================\n");
        System.out.println("                            Bem vindo ao nosso sistema de agencia de viagens! ");
        System.out.println("\n========================================================================================================\n");
        System.out.println("Escolha uma das opcoes: ");
        System.out.println("1 - Cadastro (Cidades, Atracoes, Hoteis)");
        System.out.println("2 - Visualizar Cadastros");
        System.out.println("3 - Visualizar Minhas Compras");
        System.out.println("4 - Comprar Pacote");
        System.out.println("5 - Comprar Hospedagem");
        System.out.println("6 - Comprar Passagem");
        System.out.println("7 - Visualizar Relatorios de Vendas");
        System.out.println("8 - Encerrar atividade");
    }
}
