package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfpw extends zzfpu {
    private static zzfpw zzc;

    private zzfpw(Context context) {
        super(context, "paidv1_id", "paidv1_creation_time", "PaidV1LifecycleImpl");
    }

    public static final zzfpw zzj(Context context) {
        zzfpw zzfpwVar;
        synchronized (zzfpw.class) {
            if (zzc == null) {
                zzc = new zzfpw(context);
            }
            zzfpwVar = zzc;
        }
        return zzfpwVar;
    }

    public final zzfpt zzh(long j, boolean z) throws IOException {
        zzfpt zzfptVarZzb;
        synchronized (zzfpw.class) {
            zzfptVarZzb = zzb(null, null, j, z);
        }
        return zzfptVarZzb;
    }

    public final zzfpt zzi(String str, String str2, long j, boolean z) throws IOException {
        zzfpt zzfptVarZzb;
        synchronized (zzfpw.class) {
            zzfptVarZzb = zzb(str, str2, j, z);
        }
        return zzfptVarZzb;
    }

    public final void zzk() throws IOException {
        synchronized (zzfpw.class) {
            zzf(false);
        }
    }

    public final void zzl() throws IOException {
        synchronized (zzfpw.class) {
            zzf(true);
        }
    }
}
