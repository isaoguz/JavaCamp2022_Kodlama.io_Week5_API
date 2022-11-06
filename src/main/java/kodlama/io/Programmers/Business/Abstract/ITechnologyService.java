package kodlama.io.Programmers.Business.Abstract;

import java.util.List;

import kodlama.io.Programmers.Business.Request.CreateTechnologyRequest;
import kodlama.io.Programmers.Business.Request.DeleteTechnologyRequest;
import kodlama.io.Programmers.Business.Request.UpdateTechonogyRequest;
import kodlama.io.Programmers.Business.Response.GetAllTechnologyResponse;

public interface ITechnologyService {
	
List<GetAllTechnologyResponse> getAll();
void add(CreateTechnologyRequest createTechnologyRequest);
void delete(DeleteTechnologyRequest deleteTechnologyRequest);
void update(int id, UpdateTechonogyRequest updateTechnologyRequest);
}
