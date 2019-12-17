package com.smatechnologies.opcon.restapiclient.api.scripts;

import com.smatechnologies.opcon.commons.objmapper.annotation.ObjMapperField;
import com.smatechnologies.opcon.restapiclient.criteria.AbstractResourcesCriteria;
import com.smatechnologies.opcon.restapiclient.criteria.SortedColumn;


/**
 * @author Pierre PINON
 */
public class ScriptsCriteria extends AbstractResourcesCriteria<ScriptsCriteria.ScriptColumns> {

    @ObjMapperField
    private Boolean includeVersions;
    @ObjMapperField
    private Integer runnerOSId;

    public Boolean getIncludeVersions() {
        return includeVersions;
    }

    public void setIncludeVersions(Boolean includeVersions) {
        this.includeVersions = includeVersions;
    }

    public Integer getRunnerOSId() {
        return runnerOSId;
    }

    public void setRunnerOSId(Integer runnerOSId) {
        this.runnerOSId = runnerOSId;
    }

    /**
     * Allowed columns on Scripts to specify sort order.
     *
     * @author Pierre PINON.
     */
    public enum ScriptColumns implements SortedColumn.Column {
        ;

        private String name;

        ScriptColumns(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return this.name;
        }
    }
}
