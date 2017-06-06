package br.com.helpet.dao.jinq;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.com.helpet.dao.DaoFactory;
import br.com.helpet.dao.IDao;
import br.com.helpet.dao.IExpenseDao;
import br.com.helpet.entities.Expense;
import sun.net.www.content.audio.x_aiff;

public class ExpenseDao extends GenericDao<Expense> implements IExpenseDao{

	public ExpenseDao() {
		super(Expense.class);
	}

	@Override
	public List<String> getSpeciesExpenses() {
		IDao<Expense> expenseDao = DaoFactory.getDao(Expense.class);
		List<Expense> expensesRaw = expenseDao.list();
		return expensesRaw.stream()
					.map(x -> "Espécie: " + x.getAnimal().getSpecie() + " - Quant. Serviços: "+ expensesRaw.stream()
							.filter(y -> y.getAnimal().getSpecie().equals(x.getAnimal().getSpecie())).map(y -> y.getService()).count()+
							" - Gastos: "+ expensesRaw.stream().filter(y -> y.getAnimal().getSpecie().equals(x.getAnimal().getSpecie()))
							.mapToDouble(y ->y.getService().getValue()).sum())
					.sorted()
					.distinct()
					.limit(10)
					.collect(Collectors.toList());			
	}

	@Override
	public List<String> getServicesHistory(String description) {
		IDao<Expense> expenseDao = DaoFactory.getDao(Expense.class);
		List<Expense> expensesRaw = expenseDao.list();
		return expensesRaw.stream()
					.map(x -> "Serviço: "+description + " - Valor: "+ expensesRaw.stream()
							.filter(y -> y.getService().getDescription().equals(description)).mapToDouble(y -> y.getService().getValue())+
							" - Gastos: "+ expensesRaw.stream().filter(y -> y.getAnimal().getSpecie().equals(x.getAnimal().getSpecie()))
							.mapToDouble(y ->y.getService().getValue()).sum())
					.sorted()
					.distinct()
					.collect(Collectors.toList());	
	}

	@Override
	public List<String> getExpensesSummary(Date start, Date end) {
		IDao<Expense> expenseDao = DaoFactory.getDao(Expense.class);
		List<Expense> expensesRaw = expenseDao.list();
		return expensesRaw.stream()
					.map(x -> "Serviço: " + x.getService().getDescription() + " - Quant. Serviços: "+ expensesRaw.stream()
							.filter(y -> y.getAnimal().getSpecie().equals(x.getAnimal().getSpecie())).map(y -> y.getService()).count()+
							" - Gastos: "+ expensesRaw.stream().filter(y -> y.getAnimal().getSpecie().equals(x.getAnimal().getSpecie()))
							.mapToDouble(y ->y.getService().getValue()).sum())
					.sorted()
					.distinct()
					.collect(Collectors.toList());	
	}

	
}
