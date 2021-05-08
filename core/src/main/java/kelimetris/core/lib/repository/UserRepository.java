package kelimetris.core.lib.repository;

import kelimetris.core.lib.base.BaseRepository;
import kelimetris.core.lib.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User> {
    List<User> findAll();

    Optional<User> findUserById(String id);

    Optional<User> findByUsername(String username);
}
