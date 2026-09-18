package com.applovin.impl.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class i extends BroadcastReceiver implements AppLovinBroadcastManager.Receiver {
    public static int azY = -1;
    private final Context E;
    private final AudioManager K;
    private boolean aAb;
    private int aAc;
    private final n sdk;
    private final Set<a> azZ = new HashSet();
    private final Object aAa = new Object();

    public interface a {
        void ge(int i);
    }

    public static boolean gv(int i) {
        return i == 0 || i == 1;
    }

    i(n nVar) {
        this.sdk = nVar;
        Context applicationContext = n.getApplicationContext();
        this.E = applicationContext;
        this.K = (AudioManager) applicationContext.getSystemService("audio");
    }

    public int AT() {
        return this.K.getRingerMode();
    }

    public void a(a aVar) {
        synchronized (this.aAa) {
            if (this.azZ.contains(aVar)) {
                return;
            }
            this.azZ.add(aVar);
            if (this.azZ.size() == 1) {
                AU();
            }
        }
    }

    public void b(a aVar) {
        synchronized (this.aAa) {
            if (this.azZ.contains(aVar)) {
                this.azZ.remove(aVar);
                if (this.azZ.isEmpty()) {
                    AV();
                }
            }
        }
    }

    private void AU() {
        this.sdk.BL();
        if (x.Fk()) {
            this.sdk.BL().f("AudioSessionManager", "Observing ringer mode...");
        }
        this.aAc = azY;
        this.E.registerReceiver(this, new IntentFilter("android.media.RINGER_MODE_CHANGED"));
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_RESUMED));
    }

    private void AV() {
        this.sdk.BL();
        if (x.Fk()) {
            this.sdk.BL().f("AudioSessionManager", "Stopping observation of mute switch state...");
        }
        this.E.unregisterReceiver(this);
        AppLovinBroadcastManager.unregisterReceiver(this);
    }

    private void gw(final int i) {
        if (this.aAb) {
            return;
        }
        this.sdk.BL();
        if (x.Fk()) {
            this.sdk.BL().f("AudioSessionManager", "Ringer mode is " + i);
        }
        synchronized (this.aAa) {
            for (final a aVar : this.azZ) {
                AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.-$$Lambda$i$6ZWb368ViejobCeJ_eMEcp1OSso
                    @Override // java.lang.Runnable
                    public final void run() {
                        aVar.ge(i);
                    }
                });
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.media.RINGER_MODE_CHANGED".equals(intent.getAction())) {
            gw(this.K.getRingerMode());
        }
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map<String, Object> map) {
        String action = intent.getAction();
        if (SessionTracker.ACTION_APPLICATION_PAUSED.equals(action)) {
            this.aAb = true;
            this.aAc = this.K.getRingerMode();
        } else if (SessionTracker.ACTION_APPLICATION_RESUMED.equals(action)) {
            this.aAb = false;
            if (this.aAc != this.K.getRingerMode()) {
                this.aAc = azY;
                gw(this.K.getRingerMode());
            }
        }
    }
}
