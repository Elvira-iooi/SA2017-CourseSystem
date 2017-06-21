package hello.Service;

import hello.Entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import java.util.Optional;

/**
 * Created by ELLLisa on 2017/6/21.
 */
public interface UserService extends UserDetailsService{

    Optional<User> getUserById(Long Id);

    boolean saveUser(User user);

    boolean modifyUserOnPasswordById(User user);

    boolean deleteUserById(Long id);

}
