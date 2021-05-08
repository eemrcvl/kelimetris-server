package kelimetris.monitor.service;

import kelimetris.core.lib.model.Feedback;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FeedbackMonitoringService {
    ResponseEntity<List<Feedback>> getFeedbacks();

    ResponseEntity<List<Feedback>> getFeedbacksOfUser(String userId);

    ResponseEntity<List<Feedback>> getFeedbacksContainingText(String message);

    ResponseEntity<List<Feedback>> getFeedbacksByDateAfter(String date);

    ResponseEntity<List<Feedback>> getFeedbacksByDateBefore(String date);

    ResponseEntity<List<Feedback>> getFeedbacksByDateBetween(String startDate, String endDate);

    ResponseEntity<List<Feedback>> getFeedbacksByStarsGreaterThan(int stars);

    ResponseEntity<List<Feedback>> getFeedbacksByStarsLessThan(int stars);
}
