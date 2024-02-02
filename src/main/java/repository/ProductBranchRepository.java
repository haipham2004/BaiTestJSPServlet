package repository;
import entity.ProductBranch;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class ProductBranchRepository {
    List<ProductBranch> listProductBranch = new ArrayList<>();
    public List<ProductBranch> getAll() {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            // Viết giống tên class nhé
            Query query = session.createQuery("FROM ProductBranch", ProductBranch.class);
            listProductBranch = query.getResultList();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return listProductBranch;
    }
    public static void main(String[] args) {
        ProductBranchRepository repo=new ProductBranchRepository();
        List<ProductBranch> listS = repo.getAll();
        for (ProductBranch listSa : listS) {
            System.out.println("Hi: " + listSa);
        }
    }
}
