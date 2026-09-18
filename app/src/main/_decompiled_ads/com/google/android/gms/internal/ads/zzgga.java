package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgga extends zzghv {
    zzgga() {
        super(zzgqa.class, new zzgfy(zzgax.class));
    }

    @Override // com.google.android.gms.internal.ads.zzghv
    public final zzghu zza() {
        return new zzgfz(this, zzgqd.class);
    }

    @Override // com.google.android.gms.internal.ads.zzghv
    public final zzgoy zzb() {
        return zzgoy.REMOTE;
    }

    @Override // com.google.android.gms.internal.ads.zzghv
    public final /* synthetic */ zzgvj zzc(zzgsr zzgsrVar) throws zzgul {
        return zzgqa.zze(zzgsrVar, zzgtl.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzghv
    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey";
    }

    @Override // com.google.android.gms.internal.ads.zzghv
    public final /* bridge */ /* synthetic */ void zze(zzgvj zzgvjVar) throws GeneralSecurityException {
        zzgqa zzgqaVar = (zzgqa) zzgvjVar;
        zzgrv.zzb(zzgqaVar.zza(), 0);
        if (zzgfx.zzb(zzgqaVar.zzf().zza().zzg())) {
            return;
        }
        throw new GeneralSecurityException("Unsupported DEK key type: " + zzgqaVar.zzf().zza().zzg() + ". Only Tink AEAD key types are supported.");
    }
}
