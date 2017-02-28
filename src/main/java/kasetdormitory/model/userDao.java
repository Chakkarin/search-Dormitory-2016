package kasetdormitory.model;
import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface userDao extends CrudRepository<user, Long> {
	public user findByName(String name);
	public user findById(long id);
	public user findByPass(String password);
	
	public user findByNameContaining(String name);
	public user findByPassContaining(String password);
}
