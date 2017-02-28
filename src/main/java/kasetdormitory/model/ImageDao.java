package kasetdormitory.model;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface ImageDao extends CrudRepository<Image, Long> {
	public Image findById(long id);
	public List<Image> findByDorm(dorm id);
}
