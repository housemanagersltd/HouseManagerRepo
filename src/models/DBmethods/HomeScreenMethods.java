package models.DBmethods;

import models.HibernateUtil;
import models.Resident;
import org.hibernate.SessionFactory;

import java.util.List;

public class HomeScreenMethods {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public static void monthlyUpdate(){
        List<Resident> li = ResidentMethods.getAllResidents();
        for(Resident re : li){
            ResidentMethods.updateHasPaid(re.getIdResident(),  Byte.valueOf((byte) 0));
        }

    }

}
