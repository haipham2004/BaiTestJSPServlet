package service.ProductImp;

import entity.SubCategory;
import repository.SubCategoryRepository;
import service.ProductInterface;

import java.util.List;

public class SubCategoryServiceImp implements ProductInterface<SubCategory,Integer> {
    SubCategoryRepository repo=new SubCategoryRepository();
    @Override
    public List<SubCategory> getAll() {
        return repo.getAll();
    }

    @Override
    public SubCategory getOne(Integer integer) {
        return repo.getOne(integer);
    }

    @Override
    public boolean insert(SubCategory subCategory) {
        return false;
    }

    @Override
    public boolean update(SubCategory subCategory) {
        return false;
    }

    @Override
    public boolean delete(SubCategory subCategory) {
        return false;
    }

    @Override
    public List<SubCategory> getList(SubCategory subCategory, Integer integer) {
        return null;
    }
}
