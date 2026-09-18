package com.unity3d.services.core.extensions;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CoroutineExtensions.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a.\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0086\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u0005\u001a.\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0086\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u0005\u0082\u0002\u000b\n\u0005\b\u009920\u0001\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"runReturnSuspendCatching", "Lkotlin/Result;", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "runSuspendCatching", "unity-ads_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CoroutineExtensionsKt {
    public static final <R> Object runSuspendCatching(Function0<? extends R> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            Result.Companion companion = Result.INSTANCE;
            return Result.m514constructorimpl(block.invoke());
        } catch (CancellationException e) {
            throw e;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m514constructorimpl(ResultKt.createFailure(th));
        }
    }

    public static final <R> Object runReturnSuspendCatching(Function0<? extends R> block) {
        Object objM514constructorimpl;
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            Result.Companion companion = Result.INSTANCE;
            objM514constructorimpl = Result.m514constructorimpl(block.invoke());
        } catch (CancellationException e) {
            throw e;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM514constructorimpl = Result.m514constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m521isSuccessimpl(objM514constructorimpl)) {
            Result.Companion companion3 = Result.INSTANCE;
            return Result.m514constructorimpl(objM514constructorimpl);
        }
        Throwable thM517exceptionOrNullimpl = Result.m517exceptionOrNullimpl(objM514constructorimpl);
        if (thM517exceptionOrNullimpl == null) {
            return objM514constructorimpl;
        }
        Result.Companion companion4 = Result.INSTANCE;
        return Result.m514constructorimpl(ResultKt.createFailure(thM517exceptionOrNullimpl));
    }
}
