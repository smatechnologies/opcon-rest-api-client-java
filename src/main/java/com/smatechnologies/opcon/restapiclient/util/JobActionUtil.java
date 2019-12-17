package com.smatechnologies.opcon.restapiclient.util;

import com.smatechnologies.opcon.restapiclient.model.FunctionPrivilege;
import com.smatechnologies.opcon.restapiclient.model.JobStatus;
import com.smatechnologies.opcon.restapiclient.model.JobType;
import com.smatechnologies.opcon.restapiclient.model.ScheduleAction;
import com.smatechnologies.opcon.restapiclient.model.User;
import com.smatechnologies.opcon.restapiclient.model.dailyjob.DailyJob;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


/**
 * @author Pierre PINON
 */
public class JobActionUtil {

    private JobActionUtil() {
    }

    public static boolean isHoldActionAllowed(DailyJob dailyJob, User user) {
        JobStatus jobStatus = dailyJob.getStatus();

        if (!user.hasPrivilege(dailyJob.getDepartment().getId(), FunctionPrivilege.HOLD_JOBS)) {
            return false;
        }

        return JobStatus.JobStatusCategory.WAITING.equals(jobStatus.getCategory()) && !JobStatus.JobStatusDescription.JOB_TO_BE_SKIPPED.equals(jobStatus.getDescription());
    }

    public static boolean isCancelActionAllowed(DailyJob dailyJob, User user) {
        JobStatus jobStatus = dailyJob.getStatus();

        if (!user.hasPrivilege(dailyJob.getDepartment().getId(), FunctionPrivilege.CANCEL_JOBS)) {
            return false;
        }

        return !jobStatus.isProcessingEvents() && (JobStatus.JobStatusCategory.HELD.equals(jobStatus.getCategory()) || JobStatus.JobStatusCategory.WAITING.equals(jobStatus.getCategory()) ||
                JobStatus.JobStatusCategory.MISSED_START_TIME.equals(jobStatus.getCategory()) || JobStatus.JobStatusCategory.FAILED.equals(jobStatus.getCategory()) || JobStatus.JobStatusCategory.UNDER_REVIEW.equals(jobStatus.getCategory()));
    }

    public static boolean isSkipActionAllowed(DailyJob dailyJob, User user) {
        JobStatus jobStatus = dailyJob.getStatus();

        if (!user.hasPrivilege(dailyJob.getDepartment().getId(), FunctionPrivilege.SKIP_JOBS)) {
            return false;
        }

        return !jobStatus.isProcessingEvents() && (JobStatus.JobStatusCategory.HELD.equals(jobStatus.getCategory()) || JobStatus.JobStatusCategory.WAITING.equals(jobStatus.getCategory()) ||
                JobStatus.JobStatusCategory.FAILED.equals(jobStatus.getCategory()) || JobStatus.JobStatusCategory.UNDER_REVIEW.equals(jobStatus.getCategory()) || JobStatus.JobStatusCategory.MISSED_START_TIME.equals(jobStatus.getCategory())) &&
                !JobStatus.JobStatusDescription.JOB_TO_BE_SKIPPED.equals(jobStatus.getDescription());
    }

    public static boolean isKillActionAllowed(DailyJob dailyJob, User user) {
        JobStatus jobStatus = dailyJob.getStatus();

        //Cannot Kill a Build In (Null or Container) job
        if (dailyJob.getJobType().isBuildIn()) {
            return false;
        }

        if (!user.hasPrivilege(dailyJob.getDepartment().getId(), FunctionPrivilege.KILL_JOBS)) {
            return false;
        }

        if (!JobStatus.JobStatusCategory.RUNNING.equals(jobStatus.getCategory())) {
            return false;
        }

        if (JobStatus.JobStatusDescription.JOB_RUNNING_AND_TO_BE_TERMINATED.equals(jobStatus.getDescription())) {
            return false;
        }

        return dailyJob.getStartMachine() != null;
    }

    public static boolean isReleaseActionAllowed(DailyJob dailyJob, User user) {
        JobStatus jobStatus = dailyJob.getStatus();

        if (!user.hasPrivilege(dailyJob.getDepartment().getId(), FunctionPrivilege.RELEASE_JOBS)) {
            return false;
        }

        return JobStatus.JobStatusCategory.HELD.equals(jobStatus.getCategory());
    }

    public static boolean isStartActionAllowed(DailyJob dailyJob, User user) {
        JobStatus jobStatus = dailyJob.getStatus();

        if (!user.hasPrivilege(dailyJob.getDepartment().getId(), FunctionPrivilege.FORCE_START_JOBS)) {
            return false;
        }

        return JobStatus.JobStatusCategory.HELD.equals(jobStatus.getCategory()) || JobStatus.JobStatusCategory.WAITING.equals(jobStatus.getCategory()) ||
                JobStatus.JobStatusCategory.MISSED_START_TIME.equals(jobStatus.getCategory());
    }

