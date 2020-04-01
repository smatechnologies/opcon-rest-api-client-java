package com.smatechnologies.opcon.restapiclient.api.machinegroups;

import com.smatechnologies.opcon.commons.objmapper.annotation.ObjMapperField;
import com.smatechnologies.opcon.restapiclient.criteria.AbstractResourcesCriteria;
import com.smatechnologies.opcon.restapiclient.criteria.SortedColumn;

import java.util.Collection;
import java.util.Objects;


/**
 * @author Pierre PINON
 */
public class MachineGroupsCriteria extends AbstractResourcesCriteria<MachineGroupsCriteria.MachineGroupColumns> {

    @ObjMapperField
    private String name;

    @ObjMapperField
    private Collection<Integer> ids;

    @ObjMapperField
    private Collection<Integer> typeIds;

    @ObjMapperField
    private String type;

    @ObjMapperField
    private Boolean includeMachines;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Integer> getIds() {
        return ids;
    }

    public void setIds(Collection<Integer> ids) {
        this.ids = ids;
    }

    public void setTypeIds(Collection<Integer> typeIds) {
        this.typeIds = typeIds;
    }

    public Collection<Integer> getTypeIds() {
        return typeIds;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public Boolean getIncludeMachines() {
        return includeMachines;
    }

    public void setIncludeMachines(Boolean includeMachines) {
        this.includeMachines = includeMachines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        MachineGroupsCriteria that = (MachineGroupsCriteria) o;
        return Objects.equals(ids, that.ids) &&
                Objects.equals(typeIds, that.typeIds) &&
                Objects.equals(type, that.type) &&
                Objects.equals(includeMachines, that.includeMachines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ids, typeIds, type, includeMachines);
    }

    /**
     * Allowed column to specify for sort order.
     */
    public enum MachineGroupColumns implements SortedColumn.Column {

        ID("id"),
        NAME("name"),
        TYPE("type");

        private String name;

        MachineGroupColumns(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }
}
