package repository;

import entity.Product;
import entity.SubCategory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class SubCategoryRepository {
    List<SubCategory> listS = new ArrayList<>();

    public List<SubCategory> getAll() {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM SubCategory", SubCategory.class);
            listS = query.getResultList();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return listS;
    }
    public SubCategory getOne(int ID){
        SubCategory sub=null;
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
        transaction=session.beginTransaction();
        sub=session.get(SubCategory.class,ID);
        transaction.commit();
        session.close();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return sub;
    }

    public static void main(String[] args) {
       SubCategoryRepository repo=new SubCategoryRepository();
        List<SubCategory> listS = repo.getAll();
        for (SubCategory list : listS) {
            System.out.println("Hi: " + list);
        }
        System.out.println("Mtam: "+repo.getOne(2));
    }
}
