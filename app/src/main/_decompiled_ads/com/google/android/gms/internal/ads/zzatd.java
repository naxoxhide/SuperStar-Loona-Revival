package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApkChecksum;
import android.content.pm.PackageManager;
import android.os.Build;
import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzatd extends zzaud {
    private static final zzaue zzi = new zzaue();
    private final Context zzj;

    public zzatd(zzasp zzaspVar, String str, String str2, zzaom zzaomVar, int i, int i2, Context context, zzaof zzaofVar) {
        super(zzaspVar, "p0JEft1H0Ux+/zQoofBGK8/hHhAdN3veKIjNmetX6I2+7J67s0tf2NBKaWy11XvI", "yaxGJhC1WxugM+8EfEc/xAIuDWtPkz77G//hU7f/vWw=", zzaomVar, i, 27);
        this.zzj = context;
    }

    private final String zzc() {
        try {
            if (this.zzb.zzl() != null) {
                this.zzb.zzl().get();
            }
            zzapj zzapjVarZzc = this.zzb.zzc();
            if (zzapjVarZzc == null || !zzapjVarZzc.zzaj()) {
                return null;
            }
            return zzapjVarZzc.zzh();
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaud
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        int i;
        zzaqa zzaqaVar;
        AtomicReference atomicReferenceZza = zzi.zza(this.zzj.getPackageName());
        synchronized (atomicReferenceZza) {
            zzaqa zzaqaVar2 = (zzaqa) atomicReferenceZza.get();
            if (zzaqaVar2 == null || zzass.zzd(zzaqaVar2.zza) || zzaqaVar2.zza.equals("E") || zzaqaVar2.zza.equals("0000000000000000000000000000000000000000000000000000000000000000")) {
                if (zzass.zzd(null)) {
                    (!zzass.zzd(null) ? false : false).booleanValue();
                    i = 3;
                } else {
                    i = 5;
                }
                Boolean boolValueOf = Boolean.valueOf(i == 3);
                Boolean bool = (Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzcj);
                String strZzb = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzci)).booleanValue() ? zzb() : null;
                if (bool.booleanValue() && this.zzb.zzp() && zzass.zzd(strZzb)) {
                    strZzb = zzc();
                }
                zzaqa zzaqaVar3 = new zzaqa((String) this.zzf.invoke(null, this.zzj, boolValueOf, strZzb));
                if (zzass.zzd(zzaqaVar3.zza) || zzaqaVar3.zza.equals("E")) {
                    int i2 = i - 1;
                    if (i2 == 3) {
                        String strZzc = zzc();
                        if (!zzass.zzd(strZzc)) {
                            zzaqaVar3.zza = strZzc;
                        }
                    } else if (i2 == 4) {
                        throw null;
                    }
                }
                atomicReferenceZza.set(zzaqaVar3);
            }
            zzaqaVar = (zzaqa) atomicReferenceZza.get();
        }
        synchronized (this.zze) {
            if (zzaqaVar != null) {
                this.zze.zzx(zzaqaVar.zza);
                this.zze.zzX(zzaqaVar.zzb);
                this.zze.zzZ(zzaqaVar.zzc);
                this.zze.zzi(zzaqaVar.zzd);
                this.zze.zzw(zzaqaVar.zze);
            }
        }
    }

    protected final String zzb() {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            byte[] bArrZzf = zzass.zzf((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzck));
            ArrayList arrayList = new ArrayList();
            arrayList.add(certificateFactory.generateCertificate(new ByteArrayInputStream(bArrZzf)));
            if (!Build.TYPE.equals("user")) {
                arrayList.add(certificateFactory.generateCertificate(new ByteArrayInputStream(zzass.zzf((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzcl)))));
            }
            Context context = this.zzj;
            String packageName = context.getPackageName();
            this.zzb.zzk();
            if (Build.VERSION.SDK_INT <= 30 && !Build.VERSION.CODENAME.equals("S")) {
                return null;
            }
            final zzgal zzgalVarZze = zzgal.zze();
            context.getPackageManager().requestChecksums(packageName, false, 8, arrayList, new PackageManager.OnChecksumsReadyListener() { // from class: com.google.android.gms.internal.ads.zzauf
                @Override // android.content.pm.PackageManager.OnChecksumsReadyListener
                public final void onChecksumsReady(List list) {
                    zzgal zzgalVar = zzgalVarZze;
                    if (list == null) {
                        zzgalVar.zzc(null);
                        return;
                    }
                    try {
                        int size = list.size();
                        for (int i = 0; i < size; i++) {
                            ApkChecksum apkChecksum = (ApkChecksum) list.get(i);
                            if (apkChecksum.getType() == 8) {
                                zzgalVar.zzc(zzass.zzb(apkChecksum.getValue()));
                                return;
                            }
                        }
                        zzgalVar.zzc(null);
                    } catch (Throwable unused) {
                        zzgalVar.zzc(null);
                    }
                }
            });
            return (String) zzgalVarZze.get();
        } catch (PackageManager.NameNotFoundException | InterruptedException | NoClassDefFoundError | CertificateEncodingException | CertificateException | ExecutionException unused) {
            return null;
        }
    }
}
