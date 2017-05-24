package br.com.helpet.dao.jinq;

import java.util.List;

import br.com.helpet.dao.AdoptionDao;
import br.com.helpet.entities.Adoption;

public class AdoptionDaoImpl extends GenericDao<Adoption> implements AdoptionDao {

	public AdoptionDaoImpl(Class<Adoption> entityClass) {
		super(entityClass);
	}

	@Override
	public List<String> getAdoptionHistory() {
		return null;
	}

	@Override
	public List<String> getAdoptionSummary(String city) {
		return null;
	}

}
