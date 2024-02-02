package repository;

import entity.Branch;
import entity.Statusa;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class BranchRepository {
    List<Branch> listBranch = new ArrayList<>();
    public List<Branch> getAll() {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            // Viết giống tên class nhé
            Query query = session.createQuery("FROM Branch", Branch.class);
            listBranch = query.getResultList();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return listBranch;
    }
//    public Branch getOne(int ID){
//        Transaction transaction=null;
//        Statusa sta=null;
//        try(Session session=HibernateUtil.getFACTORY().openSession()){
//            transaction=session.beginTransaction();
//            sta=session.get(Statusa.class,ID);
//            transaction.commit();
//            session.close();
//        }catch (Exception e){
//            e.printStackTrace();
//            return null;
//        }
//        return sta;
//    }

    public static void main(String[] args) {
        BranchRepository repo=new BranchRepository();
        List<Branch> listS = repo.getAll();
        for (Branch listSa : listS) {
            System.out.println("Hi: " + listSa);
        }
    }
}
