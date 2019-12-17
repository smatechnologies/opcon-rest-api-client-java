package com.smatechnologies.opcon.restapiclient.api.visionjobanomalies;

import com.smatechnologies.opcon.commons.objmapper.annotation.ObjMapperField;
import com.smatechnologies.opcon.restapiclient.api.visioncardanomalies.VisionCardAnomaliesCriteria;
import com.smatechnologies.opcon.restapiclient.criteria.AbstractResourcesCriteria;
import com.smatechnologies.opcon.restapiclient.criteria.SortedColumn;

import java.util.Collection;


/**
 * @author Matthieu COELHO
 */
public class VisionJobAnomaliesCriteria extends AbstractResourcesCriteria<VisionCardAnomaliesCriteria.VisionCardAnomalyColumn> {

    @ObjMapperField
    private Collection<Long> visionCardAnomalyIds;

    public Collection<Long> getVisionCardAnomalyIds() {
        return visionCardAnomalyIds;
    }

    public void setVisionCardAnomalyIds(Collection<Long> visionCardAnomalyIds) {
        this.visionCardAnomalyIds = visionCardAnomalyIds;
    }

    public enum VisionJobAnomalyColumn implements SortedColumn.Column {
        JOB_NAME("jobName");

        private String value;

        VisionJobAnomalyColumn(String value) {
            this.value = value;
        }

        @Override
        public String getName() {
            return value;
        }
    }

}
