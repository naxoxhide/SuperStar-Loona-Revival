package com.kakao.adfit.k;

import android.os.SystemClock;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: Time.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\bf\u0018\u0000 \u00032\u00020\u0001:\u0004\u0003\u0004\u0005\u0006J\b\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0007"}, d2 = {"Lcom/kakao/adfit/k/b0;", "", "", "a", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "c", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public interface b0 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.a;

    /* JADX INFO: renamed from: com.kakao.adfit.k.b0$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: Time.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u001b\u0010\t\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/kakao/adfit/k/b0$a;", "", "Lcom/kakao/adfit/k/b0;", "a", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/kakao/adfit/k/b0$b;", "Lkotlin/Lazy;", "getFixed", "()Lcom/kakao/adfit/k/b0$b;", "fixed", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        static final /* synthetic */ Companion a = new Companion();

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private static final Lazy<b> fixed = LazyKt.lazy(C0465a.a);

        /* JADX INFO: renamed from: com.kakao.adfit.k.b0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Time.kt */
        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/kakao/adfit/k/b0$b;", "a", "()Lcom/kakao/adfit/k/b0$b;"}, k = 3, mv = {1, 6, 0})
        static final class C0465a extends Lambda implements Function0<b> {
            public static final C0465a a = new C0465a();

            C0465a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final b invoke() {
                return new b();
            }
        }

        private Companion() {
        }

        public final b0 a() {
            return c.f1817b;
        }

        public final b0 b() {
            return d.f1818b;
        }
    }

    /* JADX INFO: compiled from: Time.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/kakao/adfit/k/b0$b;", "Lcom/kakao/adfit/k/b0;", "", "a", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "J", "getMillis", "()J", "setMillis", "(J)V", "millis", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class b implements b0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private long millis;

        @Override // com.kakao.adfit.k.b0
        /* JADX INFO: renamed from: a, reason: from getter */
        public long getMillis() {
            return this.millis;
        }
    }

    /* JADX INFO: compiled from: Time.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"Lcom/kakao/adfit/k/b0$c;", "Lcom/kakao/adfit/k/b0;", "", "a", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class c implements b0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f1817b = new c();

        private c() {
        }

        @Override // com.kakao.adfit.k.b0
        /* JADX INFO: renamed from: a */
        public long getMillis() {
            return System.currentTimeMillis();
        }
    }

    /* JADX INFO: compiled from: Time.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"Lcom/kakao/adfit/k/b0$d;", "Lcom/kakao/adfit/k/b0;", "", "a", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class d implements b0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f1818b = new d();

        private d() {
        }

        @Override // com.kakao.adfit.k.b0
        /* JADX INFO: renamed from: a */
        public long getMillis() {
            return SystemClock.elapsedRealtime();
        }
    }

    /* JADX INFO: renamed from: a */
    long getMillis();
}
