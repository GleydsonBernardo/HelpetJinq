package br.com.helpet.main;

import java.time.LocalDate;
import java.util.List;

import br.com.helpet.dao.DaoFactory;
import br.com.helpet.dao.IAdoptionDao;
import br.com.helpet.dao.IDao;
import br.com.helpet.dao.IExpenseDao;
import br.com.helpet.dao.jinq.AdoptionDao;
import br.com.helpet.dao.jinq.ExpenseDao;
import br.com.helpet.entities.Address;
import br.com.helpet.entities.Adoption;
import br.com.helpet.entities.Animal;
import br.com.helpet.entities.Expense;
import br.com.helpet.entities.Person;
import br.com.helpet.entities.Service;
import br.com.helpet.util.DateConvertUtils;

public class Main {
		
	public static void main(String[] args) {

		IAdoptionDao adoptionDao = new AdoptionDao();
		List<String> adoptionHistory = adoptionDao.getAdoptionHistory();
		List<String> adoptionSummary = adoptionDao.getAdoptionSummary("Recife");
		
//		adoptionSummary.forEach(System.out::println);
		
		IExpenseDao expenseDao = new ExpenseDao();
		List<String> specieExpenseSummary = expenseDao.getSpeciesExpenses();
		
		specieExpenseSummary.forEach(System.out::println);
		
//		adoptionOperations();
//		animalOperations();
//		expenseOperations();
//		personOperations();
//		serviceOperations();
	}
	
	public static void adoptionOperations(){
		IDao<Adoption> adoptionDao = DaoFactory.getDao(Adoption.class);
		IDao<Person> personDao = DaoFactory.getDao(Person.class);
		IDao<Animal> animalDao = DaoFactory.getDao(Animal.class);
		IDao<Address> addressDao = DaoFactory.getDao(Address.class);
		IDao<Expense> expenseDao = DaoFactory.getDao(Expense.class);
		IDao<Service> serviceDao = DaoFactory.getDao(Service.class);
		Person person = personDao.find(7);
		Animal animal = animalDao.find(7);
		Service banho = serviceDao.find(2);
		Service consulta = serviceDao.find(3);
		Service tosa = serviceDao.find(1);
		LocalDate date = LocalDate.of(2017, 10, 22);
		Expense expense = new Expense(animal, banho, DateConvertUtils.asUtilDate(date));
		Expense expense2 = new Expense(animal, tosa, DateConvertUtils.asUtilDate(date));
		Expense expense3 = new Expense(animal, consulta, DateConvertUtils.asUtilDate(date));
//		adoptionDao.insert(new Adoption(animal, person, DateConvertUtils.asUtilDate(date)));
//		animal.setPerson(person);
//		animalDao.update(animal);
		expenseDao.insert(expense);
		expenseDao.insert(expense2);
		expenseDao.insert(expense3);
		
		
//		List<Adoption> adoptions = adoptionDao.list();
//		adoptions.forEach(System.out::println);
	}
	
	public static void animalOperations(){
		IDao<Animal> animalDao = DaoFactory.getDao(Animal.class);
		animalDao.insert(new Animal("Urso", "Pardo", "M", 345.7, 3, "Kawaii", null));
//		List<Animal> animals = animalDao.list();
//		animals.forEach(System.out::println);
	}
	
	public static void expenseOperations(){
		IDao<Expense> expenseDao = DaoFactory.getDao(Expense.class);
		List<Expense> expenses = expenseDao.list();
		expenses.forEach(System.out::println);
	}

	public static void personOperations(){
		IDao<Address> addressDao = DaoFactory.getDao(Address.class);
		Address address = addressDao.find(2);
		IDao<Person> personDao = DaoFactory.getDao(Person.class);
		personDao.insert(new Person("Princesa", address, "gleydson.bernardo@gmail.com", "123456789", "983123698"));
//		personDao.delete(3);
	}
	
	public static void serviceOperations(){
		IDao<Service> serviceDao = DaoFactory.getDao(Service.class);
		List<Service> services = serviceDao.list();
		services.forEach(System.out::println);
	}
	
}
