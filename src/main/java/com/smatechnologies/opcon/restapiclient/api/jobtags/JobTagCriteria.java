package com.smatechnologies.opcon.restapiclient.api.jobtags;

import com.smatechnologies.opcon.commons.objmapper.annotation.ObjMapperField;
import com.smatechnologies.opcon.restapiclient.criteria.AbstractResourcesCriteria;
import com.smatechnologies.opcon.restapiclient.criteria.SortedColumn;

import java.util.Objects;


/**
 * @author Matthieu COELHO
 */
public class JobTagCriteria extends AbstractResourcesCriteria<JobTagCriteria.JobTagColumns> {

    @ObjMapperField
    private String name;

    @ObjMapperField
    private String remoteInstance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemoteInstance() {
        return remoteInstance;
    }

    public void setRemoteInstance(String remoteInstance) {
        this.remoteInstance = remoteInstance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof JobTagCriteria))
            return false;
        JobTagCriteria that = (JobTagCriteria) o;
        return Objects.equals(getName(), that.getName()) &&
                Objects.equals(getRemoteInstance(), that.getRemoteInstance());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getRemoteInstance());
    }

    public enum JobTagColumns implements SortedColumn.Column {
        NAME("name");

        private String name;

        JobTagColumns(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }
}
