package com.smatechnologies.opcon.restapiclient.api.batchusers;

import com.smatechnologies.opcon.commons.objmapper.annotation.ObjMapperField;
import com.smatechnologies.opcon.restapiclient.criteria.AbstractResourcesCriteria;
import com.smatechnologies.opcon.restapiclient.criteria.SortedColumn;


/**
 * @author Matthieu COELHO
 */
public class BatchUsersCriteria extends AbstractResourcesCriteria<BatchUsersCriteria.BatchUsersColumns> {

    @ObjMapperField
    private Boolean includeCount;

    @ObjMapperField
    private String platform;

    @ObjMapperField
    private Integer platformId;

    public Boolean getIncludeCount() {
        return includeCount;
    }

    public void setIncludeCount(Boolean includeCount) {
        this.includeCount = includeCount;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Integer getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Integer platformId) {
        this.platformId = platformId;
    }

    public enum BatchUsersColumns implements SortedColumn.Column {
        ID("id"),
        LOGIN_NAME("loginname");

        private String name;

        BatchUsersColumns(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }
}
