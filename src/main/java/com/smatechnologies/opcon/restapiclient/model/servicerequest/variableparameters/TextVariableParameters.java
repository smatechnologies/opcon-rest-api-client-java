package com.smatechnologies.opcon.restapiclient.model.servicerequest.variableparameters;

import com.smatechnologies.opcon.restapiclient.model.servicerequest.Variable.VariableType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;
import java.util.Set;


@XmlRootElement(name = "text")
@XmlAccessorType(XmlAccessType.FIELD)
public class TextVariableParameters implements IVariableParameters {

    private static final long serialVersionUID = 1L;

    public static final String RESOURCE = "text";

    public static final String PROPERTY_TYPE = "type";
    public static final String PROPERTY_VARIABLE_REFERENCES = "variableReferences";

    public static final String PROPERTY_MIN_CHARS = "minCharacters";
    public static final String PROPERTY_MAX_CHARS = "maxCharacters";
    public static final String PROPERTY_INVALID_CHARS = "invalidCharacters";
    public static final String PROPERTY_STRIP_CHARS = "stripCharacters";
    public static final String PROPERTY_PADDING_DIRECTION = "paddingDirection";
    public static final String PROPERTY_PADDING_CHAR = "paddingCharacter";
    public static final String PROPERTY_PADDING_LENGTH = "paddingLength";
    public static final String PROPERTY_PASSWORD = "password";
    public static final String PROPERTY_REGEXP = "regExpression";
    public static final String PROPERTY_REGEXP_ERROR_MSG = "regExpressionErrorMsg";

    public static final int DEFAULT_MIN_CHARS = 0;
    public static final int DEFAULT_MAX_CHARS = Integer.MAX_VALUE;
    public static final String DEFAULT_INVALID_CHARS = "";
    public static final String DEFAULT_STRIP_CHARS = "";
    public static final PaddingDirection DEFAULT_PADDING_DIRECTION = null;
    public static final String DEFAULT_PADDING_CHAR = null;
    public static final Integer DEFAULT_PADDING_LENGTH = null;
    public static final boolean DEFAULT_PASSWORD = false;
    public static final String DEFAULT_REGEXP = "";
    public static final String DEFAULT_REGEXP_ERROR_MSG = "";

    private int minCharacters = DEFAULT_MIN_CHARS;
    private int maxCharacters = DEFAULT_MAX_CHARS;
    private String invalidCharacters = DEFAULT_INVALID_CHARS;
    private String stripCharacters = DEFAULT_STRIP_CHARS;
    private PaddingDirection paddingDirection = DEFAULT_PADDING_DIRECTION;
    private String paddingCharacter = DEFAULT_PADDING_CHAR;
    private Integer paddingLength = DEFAULT_PADDING_LENGTH;
    private boolean password = DEFAULT_PASSWORD;
    private String regExpression = DEFAULT_REGEXP;
    private String regExpressionErrorMsg = DEFAULT_REGEXP_ERROR_MSG;

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

    public String getStripCharacters() {
        return stripCharacters;
    }

    public void setStripCharacters(String stripCharacters) {
        this.stripCharacters = stripCharacters;
    }

    public PaddingDirection getPaddingDirection() {
        return paddingDirection;
    }

    public void setPaddingDirection(PaddingDirection paddingDirection) {
        this.paddingDirection = paddingDirection;
    }

    public String getPaddingCharacter() {
        return paddingCharacter;
    }

    public void setPaddingCharacter(String paddingCharacter) {
        this.paddingCharacter = paddingCharacter;
    }

    public Integer getPaddingLength() {
        return paddingLength;
    }

    public void setPaddingLength(Integer paddingLength) {
        this.paddingLength = paddingLength;
    }

    public boolean isPassword() {
        return password;
    }

    public void setPassword(boolean password) {
        this.password = password;
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
        return VariableType.TEXT;
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

        TextVariableParameters that = (TextVariableParameters) o;

        if (minCharacters != that.minCharacters)
            return false;
        if (maxCharacters != that.maxCharacters)
            return false;
        if (password != that.password)
            return false;
        if (invalidCharacters != null ? !invalidCharacters.equals(that.invalidCharacters) : that.invalidCharacters != null)
            return false;
        if (stripCharacters != null ? !stripCharacters.equals(that.stripCharacters) : that.stripCharacters != null)
            return false;
        if (paddingDirection != that.paddingDirection)
            return false;
        if (paddingCharacter != null ? !paddingCharacter.equals(that.paddingCharacter) : that.paddingCharacter != null)
            return false;
        if (paddingLength != null ? !paddingLength.equals(that.paddingLength) : that.paddingLength != null)
            return false;
        if (regExpression != null ? !regExpression.equals(that.regExpression) : that.regExpression != null)
            return false;
        return regExpressionErrorMsg != null ? regExpressionErrorMsg.equals(that.regExpressionErrorMsg) : that.regExpressionErrorMsg == null;

    }

    @Override
    public int hashCode() {
        int result = minCharacters;
        result = 31 * result + maxCharacters;
        result = 31 * result + (invalidCharacters != null ? invalidCharacters.hashCode() : 0);
        result = 31 * result + (stripCharacters != null ? stripCharacters.hashCode() : 0);
        result = 31 * result + (paddingDirection != null ? paddingDirection.hashCode() : 0);
        result = 31 * result + (paddingCharacter != null ? paddingCharacter.hashCode() : 0);
        result = 31 * result + (paddingLength != null ? paddingLength.hashCode() : 0);
        result = 31 * result + (password ? 1 : 0);
        result = 31 * result + (regExpression != null ? regExpression.hashCode() : 0);
        result = 31 * result + (regExpressionErrorMsg != null ? regExpressionErrorMsg.hashCode() : 0);
        return result;
    }

    public enum PaddingDirection {
        LEFT,
        RIGHT
    }
}
