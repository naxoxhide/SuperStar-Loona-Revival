package com.kakao.adfit.k;

import android.content.Context;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EacidRequests.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J^\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u00052#\u0010\r\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\n0\u0005R\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/kakao/adfit/k/m;", "", "", "appKey", "appUserId", "Lkotlin/Function1;", "Lcom/kakao/adfit/k/n;", "Lkotlin/ParameterName;", "name", "response", "", "onResponse", "message", "onError", "a", "Landroid/content/Context;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class m {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final Context context;

    public m(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final void a(String appKey, String appUserId, Function1<? super n, Unit> onResponse, Function1<? super String, Unit> onError) {
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(appUserId, "appUserId");
        Intrinsics.checkNotNullParameter(onResponse, "onResponse");
        Intrinsics.checkNotNullParameter(onError, "onError");
        try {
            String string = Uri.parse("https://acid-api.ds.kakao.com/acid").buildUpon().appendPath("appKey").appendPath(appKey).appendQueryParameter("appUserId", appUserId).build().toString();
            Intrinsics.checkNotNullExpressionValue(string, "parse(baseUrl).buildUpon…              .toString()");
            com.kakao.adfit.a.g.a(this.context).a(new l(string, onResponse, onError));
        } catch (Exception e) {
            com.kakao.adfit.e.f.a.a(e);
        }
    }
}
