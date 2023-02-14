package com.smatechnologies.opcon.restapiclient.model;

public class GlobalProperty {

    public static final String RESOURCE = "globalproperties";

    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_VALUE = "value";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_DOCUMENTATION = "documentation";
    public static final String PROPERTY_ENCRYPTED = "encrypted";
    public static final String PROPERTY_FULLNAME = "fullName";
    public static final String PROPERTY_CATEGORY = "category";
    public static final String PROPERTY_ISPATTERNVALUE = "isPatternValue";
    public static final String PROPERTY_TYPE = "type";

    private Integer id;
    private String name;
    private String value;
    private String description;
    private String documentation;
    private Boolean encrypted;
    private String fullName;
    private String category;
    private Boolean isPatternValue;
    private String type;

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    public Boolean getEncrypted() {
        return encrypted;
    }

    public void setEncrypted(Boolean encrypted) {
        this.encrypted = encrypted;
    }
    
    public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Boolean getIsPatternValue() {
		return isPatternValue;
	}

	public void setIsPatternValue(Boolean isPatternValue) {
		this.isPatternValue = isPatternValue;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof GlobalProperty))
            return false;

        GlobalProperty that = (GlobalProperty) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null)
            return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null)
            return false;
        if (getValue() != null ? !getValue().equals(that.getValue()) : that.getValue() != null)
            return false;
        if (getEncrypted() != null ? !getEncrypted().equals(that.getEncrypted()) : that.getEncrypted() != null)
            return false;
        if (getFullName() != null ? !getFullName().equals(that.getFullName()) : that.getFullName() != null)
            return false;
        if (getCategory() != null ? !getCategory().equals(that.getCategory()) : that.getCategory() != null)
            return false;
        if (getIsPatternValue() != null ? !getIsPatternValue().equals(that.getIsPatternValue()) : that.getIsPatternValue() != null)
            return false;
        if (getType() != null ? !getType().equals(that.getType()) : that.getType() != null)
            return false;
        return getDocumentation() != null ? getDocumentation().equals(that.getDocumentation()) : that.getDocumentation() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getValue() != null ? getValue().hashCode() : 0);
        result = 31 * result + (getEncrypted() != null ? getEncrypted().hashCode() : 0);
        result = 31 * result + (getDocumentation() != null ? getDocumentation().hashCode() : 0);
        result = 31 * result + (getFullName() != null ? getFullName().hashCode() : 0);
        result = 31 * result + (getCategory() != null ? getCategory().hashCode() : 0);
        result = 31 * result + (getIsPatternValue() != null ? getIsPatternValue().hashCode() : 0);
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        return result;
    }
}

