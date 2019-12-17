package com.smatechnologies.opcon.restapiclient.model;

import com.smatechnologies.opcon.restapiclient.model.machine.Machine;


/**
 * Resource describing a master Job in OpCon.
 *
 * @author Pierre PINON.
 */
public class MasterJob {

    public static final String RESOURCE = "masterJob";

    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_FREQUENCY = "frequency";
    public static final String PROPERTY_JOB_TYPE = "jobType";
    public static final String PROPERTY_DEPARTMENT = "department";
    public static final String PROPERTY_ACCESS_CODE = "accessCode";
    public static final String PROPERTY_PRIMARY_MACHINE = "primaryMachine";
    public static final String PROPERTY_ALTERNATE_MACHINE = "alternateMachine";
    public static final String PROPERTY_ALTERNATE_MACHINE_2 = "alternateMachine2";
    public static final String PROPERTY_ALTERNATE_MACHINE_3 = "alternateMachine3";
    public static final String PROPERTY_MACHINE_GROUP = "machineGroup";
    public static final String PROPERTY_ESTIMATED_RUN_TIME = "estimatedRunTime";
    public static final String PROPERTY_SCHEDULE = "schedule";

    private String name;
    private Frequency frequency;
    private JobType jobType;
    private Department department;
    private AccessCode accessCode;
    private Machine primaryMachine;
    private Machine alternateMachine;
    private Machine alternateMachine2;
    private Machine alternateMachine3;
    private MachineGroup machineGroup;
    private Integer estimatedRunTime;
    private MasterSchedule schedule;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public AccessCode getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(AccessCode accessCode) {
        this.accessCode = accessCode;
    }

    public Machine getPrimaryMachine() {
        return primaryMachine;
    }

    public void setPrimaryMachine(Machine primaryMachine) {
        this.primaryMachine = primaryMachine;
    }

    public Machine getAlternateMachine() {
        return alternateMachine;
    }

    public void setAlternateMachineId(Machine alternateMachine) {
        this.alternateMachine = alternateMachine;
    }

    public Machine getAlternateMachine2() {
        return alternateMachine2;
    }

    public void setAlternateMachine2(Machine alternateMachine2) {
        this.alternateMachine2 = alternateMachine2;
    }

    public Machine getAlternateMachine3() {
        return alternateMachine3;
    }

    public void setAlternateMachine3(Machine alternateMachine3) {
        this.alternateMachine3 = alternateMachine3;
    }

    public MachineGroup getMachineGroup() {
        return machineGroup;
    }

    public void setMachineGroup(MachineGroup machineGroup) {
        this.machineGroup = machineGroup;
    }

    public Integer getEstimatedRunTime() {
        return estimatedRunTime;
    }

    public void setEstimatedRunTime(Integer estimatedRunTime) {
        this.estimatedRunTime = estimatedRunTime;
    }

    public MasterSchedule getSchedule() {
        return schedule;
    }

    public void setSchedule(MasterSchedule schedule) {
        this.schedule = schedule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        MasterJob masterJob = (MasterJob) o;

        if (name != null ? !name.equals(masterJob.name) : masterJob.name != null)
            return false;
        if (frequency != null ? !frequency.equals(masterJob.frequency) : masterJob.frequency != null)
            return false;
        if (jobType != null ? !jobType.equals(masterJob.jobType) : masterJob.jobType != null)
            return false;
        if (department != null ? !department.equals(masterJob.department) : masterJob.department != null)
            return false;
        if (accessCode != null ? !accessCode.equals(masterJob.accessCode) : masterJob.accessCode != null)
            return false;
        if (primaryMachine != null ? !primaryMachine.equals(masterJob.primaryMachine) : masterJob.primaryMachine != null)
            return false;
        if (alternateMachine != null ? !alternateMachine.equals(masterJob.alternateMachine) : masterJob.alternateMachine != null)
            return false;
        if (alternateMachine2 != null ? !alternateMachine2.equals(masterJob.alternateMachine2) : masterJob.alternateMachine2 != null)
            return false;
        if (alternateMachine3 != null ? !alternateMachine3.equals(masterJob.alternateMachine3) : masterJob.alternateMachine3 != null)
            return false;
        if (machineGroup != null ? !machineGroup.equals(masterJob.machineGroup) : masterJob.machineGroup != null)
            return false;
        if (estimatedRunTime != null ? !estimatedRunTime.equals(masterJob.estimatedRunTime) : masterJob.estimatedRunTime != null)
            return false;
        return schedule != null ? schedule.equals(masterJob.schedule) : masterJob.schedule == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (frequency != null ? frequency.hashCode() : 0);
        result = 31 * result + (jobType != null ? jobType.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + (accessCode != null ? accessCode.hashCode() : 0);
        result = 31 * result + (primaryMachine != null ? primaryMachine.hashCode() : 0);
        result = 31 * result + (alternateMachine != null ? alternateMachine.hashCode() : 0);
        result = 31 * result + (alternateMachine2 != null ? alternateMachine2.hashCode() : 0);
        result = 31 * result + (alternateMachine3 != null ? alternateMachine3.hashCode() : 0);
        result = 31 * result + (machineGroup != null ? machineGroup.hashCode() : 0);
        result = 31 * result + (estimatedRunTime != null ? estimatedRunTime.hashCode() : 0);
        result = 31 * result + (schedule != null ? schedule.hashCode() : 0);
        return result;
    }
}
