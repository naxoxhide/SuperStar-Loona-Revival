package com.applovin.exoplayer2.i;

import com.applovin.exoplayer2.v;

/* JADX INFO: loaded from: classes.dex */
public interface i {
    public static final i Ot = new i() { // from class: com.applovin.exoplayer2.i.i.1
        @Override // com.applovin.exoplayer2.i.i
        public boolean d(v vVar) {
            String str = vVar.dz;
            return "text/vtt".equals(str) || "text/x-ssa".equals(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-subrip".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/cea-608".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/cea-708".equals(str) || "application/dvbsubs".equals(str) || "application/pgs".equals(str) || "text/x-exoplayer-cues".equals(str);
        }

        @Override // com.applovin.exoplayer2.i.i
        public g x(v vVar) {
            String str = vVar.dz;
            if (str != null) {
                str.hashCode();
                switch (str) {
                    case "application/dvbsubs":
                        return new com.applovin.exoplayer2.i.b.a(vVar.dB);
                    case "application/pgs":
                        return new com.applovin.exoplayer2.i.c.a();
                    case "application/x-mp4-vtt":
                        return new com.applovin.exoplayer2.i.i.a();
                    case "text/vtt":
                        return new com.applovin.exoplayer2.i.i.g();
                    case "application/x-quicktime-tx3g":
                        return new com.applovin.exoplayer2.i.h.a(vVar.dB);
                    case "text/x-ssa":
                        return new com.applovin.exoplayer2.i.e.a(vVar.dB);
                    case "application/x-mp4-cea-608":
                    case "application/cea-608":
                        return new com.applovin.exoplayer2.i.a.a(str, vVar.dQ, 16000L);
                    case "text/x-exoplayer-cues":
                        return new c();
                    case "application/cea-708":
                        return new com.applovin.exoplayer2.i.a.b(vVar.dQ, vVar.dB);
                    case "application/x-subrip":
                        return new com.applovin.exoplayer2.i.f.a();
                    case "application/ttml+xml":
                        return new com.applovin.exoplayer2.i.g.c();
                }
            }
            throw new IllegalArgumentException("Attempted to create decoder for unsupported MIME type: " + str);
        }
    };

    boolean d(v vVar);

    g x(v vVar);
}
