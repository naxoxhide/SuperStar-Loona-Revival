package com.tapjoy.internal;

import com.tapjoy.TJCacheListener;
import com.tapjoy.TapjoyCache;
import com.tapjoy.TapjoyLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes4.dex */
public final class da extends Thread {
    public final /* synthetic */ JSONArray a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TJCacheListener f2746b;
    public final /* synthetic */ TapjoyCache c;

    public da(TapjoyCache tapjoyCache, JSONArray jSONArray, TJCacheListener tJCacheListener) {
        this.c = tapjoyCache;
        this.a = jSONArray;
        this.f2746b = tJCacheListener;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        TapjoyLog.d("TapjoyCache", "Starting to cache asset group size of " + this.a.length());
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.a.length(); i++) {
            try {
                Future<Boolean> futureCacheAssetFromJSONObject = this.c.cacheAssetFromJSONObject(this.a.getJSONObject(i));
                if (futureCacheAssetFromJSONObject != null) {
                    arrayList.add(futureCacheAssetFromJSONObject);
                }
            } catch (JSONException unused) {
                TapjoyLog.e("TapjoyCache", "Failed to load JSON object from JSONArray");
            }
        }
        Iterator it = arrayList.iterator();
        int i2 = 1;
        while (it.hasNext()) {
            try {
                if (!((Boolean) ((Future) it.next()).get()).booleanValue()) {
                    i2 = 2;
                }
            } catch (InterruptedException e) {
                TapjoyLog.e("TapjoyCache", "Caching thread failed: " + e.toString());
            } catch (ExecutionException e2) {
                TapjoyLog.e("TapjoyCache", "Caching thread failed: " + e2.toString());
            }
        }
        TapjoyLog.d("TapjoyCache", "Finished caching group");
        TJCacheListener tJCacheListener = this.f2746b;
        if (tJCacheListener != null) {
            tJCacheListener.onCachingComplete(i2);
        }
    }
}
