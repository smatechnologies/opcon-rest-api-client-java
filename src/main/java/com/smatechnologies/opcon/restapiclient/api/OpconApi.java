package com.smatechnologies.opcon.restapiclient.api;

import com.smatechnologies.opcon.commons.deserializer.DeserializeException;
import com.smatechnologies.opcon.commons.deserializer.ZonedDateTimeDeserializer;
import com.smatechnologies.opcon.commons.util.VersionComparator;
import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.WsVersionException;
import com.smatechnologies.opcon.restapiclient.api.accesscodes.WsAccessCodes;
import com.smatechnologies.opcon.restapiclient.api.batchusers.WsBatchUsers;
import com.smatechnologies.opcon.restapiclient.api.calendars.WsCalendars;
import com.smatechnologies.opcon.restapiclient.api.dailygraphedges.WsDailyGraphEdges;
import com.smatechnologies.opcon.restapiclient.api.dailyjobs.WsDailyJobs;
import com.smatechnologies.opcon.restapiclient.api.dailyschedules.WsDailySchedules;
import com.smatechnologies.opcon.restapiclient.api.dailyvisionworkspaces.WsDailyVisionWorkspaces;
import com.smatechnologies.opcon.restapiclient.api.departments.WsDepartments;
import com.smatechnologies.opcon.restapiclient.api.features.WsFeatures;
import com.smatechnologies.opcon.restapiclient.api.globalproperties.WsGlobalProperties;
import com.smatechnologies.opcon.restapiclient.api.jobactions.WsJobActions;
import com.smatechnologies.opcon.restapiclient.api.jobhistories.WsJobHistories;
import com.smatechnologies.opcon.restapiclient.api.jobinstanceactions.WsJobInstanceActions;
import com.smatechnologies.opcon.restapiclient.api.jobtags.WsJobTags;
import com.smatechnologies.opcon.restapiclient.api.machineactions.WsMachineActions;
import com.smatechnologies.opcon.restapiclient.api.machinegroups.WsMachineGroups;
import com.smatechnologies.opcon.restapiclient.api.machines.WsMachines;
import com.smatechnologies.opcon.restapiclient.api.masterjobs.WsMasterJobs;
import com.smatechnologies.opcon.restapiclient.api.masterschedules.WsMasterSchedules;
import com.smatechnologies.opcon.restapiclient.api.mastervisionworkspaces.WsMasterVisionWorkspaces;
import com.smatechnologies.opcon.restapiclient.api.propertyexpressions.WsPropertyExpressions;
import com.smatechnologies.opcon.restapiclient.api.remoteinstances.WsRemoteInstances;
import com.smatechnologies.opcon.restapiclient.api.repositories.WsRepositories;
import com.smatechnologies.opcon.restapiclient.api.resources.WsResources;
import com.smatechnologies.opcon.restapiclient.api.roles.WsRoles;
import com.smatechnologies.opcon.restapiclient.api.scheduleactions.WsScheduleActions;
import com.smatechnologies.opcon.restapiclient.api.scheduleactionsbydate.WsScheduleActionsByDate;
import com.smatechnologies.opcon.restapiclient.api.schedulebuildrequestlogs.WsScheduleBuildRequestLogs;
import com.smatechnologies.opcon.restapiclient.api.schedulebuildrequests.WsScheduleBuildRequests;
import com.smatechnologies.opcon.restapiclient.api.schedulebuilds.WsScheduleBuilds;
import com.smatechnologies.opcon.restapiclient.api.scriptrunners.WsScriptRunners;
import com.smatechnologies.opcon.restapiclient.api.scripts.WsScripts;
import com.smatechnologies.opcon.restapiclient.api.scriptversions.WsScriptVersions;
import com.smatechnologies.opcon.restapiclient.api.serveroptions.WsServerOptions;
import com.smatechnologies.opcon.restapiclient.api.servicerequestcategories.WsServiceRequestCategories;
import com.smatechnologies.opcon.restapiclient.api.servicerequestexecutions.WsServiceRequestExecutions;
import com.smatechnologies.opcon.restapiclient.api.servicerequests.WsServiceRequests;
import com.smatechnologies.opcon.restapiclient.api.servicestatus.WsServiceStatus;
import com.smatechnologies.opcon.restapiclient.api.solutionmanagersettings.WsSolutionManagerSettings;
import com.smatechnologies.opcon.restapiclient.api.thresholds.WsThresholds;
import com.smatechnologies.opcon.restapiclient.api.tokens.WsTokens;
import com.smatechnologies.opcon.restapiclient.api.users.WsUsers;
import com.smatechnologies.opcon.restapiclient.api.version.WsVersion;
import com.smatechnologies.opcon.restapiclient.api.visionactions.WsVisionActions;
import com.smatechnologies.opcon.restapiclient.api.visioncardanomalies.WsVisionCardAnomalies;
import com.smatechnologies.opcon.restapiclient.api.visioncardstatistics.WsVisionCardStatistics;
import com.smatechnologies.opcon.restapiclient.api.visionfrequencies.WsVisionFrequencies;
import com.smatechnologies.opcon.restapiclient.api.visionjobanomalies.WsVisionJobAnomalies;
import com.smatechnologies.opcon.restapiclient.api.visionstatistic.WsVisionStatistic;
import com.smatechnologies.opcon.restapiclient.model.Token;
import com.smatechnologies.opcon.restapiclient.model.Version;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;
import java.time.ZonedDateTime;


