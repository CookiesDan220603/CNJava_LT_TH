package tdtu.edu.lab09_10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import tdtu.edu.lab09_10.model.Account;

public interface AccountRepository extends JpaRepository<Account,Long> {
    Account findAccountByEmailEquals(String email);
    Account findAccountByEmailEqualsAndPasswordEquals(String email,String password);
}
