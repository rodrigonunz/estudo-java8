package br.com.estudo;

import br.com.estudo.models.Usuario;

import java.util.*;

public class RunCap5 {

    public static void main(String[] args) {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 190);

        //lista mutável
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(user1);
        usuarios.add(user2);
        usuarios.add(user3);

        //através da classe Collections
        //lambda padrão
        Collections.sort(usuarios, (u1, u2) -> u1.getNome().compareTo(u2.getNome()));
        //method reference
        Collections.sort(usuarios, Comparator.comparing(Usuario::getNome));

        //através do default method na interface Iterable
        usuarios.sort(Comparator.comparing(Usuario::getNome));


        usuarios.forEach(usuario -> System.out.println(usuario));

        List<String> palavras = Arrays.asList("Rodrigo", "Amanda", "Pedro");
        //ordem natural alfabetica
        palavras.sort(Comparator.naturalOrder());
        palavras.forEach(s -> System.out.println(s));
        //ordem reversa
        palavras.sort(Comparator.reverseOrder());
        palavras.forEach(s -> System.out.println(s));

        //comparing Int evita o autoboxing de int para Integer
        System.out.println("Ordenados por pontos");
        usuarios.sort(Comparator.comparingInt(value -> value.getPontos()));
        usuarios.forEach(s -> System.out.println(s));


    }
}
