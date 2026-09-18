package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbxw implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final Context zza;
    private final SharedPreferences zzb;
    private final com.google.android.gms.ads.internal.util.zzg zzc;
    private final zzbyy zzd;
    private String zze = "-1";
    private int zzf = -1;

    zzbxw(Context context, com.google.android.gms.ads.internal.util.zzg zzgVar, zzbyy zzbyyVar) {
        this.zzb = PreferenceManager.getDefaultSharedPreferences(context);
        this.zzc = zzgVar;
        this.zza = context;
        this.zzd = zzbyyVar;
    }

    private final void zzb() {
        this.zzc.zzH(true);
        new Bundle();
        throw null;
    }

    private final void zzc(String str, int i) {
        Context context;
        boolean z = false;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzav)).booleanValue() ? str.isEmpty() || str.charAt(0) != '1' : i == 0 || str.isEmpty() || (str.charAt(0) != '1' && !str.equals("-1"))) {
            z = true;
        }
        this.zzc.zzH(z);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgf)).booleanValue() && z && (context = this.zza) != null) {
            context.deleteDatabase("OfflineUpload.db");
        }
        this.zzd.zzt();
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0091  */
    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        byte b2;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzax)).booleanValue()) {
            if (zzbxv.zza(str, "gad_has_consent_for_cookies")) {
                int i = sharedPreferences.getInt("gad_has_consent_for_cookies", -1);
                if (i != this.zzc.zzb()) {
                    zzb();
                }
                this.zzc.zzE(i);
                return;
            }
            if (zzbxv.zza(str, "IABTCF_gdprApplies") || zzbxv.zza(str, "IABTCF_TCString") || zzbxv.zza(str, "IABTCF_PurposeConsents")) {
                String string = sharedPreferences.getString(str, "-1");
                if (string != null && !string.equals(this.zzc.zzn(str))) {
                    zzb();
                }
                this.zzc.zzF(str, string);
                return;
            }
            return;
        }
        String string2 = sharedPreferences.getString("IABTCF_PurposeConsents", "-1");
        int i2 = sharedPreferences.getInt("gad_has_consent_for_cookies", -1);
        String strValueOf = String.valueOf(str);
        int iHashCode = strValueOf.hashCode();
        if (iHashCode != -2004976699) {
            if (iHashCode == -527267622 && strValueOf.equals("gad_has_consent_for_cookies")) {
                b2 = 1;
            } else {
                b2 = -1;
            }
        } else if (strValueOf.equals("IABTCF_PurposeConsents")) {
            b2 = 0;
        } else {
            b2 = -1;
        }
        if (b2 == 0) {
            if (string2.equals("-1") || this.zze.equals(string2)) {
                return;
            }
            this.zze = string2;
            zzc(string2, i2);
            return;
        }
        if (b2 != 1) {
            return;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzav)).booleanValue() || i2 == -1 || this.zzf == i2) {
            return;
        }
        this.zzf = i2;
        zzc(string2, i2);
    }

    final void zza() {
        this.zzb.registerOnSharedPreferenceChangeListener(this);
        onSharedPreferenceChanged(this.zzb, "gad_has_consent_for_cookies");
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzax)).booleanValue()) {
            onSharedPreferenceChanged(this.zzb, "IABTCF_PurposeConsents");
        } else {
            onSharedPreferenceChanged(this.zzb, "IABTCF_gdprApplies");
            onSharedPreferenceChanged(this.zzb, "IABTCF_TCString");
        }
    }
}
