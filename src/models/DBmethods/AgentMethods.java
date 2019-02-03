package models.DBmethods;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AgentMethods {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public static int addAgent(String name){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Integer agentID =null;
        try {
            tx = session.beginTransaction();
            Agent ag = new Agent(name);
            agentID = (int)session.save(ag);
            ag.setIdAgent(agentID);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return agentID;
    }

    //ALL AGENTS ----------------------------------------------------------
    public static ObservableList<Agent> getAgents() {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List attractions = session.createQuery("FROM Agent ").list();
            ObservableList<Agent> attractionsOL = FXCollections.observableArrayList(attractions);
            tx.commit();
            return attractionsOL;
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
            Agent attraction = session.get(Agent.class, attractionID);
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

    //GET ONE ------------------------------------------------------------------------
    public static Agent getOne(Integer managerID){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Agent manager = (Agent) session.get(Agent.class, managerID);
            tx.commit();

            //manager.setIdAgent();
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

    //CALCULATE SALARY --------------------------------------------------------------------
    public static double calculateSalary(int agentID){
        List<Resident> reList = new ArrayList<>();
        List<Apartment> apList = new ArrayList<>();
        List<Building> buList = BuildingMethods.getBuildingsWithAgent(agentID);
        for(Building bu: buList){
                apList = ApatrmentMethods.getApartmentsInBuilding(bu.getIdBuilding());
                for(Apartment ap: apList){
                    List<Resident> rr = ResidentMethods.getResidentsInApartment(ap.getIdapartment());
                        for(Resident re: rr ){
                            reList.add(re);
                        }
                }
        }
        Double salary = 0.0;
        for(Resident re: reList){
            salary += 3.5; // 3.5$ per resident.
        }
        return salary;
    }
    //REGISTER PAYMENT ----------------------------------------------------------------------
    public static void registerPayment(int residentID, Byte b){
        ResidentMethods.updateHasPaid(residentID, b);
    }

}
