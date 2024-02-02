package service.ProductImp;

import entity.Statusa;
import repository.StatusRepository;
import service.ProductInterface;

import java.util.List;

public class StatusServiceImp implements ProductInterface<Statusa,Integer> {
    StatusRepository repo=new StatusRepository();
    @Override
    public List<Statusa> getAll() {
        return repo.getAll();
    }

    @Override
    public Statusa getOne(Integer integer) {
        return repo.getOne(integer);
    }

    @Override
    public boolean insert(Statusa statusa) {
        return false;
    }

    @Override
    public boolean update(Statusa statusa) {
        return false;
    }

    @Override
    public boolean delete(Statusa statusa) {
        return false;
    }

    @Override
    public List<Statusa> getList(Statusa statusa, Integer integer) {
        return null;
    }
}
