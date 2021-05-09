package kelimetris.core.lib.repository;

import kelimetris.core.lib.base.BaseRepository;
import kelimetris.core.lib.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User> {
    Page<User> findAll(Pageable pageable);

    Optional<User> findUserById(String id);

    Optional<User> findByUsername(String username);
}
