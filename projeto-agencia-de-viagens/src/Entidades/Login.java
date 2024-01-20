package Entidades;

import Entidades.Pessoa.Usuario;
import Interfaces.ILogin;
import java.util.List;

public class Login implements ILogin {
    @Override
    public Usuario validate(List<Usuario> usuarios, String email, String senha){
        for (int i = 0; i < usuarios.size() && usuarios.get(i) != null; i++) {
            if (usuarios.get(i).getEmail().equals(email) && usuarios.get(i).getSenha().equals(senha)) {
                return usuarios.get(i);
            }
        }
        return null;
    }
}