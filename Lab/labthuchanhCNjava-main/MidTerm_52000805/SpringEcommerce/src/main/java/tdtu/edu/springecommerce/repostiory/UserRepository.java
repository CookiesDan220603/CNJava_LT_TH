package tdtu.edu.springecommerce.repostiory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tdtu.edu.springecommerce.models.User;
@Repository
public interface UserRepository extends CrudRepository<User,Long> {
}
