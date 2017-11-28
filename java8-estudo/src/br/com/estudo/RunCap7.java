package br.com.estudo;

import br.com.estudo.models.Usuario;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RunCap7 {

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

        //tornando moderadores os usuarios com mais pontos
        Stream<Usuario> stream = usuarios.stream().filter(usuario -> usuario.getPontos() > 100);
        stream.forEach(Usuario::tornaModerador);


        //filtrando os usuários, ordenando e trazendo uma nova lista com o resultado
        List<Usuario> collect = usuarios.stream().filter(usuario -> usuario.getPontos() > 100)
                .sorted(Comparator.comparing(Usuario::getNome))
                .collect(Collectors.toList());


        //recupera todos os pontos dos usuarios  e faz a média, se a lista é vazia retorna um positivo infito
        // então com o orElse você trata isso
        double v = usuarios.stream().mapToInt(Usuario::getPontos)
                .average()
                .orElse(0.0);

        //faz a média de pontos, se a média for realmente calculada o ifPresent entra em ação e ececuta o Consumer dele
        usuarios.stream().mapToInt(Usuario::getPontos)
                .average()
                .ifPresent(value -> RunCap7.atulizaValor(value));

        //filtra os usuários com mais que 100 pontos e pede para o strem recuperar qualquer um deles
        // (recupera o que encontrar mais rapido de acordo com sua interação interna)
        Optional<Usuario> any = usuarios.stream().filter(usuario -> usuario.getPontos() > 100).findAny();

    }

    public static void atulizaValor(double v1) {
    }
}
