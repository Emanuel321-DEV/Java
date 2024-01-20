package Repositorios;
import Arquivos.Arquivo;
import Interfaces.IRepositorio;
import Entidades.Pessoa.Usuario;
import java.util.ArrayList;

public class UsuariosRepositorio implements IRepositorio{
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    
    public UsuariosRepositorio(){
        usuarios = (ArrayList<Usuario>) new Arquivo().recuperar("usuarios.dat");
    }
    
    @Override
    public ArrayList<Usuario> getDados(){
        return usuarios;
    }
    
    @Override
    public boolean setDados(Object obj){
        try {
            Usuario usuario = (Usuario) obj;
            this.usuarios.add(usuario);
            return true;
        } catch(Exception ex){
            System.out.println(ex.toString());
            return false;
        }
        
    }
    
    @Override
    public void mostraDados(){
        int contador = 1;
        for (Usuario usuario : usuarios) {
            System.out.println((contador + 1) + " - " + usuario.getNome());
        }
        contador++;
    }
    
}
