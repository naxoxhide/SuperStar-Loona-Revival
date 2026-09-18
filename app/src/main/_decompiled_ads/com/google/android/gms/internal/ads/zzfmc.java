package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfmc implements zzflc {
    private static final zzfmc zza = new zzfmc();
    private static final Handler zzb = new Handler(Looper.getMainLooper());
    private static Handler zzc = null;
    private static final Runnable zzd = new zzfly();
    private static final Runnable zze = new zzflz();
    private int zzg;
    private long zzm;
    private final List zzf = new ArrayList();
    private boolean zzh = false;
    private final List zzi = new ArrayList();
    private final zzflv zzk = new zzflv();
    private final zzfle zzj = new zzfle();
    private final zzflw zzl = new zzflw(new zzfmf());

    zzfmc() {
    }

    public static zzfmc zzd() {
        return zza;
    }

    static /* bridge */ /* synthetic */ void zzg(zzfmc zzfmcVar) {
        zzfmcVar.zzg = 0;
        zzfmcVar.zzi.clear();
        zzfmcVar.zzh = false;
        for (zzfkg zzfkgVar : zzfku.zza().zzb()) {
        }
        zzfmcVar.zzm = System.nanoTime();
        zzfmcVar.zzk.zzi();
        long jNanoTime = System.nanoTime();
        zzfld zzfldVarZza = zzfmcVar.zzj.zza();
        if (zzfmcVar.zzk.zze().size() > 0) {
            for (String str : zzfmcVar.zzk.zze()) {
                JSONObject jSONObjectZza = zzfldVarZza.zza(null);
                View viewZza = zzfmcVar.zzk.zza(str);
                zzfld zzfldVarZzb = zzfmcVar.zzj.zzb();
                String strZzc = zzfmcVar.zzk.zzc(str);
                if (strZzc != null) {
                    JSONObject jSONObjectZza2 = zzfldVarZzb.zza(viewZza);
                    zzfln.zzb(jSONObjectZza2, str);
                    try {
                        jSONObjectZza2.put("notVisibleReason", strZzc);
                    } catch (JSONException e) {
                        zzflo.zza("Error with setting not visible reason", e);
                    }
                    zzfln.zzc(jSONObjectZza, jSONObjectZza2);
                }
                zzfln.zzf(jSONObjectZza);
                HashSet hashSet = new HashSet();
                hashSet.add(str);
                zzfmcVar.zzl.zzc(jSONObjectZza, hashSet, jNanoTime);
            }
        }
        if (zzfmcVar.zzk.zzf().size() > 0) {
            JSONObject jSONObjectZza3 = zzfldVarZza.zza(null);
            zzfmcVar.zzk(null, zzfldVarZza, jSONObjectZza3, 1, false);
            zzfln.zzf(jSONObjectZza3);
            zzfmcVar.zzl.zzd(jSONObjectZza3, zzfmcVar.zzk.zzf(), jNanoTime);
            boolean z = zzfmcVar.zzh;
        } else {
            zzfmcVar.zzl.zzb();
        }
        zzfmcVar.zzk.zzg();
        long jNanoTime2 = System.nanoTime() - zzfmcVar.zzm;
        if (zzfmcVar.zzf.size() > 0) {
            for (zzfmb zzfmbVar : zzfmcVar.zzf) {
                int i = zzfmcVar.zzg;
                TimeUnit.NANOSECONDS.toMillis(jNanoTime2);
                zzfmbVar.zzb();
                if (zzfmbVar instanceof zzfma) {
                    int i2 = zzfmcVar.zzg;
                    ((zzfma) zzfmbVar).zza();
                }
            }
        }
    }

    private final void zzk(View view, zzfld zzfldVar, JSONObject jSONObject, int i, boolean z) {
        zzfldVar.zzb(view, jSONObject, this, i == 1, z);
    }

    private static final void zzl() {
        Handler handler = zzc;
        if (handler != null) {
            handler.removeCallbacks(zze);
            zzc = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzflc
    public final void zza(View view, zzfld zzfldVar, JSONObject jSONObject, boolean z) {
        int iZzk;
        boolean z2;
        if (zzflt.zzb(view) != null || (iZzk = this.zzk.zzk(view)) == 3) {
            return;
        }
        JSONObject jSONObjectZza = zzfldVar.zza(view);
        zzfln.zzc(jSONObject, jSONObjectZza);
        String strZzd = this.zzk.zzd(view);
        if (strZzd != null) {
            zzfln.zzb(jSONObjectZza, strZzd);
            try {
                jSONObjectZza.put("hasWindowFocus", Boolean.valueOf(this.zzk.zzj(view)));
            } catch (JSONException e) {
                zzflo.zza("Error with setting has window focus", e);
            }
            this.zzk.zzh();
        } else {
            zzflu zzfluVarZzb = this.zzk.zzb(view);
            if (zzfluVarZzb != null) {
                zzfkx zzfkxVarZza = zzfluVarZzb.zza();
                JSONArray jSONArray = new JSONArray();
                ArrayList arrayListZzb = zzfluVarZzb.zzb();
                int size = arrayListZzb.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put((String) arrayListZzb.get(i));
                }
                try {
                    jSONObjectZza.put("isFriendlyObstructionFor", jSONArray);
                    jSONObjectZza.put("friendlyObstructionClass", zzfkxVarZza.zzd());
                    jSONObjectZza.put("friendlyObstructionPurpose", zzfkxVarZza.zza());
                    jSONObjectZza.put("friendlyObstructionReason", zzfkxVarZza.zzc());
                } catch (JSONException e2) {
                    zzflo.zza("Error with setting friendly obstruction", e2);
                }
                z2 = true;
            } else {
                z2 = false;
            }
            zzk(view, zzfldVar, jSONObjectZza, iZzk, z || z2);
        }
        this.zzg++;
    }

    public final void zzh() {
        zzl();
    }

    public final void zzi() {
        if (zzc == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            zzc = handler;
            handler.post(zzd);
            zzc.postDelayed(zze, 200L);
        }
    }

    public final void zzj() {
        zzl();
        this.zzf.clear();
        zzb.post(new zzflx(this));
    }
}
