package tr.org.lkd.mahmutyetisir.ab2018blog.Repository;

import org.springframework.data.repository.CrudRepository;
import tr.org.lkd.mahmutyetisir.ab2018blog.model.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    public Optional<User> findByUsername(String username);

}
