package br.com.estudo;

import br.com.estudo.models.Usuario;
import br.com.estudo.util.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class RunCap4 {

    public static void main(String[] args) {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 190);

        //lista mutável
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(user1);
        usuarios.add(user2);
        usuarios.add(user3);

        //remoção de itens da lista sem fazer o foreach convencional
        usuarios.removeIf(usuario -> usuario.getPontos() > 120);

        usuarios.forEach(u -> System.out.println(u));



    }
}
