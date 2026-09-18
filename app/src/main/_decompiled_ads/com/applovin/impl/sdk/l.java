package com.applovin.impl.sdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
class l implements AppLovinBroadcastManager.Receiver {
    private static AlertDialog aAr;
    private static final AtomicBoolean aAs = new AtomicBoolean();
    private final m aAq;
    private com.applovin.impl.sdk.utils.r ayR;

    public interface a {
        void Bc();

        void Bd();
    }

    l(m mVar, n nVar) {
        this.aAq = mVar;
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_RESUMED));
    }

    public void a(long j, final n nVar, final a aVar) {
        if (j <= 0) {
            return;
        }
        AlertDialog alertDialog = aAr;
        if (alertDialog == null || !alertDialog.isShowing()) {
            if (aAs.getAndSet(true)) {
                if (j < this.ayR.AF()) {
                    nVar.BL();
                    if (x.Fk()) {
                        nVar.BL().f("ConsentAlertManager", "Scheduling consent alert earlier (" + j + "ms) than remaining scheduled time (" + this.ayR.AF() + "ms)");
                    }
                    this.ayR.tT();
                } else {
                    nVar.BL();
                    if (x.Fk()) {
                        nVar.BL().h("ConsentAlertManager", "Skip scheduling consent alert - one scheduled already with remaining time of " + this.ayR.AF() + " milliseconds");
                        return;
                    }
                    return;
                }
            }
            nVar.BL();
            if (x.Fk()) {
                nVar.BL().f("ConsentAlertManager", "Scheduling consent alert for " + j + " milliseconds");
            }
            this.ayR = com.applovin.impl.sdk.utils.r.b(j, nVar, new Runnable() { // from class: com.applovin.impl.sdk.-$$Lambda$l$XL-alV_oekWyq06qNNKPk7QoRpk
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(nVar, aVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final n nVar, final a aVar) {
        if (this.aAq.Be()) {
            nVar.BL();
            if (x.Fk()) {
                nVar.BL().i("ConsentAlertManager", "Consent dialog already showing, skip showing of consent alert");
                return;
            }
            return;
        }
        Activity activityAx = nVar.BK().Ax();
        if (activityAx == null || !com.applovin.impl.sdk.utils.i.Y(n.getApplicationContext())) {
            if (activityAx == null) {
                nVar.BL();
                if (x.Fk()) {
                    nVar.BL().i("ConsentAlertManager", "No parent Activity found - rescheduling consent alert...");
                }
            } else {
                nVar.BL();
                if (x.Fk()) {
                    nVar.BL().i("ConsentAlertManager", "No internet available - rescheduling consent alert...");
                }
            }
            aAs.set(false);
            a(((Long) nVar.a(com.applovin.impl.sdk.c.b.aLa)).longValue(), nVar, aVar);
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.-$$Lambda$l$8YTNPykaxuBkv-wu-a99Qyohcgg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(nVar, aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(final n nVar, final a aVar) {
        AlertDialog alertDialogCreate = new AlertDialog.Builder(nVar.BK().Ax()).setTitle((CharSequence) nVar.a(com.applovin.impl.sdk.c.b.aLb)).setMessage((CharSequence) nVar.a(com.applovin.impl.sdk.c.b.aLc)).setCancelable(false).setPositiveButton((CharSequence) nVar.a(com.applovin.impl.sdk.c.b.aLd), new DialogInterface.OnClickListener() { // from class: com.applovin.impl.sdk.-$$Lambda$l$LmGDmoLxMFWzm8Ub4kDvZ_VOrMI
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                l.a(aVar, dialogInterface, i);
            }
        }).setNegativeButton((CharSequence) nVar.a(com.applovin.impl.sdk.c.b.aLe), new DialogInterface.OnClickListener() { // from class: com.applovin.impl.sdk.-$$Lambda$l$qbxXVyr7AG13X109km54zl2dFjA
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.a(aVar, nVar, dialogInterface, i);
            }
        }).create();
        aAr = alertDialogCreate;
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(a aVar, DialogInterface dialogInterface, int i) {
        aVar.Bc();
        dialogInterface.dismiss();
        aAs.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(a aVar, n nVar, DialogInterface dialogInterface, int i) {
        aVar.Bd();
        dialogInterface.dismiss();
        aAs.set(false);
        a(((Long) nVar.a(com.applovin.impl.sdk.c.b.aKZ)).longValue(), nVar, aVar);
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map<String, Object> map) {
        if (this.ayR == null) {
            return;
        }
        String action = intent.getAction();
        if (SessionTracker.ACTION_APPLICATION_PAUSED.equals(action)) {
            this.ayR.pause();
        } else if (SessionTracker.ACTION_APPLICATION_RESUMED.equals(action)) {
            this.ayR.resume();
        }
    }
}
