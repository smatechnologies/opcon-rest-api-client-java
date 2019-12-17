package com.smatechnologies.opcon.restapiclient.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Map;


/**
 * @author Pierre PINON
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum JobType {
    UNKNOWN(-99999, "Unknown", false),
    NULL_JOB(-1, "Null Job", true),
    FILE_TRANSFER(1, "File Transfer", false),
    HP_NONSTOP(2, "HP NonStop", false),
    WINDOWS(3, "Windows", false),
    OPEN_VMS(4, "OpenVMS", false),
    IBM_I(5, "IBM i", false),
    UNIX(6, "UNIX", false),
    OS_2200(7, "OS 2200", false),
    VSE(8, "VSE", false),
    MCP(9, "MCP", false),
    BIS(11, "BIS", false),
    ZOS(12, "z/OS", false),
    SAP_R3_AND_CRM(13, "SAP R/3 and CRM", false),
    SAP_BW(14, "SAP BW", false),
    CONTAINER(15, "Container", true),
    JEE(16, "JEE", false),
    JAVA(17, "Java", false),
    TUXEDO_ART(18, "Tuxedo ART (Beta)", false),
    EASE(19, "EASE", false),
    ASYSCO_AMT(20, "Asysco AMT", false),
    SQL(21, "SQL", false);

    public static final String RESOURCE = "jobType";

    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_BUILD_IN = "buildIn";

    private final int id;
    @JsonIgnore
    private final String description;
    @JsonIgnore
    private final boolean buildIn;

    JobType(int id, String description, boolean buildIn) {
        this.id = id;
        this.description = description;
        this.buildIn = buildIn;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isBuildIn() {
        return buildIn;
    }

    @JsonCreator
    public static JobType fromObject(final Map<String, Object> obj) {
        if (obj != null && obj.containsKey("id")) {
            Integer id;
            if (obj.get("id") instanceof Integer) {
                id = (Integer) obj.get("id");
            } else {
                id = Integer.parseInt((String) obj.get("id"));
            }
            if (id != null) {
                for (JobType e : JobType.values()) {
                    if (id.equals(e.getId()))
                        return e;
                }
            }
            return null;
        }
        return null;
    }
}
