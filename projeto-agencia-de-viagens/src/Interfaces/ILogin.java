package Interfaces;

import Entidades.Pessoa.Usuario;
import java.util.List;

public interface ILogin {
    public Usuario validate(List<Usuario> u, String email, String senha);
}