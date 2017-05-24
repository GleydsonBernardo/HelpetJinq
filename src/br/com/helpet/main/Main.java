package br.com.helpet.main;

import java.util.List;

import br.com.helpet.dao.AdoptionDao;
import br.com.helpet.dao.Dao;
import br.com.helpet.dao.DaoFactory;
import br.com.helpet.dao.jinq.AdoptionDaoImpl;
import br.com.helpet.entities.Adoption;
import br.com.helpet.entities.Expense;

public class Main {
	public static void main(String[] args) {
		
		AdoptionDao dao = new AdoptionDaoImpl();
		List<String>adoption = dao.getAdoptionHistory();
		adoption.forEach(System.out::println);
		
	}
}
