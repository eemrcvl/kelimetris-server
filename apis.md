#Endpoints
* Server Application
    * /kelimetris/api/v1/post-log
    * /kelimetris/api/v1/save-feedback
    * /kelimetris/api/v1/register
    * /kelimetris/api/v1/is-online
    * /kelimetris/api/v1/scoreboard/{id}
  

* Monitoring Application
  * User
    * /kelimetris/monitoring_api/v1/users
    * /kelimetris/monitoring_api/v1/user/{id}
    * /kelimetris/monitoring_api/v1/username/{username}
  
  * Feedback
    * /kelimetris/monitoring_api/v1/feedbacks
    * /kelimetris/monitoring_api/v1/feedbacks/{userId}
    * /kelimetris/monitoring_api/v1/feedbacks/query/{message}
    * /kelimetris/monitoring_api/v1/feedbacks/feedbacks_after/{date}
    * /kelimetris/monitoring_api/v1/feedbacks/feedbacks_before/{date}
    * /kelimetris/monitoring_api/v1/feedbacks/feedbacks_between/{start}/{end}
    * /kelimetris/monitoring_api/v1/feedbacks/feedbacks_stars/{stars}/lower
    * /kelimetris/monitoring_api/v1/feedbacks/feedbacks_stars/{stars}/higher
  
  * Game Exception Messages
    * /kelimetris/monitoring_api/v1/exceptions
    * /kelimetris/monitoring_api/v1/exceptions/user/{userId}
    * /kelimetris/monitoring_api/v1/exceptions/log/{gameLogId}
    * /kelimetris/monitoring_api/v1/exceptions/search/{query}
    * /kelimetris/monitoring_api/v1/exceptions/exception/{message}
    * /kelimetris/monitoring_api/v1/exceptions_after/{date}
    * /kelimetris/monitoring_api/v1/exceptions_before/{date}
    * /kelimetris/monitoring_api/v1/exceptions_between/{start}/{end}
  
  * Game Logs
    * /kelimetris/monitoring_api/v1/logs
    * /kelimetris/monitoring_api/v1/logs/{userId}
    * /kelimetris/monitoring_api/v1/logs_after/{date}
    * /kelimetris/monitoring_api/v1/logs_before/{date}
    * /kelimetris/monitoring_api/v1/logs_between/{start}/{end}
    * /kelimetris/monitoring_api/v1/logs_between/{start}/{end}
  
  * Scores
    * /kelimetris/monitoring_api/v1/scores
    * /kelimetris/monitoring_api/v1/scores/{score}/higher
    * /kelimetris/monitoring_api/v1/scores/{score}/lower
    * /kelimetris/monitoring_api/v1/scores/{upper}&{lower}
  
  
  

