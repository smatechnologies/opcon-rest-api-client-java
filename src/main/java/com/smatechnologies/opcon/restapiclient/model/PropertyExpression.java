package com.smatechnologies.opcon.restapiclient.model;

public class PropertyExpression {

    public static final String RESOURCE = "PropertyExpression";

    public static final String PROPERTY_EXPRESSION = "expression";
    public static final String PROPERTY_STATUS = "status";
    public static final String PROPERTY_RESULT = "result";
    public static final String PROPERTY_MESSAGE = "message";

    private String expression;
    private String status;
    private String result;
    private String message;
	
    public String getExpression() {
		return expression;
	}
	
    public void setExpression(String expression) {
		this.expression = expression;
	}
	
    public String getStatus() {
		return status;
	}
	
    public void setStatus(String status) {
		this.status = status;
	}
	
    public String getResult() {
		return result;
	}
	
    public void setResult(String result) {
		this.result = result;
	}
	
    public String getMessage() {
		return message;
	}
	
    public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expression == null) ? 0 : expression.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PropertyExpression other = (PropertyExpression) obj;
		if (expression == null) {
			if (other.expression != null)
				return false;
		} else if (!expression.equals(other.expression))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (result == null) {
			if (other.result != null)
				return false;
		} else if (!result.equals(other.result))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

   
}
