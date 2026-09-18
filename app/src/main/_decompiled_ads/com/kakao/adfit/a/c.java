package com.kakao.adfit.a;

import android.content.Context;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: AdEvent.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0010\u0012B\u0017\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u001a\u0010\u001bB%\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\u001a\u0010\"B%\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010$\u001a\u00020#\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\u001a\u0010%R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\r\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0006\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0011\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\u0014\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\fR\u0017\u0010\u0019\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0004\u0010\u0018¨\u0006&"}, d2 = {"Lcom/kakao/adfit/a/c;", "", "", "", "a", "Ljava/util/List;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()Ljava/util/List;", "clickTrackers", "Lcom/kakao/adfit/a/c$e;", "Lcom/kakao/adfit/a/c$e;", "c", "()Lcom/kakao/adfit/a/c$e;", "renderEvent", "getExposedEvent", "exposedEvent", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "viewableEvent", "e", "getHideEvent", "hideEvent", "Lcom/kakao/adfit/a/c$d;", InneractiveMediationDefs.GENDER_FEMALE, "Lcom/kakao/adfit/a/c$d;", "()Lcom/kakao/adfit/a/c$d;", "clickEvent", "<init>", "(Ljava/util/List;)V", "Landroid/content/Context;", "context", "Lcom/kakao/adfit/a/a;", "ad", "Lcom/kakao/adfit/a/d;", "timestamps", "(Landroid/content/Context;Lcom/kakao/adfit/a/a;Lcom/kakao/adfit/a/d;)V", "Lcom/kakao/adfit/a/e;", "tracker", "(Landroid/content/Context;Lcom/kakao/adfit/a/e;Lcom/kakao/adfit/a/d;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class c {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final List<String> clickTrackers;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final e renderEvent;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final e exposedEvent;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final e viewableEvent;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final e hideEvent;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final d clickEvent;

    /* JADX INFO: compiled from: AdEvent.kt */
    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    static final class a extends Lambda implements Function0<Unit> {
        final /* synthetic */ Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList<String> f1664b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, ArrayList<String> arrayList) {
            super(0);
            this.a = context;
            this.f1664b = arrayList;
        }

        public final void a() {
            g.a(this.a).a(this.f1664b);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: AdEvent.kt */
    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    static final class b extends Lambda implements Function0<Unit> {
        final /* synthetic */ Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList<String> f1665b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Context context, ArrayList<String> arrayList) {
            super(0);
            this.a = context;
            this.f1665b = arrayList;
        }

        public final void a() {
            g.a(this.a).a(this.f1665b);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.kakao.adfit.a.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AdEvent.kt */
    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    static final class C0443c extends Lambda implements Function0<Unit> {
        final /* synthetic */ Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList<String> f1666b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0443c(Context context, ArrayList<String> arrayList) {
            super(0);
            this.a = context;
            this.f1666b = arrayList;
        }

        public final void a() {
            g.a(this.a).a(this.f1666b);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: AdEvent.kt */
    @Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0014\u0010\t\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0006\u0010\u0006\u001a\u00020\u0003R$\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/kakao/adfit/a/c$d;", "", "Lkotlin/Function0;", "", "observer", "", "a", "c", "Lcom/kakao/adfit/k/k;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "observers", "()Z", "isCompleted", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static class d {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private CopyOnWriteArrayList<Function0<Unit>> observers = new CopyOnWriteArrayList<>();

        /* JADX INFO: compiled from: Disposable.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00048\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b¨\u0006\n"}, d2 = {"com/kakao/adfit/a/c$d$a", "Lcom/kakao/adfit/k/k;", "", "a", "", "<set-?>", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Z", "()Z", "isDisposed", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
        public static final class a implements com.kakao.adfit.k.k {

            /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
            private boolean isDisposed;
            final /* synthetic */ Ref.ObjectRef c;
            final /* synthetic */ Function0 d;

            public a(Ref.ObjectRef objectRef, Function0 function0) {
                this.c = objectRef;
                this.d = function0;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.kakao.adfit.k.k
            public void a() {
                if (getIsDisposed()) {
                    return;
                }
                this.isDisposed = true;
                d dVar = (d) this.c.element;
                if (dVar != null) {
                    dVar.c(this.d);
                }
                this.c.element = null;
            }

            /* JADX INFO: renamed from: b, reason: from getter */
            public boolean getIsDisposed() {
                return this.isDisposed;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean c(Function0<Unit> observer) {
            if (b()) {
                return false;
            }
            CopyOnWriteArrayList<Function0<Unit>> copyOnWriteArrayList = this.observers;
            Intrinsics.checkNotNull(copyOnWriteArrayList);
            copyOnWriteArrayList.remove(observer);
            return true;
        }

        public final boolean b() {
            return this.observers == null;
        }

        private final boolean a(Function0<Unit> observer) {
            if (b()) {
                return false;
            }
            CopyOnWriteArrayList<Function0<Unit>> copyOnWriteArrayList = this.observers;
            Intrinsics.checkNotNull(copyOnWriteArrayList);
            copyOnWriteArrayList.add(observer);
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final com.kakao.adfit.k.k b(Function0<Unit> observer) {
            Intrinsics.checkNotNullParameter(observer, "observer");
            if (!a(observer)) {
                return com.kakao.adfit.k.k.INSTANCE.a();
            }
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = this;
            com.kakao.adfit.k.k.Companion companion = com.kakao.adfit.k.k.INSTANCE;
            return new a(objectRef, observer);
        }

        public void c() {
            if (b()) {
                return;
            }
            CopyOnWriteArrayList<Function0<Unit>> copyOnWriteArrayList = this.observers;
            Intrinsics.checkNotNull(copyOnWriteArrayList);
            Iterator<T> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                ((Function0) it.next()).invoke();
            }
        }

        public final void a() {
            this.observers = null;
        }
    }

    /* JADX INFO: compiled from: AdEvent.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"Lcom/kakao/adfit/a/c$e;", "Lcom/kakao/adfit/a/c$d;", "", "c", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class e extends d {
        @Override // com.kakao.adfit.a.c.d
        public void c() {
            super.c();
            a();
        }
    }

    public c(List<String> clickTrackers) {
        Intrinsics.checkNotNullParameter(clickTrackers, "clickTrackers");
        this.clickTrackers = clickTrackers;
        this.renderEvent = new e();
        this.exposedEvent = new e();
        this.viewableEvent = new e();
        this.hideEvent = new e();
        this.clickEvent = new d();
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final d getClickEvent() {
        return this.clickEvent;
    }

    public final List<String> b() {
        return this.clickTrackers;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final e getRenderEvent() {
        return this.renderEvent;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final e getViewableEvent() {
        return this.viewableEvent;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(Context context, com.kakao.adfit.a.a ad, com.kakao.adfit.a.d dVar) {
        this(context, ad.getTracker(), dVar);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(ad, "ad");
    }

    public /* synthetic */ c(Context context, com.kakao.adfit.a.a aVar, com.kakao.adfit.a.d dVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, aVar, (i & 4) != 0 ? null : dVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(Context context, com.kakao.adfit.a.e tracker, com.kakao.adfit.a.d dVar) {
        this(tracker.a());
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(tracker, "tracker");
        Context applicationContext = context.getApplicationContext();
        ArrayList<String> arrayListC = tracker.c();
        arrayListC = arrayListC.isEmpty() ^ true ? arrayListC : null;
        if (arrayListC != null) {
            this.renderEvent.b(new a(applicationContext, arrayListC));
        }
        ArrayList<String> arrayListD = tracker.d();
        arrayListD = arrayListD.isEmpty() ^ true ? arrayListD : null;
        if (arrayListD != null) {
            this.viewableEvent.b(new b(applicationContext, arrayListD));
        }
        ArrayList<String> arrayListB = tracker.b();
        ArrayList<String> arrayList = arrayListB.isEmpty() ^ true ? arrayListB : null;
        if (arrayList != null) {
            this.hideEvent.b(new C0443c(applicationContext, arrayList));
        }
    }
}
