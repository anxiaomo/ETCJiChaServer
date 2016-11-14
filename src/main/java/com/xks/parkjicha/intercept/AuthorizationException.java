package com.xks.parkjicha.intercept;


/**
 * Created by Anxiaomo on 2016/11/11.
 */
public class AuthorizationException extends Exception {
    public AuthorizationException() {
    }

    public AuthorizationException(String smg) {
        super(smg);
    }
}
