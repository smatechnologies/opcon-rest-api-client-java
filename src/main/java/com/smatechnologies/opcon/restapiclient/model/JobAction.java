package com.smatechnologies.opcon.restapiclient.model;

import com.fasterxml.jackson.annotation.JsonValue;
import com.smatechnologies.opcon.restapiclient.model.dailyjob.DailyJob;
import com.smatechnologies.opcon.restapiclient.util.JobActionUtil;

import java.util.Date;
import java.util.List;
import java.util.Objects;


/**
 * @author Pierre PINON
 */
public class JobAction {

    public static final String RESOURCE = "jobAction";

    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_ACTION = "action";
    public static final String PROPERTY_RESULT = "result";
    public static final String PROPERTY_JOBS = "jobs";
    public static final String PROPERTY_EXPIRES = "expires";
    public static final String PROPERTY_MESSAGE = "message";
    public static final String PROPERTY_REASON = "reason";

    private Integer id;
    private Action action;
    private Result result;
    private List<Job> jobs;
    private Date expires;
    private String message;
    private String reason;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public Date getExpires() {
        return expires;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        JobAction jobAction = (JobAction) o;

        if (id != null ? !id.equals(jobAction.id) : jobAction.id != null)
            return false;
        if (action != jobAction.action)
            return false;
        if (result != jobAction.result)
            return false;
        if (jobs != null ? !jobs.equals(jobAction.jobs) : jobAction.jobs != null)
            return false;
        if (expires != null ? !expires.equals(jobAction.expires) : jobAction.expires != null)
            return false;
        if (message != null ? !message.equals(jobAction.message) : jobAction.message != null)
            return false;
        return reason != null ? reason.equals(jobAction.reason) : jobAction.reason == null;
    }

    @Override
    public int hashCode() {
        int result1 = id != null ? id.hashCode() : 0;
        result1 = 31 * result1 + (action != null ? action.hashCode() : 0);
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        result1 = 31 * result1 + (jobs != null ? jobs.hashCode() : 0);
        result1 = 31 * result1 + (expires != null ? expires.hashCode() : 0);
        result1 = 31 * result1 + (message != null ? message.hashCode() : 0);
        result1 = 31 * result1 + (reason != null ? reason.hashCode() : 0);
        return result1;
    }

    public enum Action {
        HOLD("hold", JobActionUtil::isHoldActionAllowed),
        CANCEL("cancel", JobActionUtil::isCancelActionAllowed),
        SKIP("skip", JobActionUtil::isSkipActionAllowed),
        KILL("kill", JobActionUtil::isKillActionAllowed),
        RELEASE("release", JobActionUtil::isReleaseActionAllowed),
        START("start", JobActionUtil::isStartActionAllowed),
        RESTART("restart", JobActionUtil::isRestartActionAllowed),
        RESTART_ON_HOLD("restartOnHold", JobActionUtil::isRestartActionAllowed),
        FORCE_RESTART("forceRestart", JobActionUtil::isRestartActionAllowed),
        //        RESTART_WITHOUT_PRERUN("restartWithoutPrerun", JobActionUtil::isRestartActionAllowed),
        RESTART_ON_STEP("restart", JobActionUtil::isRestartOnStepActionAllowed),
        MARK_FINISHED_OK("markFinishedOk", JobActionUtil::isMarkFinishedOkActionAllowed),
        MARK_FAILED("markFailed", JobActionUtil::isMarkFailedActionAllowed),
        MARK_UNDER_REVIEW("markUnderReview", JobActionUtil::isMarkUnderReviewAllowed),
        MARK_FIXED("markFixed", JobActionUtil::isMarkFixedAllowed);

        private final String value;
        private final ActionChecker actionChecker;

        Action(String value, ActionChecker actionChecker) {
            this.value = value;
            this.actionChecker = actionChecker;
        }

        @JsonValue
        public String value() {
            return value;
        }

        public boolean isAllowed(DailyJob dailyJob, User user) {
            return actionChecker.isAllowed(dailyJob, user);
        }

        private interface ActionChecker {

            boolean isAllowed(DailyJob dailyJob, User user);
        }
    }

    public static class Job {

        public static final String RESOURCE = "job";

        public static final String PROPERTY_ID = "id";
        public static final String PROPERTY_RESULT = "result";
        public static final String PROPERTY_MESSAGE = "message";
        public static final String PROPERTY_STATUS = "status";
        public static final String PROPERTY_STEP = "step";
        public static final String PROPERTY_REBUILD_ON_RESTART_IF_CONTAINER = "rebuildOnRestartIfContainer";

        private String id;
        private Result result;
        private String message;
        private JobStatus status;
        private String step;
        private Boolean rebuildOnRestartIfContainer;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Result getResult() {
            return result;
        }

        public void setResult(Result result) {
            this.result = result;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public JobStatus getStatus() {
            return status;
        }

        public void setStatus(JobStatus status) {
            this.status = status;
        }

        public String getStep() {
            return step;
        }

        public void setStep(String step) {
            this.step = step;
        }

        public Boolean getRebuildOnRestartIfContainer() {
            return rebuildOnRestartIfContainer;
        }

        public void setRebuildOnRestartIfContainer(Boolean rebuildOnRestartIfContainer) {
            this.rebuildOnRestartIfContainer = rebuildOnRestartIfContainer;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Job job = (Job) o;
            return Objects.equals(id, job.id) &&
                    result == job.result &&
                    Objects.equals(message, job.message) &&
                    Objects.equals(status, job.status) &&
                    Objects.equals(step, job.step) &&
                    Objects.equals(rebuildOnRestartIfContainer, job.rebuildOnRestartIfContainer);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, result, message, status, step, rebuildOnRestartIfContainer);
        }
    }
}
