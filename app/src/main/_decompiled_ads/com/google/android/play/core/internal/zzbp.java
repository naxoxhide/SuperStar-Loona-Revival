package com.google.android.play.core.internal;

import com.mbridge.msdk.MBridgeConstans;
import java.io.File;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.play:core@@1.10.3 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbp implements zzaz {
    zzbp() {
    }

    static void zzc(ClassLoader classLoader, Set set) {
        zzbk.zzc(classLoader, set, new zzbn());
    }

    static boolean zzd(ClassLoader classLoader, File file, File file2, boolean z) {
        return zzbf.zze(classLoader, file, file2, z, new zzbh(), MBridgeConstans.DYNAMIC_VIEW_WX_PATH, new zzbo());
    }

    @Override // com.google.android.play.core.internal.zzaz
    public final void zza(ClassLoader classLoader, Set set) {
        zzc(classLoader, set);
    }

    @Override // com.google.android.play.core.internal.zzaz
    public final boolean zzb(ClassLoader classLoader, File file, File file2, boolean z) {
        return zzd(classLoader, file, file2, z);
    }
}
