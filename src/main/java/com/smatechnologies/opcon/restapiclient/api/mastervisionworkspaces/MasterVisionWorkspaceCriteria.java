package com.smatechnologies.opcon.restapiclient.api.mastervisionworkspaces;

import com.smatechnologies.opcon.commons.objmapper.annotation.ObjMapperField;
import com.smatechnologies.opcon.restapiclient.criteria.AbstractResourcesCriteria;
import com.smatechnologies.opcon.restapiclient.criteria.SortedColumn;

import java.util.Collection;


/**
 * @author Pierre PINON.
 */
public class MasterVisionWorkspaceCriteria extends AbstractResourcesCriteria<MasterVisionWorkspaceCriteria.MasterVisionWorkspaceColumns> {

    @ObjMapperField
    private Collection<Integer> ids;

    public Collection<Integer> getIds() {
        return ids;
    }

    public void setIds(Collection<Integer> ids) {
        this.ids = ids;
    }

    public enum MasterVisionWorkspaceColumns implements SortedColumn.Column {
        ID("id");

        private String id;

        MasterVisionWorkspaceColumns(String id) {
            this.id = id;
        }

        @Override
        public String getName() {
            return id;
        }
    }
}
