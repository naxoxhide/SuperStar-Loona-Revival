package com.applovin.exoplayer2.g;

import com.applovin.exoplayer2.v;

/* JADX INFO: loaded from: classes.dex */
public interface c {
    public static final c Ja = new c() { // from class: com.applovin.exoplayer2.g.c.1
        @Override // com.applovin.exoplayer2.g.c
        public boolean d(v vVar) {
            String str = vVar.dz;
            return "application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str) || "application/x-icy".equals(str) || "application/vnd.dvb.ait".equals(str);
        }

        @Override // com.applovin.exoplayer2.g.c
        public b s(v vVar) {
            String str = vVar.dz;
            if (str != null) {
                str.hashCode();
                switch (str) {
                    case "application/vnd.dvb.ait":
                        return new com.applovin.exoplayer2.g.a.b();
                    case "application/x-icy":
                        return new com.applovin.exoplayer2.g.d.a();
                    case "application/id3":
                        return new com.applovin.exoplayer2.g.e.g();
                    case "application/x-emsg":
                        return new com.applovin.exoplayer2.g.b.b();
                    case "application/x-scte35":
                        return new com.applovin.exoplayer2.g.g.c();
                }
            }
            throw new IllegalArgumentException("Attempted to create decoder for unsupported MIME type: " + str);
        }
    };

    boolean d(v vVar);

    b s(v vVar);
}
