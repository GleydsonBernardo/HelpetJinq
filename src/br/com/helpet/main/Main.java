package br.com.helpet.main;

import java.util.List;

import br.com.helpet.dao.Dao;
import br.com.helpet.dao.DaoFactory;
import br.com.helpet.entities.Animal;

public class Main {
	public static void main(String[] args) {
		
		Dao<Animal> dao = DaoFactory.getDao(Animal.class);
		//List<Animal> animals = dao.list();
		//animals.forEach(System.out::println);
		Animal animal = dao.find(1);
		
	}
}
