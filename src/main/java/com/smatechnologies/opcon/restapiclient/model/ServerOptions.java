package com.smatechnologies.opcon.restapiclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;


/**
 * Resource that exposes the Server Options.
 */
@JsonIgnoreProperties(value = { "solutionManagerSettings" })
public class ServerOptions {

    public static final String RESOURCE = "serverOptions";

    public static final String PROPERTY_HTML_DOCUMENTATION = "htmlDocumentation";
    public static final String PROPERTY_PASSWORD_POLICY = "passwordPolicy";
    public static final String PROPERTY_VISION_SETTINGS = "visionSettings";
    public static final String PROPERTY_TICKETING_SYSTEM_NAME = "ticketingSystemName";
    public static final String PROPERTY_NUMBER_OF_DAYS_TO_KEEP_SERVICE_REQUEST_EXECUTIONS = "numberOfDaysToKeepServiceRequestExecutions";

    private HtmlDocumentation htmlDocumentation;
    private PasswordPolicy passwordPolicy;
    private VisionSettings visionSettings;
    private String loginSecureMessage;
    private String ticketingSystemName;
    private Integer numberOfDaysToKeepServiceRequestExecutions;

    public HtmlDocumentation getHtmlDocumentation() {
        return htmlDocumentation;
    }

    public void setHtmlDocumentation(HtmlDocumentation htmlDocumentation) {
        this.htmlDocumentation = htmlDocumentation;
    }

    public PasswordPolicy getPasswordPolicy() {
        return passwordPolicy;
    }

    public void setPasswordPolicy(PasswordPolicy passwordPolicy) {
        this.passwordPolicy = passwordPolicy;
    }

    public VisionSettings getVisionSettings() {
        return visionSettings;
    }

    public void setVisionSettings(VisionSettings visionSettings) {
        this.visionSettings = visionSettings;
    }

    public String getLoginSecureMessage() {
        return loginSecureMessage;
    }

    public void setLoginSecureMessage(String loginSecureMessage) {
        this.loginSecureMessage = loginSecureMessage;
    }

    public String getTicketingSystemName() {
        return ticketingSystemName;
    }

    public void setTicketingSystemName(String ticketingSystemName) {
        this.ticketingSystemName = ticketingSystemName;
    }

    public Integer getNumberOfDaysToKeepServiceRequestExecutions() {
        return numberOfDaysToKeepServiceRequestExecutions;
    }

