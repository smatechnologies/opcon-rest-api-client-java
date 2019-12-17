package com.smatechnologies.opcon.restapiclient.model;

import com.fasterxml.jackson.annotation.JsonValue;
import com.smatechnologies.opcon.commons.objmapper.annotation.ObjMapperValue;

import java.util.Arrays;
import java.util.Objects;


/**
 * @author Pierre PINON
 */
public class MachineStatus {

    public static final String RESOURCE = "machineStatus";

    public static final String PROPERTY_STATE = "state";
    public static final String PROPERTY_NETWORK_STATUS = "networkStatus";
    public static final String PROPERTY_OPERATION_STATUS = "operationStatus";

    private State state;
    private String networkStatus;
    private Oper operationStatus;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getNetworkStatus() {
        return networkStatus;
    }

    public void setNetworkStatus(String networkStatus) {
        this.networkStatus = networkStatus;
    }

    public Oper getOperationStatus() {
        return operationStatus;
    }

    public void setOperationStatus(Oper operationStatus) {
        this.operationStatus = operationStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        MachineStatus that = (MachineStatus) o;

        if (state != that.state)
            return false;
        if (networkStatus != null ? !networkStatus.equals(that.networkStatus) : that.networkStatus != null)
            return false;
        return operationStatus == that.operationStatus;
    }

    @Override
    public int hashCode() {
        int result = state != null ? state.hashCode() : 0;
        result = 31 * result + (networkStatus != null ? networkStatus.hashCode() : 0);
        result = 31 * result + (operationStatus != null ? operationStatus.hashCode() : 0);
        return result;
    }

    /**
     * This enum holds the possible states a machine take.
     */
    public enum State {

        /**
         * NetCom is waiting on machine to respond (trying to connect, next state will either be UP/LIMITED or ERROR).
         */
        WAITING("W"),

        /**
         * NetCom sees the machine as up and running.
         */
        UP("U"),

        /**
         * NetCom does not look at the machine, communication is stopped.
         */
        DOWN("D"),

        /**
         * NetCom cannot connect to the machine ( communication error ).
         */
        ERROR("E"),

        /**
         * NetCom has set the machine communication as being limited, which means
         * the machine is communicating and reporting job state executions but no task can be sent.
         */
        LIMITED("L");

        private final String value;

        State(String value) {
            this.value = Objects.requireNonNull(value, "Value cannot be null");
        }

        /**
         * Parse the given value and try to find a matching enum entry. Returns Null if no matching entry.
         *
         * @param value
         * @return
         */
        public static State fromValue(final String value) {
            return Arrays.stream(values())
                    .filter(state -> state.value().equalsIgnoreCase(value))
                    .findFirst()
                    .orElse(null);
        }

        @ObjMapperValue
        @JsonValue
        public String value() {
            return value;
        }
    }

    public enum Oper {

        LIMITED("L"),
        UP("U"),
        DOWN("D");

        private final String value;

        Oper(String value) {
            this.value = Objects.requireNonNull(value, "Value cannot be null");
        }

        @JsonValue
        public String value() {
            return value;
        }
    }
}
