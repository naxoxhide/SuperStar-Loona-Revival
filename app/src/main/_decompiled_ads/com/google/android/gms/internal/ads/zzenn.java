package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzenn implements zzetw {
    private final zzgad zza;
    private final zzgad zzb;
    private final Context zzc;
    private final zzfdn zzd;
    private final View zze;

    public zzenn(zzgad zzgadVar, zzgad zzgadVar2, Context context, zzfdn zzfdnVar, ViewGroup viewGroup) {
        this.zza = zzgadVar;
        this.zzb = zzgadVar2;
        this.zzc = context;
        this.zzd = zzfdnVar;
        this.zze = viewGroup;
    }

    private final List zze() {
        ArrayList arrayList = new ArrayList();
        View view = this.zze;
        while (view != null) {
            Object parent = view.getParent();
            if (parent == null) {
                break;
            }
            int iIndexOfChild = parent instanceof ViewGroup ? ((ViewGroup) parent).indexOfChild(view) : -1;
            Bundle bundle = new Bundle();
            bundle.putString("type", parent.getClass().getName());
            bundle.putInt("index_of_child", iIndexOfChild);
            arrayList.add(bundle);
            if (!(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final int zza() {
        return 3;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final ListenableFuture zzb() {
        zzbci.zza(this.zzc);
        return ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzkg)).booleanValue() ? this.zzb.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzenl
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        }) : this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzenm
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzd();
            }
        });
    }

    final /* synthetic */ zzeno zzc() throws Exception {
        return new zzeno(this.zzc, this.zzd.zze, zze());
    }

    final /* synthetic */ zzeno zzd() throws Exception {
        return new zzeno(this.zzc, this.zzd.zze, zze());
    }
}
