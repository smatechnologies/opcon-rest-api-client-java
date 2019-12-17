package com.smatechnologies.opcon.restapiclient.model;

import java.util.Objects;


/**
 * @author Pierre PINON
 */
public class ServiceRequestExecutionStatusCount {

    public static final String RESOURCE = "serviceRequestExecutionStatusCount";

    public static final String PROPERTY_SERVICE_REQUEST_ID = "serviceRequestId";
    public static final String PROPERTY_COUNT = "count";

    private Integer serviceRequestId;
    private ExecutionStatusCount count;

    public Integer getServiceRequestId() {
        return serviceRequestId;
    }

    public void setServiceRequestId(Integer serviceRequestId) {
        this.serviceRequestId = serviceRequestId;
    }

    public ExecutionStatusCount getCount() {
        return count;
    }

    public void setCount(ExecutionStatusCount count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ServiceRequestExecutionStatusCount that = (ServiceRequestExecutionStatusCount) o;
        return Objects.equals(serviceRequestId, that.serviceRequestId) &&
                Objects.equals(count, that.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceRequestId, count);
    }

    public class ExecutionStatusCount {

        public static final String RESOURCE = "count";

        public static final String PROPERTY_WAITING = "waiting";
        public static final String PROPERTY_IN_PROCESS_VALID = "inProcessValid";
        public static final String PROPERTY_IN_PROCESS_INVALID = "inProcessInvalid";
        public static final String PROPERTY_COMPLETED_VALID = "completedValid";
        public static final String PROPERTY_COMPLETED_INVALID = "completedInvalid";
        public static final String PROPERTY_ZOMBIFIED = "zombified";
        public static final String PROPERTY_TOTAL = "total";

        private Integer waiting;
        private Integer inProcessValid;
        private Integer inProcessInvalid;
        private Integer completedValid;
        private Integer completedInvalid;
        private Integer zombified;
        private Integer total;

        public Integer getWaiting() {
            return waiting;
        }

        public void setWaiting(Integer waiting) {
            this.waiting = waiting;
        }

        public Integer getInProcessValid() {
            return inProcessValid;
        }

        public void setInProcessValid(Integer inProcessValid) {
            this.inProcessValid = inProcessValid;
        }

        public Integer getInProcessInvalid() {
            return inProcessInvalid;
        }

        public void setInProcessInvalid(Integer inProcessInvalid) {
            this.inProcessInvalid = inProcessInvalid;
        }

        public Integer getCompletedValid() {
            return completedValid;
        }

        public void setCompletedValid(Integer completedValid) {
            this.completedValid = completedValid;
        }

        public Integer getCompletedInvalid() {
            return completedInvalid;
        }

        public void setCompletedInvalid(Integer completedInvalid) {
            this.completedInvalid = completedInvalid;
        }

        public Integer getZombified() {
            return zombified;
        }

        public void setZombified(Integer zombified) {
            this.zombified = zombified;
        }

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            ExecutionStatusCount that = (ExecutionStatusCount) o;
            return Objects.equals(waiting, that.waiting) &&
                    Objects.equals(inProcessValid, that.inProcessValid) &&
                    Objects.equals(inProcessInvalid, that.inProcessInvalid) &&
                    Objects.equals(completedValid, that.completedValid) &&
                    Objects.equals(completedInvalid, that.completedInvalid) &&
                    Objects.equals(zombified, that.zombified) &&
                    Objects.equals(total, that.total);
        }

        @Override
        public int hashCode() {
            return Objects.hash(waiting, inProcessValid, inProcessInvalid, completedValid, completedInvalid, zombified, total);
        }
    }
}
