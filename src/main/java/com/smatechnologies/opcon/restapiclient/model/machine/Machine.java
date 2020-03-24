package com.smatechnologies.opcon.restapiclient.model.machine;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;
import com.smatechnologies.opcon.restapiclient.jackson.NestedStdTypeResolverBuilder;
import com.smatechnologies.opcon.restapiclient.jackson.deserializer.ListPropertyDeserializer;
import com.smatechnologies.opcon.restapiclient.jackson.serializer.ListPropertySerializer;
import com.smatechnologies.opcon.restapiclient.model.MachineGroup;
import com.smatechnologies.opcon.restapiclient.model.MachineStatus;
import com.smatechnologies.opcon.restapiclient.model.MachineType;
import com.smatechnologies.opcon.restapiclient.model.Property;
import com.smatechnologies.opcon.restapiclient.model.agentcapability.AgentCapability;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;


/**
 * Resource describing a Machine in OpCon.
 *
 * @author Francois EYL
 * @author Pierre PINON
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type.description", defaultImpl = DefaultMachine.class)
@JsonTypeResolver(NestedStdTypeResolverBuilder.class)
@JsonSubTypes({
        @JsonSubTypes.Type(value = WindowsMachine.class, name = "Windows")
})
public abstract class Machine {

    public static final String RESOURCE = "machine";

    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_TYPE = "type";
    public static final String PROPERTY_STATUS = "status";
    public static final String PROPERTY_VERSION = "version";
    public static final String PROPERTY_OS_VERSION = "osVersion";
    public static final String PROPERTY_OS_TYPE = "osType";
    public static final String PROPERTY_USE_TLS_SKD_COMM = "useTLSforSchedulingCommunications";
    public static final String PROPERTY_SOCKET = "socket";
    public static final String PROPERTY_GATEWAY_ID = "gatewayId";
    public static final String PROPERTY_GROUPS = "groups";
    public static final String PROPERTY_LAST_UPDATE = "lastUpdate";
    public static final String PROPERTY_MAXIMUM_JOBS = "maximumJobs";
    public static final String PROPERTY_OPCON_MAXIMUM_JOBS = "opconMaximumJobs";
    public static final String PROPERTY_CURRENT_JOBS = "currentJobs";
    public static final String PROPERTY_REQUIRES_XML_ESCAPE = "requiresXMLEscape";
    public static final String PROPERTY_AGENT_SMA_COMMUNICATIONS_PROTOCOL = "agentSMACommunicationsProtocol";
    public static final String PROPERTY_ALLOW_KILL_JOB = "allowKillJob";
    public static final String PROPERTY_TCP_IP_ADDRESS = "tcpIpAddress";
    public static final String PROPERTY_POLL_INTERVAL = "pollInterval";
    public static final String PROPERTY_CHECK_MACHINE_STATUS_INTERVAL = "checkMachineStatusInterval";
    public static final String PROPERTY_CONNECTION_ATTEMPT_TIMEOUT = "connectionAttemptTimeout";
    public static final String PROPERTY_NO_BUFFER_RETRY_COUNT = "noBufferRetryCount";
    public static final String PROPERTY_NO_BUFFER_SLEEP_TIME = "noBufferSleepTime";
    public static final String PROPERTY_MAX_CONSECUTIVE_SEND_MESSAGES = "maxConsecutiveSendMessages";
    public static final String PROPERTY_CONSECUTIVE_SEND_SLEEP_TIME = "consecutiveSendSleepTime";
    public static final String PROPERTY_SEND_BUFFER_COUNT = "sendBufferCount";
    public static final String PROPERTY_RECEIVE_BUFFER_COUNT = "receiveBufferCount";
    public static final String PROPERTY_MAX_BYTES_SENT_PER_MESSAGE = "maxBytesSentPerMessage";
    public static final String PROPERTY_MAX_BYTES_READ_PER_MESSAGE = "maxBytesReadPerMessage";
    public static final String PROPERTY_RESPONSE_TIMEOUT = "responseTimeout";
    public static final String PROPERTY_AGENT_CHECK_CRC = "agentCheckCRC";
    public static final String PROPERTY_CLOSE_SOCKET_DURING_SYNCHRONIZATION = "closeSocketDuringSynchronization";
    public static final String PROPERTY_TRACE_ALL_MESSAGES = "traceAllMessages";
    public static final String PROPERTY_SMA_NET_COM_IDENTIFIER = "smaNetComIdentifier";
    public static final String PROPERTY_GATEWAY_NAME = "gatewayName";
    public static final String PROPERTY_JORS_PORT_NUMBER = "jorsPortNumber";
    public static final String PROPERTY_FILE_TRANSFER_ROLE = "fileTransferRole";
    public static final String PROPERTY_FILE_TRANSFER_IP_ADDRESS = "fileTransferIPAddress";
    public static final String PROPERTY_AVAILABLE_PROPERTIES = "availableProperties";
    public static final String PROPERTY_FILE_TRANSFER_PORT_NUMBER_FOR_NON_TLS = "fileTransferPortNumberForNonTLS";
    public static final String PROPERTY_FILE_TRANSFER_PORT_NUMBER_FOR_TLS = "fileTransferPortNumberForTLS";
    public static final String PROPERTY_AGENT_FILE_TRANSFER_PORT_NUMBER_FOR_TLS = "agentFileTransferPortNumberForTLS";
    public static final String PROPERTY_LSAM_TIME = "lsamTime";
    public static final String PROPERTY_LSAM_TIME_DELTA_FROM_SAM = "lsamTimeDeltafromSAM";
    public static final String PROPERTY_FULLY_QUALIFIED_DOMAIN_NAME = "fullyQualifiedDomainName";
    public static final String PROPERTY_FULL_FILE_TRANSFER_SUPPORT = "fullFileTransferSupport";
    public static final String PROPERTY_TIME_OFFSET_FROM_UTC = "timeOffsetfromUTC";
    public static final String PROPERTY_TIME_ZONE_NAME = "timeZoneName";
    public static final String PROPERTY_TIME_OFFSET_FROM_SAM_IN_HOURS = "timeOffsetfromSAMInHours";
    public static final String PROPERTY_TIME_SENT = "timeSent";
    public static final String PROPERTY_HOSTNAME = "hostname";
    public static final String PROPERTY_AGENT_NAME = "agentName";
    public static final String PROPERTY_AGENT_SOCKET = "agentSocket";
    public static final String PROPERTY_JORS_SOCKET = "jorsSocket";
    public static final String PROPERTY_SMAFT_SERVER_PORT_FOR_NON_TLS = "smaftServerPortForNonTLS";
    public static final String PROPERTY_MACHINE_MAXIMUM_JOBS = "machineMaximumJobs";
    public static final String PROPERTY_SMA_COMMUNICATIONS_PROTOCOL = "smaCommunicationsProtocol";
    public static final String PROPERTY_CHECK_CRC = "checkCRC";
    public static final String PROPERTY_CLOSE_SOCKET = "closeSocket";
    public static final String PROPERTY_ACCEPT_MESSAGES_FROM_IP = "acceptMessagesfromIP";
    public static final String PROPERTY_SMA_NET_COM_SOCKET = "smaNetComSocket";
    public static final String PROPERTY_CPU_ID = "cpuid";
    public static final String PROPERTY_CPU_TYPE = "cpuType";
    public static final String PROPERTY_CPU_MODEL = "cpuModel";
    public static final String PROPERTY_CPU_COUNT = "cpuCount";
    public static final String PROPERTY_FILE_TRANSFER_FEATURE = "fileTransferFeature";
    public static final String PROPERTY_JORS_FEATURE = "jorsFeature";
    public static final String PROPERTY_RESOURCEMONITORFEATURE = "resourceMonitorFeature";
    public static final String PROPERTY_SUPPORT_SHANDSHAKE = "supportsHandshake";
    public static final String PROPERTY_TLS_CERTIFICATE_DISTINGUISHED_NAME = "tlsCertificateDistinguishedName";
    public static final String PROPERTY_CHECK_CERTIFICATE_REVOCATION_LIST = "checkCertificateRevocationList";
    public static final String PROPERTY_SUPPORT_TLS_FOR_SMAFT_AGENT = "supportTLSForSMAFTAgent";
    public static final String PROPERTY_AGENT_SUPPORT_TLS_FOR_SMAFT_AGENT = "agentSupportTLSForSMAFTAgent";
    public static final String PROPERTY_SUPPORT_TLS_FOR_SMAFT_SERVER = "supportTLSForSMAFTServer";
    public static final String PROPERTY_AGENT_SUPPORT_TLS_FOR_SMAFT_SERVER = "agentSupportTLSForSMAFTServer";
    public static final String PROPERTY_SUPPORT_NON_TLS_FOR_SMAFT_AGENT = "supportNonTLSForSMAFTAgent";
    public static final String PROPERTY_AGENT_SUPPORT_NON_TLS_FOR_SMAFT_AGENT = "agentSupportNonTLSForSMAFTAgent";
    public static final String PROPERTY_SUPPORT_NON_TLS_FOR_SMAFT_SERVER = "supportNonTLSForSMAFTServer";
    public static final String PROPERTY_AGENT_SUPPORT_NON_TLS_FOR_SMAFT_SERVER = "agentSupportNonTLSForSMAFTServer";
    public static final String PROPERTY_AGENT_SPECIAL_FEATURES = "agentSpecialFeatures";
    public static final String PROPERTY_HP_NON_STOP_IP_ADDRESS = "hpNonStopIPAddress";
    public static final String PROPERTY_HP_NON_STOP_SOCKET_NUMBER = "hpNonStopSocketNumber";
    public static final String PROPERTY_SMAFT_AGENT_PORT = "smaftAgentPort";
    public static final String PROPERTY_TLS_CERTIFICATE_SERIAL_NUMBER = "TLSCertificateSerialNumber";
    public static final String PROPERTY_SUPPORTED_AGENT_CAPABILITY = "supportedAgentCapability";
    public static final String PROPERTY_DOCUMENTATION = "documentation";

    private Integer id;
    private String name;
    private MachineStatus status;
    private String version;
    private String osVersion;
    private String osType;
    private Boolean useTLSforSchedulingCommunications;
    private Integer socket;
    private Integer gatewayId;
    private List<MachineGroup> groups;
    private ZonedDateTime lastUpdate;
    private Integer maximumJobs;
    private Integer opconMaximumJobs;
    private Integer currentJobs;
    private Boolean requiresXMLEscape;
    private String agentSMACommunicationsProtocol;
    private Boolean allowKillJob;
    private String tcpIpAddress;
    private Integer pollInterval;
    private Integer checkMachineStatusInterval;
    private Integer connectionAttemptTimeout;
    private Integer noBufferRetryCount;
    private Integer noBufferSleepTime;
    private Integer maxConsecutiveSendMessages;
    private Integer consecutiveSendSleepTime;
    private Integer sendBufferCount;
    private Integer receiveBufferCount;
    private Integer maxBytesSentPerMessage;
    private Integer maxBytesReadPerMessage;
    private Integer responseTimeout;
    private Boolean agentCheckCRC;
    private Boolean closeSocketDuringSynchronization;
    private Boolean traceAllMessages;
    private String smaNetComIdentifier;
    private String gatewayName;
    private Integer jorsPortNumber;
    private String fileTransferRole;
    private String fileTransferIPAddress;
    private List<List<Property>> availableProperties;
    private Integer fileTransferPortNumberForNonTLS;
    private Integer fileTransferPortNumberForTLS;
    private String agentFileTransferPortNumberForTLS;
    private Integer lsamTime;
    private Integer lsamTimeDeltafromSAM;
    private String fullyQualifiedDomainName;
    private Boolean fullFileTransferSupport;
    private Double timeOffsetfromUTC;
    private String timeZoneName;
    private Integer timeOffsetfromSAMInHours;
    private String timeSent;
    private String hostname;
    private String agentName;
    private String agentSocket;
    private String jorsSocket;
    private String smaftServerPortForNonTLS;
    private String machineMaximumJobs;
    private String smaCommunicationsProtocol;
    private String checkCRC;
    private String closeSocket;
    private String acceptMessagesfromIP;
    private String smaNetComSocket;
    private String cpuid;
    private String cpuType;
    private String cpuModel;
    private String cpuCount;
    private String fileTransferFeature;
    private String jorsFeature;
    private String resourceMonitorFeature;
    private String supportsHandshake;
    private String tlsCertificateDistinguishedName;
    private Boolean checkCertificateRevocationList;
    private Boolean supportTLSForSMAFTAgent;
    private String agentSupportTLSForSMAFTAgent;
    private Boolean supportTLSForSMAFTServer;
    private String agentSupportTLSForSMAFTServer;
    private Boolean supportNonTLSForSMAFTAgent;
    private String agentSupportNonTLSForSMAFTAgent;
    private Boolean supportNonTLSForSMAFTServer;
    private String agentSupportNonTLSForSMAFTServer;
    private String agentSpecialFeatures;
    private String hpNonStopIPAddress;
    private Integer hpNonStopSocketNumber;
    private String smaftAgentPort;
    private String tlsCertificateSerialNumber;
    private String documentation;

    abstract public MachineType getType();

    abstract public List<? extends AgentCapability> getSupportedAgentCapability();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public Boolean getUseTLSforSchedulingCommunications() {
        return useTLSforSchedulingCommunications;
    }

    public void setUseTLSforSchedulingCommunications(Boolean useTLSforSchedulingCommunications) {
        this.useTLSforSchedulingCommunications = useTLSforSchedulingCommunications;
    }

    public Integer getSocket() {
        return socket;
    }

    public void setSocket(Integer socket) {
        this.socket = socket;
    }

    public Integer getGatewayId() {
        return gatewayId;
    }

    public void setGatewayId(Integer gatewayId) {
        this.gatewayId = gatewayId;
    }

    public List<MachineGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<MachineGroup> groups) {
        this.groups = groups;
    }

    public ZonedDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(ZonedDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Integer getMaximumJobs() {
        return maximumJobs;
    }

    public void setMaximumJobs(Integer maximumJobs) {
        this.maximumJobs = maximumJobs;
    }

    public Integer getOpconMaximumJobs() {
        return opconMaximumJobs;
    }

    public void setOpconMaximumJobs(Integer opconMaximumJobs) {
        this.opconMaximumJobs = opconMaximumJobs;
    }

    public Integer getCurrentJobs() {
        return currentJobs;
    }

    public void setCurrentJobs(Integer currentJobs) {
        this.currentJobs = currentJobs;
    }

    public MachineStatus getStatus() {
        return status;
    }

    public void setStatus(MachineStatus status) {
        this.status = status;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }

    public Boolean getRequiresXMLEscape() {
        return requiresXMLEscape;
    }

    public void setRequiresXMLEscape(Boolean requiresXMLEscape) {
        this.requiresXMLEscape = requiresXMLEscape;
    }

    public String getAgentSMACommunicationsProtocol() {
        return agentSMACommunicationsProtocol;
    }

    public void setAgentSMACommunicationsProtocol(String agentSMACommunicationsProtocol) {
        this.agentSMACommunicationsProtocol = agentSMACommunicationsProtocol;
    }

    public Boolean getAllowKillJob() {
        return allowKillJob;
    }

    public void setAllowKillJob(Boolean allowKillJob) {
        this.allowKillJob = allowKillJob;
    }

    public String getTcpIpAddress() {
        return tcpIpAddress;
    }

    public void setTcpIpAddress(String tcpIpAddress) {
        this.tcpIpAddress = tcpIpAddress;
    }

    public Integer getPollInterval() {
        return pollInterval;
    }

    public void setPollInterval(Integer pollInterval) {
        this.pollInterval = pollInterval;
    }

    public Integer getCheckMachineStatusInterval() {
        return checkMachineStatusInterval;
    }

    public void setCheckMachineStatusInterval(Integer checkMachineStatusInterval) {
        this.checkMachineStatusInterval = checkMachineStatusInterval;
    }

    public Integer getConnectionAttemptTimeout() {
        return connectionAttemptTimeout;
    }

    public void setConnectionAttemptTimeout(Integer connectionAttemptTimeout) {
        this.connectionAttemptTimeout = connectionAttemptTimeout;
    }

    public Integer getNoBufferRetryCount() {
        return noBufferRetryCount;
    }

    public void setNoBufferRetryCount(Integer noBufferRetryCount) {
        this.noBufferRetryCount = noBufferRetryCount;
    }

    public Integer getNoBufferSleepTime() {
        return noBufferSleepTime;
    }

    public void setNoBufferSleepTime(Integer noBufferSleepTime) {
        this.noBufferSleepTime = noBufferSleepTime;
    }

    public Integer getMaxConsecutiveSendMessages() {
        return maxConsecutiveSendMessages;
    }

    public void setMaxConsecutiveSendMessages(Integer maxConsecutiveSendMessages) {
        this.maxConsecutiveSendMessages = maxConsecutiveSendMessages;
    }

    public Integer getConsecutiveSendSleepTime() {
        return consecutiveSendSleepTime;
    }

    public void setConsecutiveSendSleepTime(Integer consecutiveSendSleepTime) {
        this.consecutiveSendSleepTime = consecutiveSendSleepTime;
    }

    public Integer getSendBufferCount() {
        return sendBufferCount;
    }

    public void setSendBufferCount(Integer sendBufferCount) {
        this.sendBufferCount = sendBufferCount;
    }

    public Integer getReceiveBufferCount() {
        return receiveBufferCount;
    }

    public void setReceiveBufferCount(Integer receiveBufferCount) {
        this.receiveBufferCount = receiveBufferCount;
    }

    public Integer getMaxBytesSentPerMessage() {
        return maxBytesSentPerMessage;
    }

    public void setMaxBytesSentPerMessage(Integer maxBytesSentPerMessage) {
        this.maxBytesSentPerMessage = maxBytesSentPerMessage;
    }

    public Integer getMaxBytesReadPerMessage() {
        return maxBytesReadPerMessage;
    }

    public void setMaxBytesReadPerMessage(Integer maxBytesReadPerMessage) {
        this.maxBytesReadPerMessage = maxBytesReadPerMessage;
    }

    public Integer getResponseTimeout() {
        return responseTimeout;
    }

    public void setResponseTimeout(Integer responseTimeout) {
        this.responseTimeout = responseTimeout;
    }

    public Boolean getAgentCheckCRC() {
        return agentCheckCRC;
    }

    public void setAgentCheckCRC(Boolean agentCheckCRC) {
        this.agentCheckCRC = agentCheckCRC;
    }

    public Boolean getCloseSocketDuringSynchronization() {
        return closeSocketDuringSynchronization;
    }

    public void setCloseSocketDuringSynchronization(Boolean closeSocketDuringSynchronization) {
        this.closeSocketDuringSynchronization = closeSocketDuringSynchronization;
    }

    public Boolean getTraceAllMessages() {
        return traceAllMessages;
    }

    public void setTraceAllMessages(Boolean traceAllMessages) {
        this.traceAllMessages = traceAllMessages;
    }

    public String getSmaNetComIdentifier() {
        return smaNetComIdentifier;
    }

    public void setSmaNetComIdentifier(String smaNetComIdentifier) {
        this.smaNetComIdentifier = smaNetComIdentifier;
    }

    public String getGatewayName() {
        return gatewayName;
    }

    public void setGatewayName(String gatewayName) {
        this.gatewayName = gatewayName;
    }

    public Integer getJorsPortNumber() {
        return jorsPortNumber;
    }

    public void setJorsPortNumber(Integer jorsPortNumber) {
        this.jorsPortNumber = jorsPortNumber;
    }

    public String getFileTransferRole() {
        return fileTransferRole;
    }

    public void setFileTransferRole(String fileTransferRole) {
        this.fileTransferRole = fileTransferRole;
    }

    public String getFileTransferIPAddress() {
        return fileTransferIPAddress;
    }

    public void setFileTransferIPAddress(String fileTransferIPAddress) {
        this.fileTransferIPAddress = fileTransferIPAddress;
    }

    @JsonSerialize(contentUsing = ListPropertySerializer.class)
    @JsonDeserialize(contentUsing = ListPropertyDeserializer.class)
    public List<List<Property>> getAvailableProperties() {
        return availableProperties;
    }

    public void setAvailableProperties(List<List<Property>> availableProperties) {
        this.availableProperties = availableProperties;
    }

    public Integer getFileTransferPortNumberForNonTLS() {
        return fileTransferPortNumberForNonTLS;
    }

    public void setFileTransferPortNumberForNonTLS(Integer fileTransferPortNumberForNonTLS) {
        this.fileTransferPortNumberForNonTLS = fileTransferPortNumberForNonTLS;
    }

    public Integer getFileTransferPortNumberForTLS() {
        return fileTransferPortNumberForTLS;
    }

    public void setFileTransferPortNumberForTLS(Integer fileTransferPortNumberForTLS) {
        this.fileTransferPortNumberForTLS = fileTransferPortNumberForTLS;
    }

    public String getAgentFileTransferPortNumberForTLS() {
        return agentFileTransferPortNumberForTLS;
    }

    public void setAgentFileTransferPortNumberForTLS(String agentFileTransferPortNumberForTLS) {
        this.agentFileTransferPortNumberForTLS = agentFileTransferPortNumberForTLS;
    }

    public Integer getLsamTime() {
        return lsamTime;
    }

    public void setLsamTime(Integer lsamTime) {
        this.lsamTime = lsamTime;
    }

    public Integer getLsamTimeDeltafromSAM() {
        return lsamTimeDeltafromSAM;
    }

    public void setLsamTimeDeltafromSAM(Integer lsamTimeDeltafromSAM) {
        this.lsamTimeDeltafromSAM = lsamTimeDeltafromSAM;
    }

    public String getFullyQualifiedDomainName() {
        return fullyQualifiedDomainName;
    }

    public void setFullyQualifiedDomainName(String fullyQualifiedDomainName) {
        this.fullyQualifiedDomainName = fullyQualifiedDomainName;
    }

    public Boolean getFullFileTransferSupport() {
        return fullFileTransferSupport;
    }

    public void setFullFileTransferSupport(Boolean fullFileTransferSupport) {
        this.fullFileTransferSupport = fullFileTransferSupport;
    }

    public Double getTimeOffsetfromUTC() {
        return timeOffsetfromUTC;
    }

    public void setTimeOffsetfromUTC(Double timeOffsetfromUTC) {
        this.timeOffsetfromUTC = timeOffsetfromUTC;
    }

    public String getTimeZoneName() {
        return timeZoneName;
    }

    public void setTimeZoneName(String timeZoneName) {
        this.timeZoneName = timeZoneName;
    }

    public Integer getTimeOffsetfromSAMInHours() {
        return timeOffsetfromSAMInHours;
    }

    public void setTimeOffsetfromSAMInHours(Integer timeOffsetfromSAMInHours) {
        this.timeOffsetfromSAMInHours = timeOffsetfromSAMInHours;
    }

    public String getTimeSent() {
        return timeSent;
    }

    public void setTimeSent(String timeSent) {
        this.timeSent = timeSent;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentSocket() {
        return agentSocket;
    }

    public void setAgentSocket(String agentSocket) {
        this.agentSocket = agentSocket;
    }

    public String getJorsSocket() {
        return jorsSocket;
    }

    public void setJorsSocket(String jorsSocket) {
        this.jorsSocket = jorsSocket;
    }

    public String getSmaftServerPortForNonTLS() {
        return smaftServerPortForNonTLS;
    }

    public void setSmaftServerPortForNonTLS(String smaftServerPortForNonTLS) {
        this.smaftServerPortForNonTLS = smaftServerPortForNonTLS;
    }

    public String getMachineMaximumJobs() {
        return machineMaximumJobs;
    }

    public void setMachineMaximumJobs(String machineMaximumJobs) {
        this.machineMaximumJobs = machineMaximumJobs;
    }

    public String getSmaCommunicationsProtocol() {
        return smaCommunicationsProtocol;
    }

    public void setSmaCommunicationsProtocol(String smaCommunicationsProtocol) {
        this.smaCommunicationsProtocol = smaCommunicationsProtocol;
    }

    public String getCheckCRC() {
        return checkCRC;
    }

    public void setCheckCRC(String checkCRC) {
        this.checkCRC = checkCRC;
    }

    public String getCloseSocket() {
        return closeSocket;
    }

    public void setCloseSocket(String closeSocket) {
        this.closeSocket = closeSocket;
    }

    public String getAcceptMessagesfromIP() {
        return acceptMessagesfromIP;
    }

    public void setAcceptMessagesfromIP(String acceptMessagesfromIP) {
        this.acceptMessagesfromIP = acceptMessagesfromIP;
    }

    public String getSmaNetComSocket() {
        return smaNetComSocket;
    }

    public void setSmaNetComSocket(String smaNetComSocket) {
        this.smaNetComSocket = smaNetComSocket;
    }

    public String getCpuid() {
        return cpuid;
    }

    public void setCpuid(String cpuid) {
        this.cpuid = cpuid;
    }

    public String getCpuType() {
        return cpuType;
    }

    public void setCpuType(String cpuType) {
        this.cpuType = cpuType;
    }

    public String getCpuModel() {
        return cpuModel;
    }

    public void setCpuModel(String cpuModel) {
        this.cpuModel = cpuModel;
    }

    public String getCpuCount() {
        return cpuCount;
    }

    public void setCpuCount(String cpuCount) {
        this.cpuCount = cpuCount;
    }

    public String getFileTransferFeature() {
        return fileTransferFeature;
    }

    public void setFileTransferFeature(String fileTransferFeature) {
        this.fileTransferFeature = fileTransferFeature;
    }

    public String getJorsFeature() {
        return jorsFeature;
    }

    public void setJorsFeature(String jorsFeature) {
        this.jorsFeature = jorsFeature;
    }

    public String getResourceMonitorFeature() {
        return resourceMonitorFeature;
    }

    public void setResourceMonitorFeature(String resourceMonitorFeature) {
        this.resourceMonitorFeature = resourceMonitorFeature;
    }

    public String getSupportsHandshake() {
        return supportsHandshake;
    }

    public void setSupportsHandshake(String supportsHandshake) {
        this.supportsHandshake = supportsHandshake;
    }

    public String getTlsCertificateDistinguishedName() {
        return tlsCertificateDistinguishedName;
    }

    public void setTlsCertificateDistinguishedName(String tlsCertificateDistinguishedName) {
        this.tlsCertificateDistinguishedName = tlsCertificateDistinguishedName;
    }

    public Boolean getCheckCertificateRevocationList() {
        return checkCertificateRevocationList;
    }

    public void setCheckCertificateRevocationList(Boolean checkCertificateRevocationList) {
        this.checkCertificateRevocationList = checkCertificateRevocationList;
    }

    public Boolean getSupportTLSForSMAFTAgent() {
        return supportTLSForSMAFTAgent;
    }

    public void setSupportTLSForSMAFTAgent(Boolean supportTLSForSMAFTAgent) {
        this.supportTLSForSMAFTAgent = supportTLSForSMAFTAgent;
    }

    public String getAgentSupportTLSForSMAFTAgent() {
        return agentSupportTLSForSMAFTAgent;
    }

    public void setAgentSupportTLSForSMAFTAgent(String agentSupportTLSForSMAFTAgent) {
        this.agentSupportTLSForSMAFTAgent = agentSupportTLSForSMAFTAgent;
    }

    public Boolean getSupportTLSForSMAFTServer() {
        return supportTLSForSMAFTServer;
    }

    public void setSupportTLSForSMAFTServer(Boolean supportTLSForSMAFTServer) {
        this.supportTLSForSMAFTServer = supportTLSForSMAFTServer;
    }

    public String getAgentSupportTLSForSMAFTServer() {
        return agentSupportTLSForSMAFTServer;
    }

    public void setAgentSupportTLSForSMAFTServer(String agentSupportTLSForSMAFTServer) {
        this.agentSupportTLSForSMAFTServer = agentSupportTLSForSMAFTServer;
    }

    public Boolean getSupportNonTLSForSMAFTAgent() {
        return supportNonTLSForSMAFTAgent;
    }

    public void setSupportNonTLSForSMAFTAgent(Boolean supportNonTLSForSMAFTAgent) {
        this.supportNonTLSForSMAFTAgent = supportNonTLSForSMAFTAgent;
    }

    public String getAgentSupportNonTLSForSMAFTAgent() {
        return agentSupportNonTLSForSMAFTAgent;
    }

    public void setAgentSupportNonTLSForSMAFTAgent(String agentSupportNonTLSForSMAFTAgent) {
        this.agentSupportNonTLSForSMAFTAgent = agentSupportNonTLSForSMAFTAgent;
    }

    public Boolean getSupportNonTLSForSMAFTServer() {
        return supportNonTLSForSMAFTServer;
    }

    public void setSupportNonTLSForSMAFTServer(Boolean supportNonTLSForSMAFTServer) {
        this.supportNonTLSForSMAFTServer = supportNonTLSForSMAFTServer;
    }

    public String getAgentSupportNonTLSForSMAFTServer() {
        return agentSupportNonTLSForSMAFTServer;
    }

    public void setAgentSupportNonTLSForSMAFTServer(String agentSupportNonTLSForSMAFTServer) {
        this.agentSupportNonTLSForSMAFTServer = agentSupportNonTLSForSMAFTServer;
    }

    public String getAgentSpecialFeatures() {
        return agentSpecialFeatures;
    }

    public void setAgentSpecialFeatures(String agentSpecialFeatures) {
        this.agentSpecialFeatures = agentSpecialFeatures;
    }

    public String getHpNonStopIPAddress() {
        return hpNonStopIPAddress;
    }

    public void setHpNonStopIPAddress(String hpNonStopIPAddress) {
        this.hpNonStopIPAddress = hpNonStopIPAddress;
    }

    public Integer getHpNonStopSocketNumber() {
        return hpNonStopSocketNumber;
    }

    public void setHpNonStopSocketNumber(Integer hpNonStopSocketNumber) {
        this.hpNonStopSocketNumber = hpNonStopSocketNumber;
    }

    public String getSmaftAgentPort() {
        return smaftAgentPort;
    }

    public void setSmaftAgentPort(String smaftAgentPort) {
        this.smaftAgentPort = smaftAgentPort;
    }

    public String getTlsCertificateSerialNumber() {
        return tlsCertificateSerialNumber;
    }

    public void setTlsCertificateSerialNumber(String tlsCertificateSerialNumber) {
        this.tlsCertificateSerialNumber = tlsCertificateSerialNumber;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Machine machine = (Machine) o;
        return Objects.equals(id, machine.id) &&
                Objects.equals(name, machine.name) &&
                Objects.equals(status, machine.status) &&
                Objects.equals(version, machine.version) &&
                Objects.equals(osVersion, machine.osVersion) &&
                Objects.equals(osType, machine.osType) &&
                Objects.equals(useTLSforSchedulingCommunications, machine.useTLSforSchedulingCommunications) &&
                Objects.equals(socket, machine.socket) &&
                Objects.equals(gatewayId, machine.gatewayId) &&
                Objects.equals(groups, machine.groups) &&
                Objects.equals(lastUpdate, machine.lastUpdate) &&
                Objects.equals(maximumJobs, machine.maximumJobs) &&
                Objects.equals(opconMaximumJobs, machine.opconMaximumJobs) &&
                Objects.equals(currentJobs, machine.currentJobs) &&
                Objects.equals(requiresXMLEscape, machine.requiresXMLEscape) &&
                Objects.equals(agentSMACommunicationsProtocol, machine.agentSMACommunicationsProtocol) &&
                Objects.equals(allowKillJob, machine.allowKillJob) &&
                Objects.equals(tcpIpAddress, machine.tcpIpAddress) &&
                Objects.equals(pollInterval, machine.pollInterval) &&
                Objects.equals(checkMachineStatusInterval, machine.checkMachineStatusInterval) &&
                Objects.equals(connectionAttemptTimeout, machine.connectionAttemptTimeout) &&
                Objects.equals(noBufferRetryCount, machine.noBufferRetryCount) &&
                Objects.equals(noBufferSleepTime, machine.noBufferSleepTime) &&
                Objects.equals(maxConsecutiveSendMessages, machine.maxConsecutiveSendMessages) &&
                Objects.equals(consecutiveSendSleepTime, machine.consecutiveSendSleepTime) &&
                Objects.equals(sendBufferCount, machine.sendBufferCount) &&
                Objects.equals(receiveBufferCount, machine.receiveBufferCount) &&
                Objects.equals(maxBytesSentPerMessage, machine.maxBytesSentPerMessage) &&
                Objects.equals(maxBytesReadPerMessage, machine.maxBytesReadPerMessage) &&
                Objects.equals(responseTimeout, machine.responseTimeout) &&
                Objects.equals(agentCheckCRC, machine.agentCheckCRC) &&
                Objects.equals(closeSocketDuringSynchronization, machine.closeSocketDuringSynchronization) &&
                Objects.equals(traceAllMessages, machine.traceAllMessages) &&
                Objects.equals(smaNetComIdentifier, machine.smaNetComIdentifier) &&
                Objects.equals(gatewayName, machine.gatewayName) &&
                Objects.equals(jorsPortNumber, machine.jorsPortNumber) &&
                Objects.equals(fileTransferRole, machine.fileTransferRole) &&
                Objects.equals(fileTransferIPAddress, machine.fileTransferIPAddress) &&
                Objects.equals(availableProperties, machine.availableProperties) &&
                Objects.equals(fileTransferPortNumberForNonTLS, machine.fileTransferPortNumberForNonTLS) &&
                Objects.equals(fileTransferPortNumberForTLS, machine.fileTransferPortNumberForTLS) &&
                Objects.equals(agentFileTransferPortNumberForTLS, machine.agentFileTransferPortNumberForTLS) &&
                Objects.equals(lsamTime, machine.lsamTime) &&
                Objects.equals(lsamTimeDeltafromSAM, machine.lsamTimeDeltafromSAM) &&
                Objects.equals(fullyQualifiedDomainName, machine.fullyQualifiedDomainName) &&
                Objects.equals(fullFileTransferSupport, machine.fullFileTransferSupport) &&
                Objects.equals(timeOffsetfromUTC, machine.timeOffsetfromUTC) &&
                Objects.equals(timeZoneName, machine.timeZoneName) &&
                Objects.equals(timeOffsetfromSAMInHours, machine.timeOffsetfromSAMInHours) &&
                Objects.equals(timeSent, machine.timeSent) &&
                Objects.equals(hostname, machine.hostname) &&
                Objects.equals(agentName, machine.agentName) &&
                Objects.equals(agentSocket, machine.agentSocket) &&
                Objects.equals(jorsSocket, machine.jorsSocket) &&
                Objects.equals(smaftServerPortForNonTLS, machine.smaftServerPortForNonTLS) &&
                Objects.equals(machineMaximumJobs, machine.machineMaximumJobs) &&
                Objects.equals(smaCommunicationsProtocol, machine.smaCommunicationsProtocol) &&
                Objects.equals(checkCRC, machine.checkCRC) &&
                Objects.equals(closeSocket, machine.closeSocket) &&
                Objects.equals(acceptMessagesfromIP, machine.acceptMessagesfromIP) &&
                Objects.equals(smaNetComSocket, machine.smaNetComSocket) &&
                Objects.equals(cpuid, machine.cpuid) &&
                Objects.equals(cpuType, machine.cpuType) &&
                Objects.equals(cpuModel, machine.cpuModel) &&
                Objects.equals(cpuCount, machine.cpuCount) &&
                Objects.equals(fileTransferFeature, machine.fileTransferFeature) &&
                Objects.equals(jorsFeature, machine.jorsFeature) &&
                Objects.equals(resourceMonitorFeature, machine.resourceMonitorFeature) &&
                Objects.equals(supportsHandshake, machine.supportsHandshake) &&
                Objects.equals(tlsCertificateDistinguishedName, machine.tlsCertificateDistinguishedName) &&
                Objects.equals(checkCertificateRevocationList, machine.checkCertificateRevocationList) &&
                Objects.equals(supportTLSForSMAFTAgent, machine.supportTLSForSMAFTAgent) &&
                Objects.equals(agentSupportTLSForSMAFTAgent, machine.agentSupportTLSForSMAFTAgent) &&
                Objects.equals(supportTLSForSMAFTServer, machine.supportTLSForSMAFTServer) &&
                Objects.equals(agentSupportTLSForSMAFTServer, machine.agentSupportTLSForSMAFTServer) &&
                Objects.equals(supportNonTLSForSMAFTAgent, machine.supportNonTLSForSMAFTAgent) &&
                Objects.equals(agentSupportNonTLSForSMAFTAgent, machine.agentSupportNonTLSForSMAFTAgent) &&
                Objects.equals(supportNonTLSForSMAFTServer, machine.supportNonTLSForSMAFTServer) &&
                Objects.equals(agentSupportNonTLSForSMAFTServer, machine.agentSupportNonTLSForSMAFTServer) &&
                Objects.equals(agentSpecialFeatures, machine.agentSpecialFeatures) &&
                Objects.equals(hpNonStopIPAddress, machine.hpNonStopIPAddress) &&
                Objects.equals(hpNonStopSocketNumber, machine.hpNonStopSocketNumber) &&
                Objects.equals(smaftAgentPort, machine.smaftAgentPort) &&
                Objects.equals(tlsCertificateSerialNumber, machine.tlsCertificateSerialNumber) &&
                Objects.equals(documentation, machine.documentation);
    }

    @Override
    public int hashCode() {
        return Objects
                .hash(id, name, status, version, osVersion, osType, useTLSforSchedulingCommunications, socket, gatewayId, groups, lastUpdate, maximumJobs, opconMaximumJobs, currentJobs, requiresXMLEscape, agentSMACommunicationsProtocol, allowKillJob, tcpIpAddress, pollInterval, checkMachineStatusInterval, connectionAttemptTimeout, noBufferRetryCount, noBufferSleepTime, maxConsecutiveSendMessages, consecutiveSendSleepTime, sendBufferCount, receiveBufferCount, maxBytesSentPerMessage, maxBytesReadPerMessage,
                        responseTimeout, agentCheckCRC, closeSocketDuringSynchronization, traceAllMessages, smaNetComIdentifier, gatewayName, jorsPortNumber, fileTransferRole, fileTransferIPAddress, availableProperties, fileTransferPortNumberForNonTLS, fileTransferPortNumberForTLS, agentFileTransferPortNumberForTLS, lsamTime, lsamTimeDeltafromSAM, fullyQualifiedDomainName, fullFileTransferSupport, timeOffsetfromUTC, timeZoneName, timeOffsetfromSAMInHours, timeSent, hostname, agentName, agentSocket,
                        jorsSocket,
                        smaftServerPortForNonTLS, machineMaximumJobs, smaCommunicationsProtocol, checkCRC, closeSocket, acceptMessagesfromIP, smaNetComSocket, cpuid, cpuType, cpuModel, cpuCount, fileTransferFeature, jorsFeature, resourceMonitorFeature, supportsHandshake, tlsCertificateDistinguishedName, checkCertificateRevocationList, supportTLSForSMAFTAgent, agentSupportTLSForSMAFTAgent, supportTLSForSMAFTServer, agentSupportTLSForSMAFTServer, supportNonTLSForSMAFTAgent, agentSupportNonTLSForSMAFTAgent,
                        supportNonTLSForSMAFTServer, agentSupportNonTLSForSMAFTServer, agentSpecialFeatures, hpNonStopIPAddress, hpNonStopSocketNumber, smaftAgentPort, tlsCertificateSerialNumber, documentation);
    }
}
