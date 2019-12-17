package com.smatechnologies.opcon.restapiclient.model;

import com.fasterxml.jackson.annotation.JsonValue;

import java.time.ZonedDateTime;


/**
 * @author Pierre PINON
 */
public class Token {

    public static final String RESOURCE = "token";

    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_USER = "user";
    public static final String PROPERTY_TOKEN_TYPE = "tokenType";
    public static final String PROPERTY_VALID_FROM = "validFrom";
    public static final String PROPERTY_VALID_UNTIL = "validUntil";

    private String id;
    private User user;
    private TokenType tokenType;
    private ZonedDateTime validFrom;
    private ZonedDateTime validUntil;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TokenType getTokenType() {
        return tokenType;
    }

    public void setTokenType(TokenType tokenType) {
        this.tokenType = tokenType;
    }

    public ZonedDateTime getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(ZonedDateTime validFrom) {
        this.validFrom = validFrom;
    }

    public ZonedDateTime getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(ZonedDateTime validUntil) {
        this.validUntil = validUntil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Token token = (Token) o;

        if (id != null ? !id.equals(token.id) : token.id != null)
            return false;
        if (user != null ? !user.equals(token.user) : token.user != null)
            return false;
        if (tokenType != null ? !tokenType.equals(token.tokenType) : token.tokenType != null)
            return false;
        if (validFrom != null ? !validFrom.equals(token.validFrom) : token.validFrom != null)
            return false;
        return validUntil != null ? validUntil.equals(token.validUntil) : token.validUntil == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (tokenType != null ? tokenType.hashCode() : 0);
        result = 31 * result + (validFrom != null ? validFrom.hashCode() : 0);
        result = 31 * result + (validUntil != null ? validUntil.hashCode() : 0);
        return result;
    }

    public static class TokenType {

        public static final String RESOURCE = "tokenType";

        public static final String PROPERTY_ID = "id";
        public static final String PROPERTY_TYPE = "type";

        private String id;
        private Type type;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Type getType() {
            return type;
        }

        public void setType(Type type) {
            this.type = type;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            TokenType tokenType = (TokenType) o;

            if (id != null ? !id.equals(tokenType.id) : tokenType.id != null)
                return false;
            return type == tokenType.type;

        }

        @Override
        public int hashCode() {
            int result = id != null ? id.hashCode() : 0;
            result = 31 * result + (type != null ? type.hashCode() : 0);
            return result;
        }

        public enum Type {
            USER("User"),
            APPLICATION("Application");

            private final String value;

            Type(String value) {
                this.value = value;
            }

            @JsonValue
            public String value() {
                return value;
            }
        }
    }
}
