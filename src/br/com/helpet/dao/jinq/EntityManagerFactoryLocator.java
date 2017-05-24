package br.com.helpet.dao.jinq;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryLocator {	
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("HELPET");
	
	public static EntityManagerFactory getFactory() {
		return factory;
	}
}