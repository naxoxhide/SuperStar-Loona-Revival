package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.tapjoy.TapjoyConstants;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcem implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzcen zze;

    zzcem(zzcen zzcenVar, String str, String str2, String str3, String str4) {
        this.zze = zzcenVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:44:0x00ab  */
    @Override // java.lang.Runnable
    public final void run() {
        byte b2;
        HashMap map = new HashMap();
        map.put("event", "precacheCanceled");
        map.put("src", this.zza);
        if (!TextUtils.isEmpty(this.zzb)) {
            map.put("cachedSrc", this.zzb);
        }
        switch (this.zzc) {
            case "interrupted":
                b2 = 3;
                break;
            case "badUrl":
                b2 = 8;
                break;
            case "inProgress":
                b2 = 2;
                break;
            case "downloadTimeout":
                b2 = 9;
                break;
            case "contentLengthMissing":
                b2 = 0;
                break;
            case "playerFailed":
                b2 = 5;
                break;
            case "sizeExceeded":
                b2 = 11;
                break;
            case "externalAbort":
                b2 = 10;
                break;
            case "noop":
                b2 = 4;
                break;
            case "error":
                b2 = 1;
                break;
            case "expireFailed":
                b2 = 6;
                break;
            case "noCacheDir":
                b2 = 7;
                break;
            default:
                b2 = -1;
                break;
        }
        String str = TapjoyConstants.LOG_LEVEL_INTERNAL;
        switch (b2) {
            case 6:
            case 7:
                str = "io";
                break;
            case 8:
            case 9:
                str = "network";
                break;
            case 10:
            case 11:
                str = "policy";
                break;
        }
        map.put("type", str);
        map.put("reason", this.zzc);
        if (!TextUtils.isEmpty(this.zzd)) {
            map.put("message", this.zzd);
        }
        zzcen.zze(this.zze, "onPrecacheEvent", map);
    }
}
