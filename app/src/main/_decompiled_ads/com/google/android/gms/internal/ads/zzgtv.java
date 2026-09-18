package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgtv;
import com.google.android.gms.internal.ads.zzgtz;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzgtv<MessageType extends zzgtz<MessageType, BuilderType>, BuilderType extends zzgtv<MessageType, BuilderType>> extends zzgrz<MessageType, BuilderType> {
    protected zzgtz zza;
    private final zzgtz zzb;

    protected zzgtv(MessageType messagetype) {
        this.zzb = messagetype;
        if (messagetype.zzaY()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.zza = messagetype.zzaD();
    }

    private static void zza(Object obj, Object obj2) {
        zzgvr.zza().zzb(obj.getClass()).zzg(obj, obj2);
    }

    @Override // com.google.android.gms.internal.ads.zzgrz
    /* JADX INFO: renamed from: zzai, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final zzgtv zzah() {
        zzgtv zzgtvVar = (zzgtv) this.zzb.zzb(5, null, null);
        zzgtvVar.zza = zzan();
        return zzgtvVar;
    }

    public final zzgtv zzaj(zzgtz zzgtzVar) {
        if (!this.zzb.equals(zzgtzVar)) {
            if (!this.zza.zzaY()) {
                zzaq();
            }
            zza(this.zza, zzgtzVar);
        }
        return this;
    }

    public final zzgtv zzak(byte[] bArr, int i, int i2, zzgtl zzgtlVar) throws zzgul {
        if (!this.zza.zzaY()) {
            zzaq();
        }
        try {
            zzgvr.zza().zzb(this.zza.getClass()).zzi(this.zza, bArr, 0, i2, new zzgsd(zzgtlVar));
            return this;
        } catch (zzgul e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
        } catch (IndexOutOfBoundsException unused) {
            throw zzgul.zzj();
        }
    }

    public final MessageType zzal() {
        MessageType messagetype = (MessageType) zzan();
        if (messagetype.zzaX()) {
            return messagetype;
        }
        throw new zzgws(messagetype);
    }

    @Override // com.google.android.gms.internal.ads.zzgvi
    /* JADX INFO: renamed from: zzam, reason: merged with bridge method [inline-methods] */
    public MessageType zzan() {
        if (!this.zza.zzaY()) {
            return (MessageType) this.zza;
        }
        this.zza.zzaS();
        return (MessageType) this.zza;
    }

    protected final void zzap() {
        if (this.zza.zzaY()) {
            return;
        }
        zzaq();
    }

    protected void zzaq() {
        zzgtz zzgtzVarZzaD = this.zzb.zzaD();
        zza(zzgtzVarZzaD, this.zza);
        this.zza = zzgtzVarZzaD;
    }

    @Override // com.google.android.gms.internal.ads.zzgvk
    public final /* synthetic */ zzgvj zzbf() {
        throw null;
    }
}
