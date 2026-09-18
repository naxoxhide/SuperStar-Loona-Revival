package com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache;

import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends g {
    public static final Pattern g = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", 32);
    public static final Pattern h = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", 32);
    public static final Pattern i = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", 32);

    public l(String str, long j, long j2, long j3, File file) {
        super(str, j, j2, j3, file);
    }

    public static File a(File file, int i2, long j, long j2) {
        return new File(file, i2 + "." + j + "." + j2 + ".v3.exo");
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:38:0x00cf A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:39:0x00d0  */
    public static l a(File file, i iVar) {
        File file2;
        String strGroup;
        File fileA;
        h hVarA;
        String name = file.getName();
        if (name.endsWith(".v3.exo")) {
            file2 = file;
        } else {
            String name2 = file.getName();
            Matcher matcher = h.matcher(name2);
            if (matcher.matches()) {
                strGroup = matcher.group(1);
                int i2 = u.a;
                int length = strGroup.length();
                int iEnd = 0;
                int i3 = 0;
                for (int i4 = 0; i4 < length; i4++) {
                    if (strGroup.charAt(i4) == '%') {
                        i3++;
                    }
                }
                if (i3 != 0) {
                    int i5 = length - (i3 * 2);
                    StringBuilder sb = new StringBuilder(i5);
                    Matcher matcher2 = u.g.matcher(strGroup);
                    while (i3 > 0 && matcher2.find()) {
                        sb.append((CharSequence) strGroup, iEnd, matcher2.start()).append((char) Integer.parseInt(matcher2.group(1), 16));
                        iEnd = matcher2.end();
                        i3--;
                    }
                    if (iEnd < length) {
                        sb.append((CharSequence) strGroup, iEnd, length);
                    }
                    strGroup = sb.length() != i5 ? null : sb.toString();
                }
                if (strGroup != null) {
                    File parentFile = file.getParentFile();
                    hVarA = iVar.a.get(strGroup);
                    if (hVarA == null) {
                        hVarA = iVar.a(strGroup, -1L);
                    }
                    fileA = a(parentFile, hVarA.a, Long.parseLong(matcher.group(2)), Long.parseLong(matcher.group(3)));
                    if (!file.renameTo(fileA)) {
                    }
                }
                if (fileA == null) {
                    return null;
                }
                file2 = fileA;
                name = fileA.getName();
            } else {
                matcher = g.matcher(name2);
                if (matcher.matches()) {
                    strGroup = matcher.group(1);
                    File parentFile2 = file.getParentFile();
                    hVarA = iVar.a.get(strGroup);
                    if (hVarA == null) {
                        hVarA = iVar.a(strGroup, -1L);
                    }
                    fileA = a(parentFile2, hVarA.a, Long.parseLong(matcher.group(2)), Long.parseLong(matcher.group(3)));
                    if (!file.renameTo(fileA)) {
                    }
                }
                if (fileA == null) {
                    return null;
                }
                file2 = fileA;
                name = fileA.getName();
            }
            fileA = null;
            if (fileA == null) {
                return null;
            }
            file2 = fileA;
            name = fileA.getName();
        }
        Matcher matcher3 = i.matcher(name);
        if (!matcher3.matches()) {
            return null;
        }
        long length2 = file2.length();
        String str = iVar.f1208b.get(Integer.parseInt(matcher3.group(1)));
        if (str == null) {
            return null;
        }
        return new l(str, Long.parseLong(matcher3.group(2)), length2, Long.parseLong(matcher3.group(3)), file2);
    }
}
