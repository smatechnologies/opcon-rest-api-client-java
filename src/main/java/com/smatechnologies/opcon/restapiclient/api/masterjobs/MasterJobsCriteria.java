package com.smatechnologies.opcon.restapiclient.api.masterjobs;

import com.smatechnologies.opcon.commons.objmapper.annotation.ObjMapperField;
import com.smatechnologies.opcon.restapiclient.criteria.AbstractResourcesCriteria;
import com.smatechnologies.opcon.restapiclient.criteria.SortedColumn;


/**
 * @author Pierre PINON.
 */
public class MasterJobsCriteria extends AbstractResourcesCriteria<MasterJobsCriteria.MasterJobColumns> {

    @ObjMapperField
    private String name;

    @ObjMapperField
    private String scheduleName;

    @ObjMapperField
    private String jobType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScheduleName() {
        return scheduleName;
    }

    public void setScheduleName(String scheduleName) {
        this.scheduleName = scheduleName;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public enum MasterJobColumns implements SortedColumn.Column {

        NAME("name");

        private String name;

        MasterJobColumns(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }
}
