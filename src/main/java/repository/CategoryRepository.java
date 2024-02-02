package repository;

import entity.Category;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {
    List<Category> listSta = new ArrayList<>();

    public List<Category> getAll() {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Category", Category.class);
            listSta = query.getResultList();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return listSta;
    }

    public static void main(String[] args) {
        CategoryRepository repo=new CategoryRepository();
        List<Category> listS = repo.getAll();
        for (Category listSa : listS) {
            System.out.println("Hi: " + listSa);
        }
    }
}
