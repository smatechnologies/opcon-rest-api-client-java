package com.smatechnologies.opcon.restapiclient.model;

import java.util.Objects;


public abstract class Tokenisable<T> {

    private T t;
    private String token;

    public Tokenisable() {

    }

    public Tokenisable(T t) {
        if (t == null) {
            throw new IllegalArgumentException("t cannot be null");
        }

        this.t = t;
        this.token = null;
    }

    public Tokenisable(String token) {
        if (token == null) {
            throw new IllegalArgumentException("Token cannot be null");
        }

        this.t = null;
        this.token = token;
    }

    public T getT() {
        return t;
    }

    public String getToken() {
        return token;
    }

    public boolean isToken() {
        return token != null;
    }

    public void setT(T t) {
        this.t = t;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Tokenisable<?> that = (Tokenisable<?>) o;
        return Objects.equals(t, that.t) &&
                Objects.equals(token, that.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(t, token);
    }
}
