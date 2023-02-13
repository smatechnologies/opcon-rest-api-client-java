package com.smatechnologies.opcon.restapiclient.model;

import java.util.Objects;

public class Dependency {

    public static final String RESOURCE = "dependency";

    public static final String PROPERTY_IS_SATISIFIED = "isSatisfied";
    public static final String PROPERTY_ID = "id"; 
    public static final String PROPERTY_TYPE = "type"; 
    public static final String PROPERTY_PREDECESSOR = "predecessor"; 

    private Boolean isSatisfied;
    private Integer id;
    private DependencyType type;
    private DependencyPredecessor predecessor;    
    
    public Boolean getIsSatisfied() {
		return isSatisfied;
	}

	public void setIsSatisfied(Boolean isSatisfied) {
		this.isSatisfied = isSatisfied;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public DependencyType getType() {
		return type;
	}

	public void setType(DependencyType type) {
		this.type = type;
	}

	public DependencyPredecessor getPredecessor() {
		return predecessor;
	}

	public void setPredecessor(DependencyPredecessor predecessor) {
		this.predecessor = predecessor;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Dependency that = (Dependency) o;
        return Objects.equals(isSatisfied, that.isSatisfied) &&
        		Objects.equals(id, that.id) &&
        		Objects.equals(type, that.type) &&
        		Objects.equals(predecessor, that.predecessor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isSatisfied, id, type, predecessor);
    }

	public static class DependencyType {

        public static final String PROPERTY_ID = "id"; 
        public static final String PROPERTY_NAME = "name";
        public static final String PROPERTY_CONDITION = "condition";
        public static final String PROPERTY_OFFSET = "offset";

        private Integer id;
        private String name;
        private String condition;
        private Integer offset;

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

		public String getCondition() {
			return condition;
		}

		public void setCondition(String condition) {
			this.condition = condition;
		}

		public Integer getOffset() {
			return offset;
		}

		public void setOffset(Integer offset) {
			this.offset = offset;
		}

		@Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            DependencyType that = (DependencyType) o;
            return Objects.equals(id, that.id) &&
            		Objects.equals(name, that.name) &&
            		Objects.equals(condition, that.condition) &&
            		Objects.equals(offset, that.offset);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, condition, offset);
        }
    }

    public static class DependencyPredecessor {

        public static final String PROPERTY_SCHEDULE = "schedule"; 
        public static final String PROPERTY_ID = "id"; 
        public static final String PROPERTY_NAME = "name";
        public static final String PROPERTY_CONDITION = "status";

        private DependencyPredecessorSchedule schedule;
        private String id;
        private String name;
        private String status;

        public DependencyPredecessorSchedule getSchedule() {
			return schedule;
		}

		public void setSchedule(DependencyPredecessorSchedule schedule) {
			this.schedule = schedule;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		@Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            DependencyPredecessor that = (DependencyPredecessor) o;
            return Objects.equals(schedule, that.schedule) &&
               		Objects.equals(id, that.id) &&
               		Objects.equals(name, that.name) &&
            		Objects.equals(status, that.status);
        }

        @Override
        public int hashCode() {
            return Objects.hash(schedule, id, name, status);
        }
    }

    public static class DependencyPredecessorSchedule {

        public static final String PROPERTY_ID = "id"; 
        public static final String PROPERTY_DATE = "date";
        public static final String PROPERTY_NAME = "name";

        private String id;
        private String date;
        private String name;

        public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            DependencyPredecessorSchedule that = (DependencyPredecessorSchedule) o;
            return Objects.equals(id, that.id) &&
            		Objects.equals(date, that.date) &&
            		Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, date, name);
        }
    }

}
