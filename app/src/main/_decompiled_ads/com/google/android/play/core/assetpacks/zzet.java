package com.google.android.play.core.assetpacks;

import com.google.firebase.sessions.settings.RemoteSettings;

/* JADX INFO: compiled from: com.google.android.play:core@@1.10.3 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzet {
    zzet() {
    }

    abstract int zza();

    abstract long zzb();

    abstract String zzc();

    abstract boolean zzd();

    abstract boolean zze();

    abstract byte[] zzf();

    final boolean zzg() {
        if (zzc() == null) {
            return false;
        }
        return zzc().endsWith(RemoteSettings.FORWARD_SLASH_STRING);
    }

    final boolean zzh() {
        return zza() == 0;
    }
}
