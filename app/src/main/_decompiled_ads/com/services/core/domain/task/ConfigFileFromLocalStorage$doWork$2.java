package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.properties.SdkProperties;
import java.io.File;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: compiled from: ConfigFileFromLocalStorage.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/unity3d/services/core/configuration/Configuration;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage$doWork$2", f = "ConfigFileFromLocalStorage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ConfigFileFromLocalStorage$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Configuration>>, Object> {
    int label;

    ConfigFileFromLocalStorage$doWork$2(Continuation<? super ConfigFileFromLocalStorage$doWork$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConfigFileFromLocalStorage$doWork$2(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Configuration>> continuation) {
        return ((ConfigFileFromLocalStorage$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM514constructorimpl;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        try {
            Result.Companion companion = Result.INSTANCE;
            objM514constructorimpl = Result.m514constructorimpl(new Configuration(new JSONObject(FilesKt.readText$default(new File(SdkProperties.getLocalConfigurationFilepath()), null, 1, null))));
        } catch (CancellationException e) {
            throw e;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM514constructorimpl = Result.m514constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m521isSuccessimpl(objM514constructorimpl)) {
            Result.Companion companion3 = Result.INSTANCE;
            objM514constructorimpl = Result.m514constructorimpl(objM514constructorimpl);
        } else {
            Throwable thM517exceptionOrNullimpl = Result.m517exceptionOrNullimpl(objM514constructorimpl);
            if (thM517exceptionOrNullimpl != null) {
                Result.Companion companion4 = Result.INSTANCE;
                objM514constructorimpl = Result.m514constructorimpl(ResultKt.createFailure(thM517exceptionOrNullimpl));
            }
        }
        return Result.m513boximpl(objM514constructorimpl);
    }
}
