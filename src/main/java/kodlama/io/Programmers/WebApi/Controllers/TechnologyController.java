package kodlama.io.Programmers.WebApi.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Programmers.Business.Abstract.ITechnologyService;
import kodlama.io.Programmers.Business.Request.CreateTechnologyRequest;
import kodlama.io.Programmers.Business.Request.DeleteTechnologyRequest;
import kodlama.io.Programmers.Business.Request.UpdateTechonogyRequest;
import kodlama.io.Programmers.Business.Response.GetAllTechnologyResponse;

@RestController //annotation
@RequestMapping("/api/technologies")
public class TechnologyController {
private ITechnologyService  _technologyService;


@Autowired
public TechnologyController(ITechnologyService  technologyService) {
	_technologyService = technologyService;
}


@GetMapping("/getAll")
 public List<GetAllTechnologyResponse> getAll(){
 return	_technologyService.getAll();
}


@PostMapping("/add")
public void add(CreateTechnologyRequest createTechnologyRequest) {
	_technologyService.add(createTechnologyRequest);
}


@DeleteMapping("/delete")
public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
	_technologyService.delete(deleteTechnologyRequest);
}


@PostMapping("/update")
public void update(int id, UpdateTechonogyRequest  updateTechnologyRequest) {
	_technologyService.update(id, updateTechnologyRequest);
}


}
