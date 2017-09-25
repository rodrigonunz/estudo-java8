package br.com.estudo.util;

@FunctionalInterface
public interface Validator<T> {
    boolean valida(T t);
}
