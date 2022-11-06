package kodlama.io.Programmers.Business.Concrete;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Programmers.Business.Abstract.ILanguageService;
import kodlama.io.Programmers.Business.Request.CreateLanguageRequest;
import kodlama.io.Programmers.Business.Request.DeleteLanguageRequest;
import kodlama.io.Programmers.Business.Request.UpdateLanguageRequest;
import kodlama.io.Programmers.Business.Response.GetAllLanguageResponse;
import kodlama.io.Programmers.Business.Response.GetByIdLanguageRepsonse;
import kodlama.io.Programmers.DataAccess.Abstract.ILanguageRepository;
import kodlama.io.Programmers.Entities.Concrete.Languages;

@Service
public class LanguageManager implements ILanguageService {

	private ILanguageRepository _languageRepository;
	
	@Autowired
	public LanguageManager(ILanguageRepository languageRepository) {
		_languageRepository = languageRepository;
	}
	
	
	@Override
	public List<GetAllLanguageResponse> getAll() {
		List<Languages> languages = _languageRepository.findAll();
		List<GetAllLanguageResponse> languageResponse = new ArrayList<GetAllLanguageResponse>();
		
		 for(Languages language:languages) {
			 GetAllLanguageResponse item = new GetAllLanguageResponse();
			 item.setId(language.getId());
			 item.setName(language.getName());
			 languageResponse.add(item);
		 };
		return languageResponse;
	}

	@Override
	public GetByIdLanguageRepsonse getById(int id) {
		Languages language = _languageRepository.findById(id).get();
		
		GetByIdLanguageRepsonse response = new GetByIdLanguageRepsonse();
		
		response.setName(language.getName());

		return response;
	}

	@Override
	public void add(CreateLanguageRequest createLanguageRequest) {
		Languages language = new Languages();
		language.setName(createLanguageRequest.getName());
		_languageRepository.save(language);
	}

	@Override
	public void delete(DeleteLanguageRequest deleteLanguageRequest) {
		_languageRepository.deleteById(deleteLanguageRequest.getId());
		
	}

	@Override
	public void update(int id, UpdateLanguageRequest updateLanguageRequest) {
		if (!updateLanguageRequest.getName().isEmpty()) {
			Languages language = _languageRepository.findById(id).get();
			language.setName(updateLanguageRequest.getName());
			_languageRepository.save(language);
		}
		
	}

}
