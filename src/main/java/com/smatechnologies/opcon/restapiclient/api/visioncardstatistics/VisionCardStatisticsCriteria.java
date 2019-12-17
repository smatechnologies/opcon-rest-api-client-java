package com.smatechnologies.opcon.restapiclient.api.visioncardstatistics;

import com.smatechnologies.opcon.commons.objmapper.annotation.ObjMapperField;
import com.smatechnologies.opcon.restapiclient.criteria.AbstractResourcesCriteria;
import com.smatechnologies.opcon.restapiclient.criteria.SortedColumn;

import java.time.LocalDate;
import java.util.Collection;


/**
 * @author Matthieu COELHO
 */
public class VisionCardStatisticsCriteria extends AbstractResourcesCriteria<VisionCardStatisticsCriteria.VisionCardStatisticColumn> {

    @ObjMapperField
    private Collection<Integer> cardIds;

    @ObjMapperField
    private LocalDate from;

    @ObjMapperField
    private LocalDate to;

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

    public enum VisionCardStatisticColumn implements SortedColumn.Column {
        CARD_ID("cardId");

        private String value;

        VisionCardStatisticColumn(String value) {
            this.value = value;
        }

        @Override
        public String getName() {
            return value;
        }
    }
}
