package Arquivos;

import Entidades.Cidade;
import Entidades.Aeroporto;
import Entidades.Produto.Atracao;
import Entidades.Hotel;
import Entidades.Pessoa.Pessoa;
import Entidades.Pessoa.Usuario;
import java.util.ArrayList;
import java.util.Arrays;

public class Lab {

    public static void main(String a[]) {
        ArrayList<Cidade> cidades = new ArrayList<>();
        ArrayList<Aeroporto> aeroportos = new ArrayList<>();
        ArrayList<Atracao> atracoes = new ArrayList<>();
        ArrayList<Hotel> hoteis = new ArrayList<>();
        ArrayList<Pessoa> usuarios = new ArrayList<>();
        Usuario u1 = new Usuario("emanuel@gmail.com", "32417141", "Emanuel Henrique", "13878625618", "999268588", "Masculino", 20, true);
        usuarios.add(u1);
        Cidade cidade1 = new Cidade("Nova York", "Nova York", "Estados Unidos");
        Cidade cidade2 = new Cidade("Paris", "Ile-de-France", "Franca");
        Cidade cidade3 = new Cidade("Londres", "Inglaterra", "Reino Unido");
        Cidade cidade4 = new Cidade("Toquio", "Toquio", "Japao");
        Cidade cidade5 = new Cidade("Sao Paulo", "Sao Paulo", "Brasil");
        Cidade cidade6 = new Cidade("Araguari", "Minas Gerais", "Brasil");
        Cidade cidade7 = new Cidade("Uberlandia", "Minas Gerais", "Brasil");
        Cidade cidade8 = new Cidade("Belo Horizonte", "Minas Gerais", "Brasil");
        Cidade cidade9 = new Cidade("Rio de Janeiro", "Rio de Janeiro", "Brasil");
        Cidade cidade10 = new Cidade("Madri", "Madri", "Espanha");
        cidades.addAll(Arrays.asList(cidade1, cidade2, cidade3, cidade4, cidade5, cidade6, cidade7, cidade8, cidade9, cidade10));

        Aeroporto aeroportoNY1 = new Aeroporto("Aeroporto John F. Kennedy", cidade1);
        Aeroporto aeroportoNY2 = new Aeroporto("Aeroporto Newark", cidade1);

        Aeroporto aeroportoParis1 = new Aeroporto("Aeroporto Charles de Gaulle", cidade2);
        Aeroporto aeroportoParis2 = new Aeroporto("Aeroporto Orly", cidade2);

        Aeroporto aeroportoLondres1 = new Aeroporto("Aeroporto de Heathrow", cidade3);
        Aeroporto aeroportoLondres2 = new Aeroporto("Aeroporto London City", cidade3);

        Aeroporto aeroportoToquio1 = new Aeroporto("Aeroporto Internacional de Toquio", cidade4);
        Aeroporto aeroportoToquio2 = new Aeroporto("Aeroporto Haneda", cidade4);

        Aeroporto aeroportoSp1 = new Aeroporto("Aeroporto Internacional do Brasil", cidade5);
        Aeroporto aeroportoSp2 = new Aeroporto("Aeroporto Paulista", cidade5);

        Aeroporto aeroportoAra1 = new Aeroporto("Aeroporto Santos Dummond", cidade6);
        Aeroporto aeroportoAra2 = new Aeroporto("Aeroporto Nacional de Araguari", cidade6);

        Aeroporto aeroportoUber1 = new Aeroporto("Aeroporto de Uberlandia", cidade7);
        Aeroporto aeroportoUber2 = new Aeroporto("Aeroporto Nacional de Uberlandia", cidade7);

        Aeroporto aeroportoBH1 = new Aeroporto("Aeroporto de Belo Horizonte", cidade8);
        Aeroporto aeroportoBH2 = new Aeroporto("Aeroporto de Minas Gerais", cidade8);

        Aeroporto aeroportoRJ1 = new Aeroporto("Aeroporto do Rio de Janeiro", cidade9);
        Aeroporto aeroportoRJ2 = new Aeroporto("Aeroporto Regional do Rio de Janeiro", cidade9);

        Aeroporto aeroportoMD1 = new Aeroporto("Aeroporto de Madri", cidade10);
        Aeroporto aeroportoMD2 = new Aeroporto("Aeroporto Internacional Espanhol", cidade10);
        aeroportos.addAll((Arrays.asList(aeroportoNY1, aeroportoNY2, aeroportoParis1, aeroportoParis2, aeroportoLondres1, aeroportoLondres2, aeroportoToquio1, aeroportoToquio2, aeroportoSp1, aeroportoSp2, aeroportoAra1, aeroportoAra2, aeroportoUber1, aeroportoUber2, aeroportoBH1, aeroportoBH2, aeroportoRJ1, aeroportoRJ2, aeroportoMD1, aeroportoMD2)));

        Atracao atracaoNY1 = new Atracao(cidade1, "Estatua da Liberdade");
        Atracao atracaoNY2 = new Atracao(cidade1, "Central Park");
        Atracao atracaoNY3 = new Atracao(cidade1, "Times Square");

        Atracao atracaoPAR1 = new Atracao(cidade2, "Torre Eiffel");
        Atracao atracaoPAR2 = new Atracao(cidade2, "Catedral de Notre-Dame");
        Atracao atracaoPAR3 = new Atracao(cidade2, "Museu do Louvre");

        Atracao atracaoLON1 = new Atracao(cidade3, "Palacio de Buckingham");
        Atracao atracaoLON2 = new Atracao(cidade3, "Museu Britânico");
        Atracao atracaoLON3 = new Atracao(cidade3, "Torre de Londres");

        Atracao atracaoTOQ1 = new Atracao(cidade4, "Tokyo Disneyland");
        Atracao atracaoTOQ2 = new Atracao(cidade4, "Parque Yoyogi e Santuário Meiji");
        Atracao atracaoTOQ3 = new Atracao(cidade4, "Templo Senso-ji");

        Atracao atracaoSYD1 = new Atracao(cidade5, "Estadio do Morumbi");
        Atracao atracaoSYD2 = new Atracao(cidade5, "Teatro Municipal");
        Atracao atracaoSYD3 = new Atracao(cidade5, "Avenida 23 de Marco");

        Atracao atracaoARI1 = new Atracao(cidade6, "Prefeitura de Araguari");
        Atracao atracaoARI2 = new Atracao(cidade6, "Bosque John Kennedy");
        Atracao atracaoARI3 = new Atracao(cidade6, "Cachoeira das Andorinhas");

        Atracao atracaoUBL1 = new Atracao(cidade7, "Universidade Federal de Uberlandia");
        Atracao atracaoUBL2 = new Atracao(cidade7, "Center Shopping");
        Atracao atracaoUBL3 = new Atracao(cidade7, "Parque do Sabia");

        Atracao atracaoBH1 = new Atracao(cidade8, "Praca da Liberdade");
        Atracao atracaoBH2 = new Atracao(cidade8, "Estadio do Mineirao");
        Atracao atracaoBH3 = new Atracao(cidade8, "Lagoa da Pampulha");

        Atracao atracaoRJ1 = new Atracao(cidade9, "Cristo Redentor");
        Atracao atracaoRJ2 = new Atracao(cidade9, "Praia de Copacabana");
        Atracao atracaoRJ3 = new Atracao(cidade9, "Estadio do Maracana");

        Atracao atracaoMD1 = new Atracao(cidade10, "Praca de La Cibeles");
        Atracao atracaoMD2 = new Atracao(cidade10, "Estadio Santiago Bernabeu");
        Atracao atracaoMD3 = new Atracao(cidade10, "Palacio Real");
        atracoes.addAll(Arrays.asList(
                atracaoNY1, atracaoNY2, atracaoNY3,
                atracaoPAR1, atracaoPAR2, atracaoPAR3,
                atracaoLON1, atracaoLON2, atracaoLON3,
                atracaoTOQ1, atracaoTOQ2, atracaoTOQ3,
                atracaoSYD1, atracaoSYD2, atracaoSYD3,
                atracaoARI1, atracaoARI2, atracaoARI3,
                atracaoUBL1, atracaoUBL2, atracaoUBL3,
                atracaoBH1, atracaoBH2, atracaoBH3,
                atracaoRJ1, atracaoRJ2, atracaoRJ3,
                atracaoMD1, atracaoMD2, atracaoMD3
        ));

        Hotel hotelNY1 = new Hotel("Hotel Central", cidade1, 3, 150.0);
        Hotel hotelNY2 = new Hotel("Hotel Luxe", cidade1, 4, 200.0);

        Hotel hotelParis1 = new Hotel("Hotel Eiffel", cidade2, 4, 220.0);
        Hotel hotelParis2 = new Hotel("Hotel Le Charme", cidade2, 5, 250.0);

        Hotel hotelLondres1 = new Hotel("London Palace", cidade3, 5, 300.0);
        Hotel hotelLondres2 = new Hotel("Westminster Hotel", cidade3, 4, 220.0);

        Hotel hotelToquio1 = new Hotel("Tokyo Heights", cidade4, 3, 130.0);
        Hotel hotelToquio2 = new Hotel("Imperial Tokyo", cidade4, 5, 280.0);

        Hotel hotelSp1 = new Hotel("São Paulo Comfort", cidade5, 3, 110.0);
        Hotel hotelSp2 = new Hotel("Luxury São Paulo", cidade5, 4, 180.0);

        Hotel hotelAra1 = new Hotel("Araguari Inn", cidade6, 2, 90.0);
        Hotel hotelAra2 = new Hotel("Ara Paradise", cidade6, 3, 120.0);

        Hotel hotelUber1 = new Hotel("Uberlandia Suites", cidade7, 3, 140.0);
        Hotel hotelUber2 = new Hotel("Golden Uberlandia", cidade7, 4, 180.0);

        Hotel hotelBH1 = new Hotel("Belo Horizonte Residences", cidade8, 4, 200.0);
        Hotel hotelBH2 = new Hotel("Minas Gerais Plaza", cidade8, 4, 200.0);

        Hotel hotelRJ1 = new Hotel("Rio de Janeiro Beach Resort", cidade9, 4, 210.0);
        Hotel hotelRJ2 = new Hotel("Rio Palace", cidade9, 5, 260.0);

        Hotel hotelMD1 = new Hotel("Madri Grand", cidade10, 4, 220.0);
        Hotel hotelMD2 = new Hotel("Espana Luxury Hotel", cidade10, 5, 270.0);

        hoteis.addAll(Arrays.asList(hotelNY1, hotelNY2, hotelParis1, hotelParis2, hotelLondres1, hotelLondres2, hotelToquio1, hotelToquio2, hotelSp1, hotelSp2, hotelAra1, hotelAra2, hotelUber1, hotelUber2, hotelBH1, hotelBH2, hotelRJ1, hotelRJ2, hotelMD1, hotelMD2));

        Arquivo.gravar(cidades, "cidades.dat");
        Arquivo.gravar(aeroportos, "aeroportos.dat");
        Arquivo.gravar(hoteis, "hoteis.dat");
        Arquivo.gravar(atracoes, "atracoes.dat");
        Arquivo.gravar(usuarios, "usuarios.dat");
    }
}
