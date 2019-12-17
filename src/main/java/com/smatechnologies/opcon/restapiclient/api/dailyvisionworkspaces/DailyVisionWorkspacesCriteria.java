package com.smatechnologies.opcon.restapiclient.api.dailyvisionworkspaces;

import com.smatechnologies.opcon.commons.objmapper.annotation.ObjMapperField;
import com.smatechnologies.opcon.restapiclient.api.mastervisionworkspaces.MasterVisionWorkspaceCriteria;
import com.smatechnologies.opcon.restapiclient.criteria.AbstractResourcesCriteria;
import com.smatechnologies.opcon.restapiclient.criteria.SortedColumn;

import java.util.Collection;
import java.util.Objects;


/**
 * @author Matthieu COELHO
 */
public class DailyVisionWorkspacesCriteria extends AbstractResourcesCriteria<MasterVisionWorkspaceCriteria.MasterVisionWorkspaceColumns> {

    @ObjMapperField
    private Collection<Integer> ids;

    @ObjMapperField
    private Integer dayOffset;

    public Collection<Integer> getIds() {
        return ids;
    }

    public void setIds(Collection<Integer> ids) {
        this.ids = ids;
    }

    public Integer getDayOffset() {
        return dayOffset;
    }

    public void setDayOffset(Integer dayOffset) {
        this.dayOffset = dayOffset;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof DailyVisionWorkspacesCriteria))
            return false;
        DailyVisionWorkspacesCriteria that = (DailyVisionWorkspacesCriteria) o;
        return Objects.equals(getIds(), that.getIds()) &&
                Objects.equals(getDayOffset(), that.getDayOffset());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIds(), getDayOffset());
    }

    public enum DailyVisionWorkspaceColumns implements SortedColumn.Column {
        ID("id"),
        NAME("name");

        private String name;

        DailyVisionWorkspaceColumns(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }
}
