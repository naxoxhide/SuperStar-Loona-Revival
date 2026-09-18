package com.google.android.gms.internal.ads;

import androidx.core.view.ViewCompat;
import com.google.common.net.HttpHeaders;
import com.google.firebase.sessions.settings.RemoteSettings;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzahn {
    static final String[] zza = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", HttpHeaders.TRAILER, "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};
    public static final /* synthetic */ int zzb = 0;

    public static zzbx zza(zzfb zzfbVar) {
        String str;
        int iZzc = zzfbVar.zzc() + zzfbVar.zzf();
        int iZzf = zzfbVar.zzf();
        int i = (iZzf >> 24) & 255;
        zzbx zzafaVar = null;
        try {
            if (i == 169 || i == 253) {
                int i2 = iZzf & ViewCompat.MEASURED_SIZE_MASK;
                if (i2 == 6516084) {
                    int iZzf2 = zzfbVar.zzf();
                    if (zzfbVar.zzf() == 1684108385) {
                        zzfbVar.zzH(8);
                        String strZzx = zzfbVar.zzx(iZzf2 - 16);
                        zzafaVar = new zzafa("und", strZzx, strZzx);
                    } else {
                        zzer.zzf("MetadataUtil", "Failed to parse comment attribute: ".concat(zzagy.zzf(iZzf)));
                    }
                    zzfbVar.zzG(iZzc);
                    return zzafaVar;
                }
                if (i2 == 7233901 || i2 == 7631467) {
                    zzafp zzafpVarZze = zze(iZzf, "TIT2", zzfbVar);
                    zzfbVar.zzG(iZzc);
                    return zzafpVarZze;
                }
                if (i2 == 6516589 || i2 == 7828084) {
                    zzafp zzafpVarZze2 = zze(iZzf, "TCOM", zzfbVar);
                    zzfbVar.zzG(iZzc);
                    return zzafpVarZze2;
                }
                if (i2 == 6578553) {
                    zzafp zzafpVarZze3 = zze(iZzf, "TDRC", zzfbVar);
                    zzfbVar.zzG(iZzc);
                    return zzafpVarZze3;
                }
                if (i2 == 4280916) {
                    zzafp zzafpVarZze4 = zze(iZzf, "TPE1", zzfbVar);
                    zzfbVar.zzG(iZzc);
                    return zzafpVarZze4;
                }
                if (i2 == 7630703) {
                    zzafp zzafpVarZze5 = zze(iZzf, "TSSE", zzfbVar);
                    zzfbVar.zzG(iZzc);
                    return zzafpVarZze5;
                }
                if (i2 == 6384738) {
                    zzafp zzafpVarZze6 = zze(iZzf, "TALB", zzfbVar);
                    zzfbVar.zzG(iZzc);
                    return zzafpVarZze6;
                }
                if (i2 == 7108978) {
                    zzafp zzafpVarZze7 = zze(iZzf, "USLT", zzfbVar);
                    zzfbVar.zzG(iZzc);
                    return zzafpVarZze7;
                }
                if (i2 == 6776174) {
                    zzafp zzafpVarZze8 = zze(iZzf, "TCON", zzfbVar);
                    zzfbVar.zzG(iZzc);
                    return zzafpVarZze8;
                }
                if (i2 == 6779504) {
                    zzafp zzafpVarZze9 = zze(iZzf, "TIT1", zzfbVar);
                    zzfbVar.zzG(iZzc);
                    return zzafpVarZze9;
                }
            } else {
                if (iZzf == 1735291493) {
                    int iZzb = zzb(zzfbVar);
                    String str2 = (iZzb <= 0 || iZzb > 192) ? null : zza[iZzb - 1];
                    if (str2 != null) {
                        zzafaVar = new zzafp("TCON", null, zzfvs.zzm(str2));
                    } else {
                        zzer.zzf("MetadataUtil", "Failed to parse standard genre code");
                    }
                    zzfbVar.zzG(iZzc);
                    return zzafaVar;
                }
                if (iZzf == 1684632427) {
                    zzafp zzafpVarZzd = zzd(1684632427, "TPOS", zzfbVar);
                    zzfbVar.zzG(iZzc);
                    return zzafpVarZzd;
                }
                if (iZzf == 1953655662) {
                    zzafp zzafpVarZzd2 = zzd(1953655662, "TRCK", zzfbVar);
                    zzfbVar.zzG(iZzc);
                    return zzafpVarZzd2;
                }
                if (iZzf == 1953329263) {
                    zzafh zzafhVarZzc = zzc(1953329263, "TBPM", zzfbVar, true, false);
                    zzfbVar.zzG(iZzc);
                    return zzafhVarZzc;
                }
                if (iZzf == 1668311404) {
                    zzafh zzafhVarZzc2 = zzc(1668311404, "TCMP", zzfbVar, true, true);
                    zzfbVar.zzG(iZzc);
                    return zzafhVarZzc2;
                }
                if (iZzf == 1668249202) {
                    int iZzf3 = zzfbVar.zzf();
                    if (zzfbVar.zzf() == 1684108385) {
                        int iZzf4 = zzfbVar.zzf() & ViewCompat.MEASURED_SIZE_MASK;
                        if (iZzf4 == 13) {
                            str = "image/jpeg";
                        } else if (iZzf4 == 14) {
                            str = "image/png";
                            iZzf4 = 14;
                        } else {
                            str = null;
                        }
                        if (str == null) {
                            zzer.zzf("MetadataUtil", "Unrecognized cover art flags: " + iZzf4);
                        } else {
                            zzfbVar.zzH(4);
                            int i3 = iZzf3 - 16;
                            byte[] bArr = new byte[i3];
                            zzfbVar.zzC(bArr, 0, i3);
                            zzafaVar = new zzaes(str, null, 3, bArr);
                        }
                    } else {
                        zzer.zzf("MetadataUtil", "Failed to parse cover art attribute");
                    }
                    zzfbVar.zzG(iZzc);
                    return zzafaVar;
                }
                if (iZzf == 1631670868) {
                    zzafp zzafpVarZze10 = zze(1631670868, "TPE2", zzfbVar);
                    zzfbVar.zzG(iZzc);
                    return zzafpVarZze10;
                }
                if (iZzf == 1936682605) {
                    zzafp zzafpVarZze11 = zze(1936682605, "TSOT", zzfbVar);
                    zzfbVar.zzG(iZzc);
                    return zzafpVarZze11;
                }
                if (iZzf == 1936679276) {
                    zzafp zzafpVarZze12 = zze(1936679276, "TSO2", zzfbVar);
                    zzfbVar.zzG(iZzc);
                    return zzafpVarZze12;
                }
                if (iZzf == 1936679282) {
                    zzafp zzafpVarZze13 = zze(1936679282, "TSOA", zzfbVar);
                    zzfbVar.zzG(iZzc);
                    return zzafpVarZze13;
                }
                if (iZzf == 1936679265) {
                    zzafp zzafpVarZze14 = zze(1936679265, "TSOP", zzfbVar);
                    zzfbVar.zzG(iZzc);
                    return zzafpVarZze14;
                }
                if (iZzf == 1936679791) {
                    zzafp zzafpVarZze15 = zze(1936679791, "TSOC", zzfbVar);
                    zzfbVar.zzG(iZzc);
                    return zzafpVarZze15;
                }
                if (iZzf == 1920233063) {
                    zzafh zzafhVarZzc3 = zzc(1920233063, "ITUNESADVISORY", zzfbVar, false, false);
                    zzfbVar.zzG(iZzc);
                    return zzafhVarZzc3;
                }
                if (iZzf == 1885823344) {
                    zzafh zzafhVarZzc4 = zzc(1885823344, "ITUNESGAPLESS", zzfbVar, false, true);
                    zzfbVar.zzG(iZzc);
                    return zzafhVarZzc4;
                }
                if (iZzf == 1936683886) {
                    zzafp zzafpVarZze16 = zze(1936683886, "TVSHOWSORT", zzfbVar);
                    zzfbVar.zzG(iZzc);
                    return zzafpVarZze16;
                }
                if (iZzf == 1953919848) {
                    zzafp zzafpVarZze17 = zze(1953919848, "TVSHOW", zzfbVar);
                    zzfbVar.zzG(iZzc);
                    return zzafpVarZze17;
                }
                if (iZzf == 757935405) {
                    String strZzx2 = null;
                    String strZzx3 = null;
                    int i4 = -1;
                    int i5 = -1;
                    while (zzfbVar.zzc() < iZzc) {
                        int iZzc2 = zzfbVar.zzc();
                        int iZzf5 = zzfbVar.zzf();
                        int iZzf6 = zzfbVar.zzf();
                        zzfbVar.zzH(4);
                        if (iZzf6 == 1835360622) {
                            strZzx2 = zzfbVar.zzx(iZzf5 - 12);
                        } else {
                            int i6 = iZzf5 - 12;
                            if (iZzf6 == 1851878757) {
                                strZzx3 = zzfbVar.zzx(i6);
                            } else {
                                if (iZzf6 == 1684108385) {
                                    i5 = iZzf5;
                                }
                                if (iZzf6 == 1684108385) {
                                    i4 = iZzc2;
                                }
                                zzfbVar.zzH(i6);
                            }
                        }
                    }
                    if (strZzx2 != null && strZzx3 != null && i4 != -1) {
                        zzfbVar.zzG(i4);
                        zzfbVar.zzH(16);
                        zzafaVar = new zzafj(strZzx2, strZzx3, zzfbVar.zzx(i5 - 16));
                    }
                    zzfbVar.zzG(iZzc);
                    return zzafaVar;
                }
            }
            zzer.zzb("MetadataUtil", "Skipped unknown metadata entry: " + zzagy.zzf(iZzf));
            zzfbVar.zzG(iZzc);
            return null;
        } catch (Throwable th) {
            zzfbVar.zzG(iZzc);
            throw th;
        }
    }

    private static int zzb(zzfb zzfbVar) {
        zzfbVar.zzH(4);
        if (zzfbVar.zzf() == 1684108385) {
            zzfbVar.zzH(8);
            return zzfbVar.zzl();
        }
        zzer.zzf("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }

    private static zzafh zzc(int i, String str, zzfb zzfbVar, boolean z, boolean z2) {
        int iZzb = zzb(zzfbVar);
        if (z2) {
            iZzb = Math.min(1, iZzb);
        }
        if (iZzb >= 0) {
            return z ? new zzafp(str, null, zzfvs.zzm(Integer.toString(iZzb))) : new zzafa("und", str, Integer.toString(iZzb));
        }
        zzer.zzf("MetadataUtil", "Failed to parse uint8 attribute: ".concat(zzagy.zzf(i)));
        return null;
    }

    private static zzafp zzd(int i, String str, zzfb zzfbVar) {
        int iZzf = zzfbVar.zzf();
        if (zzfbVar.zzf() == 1684108385 && iZzf >= 22) {
            zzfbVar.zzH(10);
            int iZzp = zzfbVar.zzp();
            if (iZzp > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(iZzp);
                String string = sb.toString();
                int iZzp2 = zzfbVar.zzp();
                if (iZzp2 > 0) {
                    string = string + RemoteSettings.FORWARD_SLASH_STRING + iZzp2;
                }
                return new zzafp(str, null, zzfvs.zzm(string));
            }
        }
        zzer.zzf("MetadataUtil", "Failed to parse index/count attribute: ".concat(zzagy.zzf(i)));
        return null;
    }

    private static zzafp zze(int i, String str, zzfb zzfbVar) {
        int iZzf = zzfbVar.zzf();
        if (zzfbVar.zzf() == 1684108385) {
            zzfbVar.zzH(8);
            return new zzafp(str, null, zzfvs.zzm(zzfbVar.zzx(iZzf - 16)));
        }
        zzer.zzf("MetadataUtil", "Failed to parse text attribute: ".concat(zzagy.zzf(i)));
        return null;
    }
}
