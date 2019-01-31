package models.DBmethods;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.HibernateUtil;
import models.Resident;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

//ADD RESIDENT----------------------------------------------------------------------
public class ResidentMethods {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public static int addResident(String name, String status, int idApartment) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Integer residentID = null;
        try {
            tx = session.beginTransaction();
            Resident re = new Resident(name, status, idApartment);
            residentID = (int) session.save(re);
            re.setIdResident(residentID);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return residentID;
    }

    //ALL the RESIDENTS in a specific APARTMENT -------------------------------------------
    public static List getResidentsInApartment(int apartmentID) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List attractions = session.createQuery("FROM Resident WHERE apartmentIdapartment = " + apartmentID).list();
            ObservableList attractionOfASelectedPark = FXCollections.observableArrayList(attractions);
            tx.commit();
            return attractionOfASelectedPark;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    // DELETE --------------------------------------------------------------------------
    public static void deleleteAgent(Integer attractionID) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Resident attraction = session.get(Resident.class, attractionID);
            session.delete(attraction);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}