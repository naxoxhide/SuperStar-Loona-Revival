package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfkg extends zzfkc {
    private static final Pattern zza = Pattern.compile("^[a-zA-Z0-9 ]+$");
    private final zzfke zzb;
    private final zzfkd zzc;
    private zzfmj zze;
    private zzflh zzf;
    private final List zzd = new ArrayList();
    private boolean zzg = false;
    private boolean zzh = false;
    private final String zzi = UUID.randomUUID().toString();

    zzfkg(zzfkd zzfkdVar, zzfke zzfkeVar) {
        this.zzc = zzfkdVar;
        this.zzb = zzfkeVar;
        zzk(null);
        if (zzfkeVar.zzd() == zzfkf.HTML || zzfkeVar.zzd() == zzfkf.JAVASCRIPT) {
            this.zzf = new zzfli(zzfkeVar.zza());
        } else {
            this.zzf = new zzfll(zzfkeVar.zzi(), null);
        }
        this.zzf.zzk();
        zzfku.zza().zzd(this);
        zzfla.zza().zzd(this.zzf.zza(), zzfkdVar.zzb());
    }

    private final void zzk(View view) {
        this.zze = new zzfmj(view);
    }

    @Override // com.google.android.gms.internal.ads.zzfkc
    public final void zzb(View view, zzfkj zzfkjVar, String str) {
        zzfkx zzfkxVar;
        if (this.zzh) {
            return;
        }
        if (!zza.matcher("Ad overlay").matches()) {
            throw new IllegalArgumentException("FriendlyObstruction has detailed reason that contains characters not in [a-z][A-Z][0-9] or space");
        }
        Iterator it = this.zzd.iterator();
        do {
            if (!it.hasNext()) {
                zzfkxVar = null;
                break;
            }
            zzfkxVar = (zzfkx) it.next();
        } while (zzfkxVar.zzb().get() != view);
        if (zzfkxVar == null) {
            this.zzd.add(new zzfkx(view, zzfkjVar, "Ad overlay"));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfkc
    public final void zzc() {
        if (this.zzh) {
            return;
        }
        this.zze.clear();
        if (!this.zzh) {
            this.zzd.clear();
        }
        this.zzh = true;
        zzfla.zza().zzc(this.zzf.zza());
        zzfku.zza().zze(this);
        this.zzf.zzc();
        this.zzf = null;
    }

    @Override // com.google.android.gms.internal.ads.zzfkc
    public final void zzd(View view) {
        if (this.zzh || zzf() == view) {
            return;
        }
        zzk(view);
        this.zzf.zzb();
        Collection<zzfkg> collectionZzc = zzfku.zza().zzc();
        if (collectionZzc == null || collectionZzc.isEmpty()) {
            return;
        }
        for (zzfkg zzfkgVar : collectionZzc) {
            if (zzfkgVar != this && zzfkgVar.zzf() == view) {
                zzfkgVar.zze.clear();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfkc
    public final void zze() {
        if (this.zzg) {
            return;
        }
        this.zzg = true;
        zzfku.zza().zzf(this);
        this.zzf.zzi(zzflb.zzb().zza());
        this.zzf.zze(zzfks.zza().zzb());
        this.zzf.zzg(this, this.zzb);
    }

    public final View zzf() {
        return (View) this.zze.get();
    }

    public final zzflh zzg() {
        return this.zzf;
    }

    public final String zzh() {
        return this.zzi;
    }

    public final List zzi() {
        return this.zzd;
    }

    public final boolean zzj() {
        return this.zzg && !this.zzh;
    }
}
