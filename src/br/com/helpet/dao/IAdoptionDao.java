package br.com.helpet.dao;

import java.util.Date;
import java.util.List;

import org.jinq.tuples.Pair;
import org.jinq.tuples.Tuple3;

import br.com.helpet.entities.Adoption;

public interface IAdoptionDao extends IDao<Adoption>{

	List<Pair<String,Long>> getAdoptionHistory();
	List<Tuple3<String, String, Long>> getAdoptionSummary(Date start, Date end);
}
