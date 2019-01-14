package com.hwj.banking.Utils;


import com.hwj.banking.entity.User;
import com.hwj.banking.entity.UserDetail;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.HashMap;
import java.util.Map;

public class HibernateUtil {
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;
    public static void test() {
        System.out.println("test Hibernate");
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
                Map<String, String> settings = new HashMap<String, String>();
                settings.put("hibernate.connection.driver_class", "oracle.jdbc.driver.OracleDriver");
                settings.put("hibernate.connection.url", "jdbc:oracle:thin:@184.73.73.65:49161:xe");
                settings.put("hibernate.connection.username", "HWJ");
                settings.put("hibernate.connection.password", "123456");
                settings.put("hibernate.show_sql", "true");
                settings.put("hibernate.hbm2ddl.auto", "update");

                registry = registryBuilder.applySettings(settings).build();
                MetadataSources sources = new MetadataSources(registry)
                        .addAnnotatedClass(User.class)
                        .addAnnotatedClass(UserDetail.class);

                Metadata metadata = sources.getMetadataBuilder().build();

                sessionFactory = metadata.getSessionFactoryBuilder().build();
            } catch (Exception e) {
                System.out.println("SessionFactory creation failed");
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }

    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

}




//package com.hwj.banking.Utils;
//
//        import com.hwj.banking.entity.User;
//        import com.hwj.banking.entity.UserDetail;
//        import  org.hibernate.service.*;
//        import org.hibernate.SessionFactory;
//        import org.hibernate.boot.Metadata;
//        import org.hibernate.boot.MetadataSources;
//        import org.hibernate.boot.registry.StandardServiceRegistry;
//        import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//
//        import java.util.HashMap;
//        import java.util.Map;

//public class HibernateUtil {
//    private static StandardServiceRegistry registry;
//    private static SessionFactory sessionFactory;
//
//    public static void test() {
//        System.out.println("test Hibernate ");
//    }
//
//    public static SessionFactory getSessionFactory() {
//        System.out.println("entering getSessionFactory");
//        if (sessionFactory == null) {
//            try {
//                StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
//
//                Map<String, String> settings = new HashMap<String, String>();
//                settings.put("hibernate.connection.driver_class", "oracle.jdbc.driver.OracleDriver");
//                settings.put("hibernate.connection.url", "jdbc:oracle:thin:@184.73.73.65:49161:xe");
//                settings.put("hibernate.connection.username", "HWJ");
//                settings.put("hibernate.connection.password", "123456");
//                settings.put("hibernate.show_sql", "true");
//                settings.put("hibernate.hbm2ddl.auto", "update");
//
//                registry = registryBuilder.applySettings(settings).build();
//
//                MetadataSources sources = new MetadataSources(registry)
//                        .addAnnotatedClass(User.class)
//                        .addAnnotatedClass(UserDetail.class);
//
//                Metadata metadata = sources.getMetadataBuilder().build();
//
//                sessionFactory = metadata.getSessionFactoryBuilder().build();
//            } catch (Exception e) {
//                System.out.println("SessionFactory creation failed");
//                if (registry != null) {
//                    StandardServiceRegistryBuilder.destroy(registry);
//                }
//            }
//        }
//        return sessionFactory;
//    }
//
//    public static void shutdown() {
//        if (registry != null) {
//            StandardServiceRegistryBuilder.destroy(registry);
//        }
//    }
//}
