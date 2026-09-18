package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzib {
    private final AudioManager zza;
    private final zzhz zzb;
    private zzia zzc;
    private int zzd;
    private float zze = 1.0f;

    public zzib(Context context, Handler handler, zzia zziaVar) {
        AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService("audio");
        Objects.requireNonNull(audioManager);
        this.zza = audioManager;
        this.zzc = zziaVar;
        this.zzb = new zzhz(this, handler);
        this.zzd = 0;
    }

    private final void zze() {
        if (this.zzd == 0) {
            return;
        }
        if (zzfk.zza < 26) {
            this.zza.abandonAudioFocus(this.zzb);
        }
        zzg(0);
    }

    private final void zzf(int i) {
        zzia zziaVar = this.zzc;
        if (zziaVar != null) {
            zzjx zzjxVar = (zzjx) zziaVar;
            boolean zZzv = zzjxVar.zza.zzv();
            zzjxVar.zza.zzal(zZzv, i, zzkb.zzY(zZzv, i));
        }
    }

    private final void zzg(int i) {
        if (this.zzd == i) {
            return;
        }
        this.zzd = i;
        float f = i == 3 ? 0.2f : 1.0f;
        if (this.zze == f) {
            return;
        }
        this.zze = f;
        zzia zziaVar = this.zzc;
        if (zziaVar != null) {
            ((zzjx) zziaVar).zza.zzai();
        }
    }

    public final float zza() {
        return this.zze;
    }

    public final int zzb(boolean z, int i) {
        zze();
        return z ? 1 : -1;
    }

    public final void zzd() {
        this.zzc = null;
        zze();
    }

    static /* bridge */ /* synthetic */ void zzc(zzib zzibVar, int i) {
        if (i == -3 || i == -2) {
            if (i != -2) {
                zzibVar.zzg(3);
                return;
            } else {
                zzibVar.zzf(0);
                zzibVar.zzg(2);
                return;
            }
        }
        if (i == -1) {
            zzibVar.zzf(-1);
            zzibVar.zze();
        } else if (i == 1) {
            zzibVar.zzg(1);
            zzibVar.zzf(1);
        } else {
            zzer.zzf("AudioFocusManager", "Unknown focus change type: " + i);
        }
    }
}
