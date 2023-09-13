package org.example;

import java.util.List;

public interface Repository <T, K>{
    K add(T item);
    List<T> readAll();
    T read(K id);
    boolean update(T item);
    boolean delete(K id);
}

