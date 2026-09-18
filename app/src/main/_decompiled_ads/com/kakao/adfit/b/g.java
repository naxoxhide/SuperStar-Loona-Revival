package com.kakao.adfit.b;

import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.kakao.adfit.k.u;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: BannerAdRequestState.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R+\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0005\u0010\f\"\u0004\b\u0005\u0010\rR+\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\n\u0010\rR+\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0011\u0010\rR+\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u000f\u0010\rR+\u0010\u0015\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0013\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/kakao/adfit/b/g;", "", "", InneractiveMediationDefs.GENDER_FEMALE, "Lkotlin/Function0;", "a", "Lkotlin/jvm/functions/Function0;", "onAvailableStateChanged", "", "<set-?>", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/kakao/adfit/k/u;", "()Z", "(Z)V", "isAvailable", "c", "isExecuted", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "isRequesting", "e", "isPaused", "isTerminated", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class g {
    static final /* synthetic */ KProperty<Object>[] g = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(g.class, "isAvailable", "isAvailable()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(g.class, "isExecuted", "isExecuted()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(g.class, "isRequesting", "isRequesting()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(g.class, "isPaused", "isPaused()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(g.class, "isTerminated", "isTerminated()Z", 0))};

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final Function0<Unit> onAvailableStateChanged;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final u isAvailable;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final u isExecuted;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final u isRequesting;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final u isPaused;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final u isTerminated;

    /* JADX INFO: compiled from: BannerAdRequestState.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "a", "(Z)V"}, k = 3, mv = {1, 6, 0})
    static final class a extends Lambda implements Function1<Boolean, Unit> {
        a() {
            super(1);
        }

        public final void a(boolean z) {
            g.this.onAvailableStateChanged.invoke();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            a(bool.booleanValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: BannerAdRequestState.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "a", "(Z)V"}, k = 3, mv = {1, 6, 0})
    static final class b extends Lambda implements Function1<Boolean, Unit> {
        b() {
            super(1);
        }

        public final void a(boolean z) {
            g.this.f();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            a(bool.booleanValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: BannerAdRequestState.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "a", "(Z)V"}, k = 3, mv = {1, 6, 0})
    static final class c extends Lambda implements Function1<Boolean, Unit> {
        c() {
            super(1);
        }

        public final void a(boolean z) {
            g.this.f();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            a(bool.booleanValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: BannerAdRequestState.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "a", "(Z)V"}, k = 3, mv = {1, 6, 0})
    static final class d extends Lambda implements Function1<Boolean, Unit> {
        d() {
            super(1);
        }

        public final void a(boolean z) {
            g.this.f();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            a(bool.booleanValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: BannerAdRequestState.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "a", "(Z)V"}, k = 3, mv = {1, 6, 0})
    static final class e extends Lambda implements Function1<Boolean, Unit> {
        e() {
            super(1);
        }

        public final void a(boolean z) {
            g.this.f();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            a(bool.booleanValue());
            return Unit.INSTANCE;
        }
    }

    public g(Function0<Unit> onAvailableStateChanged) {
        Intrinsics.checkNotNullParameter(onAvailableStateChanged, "onAvailableStateChanged");
        this.onAvailableStateChanged = onAvailableStateChanged;
        this.isAvailable = new u(false, new a());
        this.isExecuted = new u(false, new b());
        this.isRequesting = new u(false, new d());
        this.isPaused = new u(false, new c());
        this.isTerminated = new u(false, new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        a((!b() || d() || c() || e()) ? false : true);
    }

    public final boolean c() {
        return this.isPaused.getValue(this, g[3]).booleanValue();
    }

    public final boolean d() {
        return this.isRequesting.getValue(this, g[2]).booleanValue();
    }

    public final boolean e() {
        return this.isTerminated.getValue(this, g[4]).booleanValue();
    }

    public final boolean a() {
        return this.isAvailable.getValue(this, g[0]).booleanValue();
    }

    public final boolean b() {
        return this.isExecuted.getValue(this, g[1]).booleanValue();
    }

    public final void c(boolean z) {
        this.isPaused.setValue(this, g[3], Boolean.valueOf(z));
    }

    public final void d(boolean z) {
        this.isRequesting.setValue(this, g[2], Boolean.valueOf(z));
    }

    public final void e(boolean z) {
        this.isTerminated.setValue(this, g[4], Boolean.valueOf(z));
    }

    private final void a(boolean z) {
        this.isAvailable.setValue(this, g[0], Boolean.valueOf(z));
    }

    public final void b(boolean z) {
        this.isExecuted.setValue(this, g[1], Boolean.valueOf(z));
    }
}
