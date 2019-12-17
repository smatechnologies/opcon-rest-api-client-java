package com.smatechnologies.opcon.restapiclient.api.servicerequestcategories;

import com.smatechnologies.opcon.commons.objmapper.annotation.ObjMapperField;
import com.smatechnologies.opcon.restapiclient.criteria.AbstractResourcesCriteria;
import com.smatechnologies.opcon.restapiclient.criteria.SortedColumn;


/**
 * @author Pierre PINON
 */
public class ServiceRequestCategoriesCriteria extends AbstractResourcesCriteria<ServiceRequestCategoriesCriteria.ServiceRequestCategoryColumns> {

    @ObjMapperField
    private String name;
    @ObjMapperField
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Allowed columns on ServiceRequestCategories to specify sort order.
     *
     * @author Pierre PINON.
     */
    public enum ServiceRequestCategoryColumns implements SortedColumn.Column {

        ID("id"),
        NAME("name"),
        COLOR("color");

        private String name;

        ServiceRequestCategoryColumns(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return this.name;
        }
    }
}
