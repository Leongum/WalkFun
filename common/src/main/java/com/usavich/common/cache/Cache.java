package com.usavich.common.cache;

import com.usavich.common.lib.Callable;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: p
 * Date: 13-11-14
 * Time: 上午10:41
 * To change this template use File | Settings | File Templates.
 */
public interface Cache {
    <V> void put(String key, V value);

    <V> V get(String key);

    <V> V get(String key, Callable<V> call);

    void evict(String key);

    void evictAll();

    List<String> getAllKeys();
}
