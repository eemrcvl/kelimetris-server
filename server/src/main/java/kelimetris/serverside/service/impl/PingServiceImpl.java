package kelimetris.serverside.service.impl;

import kelimetris.serverside.service.PingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PingServiceImpl implements PingService {

    @Override
    public ResponseEntity okService() {
        return new ResponseEntity(HttpStatus.OK);
    }
}
