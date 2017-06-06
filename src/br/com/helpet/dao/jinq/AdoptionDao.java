package br.com.helpet.dao.jinq;

import java.util.List;
import java.util.stream.Collectors;

import br.com.helpet.dao.DaoFactory;
import br.com.helpet.dao.IAdoptionDao;
import br.com.helpet.dao.IDao;
import br.com.helpet.entities.Adoption;

public class AdoptionDao extends GenericDao<Adoption> implements IAdoptionDao {

	public AdoptionDao() {
		super(Adoption.class);
	}

	@Override
	public List<String> getAdoptionHistory() {		
		IDao<Adoption> adoptionDao = DaoFactory.getDao(Adoption.class);
		List<Adoption> adoptionsRaw = adoptionDao.list();
		return adoptionsRaw.stream()
				.map(x -> "Cidade: "+x.getPerson().getAddress().getCity() + " - "
						+ "Adoções: "+adoptionsRaw.stream().filter(y -> y.getPerson().getAddress().getCity()
								.equals(x.getPerson().getAddress().getCity())).count())
				.sorted()
				.distinct()
				.collect(Collectors.toList());
	}

	@Override
	public List<String> getAdoptionSummary(String city){
		IDao<Adoption> adoptionDao = DaoFactory.getDao(Adoption.class);
		List<Adoption> adoptionsRaw = adoptionDao.list();
		return adoptionsRaw.stream()
				.map(x -> "Espécie: "+x.getAnimal().getSpecie() + " - "
						+ "Quantidade: "+adoptionsRaw.stream().filter(y -> y.getPerson().getAddress().getCity()
								.equals(city) && y.getAnimal().getSpecie().equals(x.getAnimal().getSpecie())).count())
				.sorted()
				.distinct()
				.collect(Collectors.toList());
	}

}
