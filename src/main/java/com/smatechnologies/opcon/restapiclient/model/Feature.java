package com.smatechnologies.opcon.restapiclient.model;

import java.util.List;


/**
 * Resource used to show available features based on the current OpCon license.
 */
public class Feature {

    public static final String RESOURCE = "feature";

    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_LICENSES = "licenses";
    public static final String PROPERTY_VALID = "valid";
    public static final String PROPERTY_USER_IDS = "userIds";

    private Integer id;
    private Integer licenses;
    private Boolean valid;
    private List<Integer> userIds;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLicenses() {
        return licenses;
    }

    public void setLicenses(Integer licenses) {
        this.licenses = licenses;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public List<Integer> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Integer> userIds) {
        this.userIds = userIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Feature feature = (Feature) o;

        if (id != null ? !id.equals(feature.id) : feature.id != null)
            return false;
        if (licenses != null ? !licenses.equals(feature.licenses) : feature.licenses != null)
            return false;
        if (valid != null ? !valid.equals(feature.valid) : feature.valid != null)
            return false;
        return userIds != null ? userIds.equals(feature.userIds) : feature.userIds == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (licenses != null ? licenses.hashCode() : 0);
        result = 31 * result + (valid != null ? valid.hashCode() : 0);
        result = 31 * result + (userIds != null ? userIds.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Feature{" + "id=" + id + ", licenses=" + licenses + '}';
    }

    public enum SupportedFeature {

        DASHBOARD(1),
        SELF_SERVICE(2),
        API(3),
        VISION(4);

        private int featureId;

        SupportedFeature(final int featureId) {
            this.featureId = featureId;
        }

        public int getFeatureId() {
            return featureId;
        }

        /**
         * Find the {@link SupportedFeature} from its id. Can return <code>null</code> if not found.
         *
         * @param featureId
         * @return the matching {@link SupportedFeature} or <code>null</code> if not found
         */
        public static SupportedFeature fromId(final int featureId) {
            for (SupportedFeature feature : SupportedFeature.values()) {
                if (feature.getFeatureId() == featureId) {
                    return feature;
                }
            }
            return null;
        }
    }
}
