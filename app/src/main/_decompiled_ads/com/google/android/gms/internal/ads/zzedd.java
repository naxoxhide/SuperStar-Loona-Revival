package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzedd {
    private final zzaxv zza;
    private final Context zzb;
    private final zzech zzc;
    private final zzcaz zzd;
    private final String zze;
    private final zzfib zzf;
    private final com.google.android.gms.ads.internal.util.zzg zzg = com.google.android.gms.ads.internal.zzt.zzo().zzh();

    public zzedd(Context context, zzcaz zzcazVar, zzaxv zzaxvVar, zzech zzechVar, String str, zzfib zzfibVar) {
        this.zzb = context;
        this.zzd = zzcazVar;
        this.zza = zzaxvVar;
        this.zzc = zzechVar;
        this.zze = str;
        this.zzf = zzfibVar;
    }

    private static final void zzc(SQLiteDatabase sQLiteDatabase, ArrayList arrayList) {
        int size = arrayList.size();
        long jZze = 0;
        for (int i = 0; i < size; i++) {
            zzbae zzbaeVar = (zzbae) arrayList.get(i);
            if (zzbaeVar.zzw() == 2 && zzbaeVar.zze() > jZze) {
                jZze = zzbaeVar.zze();
            }
        }
        if (jZze != 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("value", Long.valueOf(jZze));
            sQLiteDatabase.update("offline_signal_statistics", contentValues, "statistic_name = 'last_successful_request_time'", null);
        }
    }

    public final void zzb(final boolean z) {
        try {
            this.zzc.zza(new zzfgu() { // from class: com.google.android.gms.internal.ads.zzecz
                @Override // com.google.android.gms.internal.ads.zzfgu
                public final Object zza(Object obj) throws Exception {
                    this.zza.zza(z, (SQLiteDatabase) obj);
                    return null;
                }
            });
        } catch (Exception e) {
            zzcat.zzg("Error in offline signals database startup: ".concat(String.valueOf(e.getMessage())));
        }
    }

    final /* synthetic */ Void zza(boolean z, SQLiteDatabase sQLiteDatabase) throws Exception {
        if (z) {
            this.zzb.deleteDatabase("OfflineUpload.db");
            return null;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzir)).booleanValue()) {
            zzfia zzfiaVarZzb = zzfia.zzb("oa_upload");
            zzfiaVarZzb.zza("oa_failed_reqs", String.valueOf(zzecw.zza(sQLiteDatabase, 0)));
            zzfiaVarZzb.zza("oa_total_reqs", String.valueOf(zzecw.zza(sQLiteDatabase, 1)));
            zzfiaVarZzb.zza("oa_upload_time", String.valueOf(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis()));
            zzfiaVarZzb.zza("oa_last_successful_time", String.valueOf(zzecw.zzb(sQLiteDatabase, 2)));
            zzfiaVarZzb.zza("oa_session_id", this.zzg.zzQ() ? "" : this.zze);
            this.zzf.zzb(zzfiaVarZzb);
            ArrayList arrayListZzc = zzecw.zzc(sQLiteDatabase);
            zzc(sQLiteDatabase, arrayListZzc);
            int size = arrayListZzc.size();
            for (int i = 0; i < size; i++) {
                zzbae zzbaeVar = (zzbae) arrayListZzc.get(i);
                com.google.android.gms.ads.internal.util.zzg zzgVar = this.zzg;
                zzfia zzfiaVarZzb2 = zzfia.zzb("oa_signals");
                zzfiaVarZzb2.zza("oa_session_id", zzgVar.zzQ() ? "" : this.zze);
                zzazz zzazzVarZzf = zzbaeVar.zzf();
                String strValueOf = zzazzVarZzf.zzf() ? String.valueOf(zzazzVarZzf.zzh() - 1) : "-1";
                String string = zzfwg.zzb(zzbaeVar.zzk(), new zzfsk() { // from class: com.google.android.gms.internal.ads.zzedc
                    @Override // com.google.android.gms.internal.ads.zzfsk
                    public final Object apply(Object obj) {
                        return ((zzayt) obj).name();
                    }
                }).toString();
                zzfiaVarZzb2.zza("oa_sig_ts", String.valueOf(zzbaeVar.zze()));
                zzfiaVarZzb2.zza("oa_sig_status", String.valueOf(zzbaeVar.zzw() - 1));
                zzfiaVarZzb2.zza("oa_sig_resp_lat", String.valueOf(zzbaeVar.zzd()));
                zzfiaVarZzb2.zza("oa_sig_render_lat", String.valueOf(zzbaeVar.zzc()));
                zzfiaVarZzb2.zza("oa_sig_formats", string);
                zzfiaVarZzb2.zza("oa_sig_nw_type", strValueOf);
                zzfiaVarZzb2.zza("oa_sig_wifi", String.valueOf(zzbaeVar.zzx() - 1));
                zzfiaVarZzb2.zza("oa_sig_airplane", String.valueOf(zzbaeVar.zzt() - 1));
                zzfiaVarZzb2.zza("oa_sig_data", String.valueOf(zzbaeVar.zzu() - 1));
                zzfiaVarZzb2.zza("oa_sig_nw_resp", String.valueOf(zzbaeVar.zza()));
                zzfiaVarZzb2.zza("oa_sig_offline", String.valueOf(zzbaeVar.zzv() - 1));
                zzfiaVarZzb2.zza("oa_sig_nw_state", String.valueOf(zzbaeVar.zzj().zza()));
                if (zzazzVarZzf.zze() && zzazzVarZzf.zzf() && zzazzVarZzf.zzh() == 2) {
                    zzfiaVarZzb2.zza("oa_sig_cell_type", String.valueOf(zzazzVarZzf.zzg() - 1));
                }
                this.zzf.zzb(zzfiaVarZzb2);
            }
        } else {
            ArrayList arrayListZzc2 = zzecw.zzc(sQLiteDatabase);
            Context context = this.zzb;
            zzbaf zzbafVarZza = zzbaj.zza();
            zzbafVarZza.zzb(context.getPackageName());
            zzbafVarZza.zzd(Build.MODEL);
            zzbafVarZza.zze(zzecw.zza(sQLiteDatabase, 0));
            zzbafVarZza.zza(arrayListZzc2);
            zzbafVarZza.zzg(zzecw.zza(sQLiteDatabase, 1));
            zzbafVarZza.zzc(zzecw.zza(sQLiteDatabase, 3));
            zzbafVarZza.zzh(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis());
            zzbafVarZza.zzf(zzecw.zzb(sQLiteDatabase, 2));
            final zzbaj zzbajVar = (zzbaj) zzbafVarZza.zzal();
            zzc(sQLiteDatabase, arrayListZzc2);
            this.zza.zzb(new zzaxu() { // from class: com.google.android.gms.internal.ads.zzeda
                @Override // com.google.android.gms.internal.ads.zzaxu
                public final void zza(zzazk zzazkVar) {
                    zzazkVar.zzi(zzbajVar);
                }
            });
            zzcaz zzcazVar = this.zzd;
            zzbau zzbauVarZza = zzbav.zza();
            zzbauVarZza.zza(zzcazVar.zzb);
            zzbauVarZza.zzc(this.zzd.zzc);
            zzbauVarZza.zzb(true == this.zzd.zzd ? 0 : 2);
            final zzbav zzbavVar = (zzbav) zzbauVarZza.zzal();
            this.zza.zzb(new zzaxu() { // from class: com.google.android.gms.internal.ads.zzedb
                @Override // com.google.android.gms.internal.ads.zzaxu
                public final void zza(zzazk zzazkVar) {
                    zzazc zzazcVar = (zzazc) zzazkVar.zzb().zzaB();
                    zzazcVar.zzb(zzbavVar);
                    zzazkVar.zzg(zzazcVar);
                }
            });
            this.zza.zzc(10004);
        }
        zzecw.zzf(sQLiteDatabase);
        return null;
    }
}
