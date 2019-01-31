package models.DBmethods;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Apartment;
import models.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ApatrmentMethods {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public static int addApartment(String ownerFamily, int number, int buildingId){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Integer apartmentID =null;
        try {
            tx = session.beginTransaction();
            Apartment ap = new Apartment(ownerFamily, number, buildingId);
            buildingId = (int)session.save(ap);
            ap.setIdapartment(apartmentID);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return apartmentID;
    }

    //ALL the APARTMENTS in a specific BUILDING -----------------------------------------------
    public static List getApartmentsInBuilding(int apartmentID) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List attractions = session.createQuery("FROM Apartment WHERE buildingIdBuilding = " + apartmentID).list();
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

    //GET ONE ------------------------------------------------------------------------
    public static Apartment getOne(Integer managerID){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Apartment manager = (Apartment) session.get(Apartment.class, managerID);
            tx.commit();
            return manager;
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
    public static void deleteApartment(Integer attractionID) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Apartment attraction = session.get(Apartment.class, attractionID);
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
