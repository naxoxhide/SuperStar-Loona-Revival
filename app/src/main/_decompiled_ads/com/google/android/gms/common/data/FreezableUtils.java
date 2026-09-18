package com.google.android.gms.common.data;

import com.fyber.inneractive.sdk.flow.vast.j;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class FreezableUtils {
    public static <T, E extends Freezable<T>> ArrayList<T> freeze(ArrayList<E> arrayList) {
        j jVar = (ArrayList<T>) new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            jVar.add(arrayList.get(i).freeze());
        }
        return jVar;
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freezeIterable(Iterable<E> iterable) {
        j jVar = (ArrayList<T>) new ArrayList();
        Iterator<E> it = iterable.iterator();
        while (it.hasNext()) {
            jVar.add(it.next().freeze());
        }
        return jVar;
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freeze(E[] eArr) {
        j jVar = (ArrayList<T>) new ArrayList(eArr.length);
        for (E e : eArr) {
            jVar.add(e.freeze());
        }
        return jVar;
    }
}
