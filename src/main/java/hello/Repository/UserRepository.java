package hello.Repository;

import hello.Entity.User;

import java.util.List;

/**
 * Created by ELLLisa on 2017/6/21.
 */
public interface UserRepository {

    User selectUserById(Long id);

    User selectUserByUsername(String username);

    List<User> selectAllUsers();

    Integer insertUser(User user);

    Integer updateUserOnPasswordById(User user);

    Integer deleteUserById(Long id);

}
