package br.com.estudo;

import br.com.estudo.models.Usuario;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RunCap8 {

    public static void main(String[] args) {
        BiFunction<String, Integer, Usuario> criadorDeUsuarios = Usuario::new;


        Usuario user1 = criadorDeUsuarios.apply("Paulo Silveira", 150);
        Usuario user2 = criadorDeUsuarios.apply("Rodrigo Turini", 120);
        Usuario user3 = criadorDeUsuarios.apply("Guilherme Silveira", 190);
        Usuario user4 = criadorDeUsuarios.apply("Maria", 99);

        //lista mutável
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(user1);
        usuarios.add(user2);
        usuarios.add(user3);
        usuarios.add(user4);


        //o método peek, interage com o objeto (podendo imprimir, ou fazer alguma coisa) em sua interação interna, percebendo que ele não faz for na coleção inteira
        // faz uma forma de execução lazy, faz o filtro e assim que pega o elemento > 100 retorna-o, sem precisar continuar
        usuarios.stream()
                .filter(u -> u.getPontos() > 100)
                .peek(System.out::println)
                .findAny();

        //recupera a maxima pontuação, o stream retorna um Optional e com o get recupero o valor
        //o max e o min precisam de um comparator
        Optional<Usuario> max = usuarios.stream()
                .max(Comparator.comparing(Usuario::getPontos));
        Usuario maximaPontuacao = max.get();

    }

}
