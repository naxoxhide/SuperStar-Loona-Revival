package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfkt extends zzfkw {
    private static final zzfkt zzb = new zzfkt();

    private zzfkt() {
    }

    public static zzfkt zza() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfkw
    public final void zzb(boolean z) {
        Iterator it = zzfku.zza().zzc().iterator();
        while (it.hasNext()) {
            zzflh zzflhVarZzg = ((zzfkg) it.next()).zzg();
            if (zzflhVarZzg.zzl()) {
                zzfla.zza().zzb(zzflhVarZzg.zza(), "setState", true != z ? "backgrounded" : "foregrounded");
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfkw
    public final boolean zzc() {
        Iterator it = zzfku.zza().zzb().iterator();
        while (it.hasNext()) {
            View viewZzf = ((zzfkg) it.next()).zzf();
            if (viewZzf != null && viewZzf.hasWindowFocus()) {
                return true;
            }
        }
        return false;
    }
}
