package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgtv;
import com.google.android.gms.internal.ads.zzgtz;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzgtz<MessageType extends zzgtz<MessageType, BuilderType>, BuilderType extends zzgtv<MessageType, BuilderType>> extends zzgsa<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzgwu zzc = zzgwu.zzc();

    private final int zza(zzgwc zzgwcVar) {
        return zzgvr.zza().zzb(getClass()).zza(this);
    }

    static zzgtz zzaC(Class cls) {
        Map map = zzb;
        zzgtz zzgtzVar = (zzgtz) map.get(cls);
        if (zzgtzVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzgtzVar = (zzgtz) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzgtzVar == null) {
            zzgtzVar = (zzgtz) ((zzgtz) zzgxd.zzg(cls)).zzb(6, null, null);
            if (zzgtzVar == null) {
                throw new IllegalStateException();
            }
            map.put(cls, zzgtzVar);
        }
        return zzgtzVar;
    }

    protected static zzgtz zzaE(zzgtz zzgtzVar, zzgsr zzgsrVar) throws zzgul {
        zzgtl zzgtlVar = zzgtl.zza;
        zzgsz zzgszVarZzl = zzgsrVar.zzl();
        zzgtz zzgtzVarZzaD = zzgtzVar.zzaD();
        try {
            zzgwc zzgwcVarZzb = zzgvr.zza().zzb(zzgtzVarZzaD.getClass());
            zzgwcVarZzb.zzh(zzgtzVarZzaD, zzgta.zzq(zzgszVarZzl), zzgtlVar);
            zzgwcVarZzb.zzf(zzgtzVarZzaD);
            try {
                zzgszVarZzl.zzz(0);
                zzc(zzgtzVarZzaD);
                zzc(zzgtzVarZzaD);
                return zzgtzVarZzaD;
            } catch (zzgul e) {
                e.zzh(zzgtzVarZzaD);
                throw e;
            }
        } catch (zzgul e2) {
            e = e2;
            if (e.zzl()) {
                e = new zzgul(e);
            }
            e.zzh(zzgtzVarZzaD);
            throw e;
        } catch (zzgws e3) {
            zzgul zzgulVarZza = e3.zza();
            zzgulVarZza.zzh(zzgtzVarZzaD);
            throw zzgulVarZza;
        } catch (IOException e4) {
            if (e4.getCause() instanceof zzgul) {
                throw ((zzgul) e4.getCause());
            }
            zzgul zzgulVar = new zzgul(e4);
            zzgulVar.zzh(zzgtzVarZzaD);
            throw zzgulVar;
        } catch (RuntimeException e5) {
            if (e5.getCause() instanceof zzgul) {
                throw ((zzgul) e5.getCause());
            }
            throw e5;
        }
    }

    protected static zzgtz zzaF(zzgtz zzgtzVar, byte[] bArr) throws zzgul {
        zzgtz zzgtzVarZzd = zzd(zzgtzVar, bArr, 0, bArr.length, zzgtl.zza);
        zzc(zzgtzVarZzd);
        return zzgtzVarZzd;
    }

    protected static zzgtz zzaG(zzgtz zzgtzVar, zzgsr zzgsrVar, zzgtl zzgtlVar) throws zzgul {
        zzgsz zzgszVarZzl = zzgsrVar.zzl();
        zzgtz zzgtzVarZzaD = zzgtzVar.zzaD();
        try {
            zzgwc zzgwcVarZzb = zzgvr.zza().zzb(zzgtzVarZzaD.getClass());
            zzgwcVarZzb.zzh(zzgtzVarZzaD, zzgta.zzq(zzgszVarZzl), zzgtlVar);
            zzgwcVarZzb.zzf(zzgtzVarZzaD);
            try {
                zzgszVarZzl.zzz(0);
                zzc(zzgtzVarZzaD);
                return zzgtzVarZzaD;
            } catch (zzgul e) {
                e.zzh(zzgtzVarZzaD);
                throw e;
            }
        } catch (zzgul e2) {
            e = e2;
            if (e.zzl()) {
                e = new zzgul(e);
            }
            e.zzh(zzgtzVarZzaD);
            throw e;
        } catch (zzgws e3) {
            zzgul zzgulVarZza = e3.zza();
            zzgulVarZza.zzh(zzgtzVarZzaD);
            throw zzgulVarZza;
        } catch (IOException e4) {
            if (e4.getCause() instanceof zzgul) {
                throw ((zzgul) e4.getCause());
            }
            zzgul zzgulVar = new zzgul(e4);
            zzgulVar.zzh(zzgtzVarZzaD);
            throw zzgulVar;
        } catch (RuntimeException e5) {
            if (e5.getCause() instanceof zzgul) {
                throw ((zzgul) e5.getCause());
            }
            throw e5;
        }
    }

    protected static zzgtz zzaH(zzgtz zzgtzVar, InputStream inputStream, zzgtl zzgtlVar) throws zzgul {
        zzgsz zzgszVarZzH = zzgsz.zzH(inputStream, 4096);
        zzgtz zzgtzVarZzaD = zzgtzVar.zzaD();
        try {
            zzgwc zzgwcVarZzb = zzgvr.zza().zzb(zzgtzVarZzaD.getClass());
            zzgwcVarZzb.zzh(zzgtzVarZzaD, zzgta.zzq(zzgszVarZzH), zzgtlVar);
            zzgwcVarZzb.zzf(zzgtzVarZzaD);
            zzc(zzgtzVarZzaD);
            return zzgtzVarZzaD;
        } catch (zzgul e) {
            e = e;
            if (e.zzl()) {
                e = new zzgul(e);
            }
            e.zzh(zzgtzVarZzaD);
            throw e;
        } catch (zzgws e2) {
            zzgul zzgulVarZza = e2.zza();
            zzgulVarZza.zzh(zzgtzVarZzaD);
            throw zzgulVarZza;
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzgul) {
                throw ((zzgul) e3.getCause());
            }
            zzgul zzgulVar = new zzgul(e3);
            zzgulVar.zzh(zzgtzVarZzaD);
            throw zzgulVar;
        } catch (RuntimeException e4) {
            if (e4.getCause() instanceof zzgul) {
                throw ((zzgul) e4.getCause());
            }
            throw e4;
        }
    }

    protected static zzgtz zzaI(zzgtz zzgtzVar, byte[] bArr, zzgtl zzgtlVar) throws zzgul {
        zzgtz zzgtzVarZzd = zzd(zzgtzVar, bArr, 0, bArr.length, zzgtlVar);
        zzc(zzgtzVarZzd);
        return zzgtzVarZzd;
    }

    protected static zzgue zzaJ() {
        return zzgua.zzf();
    }

    protected static zzgue zzaK(zzgue zzgueVar) {
        int size = zzgueVar.size();
        return zzgueVar.zzd(size == 0 ? 10 : size + size);
    }

    protected static zzguh zzaL() {
        return zzguy.zzf();
    }

    protected static zzguh zzaM(zzguh zzguhVar) {
        int size = zzguhVar.size();
        return zzguhVar.zzd(size == 0 ? 10 : size + size);
    }

    protected static zzgui zzaN() {
        return zzgvs.zze();
    }

    protected static zzgui zzaO(zzgui zzguiVar) {
        int size = zzguiVar.size();
        return zzguiVar.zzd(size == 0 ? 10 : size + size);
    }

    static Object zzaQ(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected static Object zzaR(zzgvj zzgvjVar, String str, Object[] objArr) {
        return new zzgvt(zzgvjVar, str, objArr);
    }

    protected static void zzaU(Class cls, zzgtz zzgtzVar) {
        zzgtzVar.zzaT();
        zzb.put(cls, zzgtzVar);
    }

    private static zzgtz zzc(zzgtz zzgtzVar) throws zzgul {
        if (zzgtzVar == null || zzgtzVar.zzaX()) {
            return zzgtzVar;
        }
        zzgul zzgulVarZza = new zzgws(zzgtzVar).zza();
        zzgulVarZza.zzh(zzgtzVar);
        throw zzgulVarZza;
    }

    private static zzgtz zzd(zzgtz zzgtzVar, byte[] bArr, int i, int i2, zzgtl zzgtlVar) throws zzgul {
        zzgtz zzgtzVarZzaD = zzgtzVar.zzaD();
        try {
            zzgwc zzgwcVarZzb = zzgvr.zza().zzb(zzgtzVarZzaD.getClass());
            zzgwcVarZzb.zzi(zzgtzVarZzaD, bArr, 0, i2, new zzgsd(zzgtlVar));
            zzgwcVarZzb.zzf(zzgtzVarZzaD);
            return zzgtzVarZzaD;
        } catch (zzgul e) {
            e = e;
            if (e.zzl()) {
                e = new zzgul(e);
            }
            e.zzh(zzgtzVarZzaD);
            throw e;
        } catch (zzgws e2) {
            zzgul zzgulVarZza = e2.zza();
            zzgulVarZza.zzh(zzgtzVarZzaD);
            throw zzgulVarZza;
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzgul) {
                throw ((zzgul) e3.getCause());
            }
            zzgul zzgulVar = new zzgul(e3);
            zzgulVar.zzh(zzgtzVarZzaD);
            throw zzgulVar;
        } catch (IndexOutOfBoundsException unused) {
            zzgul zzgulVarZzj = zzgul.zzj();
            zzgulVarZzj.zzh(zzgtzVarZzaD);
            throw zzgulVarZzj;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzgvr.zza().zzb(getClass()).zzj(this, (zzgtz) obj);
    }

    public final int hashCode() {
        if (zzaY()) {
            return zzay();
        }
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int iZzay = zzay();
        this.zza = iZzay;
        return iZzay;
    }

    public final String toString() {
        return zzgvl.zza(this, super.toString());
    }

    protected final zzgtv zzaA() {
        return (zzgtv) zzb(5, null, null);
    }

    public final zzgtv zzaB() {
        zzgtv zzgtvVar = (zzgtv) zzb(5, null, null);
        zzgtvVar.zzaj(this);
        return zzgtvVar;
    }

    final zzgtz zzaD() {
        return (zzgtz) zzb(4, null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzgvj
    public final /* synthetic */ zzgvi zzaP() {
        return (zzgtv) zzb(5, null, null);
    }

    protected final void zzaS() {
        zzgvr.zza().zzb(getClass()).zzf(this);
        zzaT();
    }

    final void zzaT() {
        this.zzd &= Integer.MAX_VALUE;
    }

    final void zzaV(int i) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzgvj
    public final void zzaW(zzgtg zzgtgVar) throws IOException {
        zzgvr.zza().zzb(getClass()).zzm(this, zzgth.zza(zzgtgVar));
    }

    public final boolean zzaX() {
        boolean zBooleanValue = Boolean.TRUE.booleanValue();
        byte bByteValue = ((Byte) zzb(1, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzk = zzgvr.zza().zzb(getClass()).zzk(this);
        if (!zBooleanValue) {
            return zZzk;
        }
        zzb(2, true != zZzk ? null : this, null);
        return zZzk;
    }

    final boolean zzaY() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    @Override // com.google.android.gms.internal.ads.zzgsa
    final int zzat(zzgwc zzgwcVar) {
        if (zzaY()) {
            int iZza = zzgwcVar.zza(this);
            if (iZza >= 0) {
                return iZza;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + iZza);
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int iZza2 = zzgwcVar.zza(this);
        if (iZza2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | iZza2;
            return iZza2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iZza2);
    }

    final int zzay() {
        return zzgvr.zza().zzb(getClass()).zzb(this);
    }

    protected abstract Object zzb(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.ads.zzgvk
    public final /* synthetic */ zzgvj zzbf() {
        return (zzgtz) zzb(6, null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzgvj
    public final int zzaz() {
        int iZza;
        if (zzaY()) {
            iZza = zza(null);
            if (iZza < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + iZza);
            }
        } else {
            iZza = this.zzd & Integer.MAX_VALUE;
            if (iZza == Integer.MAX_VALUE) {
                iZza = zza(null);
                if (iZza < 0) {
                    throw new IllegalStateException("serialized size must be non-negative, was " + iZza);
                }
                this.zzd = (this.zzd & Integer.MIN_VALUE) | iZza;
            }
        }
        return iZza;
    }
}
