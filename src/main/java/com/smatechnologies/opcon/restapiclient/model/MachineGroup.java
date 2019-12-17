package com.smatechnologies.opcon.restapiclient.model;

import com.smatechnologies.opcon.restapiclient.model.machine.Machine;

import java.util.List;
import java.util.Objects;


/**
 * @author Francois EYL
 */
public class MachineGroup {

    public static final String RESOURCE = "machineGroup";

    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_TYPE = "type";
    public static final String PROPERTY_MACHINES = "machines";
    public static final String PROPERTY_DOCUMENTATION = "documentation";

    private Integer id;
    private String name;
    private MachineType type;
    private List<Machine> machines;
    private String documentation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MachineType getType() {
        return type;
    }

    public void setType(MachineType type) {
        this.type = type;
    }

    public List<Machine> getMachines() {
        return machines;
    }

    public void setMachines(List<Machine> machines) {
        this.machines = machines;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        MachineGroup that = (MachineGroup) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                type == that.type &&
                Objects.equals(machines, that.machines) &&
                Objects.equals(documentation, that.documentation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, machines, documentation);
    }
}
