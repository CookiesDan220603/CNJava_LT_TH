package tdtu.edu.springecommerce.services.intservices;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import tdtu.edu.springecommerce.models.User;
import tdtu.edu.springecommerce.repostiory.UserRepository;

@Service
public interface UserService extends UserRepository {
    @Query(value = "FROM User AS u WHERE u.username = :username and u.password=:password")
    public User getUserValid(String username,String password);

    public User findUserByUsernameEquals(String username);
}
