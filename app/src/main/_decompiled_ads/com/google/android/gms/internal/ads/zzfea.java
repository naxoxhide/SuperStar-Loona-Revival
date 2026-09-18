package com.google.android.gms.internal.ads;

import android.util.Base64;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfea {
    public zzfea() {
        try {
            zzgcj.zza();
        } catch (GeneralSecurityException e) {
            com.google.android.gms.ads.internal.util.zze.zza("Failed to Configure Aead. ".concat(e.toString()));
            com.google.android.gms.ads.internal.zzt.zzo().zzu(e, "CryptoUtils.registerAead");
        }
    }

    public static final String zza() {
        zzgso zzgsoVarZzt = zzgsr.zzt();
        try {
            zzgba.zzb(zzgbs.zzc(zzgbl.zza("AES128_GCM").zzb()), zzgaz.zzb(zzgsoVarZzt));
        } catch (IOException | GeneralSecurityException e) {
            com.google.android.gms.ads.internal.util.zze.zza("Failed to generate key".concat(e.toString()));
            com.google.android.gms.ads.internal.zzt.zzo().zzu(e, "CryptoUtils.generateKey");
        }
        String strEncodeToString = Base64.encodeToString(zzgsoVarZzt.zzb().zzA(), 11);
        zzgsoVarZzt.zzc();
        return strEncodeToString;
    }

    @Nullable
    public static final String zzb(byte[] bArr, byte[] bArr2, String str, zzdsj zzdsjVar) {
        zzgbs zzgbsVarZzc = zzc(str);
        if (zzgbsVarZzc == null) {
            return null;
        }
        try {
            byte[] bArrZza = ((zzgax) zzgbsVarZzc.zze(zzgjg.zza(), zzgax.class)).zza(bArr, bArr2);
            zzdsjVar.zza().put("ds", "1");
            return new String(bArrZza, "UTF-8");
        } catch (UnsupportedEncodingException | GeneralSecurityException e) {
            com.google.android.gms.ads.internal.util.zze.zza("Failed to decrypt ".concat(e.toString()));
            com.google.android.gms.ads.internal.zzt.zzo().zzu(e, "CryptoUtils.decrypt");
            zzdsjVar.zza().put("dsf", e.toString());
            return null;
        }
    }

    @Nullable
    private static final zzgbs zzc(String str) {
        try {
            return zzgba.zza(zzgay.zzb(Base64.decode(str, 11)));
        } catch (IOException | GeneralSecurityException e) {
            com.google.android.gms.ads.internal.util.zze.zza("Failed to get keysethandle".concat(e.toString()));
            com.google.android.gms.ads.internal.zzt.zzo().zzu(e, "CryptoUtils.getHandle");
            return null;
        }
    }
}
