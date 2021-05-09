package kelimetris.monitor.service.impl;

import kelimetris.core.lib.model.User;
import kelimetris.core.lib.repository.UserRepository;
import kelimetris.core.lib.utility.exceptions.UserNotFoundException;
import kelimetris.core.lib.utility.handlers.ApiExceptionHandler;
import kelimetris.monitor.service.UserMonitoringService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMonitoringServiceImpl implements UserMonitoringService {
    private final UserRepository userRepository;
    private final ApiExceptionHandler apiExceptionHandler;

    public UserMonitoringServiceImpl(UserRepository userRepository, ApiExceptionHandler apiExceptionHandler) {
        this.userRepository = userRepository;
        this.apiExceptionHandler = apiExceptionHandler;
    }

    @Override
    public ResponseEntity<List<User>> getUsers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<User> users = userRepository.findAll(pageable);
        return new ResponseEntity<>(users.getContent(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getUserById(String userId) {
        var user = userRepository.findUserById(userId);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(apiExceptionHandler.handleUserNotFoundException(new UserNotFoundException()), HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> getUserByUsername(String username) {
        var user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(apiExceptionHandler.handleUserNotFoundException(new UserNotFoundException()), HttpStatus.NOT_FOUND);
        }
    }
}
