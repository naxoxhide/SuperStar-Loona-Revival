package com.applovin.exoplayer2.common.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class Splitter {
    private final int limit;
    private final boolean omitEmptyStrings;
    private final b strategy;
    private final CharMatcher trimmer;

    private interface b {
        Iterator<String> b(Splitter splitter, CharSequence charSequence);
    }

    private Splitter(b bVar) {
        this(bVar, false, CharMatcher.none(), Integer.MAX_VALUE);
    }

    private Splitter(b bVar, boolean z, CharMatcher charMatcher, int i) {
        this.strategy = bVar;
        this.omitEmptyStrings = z;
        this.trimmer = charMatcher;
        this.limit = i;
    }

    public static Splitter on(char c) {
        return on(CharMatcher.is(c));
    }

    public static Splitter on(final CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return new Splitter(new b() { // from class: com.applovin.exoplayer2.common.base.Splitter.1
            @Override // com.applovin.exoplayer2.common.base.Splitter.b
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public a b(Splitter splitter, CharSequence charSequence) {
                return new a(splitter, charSequence) { // from class: com.applovin.exoplayer2.common.base.Splitter.1.1
                    @Override // com.applovin.exoplayer2.common.base.Splitter.a
                    int aQ(int i) {
                        return i + 1;
                    }

                    @Override // com.applovin.exoplayer2.common.base.Splitter.a
                    int aP(int i) {
                        return charMatcher.indexIn(this.oT, i);
                    }
                };
            }
        });
    }

    public static Splitter on(final String str) {
        Preconditions.checkArgument(str.length() != 0, "The separator may not be the empty string.");
        if (str.length() == 1) {
            return on(str.charAt(0));
        }
        return new Splitter(new b() { // from class: com.applovin.exoplayer2.common.base.Splitter.2
            @Override // com.applovin.exoplayer2.common.base.Splitter.b
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public a b(Splitter splitter, CharSequence charSequence) {
                return new a(splitter, charSequence) { // from class: com.applovin.exoplayer2.common.base.Splitter.2.1
                    @Override // com.applovin.exoplayer2.common.base.Splitter.a
                    public int aP(int i) {
                        int length = str.length();
                        int length2 = this.oT.length() - length;
                        while (i <= length2) {
                            for (int i2 = 0; i2 < length; i2++) {
                                if (this.oT.charAt(i2 + i) != str.charAt(i2)) {
                                    i++;
                                }
                            }
                            return i;
                        }
                        return -1;
                    }

                    @Override // com.applovin.exoplayer2.common.base.Splitter.a
                    public int aQ(int i) {
                        return i + str.length();
                    }
                };
            }
        });
    }

    public static Splitter fixedLength(final int i) {
        Preconditions.checkArgument(i > 0, "The length may not be less than 1");
        return new Splitter(new b() { // from class: com.applovin.exoplayer2.common.base.Splitter.3
            @Override // com.applovin.exoplayer2.common.base.Splitter.b
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public a b(Splitter splitter, CharSequence charSequence) {
                return new a(splitter, charSequence) { // from class: com.applovin.exoplayer2.common.base.Splitter.3.1
                    @Override // com.applovin.exoplayer2.common.base.Splitter.a
                    public int aQ(int i2) {
                        return i2;
                    }

                    @Override // com.applovin.exoplayer2.common.base.Splitter.a
                    public int aP(int i2) {
                        int i3 = i2 + i;
                        if (i3 < this.oT.length()) {
                            return i3;
                        }
                        return -1;
                    }
                };
            }
        });
    }

    public Splitter omitEmptyStrings() {
        return new Splitter(this.strategy, true, this.trimmer, this.limit);
    }

    public Splitter limit(int i) {
        Preconditions.checkArgument(i > 0, "must be greater than zero: %s", i);
        return new Splitter(this.strategy, this.omitEmptyStrings, this.trimmer, i);
    }

    public Splitter trimResults() {
        return trimResults(CharMatcher.whitespace());
    }

    public Splitter trimResults(CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return new Splitter(this.strategy, this.omitEmptyStrings, charMatcher, this.limit);
    }

    private Iterator<String> splittingIterator(CharSequence charSequence) {
        return this.strategy.b(this, charSequence);
    }

    public List<String> splitToList(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        Iterator<String> itSplittingIterator = splittingIterator(charSequence);
        ArrayList arrayList = new ArrayList();
        while (itSplittingIterator.hasNext()) {
            arrayList.add(itSplittingIterator.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static abstract class a extends com.applovin.exoplayer2.common.base.b<String> {
        int limit;
        final CharSequence oT;
        int oU = 0;
        final boolean omitEmptyStrings;
        final CharMatcher trimmer;

        abstract int aP(int i);

        abstract int aQ(int i);

        protected a(Splitter splitter, CharSequence charSequence) {
            this.trimmer = splitter.trimmer;
            this.omitEmptyStrings = splitter.omitEmptyStrings;
            this.limit = splitter.limit;
            this.oT = charSequence;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.applovin.exoplayer2.common.base.b
        /* JADX INFO: renamed from: fa, reason: merged with bridge method [inline-methods] */
        public String eT() {
            int i = this.oU;
            while (true) {
                int i2 = this.oU;
                if (i2 != -1) {
                    int iAP = aP(i2);
                    if (iAP == -1) {
                        iAP = this.oT.length();
                        this.oU = -1;
                    } else {
                        this.oU = aQ(iAP);
                    }
                    int i3 = this.oU;
                    if (i3 == i) {
                        int i4 = i3 + 1;
                        this.oU = i4;
                        if (i4 > this.oT.length()) {
                            this.oU = -1;
                        }
                    } else {
                        while (i < iAP && this.trimmer.matches(this.oT.charAt(i))) {
                            i++;
                        }
                        while (iAP > i && this.trimmer.matches(this.oT.charAt(iAP - 1))) {
                            iAP--;
                        }
                        if (this.omitEmptyStrings && i == iAP) {
                            i = this.oU;
                        } else {
                            int i5 = this.limit;
                            if (i5 == 1) {
                                iAP = this.oT.length();
                                this.oU = -1;
                                while (iAP > i && this.trimmer.matches(this.oT.charAt(iAP - 1))) {
                                    iAP--;
                                }
                            } else {
                                this.limit = i5 - 1;
                            }
                            return this.oT.subSequence(i, iAP).toString();
                        }
                    }
                } else {
                    return eU();
                }
            }
        }
    }
}
