package models.DBmethods;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Agent;
import models.Building;
import models.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.LinkedList;
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

    //CALCULATE SALARY --------------------------------------------------------------------
    public static double calculateSalary(){
        List<Building> buList = new LinkedList<>();

        return 20.0;
    }
}
