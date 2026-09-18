package com.applovin.impl.sdk;

import android.os.Process;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.tapjoy.TJAdUnitConstants;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class AppLovinExceptionHandler implements Thread.UncaughtExceptionHandler {
    private static final AppLovinExceptionHandler azN = new AppLovinExceptionHandler();
    private Thread.UncaughtExceptionHandler azP;
    private final Set<n> azO = new HashSet(2);
    private final AtomicBoolean amr = new AtomicBoolean();

    public static AppLovinExceptionHandler shared() {
        return azN;
    }

    public void enable() {
        if (this.amr.compareAndSet(false, true)) {
            this.azP = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    public void addSdk(n nVar) {
        this.azO.add(nVar);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        long jLongValue = 500;
        for (n nVar : this.azO) {
            if (!nVar.Bo()) {
                nVar.BL();
                if (x.Fk()) {
                    nVar.BL().f("AppLovinExceptionHandler", "Detected unhandled exception");
                }
                nVar.Cq().a(r.a.CRASH, CollectionUtils.map("top_main_method", th.toString()));
                nVar.BD().trackEventSynchronously(TJAdUnitConstants.String.VIDEO_PAUSED);
                jLongValue = ((Long) nVar.a(com.applovin.impl.sdk.c.b.aOb)).longValue();
            }
        }
        try {
            Thread.sleep(jLongValue);
        } catch (InterruptedException unused) {
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.azP;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        } else {
            Process.killProcess(Process.myPid());
            System.exit(1);
        }
    }
}
