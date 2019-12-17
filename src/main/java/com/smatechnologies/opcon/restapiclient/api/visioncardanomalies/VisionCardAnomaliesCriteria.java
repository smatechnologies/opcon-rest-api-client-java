package com.smatechnologies.opcon.restapiclient.api.visioncardanomalies;

import com.smatechnologies.opcon.commons.objmapper.annotation.ObjMapperField;
import com.smatechnologies.opcon.restapiclient.criteria.AbstractResourcesCriteria;
import com.smatechnologies.opcon.restapiclient.criteria.SortedColumn;

import java.time.LocalDate;
import java.util.Collection;


/**
 * @author Matthieu COELHO
 */
public class VisionCardAnomaliesCriteria extends AbstractResourcesCriteria<VisionCardAnomaliesCriteria.VisionCardAnomalyColumn> {

    @ObjMapperField
    private Collection<Integer> cardIds;

    @ObjMapperField
    private LocalDate from;

    @ObjMapperField
    private LocalDate to;

    @ObjMapperField
    private Boolean excludeQos;

    @ObjMapperField
    private Boolean excludeSla;

    public Collection<Integer> getCardIds() {
        return cardIds;
    }

    public void setCardIds(Collection<Integer> cardIds) {
        this.cardIds = cardIds;
    }

    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public LocalDate getTo() {
        return to;
    }

    public void setTo(LocalDate to) {
        this.to = to;
    }

    public Boolean getExcludeQos() {
        return excludeQos;
    }

    public void setExcludeQos(Boolean excludeQos) {
        this.excludeQos = excludeQos;
    }

    public Boolean getExcludeSla() {
        return excludeSla;
    }

    public void setExcludeSla(Boolean excludeSla) {
        this.excludeSla = excludeSla;
    }

    public enum VisionCardAnomalyColumn implements SortedColumn.Column {
        CARD_PATH("cardPath");

        private String value;

        VisionCardAnomalyColumn(String value) {
            this.value = value;
        }

        @Override
        public String getName() {
            return value;
        }
    }

}
