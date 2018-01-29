package tr.org.lkd.mahmutyetisir.ab2018blog.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tr.org.lkd.mahmutyetisir.ab2018blog.model.Entry;

@Repository
public interface EntryRepository extends CrudRepository<Entry, Integer>{

}
