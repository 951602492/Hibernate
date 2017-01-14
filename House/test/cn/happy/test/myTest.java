package cn.happy.test;


import cn.happy.house.House;
import cn.happy.house.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by Happy on 2017-01-08.
 */
public class myTest {
    Configuration cfg;
    Session session;
    Transaction tx;
    @Before
    public void myBefore(){
        //创建配置对象"Hibernate.cfg.xml"
        cfg=new Configuration().configure();

        // 2.根据配置对象创建SessionFactory
        SessionFactory factory=cfg.buildSessionFactory();

        //3.根据SessionFactory去创建Session
        session= factory.getCurrentSession();

        //3.5在Session创建后开启事务   xxx0001    xxxxx003
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
    //动态参数绑定
    public void selectUsers(){

        StringBuilder hql=new StringBuilder("from House where 1=1 ");
        House house=new House();
        house.setPrice("80");
        house.setUser_id(2);
        //house.setPubdate(new Date());
        if(house.getPrice()!=null){
            hql.append(" and price=:price ");
        }
        if(house.getUser_id()!=null){
            hql.append(" and user_id=:user_id ");
        }
//        if (house.getPubdate()!=null){
//            hql.append("and pubdate=:pubdate");
//        }
        Query query = session.createQuery(hql.toString());
        query.setProperties(house);
        List<House> list = query.list();
        for (House item:list) {
            System.out.println(item.getTitle()+"\t"+item.getFioorage()+"\t"+item.getContact());
        }
    }

    @Test
    //检索面积大于80平米
    public void selectHouse(){

        StringBuilder hql=new StringBuilder("from House where 1=1 ");
        House house=new House();
        house.setTitle("%床%");
        house.setFioorage(80);
        if(house.getTitle()!=null){
            hql.append(" and title like :title ");
        }
        if(house.getFioorage()!=null){
            hql.append(" and fioorage > :fioorage ");
        }
        Query query = session.createQuery(hql.toString());
        query.setProperties(house);
        List<House> list = query.list();
        for (House item:list) {
            System.out.println(item.getTitle()+"\t"+item.getFioorage()+"\t"+item.getContact());
        }
    }


    @Test
    //检索用户名为嘿嘿的用户
    public void selectPartTest(){
        //案例：检索所有的新闻
        String hql="from Users where name='嘿嘿'";
        //谁来执行
        Query query = session.createQuery(hql);
        //我要List<News>
        List<Users> list = query.list();
        for (Users item:list) {
            System.out.println("编号："+item.getId()+"\t用户名："+item.getName()+"\t密码："+item.getPassword()+"\t电话："+item.getTelephone()+"\t姓名："+item.getUsername()+"\t是否是管理员："+item.getIsadmin());
        }
    }

    @Test
    //检索所有用户
    public void selectAllUsers(){
        //案例：检索所有的用户信息
        String hql="from Users";

        Query query = session.createQuery(hql);

        List<Users> list = query.list();
        for (Users item:list) {
            System.out.println("编号："+item.getId()+"\t用户名："+item.getName()+"\t密码："+item.getPassword()+"\t电话："+item.getTelephone()+"\t姓名："+item.getUsername()+"\t是否是管理员："+item.getIsadmin());
        }
    }

}
