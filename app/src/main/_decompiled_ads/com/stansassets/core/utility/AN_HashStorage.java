package com.stansassets.core.utility;

import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public class AN_HashStorage {
    public static final int NULL_POINTER = -1;
    private static HashMap<Integer, Object> objectsMap = new HashMap<>();

    public static int add(Object obj) {
        if (obj == null) {
            AN_Logger.LogError("Attempt to link to the  NULL object: " + Thread.currentThread().getStackTrace().toString());
            return -1;
        }
        int iHashCode = obj.hashCode();
        if (!objectsMap.containsKey(Integer.valueOf(iHashCode))) {
            objectsMap.put(Integer.valueOf(iHashCode), obj);
        }
        return iHashCode;
    }

    public static void put(int i, Object obj) {
        objectsMap.put(Integer.valueOf(i), obj);
    }

    public static Object get(int i) {
        return objectsMap.get(Integer.valueOf(i));
    }

    public static void Dispose(int i) {
        if (objectsMap.containsKey(Integer.valueOf(i))) {
            AN_Logger.Log(get(i) + " object with id: " + i + " removed from hash storage");
            objectsMap.remove(Integer.valueOf(i));
        } else {
            AN_Logger.Log("failed to remove object from hash storage with id: " + i);
        }
    }
}
