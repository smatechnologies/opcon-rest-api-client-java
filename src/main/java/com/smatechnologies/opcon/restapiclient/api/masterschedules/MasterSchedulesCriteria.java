package com.smatechnologies.opcon.restapiclient.api.masterschedules;

import com.smatechnologies.opcon.commons.objmapper.annotation.ObjMapperField;
import com.smatechnologies.opcon.restapiclient.criteria.AbstractResourcesCriteria;
import com.smatechnologies.opcon.restapiclient.criteria.SortedColumn;
import com.smatechnologies.opcon.restapiclient.model.MasterSchedule;

import java.util.Collection;


/**
 * @author Pierre PINON.
 */
public class MasterSchedulesCriteria extends AbstractResourcesCriteria<MasterSchedulesCriteria.MasterScheduleColumns> {

    @ObjMapperField
    private Collection<Integer> ids;
    @ObjMapperField
    private String name;

    @ObjMapperField
    private Boolean includeCount;

    @ObjMapperField
    private Boolean autoBuild;

    @ObjMapperField
    private Boolean multiInstance;

    @ObjMapperField
    private Boolean subSchedule;

    public Collection<Integer> getIds() {
        return ids;
    }

    public void setIds(Collection<Integer> ids) {
        this.ids = ids;
    }

    public Boolean getIncludeCount() {
        return includeCount;
    }

    public void setIncludeCount(Boolean includeCount) {
        this.includeCount = includeCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAutoBuild() {
        return autoBuild;
    }

    public void setAutoBuild(Boolean autoBuild) {
        this.autoBuild = autoBuild;
    }

    public Boolean getMultiInstance() {
        return multiInstance;
    }

    public void setMultiInstance(Boolean multiInstance) {
        this.multiInstance = multiInstance;
    }

    public Boolean getSubSchedule() {
        return subSchedule;
    }

    public void setSubSchedule(Boolean subSchedule) {
        this.subSchedule = subSchedule;
    }

    public enum MasterScheduleColumns implements SortedColumn.Column {

        NAME(MasterSchedule.PROPERTY_NAME);

        private String name;

        MasterScheduleColumns(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }
}