/**
 * API helper providing shortcuts to use web services.
 *
 * @author Francois EYL
 * @author Pierre PINON
 */
public class OpconApi {

    private static final Logger LOG = LoggerFactory.getLogger(OpconApi.class);
    private static final String API_CONSUMER_ID_HEADER_KEY = "ApiConsumerId";
    private static final String API_SERVER_TIME_HEADER_KEY = "apiServerTime";
    private static final String REQUIRED_VERSION = "18.3.0";

    private final WsFactory wsFactory;

    private Token token;
    private Version version;
    private ZonedDateTime lastApiServerTime;

    public OpconApi(Client client, final OpconApiProfile profile, OpconApiListener opconApiListener) {
        Ws.WsListener wsListener = new Ws.WsListener() {

            @Override
            public Token getToken() {
                return token;
            }

            @Override
            public Version getVersion() {
                return version;
            }

            @Override
            public void renewToken() throws WsException {
                Token token = OpconApi.this.token;
                reset();

                token = opconApiListener.renewToken(OpconApi.this, token);
                if (token != null) {
                    init(token);
                }
            }

            @Override
            public void onFailed(WsException e) {
                opconApiListener.onFailed(e);
            }

            @Override
            public void onSuccess(Response response) {
                Object apiServerTime = response.getHeaders().getFirst(OpconApi.API_SERVER_TIME_HEADER_KEY);
                if (apiServerTime instanceof String) {
                    ZonedDateTimeDeserializer zonedDateTimeDeserializer = new ZonedDateTimeDeserializer();
                    try {
                        lastApiServerTime = zonedDateTimeDeserializer.deserialize((String) apiServerTime);
                    } catch (DeserializeException e) {
                        LOG.debug("[WebService]" + OpconApi.API_SERVER_TIME_HEADER_KEY + " isn't a ZoneDateTime");
                    }
                }
            }

            @Override
            public void callModifier(Ws ws) {
                String trustedApiConsumerId = opconApiListener.generateTrustedApiConsumerId();

                if (trustedApiConsumerId != null) {
                    ws.header(API_CONSUMER_ID_HEADER_KEY, trustedApiConsumerId);
                }
            }

        };

        wsFactory = new WsFactory(client, profile, wsListener);
    }

    public boolean isLogged() {
        return token != null;
    }

    public Token login(String user, String password) throws WsException {
        reset();

        Token token = tokens().postUser(user, password);
        return init(token);
    }

    public Token login(String tokenId) throws WsException {
        reset();

        Token token = tokens().get(tokenId);
        return init(token);
    }

    public Token login(Token token) throws WsException {
        reset();

        return init(token);
    }

    private Token init(Token token) throws WsException {
        this.token = token;
        version = version().get();

        if (new VersionComparator().compare(version.getOpConRestApiProductVersion(), REQUIRED_VERSION) < 0) {
            String actualVersion = version.getOpConRestApiProductVersion();
            reset();
            throw new WsVersionException("Incompatible Version Rest API Server (Required=[" + REQUIRED_VERSION + "] Actual=[" + actualVersion + "])", REQUIRED_VERSION, actualVersion);
        }

        return token;
    }

    public Token logout() throws WsException {
        if (token.getTokenType().getType() != Token.TokenType.Type.APPLICATION) {
            tokens().delete();
        }

        Token token = this.token;
        reset();

        return token;
    }

    public void reset() {
        token = null;
        version = null;
        lastApiServerTime = null;
    }

    public Token getAuthorizationToken() {
        return token;
    }

    public Version getVersion() {
        return version;
    }

    public ZonedDateTime getLastApiServerTime() {
        return lastApiServerTime;
    }

    public WsTokens tokens() {
        return new WsTokens(wsFactory);
    }

    public WsRoles roles() {
        return new WsRoles(wsFactory);
    }

    public WsDailyJobs dailyJobs() {
        return new WsDailyJobs(wsFactory);
    }

    public WsDailySchedules dailySchedules() {
        return new WsDailySchedules(wsFactory);
    }

    public WsMasterJobs masterJobs() {
        return new WsMasterJobs(wsFactory);
    }

    public WsMasterSchedules masterSchedules() {
        return new WsMasterSchedules(wsFactory);
    }

    public WsJobTags jobTags() {
        return new WsJobTags(wsFactory);
    }

