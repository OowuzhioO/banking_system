package com.hwj.banking.Dao;

import com.hwj.banking.Utils.HibernateUtil;
import com.hwj.banking.Utils.Test;
import com.hwj.banking.entity.User;
import com.hwj.banking.entity.UserDetail;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public int add(User user, UserDetail userDetail) {
        Session session = null;
        Transaction transaction = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.getTransaction();
            transaction.begin();

            user.setUserDetail(userDetail);
            session.persist(user);
            transaction.commit();

            System.out.println("User saved successfully");
            return 1;
        } catch (Exception e) {
            if (transaction != null) {
                System.out.println("Transaction is being rolled back.");
                transaction.rollback();
            }
            e.printStackTrace();
            return -1;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public int delete(User user) {

        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.getTransaction();
            transaction.begin();

//            user.setUserDetail(userDetail);
//            session.persist(user);
            session.delete(user);
            transaction.commit();

            System.out.println("User deleted successfully");
            return 1;
        } catch (Exception e) {
            if (transaction != null) {
                System.out.println("Transaction is being rolled back.");
                transaction.rollback();
            }
            e.printStackTrace();
            return -1;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public int update (User user, UserDetail userDetail) {
        Session session = null;
        Transaction transaction = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.getTransaction();
            User oldUser = session.get(User.class, user.getId());
            oldUser.setuName(user.getuName());
            oldUser.setuPassword(user.getuPassword());
            UserDetail oldUserDetail = session.get(UserDetail.class, user.getId());
            oldUserDetail.setEmail(userDetail.getEmail());
            oldUserDetail.setCelephone(userDetail.getCelephone());
            oldUserDetail.setRemark(userDetail.getRemark());
            oldUser.setUserDetail(oldUserDetail);
//            user.setUserDetail(userDetail);
            transaction.begin();
            session.update(user);
            transaction.commit();

            System.out.println("User updated successfully");
            return 1;
        } catch (Exception e) {
            if (transaction != null) {
                System.out.println("Transaction is being rolled back.");
                transaction.rollback();
            }
            e.printStackTrace();
            return -1;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public String find (int id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.getTransaction();
            transaction.begin();

            User user = session.get(User.class, id);
            transaction.commit();

            System.out.println("User checked successfully");
            return user.toString();
        } catch (Exception e) {
            if (transaction != null) {
                System.out.println("Transaction is being rolled back.");
                transaction.rollback();
            }
            e.printStackTrace();
            return "";
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<User> findAll() {
        Session session = null;
        Transaction transaction = null;
        List<User> userList = new ArrayList<User>();
        Test.test();
        HibernateUtil.test();
//        try {
//            HibernateUtil.test();
//            session = HibernateUtil.getSessionFactory().openSession();
//            transaction = session.getTransaction();
//            transaction.begin();
//
//            userList = session.createQuery("from UserTABLE").list();
//            transaction.commit();
//
//            System.out.println("User checked successfully");
//            return userList;
//        } catch (Exception e) {
//            if (transaction != null) {
//                System.out.println("Transaction is being rolled back.");
//                transaction.rollback();
//            }
//            e.printStackTrace();
//            return userList;
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
        return userList;
    }
}
