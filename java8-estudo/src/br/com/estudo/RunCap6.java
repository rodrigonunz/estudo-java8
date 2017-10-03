package br.com.estudo;

import br.com.estudo.models.Usuario;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class RunCap6 {

    public static void main(String[] args) {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 190);

        //lista mutável
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(user1);
        usuarios.add(user2);
        usuarios.add(user3);

        //tornando todos moderados por method reference
        usuarios.forEach(Usuario::tornaModerador);
        //ordena pela maior pontuação
        usuarios.sort(Comparator.comparingInt(Usuario::getPontos));
        //ordena pela maior pontuação e se houver empate compara por nome
        usuarios.sort(Comparator.comparing(Usuario::getPontos).thenComparing(Usuario::getNome));
        //deixar os nomes nulos por ultimo na lista
        usuarios.sort(Comparator.nullsLast(Comparator.comparing(Usuario::getNome)));

        //ordena por pontos em ordem decrescente
        usuarios.sort(Comparator.comparing(Usuario::getPontos).reversed());

        //6.4 Referenciando métodos de instância
        Usuario rodrigo = new Usuario("Rodrigo Turini", 50);
        Runnable bloco = rodrigo::tornaModerador;
        bloco.run();

        //ou crio um consumer que aceita um objeto do tipo Usuario e invoco pelo método acept
        Consumer<Usuario> tornaModerador = Usuario::tornaModerador;
        tornaModerador.accept(rodrigo);

        usuarios.forEach(System.out::println);

        //6.6 Referenciando construtores
        //usar um supplier para gerar novos objetos com method constructor (construtor padrão)
        Supplier<Usuario> criadorDeUsuarios = Usuario::new;
        Usuario usuario = criadorDeUsuarios.get();

        //criar usuario com um construtor com parâmetros
        Function<String, Usuario> criadorDeUsuarios2 = Usuario::new;
        Usuario rodrigo_nunes = criadorDeUsuarios2.apply("Rodrigo Nunes");

        //criar com 2 argumentos
        BiFunction<String, Integer, Usuario> criadorDeUsuarios3 = Usuario::new;
        Usuario rodrigo1 = criadorDeUsuarios3.apply("Rodrigo", 100);



    }
}
