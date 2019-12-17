package com.smatechnologies.opcon.restapiclient.api.tokens;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.Token;
import com.smatechnologies.opcon.restapiclient.model.User;

import java.util.Objects;


/**
 * Web Services proxy for Tokens (ws authentication mechanism).
 *
 * @author Francois EYL
 */
public class WsTokens {

    public final static int API_ERROR_USER_DISABLED = 2003;

    public final static String HEADER_KEY = "Authorization";
    public final static String HEADER_VALUE_PREFIX = "Token ";

    private final WsFactory wsFactory;

    public WsTokens(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("tokens");
    }

    public Token get(String tokenId) throws WsException {
        Objects.requireNonNull(tokenId, "TokenId cannot be null");

        return wsFactory.create(Ws.Type.GET).token(false).header(HEADER_KEY, HEADER_VALUE_PREFIX + tokenId).run(Token.class);
    }

    public Token postUser(String loginName) throws WsException {
        Objects.requireNonNull(loginName, "LoginName cannot be null");

        Token token = buildToken(loginName, null, buildTokenType(Token.TokenType.Type.USER, null));
        return wsFactory.create(Ws.Type.POST, token).run(Token.class);
    }

    public Token postUser(String loginName, String password) throws WsException {
        Objects.requireNonNull(loginName, "LoginName cannot be null");
        Objects.requireNonNull(password, "Password cannot be null");

        Token token = buildToken(loginName, password, buildTokenType(Token.TokenType.Type.USER, null));
        return wsFactory.create(Ws.Type.POST, token).token(false).run(Token.class);
    }

    public Token postApp(String loginName, String password, String tokenTypeId) throws WsException {
        Objects.requireNonNull(loginName, "LoginName cannot be null");
        Objects.requireNonNull(password, "Password cannot be null");
        Objects.requireNonNull(tokenTypeId, "TokenTypeId cannot be null");

        Token token = buildToken(loginName, password, buildTokenType(Token.TokenType.Type.APPLICATION, tokenTypeId));
        return wsFactory.create(Ws.Type.POST, token).token(false).run(Token.class);
    }

    public void delete() throws WsException {
        wsFactory.create(Ws.Type.DELETE).run();
    }

    private static Token buildToken(String loginName, String password, Token.TokenType tokenType) {
        User user = new User();
        user.setLoginName(loginName);
        user.setPassword(password);

        Token token = new Token();
        token.setUser(user);
        token.setTokenType(tokenType);

        return token;
    }

    private static Token.TokenType buildTokenType(Token.TokenType.Type type, String id) {
        Token.TokenType tokenType = new Token.TokenType();
        tokenType.setType(type);
        tokenType.setId(id);

        return tokenType;
    }
}
