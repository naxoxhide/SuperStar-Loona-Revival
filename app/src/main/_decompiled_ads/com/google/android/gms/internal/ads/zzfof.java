package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.common.util.Hex;
import java.io.File;
import java.util.HashSet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfof {
    final File zza;
    private final File zzb;
    private final SharedPreferences zzc;
    private final int zzd;

    public zzfof(Context context, int i) {
        this.zzc = context.getSharedPreferences("pcvmspf", 0);
        File dir = context.getDir("pccache", 0);
        zzfog.zza(dir, false);
        this.zzb = dir;
        File dir2 = context.getDir("tmppccache", 0);
        zzfog.zza(dir2, true);
        this.zza = dir2;
        this.zzd = i;
    }

    private final File zzd() {
        File file = new File(this.zzb, Integer.toString(this.zzd - 1));
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    private final String zze() {
        StringBuilder sb = new StringBuilder();
        sb.append("FBAMTD");
        sb.append(this.zzd - 1);
        return sb.toString();
    }

    private final String zzf() {
        StringBuilder sb = new StringBuilder();
        sb.append("LATMTD");
        sb.append(this.zzd - 1);
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0087  */
    public final boolean zza(zzaui zzauiVar, zzfol zzfolVar) {
        boolean z;
        String strZzk = zzauiVar.zzd().zzk();
        byte[] bArrZzA = zzauiVar.zzf().zzA();
        byte[] bArrZzA2 = zzauiVar.zze().zzA();
        if (!TextUtils.isEmpty(strZzk) && bArrZzA2 != null && bArrZzA2.length != 0) {
            zzfog.zzd(this.zza);
            this.zza.mkdirs();
            zzfog.zzc(strZzk, this.zza).mkdirs();
            File fileZzb = zzfog.zzb(strZzk, "pcam.jar", this.zza);
            if ((bArrZzA == null || bArrZzA.length <= 0 || zzfog.zze(fileZzb, bArrZzA)) && zzfog.zze(zzfog.zzb(strZzk, "pcbc", this.zza), bArrZzA2)) {
                File fileZzb2 = zzfog.zzb(zzauiVar.zzd().zzk(), "pcam.jar", this.zza);
                if (fileZzb2.exists() && zzfolVar != null && !zzfolVar.zza(fileZzb2)) {
                    return false;
                }
                String strZzk2 = zzauiVar.zzd().zzk();
                if (TextUtils.isEmpty(strZzk2)) {
                    z = false;
                } else {
                    File fileZzb3 = zzfog.zzb(strZzk2, "pcam.jar", this.zza);
                    File fileZzb4 = zzfog.zzb(strZzk2, "pcbc", this.zza);
                    File fileZzb5 = zzfog.zzb(strZzk2, "pcam.jar", zzd());
                    File fileZzb6 = zzfog.zzb(strZzk2, "pcbc", zzd());
                    if ((!fileZzb3.exists() || fileZzb3.renameTo(fileZzb5)) && fileZzb4.exists() && fileZzb4.renameTo(fileZzb6)) {
                        zzauk zzaukVarZze = zzaul.zze();
                        zzaukVarZze.zze(zzauiVar.zzd().zzk());
                        zzaukVarZze.zza(zzauiVar.zzd().zzj());
                        zzaukVarZze.zzb(zzauiVar.zzd().zza());
                        zzaukVarZze.zzd(zzauiVar.zzd().zzd());
                        zzaukVarZze.zzc(zzauiVar.zzd().zzc());
                        zzaul zzaulVar = (zzaul) zzaukVarZze.zzal();
                        zzaul zzaulVarZzb = zzb(1);
                        SharedPreferences.Editor editorEdit = this.zzc.edit();
                        if (zzaulVarZzb != null && !zzaulVar.zzk().equals(zzaulVarZzb.zzk())) {
                            editorEdit.putString(zze(), Hex.bytesToStringLowercase(zzaulVarZzb.zzax()));
                        }
                        editorEdit.putString(zzf(), Hex.bytesToStringLowercase(zzaulVar.zzax()));
                        if (editorEdit.commit()) {
                            z = true;
                        } else {
                            z = false;
                        }
                    } else {
                        z = false;
                    }
                }
                HashSet hashSet = new HashSet();
                zzaul zzaulVarZzb2 = zzb(1);
                if (zzaulVarZzb2 != null) {
                    hashSet.add(zzaulVarZzb2.zzk());
                }
                zzaul zzaulVarZzb3 = zzb(2);
                if (zzaulVarZzb3 != null) {
                    hashSet.add(zzaulVarZzb3.zzk());
                }
                for (File file : zzd().listFiles()) {
                    String name = file.getName();
                    if (!hashSet.contains(name)) {
                        zzfog.zzd(zzfog.zzc(name, zzd()));
                    }
                }
                return z;
            }
        }
        return false;
    }

    final zzaul zzb(int i) {
        String string = i == 1 ? this.zzc.getString(zzf(), null) : this.zzc.getString(zze(), null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            byte[] bArrStringToBytes = Hex.stringToBytes(string);
            zzgsr zzgsrVar = zzgsr.zzb;
            zzaul zzaulVarZzh = zzaul.zzh(zzgsr.zzv(bArrStringToBytes, 0, bArrStringToBytes.length));
            String strZzk = zzaulVarZzh.zzk();
            File fileZzb = zzfog.zzb(strZzk, "pcam.jar", zzd());
            if (!fileZzb.exists()) {
                fileZzb = zzfog.zzb(strZzk, "pcam", zzd());
            }
            File fileZzb2 = zzfog.zzb(strZzk, "pcbc", zzd());
            if (fileZzb.exists() && fileZzb2.exists()) {
                return zzaulVarZzh;
            }
            return null;
        } catch (zzgul unused) {
        }
    }

    public final zzfoe zzc(int i) {
        zzaul zzaulVarZzb = zzb(1);
        if (zzaulVarZzb == null) {
            return null;
        }
        String strZzk = zzaulVarZzb.zzk();
        File fileZzb = zzfog.zzb(strZzk, "pcam.jar", zzd());
        if (!fileZzb.exists()) {
            fileZzb = zzfog.zzb(strZzk, "pcam", zzd());
        }
        return new zzfoe(zzaulVarZzb, fileZzb, zzfog.zzb(strZzk, "pcbc", zzd()), zzfog.zzb(strZzk, "pcopt", zzd()));
    }
}