    public void setNumberOfDaysToKeepServiceRequestExecutions(Integer numberOfDaysToKeepServiceRequestExecutions) {
        this.numberOfDaysToKeepServiceRequestExecutions = numberOfDaysToKeepServiceRequestExecutions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ServerOptions that = (ServerOptions) o;
        return Objects.equals(htmlDocumentation, that.htmlDocumentation) &&
                Objects.equals(passwordPolicy, that.passwordPolicy) &&
                Objects.equals(visionSettings, that.visionSettings) &&
                Objects.equals(loginSecureMessage, that.loginSecureMessage) &&
                Objects.equals(ticketingSystemName, that.ticketingSystemName) &&
                Objects.equals(numberOfDaysToKeepServiceRequestExecutions, that.numberOfDaysToKeepServiceRequestExecutions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(htmlDocumentation, passwordPolicy, visionSettings, loginSecureMessage, ticketingSystemName, numberOfDaysToKeepServiceRequestExecutions);
    }

    public static class HtmlDocumentation {

        public static final String RESOURCE = "htmlDocumentation";

        public static final String PROPERTY_ROOT_DOC_URL = "rootDocUrl";
        public static final String PROPERTY_AUTO_UPDATE = "autoUpdate";

        private String rootDocUrl;
        private boolean autoUpdate;

        public String getRootDocUrl() {
            return rootDocUrl;
        }

        public void setRootDocUrl(String rootDocUrl) {
            this.rootDocUrl = rootDocUrl;
        }

        public boolean isAutoUpdate() {
            return autoUpdate;
        }

        public void setAutoUpdate(boolean autoUpdate) {
            this.autoUpdate = autoUpdate;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            HtmlDocumentation that = (HtmlDocumentation) o;

            if (autoUpdate != that.autoUpdate)
                return false;
            return rootDocUrl != null ? rootDocUrl.equals(that.rootDocUrl) : that.rootDocUrl == null;

        }

        @Override
        public int hashCode() {
            int result = rootDocUrl != null ? rootDocUrl.hashCode() : 0;
            result = 31 * result + (autoUpdate ? 1 : 0);
            return result;
        }

        @Override
        public String toString() {
            return "HtmlDocumentation{" +
                    "rootDocUrl='" + rootDocUrl + '\'' +
                    ", autoUpdate=" + autoUpdate +
                    '}';
        }
    }

    public static class PasswordPolicy {

        public static final String RESOURCE = "passwordPolicy";

        public static final String PROPERTY_AUTO_UPDATE = "autoUpdate";
        public static final String PROPERTY_MINIMUM_CHARACTERS = "minimumCharacters";
        public static final String PROPERTY_NUMERIC_REQUIRED = "numericRequired";
        public static final String PROPERTY_ALPHA_REQUIRED = "alphaRequired";
        public static final String PROPERTY_SPECIAL_CHARACTER_REQUIRED = "specialCharacterRequired";
        public static final String PROPERTY_REPEATED_CHARACTER_OCCURRENCES_ALLOWED = "repeatedCharacterOccurrencesAllowed";
        public static final String PROPERTY_DAYS_VALID = "daysValid";
        public static final String PROPERTY_DAYS_BEFORE_EXPIRATION_TO_WARN = "daysBeforeExpirationToWarn";
        public static final String PROPERTY_NUMBER_OF_PASSWORDS_TO_RETAIN = "numberOfPasswordsToRetain";
        public static final String PROPERTY_ATTEMPTS_BEFORE_ACCOUNT_LOCK = "attemptsBeforeAccountLock";

        private Integer minimumCharacters;
        private Boolean numericRequired;
        private Boolean alphaRequired;
        private Boolean specialCharacterRequired;
        private Integer repeatedCharacterOccurrencesAllowed;
        private Integer daysValid;
        private Integer daysBeforeExpirationToWarn;
        private Integer numberOfPasswordsToRetain;
        private Integer attemptsBeforeAccountLock;
        private Integer minimumNumberOfLowerCaseCharacters;
        private Integer minimumNumberOfUpperCaseCharacters;
        private Integer minimumNumberOfDaysToChangePassword;

        public Integer getMinimumCharacters() {
            return minimumCharacters;
        }

        public void setMinimumCharacters(Integer minimumCharacters) {
            this.minimumCharacters = minimumCharacters;
        }

        public Boolean getNumericRequired() {
            return numericRequired;
        }

        public void setNumericRequired(Boolean numericRequired) {
            this.numericRequired = numericRequired;
        }

        public Boolean getAlphaRequired() {
            return alphaRequired;
        }

        public void setAlphaRequired(Boolean alphaRequired) {
            this.alphaRequired = alphaRequired;
        }

        public Boolean getSpecialCharacterRequired() {
            return specialCharacterRequired;
        }

        public void setSpecialCharacterRequired(Boolean specialCharacterRequired) {
            this.specialCharacterRequired = specialCharacterRequired;
        }

        public Integer getRepeatedCharacterOccurrencesAllowed() {
            return repeatedCharacterOccurrencesAllowed;
        }

        public void setRepeatedCharacterOccurrencesAllowed(Integer repeatedCharacterOccurrencesAllowed) {
            this.repeatedCharacterOccurrencesAllowed = repeatedCharacterOccurrencesAllowed;
        }

        public Integer getDaysValid() {
            return daysValid;
        }

        public void setDaysValid(Integer daysValid) {
            this.daysValid = daysValid;
        }

        public Integer getDaysBeforeExpirationToWarn() {
            return daysBeforeExpirationToWarn;
        }

        public void setDaysBeforeExpirationToWarn(Integer daysBeforeExpirationToWarn) {
            this.daysBeforeExpirationToWarn = daysBeforeExpirationToWarn;
        }

        public Integer getNumberOfPasswordsToRetain() {
            return numberOfPasswordsToRetain;
        }

        public void setNumberOfPasswordsToRetain(Integer numberOfPasswordsToRetain) {
            this.numberOfPasswordsToRetain = numberOfPasswordsToRetain;
        }

        public Integer getAttemptsBeforeAccountLock() {
            return attemptsBeforeAccountLock;
        }

        public void setAttemptsBeforeAccountLock(Integer attemptsBeforeAccountLock) {
            this.attemptsBeforeAccountLock = attemptsBeforeAccountLock;
        }

        public Integer getMinimumNumberOfLowerCaseCharacters() {
            return minimumNumberOfLowerCaseCharacters;
        }

        public void setMinimumNumberOfLowerCaseCharacters(Integer minimumNumberOfLowerCaseCharacters) {
            this.minimumNumberOfLowerCaseCharacters = minimumNumberOfLowerCaseCharacters;
        }

        public Integer getMinimumNumberOfUpperCaseCharacters() {
            return minimumNumberOfUpperCaseCharacters;
        }

        public void setMinimumNumberOfUpperCaseCharacters(Integer minimumNumberOfUpperCaseCharacters) {
            this.minimumNumberOfUpperCaseCharacters = minimumNumberOfUpperCaseCharacters;
        }

        public Integer getMinimumNumberOfDaysToChangePassword() {
            return minimumNumberOfDaysToChangePassword;
        }

        public void setMinimumNumberOfDaysToChangePassword(Integer minimumNumberOfDaysToChangePassword) {
            this.minimumNumberOfDaysToChangePassword = minimumNumberOfDaysToChangePassword;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            PasswordPolicy that = (PasswordPolicy) o;
            return Objects.equals(minimumCharacters, that.minimumCharacters) &&
                    Objects.equals(numericRequired, that.numericRequired) &&
                    Objects.equals(alphaRequired, that.alphaRequired) &&
                    Objects.equals(specialCharacterRequired, that.specialCharacterRequired) &&
                    Objects.equals(repeatedCharacterOccurrencesAllowed, that.repeatedCharacterOccurrencesAllowed) &&
                    Objects.equals(daysValid, that.daysValid) &&
                    Objects.equals(daysBeforeExpirationToWarn, that.daysBeforeExpirationToWarn) &&
                    Objects.equals(numberOfPasswordsToRetain, that.numberOfPasswordsToRetain) &&
                    Objects.equals(attemptsBeforeAccountLock, that.attemptsBeforeAccountLock) &&
                    Objects.equals(minimumNumberOfLowerCaseCharacters, that.minimumNumberOfLowerCaseCharacters) &&
                    Objects.equals(minimumNumberOfUpperCaseCharacters, that.minimumNumberOfUpperCaseCharacters) &&
                    Objects.equals(minimumNumberOfDaysToChangePassword, that.minimumNumberOfDaysToChangePassword);
        }

        @Override
        public int hashCode() {
            return Objects.hash(minimumCharacters, numericRequired, alphaRequired, specialCharacterRequired, repeatedCharacterOccurrencesAllowed, daysValid, daysBeforeExpirationToWarn, numberOfPasswordsToRetain, attemptsBeforeAccountLock, minimumNumberOfLowerCaseCharacters, minimumNumberOfUpperCaseCharacters, minimumNumberOfDaysToChangePassword);
        }
    }

    public static class VisionSettings {

        public static final String RESOURCE = "visionSettings";

        public static final String PROPERTY_VISION_PAST_PROCESSING_DAYS = "visionPastProcessingDays";
        public static final String PROPERTY_VISION_FUTURE_PROCESSING_DAYS = "visionFutureProcessingDays";
        public static final String PROPERTY_VISION_HISTORY_DAYS_TO_KEEP = "visionHistoryDaysToKeep";

        private Integer visionPastProcessingDays;
        private Integer visionFutureProcessingDays;
        private Integer visionHistoryDaysToKeep;

        public Integer getVisionPastProcessingDays() {
            return visionPastProcessingDays;
        }

        public void setVisionPastProcessingDays(Integer visionPastProcessingDays) {
            this.visionPastProcessingDays = visionPastProcessingDays;
        }

        public Integer getVisionFutureProcessingDays() {
            return visionFutureProcessingDays;
        }

        public void setVisionFutureProcessingDays(Integer visionFutureProcessingDays) {
            this.visionFutureProcessingDays = visionFutureProcessingDays;
        }

        public Integer getVisionHistoryDaysToKeep() {
            return visionHistoryDaysToKeep;
        }

        public void setVisionHistoryDaysToKeep(Integer visionHistoryDaysToKeep) {
            this.visionHistoryDaysToKeep = visionHistoryDaysToKeep;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof VisionSettings))
                return false;
            VisionSettings that = (VisionSettings) o;
            return Objects.equals(getVisionPastProcessingDays(), that.getVisionPastProcessingDays()) &&
                    Objects.equals(getVisionFutureProcessingDays(), that.getVisionFutureProcessingDays()) &&
                    Objects.equals(getVisionHistoryDaysToKeep(), that.getVisionHistoryDaysToKeep());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getVisionPastProcessingDays(), getVisionFutureProcessingDays(), getVisionHistoryDaysToKeep());
        }
    }
}