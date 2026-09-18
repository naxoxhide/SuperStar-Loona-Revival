package com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist;

import android.net.Uri;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.player.exoplayer2.i;
import com.fyber.inneractive.sdk.player.exoplayer2.l;
import com.fyber.inneractive.sdk.player.exoplayer2.source.t;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.y;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements y.a<c> {
    public static final Pattern a = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f1077b = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
    public static final Pattern c = Pattern.compile("CODECS=\"(.+?)\"");
    public static final Pattern d = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
    public static final Pattern e = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
    public static final Pattern f = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
    public static final Pattern g = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
    public static final Pattern h = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    public static final Pattern i = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    public static final Pattern j = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    public static final Pattern k = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    public static final Pattern l = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    public static final Pattern m = Pattern.compile("METHOD=(NONE|AES-128)");
    public static final Pattern n = Pattern.compile("URI=\"(.+?)\"");
    public static final Pattern o = Pattern.compile("IV=([^,.*]+)");
    public static final Pattern p = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    public static final Pattern q = Pattern.compile("LANGUAGE=\"(.+?)\"");
    public static final Pattern r = Pattern.compile("NAME=\"(.+?)\"");
    public static final Pattern s = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    public static final Pattern t = a("AUTOSELECT");
    public static final Pattern u = a("DEFAULT");
    public static final Pattern v = a("FORCED");

    public static class a {
        public final BufferedReader a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Queue<String> f1078b;
        public String c;

        public a(Queue<String> queue, BufferedReader bufferedReader) {
            this.f1078b = queue;
            this.a = bufferedReader;
        }

        public boolean a() throws IOException {
            String strTrim;
            if (this.c != null) {
                return true;
            }
            if (!this.f1078b.isEmpty()) {
                this.c = this.f1078b.poll();
                return true;
            }
            do {
                String line = this.a.readLine();
                this.c = line;
                if (line == null) {
                    return false;
                }
                strTrim = line.trim();
                this.c = strTrim;
            } while (strTrim.isEmpty());
            return true;
        }

        public String b() throws IOException {
            if (!a()) {
                return null;
            }
            String str = this.c;
            this.c = null;
            return str;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static b b(a aVar, String str) throws IOException {
        int i2;
        String hexString;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i3 = 2;
        int i4 = 0;
        int i5 = 1;
        long j2 = -9223372036854775807L;
        long j3 = -9223372036854775807L;
        long jA = 0;
        long j4 = 0;
        long j5 = 0;
        long j6 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        boolean z = false;
        int i11 = 0;
        boolean zEquals = false;
        int i12 = 1;
        b.a aVar2 = null;
        long j7 = -1;
        while (true) {
            String strA = null;
            String strB = null;
            while (true) {
                if (!aVar.a()) {
                    return new b(i6, str, j2, jA, i8, i9, i10, i12, j3, z, jA != 0, aVar2, arrayList, arrayList2);
                }
                String strB2 = aVar.b();
                if (strB2.startsWith("#EXT-X-PLAYLIST-TYPE")) {
                    String strB3 = b(strB2, g);
                    if ("VOD".equals(strB3)) {
                        i6 = i5;
                    } else if ("EVENT".equals(strB3)) {
                        i6 = i3;
                    } else {
                        i3 = 2;
                        i4 = 0;
                        i5 = 1;
                    }
                } else if (strB2.startsWith("#EXT-X-START")) {
                    j2 = (long) (Double.parseDouble(b(strB2, j)) * 1000000.0d);
                } else if (strB2.startsWith("#EXT-X-MAP")) {
                    String strB4 = b(strB2, n);
                    String strA2 = a(strB2, l);
                    if (strA2 != null) {
                        String[] strArrSplit = strA2.split("@");
                        j7 = Long.parseLong(strArrSplit[i4]);
                        if (strArrSplit.length > i5) {
                            j4 = Long.parseLong(strArrSplit[i5]);
                        }
                    }
                    aVar2 = new b.a(strB4, 0L, -1, -9223372036854775807L, false, null, null, j4, j7);
                    j4 = 0;
                    j7 = -1;
                } else if (strB2.startsWith("#EXT-X-TARGETDURATION")) {
                    j3 = 1000000 * ((long) Integer.parseInt(b(strB2, e)));
                } else if (strB2.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                    i11 = Integer.parseInt(b(strB2, h));
                    i10 = i11;
                } else if (strB2.startsWith("#EXT-X-VERSION")) {
                    i12 = Integer.parseInt(b(strB2, f));
                } else if (strB2.startsWith("#EXTINF")) {
                    j6 = (long) (Double.parseDouble(b(strB2, i)) * 1000000.0d);
                } else if (strB2.startsWith("#EXT-X-KEY")) {
                    zEquals = "AES-128".equals(b(strB2, m));
                    if (zEquals) {
                        strB = b(strB2, n);
                        strA = a(strB2, o);
                    }
                } else if (strB2.startsWith("#EXT-X-BYTERANGE")) {
                    String[] strArrSplit2 = b(strB2, k).split("@");
                    j7 = Long.parseLong(strArrSplit2[i4]);
                    if (strArrSplit2.length > i5) {
                        j4 = Long.parseLong(strArrSplit2[i5]);
                    }
                } else if (strB2.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                    i9 = Integer.parseInt(strB2.substring(strB2.indexOf(58) + i5));
                    i8 = i5;
                } else if (strB2.equals("#EXT-X-DISCONTINUITY")) {
                    i7++;
                } else if (strB2.startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
                    if (jA == 0) {
                        String strSubstring = strB2.substring(strB2.indexOf(58) + i5);
                        Matcher matcher = u.f.matcher(strSubstring);
                        if (!matcher.matches()) {
                            throw new l("Invalid date/time format: " + strSubstring);
                        }
                        if (matcher.group(9) == null || matcher.group(9).equalsIgnoreCase("Z")) {
                            i2 = i4;
                        } else {
                            i2 = (Integer.parseInt(matcher.group(12)) * 60) + Integer.parseInt(matcher.group(13));
                            if (matcher.group(11).equals("-")) {
                                i2 *= -1;
                            }
                        }
                        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
                        gregorianCalendar.clear();
                        gregorianCalendar.set(Integer.parseInt(matcher.group(i5)), Integer.parseInt(matcher.group(i3)) - 1, Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
                        if (!TextUtils.isEmpty(matcher.group(8))) {
                            gregorianCalendar.set(14, new BigDecimal("0." + matcher.group(8)).movePointRight(3).intValue());
                        }
                        long timeInMillis = gregorianCalendar.getTimeInMillis();
                        if (i2 != 0) {
                            timeInMillis -= (long) (i2 * 60000);
                        }
                        jA = com.fyber.inneractive.sdk.player.exoplayer2.b.a(timeInMillis) - j5;
                    }
                    i3 = 2;
                    i4 = 0;
                    i5 = 1;
                } else if (strB2.startsWith("#EXT-X-DATERANGE")) {
                    arrayList2.add(strB2);
                    i3 = 2;
                    i4 = 0;
                    i5 = 1;
                } else {
                    if (!strB2.startsWith("#")) {
                        if (zEquals) {
                            hexString = strA != null ? strA : Integer.toHexString(i11);
                        } else {
                            hexString = null;
                        }
                        int i13 = i11 + 1;
                        if (j7 == -1) {
                            j4 = 0;
                        }
                        arrayList.add(new b.a(strB2, j6, i7, j5, zEquals, strB, hexString, j4, j7));
                        j5 += j6;
                        if (j7 != -1) {
                            j4 += j7;
                        }
                        i11 = i13;
                        j7 = -1;
                        j6 = 0;
                    } else if (strB2.equals("#EXT-X-ENDLIST")) {
                        i3 = 2;
                        i4 = 0;
                        i5 = 1;
                        z = true;
                    }
                    i3 = 2;
                    i4 = 0;
                    i5 = 1;
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003f A[Catch: all -> 0x00fe, TryCatch #0 {all -> 0x00fe, blocks: (B:3:0x000f, B:5:0x0018, B:7:0x0020, B:10:0x0029, B:30:0x0068, B:32:0x006e, B:35:0x0079, B:37:0x0081, B:38:0x0092, B:40:0x009a, B:42:0x00a2, B:44:0x00aa, B:46:0x00b2, B:48:0x00ba, B:50:0x00c2, B:52:0x00ca, B:55:0x00d3, B:56:0x00d7, B:61:0x00f6, B:62:0x00fd, B:13:0x0030, B:15:0x0036, B:18:0x003f, B:21:0x0048, B:23:0x0051, B:25:0x0057, B:27:0x005d, B:28:0x0062), top: B:66:0x000f }] */
    /* JADX WARN: Code duplicated, block: B:21:0x0048 A[Catch: all -> 0x00fe, LOOP:2: B:17:0x003d->B:21:0x0048, LOOP_END, TryCatch #0 {all -> 0x00fe, blocks: (B:3:0x000f, B:5:0x0018, B:7:0x0020, B:10:0x0029, B:30:0x0068, B:32:0x006e, B:35:0x0079, B:37:0x0081, B:38:0x0092, B:40:0x009a, B:42:0x00a2, B:44:0x00aa, B:46:0x00b2, B:48:0x00ba, B:50:0x00c2, B:52:0x00ca, B:55:0x00d3, B:56:0x00d7, B:61:0x00f6, B:62:0x00fd, B:13:0x0030, B:15:0x0036, B:18:0x003f, B:21:0x0048, B:23:0x0051, B:25:0x0057, B:27:0x005d, B:28:0x0062), top: B:66:0x000f }] */
    /* JADX WARN: Code duplicated, block: B:85:0x004f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:86:0x0047 A[SYNTHETIC] */
    public Object a(Uri uri, InputStream inputStream) throws IOException {
        int i2;
        Object objA;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        LinkedList linkedList = new LinkedList();
        try {
            int i3 = bufferedReader.read();
            boolean zB = false;
            if (i3 == 239) {
                if (bufferedReader.read() == 187 && bufferedReader.read() == 191) {
                    i3 = bufferedReader.read();
                    while (i3 != -1) {
                        i3 = bufferedReader.read();
                    }
                    i2 = 0;
                    while (true) {
                        if (i2 < 7) {
                            while (i3 != -1) {
                                i3 = bufferedReader.read();
                            }
                            zB = u.b(i3);
                            break;
                        }
                        if (i3 != "#EXTM3U".charAt(i2)) {
                            break;
                            break;
                        }
                        i3 = bufferedReader.read();
                        i2++;
                    }
                }
            } else {
                while (i3 != -1 && Character.isWhitespace(i3)) {
                    i3 = bufferedReader.read();
                }
                i2 = 0;
                while (true) {
                    if (i2 < 7) {
                        while (i3 != -1 && Character.isWhitespace(i3) && !u.b(i3)) {
                            i3 = bufferedReader.read();
                        }
                        zB = u.b(i3);
                        break;
                    }
                    if (i3 != "#EXTM3U".charAt(i2)) {
                        break;
                    }
                    i3 = bufferedReader.read();
                    i2++;
                }
            }
            if (!zB) {
                throw new t("Input does not start with the #EXTM3U header.", uri);
            }
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    u.a(bufferedReader);
                    throw new l("Failed to parse the playlist, could not identify any tags.");
                }
                String strTrim = line.trim();
                if (!strTrim.isEmpty()) {
                    if (strTrim.startsWith("#EXT-X-STREAM-INF")) {
                        linkedList.add(strTrim);
                        objA = a(new a(linkedList, bufferedReader), uri.toString());
                    } else {
                        if (!strTrim.startsWith("#EXT-X-TARGETDURATION") && !strTrim.startsWith("#EXT-X-MEDIA-SEQUENCE") && !strTrim.startsWith("#EXTINF") && !strTrim.startsWith("#EXT-X-KEY") && !strTrim.startsWith("#EXT-X-BYTERANGE") && !strTrim.equals("#EXT-X-DISCONTINUITY") && !strTrim.equals("#EXT-X-DISCONTINUITY-SEQUENCE") && !strTrim.equals("#EXT-X-ENDLIST")) {
                            linkedList.add(strTrim);
                        }
                        linkedList.add(strTrim);
                        objA = b(new a(linkedList, bufferedReader), uri.toString());
                    }
                    u.a(bufferedReader);
                    return objA;
                }
            }
        } catch (Throwable th) {
            u.a(bufferedReader);
            throw th;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:17:0x006f  */
    /* JADX WARN: Code duplicated, block: B:56:0x018d  */
    public static com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a a(a aVar, String str) throws IOException {
        int i2;
        String str2;
        int i3;
        int i4;
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = null;
        i iVar = null;
        boolean zContains = false;
        while (aVar.a()) {
            String strB = aVar.b();
            if (strB.startsWith("#EXT-X-MEDIA")) {
                int i5 = (a(strB, u, false) ? 1 : 0) | (a(strB, v, false) ? 2 : 0) | (a(strB, t, false) ? 4 : 0);
                String strA = a(strB, n);
                String strB2 = b(strB, r);
                String strA2 = a(strB, q);
                String strB3 = b(strB, p);
                strB3.getClass();
                strB3.hashCode();
                switch (strB3) {
                    case "SUBTITLES":
                        arrayList3.add(new com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a.C0287a(strA, i.a(strB2, "application/x-mpegURL", "text/vtt", null, -1, i5, strA2, -1)));
                        break;
                    case "CLOSED-CAPTIONS":
                        String strB4 = b(strB, s);
                        if (strB4.startsWith("CC")) {
                            i2 = Integer.parseInt(strB4.substring(2));
                            str2 = "application/cea-608";
                        } else {
                            i2 = Integer.parseInt(strB4.substring(7));
                            str2 = "application/cea-708";
                        }
                        int i6 = i2;
                        String str3 = str2;
                        if (arrayList4 == null) {
                            arrayList4 = new ArrayList();
                        }
                        arrayList4.add(i.a(strB2, null, str3, null, -1, i5, strA2, i6));
                        break;
                    case "AUDIO":
                        i iVar2 = new i(strB2, "application/x-mpegURL", null, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i5, strA2, -1, Long.MAX_VALUE, null, null, null);
                        if (strA != null) {
                            arrayList2.add(new com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a.C0287a(strA, iVar2));
                            break;
                        } else {
                            iVar = iVar2;
                            break;
                        }
                        break;
                }
            } else if (strB.startsWith("#EXT-X-STREAM-INF")) {
                int i7 = Integer.parseInt(b(strB, f1077b));
                String strA3 = a(strB, a);
                if (strA3 != null) {
                    i7 = Integer.parseInt(strA3);
                }
                int i8 = i7;
                String strA4 = a(strB, c);
                String strA5 = a(strB, d);
                zContains |= strB.contains("CLOSED-CAPTIONS=NONE");
                if (strA5 != null) {
                    String[] strArrSplit = strA5.split("x");
                    int i9 = Integer.parseInt(strArrSplit[0]);
                    int i10 = Integer.parseInt(strArrSplit[1]);
                    if (i9 <= 0 || i10 <= 0) {
                        i3 = -1;
                        i4 = -1;
                    } else {
                        i4 = i10;
                        i3 = i9;
                    }
                } else {
                    i3 = -1;
                    i4 = -1;
                }
                String strB5 = aVar.b();
                if (hashSet.add(strB5)) {
                    arrayList.add(new com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a.C0287a(strB5, new i(Integer.toString(arrayList.size()), "application/x-mpegURL", null, strA4, i8, -1, i3, i4, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, null, null)));
                }
            }
        }
        return new com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a(str, arrayList, arrayList2, arrayList3, iVar, zContains ? Collections.emptyList() : arrayList4);
    }

    public static String b(String str, Pattern pattern) throws l {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find() && matcher.groupCount() == 1) {
            return matcher.group(1);
        }
        throw new l("Couldn't match " + pattern.pattern() + " in " + str);
    }

    public static String a(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    public static boolean a(String str, Pattern pattern, boolean z) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? matcher.group(1).equals("YES") : z;
    }

    public static Pattern a(String str) {
        return Pattern.compile(str + "=(NO|YES)");
    }
}
