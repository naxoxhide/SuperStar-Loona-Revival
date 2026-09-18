package com.applovin.exoplayer2.e.g;

import com.applovin.exoplayer2.e.r;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.l.y;
import com.applovin.exoplayer2.v;
import com.google.common.net.HttpHeaders;
import com.google.firebase.sessions.settings.RemoteSettings;

/* JADX INFO: loaded from: classes.dex */
final class f {
    static final String[] Ay = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", HttpHeaders.TRAILER, "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};

    /* JADX WARN: Code duplicated, block: B:18:0x003c  */
    public static void a(int i, com.applovin.exoplayer2.g.a aVar, com.applovin.exoplayer2.g.a aVar2, v.a aVar3, com.applovin.exoplayer2.g.a... aVarArr) {
        com.applovin.exoplayer2.g.a aVar4 = new com.applovin.exoplayer2.g.a(new com.applovin.exoplayer2.g.a.InterfaceC0095a[0]);
        if (i == 1) {
            if (aVar == null) {
                aVar = aVar4;
                break;
            }
        } else {
            if (i != 2 || aVar2 == null) {
                aVar = aVar4;
                break;
            }
            int i2 = 0;
            while (true) {
                if (i2 >= aVar2.kD()) {
                    aVar = aVar4;
                    break;
                }
                com.applovin.exoplayer2.g.a.InterfaceC0095a interfaceC0095aDe = aVar2.de(i2);
                if (interfaceC0095aDe instanceof com.applovin.exoplayer2.g.f.a) {
                    com.applovin.exoplayer2.g.f.a aVar5 = (com.applovin.exoplayer2.g.f.a) interfaceC0095aDe;
                    if ("com.android.capture.fps".equals(aVar5.Jx)) {
                        aVar = new com.applovin.exoplayer2.g.a(aVar5);
                        break;
                    }
                }
                i2++;
            }
        }
        for (com.applovin.exoplayer2.g.a aVar6 : aVarArr) {
            aVar = aVar.g(aVar6);
        }
        if (aVar.kD() > 0) {
            aVar3.b(aVar);
        }
    }

    public static void a(int i, r rVar, v.a aVar) {
        if (i == 1 && rVar.ij()) {
            aVar.Q(rVar.dO).R(rVar.dP);
        }
    }

    public static com.applovin.exoplayer2.g.a.InterfaceC0095a z(y yVar) {
        int iIl = yVar.il() + yVar.px();
        int iPx = yVar.px();
        int i = (iPx >> 24) & 255;
        try {
            if (i == 169 || i == 253) {
                int i2 = 16777215 & iPx;
                if (i2 == 6516084) {
                    com.applovin.exoplayer2.g.e.e eVarB = b(iPx, yVar);
                    yVar.fx(iIl);
                    return eVarB;
                }
                if (i2 == 7233901 || i2 == 7631467) {
                    com.applovin.exoplayer2.g.e.l lVarA = a(iPx, "TIT2", yVar);
                    yVar.fx(iIl);
                    return lVarA;
                }
                if (i2 == 6516589 || i2 == 7828084) {
                    com.applovin.exoplayer2.g.e.l lVarA2 = a(iPx, "TCOM", yVar);
                    yVar.fx(iIl);
                    return lVarA2;
                }
                if (i2 == 6578553) {
                    com.applovin.exoplayer2.g.e.l lVarA3 = a(iPx, "TDRC", yVar);
                    yVar.fx(iIl);
                    return lVarA3;
                }
                if (i2 == 4280916) {
                    com.applovin.exoplayer2.g.e.l lVarA4 = a(iPx, "TPE1", yVar);
                    yVar.fx(iIl);
                    return lVarA4;
                }
                if (i2 == 7630703) {
                    com.applovin.exoplayer2.g.e.l lVarA5 = a(iPx, "TSSE", yVar);
                    yVar.fx(iIl);
                    return lVarA5;
                }
                if (i2 == 6384738) {
                    com.applovin.exoplayer2.g.e.l lVarA6 = a(iPx, "TALB", yVar);
                    yVar.fx(iIl);
                    return lVarA6;
                }
                if (i2 == 7108978) {
                    com.applovin.exoplayer2.g.e.l lVarA7 = a(iPx, "USLT", yVar);
                    yVar.fx(iIl);
                    return lVarA7;
                }
                if (i2 == 6776174) {
                    com.applovin.exoplayer2.g.e.l lVarA8 = a(iPx, "TCON", yVar);
                    yVar.fx(iIl);
                    return lVarA8;
                }
                if (i2 == 6779504) {
                    com.applovin.exoplayer2.g.e.l lVarA9 = a(iPx, "TIT1", yVar);
                    yVar.fx(iIl);
                    return lVarA9;
                }
            } else {
                if (iPx == 1735291493) {
                    com.applovin.exoplayer2.g.e.l lVarA10 = A(yVar);
                    yVar.fx(iIl);
                    return lVarA10;
                }
                if (iPx == 1684632427) {
                    com.applovin.exoplayer2.g.e.l lVarB = b(iPx, "TPOS", yVar);
                    yVar.fx(iIl);
                    return lVarB;
                }
                if (iPx == 1953655662) {
                    com.applovin.exoplayer2.g.e.l lVarB2 = b(iPx, "TRCK", yVar);
                    yVar.fx(iIl);
                    return lVarB2;
                }
                if (iPx == 1953329263) {
                    com.applovin.exoplayer2.g.e.h hVarA = a(iPx, "TBPM", yVar, true, false);
                    yVar.fx(iIl);
                    return hVarA;
                }
                if (iPx == 1668311404) {
                    com.applovin.exoplayer2.g.e.h hVarA2 = a(iPx, "TCMP", yVar, true, true);
                    yVar.fx(iIl);
                    return hVarA2;
                }
                if (iPx == 1668249202) {
                    com.applovin.exoplayer2.g.e.a aVarB = B(yVar);
                    yVar.fx(iIl);
                    return aVarB;
                }
                if (iPx == 1631670868) {
                    com.applovin.exoplayer2.g.e.l lVarA11 = a(iPx, "TPE2", yVar);
                    yVar.fx(iIl);
                    return lVarA11;
                }
                if (iPx == 1936682605) {
                    com.applovin.exoplayer2.g.e.l lVarA12 = a(iPx, "TSOT", yVar);
                    yVar.fx(iIl);
                    return lVarA12;
                }
                if (iPx == 1936679276) {
                    com.applovin.exoplayer2.g.e.l lVarA13 = a(iPx, "TSO2", yVar);
                    yVar.fx(iIl);
                    return lVarA13;
                }
                if (iPx == 1936679282) {
                    com.applovin.exoplayer2.g.e.l lVarA14 = a(iPx, "TSOA", yVar);
                    yVar.fx(iIl);
                    return lVarA14;
                }
                if (iPx == 1936679265) {
                    com.applovin.exoplayer2.g.e.l lVarA15 = a(iPx, "TSOP", yVar);
                    yVar.fx(iIl);
                    return lVarA15;
                }
                if (iPx == 1936679791) {
                    com.applovin.exoplayer2.g.e.l lVarA16 = a(iPx, "TSOC", yVar);
                    yVar.fx(iIl);
                    return lVarA16;
                }
                if (iPx == 1920233063) {
                    com.applovin.exoplayer2.g.e.h hVarA3 = a(iPx, "ITUNESADVISORY", yVar, false, false);
                    yVar.fx(iIl);
                    return hVarA3;
                }
                if (iPx == 1885823344) {
                    com.applovin.exoplayer2.g.e.h hVarA4 = a(iPx, "ITUNESGAPLESS", yVar, false, true);
                    yVar.fx(iIl);
                    return hVarA4;
                }
                if (iPx == 1936683886) {
                    com.applovin.exoplayer2.g.e.l lVarA17 = a(iPx, "TVSHOWSORT", yVar);
                    yVar.fx(iIl);
                    return lVarA17;
                }
                if (iPx == 1953919848) {
                    com.applovin.exoplayer2.g.e.l lVarA18 = a(iPx, "TVSHOW", yVar);
                    yVar.fx(iIl);
                    return lVarA18;
                }
                if (iPx == 757935405) {
                    com.applovin.exoplayer2.g.e.h hVarL = l(yVar, iIl);
                    yVar.fx(iIl);
                    return hVarL;
                }
            }
            q.f("MetadataUtil", "Skipped unknown metadata entry: " + a.ch(iPx));
            yVar.fx(iIl);
            return null;
        } catch (Throwable th) {
            yVar.fx(iIl);
            throw th;
        }
    }

    public static com.applovin.exoplayer2.g.f.a a(y yVar, int i, String str) {
        while (true) {
            int iIl = yVar.il();
            if (iIl >= i) {
                return null;
            }
            int iPx = yVar.px();
            if (yVar.px() == 1684108385) {
                int iPx2 = yVar.px();
                int iPx3 = yVar.px();
                int i2 = iPx - 16;
                byte[] bArr = new byte[i2];
                yVar.r(bArr, 0, i2);
                return new com.applovin.exoplayer2.g.f.a(str, bArr, iPx3, iPx2);
            }
            yVar.fx(iIl + iPx);
        }
    }

    private static com.applovin.exoplayer2.g.e.l a(int i, String str, y yVar) {
        int iPx = yVar.px();
        if (yVar.px() == 1684108385) {
            yVar.fz(8);
            return new com.applovin.exoplayer2.g.e.l(str, null, yVar.fC(iPx - 16));
        }
        q.h("MetadataUtil", "Failed to parse text attribute: " + a.ch(i));
        return null;
    }

    private static com.applovin.exoplayer2.g.e.e b(int i, y yVar) {
        int iPx = yVar.px();
        if (yVar.px() == 1684108385) {
            yVar.fz(8);
            String strFC = yVar.fC(iPx - 16);
            return new com.applovin.exoplayer2.g.e.e("und", strFC, strFC);
        }
        q.h("MetadataUtil", "Failed to parse comment attribute: " + a.ch(i));
        return null;
    }

    private static com.applovin.exoplayer2.g.e.h a(int i, String str, y yVar, boolean z, boolean z2) {
        int iC = C(yVar);
        if (z2) {
            iC = Math.min(1, iC);
        }
        if (iC < 0) {
            q.h("MetadataUtil", "Failed to parse uint8 attribute: " + a.ch(i));
            return null;
        }
        if (z) {
            return new com.applovin.exoplayer2.g.e.l(str, null, Integer.toString(iC));
        }
        return new com.applovin.exoplayer2.g.e.e("und", str, Integer.toString(iC));
    }

    private static com.applovin.exoplayer2.g.e.l b(int i, String str, y yVar) {
        int iPx = yVar.px();
        if (yVar.px() == 1684108385 && iPx >= 22) {
            yVar.fz(10);
            int iPp = yVar.pp();
            if (iPp > 0) {
                String str2 = "" + iPp;
                int iPp2 = yVar.pp();
                if (iPp2 > 0) {
                    str2 = str2 + RemoteSettings.FORWARD_SLASH_STRING + iPp2;
                }
                return new com.applovin.exoplayer2.g.e.l(str, null, str2);
            }
        }
        q.h("MetadataUtil", "Failed to parse index/count attribute: " + a.ch(i));
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0011  */
    private static com.applovin.exoplayer2.g.e.l A(y yVar) {
        String str;
        int iC = C(yVar);
        if (iC > 0) {
            String[] strArr = Ay;
            if (iC <= strArr.length) {
                str = strArr[iC - 1];
            } else {
                str = null;
            }
        } else {
            str = null;
        }
        if (str != null) {
            return new com.applovin.exoplayer2.g.e.l("TCON", null, str);
        }
        q.h("MetadataUtil", "Failed to parse standard genre code");
        return null;
    }

    private static com.applovin.exoplayer2.g.e.a B(y yVar) {
        String str;
        int iPx = yVar.px();
        if (yVar.px() == 1684108385) {
            int iCg = a.cg(yVar.px());
            if (iCg == 13) {
                str = "image/jpeg";
            } else {
                str = iCg == 14 ? "image/png" : null;
            }
            if (str == null) {
                q.h("MetadataUtil", "Unrecognized cover art flags: " + iCg);
                return null;
            }
            yVar.fz(4);
            int i = iPx - 16;
            byte[] bArr = new byte[i];
            yVar.r(bArr, 0, i);
            return new com.applovin.exoplayer2.g.e.a(str, null, 3, bArr);
        }
        q.h("MetadataUtil", "Failed to parse cover art attribute");
        return null;
    }

    private static com.applovin.exoplayer2.g.e.h l(y yVar, int i) {
        int i2 = -1;
        int i3 = -1;
        String strFC = null;
        String strFC2 = null;
        while (yVar.il() < i) {
            int iIl = yVar.il();
            int iPx = yVar.px();
            int iPx2 = yVar.px();
            yVar.fz(4);
            if (iPx2 == 1835360622) {
                strFC = yVar.fC(iPx - 12);
            } else if (iPx2 == 1851878757) {
                strFC2 = yVar.fC(iPx - 12);
            } else {
                if (iPx2 == 1684108385) {
                    i2 = iIl;
                    i3 = iPx;
                }
                yVar.fz(iPx - 12);
            }
        }
        if (strFC == null || strFC2 == null || i2 == -1) {
            return null;
        }
        yVar.fx(i2);
        yVar.fz(16);
        return new com.applovin.exoplayer2.g.e.i(strFC, strFC2, yVar.fC(i3 - 16));
    }

    private static int C(y yVar) {
        yVar.fz(4);
        if (yVar.px() == 1684108385) {
            yVar.fz(8);
            return yVar.po();
        }
        q.h("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }
}
