package com.applovin.impl.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a implements Application.ActivityLifecycleCallbacks {
    private final List<com.applovin.impl.sdk.utils.a> ayJ = Collections.synchronizedList(new ArrayList());
    private WeakReference<Activity> ayK;
    private WeakReference<Activity> ayL;

    public a(Context context) {
        this.ayK = new WeakReference<>(null);
        this.ayL = new WeakReference<>(null);
        x.D("AppLovinSdk", "Attaching Activity lifecycle manager...");
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            this.ayK = new WeakReference<>(activity);
            if (activity.hasWindowFocus()) {
                this.ayL = this.ayK;
            }
        }
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(this);
    }

    public Activity Ax() {
        return this.ayK.get();
    }

    public Activity Ay() {
        return this.ayL.get();
    }

    public void a(com.applovin.impl.sdk.utils.a aVar) {
        this.ayJ.add(aVar);
    }

    public void b(com.applovin.impl.sdk.utils.a aVar) {
        this.ayJ.remove(aVar);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Iterator it = new ArrayList(this.ayJ).iterator();
        while (it.hasNext()) {
            ((com.applovin.impl.sdk.utils.a) it.next()).onActivityCreated(activity, bundle);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Iterator it = new ArrayList(this.ayJ).iterator();
        while (it.hasNext()) {
            ((com.applovin.impl.sdk.utils.a) it.next()).onActivityStarted(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        WeakReference<Activity> weakReference = new WeakReference<>(activity);
        this.ayK = weakReference;
        this.ayL = weakReference;
        Iterator it = new ArrayList(this.ayJ).iterator();
        while (it.hasNext()) {
            ((com.applovin.impl.sdk.utils.a) it.next()).onActivityResumed(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        this.ayL = new WeakReference<>(null);
        Iterator it = new ArrayList(this.ayJ).iterator();
        while (it.hasNext()) {
            ((com.applovin.impl.sdk.utils.a) it.next()).onActivityPaused(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Iterator it = new ArrayList(this.ayJ).iterator();
        while (it.hasNext()) {
            ((com.applovin.impl.sdk.utils.a) it.next()).onActivityStopped(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Iterator it = new ArrayList(this.ayJ).iterator();
        while (it.hasNext()) {
            ((com.applovin.impl.sdk.utils.a) it.next()).onActivitySaveInstanceState(activity, bundle);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Iterator it = new ArrayList(this.ayJ).iterator();
        while (it.hasNext()) {
            ((com.applovin.impl.sdk.utils.a) it.next()).onActivityDestroyed(activity);
        }
    }
}
