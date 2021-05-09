package kelimetris.monitor.service;

import kelimetris.core.lib.model.Feedback;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FeedbackMonitoringService {
    ResponseEntity<List<Feedback>> getFeedbacks(int page, int size);

    ResponseEntity<List<Feedback>> getFeedbacksOfUser(String userId, int page, int size);

    ResponseEntity<List<Feedback>> getFeedbacksContainingText(String message, int page, int size);

    ResponseEntity<List<Feedback>> getFeedbacksByDateAfter(String date, int page, int size);

    ResponseEntity<List<Feedback>> getFeedbacksByDateBefore(String date, int page, int size);

    ResponseEntity<List<Feedback>> getFeedbacksByDateBetween(String startDate, String endDate, int page, int size);

    ResponseEntity<List<Feedback>> getFeedbacksByStarsGreaterThan(int stars, int page, int size);

    ResponseEntity<List<Feedback>> getFeedbacksByStarsLessThan(int stars, int page, int size);
}
