package com.usavich.common.cryptoservice;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 3/5/13
 * Time: 3:35 PM
 * To change this template use File | Settings | File Templates.
 */
public interface CryptoService {

    String encrypt(String value);

    String decrypt(String value);
}
