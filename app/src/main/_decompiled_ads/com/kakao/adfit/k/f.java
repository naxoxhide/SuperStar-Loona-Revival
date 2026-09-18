package com.kakao.adfit.k;

import android.content.Context;
import android.util.Log;
import com.kakao.adfit.common.matrix.MatrixLevel;
import com.kakao.adfit.h.MatrixBreadcrumb;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AdLog.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001:\u0005\u0005\u0010\u000e\r\u000fB\t\b\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0005\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\"\u0010\u0005\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\u0005\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0007J\u001a\u0010\u0005\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0007J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0007J\u001a\u0010\u0010\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007J\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/kakao/adfit/k/f;", "", "Landroid/content/Context;", "context", "", "a", "", "level", "", "message", "", "", "t", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "c", "e", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/kakao/adfit/k/f$e;", "Lcom/kakao/adfit/k/f$e;", "uploader", "Z", "isPrepared", "Lcom/kakao/adfit/k/f$c;", "Lcom/kakao/adfit/k/f$c;", "printer", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class f {

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private static boolean isPrepared;
    public static final f a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final e uploader = new d();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private static c printer = new b();

    /* JADX INFO: compiled from: AdLog.kt */
    @Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\bb\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&J*\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH&¨\u0006\u000b"}, d2 = {"Lcom/kakao/adfit/k/f$c;", "", "", "level", "", "tag", "message", "", "a", "", "t", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    private interface c {
        void a(int level, String tag, String message);

        void a(int level, String tag, String message, Throwable t);
    }

    /* JADX INFO: compiled from: AdLog.kt */
    @Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\bb\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H&J,\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH&¨\u0006\u000b"}, d2 = {"Lcom/kakao/adfit/k/f$e;", "", "", "level", "", "tag", "message", "", "a", "", "t", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    private interface e {
        void a(int level, String tag, String message);

        void a(int level, String tag, String message, Throwable t);
    }

    private f() {
    }

    private final boolean a(Context context) {
        return w.c(context, "com.kakao.adfit.libraryqa") == -325445849;
    }

    @JvmStatic
    public static final void c(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        a.a(4, message);
    }

    @JvmStatic
    public static final void d(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        a.a(2, message);
    }

    @JvmStatic
    public static final void e(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        a.a(5, message);
    }

    public final void b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (isPrepared) {
            return;
        }
        if (a(context) && !(printer instanceof a)) {
            printer = new a();
        }
        isPrepared = true;
    }

    private final void a(int level, String message) {
        uploader.a(level, "AdFit3.13.6", message);
        printer.a(level, "AdFit3.13.6", message);
    }

    @JvmStatic
    public static final void c(String message, Throwable t) {
        Intrinsics.checkNotNullParameter(message, "message");
        a.a(5, message, t);
    }

    /* JADX INFO: compiled from: AdLog.kt */
    @Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J*\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\r"}, d2 = {"Lcom/kakao/adfit/k/f$b;", "Lcom/kakao/adfit/k/f$c;", "", "level", "", "tag", "message", "", "a", "", "t", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    private static final class b implements c {
        @Override // com.kakao.adfit.k.f.c
        public void a(int level, String tag, String message) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(message, "message");
            if (level == 4) {
                Log.i(tag, message);
            } else if (level == 5) {
                Log.w(tag, message);
            } else {
                if (level != 6) {
                    return;
                }
                Log.e(tag, message);
            }
        }

        @Override // com.kakao.adfit.k.f.c
        public void a(int level, String tag, String message, Throwable t) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(message, "message");
            if (level == 4) {
                Log.i(tag, message, t);
            } else if (level == 5) {
                Log.w(tag, message, t);
            } else {
                if (level != 6) {
                    return;
                }
                Log.e(tag, message, t);
            }
        }
    }

    private final void a(int level, String message, Throwable t) {
        uploader.a(level, "AdFit3.13.6", message, t);
        printer.a(level, "AdFit3.13.6", message, t);
    }

    @JvmStatic
    public static final void a(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        a.a(3, message);
    }

    /* JADX INFO: compiled from: AdLog.kt */
    @Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u0002H\u0002J\"\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J,\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/kakao/adfit/k/f$d;", "Lcom/kakao/adfit/k/f$e;", "", "Lcom/kakao/adfit/common/matrix/MatrixLevel;", "a", "level", "", "tag", "message", "", "", "t", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    private static final class d implements e {
        @Override // com.kakao.adfit.k.f.e
        public void a(int level, String tag, String message) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            com.kakao.adfit.e.f.a.a(MatrixBreadcrumb.Companion.a(MatrixBreadcrumb.INSTANCE, message, null, a(level), 2, null));
        }

        @Override // com.kakao.adfit.k.f.e
        public void a(int level, String tag, String message, Throwable t) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            com.kakao.adfit.e.f.a.a(MatrixBreadcrumb.Companion.a(MatrixBreadcrumb.INSTANCE, message + '\n' + t, null, a(level), 2, null));
        }

        private final MatrixLevel a(int i) {
            if (i == 2) {
                return MatrixLevel.LOG;
            }
            if (i == 3) {
                return MatrixLevel.DEBUG;
            }
            if (i == 4) {
                return MatrixLevel.INFO;
            }
            if (i == 5) {
                return MatrixLevel.WARNING;
            }
            if (i != 6) {
                return null;
            }
            return MatrixLevel.ERROR;
        }
    }

    @JvmStatic
    public static final void a(String message, Throwable t) {
        Intrinsics.checkNotNullParameter(message, "message");
        a.a(3, message, t);
    }

    @JvmStatic
    public static final void b(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        a.a(6, message);
    }

    @JvmStatic
    public static final void b(String message, Throwable t) {
        Intrinsics.checkNotNullParameter(message, "message");
        a.a(6, message, t);
    }

    /* JADX INFO: compiled from: AdLog.kt */
    @Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J*\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\r"}, d2 = {"Lcom/kakao/adfit/k/f$a;", "Lcom/kakao/adfit/k/f$c;", "", "level", "", "tag", "message", "", "a", "", "t", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    private static final class a implements c {
        @Override // com.kakao.adfit.k.f.c
        public void a(int level, String tag, String message) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(message, "message");
            StackTraceElement stackTraceElement = new Throwable().getStackTrace()[3];
            String str = '(' + stackTraceElement.getFileName() + ':' + stackTraceElement.getLineNumber() + ") " + message;
            if (level == 2) {
                Log.v(tag, str);
                return;
            }
            if (level == 3) {
                Log.d(tag, str);
                return;
            }
            if (level == 4) {
                Log.i(tag, str);
            } else if (level == 5) {
                Log.w(tag, str);
            } else {
                if (level != 6) {
                    return;
                }
                Log.e(tag, str);
            }
        }

        @Override // com.kakao.adfit.k.f.c
        public void a(int level, String tag, String message, Throwable t) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(message, "message");
            StackTraceElement stackTraceElement = new Throwable().getStackTrace()[3];
            String str = '(' + stackTraceElement.getFileName() + ':' + stackTraceElement.getLineNumber() + ") " + message;
            if (level == 2) {
                Log.v(tag, str, t);
                return;
            }
            if (level == 3) {
                Log.d(tag, str, t);
                return;
            }
            if (level == 4) {
                Log.i(tag, str, t);
            } else if (level == 5) {
                Log.w(tag, str, t);
            } else {
                if (level != 6) {
                    return;
                }
                Log.e(tag, str, t);
            }
        }
    }
}
