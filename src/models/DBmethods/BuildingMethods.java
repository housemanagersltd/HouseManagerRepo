package models.DBmethods;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Apartment;
import models.Building;
import models.HibernateUtil;
import models.Resident;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class BuildingMethods {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static int count = 0;

    public static int addBuilding(String address, int numberOfFloors, int commonParts, Integer agentID, int numberOfApartments, Integer agID) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Integer buildingId = null;
        try {
            tx = session.beginTransaction();
            Building bi = new Building(address, numberOfFloors, commonParts, agentID , numberOfApartments, agID);

            buildingId = (int) session.save(bi);
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
    public static List getBuildingsWithAgent(int id) {
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

    //GET ONE ------------------------------------------------------------------------
    public static Building getOne(Integer managerID) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Building manager = (Building) session.get(Building.class, managerID);
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

    // CALCULATE TAX ---------------------------------------------------------------------------
    public static double calculateBuildingTax(int buildingID) {

        List<Resident> reList = new ArrayList<>();

        List<Apartment> apList = ApatrmentMethods.getApartmentsInBuilding(buildingID);

        for (Apartment ap : apList) {
            List<Resident> rr = ResidentMethods.getResidentsInApartment(ap.getIdapartment());
            for (Resident re : rr) {

                reList.add(re);
            }
        }

        Building bu = getOne(buildingID);
        double agSalary = AgentMethods.calculateSalary(bu.getIdBuilding());
        int residentsCount = 0;
        Double tax = (2 * BuildingMethods.getOne(buildingID).getCommonPartsArea() + agSalary);
        for (Resident re : reList) {
            if (re.getIsChild() == (byte) 1 || re.getIsDisabled() == (byte) 1) {
                residentsCount += 0; //  не участват в подялбата на таксите
            } else if (re.getIdResident() == (byte) 1) {
                boolean prezEdin = true;
                if (prezEdin) {
                    residentsCount += 1;
                    prezEdin = !prezEdin;
                } else {
                    prezEdin = !prezEdin;
                }
            }
        }

        count = residentsCount;
        return tax;
    }

    // PER PERSON
    public static double taxPerPerson(int buildingID) {
        double tax = calculateBuildingTax(buildingID);
        double taxPerResident = tax / count;
        return taxPerResident;
    }
}
