package kelimetris.monitor.controller;

import kelimetris.core.lib.model.User;
import kelimetris.monitor.service.impl.UserMonitoringServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserMonitoringController {
    private final UserMonitoringServiceImpl userMonitoringService;

    public UserMonitoringController(UserMonitoringServiceImpl userMonitoringService) {
        this.userMonitoringService = userMonitoringService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUsers(@RequestParam(value = "pageNo", required = false, defaultValue = "0") int pageNumber,
                                               @RequestParam(value = "pageSize", required = false, defaultValue = "50") int pageSize) {
        return userMonitoringService.getUsers(pageNumber, pageSize);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUserById(@PathVariable("id") String id) {
        return userMonitoringService.getUserById(id);
    }

    @RequestMapping(value = "/username/{username}", method = RequestMethod.GET)
    public ResponseEntity<?> getUserByUsername(@PathVariable("username") String username) {
        return userMonitoringService.getUserByUsername(username);
    }
}
