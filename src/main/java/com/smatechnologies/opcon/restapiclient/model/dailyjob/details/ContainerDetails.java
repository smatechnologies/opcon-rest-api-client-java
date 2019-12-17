package com.smatechnologies.opcon.restapiclient.model.dailyjob.details;

import com.smatechnologies.opcon.restapiclient.model.DailySchedule;
import com.smatechnologies.opcon.restapiclient.model.MasterSchedule;

import java.util.Objects;


/**
 * @author Pierre PINON
 */
public class ContainerDetails {

    public static final String RESOURCE = "details";

    public static final String PROPERTY_DAILY_SUB_SCHEDULE = "dailySubSchedule";
    public static final String PROPERTY_MASTER_SUB_SCHEDULE = "masterSubSchedule";

    private DailySchedule dailySubSchedule;
    private MasterSchedule masterSubSchedule;

    public DailySchedule getDailySubSchedule() {
        return dailySubSchedule;
    }

    public void setDailySubSchedule(DailySchedule dailySubSchedule) {
        this.dailySubSchedule = dailySubSchedule;
    }

    public MasterSchedule getMasterSubSchedule() {
        return masterSubSchedule;
    }

    public void setMasterSubSchedule(MasterSchedule masterSubSchedule) {
        this.masterSubSchedule = masterSubSchedule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ContainerDetails that = (ContainerDetails) o;
        return Objects.equals(dailySubSchedule, that.dailySubSchedule) &&
                Objects.equals(masterSubSchedule, that.masterSubSchedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dailySubSchedule, masterSubSchedule);
    }
}
