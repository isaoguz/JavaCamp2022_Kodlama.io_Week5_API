package kodlama.io.Programmers.DataAccess.Abstract;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.Programmers.Entities.Concrete.Technology;

public interface ITechnologhyRepository extends JpaRepository<Technology,Integer> {

}