    public static boolean isRestartActionAllowed(DailyJob dailyJob, User user) {
        JobStatus jobStatus = dailyJob.getStatus();

        if (!user.hasPrivilege(dailyJob.getDepartment().getId(), FunctionPrivilege.RESTART_JOBS)) {
            return false;
        }

        return !jobStatus.isProcessingEvents() && (JobStatus.JobStatusCategory.CANCELLED.equals(jobStatus.getCategory()) || JobStatus.JobStatusCategory.FINISHED_OK.equals(jobStatus.getCategory()) || JobStatus.JobStatusCategory.FIXED.equals(jobStatus.getCategory()) ||
                JobStatus.JobStatusCategory.FAILED.equals(jobStatus.getCategory()) || JobStatus.JobStatusCategory.UNDER_REVIEW.equals(jobStatus.getCategory()) || JobStatus.JobStatusCategory.SKIPPED.equals(jobStatus.getCategory()) ||
                JobStatus.JobStatusDescription.JOB_TO_BE_SKIPPED.equals(jobStatus.getDescription()));
    }

    public static boolean isRestartOnStepActionAllowed(DailyJob dailyJob, User user) {
        return isRestartActionAllowed(dailyJob, user)
                && dailyJob.getSteps() != null && !dailyJob.getSteps().isEmpty();
    }

    public static boolean isMarkFinishedOkActionAllowed(DailyJob dailyJob, User user) {
        JobStatus jobStatus = dailyJob.getStatus();

        //Cannot MARK Finished Ok a container job whenever it's still running
        if (dailyJob.getJobType() == JobType.CONTAINER && JobStatus.JobStatusCategory.RUNNING.equals(jobStatus.getCategory())) {
            return false;
        }

        if (!user.hasPrivilege(dailyJob.getDepartment().getId(), FunctionPrivilege.MARK_JOBS_FINISHED_OK)) {
            return false;
        }

        return !jobStatus.isProcessingEvents() && (JobStatus.JobStatusCategory.HELD.equals(jobStatus.getCategory()) || JobStatus.JobStatusCategory.WAITING.equals(jobStatus.getCategory()) ||
                JobStatus.JobStatusCategory.RUNNING.equals(jobStatus.getCategory()) || JobStatus.JobStatusCategory.FAILED.equals(jobStatus.getCategory()) || JobStatus.JobStatusCategory.UNDER_REVIEW.equals(jobStatus.getCategory()) ||
                JobStatus.JobStatusCategory.MISSED_START_TIME.equals(jobStatus.getCategory()) || JobStatus.JobStatusCategory.FIXED.equals(jobStatus.getCategory()));
    }

    public static boolean isMarkFailedActionAllowed(DailyJob dailyJob, User user) {
        JobStatus jobStatus = dailyJob.getStatus();

        //Cannot MARK Failed a container job whenever it's still running
        if (dailyJob.getJobType() == JobType.CONTAINER && JobStatus.JobStatusCategory.RUNNING.equals(jobStatus.getCategory())) {
            return false;
        }

        if (!user.hasPrivilege(dailyJob.getDepartment().getId(), FunctionPrivilege.MARK_JOBS_FAILED)) {
            return false;
        }

        return !jobStatus.isProcessingEvents() && (JobStatus.JobStatusCategory.HELD.equals(jobStatus.getCategory()) || JobStatus.JobStatusCategory.WAITING.equals(jobStatus.getCategory()) ||
                JobStatus.JobStatusCategory.RUNNING.equals(jobStatus.getCategory()) || JobStatus.JobStatusCategory.FINISHED_OK.equals(jobStatus.getCategory()) || JobStatus.JobStatusCategory.FIXED.equals(jobStatus.getCategory()) ||
                JobStatus.JobStatusCategory.MISSED_START_TIME.equals(jobStatus.getCategory()) || JobStatus.JobStatusCategory.UNDER_REVIEW.equals(jobStatus.getCategory()));
    }

    public static boolean isMarkUnderReviewAllowed(DailyJob dailyJob, User user) {
        JobStatus jobStatus = dailyJob.getStatus();

        //Cannot Under Review a container job whenever it's still running
        if (dailyJob.getJobType() == JobType.CONTAINER && JobStatus.JobStatusCategory.RUNNING.equals(jobStatus.getCategory())) {
            return false;
        }

        if (!user.hasPrivilege(dailyJob.getDepartment().getId(), FunctionPrivilege.MARK_JOBS_FAILED)) {
            return false;
        }

        return !jobStatus.isProcessingEvents() && JobStatus.JobStatusCategory.FAILED.equals(jobStatus.getCategory());
    }

