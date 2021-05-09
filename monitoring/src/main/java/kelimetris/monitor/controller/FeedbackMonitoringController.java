package kelimetris.monitor.controller;

import kelimetris.core.lib.model.Feedback;
import kelimetris.monitor.service.impl.FeedbackMonitoringServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FeedbackMonitoringController {
    private final FeedbackMonitoringServiceImpl feedbackMonitoringService;

    public FeedbackMonitoringController(FeedbackMonitoringServiceImpl feedbackMonitoringService) {
        this.feedbackMonitoringService = feedbackMonitoringService;
    }

    @RequestMapping(value = "/feedbacks", method = RequestMethod.GET)
    public ResponseEntity<List<Feedback>> getFeedbacks(@RequestParam(value = "pageNo", required = false, defaultValue = "0") int pageNumber,
                                                       @RequestParam(value = "pageSize", required = false, defaultValue = "50") int pageSize) {
        return feedbackMonitoringService.getFeedbacks(pageNumber, pageSize);
    }

    @RequestMapping(value = "/feedbacks/{userId}", method = RequestMethod.GET)
    public ResponseEntity<List<Feedback>> getFeedbacksOfUser(@PathVariable("userId") String userId,
                                                             @RequestParam(value = "pageNo", required = false, defaultValue = "0") int pageNumber,
                                                             @RequestParam(value = "pageSize", required = false, defaultValue = "50") int pageSize) {
        return feedbackMonitoringService.getFeedbacksOfUser(userId, pageNumber, pageSize);
    }

    @RequestMapping(value = "/feedbacks/query/{message}", method = RequestMethod.GET)
    public ResponseEntity<List<Feedback>> getFeedbacksWithText(@PathVariable("message") String message,
                                                               @RequestParam(value = "pageNo", required = false, defaultValue = "0") int pageNumber,
                                                               @RequestParam(value = "pageSize", required = false, defaultValue = "50") int pageSize) {
        return feedbackMonitoringService.getFeedbacksContainingText(message, pageNumber, pageSize);
    }

    @RequestMapping(value = "/feedbacks_after/{date}", method = RequestMethod.GET)
    public ResponseEntity<List<Feedback>> getFeedbacksByDateAfter(@PathVariable("date") String date,
                                                                  @RequestParam(value = "pageNo", required = false, defaultValue = "0") int pageNumber,
                                                                  @RequestParam(value = "pageSize", required = false, defaultValue = "50") int pageSize) {
        return feedbackMonitoringService.getFeedbacksByDateAfter(date, pageNumber, pageSize);
    }

    @RequestMapping(value = "/feedbacks_before/{date}", method = RequestMethod.GET)
    public ResponseEntity<List<Feedback>> getFeedbacksByDateBefore(@PathVariable("date") String date,
                                                                   @RequestParam(value = "pageNo", required = false, defaultValue = "0") int pageNumber,
                                                                   @RequestParam(value = "pageSize", required = false, defaultValue = "50") int pageSize) {
        return feedbackMonitoringService.getFeedbacksByDateBefore(date, pageNumber, pageSize);
    }

    @RequestMapping(value = "/feedbacks_between/{start}/{end}", method = RequestMethod.GET)
    public ResponseEntity<List<Feedback>> getFeedbacksByDateBetween(@PathVariable("start") String startDate,
                                                                    @PathVariable("end") String endDate,
                                                                    @RequestParam(value = "pageNo", required = false, defaultValue = "0") int pageNumber,
                                                                    @RequestParam(value = "pageSize", required = false, defaultValue = "50") int pageSize) {
        return feedbackMonitoringService.getFeedbacksByDateBetween(startDate, endDate, pageNumber, pageSize);
    }

    @RequestMapping(value = "/feedbacks_stars/{stars}/lower", method = RequestMethod.GET)
    public ResponseEntity<List<Feedback>> getFeedbacksWithStarsLessThan(@PathVariable("stars") int stars,
                                                                        @RequestParam(value = "pageNo", required = false, defaultValue = "0") int pageNumber,
                                                                        @RequestParam(value = "pageSize", required = false, defaultValue = "50") int pageSize) {
        return feedbackMonitoringService.getFeedbacksByStarsLessThan(stars, pageNumber, pageSize);
    }

    @RequestMapping(value = "/feedbacks_stars/{stars}/higher", method = RequestMethod.GET)
    public ResponseEntity<List<Feedback>> getFeedbacksWithStarsGreaterThan(@PathVariable("stars") int stars,
                                                                           @RequestParam(value = "pageNo", required = false, defaultValue = "0") int pageNumber,
                                                                           @RequestParam(value = "pageSize", required = false, defaultValue = "50") int pageSize) {
        return feedbackMonitoringService.getFeedbacksByStarsGreaterThan(stars, pageNumber, pageSize);
    }
}
