package com.applovin.impl.communicator;

import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorMessagingService;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public class MessagingServiceImpl implements AppLovinCommunicatorMessagingService {
    private ScheduledThreadPoolExecutor ajX;
    private final Object ajY = new Object();

    public String toString() {
        return "MessagingServiceImpl{}";
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorMessagingService
    public void publish(final AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutorTt = tt();
        this.ajX = scheduledThreadPoolExecutorTt;
        scheduledThreadPoolExecutorTt.execute(new Runnable() { // from class: com.applovin.impl.communicator.-$$Lambda$MessagingServiceImpl$091f7fB0N0JCT7LEULoZZPDCXzc
            @Override // java.lang.Runnable
            public final void run() {
                AppLovinBroadcastManager.sendBroadcastSync(appLovinCommunicatorMessage, null);
            }
        });
    }

    private ScheduledThreadPoolExecutor tt() {
        synchronized (this.ajY) {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.ajX;
            if (scheduledThreadPoolExecutor != null) {
                return scheduledThreadPoolExecutor;
            }
            return new ScheduledThreadPoolExecutor(1, new ThreadFactory() { // from class: com.applovin.impl.communicator.-$$Lambda$MessagingServiceImpl$WFclmPBwXPYKeRNMak6Q9LVcOvs
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    return MessagingServiceImpl.f(runnable);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Thread f(Runnable runnable) {
        Thread thread = new Thread(runnable, "AppLovinSdk:communicator");
        thread.setPriority(1);
        thread.setDaemon(true);
        return thread;
    }
}
