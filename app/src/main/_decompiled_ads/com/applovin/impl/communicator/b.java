package com.applovin.impl.communicator;

import android.content.Intent;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.x;
import java.lang.ref.WeakReference;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class b implements AppLovinBroadcastManager.Receiver {
    private final String akc;
    private final WeakReference<AppLovinCommunicatorSubscriber> akd;
    private boolean akb = true;
    private final Set<String> ake = new LinkedHashSet();
    private final Object akf = new Object();

    b(String str, AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber) {
        this.akc = str;
        this.akd = new WeakReference<>(appLovinCommunicatorSubscriber);
    }

    public String getTopic() {
        return this.akc;
    }

    public AppLovinCommunicatorSubscriber tu() {
        return this.akd.get();
    }

    public boolean isActive() {
        return this.akb;
    }

    public void ax(boolean z) {
        this.akb = z;
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map<String, Object> map) {
        if (tu() == null) {
            x.H("AppLovinCommunicator", "Message received for GC'd subscriber");
            return;
        }
        CommunicatorMessageImpl communicatorMessageImpl = (CommunicatorMessageImpl) intent;
        boolean z = false;
        synchronized (this.akf) {
            if (!this.ake.contains(communicatorMessageImpl.getUniqueId())) {
                this.ake.add(communicatorMessageImpl.getUniqueId());
                z = true;
            }
        }
        if (z) {
            tu().onMessageReceived((AppLovinCommunicatorMessage) communicatorMessageImpl);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber = this.akd.get();
        b bVar = (b) obj;
        AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber2 = bVar.akd.get();
        if (getTopic().equals(bVar.getTopic())) {
            if (appLovinCommunicatorSubscriber != null) {
                if (appLovinCommunicatorSubscriber.equals(appLovinCommunicatorSubscriber2)) {
                    return true;
                }
            } else if (appLovinCommunicatorSubscriber == appLovinCommunicatorSubscriber2) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = this.akc.hashCode();
        AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber = this.akd.get();
        return (iHashCode * 31) + (appLovinCommunicatorSubscriber != null ? appLovinCommunicatorSubscriber.hashCode() : 0);
    }
}
