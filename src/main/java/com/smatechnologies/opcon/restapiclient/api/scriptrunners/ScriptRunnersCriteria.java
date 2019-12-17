package com.smatechnologies.opcon.restapiclient.api.scriptrunners;

import com.smatechnologies.opcon.commons.objmapper.annotation.ObjMapperField;
import com.smatechnologies.opcon.restapiclient.criteria.AbstractResourcesCriteria;
import com.smatechnologies.opcon.restapiclient.criteria.SortedColumn;

import java.util.Collection;


/**
 * @author Pierre PINON
 */
public class ScriptRunnersCriteria extends AbstractResourcesCriteria<ScriptRunnersCriteria.ScriptRunnerColumns> {

    @ObjMapperField
    private Collection<String> ids;

    @ObjMapperField
    private String name;

    @ObjMapperField
    private Integer scriptTypeId;

    public Collection<String> getIds() {
        return ids;
    }

    public void setIds(Collection<String> ids) {
        this.ids = ids;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScriptTypeId() {
        return scriptTypeId;
    }

    public void setScriptTypeId(Integer scriptTypeId) {
        this.scriptTypeId = scriptTypeId;
    }

    /**
     * Allowed columns on ScriptRunners to specify sort order.
     *
     * @author Pierre PINON.
     */
    public enum ScriptRunnerColumns implements SortedColumn.Column {
        ;

        private String name;

        ScriptRunnerColumns(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return this.name;
        }
    }
}
