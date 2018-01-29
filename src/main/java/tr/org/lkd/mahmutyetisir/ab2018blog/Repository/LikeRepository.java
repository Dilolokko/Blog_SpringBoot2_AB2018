package tr.org.lkd.mahmutyetisir.ab2018blog.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tr.org.lkd.mahmutyetisir.ab2018blog.model.Like;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface LikeRepository extends CrudRepository<Like, Integer>{

    @Query("select l from Like l")
    List<Like> findAllLike();
}