    public static boolean isMarkFixedAllowed(DailyJob dailyJob, User user) {
        JobStatus jobStatus = dailyJob.getStatus();

        //Cannot Fixed a container job whenever it's still running
        if (dailyJob.getJobType() == JobType.CONTAINER && JobStatus.JobStatusCategory.RUNNING.equals(jobStatus.getCategory())) {
            return false;
        }

        if (!user.hasPrivilege(dailyJob.getDepartment().getId(), FunctionPrivilege.MARK_JOBS_FINISHED_OK)) {
            return false;
        }

        return !jobStatus.isProcessingEvents() && (JobStatus.JobStatusCategory.FAILED.equals(jobStatus.getCategory()) || JobStatus.JobStatusCategory.UNDER_REVIEW.equals(jobStatus.getCategory()));
    }

    public static Set<JobStatus.JobStatusCategory> getAvailableStatusCategories(ScheduleAction.Action action) {
        Objects.requireNonNull(action, "Action cannot be null");

        Set<JobStatus.JobStatusCategory> categories = new HashSet<>();

        if (action.equals(ScheduleAction.Action.CANCEL_JOBS) || action.equals(ScheduleAction.Action.SKIP_JOBS) || action.equals(ScheduleAction.Action.MARK_JOBS_FINISHED_OK) || action.equals(ScheduleAction.Action.MARK_JOBS_FAILED) || action.equals(ScheduleAction.Action.RELEASE_JOBS)) {
            categories.add(JobStatus.JobStatusCategory.HELD);
        }

        if (action.equals(ScheduleAction.Action.CANCEL_JOBS) || action.equals(ScheduleAction.Action.SKIP_JOBS) || action.equals(ScheduleAction.Action.MARK_JOBS_FINISHED_OK) || action.equals(ScheduleAction.Action.MARK_JOBS_FAILED) || action.equals(ScheduleAction.Action.HOLD_JOBS)) {
            categories.add(JobStatus.JobStatusCategory.WAITING);
        }

        if (action.equals(ScheduleAction.Action.CANCEL_JOBS) || action.equals(ScheduleAction.Action.SKIP_JOBS) || action.equals(ScheduleAction.Action.MARK_JOBS_FINISHED_OK) || action.equals(ScheduleAction.Action.RESTART_JOBS) || action.equals(ScheduleAction.Action.RESTART_JOBS_ON_HOLD) || action.equals(ScheduleAction.Action.MARK_JOBS_UNDER_REVIEW) || action.equals(ScheduleAction.Action.MARK_JOBS_FIXED)) {
            categories.add(JobStatus.JobStatusCategory.FAILED);
        }

        if (action.equals(ScheduleAction.Action.CANCEL_JOBS) || action.equals(ScheduleAction.Action.SKIP_JOBS) || action.equals(ScheduleAction.Action.MARK_JOBS_FINISHED_OK) || action.equals(ScheduleAction.Action.MARK_JOBS_FAILED) || action.equals(ScheduleAction.Action.RESTART_JOBS) || action.equals(ScheduleAction.Action.RESTART_JOBS_ON_HOLD) || action.equals(ScheduleAction.Action.MARK_JOBS_FIXED)) {
            categories.add(JobStatus.JobStatusCategory.UNDER_REVIEW);
        }

        if (action.equals(ScheduleAction.Action.RESTART_JOBS) || action.equals(ScheduleAction.Action.RESTART_JOBS_ON_HOLD) || action.equals(ScheduleAction.Action.MARK_JOBS_FAILED) || action.equals(ScheduleAction.Action.MARK_JOBS_FINISHED_OK)) {
            categories.add(JobStatus.JobStatusCategory.FIXED);
        }

        if (action.equals(ScheduleAction.Action.CANCEL_JOBS) || action.equals(ScheduleAction.Action.SKIP_JOBS) || action.equals(ScheduleAction.Action.MARK_JOBS_FINISHED_OK) || action.equals(ScheduleAction.Action.MARK_JOBS_FAILED)) {
            categories.add(JobStatus.JobStatusCategory.MISSED_START_TIME);
        }

        if (action.equals(ScheduleAction.Action.RESTART_JOBS) || action.equals(ScheduleAction.Action.RESTART_JOBS_ON_HOLD)) {
            categories.add(JobStatus.JobStatusCategory.CANCELLED);
            categories.add(JobStatus.JobStatusCategory.SKIPPED);
        }

        if (action.equals(ScheduleAction.Action.RESTART_JOBS) || action.equals(ScheduleAction.Action.RESTART_JOBS_ON_HOLD) || action.equals(ScheduleAction.Action.MARK_JOBS_FAILED)) {
            categories.add(JobStatus.JobStatusCategory.FINISHED_OK);
        }

        if (action.equals(ScheduleAction.Action.MARK_JOBS_FAILED) || action.equals(ScheduleAction.Action.MARK_JOBS_FINISHED_OK)) {
            categories.add(JobStatus.JobStatusCategory.RUNNING);
        }

        return categories;
    }
}
