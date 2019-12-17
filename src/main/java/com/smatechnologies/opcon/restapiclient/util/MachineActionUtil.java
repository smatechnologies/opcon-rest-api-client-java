package com.smatechnologies.opcon.restapiclient.util;

import com.smatechnologies.opcon.restapiclient.model.FunctionPrivilege;
import com.smatechnologies.opcon.restapiclient.model.MachineStatus;
import com.smatechnologies.opcon.restapiclient.model.User;
import com.smatechnologies.opcon.restapiclient.model.machine.Machine;


/**
 * @author Pierre PINON
 */
public class MachineActionUtil {

    private MachineActionUtil() {
    }

    public static boolean isCommunicationFullEnableActionAllowed(Machine machine, User user) {
        MachineStatus machineStatus = machine.getStatus();

        if (!user.hasPrivilege(FunctionPrivilege.MAINTAIN_MACHINES)) {
            return false;
        }

        return machineStatus.getOperationStatus() != MachineStatus.Oper.UP;
    }

    public static boolean isCommunicationLimitEnableActionAllowed(Machine machine, User user) {
        MachineStatus machineStatus = machine.getStatus();

        if (!user.hasPrivilege(FunctionPrivilege.MAINTAIN_MACHINES)) {
            return false;
        }

        return machineStatus.getOperationStatus() != MachineStatus.Oper.LIMITED;
    }

    public static boolean isCommunicationDisableActionAllowed(Machine machine, User user) {
        MachineStatus machineStatus = machine.getStatus();

        if (!user.hasPrivilege(FunctionPrivilege.MAINTAIN_MACHINES)) {
            return false;
        }

        return machineStatus.getOperationStatus() != MachineStatus.Oper.DOWN;
    }
}
