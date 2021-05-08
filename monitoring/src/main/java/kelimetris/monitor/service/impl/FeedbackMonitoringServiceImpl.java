package kelimetris.monitor.service.impl;

import kelimetris.core.lib.model.Feedback;
import kelimetris.core.lib.repository.FeedbackRepository;
import kelimetris.monitor.service.FeedbackMonitoringService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class FeedbackMonitoringServiceImpl implements FeedbackMonitoringService {
    private final FeedbackRepository feedbackRepository;

    public FeedbackMonitoringServiceImpl(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public ResponseEntity<List<Feedback>> getFeedbacks() {
        return new ResponseEntity<>(feedbackRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Feedback>> getFeedbacksOfUser(String userId) {
        var feedbacks = feedbackRepository.findAllByUserId(userId);
        return new ResponseEntity<>(feedbacks, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Feedback>> getFeedbacksContainingText(String message) {
        var feedbacks = feedbackRepository.findAllByMessageContainingIgnoreCase(message);
        return new ResponseEntity<>(feedbacks, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Feedback>> getFeedbacksByDateAfter(String date) {
        return new ResponseEntity<>(feedbackRepository.findAllByInsertDateAfter(date), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Feedback>> getFeedbacksByDateBefore(String date) {
        return new ResponseEntity<>(feedbackRepository.findAllByInsertDateBefore(date), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Feedback>> getFeedbacksByDateBetween(String startDate, String endDate) {
        return new ResponseEntity<>(feedbackRepository.findAllByInsertDateBetween(startDate, endDate), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Feedback>> getFeedbacksByStarsGreaterThan(int stars) {
        return new ResponseEntity<>(feedbackRepository.findAllByStarsGreaterThanEqual(stars), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Feedback>> getFeedbacksByStarsLessThan(int stars) {
        return new ResponseEntity<>(feedbackRepository.findAllByStarsIsLessThanEqual(stars), HttpStatus.OK);
    }
}
