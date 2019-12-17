package com.smatechnologies.opcon.restapiclient.model;

import com.fasterxml.jackson.annotation.JsonValue;
import com.smatechnologies.opcon.restapiclient.model.machine.Machine;
import com.smatechnologies.opcon.restapiclient.util.MachineActionUtil;

import java.util.Date;
import java.util.List;


/**
 * @author Pierre PINON
 */
public class MachineAction {

    public static final String RESOURCE = "machineAction";

    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_ACTION = "action";
    public static final String PROPERTY_RESULT = "result";
    public static final String PROPERTY_JOBS = "jobs";
    public static final String PROPERTY_EXPIRES = "expires";
    public static final String PROPERTY_MESSAGE = "message";

    private Integer id;
    private Action action;
    private Result result;
    private List<MachineActionMachine> machines;
    private Date expires;
    private String message;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public List<MachineActionMachine> getMachines() {
        return machines;
    }

    public void setMachines(List<MachineActionMachine> machines) {
        this.machines = machines;
    }

    public Date getExpires() {
        return expires;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        MachineAction that = (MachineAction) o;

        if (id != null ? !id.equals(that.id) : that.id != null)
            return false;
        if (action != that.action)
            return false;
        if (result != that.result)
            return false;
        if (machines != null ? !machines.equals(that.machines) : that.machines != null)
            return false;
        if (expires != null ? !expires.equals(that.expires) : that.expires != null)
            return false;
        return message != null ? message.equals(that.message) : that.message == null;
    }

    @Override
    public int hashCode() {
        int result1 = id != null ? id.hashCode() : 0;
        result1 = 31 * result1 + (action != null ? action.hashCode() : 0);
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        result1 = 31 * result1 + (machines != null ? machines.hashCode() : 0);
        result1 = 31 * result1 + (expires != null ? expires.hashCode() : 0);
        result1 = 31 * result1 + (message != null ? message.hashCode() : 0);
        return result1;
    }

    public enum Action {
        ENABLE_FULL("up", MachineActionUtil::isCommunicationFullEnableActionAllowed),
        ENABLE_LIMITED("limited", MachineActionUtil::isCommunicationLimitEnableActionAllowed),
        DISABLE("down", MachineActionUtil::isCommunicationDisableActionAllowed);

        private final String value;
        private final ActionChecker actionChecker;

        Action(String value, ActionChecker actionChecker) {
            this.value = value;
            this.actionChecker = actionChecker;
        }

        @JsonValue
        public String value() {
            return value;
        }

        public boolean isAllowed(Machine machine, User user) {
            return actionChecker.isAllowed(machine, user);
        }

        private interface ActionChecker {

            boolean isAllowed(Machine machine, User user);
        }
    }

    public static class MachineActionMachine {

        public static final String RESOURCE = "machine";

        public static final String PROPERTY_ID = "id";
        public static final String PROPERTY_RESULT = "result";
        public static final String PROPERTY_MESSAGE = "message";
        public static final String PROPERTY_STATUS = "status";

        private Integer id;
        private Result result;
        private String message;
        private MachineStatus status;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Result getResult() {
            return result;
        }

        public void setResult(Result result) {
            this.result = result;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public MachineStatus getStatus() {
            return status;
        }

        public void setStatus(MachineStatus status) {
            this.status = status;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            MachineActionMachine machine = (MachineActionMachine) o;

            if (id != null ? !id.equals(machine.id) : machine.id != null)
                return false;
            if (result != machine.result)
                return false;
            if (message != null ? !message.equals(machine.message) : machine.message != null)
                return false;
            return status != null ? status.equals(machine.status) : machine.status == null;

        }

        @Override
        public int hashCode() {
            int result1 = id != null ? id.hashCode() : 0;
            result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
            result1 = 31 * result1 + (message != null ? message.hashCode() : 0);
            result1 = 31 * result1 + (status != null ? status.hashCode() : 0);
            return result1;
        }
    }
}
