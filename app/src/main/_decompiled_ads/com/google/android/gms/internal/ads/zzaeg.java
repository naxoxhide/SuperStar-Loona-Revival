package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaeg {
    private static final String[] zza = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};
    private static final String[] zzb = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};
    private static final String[] zzc = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    public static zzaec zza(String str) throws IOException {
        long j;
        try {
            XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
            xmlPullParserNewPullParser.setInput(new StringReader(str));
            xmlPullParserNewPullParser.next();
            if (!zzfl.zzc(xmlPullParserNewPullParser, "x:xmpmeta")) {
                throw zzcc.zza("Couldn't find xmp metadata", null);
            }
            zzfvs zzfvsVarZzl = zzfvs.zzl();
            long j2 = -9223372036854775807L;
            do {
                xmlPullParserNewPullParser.next();
                if (zzfl.zzc(xmlPullParserNewPullParser, "rdf:Description")) {
                    String[] strArr = zza;
                    int i = 0;
                    for (int i2 = 0; i2 < 4; i2++) {
                        String strZza = zzfl.zza(xmlPullParserNewPullParser, strArr[i2]);
                        if (strZza != null) {
                            if (Integer.parseInt(strZza) != 1) {
                                return null;
                            }
                            String[] strArr2 = zzb;
                            int i3 = 0;
                            while (true) {
                                if (i3 < 4) {
                                    String strZza2 = zzfl.zza(xmlPullParserNewPullParser, strArr2[i3]);
                                    if (strZza2 != null) {
                                        j = Long.parseLong(strZza2);
                                        if (j != -1) {
                                            break;
                                        }
                                    } else {
                                        i3++;
                                    }
                                }
                                j = -9223372036854775807L;
                                break;
                            }
                            String[] strArr3 = zzc;
                            while (true) {
                                if (i >= 2) {
                                    zzfvsVarZzl = zzfvs.zzl();
                                    break;
                                }
                                String strZza3 = zzfl.zza(xmlPullParserNewPullParser, strArr3[i]);
                                if (strZza3 != null) {
                                    zzfvsVarZzl = zzfvs.zzn(new zzaeb("image/jpeg", "Primary", 0L, 0L), new zzaeb("video/mp4", "MotionPhoto", Long.parseLong(strZza3), 0L));
                                    break;
                                }
                                i++;
                            }
                            j2 = j;
                        }
                    }
                    return null;
                }
                if (zzfl.zzc(xmlPullParserNewPullParser, "Container:Directory")) {
                    zzfvsVarZzl = zzb(xmlPullParserNewPullParser, "Container", "Item");
                } else if (zzfl.zzc(xmlPullParserNewPullParser, "GContainer:Directory")) {
                    zzfvsVarZzl = zzb(xmlPullParserNewPullParser, "GContainer", "GContainerItem");
                }
            } while (!zzfl.zzb(xmlPullParserNewPullParser, "x:xmpmeta"));
            if (zzfvsVarZzl.isEmpty()) {
                return null;
            }
            return new zzaec(j2, zzfvsVarZzl);
        } catch (zzcc | NumberFormatException | XmlPullParserException unused) {
            zzer.zzf("MotionPhotoXmpParser", "Ignoring unexpected XMP metadata");
            return null;
        }
    }

    private static zzfvs zzb(XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException, IOException {
        zzfvp zzfvpVar = new zzfvp();
        do {
            String strConcat = str.concat(":Item");
            xmlPullParser.next();
            if (zzfl.zzc(xmlPullParser, strConcat)) {
                String strConcat2 = str2.concat(":Mime");
                String strConcat3 = str2.concat(":Semantic");
                String strConcat4 = str2.concat(":Length");
                String strConcat5 = str2.concat(":Padding");
                String strZza = zzfl.zza(xmlPullParser, strConcat2);
                String strZza2 = zzfl.zza(xmlPullParser, strConcat3);
                String strZza3 = zzfl.zza(xmlPullParser, strConcat4);
                String strZza4 = zzfl.zza(xmlPullParser, strConcat5);
                if (strZza == null || strZza2 == null) {
                    return zzfvs.zzl();
                }
                zzfvpVar.zzf(new zzaeb(strZza, strZza2, strZza3 != null ? Long.parseLong(strZza3) : 0L, strZza4 != null ? Long.parseLong(strZza4) : 0L));
            }
        } while (!zzfl.zzb(xmlPullParser, str.concat(":Directory")));
        return zzfvpVar.zzi();
    }
}
