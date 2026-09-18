package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: InitializeStateCreateWithRemote.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateCreateWithRemote", f = "InitializeStateCreateWithRemote.kt", i = {}, l = {27}, m = "doWork-gIAlu-s", n = {}, s = {})
final class InitializeStateCreateWithRemote$doWork$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InitializeStateCreateWithRemote this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateCreateWithRemote$doWork$1(InitializeStateCreateWithRemote initializeStateCreateWithRemote, Continuation<? super InitializeStateCreateWithRemote$doWork$1> continuation) {
        super(continuation);
        this.this$0 = initializeStateCreateWithRemote;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM500doWorkgIAlus = this.this$0.m500doWorkgIAlus((InitializeStateCreateWithRemote.Params) null, (Continuation<? super Result<? extends Configuration>>) this);
        return objM500doWorkgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM500doWorkgIAlus : Result.m513boximpl(objM500doWorkgIAlus);
    }
}
