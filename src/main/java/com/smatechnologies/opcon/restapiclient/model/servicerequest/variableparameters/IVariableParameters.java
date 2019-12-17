package com.smatechnologies.opcon.restapiclient.model.servicerequest.variableparameters;

import com.smatechnologies.opcon.restapiclient.model.servicerequest.Variable.VariableType;

import java.io.Serializable;
import java.util.Set;


/**
 * Interface that variable parameters must implement
 */
public interface IVariableParameters extends Serializable {

    VariableType getType();

    Set<String> getVariableReferences();
}
