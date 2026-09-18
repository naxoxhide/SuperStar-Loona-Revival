package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbjo implements zzbjj {
    private final Context zza;

    public zzbjo(Context context) {
        this.zza = context;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0051  */
    @Override // com.google.android.gms.internal.ads.zzbjj
    public final void zza(Object obj, Map map) {
        byte b2;
        if (com.google.android.gms.ads.internal.zzt.zzn().zzu(this.zza)) {
            String str = (String) map.get("eventName");
            String str2 = (String) map.get("eventId");
            int iHashCode = str.hashCode();
            if (iHashCode != 94399) {
                if (iHashCode != 94401) {
                    if (iHashCode == 94407 && str.equals("_ai")) {
                        b2 = 1;
                    } else {
                        b2 = -1;
                    }
                } else if (str.equals("_ac")) {
                    b2 = 0;
                } else {
                    b2 = -1;
                }
            } else if (str.equals("_aa")) {
                b2 = 2;
            } else {
                b2 = -1;
            }
            if (b2 == 0) {
                com.google.android.gms.ads.internal.zzt.zzn().zzm(this.zza, str2);
            } else if (b2 == 1) {
                com.google.android.gms.ads.internal.zzt.zzn().zzn(this.zza, str2);
            } else if (b2 != 2) {
                zzcat.zzg("logScionEvent gmsg contained unsupported eventName");
            } else {
                com.google.android.gms.ads.internal.zzt.zzn().zzk(this.zza, str2);
            }
        }
    }
}
