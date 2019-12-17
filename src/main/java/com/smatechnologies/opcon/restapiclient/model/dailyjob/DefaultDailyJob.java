package com.smatechnologies.opcon.restapiclient.model.dailyjob;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * @author Pierre PINON
 */
@JsonIgnoreProperties("details") //To avoid error on non implemented job type
public class DefaultDailyJob extends DailyJob {

}
