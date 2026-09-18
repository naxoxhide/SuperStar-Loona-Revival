package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.ConfigurationLoader;
import com.unity3d.services.core.configuration.ConfigurationRequestFactory;
import com.unity3d.services.core.configuration.ErrorState;
import com.unity3d.services.core.configuration.IConfigurationLoader;
import com.unity3d.services.core.configuration.InitRequestType;
import com.unity3d.services.core.configuration.InitializeEventsMetricSender;
import com.unity3d.services.core.configuration.PrivacyConfigStorage;
import com.unity3d.services.core.configuration.PrivacyConfigurationLoader;
import com.unity3d.services.core.device.reader.DeviceInfoDataFactory;
import com.unity3d.services.core.extensions.AbortRetryException;
import com.unity3d.services.core.extensions.TaskExtensionsKt;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
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
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: InitializeStateConfigWithLoader.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/unity3d/services/core/configuration/Configuration;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2", f = "InitializeStateConfigWithLoader.kt", i = {0, 0, 0, 1, 1, 2}, l = {53, 96, 104}, m = "invokeSuspend", n = {"$this$withContext", "configurationLoader", "config", "configurationLoader", "config", "config"}, s = {"L$0", "L$3", "L$4", "L$2", "L$3", "L$0"})
final class InitializeStateConfigWithLoader$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Configuration>>, Object> {
    final /* synthetic */ InitializeStateConfigWithLoader.Params $params;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ InitializeStateConfigWithLoader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateConfigWithLoader$doWork$2(InitializeStateConfigWithLoader.Params params, InitializeStateConfigWithLoader initializeStateConfigWithLoader, Continuation<? super InitializeStateConfigWithLoader$doWork$2> continuation) {
        super(2, continuation);
        this.$params = params;
        this.this$0 = initializeStateConfigWithLoader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InitializeStateConfigWithLoader$doWork$2 initializeStateConfigWithLoader$doWork$2 = new InitializeStateConfigWithLoader$doWork$2(this.$params, this.this$0, continuation);
        initializeStateConfigWithLoader$doWork$2.L$0 = obj;
        return initializeStateConfigWithLoader$doWork$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Configuration>> continuation) {
        return ((InitializeStateConfigWithLoader$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:53:0x01a3 A[Catch: all -> 0x0211, CancellationException -> 0x023e, TryCatch #7 {CancellationException -> 0x023e, all -> 0x0211, blocks: (B:8:0x001b, B:57:0x01d5, B:63:0x0206, B:51:0x019a, B:53:0x01a3, B:58:0x01df, B:59:0x01f1, B:50:0x0190, B:38:0x014e, B:40:0x0157, B:60:0x01f2, B:61:0x01ff, B:62:0x0200, B:37:0x0144, B:23:0x007c), top: B:87:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:55:0x01d2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:56:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:58:0x01df A[Catch: all -> 0x0211, CancellationException -> 0x023e, TryCatch #7 {CancellationException -> 0x023e, all -> 0x0211, blocks: (B:8:0x001b, B:57:0x01d5, B:63:0x0206, B:51:0x019a, B:53:0x01a3, B:58:0x01df, B:59:0x01f1, B:50:0x0190, B:38:0x014e, B:40:0x0157, B:60:0x01f2, B:61:0x01ff, B:62:0x0200, B:37:0x0144, B:23:0x007c), top: B:87:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0222  */
    /* JADX WARN: Code duplicated, block: B:70:0x0229  */
    /* JADX WARN: Code duplicated, block: B:72:0x022f  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [T, com.unity3d.services.core.configuration.Configuration] */
    /* JADX WARN: Type inference failed for: r4v0, types: [T, com.unity3d.services.core.configuration.ConfigurationLoader] */
    /* JADX WARN: Type inference failed for: r4v1, types: [T, com.unity3d.services.core.configuration.PrivacyConfigurationLoader] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM514constructorimpl;
        Throwable thM517exceptionOrNullimpl;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        Ref.ObjectRef objectRef3;
        InitializeStateConfigWithLoader.Params params;
        InitializeStateConfigWithLoader initializeStateConfigWithLoader;
        Object objM514constructorimpl2;
        InitializeStateConfigWithLoader.Params params2;
        InitializeStateConfigWithLoader initializeStateConfigWithLoader2;
        Ref.ObjectRef objectRef4;
        Ref.ObjectRef objectRef5;
        Ref.ObjectRef objectRef6;
        Object value;
        Object objM514constructorimpl3;
        Ref.ObjectRef objectRef7;
        InitializeStateConfigWithLoader.Params params3;
        InitializeStateConfigWithLoader initializeStateConfigWithLoader3;
        CoroutineDispatcher io;
        InitializeStateConfigWithLoader$doWork$2$1$1 initializeStateConfigWithLoader$doWork$2$1$1;
        Ref.ObjectRef objectRef8;
        Ref.ObjectRef objectRef9;
        T t;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                InitializeStateConfigWithLoader.Params params4 = this.$params;
                InitializeStateConfigWithLoader initializeStateConfigWithLoader4 = this.this$0;
                Result.Companion companion = Result.INSTANCE;
                PrivacyConfigStorage privacyConfigStorage = PrivacyConfigStorage.getInstance();
                DeviceInfoDataFactory deviceInfoDataFactory = new DeviceInfoDataFactory();
                Ref.ObjectRef objectRef10 = new Ref.ObjectRef();
                objectRef10.element = new ConfigurationLoader(new ConfigurationRequestFactory(params4.getConfig(), deviceInfoDataFactory.getDeviceInfoData(InitRequestType.TOKEN)), (SDKMetricsSender) initializeStateConfigWithLoader4.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(SDKMetricsSender.class)));
                objectRef10.element = new PrivacyConfigurationLoader((IConfigurationLoader) objectRef10.element, new ConfigurationRequestFactory(params4.getConfig(), deviceInfoDataFactory.getDeviceInfoData(InitRequestType.PRIVACY)), privacyConfigStorage);
                Ref.ObjectRef objectRef11 = new Ref.ObjectRef();
                objectRef11.element = new Configuration();
                try {
                    Result.Companion companion2 = Result.INSTANCE;
                    int maxRetries = params4.getConfig().getMaxRetries();
                    double retryScalingFactor = params4.getConfig().getRetryScalingFactor();
                    long retryDelay = params4.getConfig().getRetryDelay();
                    InitializationException initializationException = new InitializationException(ErrorState.NetworkConfigRequest, new Exception(), params4.getConfig());
                    InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1 initializeStateConfigWithLoader$doWork$2$1$configResult$1$1 = new InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1(initializeStateConfigWithLoader4, objectRef10, objectRef11, null);
                    this.L$0 = coroutineScope;
                    this.L$1 = params4;
                    this.L$2 = initializeStateConfigWithLoader4;
                    this.L$3 = objectRef10;
                    this.L$4 = objectRef11;
                    this.label = 1;
                    objectRef = objectRef10;
                    try {
                        if (TaskExtensionsKt.withRetry(retryDelay, maxRetries, retryScalingFactor, initializationException, initializeStateConfigWithLoader$doWork$2$1$configResult$1$1, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        objectRef2 = objectRef11;
                        objectRef3 = objectRef;
                        params = params4;
                        initializeStateConfigWithLoader = initializeStateConfigWithLoader4;
                    } catch (Throwable th) {
                        th = th;
                        objectRef2 = objectRef11;
                        objectRef3 = objectRef;
                        params = params4;
                        initializeStateConfigWithLoader = initializeStateConfigWithLoader4;
                        Result.Companion companion3 = Result.INSTANCE;
                        objM514constructorimpl2 = Result.m514constructorimpl(ResultKt.createFailure(th));
                    }
                } catch (Throwable th2) {
                    th = th2;
                    objectRef = objectRef10;
                }
            } else {
                if (i == 1) {
                    objectRef2 = (Ref.ObjectRef) this.L$4;
                    objectRef3 = (Ref.ObjectRef) this.L$3;
                    initializeStateConfigWithLoader = (InitializeStateConfigWithLoader) this.L$2;
                    params = (InitializeStateConfigWithLoader.Params) this.L$1;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th3) {
                        th = th3;
                        Result.Companion companion4 = Result.INSTANCE;
                        objM514constructorimpl2 = Result.m514constructorimpl(ResultKt.createFailure(th));
                    }
                } else if (i == 2) {
                    objectRef2 = (Ref.ObjectRef) this.L$4;
                    objectRef6 = (Ref.ObjectRef) this.L$3;
                    objectRef4 = (Ref.ObjectRef) this.L$2;
                    initializeStateConfigWithLoader2 = (InitializeStateConfigWithLoader) this.L$1;
                    params2 = (InitializeStateConfigWithLoader.Params) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        value = ((Result) obj).getValue();
                        objM514constructorimpl3 = Result.m514constructorimpl(Result.m513boximpl(value));
                    } catch (Throwable th4) {
                        th = th4;
                        Result.Companion companion5 = Result.INSTANCE;
                        objM514constructorimpl3 = Result.m514constructorimpl(ResultKt.createFailure(th));
                    }
                    objectRef7 = objectRef6;
                    params3 = params2;
                    initializeStateConfigWithLoader3 = initializeStateConfigWithLoader2;
                    if (Result.m521isSuccessimpl(objM514constructorimpl3)) {
                        InitializeEventsMetricSender.getInstance().onRetryConfig();
                        io = initializeStateConfigWithLoader3.dispatchers.getIo();
                        initializeStateConfigWithLoader$doWork$2$1$1 = new InitializeStateConfigWithLoader$doWork$2$1$1(objectRef4, objectRef7, initializeStateConfigWithLoader3, params3, null);
                        this.L$0 = objectRef7;
                        this.L$1 = objectRef2;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.L$4 = null;
                        this.label = 3;
                        if (BuildersKt.withContext(io, initializeStateConfigWithLoader$doWork$2$1$1, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        objectRef8 = objectRef2;
                        objectRef9 = objectRef7;
                    } else {
                        throw new InitializationException(ErrorState.NetworkConfigRequest, new Exception("No connected events within the timeout!"), params3.getConfig());
                    }
                } else {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    objectRef8 = (Ref.ObjectRef) this.L$1;
                    objectRef9 = (Ref.ObjectRef) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                Configuration configuration = (Configuration) objectRef9.element;
                Ref.ObjectRef objectRef12 = objectRef9;
                objectRef2 = objectRef8;
                objectRef5 = objectRef12;
                t = configuration;
                objectRef2.element = t;
                objM514constructorimpl = Result.m514constructorimpl((Configuration) objectRef5.element);
                if (Result.m521isSuccessimpl(objM514constructorimpl)) {
                    Result.Companion companion6 = Result.INSTANCE;
                    objM514constructorimpl = Result.m514constructorimpl(objM514constructorimpl);
                } else {
                    thM517exceptionOrNullimpl = Result.m517exceptionOrNullimpl(objM514constructorimpl);
                    if (thM517exceptionOrNullimpl != null) {
                        Result.Companion companion7 = Result.INSTANCE;
                        objM514constructorimpl = Result.m514constructorimpl(ResultKt.createFailure(thM517exceptionOrNullimpl));
                    }
                }
                return Result.m513boximpl(objM514constructorimpl);
            }
            objM514constructorimpl2 = Result.m514constructorimpl(Unit.INSTANCE);
            params2 = params;
            initializeStateConfigWithLoader2 = initializeStateConfigWithLoader;
            objectRef4 = objectRef3;
            if (Result.m520isFailureimpl(objM514constructorimpl2)) {
                Throwable thM517exceptionOrNullimpl2 = Result.m517exceptionOrNullimpl(objM514constructorimpl2);
                if (thM517exceptionOrNullimpl2 instanceof AbortRetryException) {
                    throw new InitializationException(ErrorState.NetworkConfigRequest, (Exception) thM517exceptionOrNullimpl2, params2.getConfig());
                }
                try {
                    Result.Companion companion8 = Result.INSTANCE;
                    InitializeStateNetworkError initializeStateNetworkError = initializeStateConfigWithLoader2.initializeStateNetworkError;
                    InitializeStateNetworkError.Params params5 = new InitializeStateNetworkError.Params(params2.getConfig());
                    this.L$0 = params2;
                    this.L$1 = initializeStateConfigWithLoader2;
                    this.L$2 = objectRef4;
                    this.L$3 = objectRef2;
                    this.L$4 = objectRef2;
                    this.label = 2;
                    value = initializeStateNetworkError.mo489invokegIAlus(params5, this);
                    if (value == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef6 = objectRef2;
                    objM514constructorimpl3 = Result.m514constructorimpl(Result.m513boximpl(value));
                    objectRef7 = objectRef6;
                    params3 = params2;
                    initializeStateConfigWithLoader3 = initializeStateConfigWithLoader2;
                    if (Result.m521isSuccessimpl(objM514constructorimpl3)) {
                        InitializeEventsMetricSender.getInstance().onRetryConfig();
                        io = initializeStateConfigWithLoader3.dispatchers.getIo();
                        initializeStateConfigWithLoader$doWork$2$1$1 = new InitializeStateConfigWithLoader$doWork$2$1$1(objectRef4, objectRef7, initializeStateConfigWithLoader3, params3, null);
                        this.L$0 = objectRef7;
                        this.L$1 = objectRef2;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.L$4 = null;
                        this.label = 3;
                        if (BuildersKt.withContext(io, initializeStateConfigWithLoader$doWork$2$1$1, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        objectRef8 = objectRef2;
                        objectRef9 = objectRef7;
                        Configuration configuration2 = (Configuration) objectRef9.element;
                        Ref.ObjectRef objectRef13 = objectRef9;
                        objectRef2 = objectRef8;
                        objectRef5 = objectRef13;
                        t = configuration2;
                    } else {
                        throw new InitializationException(ErrorState.NetworkConfigRequest, new Exception("No connected events within the timeout!"), params3.getConfig());
                    }
                } catch (Throwable th5) {
                    th = th5;
                    objectRef6 = objectRef2;
                    Result.Companion companion9 = Result.INSTANCE;
                    objM514constructorimpl3 = Result.m514constructorimpl(ResultKt.createFailure(th));
                }
            } else {
                objectRef5 = objectRef2;
                t = (Configuration) objectRef2.element;
            }
            objectRef2.element = t;
            objM514constructorimpl = Result.m514constructorimpl((Configuration) objectRef5.element);
        } catch (CancellationException e) {
            throw e;
        } catch (Throwable th6) {
            Result.Companion companion10 = Result.INSTANCE;
            objM514constructorimpl = Result.m514constructorimpl(ResultKt.createFailure(th6));
        }
        if (Result.m521isSuccessimpl(objM514constructorimpl)) {
            Result.Companion companion11 = Result.INSTANCE;
            objM514constructorimpl = Result.m514constructorimpl(objM514constructorimpl);
        } else {
            thM517exceptionOrNullimpl = Result.m517exceptionOrNullimpl(objM514constructorimpl);
            if (thM517exceptionOrNullimpl != null) {
                Result.Companion companion12 = Result.INSTANCE;
                objM514constructorimpl = Result.m514constructorimpl(ResultKt.createFailure(thM517exceptionOrNullimpl));
            }
        }
        return Result.m513boximpl(objM514constructorimpl);
    }
}
