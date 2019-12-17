package com.smatechnologies.opcon.restapiclient.api.dailygraphedges;

import com.smatechnologies.opcon.commons.objmapper.annotation.ObjMapperField;
import com.smatechnologies.opcon.restapiclient.criteria.ICriteria;

import java.util.Collection;


/**
 * @author Pierre PINON
 */
public class DailyGraphEdgesCriteria implements ICriteria {

    @ObjMapperField
    private Collection<String> jobIds;

    @ObjMapperField
    private Collection<String> scheduleIds;

    @ObjMapperField
    private Integer predecessorLevel;

    @ObjMapperField
    private Integer successorLevel;

    public Collection<String> getJobIds() {
        return jobIds;
    }

    public void setJobIds(Collection<String> jobIds) {
        this.jobIds = jobIds;
    }

    public Collection<String> getScheduleIds() {
        return scheduleIds;
    }

    public void setScheduleIds(Collection<String> scheduleIds) {
        this.scheduleIds = scheduleIds;
    }

    public Integer getPredecessorLevel() {
        return predecessorLevel;
    }

    public void setPredecessorLevel(Integer predecessorLevel) {
        this.predecessorLevel = predecessorLevel;
    }

    public Integer getSuccessorLevel() {
        return successorLevel;
    }

    public void setSuccessorLevel(Integer successorLevel) {
        this.successorLevel = successorLevel;
    }
}
