package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzfyy extends zzfyh.zzi {
    private static final zzfyu zzbb;
    private static final Logger zzbc = Logger.getLogger(zzfyy.class.getName());
    private volatile int remaining;

    @CheckForNull
    private volatile Set<Throwable> seenExceptions = null;

    static {
        zzfyu zzfyxVar;
        Throwable th;
        zzfyw zzfywVar = null;
        try {
            zzfyxVar = new zzfyv(AtomicReferenceFieldUpdater.newUpdater(zzfyy.class, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(zzfyy.class, "remaining"));
            th = null;
        } catch (Error | RuntimeException e) {
            zzfyxVar = new zzfyx(zzfywVar);
            th = e;
        }
        zzbb = zzfyxVar;
        if (th != null) {
            zzbc.logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFutureState", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
    }

    zzfyy(int i) {
        this.remaining = i;
    }

    final int zzA() {
        return zzbb.zza(this);
    }

    final Set zzC() {
        Set<Throwable> set = this.seenExceptions;
        if (set != null) {
            return set;
        }
        Set setNewSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
        zze(setNewSetFromMap);
        zzbb.zzb(this, null, setNewSetFromMap);
        Set<Throwable> set2 = this.seenExceptions;
        set2.getClass();
        return set2;
    }

    final void zzF() {
        this.seenExceptions = null;
    }

    abstract void zze(Set set);
}
