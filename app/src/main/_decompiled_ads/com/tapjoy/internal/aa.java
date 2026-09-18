package com.tapjoy.internal;

import android.app.Application;
import android.content.Context;
import com.tapjoy.TJConnectListener;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes4.dex */
public final class aa {
    public final ReentrantLock a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Condition f2730b;
    public volatile int c;
    public final LinkedList d;
    public ja e;
    public long f;
    public ga g;
    public ga h;
    public final /* synthetic */ ba i;

    public aa(ba baVar) {
        this.i = baVar;
        ReentrantLock reentrantLock = new ReentrantLock();
        this.a = reentrantLock;
        this.f2730b = reentrantLock.newCondition();
        this.c = 1;
        this.d = new LinkedList();
        this.f = 1000L;
    }

    public static Context a(Context context) {
        Context applicationContext;
        if (context != null) {
            applicationContext = context instanceof Application ? context : context.getApplicationContext();
        } else {
            applicationContext = null;
        }
        return applicationContext != null ? applicationContext : context;
    }

    public final boolean a(Context context, String str, Hashtable hashtable, TJConnectListener tJConnectListener) {
        this.a.lock();
        if (tJConnectListener != null) {
            try {
                this.d.addLast(tJConnectListener);
            } catch (Throwable th) {
                this.a.unlock();
                throw th;
            }
        }
        ga gaVar = new ga(this, context, str, hashtable);
        int iB = k.b(this.c);
        if (iB == 0) {
            this.g = gaVar;
            k3.f2775b.addObserver(new ea(this));
            if (super/*com.tapjoy.e0*/.a(gaVar.a, gaVar.f2760b, gaVar.c, new fa(this))) {
                a(2);
                return true;
            }
            this.d.clear();
            this.a.unlock();
            return false;
        }
        if (iB == 1 || iB == 2) {
            this.h = gaVar;
        } else if (iB == 3) {
            this.h = gaVar;
            this.a.lock();
            try {
                this.f = 1000L;
                this.f2730b.signal();
                this.a.unlock();
            } finally {
                this.a.unlock();
            }
        } else if (iB == 4) {
            a();
        } else {
            a(1);
            this.a.unlock();
            return false;
        }
        return true;
    }

    public final void a(int i) {
        this.a.lock();
        try {
            this.c = i;
        } finally {
            this.a.unlock();
        }
    }

    public final void a() {
        this.a.lock();
        try {
            if (this.d.size() == 0) {
                this.a.unlock();
                return;
            }
            ArrayList arrayList = new ArrayList(this.d);
            this.d.clear();
            this.a.unlock();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((TJConnectListener) it.next()).onConnectSuccess();
            }
        } catch (Throwable th) {
            this.a.unlock();
            throw th;
        }
    }

    public final void a(int i, String str) {
        this.a.lock();
        try {
            if (this.d.size() == 0) {
                this.a.unlock();
                return;
            }
            ArrayList<TJConnectListener> arrayList = new ArrayList(this.d);
            this.d.clear();
            this.a.unlock();
            for (TJConnectListener tJConnectListener : arrayList) {
                tJConnectListener.onConnectFailure(i, str);
                tJConnectListener.onConnectFailure();
            }
        } catch (Throwable th) {
            this.a.unlock();
            throw th;
        }
    }

    public final void a(long j) {
        this.a.lock();
        try {
            a(4);
            if (this.f2730b.await(j, TimeUnit.MILLISECONDS)) {
                this.f = 1000L;
            }
        } catch (InterruptedException unused) {
        } finally {
            a(3);
            this.a.unlock();
        }
    }
}
