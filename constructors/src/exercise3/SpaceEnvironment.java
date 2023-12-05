package exercise3;

import java.util.Scanner;

public class SpaceEnvironment {   
    public static void main(String[] args){
        Spacecraft[] spacecraft = new Spacecraft[5];
        int contador = 0;
        
        int opcao;
        Scanner scan = new Scanner(System.in);
        
        do{
            System.out.println("Escolha uma opcao");
            
            System.out.println("1 - Criar Nave");
            System.out.println("2 - Exibir naves existentes");
            System.out.println("3 - Parar Nave");
            System.out.println("4 - Iniciar Nave");
            System.out.println("6 - Sair");
            opcao = scan.nextInt();
            
            switch (opcao) {
                case 1:
                    System.out.println("Informe o nome da nave");
                    String name = scan.next();
                    Spacecraft spcrf = new Spacecraft(name);
                    spacecraft[contador] = spcrf;
                    contador++;
                    
                    System.out.println("\n =========== Nave Cadastrada com sucesso ===============");
                    System.out.println("Nave: " + spcrf.getName());
                    System.out.println("Velocidade: "  + spcrf.getVelocity());
                    System.out.println("==========================================================\n");
                    
                    break;
                case 2:
                    
                    System.out.println("\n\n ============== Naves Cadastradas ================= ");
                    for (int i = 0; i < contador; i++) {
                        System.out.println(i + " " + spacecraft[i].showSpaceCraft() + "\n");
                    }
                    
                    System.out.println("================================================== \n");
                    break;
                case 3:
                    System.out.println("\n Digite o nro de uma nave pra parar");
                    int nbr = scan.nextInt();
                    
                    if(nbr >= 0 && nbr < contador){
                        spacecraft[nbr].stopSpaceCraft();
                        
                        System.out.println("\n Nave parada com sucesso! \n");
                        break;
                    }
                    
                    System.out.println("Nave nao encontrada");
                    break;
                case 4:
                    System.out.println("\n Digite o numero da nave que deseja iniciar");
                    int nbr2 = scan.nextInt();
                    
                    System.out.println("\n Informe uma velocidade para sua maquina");
                    double v = scan.nextInt();
                    spacecraft[nbr2].startSpaceCraft(v);
                    
                    System.out.println("Nave iniciada com sucesso!");
                    
                default:
                    System.out.println("Opcao nao encontrada");
                    break;
            }
            
        }
        while(opcao != 6 && contador != 5);
    }

    
}
