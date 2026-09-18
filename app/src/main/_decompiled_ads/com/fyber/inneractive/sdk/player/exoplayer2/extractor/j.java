package com.fyber.inneractive.sdk.player.exoplayer2.extractor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class j {
    public static final com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.g.a c = new a();
    public static final Pattern d = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1081b = -1;

    public class a implements com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.g.a {
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0046  */
    public boolean a(com.fyber.inneractive.sdk.player.exoplayer2.metadata.a aVar) {
        boolean z;
        int i = 0;
        while (true) {
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.a.b[] bVarArr = aVar.a;
            if (i >= bVarArr.length) {
                return false;
            }
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.a.b bVar = bVarArr[i];
            if (bVar instanceof com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.e) {
                com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.e eVar = (com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.e) bVar;
                String str = eVar.c;
                String str2 = eVar.d;
                if ("iTunSMPB".equals(str)) {
                    Matcher matcher = d.matcher(str2);
                    if (matcher.find()) {
                        try {
                            int i2 = Integer.parseInt(matcher.group(1), 16);
                            int i3 = Integer.parseInt(matcher.group(2), 16);
                            if (i2 > 0 || i3 > 0) {
                                this.a = i2;
                                this.f1081b = i3;
                                z = true;
                            } else {
                                z = false;
                            }
                        } catch (NumberFormatException unused) {
                        }
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                }
                if (z) {
                    return true;
                }
            }
            i++;
        }
    }

    public boolean a() {
        return (this.a == -1 || this.f1081b == -1) ? false : true;
    }
}
