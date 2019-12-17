package com.smatechnologies.opcon.restapiclient.model.servicerequest.variableparameters;

import com.smatechnologies.opcon.commons.adapter.LocalDateXmlAdapter;
import com.smatechnologies.opcon.restapiclient.model.servicerequest.Variable.VariableType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.Set;


@XmlRootElement(name = "date")
@XmlAccessorType(XmlAccessType.FIELD)
public class DateVariableParameters implements IVariableParameters {

    private static final long serialVersionUID = 1L;

    public static final String RESOURCE = "date";

    public static final String PROPERTY_TYPE = "type";
    public static final String PROPERTY_VARIABLE_REFERENCES = "variableReferences";

    public static final String PROPERTY_BEFORE_TODAY = "beforeToday";
    public static final String PROPERTY_AFTER_TODAY = "afterToday";
    public static final String PROPERTY_AFTER_DATE = "afterDate";
    public static final String PROPERTY_BEFORE_DATE = "beforeDate";
    public static final String PROPERTY_FORMAT = "format";

    public static final LocalDate DEFAULT_AFTER_DATE = null;
    public static final LocalDate DEFAULT_BEFORE_DATE = null;
    public static final String DEFAULT_FORMAT = "yyyy/MM/dd";

    private boolean beforeToday = false;
    private boolean afterToday = false;
    @XmlJavaTypeAdapter(value = LocalDateXmlAdapter.class)
    private LocalDate beforeDate = DEFAULT_AFTER_DATE;
    @XmlJavaTypeAdapter(value = LocalDateXmlAdapter.class)
    private LocalDate afterDate = DEFAULT_BEFORE_DATE;
    private String format = DEFAULT_FORMAT;

    public boolean isBeforeToday() {
        return beforeToday;
    }

    public void setBeforeToday(boolean beforeToday) {
        this.beforeToday = beforeToday;
    }

    public boolean isAfterToday() {
        return afterToday;
    }

    public void setAfterToday(boolean afterToday) {
        this.afterToday = afterToday;
    }

    public LocalDate getBeforeDate() {
        return beforeDate;
    }

    public void setBeforeDate(LocalDate beforeDate) {
        this.beforeDate = beforeDate;
    }

    public LocalDate getAfterDate() {
        return afterDate;
    }

    public void setAfterDate(LocalDate afterDate) {
        this.afterDate = afterDate;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public VariableType getType() {
        return VariableType.DATE;
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

        DateVariableParameters that = (DateVariableParameters) o;

        if (beforeToday != that.beforeToday)
            return false;
        if (afterToday != that.afterToday)
            return false;
        if (beforeDate != null ? !beforeDate.equals(that.beforeDate) : that.beforeDate != null)
            return false;
        if (afterDate != null ? !afterDate.equals(that.afterDate) : that.afterDate != null)
            return false;
        return format != null ? format.equals(that.format) : that.format == null;

    }

    @Override
    public int hashCode() {
        int result = (beforeToday ? 1 : 0);
        result = 31 * result + (afterToday ? 1 : 0);
        result = 31 * result + (beforeDate != null ? beforeDate.hashCode() : 0);
        result = 31 * result + (afterDate != null ? afterDate.hashCode() : 0);
        result = 31 * result + (format != null ? format.hashCode() : 0);
        return result;
    }
}
