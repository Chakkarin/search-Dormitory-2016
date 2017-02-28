package kasetdormitory.model;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface categoryDao extends CrudRepository<category, Long>{
	public category findByName(String name);
}
