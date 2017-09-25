package br.com.estudo;

import br.com.estudo.models.Usuario;
import br.com.estudo.util.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class RunCap1for3 {

    public static void main(String[] args) {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 190);

        //lista imutavel
        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        //impressao com o método foreach
        usuarios.forEach(u -> System.out.println(u.getNome()));

        //impressao utilizando o method reference
        usuarios.forEach(System.out::println);

        //utilizando classes anonimas
        usuarios.forEach(new Consumer<Usuario>() {
            @Override
            public void accept(Usuario usuario) {
                System.out.println(usuario.getNome());
            }
        });

        //thread que conta de 1 a 1000 com lambda
        new Thread(() -> {
            for (int i = 0; i <= 1000; i++) {
                System.out.println(i);
            }
        }).start();

        //validator de cep com lambda
        Validator<String> validatorCep = cepDigitado -> cepDigitado.matches("[0-9]{5}-[0-9]{3}");
        validatorCep.valida("15140-000");

        //utilização do andThen
        usuarios.forEach(((Consumer<Usuario>) usuario -> System.out.println("Antes de imprimir os nomes")
        ).andThen(usuario -> System.out.println(usuario)));


    }
}
