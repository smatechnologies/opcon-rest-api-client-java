package com.smatechnologies.opcon.restapiclient.model.dailyjob.details.commons;

import com.smatechnologies.opcon.restapiclient.model.TokenisableInteger;

import java.util.Objects;


/**
 * @author Pierre PINON
 */
public class FileArrivalSettings {

    public static final String RESOURCE = "fileArrivalSettings";

    public static final String PROPERTY_FILE_TO_WATCH = "fileToWatch";
    public static final String PROPERTY_END_OFFSET = "endOffset";
    public static final String PROPERTY_START_OFFSET = "startOffset";
    public static final String PROPERTY_DURATION = "duration";
    public static final String PROPERTY_SUBDIRECTORY_SEARCH = "subdirectorySearch";

    public static final int MAX_FILE_TO_WATCH_CHARACTERS = 4000;
    public static final int MAX_DURATION = 999;
    public static final int MIN_DURATION = 1;
    public static final int V2_MIN_START_OFFSET = -142560;//-99 days at 00:00 in minutes;
    public static final int V2_MAX_START_OFFSET = 143999;//99 days at 23:59 in minutes

    public static final int V1_MIN_START_OFFSET = -999;//hours
    public static final int V1_MAX_START_OFFSET = 999;//hours

    private String fileToWatch;
    private TokenisableInteger endOffset;
    private TokenisableInteger startOffset;
    private TokenisableInteger duration;
    private Boolean subdirectorySearch;

    public String getFileToWatch() {
        return fileToWatch;
    }

    public void setFileToWatch(String fileToWatch) {
        this.fileToWatch = fileToWatch;
    }

    public TokenisableInteger getEndOffset() {
        return endOffset;
    }

    public void setEndOffset(TokenisableInteger endOffset) {
        this.endOffset = endOffset;
    }

    public TokenisableInteger getStartOffset() {
        return startOffset;
    }

    public void setStartOffset(TokenisableInteger startOffset) {
        this.startOffset = startOffset;
    }

    public TokenisableInteger getDuration() {
        return duration;
    }

    public void setDuration(TokenisableInteger duration) {
        this.duration = duration;
    }

    public Boolean getSubdirectorySearch() {
        return subdirectorySearch;
    }

    public void setSubdirectorySearch(Boolean subdirectorySearch) {
        this.subdirectorySearch = subdirectorySearch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        FileArrivalSettings that = (FileArrivalSettings) o;
        return Objects.equals(fileToWatch, that.fileToWatch) &&
                Objects.equals(endOffset, that.endOffset) &&
                Objects.equals(startOffset, that.startOffset) &&
                Objects.equals(duration, that.duration) &&
                Objects.equals(subdirectorySearch, that.subdirectorySearch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileToWatch, endOffset, startOffset, duration, subdirectorySearch);
    }
}
