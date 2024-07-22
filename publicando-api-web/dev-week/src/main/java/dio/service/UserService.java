package dio.service;

import dio.domain.model.User;
import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(Long id);

    User create(User userToCreate);
}
