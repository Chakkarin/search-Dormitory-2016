package kasetdormitory.model;

import java.util.List;

import javax.transaction.*;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface commentDao extends CrudRepository<comment, Long>{
	public comment findById(long id);
	public List<comment> findByDorm(dorm dorm);
}
