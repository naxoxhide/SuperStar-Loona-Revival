package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.ErrorState;
import com.unity3d.services.core.extensions.TaskExtensionsKt;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import com.unity3d.services.core.network.model.RequestType;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: InitializeStateLoadWeb.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/unity3d/services/core/domain/task/InitializeStateLoadWeb$LoadWebResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateLoadWeb$doWork$2", f = "InitializeStateLoadWeb.kt", i = {0, 0, 1}, l = {44, 62, 69}, m = "invokeSuspend", n = {"$this$withContext", "request", "request"}, s = {"L$0", "L$3", "L$2"})
final class InitializeStateLoadWeb$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends InitializeStateLoadWeb.LoadWebResult>>, Object> {
    final /* synthetic */ InitializeStateLoadWeb.Params $params;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ InitializeStateLoadWeb this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateLoadWeb$doWork$2(InitializeStateLoadWeb.Params params, InitializeStateLoadWeb initializeStateLoadWeb, Continuation<? super InitializeStateLoadWeb$doWork$2> continuation) {
        super(2, continuation);
        this.$params = params;
        this.this$0 = initializeStateLoadWeb;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InitializeStateLoadWeb$doWork$2 initializeStateLoadWeb$doWork$2 = new InitializeStateLoadWeb$doWork$2(this.$params, this.this$0, continuation);
        initializeStateLoadWeb$doWork$2.L$0 = obj;
        return initializeStateLoadWeb$doWork$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends InitializeStateLoadWeb.LoadWebResult>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Result<InitializeStateLoadWeb.LoadWebResult>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<InitializeStateLoadWeb.LoadWebResult>> continuation) {
        return ((InitializeStateLoadWeb$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:48:0x016b A[Catch: all -> 0x01f5, CancellationException -> 0x0222, TryCatch #6 {CancellationException -> 0x0222, all -> 0x01f5, blocks: (B:8:0x0018, B:51:0x018e, B:55:0x01b1, B:57:0x01bb, B:60:0x01c6, B:61:0x01d8, B:63:0x01db, B:64:0x01e7, B:46:0x0165, B:48:0x016b, B:52:0x0191, B:53:0x01a3, B:45:0x015b, B:38:0x0129, B:54:0x01a4, B:37:0x011f, B:23:0x006f), top: B:80:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:50:0x018d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:52:0x0191 A[Catch: all -> 0x01f5, CancellationException -> 0x0222, TryCatch #6 {CancellationException -> 0x0222, all -> 0x01f5, blocks: (B:8:0x0018, B:51:0x018e, B:55:0x01b1, B:57:0x01bb, B:60:0x01c6, B:61:0x01d8, B:63:0x01db, B:64:0x01e7, B:46:0x0165, B:48:0x016b, B:52:0x0191, B:53:0x01a3, B:45:0x015b, B:38:0x0129, B:54:0x01a4, B:37:0x011f, B:23:0x006f), top: B:80:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:63:0x01db A[Catch: all -> 0x01f5, CancellationException -> 0x0222, TryCatch #6 {CancellationException -> 0x0222, all -> 0x01f5, blocks: (B:8:0x0018, B:51:0x018e, B:55:0x01b1, B:57:0x01bb, B:60:0x01c6, B:61:0x01d8, B:63:0x01db, B:64:0x01e7, B:46:0x0165, B:48:0x016b, B:52:0x0191, B:53:0x01a3, B:45:0x015b, B:38:0x0129, B:54:0x01a4, B:37:0x011f, B:23:0x006f), top: B:80:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:70:0x0206  */
    /* JADX WARN: Code duplicated, block: B:71:0x020d  */
    /* JADX WARN: Code duplicated, block: B:73:0x0213  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.unity3d.services.core.network.model.HttpRequest] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM514constructorimpl;
        Object objM514constructorimpl2;
        ?? r1;
        Object objWithContext;
        Throwable thM517exceptionOrNullimpl;
        InitializeStateLoadWeb.Params params;
        String string;
        String webViewHash;
        HttpRequest httpRequest;
        HttpRequest httpRequest2;
        InitializeStateLoadWeb initializeStateLoadWeb;
        Object objWithRetry;
        Object objM514constructorimpl3;
        HttpRequest httpRequest3;
        Object value;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        ?? r2 = 1;
        try {
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    InitializeStateLoadWeb.Params params2 = this.$params;
                    InitializeStateLoadWeb initializeStateLoadWeb2 = this.this$0;
                    Result.Companion companion = Result.INSTANCE;
                    DeviceLog.info("Unity Ads init: loading webapp from " + params2.getConfig().getWebViewUrl());
                    String webViewUrl = params2.getConfig().getWebViewUrl();
                    Intrinsics.checkNotNullExpressionValue(webViewUrl, "params.config.webViewUrl");
                    HttpRequest httpRequest4 = new HttpRequest(webViewUrl, null, RequestType.GET, null, null, null, null, null, null, 0, 0, 0, 0, 8186, null);
                    try {
                        Result.Companion companion2 = Result.INSTANCE;
                        int maxRetries = params2.getConfig().getMaxRetries();
                        double retryScalingFactor = params2.getConfig().getRetryScalingFactor();
                        long retryDelay = params2.getConfig().getRetryDelay();
                        InitializationException initializationException = new InitializationException(ErrorState.NetworkWebviewRequest, new Exception(), params2.getConfig());
                        InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1 initializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1 = new InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1(initializeStateLoadWeb2, httpRequest4, null);
                        this.L$0 = coroutineScope;
                        this.L$1 = params2;
                        this.L$2 = initializeStateLoadWeb2;
                        this.L$3 = httpRequest4;
                        this.label = 1;
                        httpRequest = httpRequest4;
                        try {
                            objWithRetry = TaskExtensionsKt.withRetry(retryDelay, maxRetries, retryScalingFactor, initializationException, initializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1, this);
                            if (objWithRetry == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            httpRequest2 = httpRequest;
                            params = params2;
                            initializeStateLoadWeb = initializeStateLoadWeb2;
                        } catch (Throwable th) {
                            th = th;
                            httpRequest2 = httpRequest;
                            params = params2;
                            initializeStateLoadWeb = initializeStateLoadWeb2;
                            Result.Companion companion3 = Result.INSTANCE;
                            objM514constructorimpl3 = Result.m514constructorimpl(ResultKt.createFailure(th));
                            httpRequest3 = httpRequest2;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        httpRequest = httpRequest4;
                    }
                } else {
                    if (i == 1) {
                        httpRequest2 = (HttpRequest) this.L$3;
                        initializeStateLoadWeb = (InitializeStateLoadWeb) this.L$2;
                        params = (InitializeStateLoadWeb.Params) this.L$1;
                        try {
                            ResultKt.throwOnFailure(obj);
                            objWithRetry = obj;
                            httpRequest2 = httpRequest2;
                        } catch (Throwable th3) {
                            th = th3;
                            Result.Companion companion4 = Result.INSTANCE;
                            objM514constructorimpl3 = Result.m514constructorimpl(ResultKt.createFailure(th));
                            httpRequest3 = httpRequest2;
                        }
                    } else if (i == 2) {
                        HttpRequest httpRequest5 = (HttpRequest) this.L$2;
                        initializeStateLoadWeb = (InitializeStateLoadWeb) this.L$1;
                        params = (InitializeStateLoadWeb.Params) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        value = ((Result) obj).getValue();
                        r2 = httpRequest5;
                        r2 = httpRequest3;
                        objM514constructorimpl2 = Result.m514constructorimpl(Result.m513boximpl(value));
                        r1 = r2;
                        if (Result.m521isSuccessimpl(objM514constructorimpl2)) {
                            CoroutineDispatcher io = initializeStateLoadWeb.dispatchers.getIo();
                            InitializeStateLoadWeb$doWork$2$1$webViewData$1 initializeStateLoadWeb$doWork$2$1$webViewData$1 = new InitializeStateLoadWeb$doWork$2$1$webViewData$1(initializeStateLoadWeb, r1, null);
                            this.L$0 = params;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.label = 3;
                            objWithContext = BuildersKt.withContext(io, initializeStateLoadWeb$doWork$2$1$webViewData$1, this);
                            if (objWithContext == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            throw new InitializationException(ErrorState.NetworkWebviewRequest, new Exception("No connected events within the timeout!"), params.getConfig());
                        }
                    } else {
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        InitializeStateLoadWeb.Params params3 = (InitializeStateLoadWeb.Params) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        params = params3;
                        objWithContext = obj;
                    }
                    string = (String) objWithContext;
                    webViewHash = params.getConfig().getWebViewHash();
                    if (webViewHash != null && !Intrinsics.areEqual(Utilities.Sha256(string), webViewHash)) {
                        throw new InitializationException(ErrorState.InvalidHash, new Exception("Invalid webViewHash"), params.getConfig());
                    }
                    if (webViewHash != null) {
                        Utilities.writeFile(new File(SdkProperties.getLocalWebViewFile()), string);
                    }
                    objM514constructorimpl = Result.m514constructorimpl(new InitializeStateLoadWeb.LoadWebResult(params.getConfig(), string));
                    if (Result.m521isSuccessimpl(objM514constructorimpl)) {
                        Result.Companion companion5 = Result.INSTANCE;
                        objM514constructorimpl = Result.m514constructorimpl(objM514constructorimpl);
                    } else {
                        thM517exceptionOrNullimpl = Result.m517exceptionOrNullimpl(objM514constructorimpl);
                        if (thM517exceptionOrNullimpl != null) {
                            Result.Companion companion6 = Result.INSTANCE;
                            objM514constructorimpl = Result.m514constructorimpl(ResultKt.createFailure(thM517exceptionOrNullimpl));
                        }
                    }
                    return Result.m513boximpl(objM514constructorimpl);
                }
                objM514constructorimpl3 = Result.m514constructorimpl((HttpResponse) objWithRetry);
                httpRequest3 = httpRequest2;
                if (Result.m520isFailureimpl(objM514constructorimpl3)) {
                    Result.Companion companion7 = Result.INSTANCE;
                    InitializeStateNetworkError initializeStateNetworkError = initializeStateLoadWeb.initializeStateNetworkError;
                    InitializeStateNetworkError.Params params4 = new InitializeStateNetworkError.Params(params.getConfig());
                    this.L$0 = params;
                    this.L$1 = initializeStateLoadWeb;
                    this.L$2 = httpRequest3;
                    this.L$3 = null;
                    this.label = 2;
                    value = initializeStateNetworkError.mo489invokegIAlus(params4, this);
                    if (value == coroutine_suspended) {
                        r2 = httpRequest3;
                        return coroutine_suspended;
                    }
                    r2 = httpRequest3;
                    objM514constructorimpl2 = Result.m514constructorimpl(Result.m513boximpl(value));
                    r1 = r2;
                    if (Result.m521isSuccessimpl(objM514constructorimpl2)) {
                        CoroutineDispatcher io2 = initializeStateLoadWeb.dispatchers.getIo();
                        InitializeStateLoadWeb$doWork$2$1$webViewData$1 initializeStateLoadWeb$doWork$2$1$webViewData$2 = new InitializeStateLoadWeb$doWork$2$1$webViewData$1(initializeStateLoadWeb, r1, null);
                        this.L$0 = params;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 3;
                        objWithContext = BuildersKt.withContext(io2, initializeStateLoadWeb$doWork$2$1$webViewData$2, this);
                        if (objWithContext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        string = (String) objWithContext;
                    } else {
                        throw new InitializationException(ErrorState.NetworkWebviewRequest, new Exception("No connected events within the timeout!"), params.getConfig());
                    }
                } else {
                    ResultKt.throwOnFailure(objM514constructorimpl3);
                    string = ((HttpResponse) objM514constructorimpl3).getBody().toString();
                }
            } catch (CancellationException e) {
                throw e;
            } catch (Throwable th4) {
                Result.Companion companion8 = Result.INSTANCE;
                objM514constructorimpl = Result.m514constructorimpl(ResultKt.createFailure(th4));
            }
        } catch (Throwable th5) {
            Result.Companion companion9 = Result.INSTANCE;
            objM514constructorimpl2 = Result.m514constructorimpl(ResultKt.createFailure(th5));
            r1 = r2;
        }
        webViewHash = params.getConfig().getWebViewHash();
        if (webViewHash != null) {
            throw new InitializationException(ErrorState.InvalidHash, new Exception("Invalid webViewHash"), params.getConfig());
        }
        if (webViewHash != null) {
            Utilities.writeFile(new File(SdkProperties.getLocalWebViewFile()), string);
        }
        objM514constructorimpl = Result.m514constructorimpl(new InitializeStateLoadWeb.LoadWebResult(params.getConfig(), string));
        if (Result.m521isSuccessimpl(objM514constructorimpl)) {
            Result.Companion companion10 = Result.INSTANCE;
            objM514constructorimpl = Result.m514constructorimpl(objM514constructorimpl);
        } else {
            thM517exceptionOrNullimpl = Result.m517exceptionOrNullimpl(objM514constructorimpl);
            if (thM517exceptionOrNullimpl != null) {
                Result.Companion companion11 = Result.INSTANCE;
                objM514constructorimpl = Result.m514constructorimpl(ResultKt.createFailure(thM517exceptionOrNullimpl));
            }
        }
        return Result.m513boximpl(objM514constructorimpl);
    }
}
