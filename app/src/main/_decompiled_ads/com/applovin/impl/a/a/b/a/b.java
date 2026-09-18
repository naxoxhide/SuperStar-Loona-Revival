package com.applovin.impl.a.a.b.a;

import android.app.Activity;
import android.content.Context;
import com.applovin.impl.mediation.debugger.ui.d.d;
import com.applovin.impl.mediation.debugger.ui.d.e;
import com.applovin.impl.sdk.n;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class b extends d {
    private List<com.applovin.impl.a.a.a.a> akC;
    private final AtomicBoolean akD;
    private List<com.applovin.impl.mediation.debugger.ui.d.c> akE;
    private n sdk;

    public enum a {
        RECENT_ADS,
        COUNT
    }

    public b(Context context) {
        super(context);
        this.akD = new AtomicBoolean();
        this.akE = new ArrayList();
    }

    public void tJ() {
        this.akD.compareAndSet(true, false);
    }

    public boolean tK() {
        return this.akE.size() == 0;
    }

    public n getSdk() {
        return this.sdk;
    }

    public List<com.applovin.impl.a.a.a.a> tL() {
        return this.akC;
    }

    public void initialize(List<com.applovin.impl.a.a.a.a> list, n nVar) {
        Activity activityCD;
        this.sdk = nVar;
        this.akC = list;
        if (!(this.E instanceof Activity) && (activityCD = nVar.CD()) != null) {
            this.E = activityCD;
        }
        if (list != null && this.akD.compareAndSet(false, true)) {
            this.akE = n(this.akC);
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.a.a.b.a.-$$Lambda$5c4K0WqZcc7OeYtMj8iAdcPC1nE
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.notifyDataSetChanged();
            }
        });
    }

    @Override // com.applovin.impl.mediation.debugger.ui.d.d
    protected int tM() {
        return a.COUNT.ordinal();
    }

    @Override // com.applovin.impl.mediation.debugger.ui.d.d
    protected int gg(int i) {
        return this.akE.size();
    }

    @Override // com.applovin.impl.mediation.debugger.ui.d.d
    protected com.applovin.impl.mediation.debugger.ui.d.c gh(int i) {
        return new e("RECENT ADS");
    }

    @Override // com.applovin.impl.mediation.debugger.ui.d.d
    protected List<com.applovin.impl.mediation.debugger.ui.d.c> gi(int i) {
        return this.akE;
    }

    private List<com.applovin.impl.mediation.debugger.ui.d.c> n(List<com.applovin.impl.a.a.a.a> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<com.applovin.impl.a.a.a.a> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new com.applovin.impl.a.a.b.a.a.a(it.next(), this.E));
        }
        return arrayList;
    }

    public String toString() {
        return "CreativeDebuggerListAdapter{isInitialized=" + this.akD.get() + "}";
    }
}
