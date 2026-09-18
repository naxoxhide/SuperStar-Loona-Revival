package com.applovin.exoplayer2.e;

/* JADX INFO: loaded from: classes.dex */
public interface v {
    a ai(long j);

    long dd();

    boolean hU();

    public static class b implements v {
        private final long fH;
        private final a uS;

        @Override // com.applovin.exoplayer2.e.v
        public boolean hU() {
            return false;
        }

        public b(long j) {
            this(j, 0L);
        }

        public b(long j, long j2) {
            this.fH = j;
            this.uS = new a(j2 == 0 ? w.uT : new w(0L, j2));
        }

        @Override // com.applovin.exoplayer2.e.v
        public long dd() {
            return this.fH;
        }

        @Override // com.applovin.exoplayer2.e.v
        public a ai(long j) {
            return this.uS;
        }
    }

    public static final class a {
        public final w uQ;
        public final w uR;

        public a(w wVar) {
            this(wVar, wVar);
        }

        public a(w wVar, w wVar2) {
            this.uQ = (w) com.applovin.exoplayer2.l.a.checkNotNull(wVar);
            this.uR = (w) com.applovin.exoplayer2.l.a.checkNotNull(wVar2);
        }

        public String toString() {
            return "[" + this.uQ + (this.uQ.equals(this.uR) ? "" : ", " + this.uR) + "]";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.uQ.equals(aVar.uQ) && this.uR.equals(aVar.uR);
        }

        public int hashCode() {
            return (this.uQ.hashCode() * 31) + this.uR.hashCode();
        }
    }
}
