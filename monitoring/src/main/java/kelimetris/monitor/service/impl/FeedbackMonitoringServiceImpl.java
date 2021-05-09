package kelimetris.monitor.service.impl;

import kelimetris.core.lib.model.Feedback;
import kelimetris.core.lib.repository.FeedbackRepository;
import kelimetris.monitor.service.FeedbackMonitoringService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackMonitoringServiceImpl implements FeedbackMonitoringService {
    private final FeedbackRepository feedbackRepository;

    public FeedbackMonitoringServiceImpl(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public ResponseEntity<List<Feedback>> getFeedbacks(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Feedback> feedbacks = feedbackRepository.findAll(pageable);
        return new ResponseEntity<>(feedbacks.getContent(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Feedback>> getFeedbacksOfUser(String userId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Feedback> feedbacks = feedbackRepository.findAllByUserId(userId, pageable);
        return new ResponseEntity<>(feedbacks.getContent(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Feedback>> getFeedbacksContainingText(String message, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Feedback> feedbacks = feedbackRepository.findAllByMessageContainingIgnoreCase(message, pageable);
        return new ResponseEntity<>(feedbacks.getContent(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Feedback>> getFeedbacksByDateAfter(String date, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Feedback> feedbacks = feedbackRepository.findAllByInsertDateAfter(date, pageable);
        return new ResponseEntity<>(feedbacks.getContent(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Feedback>> getFeedbacksByDateBefore(String date, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Feedback> feedbacks = feedbackRepository.findAllByInsertDateBefore(date, pageable);
        return new ResponseEntity<>(feedbacks.getContent(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Feedback>> getFeedbacksByDateBetween(String startDate, String endDate, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Feedback> feedbacks = feedbackRepository.findAllByInsertDateBetween(startDate, endDate, pageable);
        return new ResponseEntity<>(feedbacks.getContent(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Feedback>> getFeedbacksByStarsGreaterThan(int stars, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Feedback> feedbacks = feedbackRepository.findAllByStarsGreaterThanEqual(stars, pageable);
        return new ResponseEntity<>(feedbacks.getContent(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Feedback>> getFeedbacksByStarsLessThan(int stars, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Feedback> feedbacks = feedbackRepository.findAllByStarsIsLessThanEqual(stars, pageable);
        return new ResponseEntity<>(feedbacks.getContent(), HttpStatus.OK);
    }
}

