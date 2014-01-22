package com.usavich.common.lib;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 3/5/13
 * Time: 4:44 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Func<I, O> {
    O execute(I param);
}
