package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgaz {
    private final OutputStream zza;

    private zzgaz(OutputStream outputStream) {
        this.zza = outputStream;
    }

    public static zzgaz zzb(OutputStream outputStream) {
        return new zzgaz(outputStream);
    }

    public final void zza(zzgpm zzgpmVar) throws IOException {
        try {
            zzgpmVar.zzaw(this.zza);
        } finally {
            this.zza.close();
        }
    }
}
