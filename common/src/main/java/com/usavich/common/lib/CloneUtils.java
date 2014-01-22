package com.usavich.common.lib;

import com.esotericsoftware.kryo.Kryo;

/**
 * Created with IntelliJ IDEA.
 * User: p
 * Date: 13-11-14
 * Time: 上午11:05
 * To change this template use File | Settings | File Templates.
 */
public final class CloneUtils {

    private static ThreadLocal<Kryo> kryo = new ThreadLocal<Kryo>();

    private CloneUtils() {
    }

    public static <T> T clone(T source) {
        if (source == null)
            return null;

        return kryoClone(source);
    }

    @SuppressWarnings("unchecked")
    public static <T> T kryoClone(T source) {
        if (source == null) {
            return null;
        }

        T result = source;
        try {
            result = getOrCreateLocalKryo().copy(source);
        } catch (Exception e) {
            // ignore
        }

        return result;
    }

    private static Kryo getOrCreateLocalKryo() {
        Kryo localKryo = kryo.get();
        if (localKryo == null) {
            localKryo = new Kryo();
            kryo.set(localKryo);
        }

        return localKryo;
    }

}
