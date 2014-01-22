package com.usavich.common.exception;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 6/19/13
 * Time: 11:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class ServerRequestException extends RuntimeException {

    public ServerRequestException(String message) {
        super(message);
    }
}
