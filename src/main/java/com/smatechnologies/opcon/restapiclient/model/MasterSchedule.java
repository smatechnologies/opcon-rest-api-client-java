package com.smatechnologies.opcon.restapiclient.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;
import com.smatechnologies.opcon.restapiclient.jackson.NestedStdTypeResolverBuilder;

import java.util.List;
import java.util.Objects;


/**
 * @author Matthieu COELHO
 */
public class MasterSchedule {

    public static final String RESOURCE = "masterSchedule";

    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_SUB_SCHEDULE = "subSchedule";
    public static final String PROPERTY_AUTO_BUILD_SETTINGS = "autoBuildSettings";
    public static final String PROPERTY_MULTI_INSTANCE_DETAILS = "multiInstanceDetails";
    public static final String PROPERTY_PROPERTIES = "properties";

    private Integer id;
    private String name;
    private Boolean subSchedule;
    private AutoBuildSettings autoBuildSettings;
    private MultiInstanceDetails multiInstanceDetails;
    private List<Property> properties;

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

    public Boolean getSubSchedule() {
        return subSchedule;
    }

    public void setSubSchedule(Boolean subSchedule) {
        this.subSchedule = subSchedule;
    }

    public AutoBuildSettings getAutoBuildSettings() {
        return autoBuildSettings;
    }

    public void setAutoBuildSettings(AutoBuildSettings autoBuildSettings) {
        this.autoBuildSettings = autoBuildSettings;
    }

    public MultiInstanceDetails getMultiInstanceDetails() {
        return multiInstanceDetails;
    }

    public void setMultiInstanceDetails(MultiInstanceDetails multiInstanceDetails) {
        this.multiInstanceDetails = multiInstanceDetails;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        MasterSchedule that = (MasterSchedule) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(subSchedule, that.subSchedule) &&
                Objects.equals(autoBuildSettings, that.autoBuildSettings) &&
                Objects.equals(multiInstanceDetails, that.multiInstanceDetails) &&
                Objects.equals(properties, that.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, subSchedule, autoBuildSettings, multiInstanceDetails, properties);
    }

    public static class AutoBuildSettings {

        public static final String RESOURCE = "autoBuildSettings";

        public static final String PROPERTY_NUMBER_OF_DAYS_IN_ADVANCE = "numberOfDaysInAdvance";
        public static final String PROPERTY_DAYS_TO_BUILD = "daysToBuild";
        public static final String PROPERTY_OVERWRITE = "overwrite";
        public static final String PROPERTY_BUILD_ON_HOLD = "buildOnHold";
        public static final String PROPERTY_BUILD_OFFSET = "buildOffset";

        private Integer numberOfDaysInAdvance;
        private Integer daysToBuild;
        private Boolean overwrite;
        private Boolean buildOnHold;
        private Integer buildOffset;

        public Integer getNumberOfDaysInAdvance() {
            return numberOfDaysInAdvance;
        }

        public void setNumberOfDaysInAdvance(Integer numberOfDaysInAdvance) {
            this.numberOfDaysInAdvance = numberOfDaysInAdvance;
        }

        public Integer getDaysToBuild() {
            return daysToBuild;
        }

        public void setDaysToBuild(Integer daysToBuild) {
            this.daysToBuild = daysToBuild;
        }

        public Boolean getOverwrite() {
            return overwrite;
        }

        public void setOverwrite(Boolean overwrite) {
            this.overwrite = overwrite;
        }

        public Boolean getBuildOnHold() {
            return buildOnHold;
        }

        public void setBuildOnHold(Boolean buildOnHold) {
            this.buildOnHold = buildOnHold;
        }

        public Integer getBuildOffset() {
            return buildOffset;
        }

        public void setBuildOffset(Integer buildOffset) {
            this.buildOffset = buildOffset;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            AutoBuildSettings that = (AutoBuildSettings) o;
            return Objects.equals(numberOfDaysInAdvance, that.numberOfDaysInAdvance) &&
                    Objects.equals(daysToBuild, that.daysToBuild) &&
                    Objects.equals(overwrite, that.overwrite) &&
                    Objects.equals(buildOnHold, that.buildOnHold) &&
                    Objects.equals(buildOffset, that.buildOffset);
        }

        @Override
        public int hashCode() {
            return Objects.hash(numberOfDaysInAdvance, daysToBuild, overwrite, buildOnHold, buildOffset);
        }
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = MultiInstanceDetails.PROPERTY_TYPE)
    @JsonTypeResolver(NestedStdTypeResolverBuilder.class)
    @JsonSubTypes({
            @JsonSubTypes.Type(value = MultiInstanceDetails.MachineGroupMultiInstanceDetails.class, name = "machineGroup"),
            @JsonSubTypes.Type(value = MultiInstanceDetails.NamedInstanceMultiInstanceDetails.class, name = "namedInstance"),
            @JsonSubTypes.Type(value = MultiInstanceDetails.PropertiesMultiInstanceDetails.class, name = "properties")
    })
    public static abstract class MultiInstanceDetails {

