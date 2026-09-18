package com.applovin.impl.sdk.utils;

import android.content.Context;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.OnSuccessListener;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class j {
    public static void aa(final Context context) {
        new Thread(new Runnable() { // from class: com.applovin.impl.sdk.utils.-$$Lambda$j$3CMvW8ZuviAt7UzmwLQghl-ttlM
            @Override // java.lang.Runnable
            public final void run() {
                j.ab(context);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void ab(Context context) {
        d.a aVarS = d.S(context);
        com.applovin.impl.sdk.q.a(aVarS);
        com.applovin.impl.sdk.o.a(aVarS);
        if (u.dI("com.google.android.gms.appset.AppSet")) {
            try {
                AppSet.getClient(context).getAppSetIdInfo().addOnSuccessListener(new OnSuccessListener<AppSetIdInfo>() { // from class: com.applovin.impl.sdk.utils.j.1
                    @Override // com.google.android.gms.tasks.OnSuccessListener
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onSuccess(AppSetIdInfo appSetIdInfo) {
                        Objects.requireNonNull(appSetIdInfo, "info is marked non-null but is null");
                        com.applovin.impl.sdk.q.a(new com.applovin.impl.sdk.q.b(appSetIdInfo.getId(), appSetIdInfo.getScope()));
                        com.applovin.impl.sdk.o.a(new com.applovin.impl.sdk.o.a(appSetIdInfo.getId(), appSetIdInfo.getScope()));
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }
}
