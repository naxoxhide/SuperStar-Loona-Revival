package com.kakao.adfit.k;

import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
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

/* JADX INFO: compiled from: AdViewState.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R+\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\n\u0010\u000eR+\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0005\u0010\u000eR+\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0012\u0010\u000eR+\u0010\u0015\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0014\u0010\u000eR+\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\n\u0010\r\"\u0004\b\f\u0010\u000eR+\u0010\u0017\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\u0005\u0010\r\"\u0004\b\u0010\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/kakao/adfit/k/g;", "", "", "g", "Lkotlin/Function0;", "a", "Lkotlin/jvm/functions/Function0;", "onForegroundStateChanged", "", "<set-?>", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/kakao/adfit/k/u;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "()Z", "(Z)V", "isForeground", "c", "isAttached", "e", "isVisible", InneractiveMediationDefs.GENDER_FEMALE, "isWindowVisible", "hasWindowFocus", "hasLayoutSize", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class g {
    static final /* synthetic */ KProperty<Object>[] h = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(g.class, "isForeground", "isForeground()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(g.class, "isAttached", "isAttached()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(g.class, "isVisible", "isVisible()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(g.class, "isWindowVisible", "isWindowVisible()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(g.class, "hasWindowFocus", "getHasWindowFocus()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(g.class, "hasLayoutSize", "getHasLayoutSize()Z", 0))};

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final Function0<Unit> onForegroundStateChanged;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final u isForeground;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final u isAttached;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final u isVisible;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final u isWindowVisible;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final u hasWindowFocus;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final u hasLayoutSize;

    /* JADX INFO: compiled from: AdViewState.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "a", "(Z)V"}, k = 3, mv = {1, 6, 0})
    static final class a extends Lambda implements Function1<Boolean, Unit> {
        a() {
            super(1);
        }

        public final void a(boolean z) {
            g.this.g();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            a(bool.booleanValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: AdViewState.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "a", "(Z)V"}, k = 3, mv = {1, 6, 0})
    static final class b extends Lambda implements Function1<Boolean, Unit> {
        b() {
            super(1);
        }

        public final void a(boolean z) {
            g.this.g();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            a(bool.booleanValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: AdViewState.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "a", "(Z)V"}, k = 3, mv = {1, 6, 0})
    static final class c extends Lambda implements Function1<Boolean, Unit> {
        c() {
            super(1);
        }

        public final void a(boolean z) {
            g.this.g();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            a(bool.booleanValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: AdViewState.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "a", "(Z)V"}, k = 3, mv = {1, 6, 0})
    static final class d extends Lambda implements Function1<Boolean, Unit> {
        d() {
            super(1);
        }

        public final void a(boolean z) {
            g.this.onForegroundStateChanged.invoke();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            a(bool.booleanValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: AdViewState.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "a", "(Z)V"}, k = 3, mv = {1, 6, 0})
    static final class e extends Lambda implements Function1<Boolean, Unit> {
        e() {
            super(1);
        }

        public final void a(boolean z) {
            g.this.g();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            a(bool.booleanValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: AdViewState.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "a", "(Z)V"}, k = 3, mv = {1, 6, 0})
    static final class f extends Lambda implements Function1<Boolean, Unit> {
        f() {
            super(1);
        }

        public final void a(boolean z) {
            g.this.g();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            a(bool.booleanValue());
            return Unit.INSTANCE;
        }
    }

    public g(Function0<Unit> onForegroundStateChanged) {
        Intrinsics.checkNotNullParameter(onForegroundStateChanged, "onForegroundStateChanged");
        this.onForegroundStateChanged = onForegroundStateChanged;
        this.isForeground = new u(false, new d());
        this.isAttached = new u(false, new c());
        this.isVisible = new u(false, new e());
        this.isWindowVisible = new u(false, new f());
        this.hasWindowFocus = new u(false, new b());
        this.hasLayoutSize = new u(false, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        b(c() && e() && f() && b() && a());
    }

    public final boolean c() {
        return this.isAttached.getValue(this, h[1]).booleanValue();
    }

    public final boolean d() {
        return this.isForeground.getValue(this, h[0]).booleanValue();
    }

    public final boolean e() {
        return this.isVisible.getValue(this, h[2]).booleanValue();
    }

    public final boolean f() {
        return this.isWindowVisible.getValue(this, h[3]).booleanValue();
    }

    private final void b(boolean z) {
        this.isForeground.setValue(this, h[0], Boolean.valueOf(z));
    }

    public final void a(boolean z) {
        this.isAttached.setValue(this, h[1], Boolean.valueOf(z));
    }

    public final void c(boolean z) {
        this.hasLayoutSize.setValue(this, h[5], Boolean.valueOf(z));
    }

    public final void d(boolean z) {
        this.hasWindowFocus.setValue(this, h[4], Boolean.valueOf(z));
    }

    public final void e(boolean z) {
        this.isVisible.setValue(this, h[2], Boolean.valueOf(z));
    }

    public final void f(boolean z) {
        this.isWindowVisible.setValue(this, h[3], Boolean.valueOf(z));
    }

    public final boolean a() {
        return this.hasLayoutSize.getValue(this, h[5]).booleanValue();
    }

    public final boolean b() {
        return this.hasWindowFocus.getValue(this, h[4]).booleanValue();
    }
}
