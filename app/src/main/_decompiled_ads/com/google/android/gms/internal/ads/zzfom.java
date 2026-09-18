package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.util.Hex;
import java.io.File;
import java.util.HashSet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfom {
    private static final Object zza = new Object();
    private final Context zzb;
    private final SharedPreferences zzc;
    private final String zzd;
    private final zzfnt zze;
    private boolean zzf;

    public zzfom(Context context, int i, zzfnt zzfntVar, boolean z) {
        this.zzf = false;
        this.zzb = context;
        this.zzd = Integer.toString(i - 1);
        this.zzc = context.getSharedPreferences("pcvmspf", 0);
        this.zze = zzfntVar;
        this.zzf = z;
    }

    private final File zze(String str) {
        return new File(new File(this.zzb.getDir("pccache", 0), this.zzd), str);
    }

    private static String zzf(zzaui zzauiVar) {
        zzauk zzaukVarZze = zzaul.zze();
        zzaukVarZze.zze(zzauiVar.zzd().zzk());
        zzaukVarZze.zza(zzauiVar.zzd().zzj());
        zzaukVarZze.zzb(zzauiVar.zzd().zza());
        zzaukVarZze.zzd(zzauiVar.zzd().zzd());
        zzaukVarZze.zzc(zzauiVar.zzd().zzc());
        return Hex.bytesToStringLowercase(((zzaul) zzaukVarZze.zzal()).zzax());
    }

    private final String zzg() {
        return "FBAMTD".concat(String.valueOf(this.zzd));
    }

    private final String zzh() {
        return "LATMTD".concat(String.valueOf(this.zzd));
    }

    private final void zzi(int i, long j) {
        this.zze.zza(i, j);
    }

    private final void zzj(int i, long j, String str) {
        this.zze.zzb(i, j, str);
    }

    private final zzaul zzk(int i) {
        String string = i == 1 ? this.zzc.getString(zzh(), null) : this.zzc.getString(zzg(), null);
        if (string == null) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            byte[] bArrStringToBytes = Hex.stringToBytes(string);
            zzgsr zzgsrVar = zzgsr.zzb;
            return zzaul.zzi(zzgsr.zzv(bArrStringToBytes, 0, bArrStringToBytes.length), this.zzf ? zzgtl.zza() : zzgtl.zzb());
        } catch (zzgul unused) {
            return null;
        } catch (NullPointerException unused2) {
            zzi(2029, jCurrentTimeMillis);
            return null;
        } catch (RuntimeException unused3) {
            zzi(2032, jCurrentTimeMillis);
            return null;
        }
    }

    public final boolean zza(zzaui zzauiVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (zza) {
            if (!zzfog.zze(new File(zze(zzauiVar.zzd().zzk()), "pcbc"), zzauiVar.zze().zzA())) {
                zzi(4020, jCurrentTimeMillis);
                return false;
            }
            String strZzf = zzf(zzauiVar);
            SharedPreferences.Editor editorEdit = this.zzc.edit();
            editorEdit.putString(zzh(), strZzf);
            boolean zCommit = editorEdit.commit();
            if (zCommit) {
                zzi(5015, jCurrentTimeMillis);
            } else {
                zzi(4021, jCurrentTimeMillis);
            }
            return zCommit;
        }
    }

    public final boolean zzb(zzaui zzauiVar, zzfol zzfolVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (zza) {
            zzaul zzaulVarZzk = zzk(1);
            String strZzk = zzauiVar.zzd().zzk();
            if (zzaulVarZzk != null && zzaulVarZzk.zzk().equals(strZzk)) {
                zzi(4014, jCurrentTimeMillis);
                return false;
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            File fileZze = zze(strZzk);
            if (fileZze.exists()) {
                zzj(4023, jCurrentTimeMillis2, "d:" + (true != fileZze.isDirectory() ? "0" : "1") + ",f:" + (true != fileZze.isFile() ? "0" : "1"));
                zzi(4015, jCurrentTimeMillis2);
            } else if (!fileZze.mkdirs()) {
                zzj(4024, jCurrentTimeMillis2, "cw:".concat(true != fileZze.canWrite() ? "0" : "1"));
                zzi(4015, jCurrentTimeMillis2);
                return false;
            }
            File fileZze2 = zze(strZzk);
            File file = new File(fileZze2, "pcam.jar");
            File file2 = new File(fileZze2, "pcbc");
            if (!zzfog.zze(file, zzauiVar.zzf().zzA())) {
                zzi(4016, jCurrentTimeMillis);
                return false;
            }
            if (!zzfog.zze(file2, zzauiVar.zze().zzA())) {
                zzi(4017, jCurrentTimeMillis);
                return false;
            }
            if (zzfolVar != null && !zzfolVar.zza(file)) {
                zzi(4018, jCurrentTimeMillis);
                zzfog.zzd(fileZze2);
                return false;
            }
            String strZzf = zzf(zzauiVar);
            long jCurrentTimeMillis3 = System.currentTimeMillis();
            String string = this.zzc.getString(zzh(), null);
            SharedPreferences.Editor editorEdit = this.zzc.edit();
            editorEdit.putString(zzh(), strZzf);
            if (string != null) {
                editorEdit.putString(zzg(), string);
            }
            if (!editorEdit.commit()) {
                zzi(4019, jCurrentTimeMillis3);
                return false;
            }
            HashSet hashSet = new HashSet();
            zzaul zzaulVarZzk2 = zzk(1);
            if (zzaulVarZzk2 != null) {
                hashSet.add(zzaulVarZzk2.zzk());
            }
            zzaul zzaulVarZzk3 = zzk(2);
            if (zzaulVarZzk3 != null) {
                hashSet.add(zzaulVarZzk3.zzk());
            }
            for (File file3 : new File(this.zzb.getDir("pccache", 0), this.zzd).listFiles()) {
                if (!hashSet.contains(file3.getName())) {
                    zzfog.zzd(file3);
                }
            }
            zzi(5014, jCurrentTimeMillis);
            return true;
        }
    }

    public final zzfoe zzc(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (zza) {
            zzaul zzaulVarZzk = zzk(1);
            if (zzaulVarZzk == null) {
                zzi(4022, jCurrentTimeMillis);
                return null;
            }
            File fileZze = zze(zzaulVarZzk.zzk());
            File file = new File(fileZze, "pcam.jar");
            if (!file.exists()) {
                file = new File(fileZze, "pcam");
            }
            File file2 = new File(fileZze, "pcbc");
            File file3 = new File(fileZze, "pcopt");
            zzi(5016, jCurrentTimeMillis);
            return new zzfoe(zzaulVarZzk, file, file2, file3);
        }
    }

    public final boolean zzd(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (zza) {
            zzaul zzaulVarZzk = zzk(1);
            if (zzaulVarZzk == null) {
                zzi(4025, jCurrentTimeMillis);
                return false;
            }
            File fileZze = zze(zzaulVarZzk.zzk());
            if (!new File(fileZze, "pcam.jar").exists()) {
                zzi(4026, jCurrentTimeMillis);
                return false;
            }
            if (new File(fileZze, "pcbc").exists()) {
                zzi(5019, jCurrentTimeMillis);
                return true;
            }
            zzi(4027, jCurrentTimeMillis);
            return false;
        }
    }
}
