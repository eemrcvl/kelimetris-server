package kelimetris.monitor.service.impl;

import kelimetris.core.lib.model.User;
import kelimetris.monitor.service.UserMonitoringService;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class UserMonitoringServiceImpl implements UserMonitoringService {
    @Override
    public ResponseEntity<List<User>> getUsers() {
        return null;
    }

    @Override
    public ResponseEntity<Optional<User>> getUserById() {
        return null;
    }

    @Override
    public ResponseEntity<Optional<User>> getUserByUsername() {
        return null;
    }
}
