package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgjq extends RuntimeException {
    public zzgjq(String str) {
        super(str);
    }

    public static Object zza(zzgjp zzgjpVar) {
        try {
            return zzgjpVar.zza();
        } catch (Exception e) {
            throw new zzgjq(e);
        }
    }

    public zzgjq(String str, Throwable th) {
        super("Creating a protokey serialization failed", th);
    }

    public zzgjq(Throwable th) {
        super(th);
    }
}
