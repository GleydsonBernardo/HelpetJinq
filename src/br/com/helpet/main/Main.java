package br.com.helpet.main;

import java.util.List;

import br.com.helpet.dao.Dao;
import br.com.helpet.dao.DaoFactory;
import br.com.helpet.entities.Address;
import br.com.helpet.entities.Adoption;
import br.com.helpet.entities.Animal;
import br.com.helpet.entities.Expense;
import br.com.helpet.entities.Person;
import br.com.helpet.entities.Service;

public class Main {
		
	public static void main(String[] args) {
//		addressOperations();
//		adoptionOperations();
//		animalOperations();
//		expenseOperations();
		personOperations();
//		serviceOperations();
	}
	
	public static void addressOperations(){
		Dao<Address> addressDao = DaoFactory.getDao(Address.class);
//		List<Address> addresses = addressDao.list();
//		addresses.forEach(System.out::println);
		addressDao.insert(new Address("Rubem Queiroga", "Paulista", "Pernambuco", "N 704 APt 202 Blc D"));
	}
	
	public static void adoptionOperations(){
		Dao<Adoption> adoptionDao = DaoFactory.getDao(Adoption.class);
		List<Adoption> adoptions = adoptionDao.list();
		adoptions.forEach(System.out::println);
	}
	
	public static void animalOperations(){
		Dao<Animal> animalDao = DaoFactory.getDao(Animal.class);
		List<Animal> animals = animalDao.list();
		animals.forEach(System.out::println);
	}
	
	public static void expenseOperations(){
		Dao<Expense> expenseDao = DaoFactory.getDao(Expense.class);
		List<Expense> expenses = expenseDao.list();
		expenses.forEach(System.out::println);
	}

	public static void personOperations(){
		Dao<Address> addressDao = DaoFactory.getDao(Address.class);
		Address address = addressDao.find(3);
		Dao<Person> personDao = DaoFactory.getDao(Person.class);
//		List<Person> people = personDao.list();
//		people.forEach(System.out::println);
		personDao.insert(new Person("Bernardo", address, "gleydson.bernardo@gmail.com", "123456789", "983123698"));
	}
	
	public static void serviceOperations(){
		Dao<Service> serviceDao = DaoFactory.getDao(Service.class);
		List<Service> services = serviceDao.list();
		services.forEach(System.out::println);
	}
	
}
