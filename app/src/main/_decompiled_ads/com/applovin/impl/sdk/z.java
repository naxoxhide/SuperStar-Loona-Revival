package com.applovin.impl.sdk;

import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
class z {
    private final Queue<AppLovinAdImpl> aFq = new LinkedList();
    private final Object aFr = new Object();

    z() {
    }

    int Fn() {
        int size;
        synchronized (this.aFr) {
            size = this.aFq.size();
        }
        return size;
    }

    boolean isEmpty() {
        boolean z;
        synchronized (this.aFr) {
            z = Fn() == 0;
        }
        return z;
    }

    void c(AppLovinAdImpl appLovinAdImpl) {
        synchronized (this.aFr) {
            if (Fn() <= 25) {
                this.aFq.offer(appLovinAdImpl);
            } else {
                x.H("AppLovinSdk", "Maximum queue capacity reached - discarding ad...");
            }
        }
    }

    AppLovinAdImpl Fo() {
        AppLovinAdImpl appLovinAdImplPoll;
        synchronized (this.aFr) {
            appLovinAdImplPoll = !isEmpty() ? this.aFq.poll() : null;
        }
        return appLovinAdImplPoll;
    }

    AppLovinAdImpl Fp() {
        AppLovinAdImpl appLovinAdImplPeek;
        synchronized (this.aFr) {
            appLovinAdImplPeek = this.aFq.peek();
        }
        return appLovinAdImplPeek;
    }

    void d(AppLovinAdImpl appLovinAdImpl) {
        synchronized (this.aFr) {
            this.aFq.remove(appLovinAdImpl);
        }
    }
}
