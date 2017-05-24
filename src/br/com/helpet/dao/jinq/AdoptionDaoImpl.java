package br.com.helpet.dao.jinq;

import java.util.List;

import br.com.helpet.dao.AdoptionDao;
import br.com.helpet.entities.Adoption;

public class AdoptionDaoImpl extends GenericDao<Adoption> implements AdoptionDao {

	public AdoptionDaoImpl() {
		super(Adoption.class);
	}

	@Override
	public List<String> getAdoptionHistory() {		
		return super.getStream()
						.group(a -> a.getPerson().getAddress().getCity(),
							(city, stream) -> stream.where(a -> a.getAnimal().getPerson().getAddress().getCity().equals(city)).count())
						.select(p -> "Cidade: "+p.getOne()+" - Nº adoções: "+p.getTwo())
						.toList();			
	}

	@Override
	public List<String> getAdoptionSummary(String city){
		return null;
	}

}
