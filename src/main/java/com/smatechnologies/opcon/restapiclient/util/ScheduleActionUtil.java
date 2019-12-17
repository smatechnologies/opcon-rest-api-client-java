package com.smatechnologies.opcon.restapiclient.util;

import com.smatechnologies.opcon.restapiclient.model.DailySchedule;
import com.smatechnologies.opcon.restapiclient.model.FunctionPrivilege;
import com.smatechnologies.opcon.restapiclient.model.ScheduleStatus;
import com.smatechnologies.opcon.restapiclient.model.User;


/**
 * @author Pierre PINON
 */
public class ScheduleActionUtil {

    private ScheduleActionUtil() {
    }

    public static boolean isReleaseActionAllowed(DailySchedule dailySchedule, User user) {
        if (!user.hasPrivilege(FunctionPrivilege.RELEASE_SCHEDULES)) {
            return false;
        }

        return (dailySchedule.getStatus().getId() != ScheduleStatus.ID_PARENT_HOLD && ScheduleStatus.ScheduleStatusCategory.HELD.equals(dailySchedule.getStatus().getCategory()));
    }

    public static boolean isHoldActionAllowed(DailySchedule dailySchedule, User user) {
        if (!user.hasPrivilege(FunctionPrivilege.HOLD_SCHEDULES)) {
            return false;
        }

        return (dailySchedule.getStatus().getId() != ScheduleStatus.ID_PARENT_HOLD && (ScheduleStatus.ScheduleStatusCategory.WAITING.equals(dailySchedule.getStatus().getCategory()) ||
                ScheduleStatus.ScheduleStatusCategory.RUNNING.equals(dailySchedule.getStatus().getCategory()) ||
                ScheduleStatus.ScheduleStatusCategory.FINISHED_OK.equals(dailySchedule.getStatus().getCategory())));
    }

    public static boolean isCloseActionAllowed(DailySchedule dailySchedule, User user) {
        if (!user.hasPrivilege(FunctionPrivilege.HOLD_SCHEDULES)) {
            return false;
        }

        return (dailySchedule.getStatus().getId() != ScheduleStatus.ID_PARENT_HOLD && !ScheduleStatus.ScheduleStatusCategory.FINISHED_OK.equals(dailySchedule.getStatus().getCategory()));
    }

    public static boolean isStartActionAllowed(DailySchedule dailySchedule, User user) {
        if (!user.hasPrivilege(FunctionPrivilege.FORCE_START_SCHEDULES)) {
            return false;
        }

        return (dailySchedule.getStatus().getId() != ScheduleStatus.ID_PARENT_HOLD && ScheduleStatus.ScheduleStatusCategory.WAITING.equals(dailySchedule.getStatus().getCategory()));
    }
}
