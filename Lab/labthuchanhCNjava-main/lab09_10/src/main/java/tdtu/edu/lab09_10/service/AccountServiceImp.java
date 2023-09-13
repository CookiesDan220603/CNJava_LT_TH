package tdtu.edu.lab09_10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import tdtu.edu.lab09_10.model.Account;
import tdtu.edu.lab09_10.repository.AccountRepository;

@Service
public class AccountServiceImp implements UserDetailsService {
    @Autowired
    AccountRepository accountRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account;
        try {
            account = getUserDetailsCustom(username);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if(ObjectUtils.isEmpty(account)){
            throw new UsernameNotFoundException("User not found");
        }
        return account;
    }

    private Account getUserDetailsCustom(String email) throws Exception {
        Account account = accountRepository.findAccountByEmailEquals(email);
        if(ObjectUtils.isEmpty(account)){
            throw new Exception(String.valueOf(HttpStatus.BAD_REQUEST));
        }
        return new Account(account.getUsername(), account.getPassword());
    }
    public Account getAccount(String email){
        return accountRepository.findAccountByEmailEquals(email);
    }
    public Account checkLogin(String email, String password){
        return accountRepository.findAccountByEmailEqualsAndPasswordEquals(email,password);
    }

    public Account save(Account account) {
        return accountRepository.save(account);
    }


}
