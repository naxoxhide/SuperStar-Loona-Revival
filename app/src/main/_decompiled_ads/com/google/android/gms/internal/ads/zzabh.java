package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import com.google.common.net.HttpHeaders;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzabh implements zzabt {
    private static final int[] zza = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 16, 15, 14, 17, 18, 19};
    private static final zzabg zzc = new zzabg(new zzabf() { // from class: com.google.android.gms.internal.ads.zzabd
        @Override // com.google.android.gms.internal.ads.zzabf
        public final Constructor zza() {
            if (Boolean.TRUE.equals(Class.forName("androidx.media3.decoder.flac.FlacLibrary").getMethod("isAvailable", new Class[0]).invoke(null, new Object[0]))) {
                return Class.forName("androidx.media3.decoder.flac.FlacExtractor").asSubclass(zzabm.class).getConstructor(Integer.TYPE);
            }
            return null;
        }
    });
    private static final zzabg zzd = new zzabg(new zzabf() { // from class: com.google.android.gms.internal.ads.zzabe
        @Override // com.google.android.gms.internal.ads.zzabf
        public final Constructor zza() {
            return Class.forName("androidx.media3.decoder.midi.MidiExtractor").asSubclass(zzabm.class).getConstructor(new Class[0]);
        }
    });
    private zzfvs zze;
    private final zzair zzf = new zzair();

    /* JADX WARN: Code duplicated, block: B:128:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:154:0x0215  */
    /* JADX WARN: Code duplicated, block: B:30:0x0077  */
    @Override // com.google.android.gms.internal.ads.zzabt
    public final synchronized zzabm[] zza(Uri uri, Map map) {
        byte b2;
        int i;
        zzabm[] zzabmVarArr;
        ArrayList arrayList = new ArrayList(19);
        List list = (List) map.get(HttpHeaders.CONTENT_TYPE);
        String str = (list == null || list.isEmpty()) ? null : (String) list.get(0);
        int i2 = 1;
        if (str != null) {
            int i3 = zzcb.zza;
            int iHashCode = str.hashCode();
            if (iHashCode != -1007807498) {
                if (iHashCode != -586683234) {
                    if (iHashCode == 187090231 && str.equals("audio/mp3")) {
                        b2 = 1;
                    } else {
                        b2 = -1;
                    }
                } else if (str.equals("audio/x-wav")) {
                    b2 = 2;
                } else {
                    b2 = -1;
                }
            } else if (str.equals("audio/x-flac")) {
                b2 = 0;
            } else {
                b2 = -1;
            }
            if (b2 == 0) {
                str = "audio/flac";
            } else if (b2 == 1) {
                str = "audio/mpeg";
            } else if (b2 == 2) {
                str = "audio/wav";
            }
            switch (str) {
                case "audio/ac3":
                case "audio/eac3":
                case "audio/eac3-joc":
                    i = 0;
                    break;
                case "audio/ac4":
                    i = 1;
                    break;
                case "audio/amr":
                case "audio/3gpp":
                case "audio/amr-wb":
                    i = 3;
                    break;
                case "audio/flac":
                    i = 4;
                    break;
                case "video/x-flv":
                    i = 5;
                    break;
                case "audio/midi":
                    i = 15;
                    break;
                case "video/x-matroska":
                case "audio/x-matroska":
                case "video/webm":
                case "audio/webm":
                case "application/webm":
                    i = 6;
                    break;
                case "audio/mpeg":
                    i = 7;
                    break;
                case "video/mp4":
                case "audio/mp4":
                case "application/mp4":
                    i = 8;
                    break;
                case "audio/ogg":
                    i = 9;
                    break;
                case "video/mp2p":
                    i = 10;
                    break;
                case "video/mp2t":
                    i = 11;
                    break;
                case "audio/wav":
                    i = 12;
                    break;
                case "text/vtt":
                    i = 13;
                    break;
                case "image/jpeg":
                    i = 14;
                    break;
                case "video/x-msvideo":
                    i = 16;
                    break;
                case "image/png":
                    i = 17;
                    break;
                case "image/webp":
                    i = 18;
                    break;
                case "image/bmp":
                    i = 19;
                    break;
                default:
                    i = -1;
                    break;
            }
        } else {
            i = -1;
        }
        if (i != -1) {
            zzb(i, arrayList);
        }
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            i2 = -1;
        } else if (lastPathSegment.endsWith(DefaultHlsExtractorFactory.AC3_FILE_EXTENSION) || lastPathSegment.endsWith(DefaultHlsExtractorFactory.EC3_FILE_EXTENSION)) {
            i2 = 0;
        } else if (!lastPathSegment.endsWith(".ac4")) {
            if (lastPathSegment.endsWith(".adts") || lastPathSegment.endsWith(DefaultHlsExtractorFactory.AAC_FILE_EXTENSION)) {
                i2 = 2;
            } else if (lastPathSegment.endsWith(".amr")) {
                i2 = 3;
            } else if (lastPathSegment.endsWith(".flac")) {
                i2 = 4;
            } else if (lastPathSegment.endsWith(".flv")) {
                i2 = 5;
            } else if (lastPathSegment.endsWith(".mid") || lastPathSegment.endsWith(".midi") || lastPathSegment.endsWith(".smf")) {
                i2 = 15;
            } else if (lastPathSegment.startsWith(".mk", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".webm")) {
                i2 = 6;
            } else if (lastPathSegment.endsWith(DefaultHlsExtractorFactory.MP3_FILE_EXTENSION)) {
                i2 = 7;
            } else if (lastPathSegment.endsWith(".mp4") || lastPathSegment.startsWith(DefaultHlsExtractorFactory.M4_FILE_EXTENSION_PREFIX, lastPathSegment.length() - 4) || lastPathSegment.startsWith(".mp4", lastPathSegment.length() - 5) || lastPathSegment.startsWith(".cmf", lastPathSegment.length() - 5)) {
                i2 = 8;
            } else if (lastPathSegment.startsWith(".og", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".opus")) {
                i2 = 9;
            } else if (lastPathSegment.endsWith(".ps") || lastPathSegment.endsWith(".mpeg") || lastPathSegment.endsWith(".mpg") || lastPathSegment.endsWith(".m2p")) {
                i2 = 10;
            } else if (lastPathSegment.endsWith(".ts") || lastPathSegment.startsWith(".ts", lastPathSegment.length() - 4)) {
                i2 = 11;
            } else if (lastPathSegment.endsWith(".wav") || lastPathSegment.endsWith(".wave")) {
                i2 = 12;
            } else if (lastPathSegment.endsWith(DefaultHlsExtractorFactory.VTT_FILE_EXTENSION) || lastPathSegment.endsWith(DefaultHlsExtractorFactory.WEBVTT_FILE_EXTENSION)) {
                i2 = 13;
            } else if (lastPathSegment.endsWith(".jpg") || lastPathSegment.endsWith(".jpeg")) {
                i2 = 14;
            } else if (lastPathSegment.endsWith(".avi")) {
                i2 = 16;
            } else if (lastPathSegment.endsWith(".png")) {
                i2 = 17;
            } else if (lastPathSegment.endsWith(".webp")) {
                i2 = 18;
            } else if (lastPathSegment.endsWith(".bmp") || lastPathSegment.endsWith(".dib")) {
                i2 = 19;
            } else {
                i2 = -1;
            }
        }
        if (i2 != -1 && i2 != i) {
            zzb(i2, arrayList);
        }
        int[] iArr = zza;
        for (int i4 = 0; i4 < 19; i4++) {
            int i5 = iArr[i4];
            if (i5 != i && i5 != i2) {
                zzb(i5, arrayList);
            }
        }
        zzabmVarArr = new zzabm[arrayList.size()];
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            zzabmVarArr[i6] = (zzabm) arrayList.get(i6);
        }
        return zzabmVarArr;
    }

    private final void zzb(int i, List list) {
        switch (i) {
            case 0:
                list.add(new zzait());
                break;
            case 1:
                list.add(new zzaiw());
                break;
            case 2:
                list.add(new zzaiz(0));
                break;
            case 3:
                list.add(new zzada(0));
                break;
            case 4:
                zzabm zzabmVarZza = zzc.zza(0);
                if (zzabmVarZza == null) {
                    list.add(new zzads(0));
                } else {
                    list.add(zzabmVarZza);
                }
                break;
            case 5:
                list.add(new zzadv());
                break;
            case 6:
                list.add(new zzagj(0));
                break;
            case 7:
                list.add(new zzagr(0));
                break;
            case 8:
                list.add(new zzahm(0, null));
                list.add(new zzahr(0));
                break;
            case 9:
                list.add(new zzaif());
                break;
            case 10:
                list.add(new zzakc());
                break;
            case 11:
                if (this.zze == null) {
                    this.zze = zzfvs.zzl();
                }
                list.add(new zzakm(1, new zzfi(0L), new zzajb(0, this.zze), 112800));
                break;
            case 12:
                list.add(new zzaky());
                break;
            case 14:
                list.add(new zzaea());
                break;
            case 15:
                zzabm zzabmVarZza2 = zzd.zza(new Object[0]);
                if (zzabmVarZza2 != null) {
                    list.add(zzabmVarZza2);
                }
                break;
            case 16:
                list.add(new zzadf());
                break;
            case 17:
                list.add(new zzaiq());
                break;
            case 18:
                list.add(new zzald());
                break;
            case 19:
                list.add(new zzadm());
                break;
        }
    }
}
