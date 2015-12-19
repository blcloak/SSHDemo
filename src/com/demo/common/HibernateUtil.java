package com.demo.common;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;

	static {
		try {
			Configuration cfg = new Configuration().configure();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties())
					.build();

			sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		} catch (Throwable e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	private HibernateUtil() {
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
