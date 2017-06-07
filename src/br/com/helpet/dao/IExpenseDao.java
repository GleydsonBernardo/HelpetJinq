package br.com.helpet.dao;

import java.util.Date;
import java.util.List;

import org.jinq.tuples.Tuple3;

import br.com.helpet.entities.Expense;

public interface IExpenseDao extends IDao<Expense>{

	List<Tuple3<String, Long, Double>> getSpeciesExpenses();
	List<Tuple3<Double, String, Date>> getServicesHistory(String description);
	List<Tuple3<String, Long, Double>> getExpensesSummary(Date start, Date end);
}
