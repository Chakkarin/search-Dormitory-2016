package kasetdormitory.model;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface dormDao extends CrudRepository<dorm, Long>{
	public dorm findById(long id);
	public List<dorm> findByName(String name);
	public List<dorm> findByNameContaining(String name);
	public dorm findByCategoryOrConsume(category category,String[] consume);
	public List<dorm> findByConsume(String[] consume);
	public List<dorm> findByConsumeLike(String[] consume);
}
