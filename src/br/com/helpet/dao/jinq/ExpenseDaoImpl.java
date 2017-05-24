package br.com.helpet.dao.jinq;

import java.sql.Date;
import java.util.List;

import br.com.helpet.dao.ExpenseDao;
import br.com.helpet.entities.Expense;

public class ExpenseDaoImpl extends GenericDao<Expense> implements ExpenseDao{

	public ExpenseDaoImpl(Class<Expense> entityClass) {
		super(entityClass);
	}

	@Override
	public List<String> getSpeciesExpenses() {
		return null;
	}

	@Override
	public List<String> getServicesHistory(String description) {
		return null;
	}

	@Override
	public List<String> getExpensesSummary(Date start, Date end) {
		return null;
	}

	
}
