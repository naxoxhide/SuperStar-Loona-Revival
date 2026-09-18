package com.fyber.inneractive.sdk.bidder;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.util.l;

/* JADX INFO: loaded from: classes2.dex */
public class e extends BroadcastReceiver {
    public final d a;

    public e(d dVar) {
        this.a = dVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || intent.getAction() == null) {
            return;
        }
        String action = intent.getAction();
        action.getClass();
        action.hashCode();
        boolean z = false;
        switch (action) {
            case "android.intent.action.BATTERY_CHANGED":
                a aVar = (a) this.a;
                aVar.f842b.getClass();
                int intExtra = intent.getIntExtra("plugged", -1);
                z = intExtra == 1 || intExtra == 2 || intExtra == 4;
                Boolean bool = aVar.c.B;
                if (bool == null || bool.booleanValue() != z) {
                    aVar.c.B = Boolean.valueOf(z);
                    aVar.b();
                }
                if (!TextUtils.equals(aVar.c.C, aVar.f842b.a(intent))) {
                    aVar.c.C = aVar.f842b.a(intent);
                    aVar.b();
                    break;
                }
                break;
            case "android.bluetooth.adapter.action.STATE_CHANGED":
            case "android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED":
                a aVar2 = (a) this.a;
                aVar2.getClass();
                Boolean bool2 = intent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", Integer.MIN_VALUE) == 2 ? Boolean.TRUE : null;
                c cVar = aVar2.c;
                if (cVar.t != bool2) {
                    cVar.t = bool2;
                    aVar2.b();
                    break;
                }
                break;
            case "android.intent.action.AIRPLANE_MODE":
                a aVar3 = (a) this.a;
                aVar3.c.w = Boolean.valueOf(intent.getBooleanExtra("state", false));
                aVar3.b();
                break;
            case "android.os.action.POWER_SAVE_MODE_CHANGED":
                a aVar4 = (a) this.a;
                aVar4.c.u = com.fyber.inneractive.sdk.serverapi.a.l();
                aVar4.b();
                break;
            case "android.media.RINGER_MODE_CHANGED":
                a aVar5 = (a) this.a;
                aVar5.getClass();
                int intExtra2 = intent.getIntExtra("android.media.EXTRA_RINGER_MODE", -1);
                z = intExtra2 == 0 || intExtra2 == 1;
                Boolean bool3 = aVar5.c.y;
                if (bool3 == null || bool3.booleanValue() != z) {
                    aVar5.c.y = Boolean.valueOf(z);
                    aVar5.b();
                    break;
                }
                break;
            case "android.app.action.INTERRUPTION_FILTER_CHANGED":
                a aVar6 = (a) this.a;
                aVar6.getClass();
                int currentInterruptionFilter = ((NotificationManager) l.a.getSystemService("notification")).getCurrentInterruptionFilter();
                if (currentInterruptionFilter >= 2 && currentInterruptionFilter <= 4) {
                    z = true;
                }
                Boolean bool4 = aVar6.c.x;
                if (bool4 == null || bool4.booleanValue() != z) {
                    aVar6.c.x = Boolean.valueOf(z);
                    aVar6.b();
                    break;
                }
                break;
        }
    }
}
