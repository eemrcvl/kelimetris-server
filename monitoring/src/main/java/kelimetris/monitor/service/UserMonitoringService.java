package kelimetris.monitor.service;

import kelimetris.core.lib.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserMonitoringService {
    ResponseEntity<List<User>> getUsers();

    ResponseEntity<Optional<User>> getUserById();

    ResponseEntity<Optional<User>> getUserByUsername();
}
