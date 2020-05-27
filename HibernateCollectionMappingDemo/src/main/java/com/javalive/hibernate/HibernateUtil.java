package com.javalive.hibernate;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.javalive.entity.UserDetails;

/**
 * @author javalive.com 
 *         Hibernate provides the facility to persist the
 *         collections. A collection can be a list, set, map, collection, sorted
 *         set, sorted map. java.util.List, java.util.Set, java.util.Collection,
 *         java.util.SortedSet, java.util.SortedMap etc. are the real interface
 *         types to declared the persistent collection-valued fields. Hibernate
 *         injects persistent collections based on the type of interface. The
 *         collection instances usually behave likes the types of value
 *         behavior. Instances of collections are auto persisted if a
 *         persistent object refers it and are deleted automatically if it is
 *         not referred through. Elements of collection may shift from one table
 *         to another when a persistent object passed the collection to another
 *         persistent object.
 */
public class HibernateUtil {

	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

				Map<String, Object> settings = new HashMap<>();
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/test1?useSSL=false");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "root");
				settings.put(Environment.HBM2DDL_AUTO, "create");

				registryBuilder.applySettings(settings);
				registry = registryBuilder.build();
				MetadataSources sources = new MetadataSources(registry).addAnnotatedClass(UserDetails.class);
				Metadata metadata = sources.getMetadataBuilder().build();
				sessionFactory = metadata.getSessionFactoryBuilder().build();
			} catch (Exception e) {
				if (registry != null) {
					StandardServiceRegistryBuilder.destroy(registry);
				}
				e.printStackTrace();
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
