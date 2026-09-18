package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzanc implements zzalq {
    private final zzanb zzc;
    private final Map zza = new LinkedHashMap(16, 0.75f, true);
    private long zzb = 0;
    private final int zzd = 5242880;

    public zzanc(zzanb zzanbVar, int i) {
        this.zzc = zzanbVar;
    }

    static int zze(InputStream inputStream) throws IOException {
        return (zzn(inputStream) << 24) | zzn(inputStream) | (zzn(inputStream) << 8) | (zzn(inputStream) << 16);
    }

    static long zzf(InputStream inputStream) throws IOException {
        return (((long) zzn(inputStream)) & 255) | ((((long) zzn(inputStream)) & 255) << 8) | ((((long) zzn(inputStream)) & 255) << 16) | ((((long) zzn(inputStream)) & 255) << 24) | ((((long) zzn(inputStream)) & 255) << 32) | ((((long) zzn(inputStream)) & 255) << 40) | ((((long) zzn(inputStream)) & 255) << 48) | ((((long) zzn(inputStream)) & 255) << 56);
    }

    static String zzh(zzana zzanaVar) throws IOException {
        return new String(zzm(zzanaVar, zzf(zzanaVar)), "UTF-8");
    }

    static void zzj(OutputStream outputStream, int i) throws IOException {
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static void zzk(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) j);
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 32));
        outputStream.write((byte) (j >>> 40));
        outputStream.write((byte) (j >>> 48));
        outputStream.write((byte) (j >>> 56));
    }

    static void zzl(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        int length = bytes.length;
        zzk(outputStream, length);
        outputStream.write(bytes, 0, length);
    }

    static byte[] zzm(zzana zzanaVar, long j) throws IOException {
        long jZza = zzanaVar.zza();
        if (j >= 0 && j <= jZza) {
            int i = (int) j;
            if (i == j) {
                byte[] bArr = new byte[i];
                new DataInputStream(zzanaVar).readFully(bArr);
                return bArr;
            }
        }
        throw new IOException("streamToBytes length=" + j + ", maxLength=" + jZza);
    }

    private static int zzn(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        if (i != -1) {
            return i;
        }
        throw new EOFException();
    }

    private final void zzo(String str, zzamz zzamzVar) {
        if (this.zza.containsKey(str)) {
            this.zzb += zzamzVar.zza - ((zzamz) this.zza.get(str)).zza;
        } else {
            this.zzb += zzamzVar.zza;
        }
        this.zza.put(str, zzamzVar);
    }

    private final void zzp(String str) {
        zzamz zzamzVar = (zzamz) this.zza.remove(str);
        if (zzamzVar != null) {
            this.zzb -= zzamzVar.zza;
        }
    }

    private static final String zzq(String str) {
        int length = str.length() / 2;
        return String.valueOf(String.valueOf(str.substring(0, length).hashCode())).concat(String.valueOf(String.valueOf(str.substring(length).hashCode())));
    }

    @Override // com.google.android.gms.internal.ads.zzalq
    public final synchronized zzalp zza(String str) {
        zzamz zzamzVar = (zzamz) this.zza.get(str);
        if (zzamzVar == null) {
            return null;
        }
        File fileZzg = zzg(str);
        try {
            zzana zzanaVar = new zzana(new BufferedInputStream(new FileInputStream(fileZzg)), fileZzg.length());
            try {
                zzamz zzamzVarZza = zzamz.zza(zzanaVar);
                if (!TextUtils.equals(str, zzamzVarZza.zzb)) {
                    zzams.zza("%s: key=%s, found=%s", fileZzg.getAbsolutePath(), str, zzamzVarZza.zzb);
                    zzp(str);
                    zzanaVar.close();
                    return null;
                }
                byte[] bArrZzm = zzm(zzanaVar, zzanaVar.zza());
                zzalp zzalpVar = new zzalp();
                zzalpVar.zza = bArrZzm;
                zzalpVar.zzb = zzamzVar.zzc;
                zzalpVar.zzc = zzamzVar.zzd;
                zzalpVar.zzd = zzamzVar.zze;
                zzalpVar.zze = zzamzVar.zzf;
                zzalpVar.zzf = zzamzVar.zzg;
                List<zzaly> list = zzamzVar.zzh;
                TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                for (zzaly zzalyVar : list) {
                    treeMap.put(zzalyVar.zza(), zzalyVar.zzb());
                }
                zzalpVar.zzg = treeMap;
                zzalpVar.zzh = Collections.unmodifiableList(zzamzVar.zzh);
                zzanaVar.close();
                return zzalpVar;
            } catch (Throwable th) {
                zzanaVar.close();
                throw th;
            }
        } catch (IOException e) {
            zzams.zza("%s: %s", fileZzg.getAbsolutePath(), e.toString());
            zzi(str);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalq
    public final synchronized void zzb() {
        File fileZza = this.zzc.zza();
        if (!fileZza.exists()) {
            if (fileZza.mkdirs()) {
                return;
            }
            zzams.zzb("Unable to create cache dir %s", fileZza.getAbsolutePath());
            return;
        }
        File[] fileArrListFiles = fileZza.listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                try {
                    long length = file.length();
                    zzana zzanaVar = new zzana(new BufferedInputStream(new FileInputStream(file)), length);
                    try {
                        zzamz zzamzVarZza = zzamz.zza(zzanaVar);
                        zzamzVarZza.zza = length;
                        zzo(zzamzVarZza.zzb, zzamzVarZza);
                        zzanaVar.close();
                    } catch (Throwable th) {
                        zzanaVar.close();
                        throw th;
                    }
                } catch (IOException unused) {
                    file.delete();
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalq
    public final synchronized void zzc(String str, boolean z) {
        zzalp zzalpVarZza = zza(str);
        if (zzalpVarZza != null) {
            zzalpVarZza.zzf = 0L;
            zzalpVarZza.zze = 0L;
            zzd(str, zzalpVarZza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalq
    public final synchronized void zzd(String str, zzalp zzalpVar) {
        long j = this.zzb;
        int length = zzalpVar.zza.length;
        long j2 = j + ((long) length);
        int i = this.zzd;
        if (j2 <= i || length <= i * 0.9f) {
            File fileZzg = zzg(str);
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileZzg));
                zzamz zzamzVar = new zzamz(str, zzalpVar);
                try {
                    zzj(bufferedOutputStream, 538247942);
                    zzl(bufferedOutputStream, zzamzVar.zzb);
                    String str2 = zzamzVar.zzc;
                    if (str2 == null) {
                        str2 = "";
                    }
                    zzl(bufferedOutputStream, str2);
                    zzk(bufferedOutputStream, zzamzVar.zzd);
                    zzk(bufferedOutputStream, zzamzVar.zze);
                    zzk(bufferedOutputStream, zzamzVar.zzf);
                    zzk(bufferedOutputStream, zzamzVar.zzg);
                    List<zzaly> list = zzamzVar.zzh;
                    if (list != null) {
                        zzj(bufferedOutputStream, list.size());
                        for (zzaly zzalyVar : list) {
                            zzl(bufferedOutputStream, zzalyVar.zza());
                            zzl(bufferedOutputStream, zzalyVar.zzb());
                        }
                    } else {
                        zzj(bufferedOutputStream, 0);
                    }
                    bufferedOutputStream.flush();
                    bufferedOutputStream.write(zzalpVar.zza);
                    bufferedOutputStream.close();
                    zzamzVar.zza = fileZzg.length();
                    zzo(str, zzamzVar);
                    if (this.zzb >= this.zzd) {
                        if (zzams.zzb) {
                            zzams.zzd("Pruning old cache entries.", new Object[0]);
                        }
                        long j3 = this.zzb;
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        Iterator it = this.zza.entrySet().iterator();
                        int i2 = 0;
                        while (it.hasNext()) {
                            zzamz zzamzVar2 = (zzamz) ((Map.Entry) it.next()).getValue();
                            if (zzg(zzamzVar2.zzb).delete()) {
                                this.zzb -= zzamzVar2.zza;
                            } else {
                                String str3 = zzamzVar2.zzb;
                                zzams.zza("Could not delete cache entry for key=%s, filename=%s", str3, zzq(str3));
                            }
                            it.remove();
                            i2++;
                            if (this.zzb < this.zzd * 0.9f) {
                                break;
                            }
                        }
                        if (zzams.zzb) {
                            zzams.zzd("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.zzb - j3), Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
                        }
                    }
                } catch (IOException e) {
                    zzams.zza("%s", e.toString());
                    bufferedOutputStream.close();
                    zzams.zza("Failed to write header for %s", fileZzg.getAbsolutePath());
                    throw new IOException();
                }
            } catch (IOException unused) {
                if (!fileZzg.delete()) {
                    zzams.zza("Could not clean up file %s", fileZzg.getAbsolutePath());
                }
                if (!this.zzc.zza().exists()) {
                    zzams.zza("Re-initializing cache after external clearing.", new Object[0]);
                    this.zza.clear();
                    this.zzb = 0L;
                    zzb();
                }
            }
        }
    }

    public final File zzg(String str) {
        return new File(this.zzc.zza(), zzq(str));
    }

    public final synchronized void zzi(String str) {
        boolean zDelete = zzg(str).delete();
        zzp(str);
        if (zDelete) {
            return;
        }
        zzams.zza("Could not delete cache entry for key=%s, filename=%s", str, zzq(str));
    }

    public zzanc(File file, int i) {
        this.zzc = new zzamy(this, file);
    }
}
