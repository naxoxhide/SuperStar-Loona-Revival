package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgrz;
import com.google.android.gms.internal.ads.zzgsa;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzgsa<MessageType extends zzgsa<MessageType, BuilderType>, BuilderType extends zzgrz<MessageType, BuilderType>> implements zzgvj {
    protected int zza = 0;

    /* JADX WARN: Multi-variable type inference failed */
    protected static void zzav(Iterable iterable, List list) {
        byte[] bArr = zzguj.zzd;
        Objects.requireNonNull(iterable);
        if (iterable instanceof zzgur) {
            List listZzh = ((zzgur) iterable).zzh();
            zzgur zzgurVar = (zzgur) list;
            int size = list.size();
            for (Object obj : listZzh) {
                if (obj == null) {
                    String str = "Element at index " + (zzgurVar.size() - size) + " is null.";
                    int size2 = zzgurVar.size();
                    while (true) {
                        size2--;
                        if (size2 < size) {
                            throw new NullPointerException(str);
                        }
                        zzgurVar.remove(size2);
                    }
                } else if (obj instanceof zzgsr) {
                    zzgurVar.zzi((zzgsr) obj);
                } else {
                    zzgurVar.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof zzgvq) {
            list.addAll(iterable);
            return;
        }
        if (list instanceof ArrayList) {
            ((ArrayList) list).ensureCapacity(list.size() + iterable.size());
        }
        int size3 = list.size();
        for (Object obj2 : iterable) {
            if (obj2 == null) {
                String str2 = "Element at index " + (list.size() - size3) + " is null.";
                int size4 = list.size();
                while (true) {
                    size4--;
                    if (size4 < size3) {
                        throw new NullPointerException(str2);
                    }
                    list.remove(size4);
                }
            } else {
                list.add(obj2);
            }
        }
    }

    int zzat(zzgwc zzgwcVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzgvj
    public final zzgsr zzau() {
        try {
            int iZzaz = zzaz();
            zzgsr zzgsrVar = zzgsr.zzb;
            byte[] bArr = new byte[iZzaz];
            zzgtg zzgtgVarZzC = zzgtg.zzC(bArr, 0, iZzaz);
            zzaW(zzgtgVarZzC);
            zzgtgVarZzC.zzD();
            return new zzgsn(bArr);
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a ByteString threw an IOException (should never happen).", e);
        }
    }

    public final void zzaw(OutputStream outputStream) throws IOException {
        int iZzaz = zzaz();
        int i = zzgtg.zzf;
        if (iZzaz > 4096) {
            iZzaz = 4096;
        }
        zzgte zzgteVar = new zzgte(outputStream, iZzaz);
        zzaW(zzgteVar);
        zzgteVar.zzI();
    }

    public final byte[] zzax() {
        try {
            int iZzaz = zzaz();
            byte[] bArr = new byte[iZzaz];
            zzgtg zzgtgVarZzC = zzgtg.zzC(bArr, 0, iZzaz);
            zzaW(zzgtgVarZzC);
            zzgtgVarZzC.zzD();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e);
        }
    }
}
