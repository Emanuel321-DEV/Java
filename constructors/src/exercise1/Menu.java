package exercise1;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        TicketMachine tm = new TicketMachine(2);
        System.out.println("------------------ Sua maquina foi iniciada com sucesso! Hora de vender passagens ------------------- \n ");
        
        Scanner scan = new Scanner(System.in);
        
        while(true){
            
            System.out.println("Escolha uma opcao: ");
            System.out.println("1 - Comprar passagens ");
            System.out.println("2 - Ver total da maquina ");
            int option = scan.nextInt();
            
            // Compro as passagens
            if(option == 1){
                
                System.out.println("\nPreco da passagem: " + tm.getPriceTicket() );
                System.out.println("Valores aceitos: R$ 1,00 e R$ 2,00 ");
            
                System.out.println("Insira um valor na maquina");
                int value = scan.nextInt();
            
                String result = tm.insertMoney(value);
                System.out.println(result);
                
                System.out.println("\n");
            
            } else if(option == 2){ // Imprime o total
                System.out.println("\n =====================================");
                System.out.println(" Valor inserido ate o momento " + tm.getTotalValue());
                System.out.println("===================================== \n ");
            }
                
            

            

        }
    }
    
}
