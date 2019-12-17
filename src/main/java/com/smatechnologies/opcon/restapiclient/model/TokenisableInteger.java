package com.smatechnologies.opcon.restapiclient.model;

/**
 * @author Pierre PINON
 */
public class TokenisableInteger extends Tokenisable<Integer> {

    public TokenisableInteger(Integer integer) {
        super(integer);
    }

    public TokenisableInteger(String token) {
        super(token);
    }

    public TokenisableInteger() {

    }
}