    public WsServiceRequestCategories serviceRequestCategories() {
        return new WsServiceRequestCategories(wsFactory);
    }

    public WsServiceRequests serviceRequests() {
        return new WsServiceRequests(wsFactory);
    }

    public WsUsers users() {
        return new WsUsers(wsFactory);
    }

    public WsDepartments departments() {
        return new WsDepartments(wsFactory);
    }

    public WsAccessCodes accessCodes() {
        return new WsAccessCodes(wsFactory);
    }

    public WsBatchUsers batchUsers() {
        return new WsBatchUsers(wsFactory);
    }

    public WsGlobalProperties globalProperties() {
        return new WsGlobalProperties(wsFactory);
    }

    public WsResources resources() {
        return new WsResources(wsFactory);
    }

    public WsRepositories repositories() {
        return new WsRepositories(wsFactory);
    }

    public WsThresholds thresholds() {
        return new WsThresholds(wsFactory);
    }

    public WsCalendars calendars() {
        return new WsCalendars(wsFactory);
    }

    public WsServiceRequestExecutions serviceRequestExecutions() {
        return new WsServiceRequestExecutions(wsFactory);
    }

    public WsServerOptions serverOptions() {
        return new WsServerOptions(wsFactory);
    }

    public WsFeatures features() {
        return new WsFeatures(wsFactory);
    }

    public WsVersion version() {
        return new WsVersion(wsFactory);
    }

    public WsJobActions jobActions() {
        return new WsJobActions(wsFactory);
    }

    public WsJobInstanceActions jobInstanceActions() {
        return new WsJobInstanceActions(wsFactory);
    }

    public WsMachines machines() {
        return new WsMachines(wsFactory);
    }

    public WsMachineGroups machineGroups() {
        return new WsMachineGroups(wsFactory);
    }

    public WsMachineActions machineActions() {
        return new WsMachineActions(wsFactory);
    }

    public WsScheduleActions scheduleActions() {
        return new WsScheduleActions(wsFactory);
    }

    public WsScheduleActionsByDate scheduleActionsByDate() {
        return new WsScheduleActionsByDate(wsFactory);
    }

    public WsScheduleBuildRequests scheduleBuildRequests() {
        return new WsScheduleBuildRequests(wsFactory);
    }

    public WsScheduleBuildRequestLogs scheduleBuildRequestLogs() {
        return new WsScheduleBuildRequestLogs(wsFactory);
    }

    public WsScheduleBuilds scheduleBuilds() {
        return new WsScheduleBuilds(wsFactory);
    }

    public WsServiceStatus serviceStatus() {
        return new WsServiceStatus(wsFactory);
    }

    public WsDailyGraphEdges dailyGraphEdges() {
        return new WsDailyGraphEdges(wsFactory);
    }

    public WsVisionActions visionActions() {
        return new WsVisionActions(wsFactory);
    }

    public WsVisionFrequencies visionFrequencies() {
        return new WsVisionFrequencies(wsFactory);
    }

    public WsVisionStatistic visionStatistic() {
        return new WsVisionStatistic(wsFactory);
    }

    public WsVisionCardStatistics visionCardStatistics() {
        return new WsVisionCardStatistics(wsFactory);
    }

    public WsVisionJobAnomalies visionJobAnomalies() {
        return new WsVisionJobAnomalies(wsFactory);
    }

    public WsVisionCardAnomalies visionCardAnomalies() {
        return new WsVisionCardAnomalies(wsFactory);
    }

    public WsMasterVisionWorkspaces masterVisionWorkspaces() {
        return new WsMasterVisionWorkspaces(wsFactory);
    }

    public WsSolutionManagerSettings solutionManagerSettings() {
        return new WsSolutionManagerSettings(wsFactory);
    }

    public WsDailyVisionWorkspaces dailyVisionWorkspaces() {
        return new WsDailyVisionWorkspaces(wsFactory);
    }

    public WsRemoteInstances remoteInstances() {
        return new WsRemoteInstances(wsFactory);
    }

    public WsJobHistories jobHistories() {
        return new WsJobHistories(wsFactory);
    }

    public WsScripts scripts() {
        return new WsScripts(wsFactory);
    }

    public WsScriptVersions scriptVersions() {
        return new WsScriptVersions(wsFactory);
    }

    public WsScriptRunners scriptRunners() {
        return new WsScriptRunners(wsFactory);
    }

    public WsPropertyExpressions propertyExpressions() {
        return new WsPropertyExpressions(wsFactory);
    }

    public interface OpconApiListener {

        /**
         * Renew Token automatically
         *
         * @param opconApi
         * @param token
         *         the expired Token
         * @return the new Token or <null> to abort renew
         * @throws WsException
         */
        default Token renewToken(OpconApi opconApi, Token token) throws WsException {
            throw new WsException("Skip renew");
        }

        default String generateTrustedApiConsumerId() {
            return null;
        }

        void onFailed(WsException e);
    }
}
