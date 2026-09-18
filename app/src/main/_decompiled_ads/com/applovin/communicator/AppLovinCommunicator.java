package com.applovin.communicator;

import android.content.Context;
import com.applovin.impl.communicator.MessagingServiceImpl;
import com.applovin.impl.communicator.a;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.x;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class AppLovinCommunicator {
    private static AppLovinCommunicator x;
    private static final Object y = new Object();
    private x logger;
    private n sdk;
    private final a z = new a();
    private final MessagingServiceImpl A = new MessagingServiceImpl();

    public static AppLovinCommunicator getInstance(Context context) {
        synchronized (y) {
            if (x == null) {
                x = new AppLovinCommunicator();
            }
        }
        return x;
    }

    public boolean hasSubscriber(String str) {
        return this.z.hasSubscriber(str);
    }

    public void subscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, String str) {
        subscribe(appLovinCommunicatorSubscriber, Collections.singletonList(str));
    }

    public void subscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, List<String> list) {
        for (String str : list) {
            if (!this.z.a(appLovinCommunicatorSubscriber, str)) {
                c("Unable to subscribe " + appLovinCommunicatorSubscriber + " to topic: " + str);
            }
        }
    }

    public void unsubscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, String str) {
        unsubscribe(appLovinCommunicatorSubscriber, Collections.singletonList(str));
    }

    public void unsubscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, List<String> list) {
        for (String str : list) {
            c("Unsubscribing " + appLovinCommunicatorSubscriber + " from topic: " + str);
            this.z.unsubscribe(appLovinCommunicatorSubscriber, str);
        }
    }

    public boolean respondsToTopic(String str) {
        return this.sdk.Cf().respondsToTopic(str);
    }

    public AppLovinCommunicatorMessagingService getMessagingService() {
        return this.A;
    }

    public void a(n nVar) {
        this.sdk = nVar;
        this.logger = nVar.BL();
        c("Attached SDK instance: " + nVar + "...");
    }

    private void c(String str) {
        if (this.logger == null || !x.Fk()) {
            return;
        }
        this.logger.f("AppLovinCommunicator", str);
    }

    public String toString() {
        return "AppLovinCommunicator{sdk=" + this.sdk + '}';
    }
}
