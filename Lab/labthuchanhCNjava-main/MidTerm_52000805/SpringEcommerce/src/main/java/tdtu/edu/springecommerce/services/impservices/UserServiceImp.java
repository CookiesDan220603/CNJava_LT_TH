package tdtu.edu.springecommerce.services.impservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tdtu.edu.springecommerce.models.User;
import tdtu.edu.springecommerce.services.intservices.UserService;

@Service
public class UserServiceImp {
    @Autowired
    private UserService userService;

    public User userLoginValid(String username,String password) {
        return userService.getUserValid(username, password);
    }
    public boolean checkUserExist(String username){
        return userService.findUserByUsernameEquals(username)!=null;
    }

    public void save(User user) {
        userService.save(user);
    }
    public User findById(Long id){
        return userService.findById(id).get();
    }
}
