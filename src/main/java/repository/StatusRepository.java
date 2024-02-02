package repository;

import entity.Statusa;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class StatusRepository {
    List<Statusa> listSta = new ArrayList<>();
    public List<Statusa> getAll() {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            // Viết giống tên class nhé
            Query query = session.createQuery("FROM Statusa", Statusa.class);
            listSta = query.getResultList();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return listSta;
    }
    public Statusa getOne(int ID){
        Transaction transaction=null;
        Statusa sta=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
           transaction=session.beginTransaction();
           sta=session.get(Statusa.class,ID);
           transaction.commit();
           session.close();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return sta;
    }

    public static void main(String[] args) {
        StatusRepository repo=new StatusRepository();
        List<Statusa> listS = repo.getAll();
        for (Statusa listSa : listS) {
            System.out.println("Hi: " + listSa);
        }
        System.out.println("Tên: "+repo.getOne(2));
    }
}
