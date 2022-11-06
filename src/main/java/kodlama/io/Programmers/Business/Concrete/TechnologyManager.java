package kodlama.io.Programmers.Business.Concrete;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Programmers.Business.Abstract.ITechnologyService;
import kodlama.io.Programmers.Business.Request.CreateTechnologyRequest;
import kodlama.io.Programmers.Business.Request.DeleteTechnologyRequest;
import kodlama.io.Programmers.Business.Request.UpdateTechonogyRequest;
import kodlama.io.Programmers.Business.Response.GetAllTechnologyResponse;
import kodlama.io.Programmers.DataAccess.Abstract.ILanguageRepository;
import kodlama.io.Programmers.DataAccess.Abstract.ITechnologhyRepository;
import kodlama.io.Programmers.Entities.Concrete.Languages;
import kodlama.io.Programmers.Entities.Concrete.Technology;

@Service
public class TechnologyManager implements ITechnologyService {

	
	private ITechnologhyRepository _technologyrepository;
	private ILanguageRepository _language;
	
	@Autowired
	public TechnologyManager(ITechnologhyRepository technologyrepository,ILanguageRepository language) {
		_technologyrepository = technologyrepository;
		_language = language;
	}

	@Override
	public List<GetAllTechnologyResponse> getAll() {
		
		List<Technology> technology = _technologyrepository.findAll();
		
		List<GetAllTechnologyResponse> getAllTechnologyResponse = new ArrayList<>();
		
		for(Technology tech:technology) {
			GetAllTechnologyResponse response = new GetAllTechnologyResponse();
			response.setName(tech.getName());
			response.setLanguageName(tech.getLanguages().getName());
			getAllTechnologyResponse.add(response);
		}
		
		return getAllTechnologyResponse;
	}

	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest) {
		Technology technology = new Technology();
		Languages language = _language.findById(createTechnologyRequest.getLanguageId()).get();
		technology.setName(createTechnologyRequest.getName());
		technology.setLanguages(language);
		_technologyrepository.save(technology);
		
	}

	@Override
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
		
		_technologyrepository.deleteById(deleteTechnologyRequest.getId());
	}

	@Override
	public void update(int id, UpdateTechonogyRequest updateTechonogyRequest) {
		Technology technology = _technologyrepository.findById(id).get();
		Languages language = _language.findById(updateTechonogyRequest.getLanguageId()).get();
		technology.setName(updateTechonogyRequest.getName());
		technology.setLanguages(language);
		_technologyrepository.save(technology);
	}
}
