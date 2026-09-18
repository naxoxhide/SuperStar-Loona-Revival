package com.tapjoy;

import android.content.Context;
import com.google.android.gms.appset.AppSet;
import com.tapjoy.internal.g8;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class TJAppSetId {
    public void fetch(Context context, TJTaskHandler<String> tJTaskHandler) {
        try {
            Class.forName("com.google.android.gms.appset.AppSet");
            AppSet.getClient(context.getApplicationContext()).getAppSetIdInfo().addOnSuccessListener(new g8(tJTaskHandler));
        } catch (Exception e) {
            TapjoyLog.d("TJAppSetId", String.format(Locale.ENGLISH, "AppSetId class not found: %s", e.getMessage()));
            tJTaskHandler.onComplete("");
        }
    }
}
