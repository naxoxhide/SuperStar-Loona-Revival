package com.kakao.adfit.k;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: ObservableBooleanProperty.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B2\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0004\b\u0012\u0010\u0013J$\u0010\u0007\u001a\u00020\u00022\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J$\u0010\t\u001a\u00020\b2\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0014R2\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\b0\n8\u0006¢\u0006\f\n\u0004\b\t\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/kakao/adfit/k/u;", "Lkotlin/properties/ObservableProperty;", "", "Lkotlin/reflect/KProperty;", "property", "oldValue", "newValue", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "", "a", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlin/jvm/functions/Function1;", "getOnChanged", "()Lkotlin/jvm/functions/Function1;", "onChanged", "initialValue", "<init>", "(ZLkotlin/jvm/functions/Function1;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class u extends ObservableProperty<Boolean> {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final Function1<Boolean, Unit> onChanged;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public u(boolean z, Function1<? super Boolean, Unit> onChanged) {
        super(Boolean.valueOf(z));
        Intrinsics.checkNotNullParameter(onChanged, "onChanged");
        this.onChanged = onChanged;
    }

    protected void a(KProperty<?> property, boolean oldValue, boolean newValue) {
        Intrinsics.checkNotNullParameter(property, "property");
        this.onChanged.invoke(Boolean.valueOf(newValue));
    }

    @Override // kotlin.properties.ObservableProperty
    public /* bridge */ /* synthetic */ void afterChange(KProperty kProperty, Boolean bool, Boolean bool2) {
        a(kProperty, bool.booleanValue(), bool2.booleanValue());
    }

    protected boolean b(KProperty<?> property, boolean oldValue, boolean newValue) {
        Intrinsics.checkNotNullParameter(property, "property");
        return oldValue != newValue;
    }

    @Override // kotlin.properties.ObservableProperty
    public /* bridge */ /* synthetic */ boolean beforeChange(KProperty kProperty, Boolean bool, Boolean bool2) {
        return b(kProperty, bool.booleanValue(), bool2.booleanValue());
    }
}
