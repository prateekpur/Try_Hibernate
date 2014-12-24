package com;

import java.util.Date;
import org.hibernate.Session;

public class App {
  public static void main(String[] args) throws InterruptedException {
    Session session = HibernateUtil.getSessionFactory().openSession();

    session.beginTransaction();

    DBUser user = new DBUser();
    for (int i = 1; i < 99; ++i)  {
      user = new DBUser();
      user.setUserId(i);
      user.setUsername("superman"+i);
      user.setCreatedBy("system");
      user.setCreatedDate(new Date());

      session.save(user);
      //Thread.sleep(200);
      System.out.println(i);
    }

    session.getTransaction().commit();
    session.close();
  }
}