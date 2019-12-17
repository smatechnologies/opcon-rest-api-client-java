package com.smatechnologies.opcon.restapiclient.model.dailyjob.details.commons;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;


/**
 * @author Pierre PINON
 */
public class JobOutputParsing {

    public static final String RESOURCE = "jobOutputParsing";

    public static final String PROPERTY_SEARCH_OPERATOR = "searchOperator";
    public static final String PROPERTY_STRING_TO_FIND = "stringToFind";
    public static final String PROPERTY_EXIT_CODE_TO_SET = "exitCodeToSet";

    public static int MAX_STRING_TO_FIND_CHARACTERS = 255;

    private SearchOperator searchOperator;
    private String stringToFind;
    private Integer exitCodeToSet;

    public SearchOperator getSearchOperator() {
        return searchOperator;
    }

    public void setSearchOperator(SearchOperator searchOperator) {
        this.searchOperator = searchOperator;
    }

    public String getStringToFind() {
        return stringToFind;
    }

    public void setStringToFind(String stringToFind) {
        this.stringToFind = stringToFind;
    }

    public Integer getExitCodeToSet() {
        return exitCodeToSet;
    }

    public void setExitCodeToSet(Integer exitCodeToSet) {
        this.exitCodeToSet = exitCodeToSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        JobOutputParsing that = (JobOutputParsing) o;
        return Objects.equals(searchOperator, that.searchOperator) &&
                Objects.equals(stringToFind, that.stringToFind) &&
                Objects.equals(exitCodeToSet, that.exitCodeToSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(searchOperator, stringToFind, exitCodeToSet);
    }

    public enum SearchOperator {
        CONTAINS("Contains"),
        DOES_NOT_CONTAIN("Does Not Contain");

        private final String value;

        SearchOperator(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
}
