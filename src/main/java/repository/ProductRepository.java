package repository;

import entity.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;


public class ProductRepository {
    List<Product> listP = new ArrayList<>();
    public List<Product> getAll() {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Product", Product.class);
            listP = query.getResultList();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return listP;
    }
    public boolean insert(Product prd){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.save(prd);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public boolean update(Product prd){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.update(prd);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public boolean delete(Product prd){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.delete(prd);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public Product getOne(int ID){
        Product prd=null;
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            prd=session.get(Product.class,ID);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return prd;
    }
    public List<Product> getList(int IDSubCategory,int IDStatus){
       Transaction transaction=null;
       try(Session session=HibernateUtil.getFACTORY().openSession()){
          transaction=session.beginTransaction();
          Query query= session.createQuery("FROM  Product  prd where prd.IDSubCategory=:maCate and prd.IDStatus=:IDStatus",Product.class);
          query.setParameter("IDSubCategory",IDSubCategory);
          query.setParameter("IDStatus",IDStatus);
          listP=query.getResultList();
          transaction.commit();
          session.close();
       }catch (Exception e){
           e.printStackTrace();
           return null;
       }
       return listP;
    }
    public static void main(String[] args) {
        ProductRepository repo = new ProductRepository();
        List<Product> listP = repo.getAll();
        for (Product list : listP) {
            System.out.println("Hi: " + list);
        }
//        double ID=2;
//        Product prd=repo.getOne(ID);
//        System.out.println("Hi2: "+prd);
//        SubCategory sub=new SubCategory(2);
//        Statusa sta=new Statusa(1);
////
//        Product product = new Product(3,sub, "Mitsubishi Xpander", "Đen",20, 50000, 650000,sta);
//        repo.update(product);
//        List<Product> listP2 = repo.getList(2,1);
//        for (Product list : listP2) {
//            System.out.println("Hi: " +list);
        }
    }

