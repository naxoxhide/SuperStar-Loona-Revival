package com.kakao.adfit.k;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: ActivityCollector.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0011\u0010\u0012\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0011R\u0011\u0010\u0013\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/kakao/adfit/k/b;", "", "Landroid/content/Context;", "context", "", "a", "Landroid/app/Application;", "application", "Lcom/kakao/adfit/k/b$a;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/kakao/adfit/k/b$a;", "collector", "Ljava/util/concurrent/atomic/AtomicBoolean;", "c", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isInitialized", "", "()Z", "hasStartedActivity", "hasResumedActivity", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class b {
    public static final b a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final a collector = new a();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private static AtomicBoolean isInitialized = new AtomicBoolean(false);

    /* JADX INFO: compiled from: ActivityCollector.kt */
    @Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R3\u0010\u0017\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00110\u0010j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0011`\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R3\u0010\u0018\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00110\u0010j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0011`\u00128\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0014\u001a\u0004\b\u0013\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/kakao/adfit/k/b$a;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "", "c", "Landroid/app/Activity;", "activity", "Landroid/os/Bundle;", "savedInstanceState", "onActivityCreated", "onActivityStarted", "onActivityResumed", "onActivityPaused", "onActivityStopped", "outState", "onActivitySaveInstanceState", "onActivityDestroyed", "Ljava/util/ArrayList;", "Ljava/lang/ref/WeakReference;", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/ArrayList;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()Ljava/util/ArrayList;", "started", "resumed", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class a implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final ArrayList<WeakReference<Activity>> started = new ArrayList<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final ArrayList<WeakReference<Activity>> resumed = new ArrayList<>();

        /* JADX INFO: renamed from: com.kakao.adfit.k.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ActivityCollector.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "it", "", "a", "(Ljava/lang/ref/WeakReference;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0})
        static final class C0463a extends Lambda implements Function1<WeakReference<Activity>, Boolean> {
            public static final C0463a a = new C0463a();

            C0463a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(WeakReference<Activity> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.get() == null);
            }
        }

        /* JADX INFO: renamed from: com.kakao.adfit.k.b$a$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ActivityCollector.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "it", "", "a", "(Ljava/lang/ref/WeakReference;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0})
        static final class C0464b extends Lambda implements Function1<WeakReference<Activity>, Boolean> {
            public static final C0464b a = new C0464b();

            C0464b() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(WeakReference<Activity> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.get() == null);
            }
        }

        private final void c() {
            CollectionsKt.removeAll((List) this.resumed, (Function1) C0463a.a);
            CollectionsKt.removeAll((List) this.started, (Function1) C0464b.a);
        }

        public final ArrayList<WeakReference<Activity>> a() {
            return this.resumed;
        }

        public final ArrayList<WeakReference<Activity>> b() {
            return this.started;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            c();
            Context applicationContext = activity.getApplicationContext();
            if (applicationContext != null) {
                d.c(applicationContext);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            c();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Iterator<WeakReference<Activity>> it = this.resumed.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else {
                    if (it.next().get() == activity) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
            if (i >= 0) {
                this.resumed.remove(i);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.resumed.add(new WeakReference<>(activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(outState, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.started.add(new WeakReference<>(activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Iterator<WeakReference<Activity>> it = this.started.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else {
                    if (it.next().get() == activity) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
            if (i >= 0) {
                this.started.remove(i);
            }
        }
    }

    private b() {
    }

    public final boolean a() {
        ArrayList<WeakReference<Activity>> arrayListA = collector.a();
        if (!(arrayListA instanceof Collection) || !arrayListA.isEmpty()) {
            Iterator<T> it = arrayListA.iterator();
            while (it.hasNext()) {
                if (((WeakReference) it.next()).get() != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean b() {
        ArrayList<WeakReference<Activity>> arrayListB = collector.b();
        if (!(arrayListB instanceof Collection) || !arrayListB.isEmpty()) {
            Iterator<T> it = arrayListB.iterator();
            while (it.hasNext()) {
                if (((WeakReference) it.next()).get() != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (isInitialized.get()) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        Objects.requireNonNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
        a((Application) applicationContext);
    }

    public final void a(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        if (isInitialized.compareAndSet(false, true)) {
            application.registerActivityLifecycleCallbacks(collector);
        }
    }
}
