package cn.happy.test;

import cn.happy.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by CKW on 2017/1/12.
 */
public class myTest {
    Configuration cfg;
    Session session;
    Transaction tx;
    @Before
    public void myBefore(){
        //创建配置对象
        cfg=new Configuration().configure();

        // 2.根据配置对象创建SessionFactory
        SessionFactory factory=cfg.buildSessionFactory();

        //3.根据SessionFactory去创建Session
        session= factory.getCurrentSession();

        //3.5在Session创建后开启事务
        //tx= session.beginTransaction();
    }
    @After
    public void myAfter(){
        //5.提交事务
        //tx.commit();
        //6.关闭session
        //session.close();
    }

    @Test
    public void find(){
        tx= session.beginTransaction();

        Student stu= (Student)session.load(Student.class,1);
        System.out.printf("");
        tx.commit();
    }

}
