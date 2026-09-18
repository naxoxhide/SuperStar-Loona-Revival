package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhau {
    public static zzhau zzb(Class cls) {
        return System.getProperty("java.vm.name").equalsIgnoreCase("Dalvik") ? new zzhap(cls.getSimpleName()) : new zzhar(cls.getSimpleName());
    }

    public abstract void zza(String str);
}