        public static final String RESOURCE = "multiInstanceDetails";
        public static final String PROPERTY_TYPE = "type";

        private Type type;

        public Type getType() {
            return type;
        }

        public void setType(Type type) {
            this.type = type;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            MultiInstanceDetails that = (MultiInstanceDetails) o;
            return type == that.type;
        }

        @Override
        public int hashCode() {
            return Objects.hash(type);
        }

        public static class PropertiesMultiInstanceDetails extends MultiInstanceDetails {

            public static final String PROPERTY_PROPERTIES_LIST = "propertiesList";
            private List<List<Property>> propertiesList;

            public List<List<Property>> getPropertiesList() {
                return propertiesList;
            }

            public void setPropertiesList(List<List<Property>> propertiesList) {
                this.propertiesList = propertiesList;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o)
                    return true;
                if (o == null || getClass() != o.getClass())
                    return false;
                if (!super.equals(o))
                    return false;
                PropertiesMultiInstanceDetails that = (PropertiesMultiInstanceDetails) o;
                return Objects.equals(propertiesList, that.propertiesList);
            }

            @Override
            public int hashCode() {
                return Objects.hash(super.hashCode(), propertiesList);
            }
        }

        public static class MachineGroupMultiInstanceDetails extends MultiInstanceDetails {

            public static final String PROPERTY_MACHINE_GROUP = "machineGroup";
            private MachineGroup machineGroup;

            public MachineGroup getMachineGroup() {
                return machineGroup;
            }

            public void setMachineGroup(MachineGroup machineGroup) {
                this.machineGroup = machineGroup;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o)
                    return true;
                if (o == null || getClass() != o.getClass())
                    return false;
                if (!super.equals(o))
                    return false;
                MachineGroupMultiInstanceDetails that = (MachineGroupMultiInstanceDetails) o;
                return Objects.equals(machineGroup, that.machineGroup);
            }

            @Override
            public int hashCode() {
                return Objects.hash(super.hashCode(), machineGroup);
            }
        }

        public static class NamedInstanceMultiInstanceDetails extends MultiInstanceDetails {

            public static final String PROPERTY_NAMED_INSTANCE_DETAILS = "namedInstanceDetails";
            private List<NamedInstanceDetails> namedInstanceDetails;

            public List<NamedInstanceDetails> getNamedInstanceDetails() {
                return namedInstanceDetails;
            }

            public void setNamedInstanceDetails(List<NamedInstanceDetails> namedInstanceDetails) {
                this.namedInstanceDetails = namedInstanceDetails;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o)
                    return true;
                if (o == null || getClass() != o.getClass())
                    return false;
                if (!super.equals(o))
                    return false;
                NamedInstanceMultiInstanceDetails that = (NamedInstanceMultiInstanceDetails) o;
                return Objects.equals(namedInstanceDetails, that.namedInstanceDetails);
            }

            @Override
            public int hashCode() {
                return Objects.hash(super.hashCode(), namedInstanceDetails);
            }

            public static class NamedInstanceDetails {

                public static final String PROPERTY_NAMED_INSTANCE = "namedInstance";
                public static final String PROPERTY_PROPERTIES = "properties";

                private NamedInstance namedInstance;
                private List<Property> properties;

                public NamedInstance getNamedInstance() {
                    return namedInstance;
                }

                public void setNamedInstance(NamedInstance namedInstance) {
                    this.namedInstance = namedInstance;
                }

                public List<Property> getProperties() {
                    return properties;
                }

                public void setProperties(List<Property> properties) {
                    this.properties = properties;
                }

                @Override
                public boolean equals(Object o) {
                    if (this == o)
                        return true;
                    if (o == null || getClass() != o.getClass())
                        return false;
                    NamedInstanceDetails that = (NamedInstanceDetails) o;
                    return Objects.equals(namedInstance, that.namedInstance) &&
                            Objects.equals(properties, that.properties);
                }

                @Override
                public int hashCode() {
                    return Objects.hash(namedInstance, properties);
                }
            }
        }

        public enum Type {
            NAMED_INSTANCE("namedInstance"),
            PROPERTIES("properties"),
            MACHINE_GROUP("machineGroup");
            private String value;

            Type(String value) {
                this.value = value;
            }

            @JsonValue
            public String getValue() {
                return value;
            }
        }
    }
}
