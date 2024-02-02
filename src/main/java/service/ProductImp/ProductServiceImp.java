package service.ProductImp;
import entity.Product;
import repository.ProductRepository;
import service.ProductInterface;

import java.util.List;

public class ProductServiceImp implements ProductInterface<Product,Integer> {
ProductRepository repo=new ProductRepository();

    @Override
    public List<Product> getAll() {
        return repo.getAll();
    }

    @Override
    public Product getOne(Integer integer) {
        return repo.getOne(integer);
    }

    @Override
    public boolean insert(Product product) {
        return repo.insert(product);
    }

    @Override
    public boolean update(Product product) {
        return repo.update(product);
    }

    @Override
    public boolean delete(Product product) {
        return repo.delete(product);
    }

    @Override
    public List<Product> getList(Product product, Integer integer) {
        return null;
    }
}
