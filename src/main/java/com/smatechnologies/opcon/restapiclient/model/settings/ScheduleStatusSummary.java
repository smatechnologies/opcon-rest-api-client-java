package com.smatechnologies.opcon.restapiclient.model.settings;

import com.smatechnologies.opcon.restapiclient.model.ScheduleStatus;


/**
 * @author Pierre PINON
 */
public enum ScheduleStatusSummary {

    WAITING("Waiting", null, ScheduleStatus.ScheduleStatusCategory.WAITING),
    HELD("Held", null, ScheduleStatus.ScheduleStatusCategory.HELD),
    IN_PROCESS("In Process", null, ScheduleStatus.ScheduleStatusCategory.RUNNING),
    COMPLETED("Completed", false, ScheduleStatus.ScheduleStatusCategory.FINISHED_OK),
    COMPLETED_WITH_ERROR("Completed With Error(s)", true, ScheduleStatus.ScheduleStatusCategory.FINISHED_OK);

    private final String caption;
    private final Boolean containsFailedJobs;
    private final ScheduleStatus.ScheduleStatusCategory scheduleStatusCategory;

    ScheduleStatusSummary(String caption, Boolean containsFailedJobs, ScheduleStatus.ScheduleStatusCategory scheduleStatusCategory) {
        this.caption = caption;
        this.containsFailedJobs = containsFailedJobs;
        this.scheduleStatusCategory = scheduleStatusCategory;
    }

    public String getCaption() {
        return caption;
    }

    public Boolean getContainsFailedJobs() {
        return containsFailedJobs;
    }

    public ScheduleStatus.ScheduleStatusCategory getScheduleStatusCategory() {
        return scheduleStatusCategory;
    }

    public static ScheduleStatusSummary fromScheduleStatus(final ScheduleStatus scheduleStatus) {
        if (scheduleStatus == null) {
            return null;
        }

        ScheduleStatus.ScheduleStatusCategory scheduleStatusCategory = scheduleStatus.getCategory();
        if (scheduleStatusCategory == null) {
            return null;
        }

        Boolean containsFailedJobs = scheduleStatus.getContainsFailedJobs();

        for (ScheduleStatusSummary scheduleStatusFilter : values()) {
            if (scheduleStatusFilter.getScheduleStatusCategory() == scheduleStatusCategory && (scheduleStatusFilter.getContainsFailedJobs() == null || scheduleStatusFilter.getContainsFailedJobs().equals(containsFailedJobs))) {
                return scheduleStatusFilter;
            }
        }

        return null;
    }
}
