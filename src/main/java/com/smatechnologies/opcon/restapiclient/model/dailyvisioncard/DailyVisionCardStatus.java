package com.smatechnologies.opcon.restapiclient.model.dailyvisioncard;

import com.smatechnologies.opcon.restapiclient.model.VisionCardCondition;

import java.util.Objects;


/**
 * @author Pierre PINON
 */
public class DailyVisionCardStatus {

    public static final String RESOURCE = "status";

    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_CONDITION = "condition";
    public static final String PROPERTY_SLA = "sla";

    private Integer id;
    private String name;
    private VisionCardCondition condition;
    private DailyVisionCardSla sla;

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

    public VisionCardCondition getCondition() {
        return condition;
    }

    public void setCondition(VisionCardCondition condition) {
        this.condition = condition;
    }

    public DailyVisionCardSla getSla() {
        return sla;
    }

    public void setSla(DailyVisionCardSla sla) {
        this.sla = sla;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        DailyVisionCardStatus that = (DailyVisionCardStatus) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                condition == that.condition &&
                Objects.equals(sla, that.sla);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, condition, sla);
    }
}
