package br.com.helpet.dao.jinq;

import java.util.Date;
import java.util.List;

import org.jinq.tuples.Pair;
import org.jinq.tuples.Tuple3;

import br.com.helpet.dao.IAdoptionDao;
import br.com.helpet.entities.Adoption;

public class AdoptionDao extends GenericDao<Adoption> implements IAdoptionDao {

	public AdoptionDao() {
		super(Adoption.class);
	}

	@Override
	public List<Pair<String,Long>> getAdoptionHistory() {		
		return super.getStream()
				.group(
					a -> a.getPerson().getAddress().getCity(),
					(city, stream) -> stream.count())
				.sortedBy(p -> p.getOne())
				.sortedDescendingBy(p -> p.getTwo())
				.toList();
	}

	@Override
	public List<Tuple3<String, String, Long>> getAdoptionSummary(Date start, Date end){
		return super.getStream()
				.where(a -> a.getDate().after(start) && a.getDate().before(end))
				.group(
					a -> a.getAnimal().getSpecie(),
					(specie, stream) -> stream.min(a -> a.getPerson().getAddress().getCity()),
					(specie, stream) -> stream.count())
				.sortedDescendingBy(tuple -> tuple.getThree())
				.sortedBy(tuple -> tuple.getOne())
				.sortedBy(tuple -> tuple.getTwo())
				.toList();
	}
}
