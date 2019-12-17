package com.smatechnologies.opcon.restapiclient.model.servicerequest.variableparameters;

import com.smatechnologies.opcon.restapiclient.model.servicerequest.Variable.VariableType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;
import java.util.Set;


@XmlRootElement(name = "text-collection")
@XmlAccessorType(XmlAccessType.FIELD)
public class TextCollectionVariableParameters implements IVariableParameters {

    private static final long serialVersionUID = 1L;

    public static final String RESOURCE = "text-collection";

    public static final String PROPERTY_TYPE = "type";
    public static final String PROPERTY_VARIABLE_REFERENCES = "variableReferences";

    public static final String PROPERTY_DISALLOW_DUPLICATE = "disallowDuplicate";
    public static final String PROPERTY_DELIMITER = "delimiter";
    public static final String PROPERTY_MIN_CHARS = "minCharacters";
    public static final String PROPERTY_MAX_CHARS = "maxCharacters";
    public static final String PROPERTY_INVALID_CHARS = "invalidCharacters";
    public static final String PROPERTY_REGEXP = "regExpression";
    public static final String PROPERTY_REGEXP_ERROR_MSG = "regExpressionErrorMsg";

    public static final boolean DEFAULT_DISALLOW_DUPLICATE = false;
    public static final String DEFAULT_DELIMITER = ":";
    public static final int DEFAULT_MIN_CHARS = 0;
    public static final int DEFAULT_MAX_CHARS = Integer.MAX_VALUE;
    public static final String DEFAULT_INVALID_CHARS = "";
    public static final String DEFAULT_REGEXP = "";
    public static final String DEFAULT_REGEXP_ERROR_MSG = "";

    private boolean disallowDuplicate = DEFAULT_DISALLOW_DUPLICATE;
    private String delimiter = DEFAULT_DELIMITER;
    private int minCharacters = DEFAULT_MIN_CHARS;
    private int maxCharacters = DEFAULT_MAX_CHARS;
    private String invalidCharacters = DEFAULT_INVALID_CHARS;
    private String regExpression = DEFAULT_REGEXP;
    private String regExpressionErrorMsg = DEFAULT_REGEXP_ERROR_MSG;

    public boolean isDisallowDuplicate() {
        return disallowDuplicate;
    }

    public void setDisallowDuplicate(boolean disallowDuplicate) {
        this.disallowDuplicate = disallowDuplicate;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public int getMinCharacters() {
        return minCharacters;
    }

    public void setMinCharacters(int minCharacters) {
        this.minCharacters = minCharacters;
    }

    public int getMaxCharacters() {
        return maxCharacters;
    }

    public void setMaxCharacters(int maxCharacters) {
        this.maxCharacters = maxCharacters;
    }

    public String getInvalidCharacters() {
        return invalidCharacters;
    }

    public void setInvalidCharacters(String invalidCharacters) {
        this.invalidCharacters = Objects.requireNonNull(invalidCharacters);
    }

    public String getRegExpression() {
        return regExpression;
    }

    public void setRegExpression(String regExpression) {
        this.regExpression = regExpression;
    }

    public String getRegExpressionErrorMsg() {
        return regExpressionErrorMsg;
    }

    public void setRegExpressionErrorMsg(String regExpressionErrorMsg) {
        this.regExpressionErrorMsg = regExpressionErrorMsg;
    }

    @Override
    public VariableType getType() {
        return VariableType.TEXT_COLLECTION;
    }

    @Override
    public Set<String> getVariableReferences() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        TextCollectionVariableParameters that = (TextCollectionVariableParameters) o;

        if (disallowDuplicate != that.disallowDuplicate)
            return false;
        if (minCharacters != that.minCharacters)
            return false;
        if (maxCharacters != that.maxCharacters)
            return false;
        if (delimiter != null ? !delimiter.equals(that.delimiter) : that.delimiter != null)
            return false;
        if (invalidCharacters != null ? !invalidCharacters.equals(that.invalidCharacters) : that.invalidCharacters != null)
            return false;
        if (regExpression != null ? !regExpression.equals(that.regExpression) : that.regExpression != null)
            return false;
        return regExpressionErrorMsg != null ? regExpressionErrorMsg.equals(that.regExpressionErrorMsg) : that.regExpressionErrorMsg == null;

    }

    @Override
    public int hashCode() {
        int result = (disallowDuplicate ? 1 : 0);
        result = 31 * result + (delimiter != null ? delimiter.hashCode() : 0);
        result = 31 * result + minCharacters;
        result = 31 * result + maxCharacters;
        result = 31 * result + (invalidCharacters != null ? invalidCharacters.hashCode() : 0);
        result = 31 * result + (regExpression != null ? regExpression.hashCode() : 0);
        result = 31 * result + (regExpressionErrorMsg != null ? regExpressionErrorMsg.hashCode() : 0);
        return result;
    }
}
