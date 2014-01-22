package com.usavich.service.Cache;

import com.usavich.common.cache.Cache;
import com.usavich.common.lib.Callable;

import java.util.List;

import com.usavich.common.lib.CloneUtils;
import net.sf.ehcache.*;

/**
 * Created with IntelliJ IDEA.
 * User: p
 * Date: 13-11-14
 * Time: 上午10:46
 * To change this template use File | Settings | File Templates.
 */
public enum CacheFacade implements Cache {
    PLAN;

    private Ehcache internal = CacheManager.getInstance().getCache(this.name());

    @Override
    public <V> void put(String key, V value) {
        internal.put(new Element(normalize(key), CloneUtils.clone(value)));
    }

    @Override
    public <V> V get(String key) {

        Element element = internal.get(normalize(key));
        return element == null ? null : CloneUtils.clone((V) element.getObjectValue());
    }

    @Override
    public <V> V get(String key, Callable<V> call) {

        key = normalize(key);
        V value = (V) get(key);

        if (!internal.isKeyInCache(key) || internal.get(key) == null) {
            value = call.execute();
            put(key, value);
        }

        return value;
    }

    @Override
    public void evict(String key) {
        internal.remove(normalize(key));
    }

    @Override
    public void evictAll() {
        internal.removeAll();
    }

    @Override
    public List<String> getAllKeys() {
        return internal.getKeys();
    }

    private String normalize(String key) {
        return key == null ? null : key.toLowerCase();
    }
}
