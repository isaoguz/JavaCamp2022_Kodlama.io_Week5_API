package kodlama.io.Programmers.DataAccess.Abstract;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.Programmers.Entities.Concrete.Languages;

public interface ILanguageRepository extends JpaRepository<Languages,Integer> {

}
