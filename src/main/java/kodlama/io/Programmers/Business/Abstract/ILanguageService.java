package kodlama.io.Programmers.Business.Abstract;

import java.util.List;

import kodlama.io.Programmers.Business.Request.CreateLanguageRequest;
import kodlama.io.Programmers.Business.Request.DeleteLanguageRequest;
import kodlama.io.Programmers.Business.Request.UpdateLanguageRequest;
import kodlama.io.Programmers.Business.Response.GetAllLanguageResponse;
import kodlama.io.Programmers.Business.Response.GetByIdLanguageRepsonse;

public interface ILanguageService {
List<GetAllLanguageResponse> getAll();
GetByIdLanguageRepsonse getById(int id);
void add(CreateLanguageRequest createLanguageRequest );
void delete(DeleteLanguageRequest deleteLanguageRequest);
void update(int id, UpdateLanguageRequest updateLanguageRequest);
}
