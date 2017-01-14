package cn.happy.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Created by CKW on 2017/1/12.
 */
public class HibernateUtil {
    private static final ThreadLocal sessionTL=new ThreadLocal();
    private static Configuration cfg;
    private final static SessionFactory factory;
    static {
        try{
            cfg =new Configuration().configure();
            factory=cfg.buildSessionFactory();
        }catch (Throwable ex){
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }

    }
    public static Session currentSession(){
        Session session=(Session)sessionTL.get();

        if (session==null){
            session=factory.openSession();
            sessionTL.set(session);
        }
        return session;
    }
    public static void closeSession(){
        Session session=(Session) sessionTL.get();
        sessionTL.set(null);
        session.close();
    }



}
