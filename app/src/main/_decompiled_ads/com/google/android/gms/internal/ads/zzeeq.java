package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.view.InputEvent;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeeq {
    private MeasurementManagerFutures zza;
    private final Context zzb;

    zzeeq(Context context) {
        this.zzb = context;
    }

    public final ListenableFuture zza() {
        MeasurementManagerFutures measurementManagerFuturesFrom = MeasurementManagerFutures.from(this.zzb);
        this.zza = measurementManagerFuturesFrom;
        return measurementManagerFuturesFrom == null ? zzfzt.zzg(new IllegalStateException("MeasurementManagerFutures is null")) : measurementManagerFuturesFrom.getMeasurementApiStatusAsync();
    }

    public final ListenableFuture zzb(Uri uri, InputEvent inputEvent) {
        MeasurementManagerFutures measurementManagerFutures = this.zza;
        measurementManagerFutures.getClass();
        return measurementManagerFutures.registerSourceAsync(uri, inputEvent);
    }
}
