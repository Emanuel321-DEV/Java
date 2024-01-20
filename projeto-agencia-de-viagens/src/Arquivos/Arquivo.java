package Arquivos;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Arquivo {

    public static boolean gravar(Object a, String arquivo) {
        try {

            FileOutputStream arquivoGrav = new FileOutputStream(arquivo);
            ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav);

            objGravar.writeObject(a);
            objGravar.flush();
            objGravar.close();

            arquivoGrav.flush();
            arquivoGrav.close();

            return true;
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo!" + arquivo + " - " + e.toString());
            return false;
        }
    }

    public Object recuperar(String arquivo) {
        Object obj = null;
        FileInputStream arquivoLeitura = null;
        ObjectInputStream objLeitura = null;
        try {
            
            InputStream in = getClass().getResourceAsStream("/Arquivos/" +arquivo);
            BufferedReader reader = new BufferedReader( new InputStreamReader(in) );
            
            objLeitura = new ObjectInputStream(in);

            obj = objLeitura.readObject();
            objLeitura.close();

            objLeitura.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao ler arquivo " + arquivo + " - " + e.toString());
            return null;
        }
        return obj;
    }
    
}
