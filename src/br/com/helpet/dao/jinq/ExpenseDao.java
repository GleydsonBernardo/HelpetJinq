package br.com.helpet.dao.jinq;

import java.util.Date;
import java.util.List;

import org.jinq.tuples.Tuple3;

import br.com.helpet.dao.IExpenseDao;
import br.com.helpet.entities.Expense;

public class ExpenseDao extends GenericDao<Expense> implements IExpenseDao{

	public ExpenseDao() {
		super(Expense.class);
	}

	@Override
	public List<Tuple3<String, Long, Double>> getSpeciesExpenses() {
		return super.getStream()
					.group(
						e -> e.getAnimal().getSpecie(),
						(specie, stream) -> stream.count(),
						(specie, stream) -> stream.sumDouble(e -> e.getService().getValue()))
					.sortedDescendingBy(tuple -> tuple.getThree())
					.limit(10)
					.toList();
	}

	@Override
	public List<Tuple3<Double, String, Date>> getServicesHistory(String description) {
		return super.getStream()
				.where(e -> e.getService().getDescription().equals(description))
				.group(
					e -> e.getService().getValue(),
					(value, stream) -> description,
					(value, stream) -> stream.min(e -> e.getDate()))
				.sortedBy(tuple -> tuple.getThree())
				.toList();
	}

	@Override
	public List<Tuple3<String, Long, Double>> getExpensesSummary(Date start, Date end) {
		return super.getStream()
				.where(e -> e.getDate().after(start) && e.getDate().before(end))
				.group(
					e -> e.getService().getDescription(),
					(specie, stream) -> stream.count(),
					(specie, stream) -> stream.sumDouble(e -> e.getService().getValue()))
				.sortedBy(tuple -> tuple.getOne())
				.sortedDescendingBy(tuple -> tuple.getThree())
				.toList();
	}
}