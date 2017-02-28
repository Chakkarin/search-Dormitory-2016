package kasetdormitory.model;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface consuDao extends CrudRepository<consu, Long> {
	
	 public consu findById(long id);

}
