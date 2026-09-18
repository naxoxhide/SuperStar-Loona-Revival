package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.DeniedByServerException;
import android.media.MediaCodec;
import android.media.MediaDrm;
import android.media.MediaDrmResetException;
import android.media.NotProvisionedException;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.media.metrics.NetworkEvent;
import android.media.metrics.PlaybackErrorEvent;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.PlaybackStateEvent;
import android.media.metrics.TrackChangeEvent;
import android.os.SystemClock;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.util.Pair;
import androidx.core.view.PointerIconCompat;
import com.facebook.ads.AdError;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzoh implements zzme, zzoi {
    private final Context zza;
    private final zzoj zzb;
    private final PlaybackSession zzc;
    private String zzi;
    private PlaybackMetrics.Builder zzj;
    private int zzk;
    private zzce zzn;
    private zzog zzo;
    private zzog zzp;
    private zzog zzq;
    private zzam zzr;
    private zzam zzs;
    private zzam zzt;
    private boolean zzu;
    private boolean zzv;
    private int zzw;
    private int zzx;
    private int zzy;
    private boolean zzz;
    private final zzcu zze = new zzcu();
    private final zzcs zzf = new zzcs();
    private final HashMap zzh = new HashMap();
    private final HashMap zzg = new HashMap();
    private final long zzd = SystemClock.elapsedRealtime();
    private int zzl = 0;
    private int zzm = 0;

    private zzoh(Context context, PlaybackSession playbackSession) {
        this.zza = context.getApplicationContext();
        this.zzc = playbackSession;
        zzof zzofVar = new zzof(zzof.zza);
        this.zzb = zzofVar;
        zzofVar.zzh(this);
    }

    public static zzoh zzb(Context context) {
        MediaMetricsManager mediaMetricsManager = (MediaMetricsManager) context.getSystemService("media_metrics");
        if (mediaMetricsManager == null) {
            return null;
        }
        return new zzoh(context, mediaMetricsManager.createPlaybackSession());
    }

    private static int zzr(int i) {
        switch (zzfk.zzi(i)) {
            case AdError.ICONVIEW_MISSING_ERROR_CODE /* 6002 */:
                return 24;
            case AdError.AD_ASSETS_UNSUPPORTED_TYPE_ERROR_CODE /* 6003 */:
                return 28;
            case 6004:
                return 25;
            case 6005:
                return 26;
            default:
                return 27;
        }
    }

    private final void zzs() {
        PlaybackMetrics.Builder builder = this.zzj;
        if (builder != null && this.zzz) {
            builder.setAudioUnderrunCount(this.zzy);
            this.zzj.setVideoFramesDropped(this.zzw);
            this.zzj.setVideoFramesPlayed(this.zzx);
            Long l = (Long) this.zzg.get(this.zzi);
            this.zzj.setNetworkTransferDurationMillis(l == null ? 0L : l.longValue());
            Long l2 = (Long) this.zzh.get(this.zzi);
            this.zzj.setNetworkBytesRead(l2 == null ? 0L : l2.longValue());
            this.zzj.setStreamSource((l2 == null || l2.longValue() <= 0) ? 0 : 1);
            this.zzc.reportPlaybackMetrics(this.zzj.build());
        }
        this.zzj = null;
        this.zzi = null;
        this.zzy = 0;
        this.zzw = 0;
        this.zzx = 0;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzz = false;
    }

    private final void zzt(long j, zzam zzamVar, int i) {
        if (zzfk.zzE(this.zzs, zzamVar)) {
            return;
        }
        int i2 = this.zzs == null ? 1 : 0;
        this.zzs = zzamVar;
        zzx(0, j, zzamVar, i2);
    }

    private final void zzu(long j, zzam zzamVar, int i) {
        if (zzfk.zzE(this.zzt, zzamVar)) {
            return;
        }
        int i2 = this.zzt == null ? 1 : 0;
        this.zzt = zzamVar;
        zzx(2, j, zzamVar, i2);
    }

    @RequiresNonNull({"metricsBuilder"})
    private final void zzv(zzcv zzcvVar, zztw zztwVar) {
        int iZza;
        PlaybackMetrics.Builder builder = this.zzj;
        if (zztwVar == null || (iZza = zzcvVar.zza(zztwVar.zza)) == -1) {
            return;
        }
        int i = 0;
        zzcvVar.zzd(iZza, this.zzf, false);
        zzcvVar.zze(this.zzf.zzd, this.zze, 0L);
        zzbi zzbiVar = this.zze.zze.zzd;
        if (zzbiVar != null) {
            int iZzm = zzfk.zzm(zzbiVar.zzb);
            if (iZzm == 0) {
                i = 3;
            } else if (iZzm != 1) {
                i = iZzm != 2 ? 1 : 4;
            } else {
                i = 5;
            }
        }
        builder.setStreamType(i);
        zzcu zzcuVar = this.zze;
        if (zzcuVar.zzo != -9223372036854775807L && !zzcuVar.zzm && !zzcuVar.zzj && !zzcuVar.zzb()) {
            builder.setMediaDurationMillis(zzfk.zzs(this.zze.zzo));
        }
        builder.setPlaybackType(true != this.zze.zzb() ? 1 : 2);
        this.zzz = true;
    }

    private final void zzw(long j, zzam zzamVar, int i) {
        if (zzfk.zzE(this.zzr, zzamVar)) {
            return;
        }
        int i2 = this.zzr == null ? 1 : 0;
        this.zzr = zzamVar;
        zzx(1, j, zzamVar, i2);
    }

    private final void zzx(int i, long j, zzam zzamVar, int i2) {
        TrackChangeEvent.Builder timeSinceCreatedMillis = new TrackChangeEvent.Builder(i).setTimeSinceCreatedMillis(j - this.zzd);
        if (zzamVar != null) {
            timeSinceCreatedMillis.setTrackState(1);
            timeSinceCreatedMillis.setTrackChangeReason(i2 != 1 ? 1 : 2);
            String str = zzamVar.zzl;
            if (str != null) {
                timeSinceCreatedMillis.setContainerMimeType(str);
            }
            String str2 = zzamVar.zzm;
            if (str2 != null) {
                timeSinceCreatedMillis.setSampleMimeType(str2);
            }
            String str3 = zzamVar.zzj;
            if (str3 != null) {
                timeSinceCreatedMillis.setCodecName(str3);
            }
            int i3 = zzamVar.zzi;
            if (i3 != -1) {
                timeSinceCreatedMillis.setBitrate(i3);
            }
            int i4 = zzamVar.zzr;
            if (i4 != -1) {
                timeSinceCreatedMillis.setWidth(i4);
            }
            int i5 = zzamVar.zzs;
            if (i5 != -1) {
                timeSinceCreatedMillis.setHeight(i5);
            }
            int i6 = zzamVar.zzz;
            if (i6 != -1) {
                timeSinceCreatedMillis.setChannelCount(i6);
            }
            int i7 = zzamVar.zzA;
            if (i7 != -1) {
                timeSinceCreatedMillis.setAudioSampleRate(i7);
            }
            String str4 = zzamVar.zzd;
            if (str4 != null) {
                int i8 = zzfk.zza;
                String[] strArrSplit = str4.split("-", -1);
                Pair pairCreate = Pair.create(strArrSplit[0], strArrSplit.length >= 2 ? strArrSplit[1] : null);
                timeSinceCreatedMillis.setLanguage((String) pairCreate.first);
                if (pairCreate.second != null) {
                    timeSinceCreatedMillis.setLanguageRegion((String) pairCreate.second);
                }
            }
            float f = zzamVar.zzt;
            if (f != -1.0f) {
                timeSinceCreatedMillis.setVideoFrameRate(f);
            }
        } else {
            timeSinceCreatedMillis.setTrackState(0);
        }
        this.zzz = true;
        this.zzc.reportTrackChangeEvent(timeSinceCreatedMillis.build());
    }

    @EnsuresNonNullIf(expression = {"#1"}, result = true)
    private final boolean zzy(zzog zzogVar) {
        if (zzogVar != null) {
            return zzogVar.zzc.equals(this.zzb.zze());
        }
        return false;
    }

    public final LogSessionId zza() {
        return this.zzc.getSessionId();
    }

    @Override // com.google.android.gms.internal.ads.zzoi
    public final void zzc(zzmc zzmcVar, String str) {
        zztw zztwVar = zzmcVar.zzd;
        if (zztwVar == null || !zztwVar.zzb()) {
            zzs();
            this.zzi = str;
            this.zzj = new PlaybackMetrics.Builder().setPlayerName("AndroidXMedia3").setPlayerVersion("1.2.0-alpha01");
            zzv(zzmcVar.zzb, zzmcVar.zzd);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzoi
    public final void zzd(zzmc zzmcVar, String str, boolean z) {
        zztw zztwVar = zzmcVar.zzd;
        if ((zztwVar == null || !zztwVar.zzb()) && str.equals(this.zzi)) {
            zzs();
        }
        this.zzg.remove(str);
        this.zzh.remove(str);
    }

    @Override // com.google.android.gms.internal.ads.zzme
    public final /* synthetic */ void zze(zzmc zzmcVar, zzam zzamVar, zzie zzieVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzme
    public final void zzf(zzmc zzmcVar, int i, long j, long j2) {
        zztw zztwVar = zzmcVar.zzd;
        if (zztwVar != null) {
            zzoj zzojVar = this.zzb;
            zzcv zzcvVar = zzmcVar.zzb;
            HashMap map = this.zzh;
            String strZzf = zzojVar.zzf(zzcvVar, zztwVar);
            Long l = (Long) map.get(strZzf);
            Long l2 = (Long) this.zzg.get(strZzf);
            this.zzh.put(strZzf, Long.valueOf((l == null ? 0L : l.longValue()) + j));
            this.zzg.put(strZzf, Long.valueOf((l2 != null ? l2.longValue() : 0L) + ((long) i)));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzme
    public final void zzg(zzmc zzmcVar, zzts zztsVar) {
        zztw zztwVar = zzmcVar.zzd;
        if (zztwVar == null) {
            return;
        }
        zzam zzamVar = zztsVar.zzb;
        Objects.requireNonNull(zzamVar);
        zzog zzogVar = new zzog(zzamVar, 0, this.zzb.zzf(zzmcVar.zzb, zztwVar));
        int i = zztsVar.zza;
        if (i != 0) {
            if (i == 1) {
                this.zzp = zzogVar;
                return;
            } else if (i != 2) {
                if (i != 3) {
                    return;
                }
                this.zzq = zzogVar;
                return;
            }
        }
        this.zzo = zzogVar;
    }

    @Override // com.google.android.gms.internal.ads.zzme
    public final /* synthetic */ void zzh(zzmc zzmcVar, int i, long j) {
    }

    /* JADX WARN: Code duplicated, block: B:177:0x0293  */
    /* JADX WARN: Code duplicated, block: B:178:0x0298  */
    /* JADX WARN: Code duplicated, block: B:180:0x029b  */
    /* JADX WARN: Code duplicated, block: B:182:0x02a0  */
    /* JADX WARN: Code duplicated, block: B:188:0x02bd  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzme
    public final void zzi(zzco zzcoVar, zzmd zzmdVar) {
        int i;
        int i2;
        boolean z;
        int i3;
        int i4;
        zzad zzadVar;
        int i5;
        int i6;
        if (zzmdVar.zzb() != 0) {
            int errorCode = 0;
            for (int i7 = 0; i7 < zzmdVar.zzb(); i7++) {
                int iZza = zzmdVar.zza(i7);
                zzmc zzmcVarZzc = zzmdVar.zzc(iZza);
                if (iZza == 0) {
                    this.zzb.zzk(zzmcVarZzc);
                } else if (iZza == 11) {
                    this.zzb.zzj(zzmcVarZzc, this.zzk);
                } else {
                    this.zzb.zzi(zzmcVarZzc);
                }
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (zzmdVar.zzd(0)) {
                zzmc zzmcVarZzc2 = zzmdVar.zzc(0);
                if (this.zzj != null) {
                    zzv(zzmcVarZzc2.zzb, zzmcVarZzc2.zzd);
                }
            }
            if (zzmdVar.zzd(2) && this.zzj != null) {
                zzfvs zzfvsVarZza = zzcoVar.zzo().zza();
                int size = zzfvsVarZza.size();
                int i8 = 0;
                loop1: while (true) {
                    if (i8 >= size) {
                        zzadVar = null;
                        break;
                    }
                    zzdf zzdfVar = (zzdf) zzfvsVarZza.get(i8);
                    char c = 0;
                    while (true) {
                        int i9 = zzdfVar.zzb;
                        i6 = i8 + 1;
                        if (c <= 0) {
                            if (zzdfVar.zzd(0) && (zzadVar = zzdfVar.zzb(0).zzp) != null) {
                                break loop1;
                            } else {
                                c = 1;
                            }
                        }
                    }
                    i8 = i6;
                }
                if (zzadVar != null) {
                    PlaybackMetrics.Builder builder = this.zzj;
                    int i10 = zzfk.zza;
                    int i11 = 0;
                    while (true) {
                        if (i11 >= zzadVar.zzb) {
                            i5 = 1;
                            break;
                        }
                        UUID uuid = zzadVar.zza(i11).zza;
                        if (uuid.equals(zzo.zzd)) {
                            i5 = 3;
                            break;
                        } else if (uuid.equals(zzo.zze)) {
                            i5 = 2;
                            break;
                        } else {
                            if (uuid.equals(zzo.zzc)) {
                                i5 = 6;
                                break;
                            }
                            i11++;
                        }
                    }
                    builder.setDrmType(i5);
                }
            }
            if (zzmdVar.zzd(PointerIconCompat.TYPE_COPY)) {
                this.zzy++;
            }
            zzce zzceVar = this.zzn;
            if (zzceVar != null) {
                Context context = this.zza;
                int iZzr = 14;
                int i12 = 23;
                if (zzceVar.zzb == 1001) {
                    iZzr = 20;
                } else {
                    zzil zzilVar = (zzil) zzceVar;
                    boolean z2 = zzilVar.zze == 1;
                    int i13 = zzilVar.zzi;
                    Throwable cause = zzceVar.getCause();
                    Objects.requireNonNull(cause);
                    if (!(cause instanceof IOException)) {
                        if (z2 && (i13 == 0 || i13 == 1)) {
                            i12 = 35;
                        } else {
                            if (z2 && i13 == 3) {
                                iZzr = 15;
                            } else if (!z2 || i13 != 2) {
                                if (cause instanceof zzsc) {
                                    errorCode = zzfk.zzj(((zzsc) cause).zzd);
                                    i12 = 13;
                                } else if (cause instanceof zzrx) {
                                    errorCode = zzfk.zzj(((zzrx) cause).zzb);
                                } else if (!(cause instanceof OutOfMemoryError)) {
                                    if (cause instanceof zzpe) {
                                        errorCode = ((zzpe) cause).zza;
                                        iZzr = 17;
                                    } else if (cause instanceof zzph) {
                                        errorCode = ((zzph) cause).zza;
                                        iZzr = 18;
                                    } else {
                                        int i14 = zzfk.zza;
                                        if (cause instanceof MediaCodec.CryptoException) {
                                            errorCode = ((MediaCodec.CryptoException) cause).getErrorCode();
                                            iZzr = zzr(errorCode);
                                        } else {
                                            iZzr = 22;
                                        }
                                    }
                                }
                            }
                            i12 = iZzr;
                        }
                        errorCode = 0;
                    } else if (cause instanceof zzhd) {
                        errorCode = ((zzhd) cause).zzd;
                        i12 = 5;
                    } else if ((cause instanceof zzhc) || (cause instanceof zzcc)) {
                        errorCode = 0;
                        i12 = 11;
                    } else {
                        boolean z3 = cause instanceof zzhb;
                        if (z3 || (cause instanceof zzhl)) {
                            if (zzez.zzb(context).zza() == 1) {
                                i12 = 3;
                            } else {
                                Throwable cause2 = cause.getCause();
                                if (cause2 instanceof UnknownHostException) {
                                    errorCode = 0;
                                    i12 = 6;
                                } else if (cause2 instanceof SocketTimeoutException) {
                                    errorCode = 0;
                                    i12 = 7;
                                } else if (z3 && ((zzhb) cause).zzc == 1) {
                                    errorCode = 0;
                                    i12 = 4;
                                } else {
                                    errorCode = 0;
                                    i12 = 8;
                                }
                            }
                        } else if (zzceVar.zzb == 1002) {
                            i12 = 21;
                        } else if (cause instanceof zzqv) {
                            Throwable cause3 = cause.getCause();
                            Objects.requireNonNull(cause3);
                            if (zzfk.zza < 21 || !(cause3 instanceof MediaDrm.MediaDrmStateException)) {
                                if (zzfk.zza >= 23 && (cause3 instanceof MediaDrmResetException)) {
                                    iZzr = 27;
                                } else if (cause3 instanceof NotProvisionedException) {
                                    iZzr = 24;
                                } else if (cause3 instanceof DeniedByServerException) {
                                    iZzr = 29;
                                } else if (!(cause3 instanceof zzrg)) {
                                    iZzr = cause3 instanceof zzqt ? 28 : 30;
                                }
                                i12 = iZzr;
                            } else {
                                errorCode = zzfk.zzj(((MediaDrm.MediaDrmStateException) cause3).getDiagnosticInfo());
                                iZzr = zzr(errorCode);
                            }
                        } else if ((cause instanceof zzgx) && (cause.getCause() instanceof FileNotFoundException)) {
                            Throwable cause4 = cause.getCause();
                            Objects.requireNonNull(cause4);
                            Throwable cause5 = cause4.getCause();
                            if (zzfk.zza >= 21 && (cause5 instanceof ErrnoException) && ((ErrnoException) cause5).errno == OsConstants.EACCES) {
                                iZzr = 32;
                                i12 = iZzr;
                            } else {
                                i12 = 31;
                            }
                        } else {
                            i12 = 9;
                        }
                        errorCode = 0;
                    }
                    this.zzc.reportPlaybackErrorEvent(new PlaybackErrorEvent.Builder().setTimeSinceCreatedMillis(jElapsedRealtime - this.zzd).setErrorCode(i12).setSubErrorCode(errorCode).setException(zzceVar).build());
                    this.zzz = true;
                    this.zzn = null;
                }
                i12 = iZzr;
                this.zzc.reportPlaybackErrorEvent(new PlaybackErrorEvent.Builder().setTimeSinceCreatedMillis(jElapsedRealtime - this.zzd).setErrorCode(i12).setSubErrorCode(errorCode).setException(zzceVar).build());
                this.zzz = true;
                this.zzn = null;
            }
            if (zzmdVar.zzd(2)) {
                zzdg zzdgVarZzo = zzcoVar.zzo();
                boolean zZzb = zzdgVarZzo.zzb(2);
                boolean zZzb2 = zzdgVarZzo.zzb(1);
                boolean zZzb3 = zzdgVarZzo.zzb(3);
                if (zZzb || zZzb2) {
                    if (zZzb) {
                        i4 = 0;
                    } else {
                        i4 = 0;
                        zzw(jElapsedRealtime, null, 0);
                    }
                    if (!zZzb2) {
                        zzt(jElapsedRealtime, null, i4);
                    }
                    if (!zZzb3) {
                        zzu(jElapsedRealtime, null, i4);
                    }
                } else if (zZzb3) {
                    zZzb3 = true;
                    if (zZzb) {
                        i4 = 0;
                        zzw(jElapsedRealtime, null, 0);
                    } else {
                        i4 = 0;
                    }
                    if (!zZzb2) {
                        zzt(jElapsedRealtime, null, i4);
                    }
                    if (!zZzb3) {
                        zzu(jElapsedRealtime, null, i4);
                    }
                }
            }
            if (zzy(this.zzo)) {
                zzog zzogVar = this.zzo;
                zzam zzamVar = zzogVar.zza;
                if (zzamVar.zzs != -1) {
                    int i15 = zzogVar.zzb;
                    i = 0;
                    zzw(jElapsedRealtime, zzamVar, 0);
                    this.zzo = null;
                } else {
                    i = 0;
                }
            } else {
                i = 0;
            }
            if (zzy(this.zzp)) {
                zzog zzogVar2 = this.zzp;
                zzam zzamVar2 = zzogVar2.zza;
                int i16 = zzogVar2.zzb;
                zzt(jElapsedRealtime, zzamVar2, i);
                this.zzp = null;
            }
            if (zzy(this.zzq)) {
                zzog zzogVar3 = this.zzq;
                zzam zzamVar3 = zzogVar3.zza;
                int i17 = zzogVar3.zzb;
                zzu(jElapsedRealtime, zzamVar3, i);
                this.zzq = null;
            }
            switch (zzez.zzb(this.zza).zza()) {
                case 0:
                    i2 = 0;
                    break;
                case 1:
                    i2 = 9;
                    break;
                case 2:
                    i2 = 2;
                    break;
                case 3:
                    i2 = 4;
                    break;
                case 4:
                    i2 = 5;
                    break;
                case 5:
                    i2 = 6;
                    break;
                case 6:
                case 8:
                default:
                    i2 = 1;
                    break;
                case 7:
                    i2 = 3;
                    break;
                case 9:
                    i2 = 8;
                    break;
                case 10:
                    i2 = 7;
                    break;
            }
            if (i2 != this.zzm) {
                this.zzm = i2;
                this.zzc.reportNetworkEvent(new NetworkEvent.Builder().setNetworkType(i2).setTimeSinceCreatedMillis(jElapsedRealtime - this.zzd).build());
            }
            if (zzcoVar.zzf() != 2) {
                z = false;
                this.zzu = false;
            } else {
                z = false;
            }
            if (((zzlx) zzcoVar).zzC() == null) {
                this.zzv = z;
            } else if (zzmdVar.zzd(10)) {
                this.zzv = true;
            }
            int iZzf = zzcoVar.zzf();
            if (this.zzu) {
                i3 = 5;
            } else if (this.zzv) {
                i3 = 13;
            } else {
                i3 = 4;
                if (iZzf == 4) {
                    i3 = 11;
                } else if (iZzf == 2) {
                    int i18 = this.zzl;
                    if (i18 == 0 || i18 == 2) {
                        i3 = 2;
                    } else if (zzcoVar.zzv()) {
                        i3 = zzcoVar.zzg() != 0 ? 10 : 6;
                    } else {
                        i3 = 7;
                    }
                } else if (iZzf != 3) {
                    i3 = (iZzf != 1 || this.zzl == 0) ? this.zzl : 12;
                } else if (zzcoVar.zzv()) {
                    i3 = zzcoVar.zzg() != 0 ? 9 : 3;
                }
            }
            if (this.zzl != i3) {
                this.zzl = i3;
                this.zzz = true;
                this.zzc.reportPlaybackStateEvent(new PlaybackStateEvent.Builder().setState(this.zzl).setTimeSinceCreatedMillis(jElapsedRealtime - this.zzd).build());
            }
            if (zzmdVar.zzd(1028)) {
                this.zzb.zzg(zzmdVar.zzc(1028));
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzme
    public final void zzj(zzmc zzmcVar, zztn zztnVar, zzts zztsVar, IOException iOException, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzme
    public final /* synthetic */ void zzk(zzmc zzmcVar, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzme
    public final void zzl(zzmc zzmcVar, zzce zzceVar) {
        this.zzn = zzceVar;
    }

    @Override // com.google.android.gms.internal.ads.zzme
    public final void zzm(zzmc zzmcVar, zzcn zzcnVar, zzcn zzcnVar2, int i) {
        if (i == 1) {
            this.zzu = true;
            i = 1;
        }
        this.zzk = i;
    }

    @Override // com.google.android.gms.internal.ads.zzme
    public final /* synthetic */ void zzn(zzmc zzmcVar, Object obj, long j) {
    }

    @Override // com.google.android.gms.internal.ads.zzme
    public final void zzo(zzmc zzmcVar, zzid zzidVar) {
        this.zzw += zzidVar.zzg;
        this.zzx += zzidVar.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzme
    public final /* synthetic */ void zzp(zzmc zzmcVar, zzam zzamVar, zzie zzieVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzme
    public final void zzq(zzmc zzmcVar, zzdm zzdmVar) {
        zzog zzogVar = this.zzo;
        if (zzogVar != null) {
            zzam zzamVar = zzogVar.zza;
            if (zzamVar.zzs == -1) {
                zzak zzakVarZzb = zzamVar.zzb();
                zzakVarZzb.zzab(zzdmVar.zzc);
                zzakVarZzb.zzH(zzdmVar.zzd);
                this.zzo = new zzog(zzakVarZzb.zzac(), 0, zzogVar.zzc);
            }
        }
    }
}
