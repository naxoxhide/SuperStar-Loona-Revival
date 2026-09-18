package com.google.android.gms.internal.ads;

import java.io.File;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzarf implements zzfol {
    final /* synthetic */ zzfml zza;

    zzarf(zzarh zzarhVar, zzfml zzfmlVar) {
        this.zza = zzfmlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfol
    public final boolean zza(File file) {
        try {
            return this.zza.zza(file);
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
