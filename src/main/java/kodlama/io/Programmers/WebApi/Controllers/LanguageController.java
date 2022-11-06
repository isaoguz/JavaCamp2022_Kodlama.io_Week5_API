package kodlama.io.Programmers.WebApi.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Programmers.Business.Abstract.ILanguageService;
import kodlama.io.Programmers.Business.Request.CreateLanguageRequest;
import kodlama.io.Programmers.Business.Request.DeleteLanguageRequest;
import kodlama.io.Programmers.Business.Request.UpdateLanguageRequest;
import kodlama.io.Programmers.Business.Response.GetAllLanguageResponse;
import kodlama.io.Programmers.Business.Response.GetByIdLanguageRepsonse;

@RestController //annotation
@RequestMapping("/api/Languages")
public class LanguageController {

	
	private ILanguageService _languageService;
	
	@Autowired
	public LanguageController(ILanguageService languageService) {
		_languageService=languageService;
	}
	
	
	
	@GetMapping("/getAll")
	public List<GetAllLanguageResponse> getAll(){
	 return	_languageService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetByIdLanguageRepsonse getById(int id) {
		return _languageService.getById(id);
	}
	
	@PostMapping("/add")
	public void add(CreateLanguageRequest createLanguageRequest) {
		_languageService.add(createLanguageRequest);
	}
	
	@PostMapping("/delete")
	public void delete(DeleteLanguageRequest deleteLanguageRequest ) {
		_languageService.delete(deleteLanguageRequest);
	}
	
	@PutMapping("/update")
	public void update(int id, UpdateLanguageRequest updateLanguageRequest ) {
		_languageService.update(id, updateLanguageRequest);
	}
	
}
