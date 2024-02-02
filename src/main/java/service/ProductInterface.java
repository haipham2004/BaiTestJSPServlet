package service;

import java.util.List;

public interface ProductInterface<E,K> {
    public List<E> getAll();
    public  E getOne(K k);
    public boolean insert(E e);
    public boolean update(E e);
    public boolean delete(E e);
    public List<E> getList(E e,K k);
}
