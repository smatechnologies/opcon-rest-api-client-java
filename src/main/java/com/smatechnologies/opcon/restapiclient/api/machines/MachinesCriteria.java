package com.smatechnologies.opcon.restapiclient.api.machines;

import com.smatechnologies.opcon.commons.objmapper.annotation.ObjMapperField;
import com.smatechnologies.opcon.restapiclient.criteria.AbstractResourcesCriteria;
import com.smatechnologies.opcon.restapiclient.criteria.SortedColumn;
import com.smatechnologies.opcon.restapiclient.model.MachineStatus;

import java.util.Collection;
import java.util.Objects;


/**
 * @author Francois EYL
 */
public class MachinesCriteria extends AbstractResourcesCriteria<MachinesCriteria.MachineColumns> {

    @ObjMapperField
    private Collection<Integer> ids;

    @ObjMapperField
    private String name;

    @ObjMapperField
    private Collection<Integer> typeIds;

    @ObjMapperField
    private String type;

    @ObjMapperField
    private Collection<MachineStatus.State> states;

    @ObjMapperField
    private String groupName;

    @ObjMapperField
    private Collection<Integer> groupIds;

    @ObjMapperField
    private Boolean extendedProperties;

    @ObjMapperField
    private String version;

    @ObjMapperField
    private Collection<Integer> sockets;

    @ObjMapperField
    private Boolean tls;

    @ObjMapperField
    private Boolean includeCount;

    public Collection<Integer> getIds() {
        return ids;
    }

    public void setIds(Collection<Integer> ids) {
        this.ids = ids;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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

    public void setStates(Collection<MachineStatus.State> states) {
        this.states = states;
    }

    public Collection<MachineStatus.State> getStates() {
        return states;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public Boolean isExtendedProperties() {
        return extendedProperties;
    }

    public void setExtendedProperties(Boolean extendedProperties) {
        this.extendedProperties = extendedProperties;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Collection<Integer> getSockets() {
        return sockets;
    }

    public void setSockets(Collection<Integer> sockets) {
        this.sockets = sockets;
    }

    public Collection<Integer> getGroupIds() {
        return groupIds;
    }

    public void setGroupIds(Collection<Integer> groupIds) {
        this.groupIds = groupIds;
    }

    public Boolean isTls() {
        return tls;
    }

    public void setTls(Boolean tls) {
        this.tls = tls;
    }

    public Boolean getIncludeCount() {
        return includeCount;
    }

    public void setIncludeCount(Boolean includeCount) {
        this.includeCount = includeCount;
    }

    public Boolean getExtendedProperties() {
        return extendedProperties;
    }

    public Boolean getTls() {
        return tls;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        MachinesCriteria that = (MachinesCriteria) o;
        return Objects.equals(ids, that.ids) &&
                Objects.equals(name, that.name) &&
                Objects.equals(typeIds, that.typeIds) &&
                Objects.equals(type, that.type) &&
                Objects.equals(states, that.states) &&
                Objects.equals(groupName, that.groupName) &&
                Objects.equals(groupIds, that.groupIds) &&
                Objects.equals(extendedProperties, that.extendedProperties) &&
                Objects.equals(version, that.version) &&
                Objects.equals(sockets, that.sockets) &&
                Objects.equals(tls, that.tls) &&
                Objects.equals(includeCount, that.includeCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ids, name, typeIds, type, states, groupName, groupIds, extendedProperties, version, sockets, tls, includeCount);
    }

    /**
     * Allowed column to specify for sort order.
     */
    public enum MachineColumns implements SortedColumn.Column {

        STATE("state"),
        NAME("name"),
        TYPE("type"),
        LASTUPDATE("lastupdate"),
        RUNNINGJOBS("runningJobs"),
        USE_TLS("useTLS"),
        VERSION("version"),
        SOCKET("socket");

        private String name;

        MachineColumns(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }
}