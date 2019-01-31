package models.DBmethods;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Building;
import models.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class BuildingMethods {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public static int addBuilding(String address, int numberOfFloors, int commonParts, Integer agentID){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Integer buildingId =null;
        try {
            tx = session.beginTransaction();
                Building bi = new Building(address, numberOfFloors, commonParts, agentID);
            buildingId = (int)session.save(bi);
            bi.setIdBuilding(buildingId);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return buildingId;
    }

    //ALL the BUILDINGS of an AGENT --------------------------------------------------
    public static List getBuildingsWithAgent (int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List attractions = session.createQuery("FROM Building WHERE agentIdAgent = " + id).list();
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
    public static void deleteBuilding(Integer attractionID) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Building attraction = session.get(Building.class, attractionID);
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
