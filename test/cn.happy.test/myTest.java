package cn.happy.test;

import cn.happy.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by CKW on 2017/1/9.
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
        tx= session.beginTransaction();
    }
    @After
    public void myAfter(){
        //5.提交事务
        tx.commit();
        //6.关闭session
        //session.close();
    }
    @Test
    public void addStudent(){
        //4.根据session的方法做数据操作。例如添加 save
        //构建一个狗
        Student stu=new Student();
        //stu.setId(4);
        stu.setAge(2);
        stu.setName("ggggg");
        session.save(stu);
    }
    public static void main(String[] args){
        /* Class<Dog> clazz=Dog.class;
         System.out.println(clazz);*/
    }

    @Test
    public   void updateStudent() {
        //4.根据session的方法做数据操作   修改
        //1. 获取被Hibernate上下文跟踪的狗狗
        Student stu = (Student) session.load(Student.class, 2);

        //2.对狗狗的属性，模拟重新设值
        stu.setName("暗黑破坏神");
        //3.调用update
        // session.update(stu);
    }
    @Test
    public  void findStudent() {
        //4.根据session的方法做数据操作  检索
        Student stu= (Student) session.load(Student.class,4);
        System.out.println(stu.getName());
    }

}
