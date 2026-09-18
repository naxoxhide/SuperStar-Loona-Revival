package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.ErrorState;
import com.unity3d.services.core.configuration.InitializeEventsMetricSender;
import com.unity3d.services.core.domain.ResultExtensionsKt;
import com.unity3d.services.core.lifecycle.CachedLifecycle;
import com.unity3d.services.core.log.DeviceLog;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: InitializeSDK.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeSDK$doWork$2", f = "InitializeSDK.kt", i = {0, 1, 1, 2, 3, 3, 4, 4, 4, 5, 5, 5, 7, 7, 7, 8, 8, 8, 9, 10, 11, 11, 12, 13}, l = {43, 48, 50, 55, 57, 62, 66, 69, 74, 77, 92, 95, 103, 106, 109}, m = "invokeSuspend", n = {"$this$withContext", "$this$withContext", "configuration", "resetResult", "$this$withContext", "configuration", "$this$withContext", "configResult", "configuration", "$this$withContext", "configResult", "configuration", "$this$withContext", "configResult", "configuration", "$this$withContext", "configResult", "configuration", "loadCacheResult", "configResult", "configResult", "loadWebResult", "configResult", "configResult"}, s = {"L$0", "L$0", "L$2", "L$0", "L$0", "L$2", "L$0", "L$2", "L$3", "L$0", "L$2", "L$3", "L$0", "L$2", "L$3", "L$0", "L$2", "L$3", "L$0", "L$1", "L$1", "L$2", "L$1", "L$1"})
final class InitializeSDK$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ InitializeSDK this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeSDK$doWork$2(InitializeSDK initializeSDK, Continuation<? super InitializeSDK$doWork$2> continuation) {
        super(2, continuation);
        this.this$0 = initializeSDK;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InitializeSDK$doWork$2 initializeSDK$doWork$2 = new InitializeSDK$doWork$2(this.this$0, continuation);
        initializeSDK$doWork$2.L$0 = obj;
        return initializeSDK$doWork$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Result<Unit>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit>> continuation) {
        return ((InitializeSDK$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x029d A[Catch: all -> 0x03c6, CancellationException -> 0x03f3, TryCatch #2 {CancellationException -> 0x03f3, all -> 0x03c6, blocks: (B:6:0x0012, B:139:0x03b0, B:140:0x03b3, B:9:0x0023, B:136:0x0391, B:12:0x002e, B:131:0x0378, B:133:0x037e, B:15:0x0041, B:124:0x0342, B:127:0x0352, B:18:0x004c, B:119:0x0327, B:121:0x032d, B:22:0x005c, B:105:0x02b7, B:107:0x02bd, B:108:0x02ca, B:25:0x0074, B:99:0x0297, B:101:0x029d, B:109:0x02cb, B:111:0x02d6, B:113:0x02e0, B:115:0x02e6, B:116:0x0303, B:125:0x034c, B:141:0x03ba, B:142:0x03c5, B:28:0x008d, B:96:0x0273, B:29:0x0092, B:92:0x0257, B:32:0x00ab, B:87:0x022f, B:89:0x0235, B:93:0x025c, B:35:0x00c4, B:82:0x0202, B:84:0x020c, B:38:0x00d5, B:77:0x01e6, B:79:0x01ec, B:41:0x00e5, B:70:0x01b7, B:72:0x01bd, B:73:0x01ca, B:44:0x00fb, B:64:0x019a, B:66:0x01a0, B:74:0x01cb, B:47:0x010e, B:55:0x0150, B:57:0x0156, B:58:0x0170, B:61:0x017c, B:51:0x0123), top: B:155:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:103:0x02b5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:104:0x02b6  */
    /* JADX WARN: Code duplicated, block: B:107:0x02bd A[Catch: all -> 0x03c6, CancellationException -> 0x03f3, TryCatch #2 {CancellationException -> 0x03f3, all -> 0x03c6, blocks: (B:6:0x0012, B:139:0x03b0, B:140:0x03b3, B:9:0x0023, B:136:0x0391, B:12:0x002e, B:131:0x0378, B:133:0x037e, B:15:0x0041, B:124:0x0342, B:127:0x0352, B:18:0x004c, B:119:0x0327, B:121:0x032d, B:22:0x005c, B:105:0x02b7, B:107:0x02bd, B:108:0x02ca, B:25:0x0074, B:99:0x0297, B:101:0x029d, B:109:0x02cb, B:111:0x02d6, B:113:0x02e0, B:115:0x02e6, B:116:0x0303, B:125:0x034c, B:141:0x03ba, B:142:0x03c5, B:28:0x008d, B:96:0x0273, B:29:0x0092, B:92:0x0257, B:32:0x00ab, B:87:0x022f, B:89:0x0235, B:93:0x025c, B:35:0x00c4, B:82:0x0202, B:84:0x020c, B:38:0x00d5, B:77:0x01e6, B:79:0x01ec, B:41:0x00e5, B:70:0x01b7, B:72:0x01bd, B:73:0x01ca, B:44:0x00fb, B:64:0x019a, B:66:0x01a0, B:74:0x01cb, B:47:0x010e, B:55:0x0150, B:57:0x0156, B:58:0x0170, B:61:0x017c, B:51:0x0123), top: B:155:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:109:0x02cb A[Catch: all -> 0x03c6, CancellationException -> 0x03f3, TryCatch #2 {CancellationException -> 0x03f3, all -> 0x03c6, blocks: (B:6:0x0012, B:139:0x03b0, B:140:0x03b3, B:9:0x0023, B:136:0x0391, B:12:0x002e, B:131:0x0378, B:133:0x037e, B:15:0x0041, B:124:0x0342, B:127:0x0352, B:18:0x004c, B:119:0x0327, B:121:0x032d, B:22:0x005c, B:105:0x02b7, B:107:0x02bd, B:108:0x02ca, B:25:0x0074, B:99:0x0297, B:101:0x029d, B:109:0x02cb, B:111:0x02d6, B:113:0x02e0, B:115:0x02e6, B:116:0x0303, B:125:0x034c, B:141:0x03ba, B:142:0x03c5, B:28:0x008d, B:96:0x0273, B:29:0x0092, B:92:0x0257, B:32:0x00ab, B:87:0x022f, B:89:0x0235, B:93:0x025c, B:35:0x00c4, B:82:0x0202, B:84:0x020c, B:38:0x00d5, B:77:0x01e6, B:79:0x01ec, B:41:0x00e5, B:70:0x01b7, B:72:0x01bd, B:73:0x01ca, B:44:0x00fb, B:64:0x019a, B:66:0x01a0, B:74:0x01cb, B:47:0x010e, B:55:0x0150, B:57:0x0156, B:58:0x0170, B:61:0x017c, B:51:0x0123), top: B:155:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:111:0x02d6 A[Catch: all -> 0x03c6, CancellationException -> 0x03f3, TryCatch #2 {CancellationException -> 0x03f3, all -> 0x03c6, blocks: (B:6:0x0012, B:139:0x03b0, B:140:0x03b3, B:9:0x0023, B:136:0x0391, B:12:0x002e, B:131:0x0378, B:133:0x037e, B:15:0x0041, B:124:0x0342, B:127:0x0352, B:18:0x004c, B:119:0x0327, B:121:0x032d, B:22:0x005c, B:105:0x02b7, B:107:0x02bd, B:108:0x02ca, B:25:0x0074, B:99:0x0297, B:101:0x029d, B:109:0x02cb, B:111:0x02d6, B:113:0x02e0, B:115:0x02e6, B:116:0x0303, B:125:0x034c, B:141:0x03ba, B:142:0x03c5, B:28:0x008d, B:96:0x0273, B:29:0x0092, B:92:0x0257, B:32:0x00ab, B:87:0x022f, B:89:0x0235, B:93:0x025c, B:35:0x00c4, B:82:0x0202, B:84:0x020c, B:38:0x00d5, B:77:0x01e6, B:79:0x01ec, B:41:0x00e5, B:70:0x01b7, B:72:0x01bd, B:73:0x01ca, B:44:0x00fb, B:64:0x019a, B:66:0x01a0, B:74:0x01cb, B:47:0x010e, B:55:0x0150, B:57:0x0156, B:58:0x0170, B:61:0x017c, B:51:0x0123), top: B:155:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:113:0x02e0 A[Catch: all -> 0x03c6, CancellationException -> 0x03f3, TryCatch #2 {CancellationException -> 0x03f3, all -> 0x03c6, blocks: (B:6:0x0012, B:139:0x03b0, B:140:0x03b3, B:9:0x0023, B:136:0x0391, B:12:0x002e, B:131:0x0378, B:133:0x037e, B:15:0x0041, B:124:0x0342, B:127:0x0352, B:18:0x004c, B:119:0x0327, B:121:0x032d, B:22:0x005c, B:105:0x02b7, B:107:0x02bd, B:108:0x02ca, B:25:0x0074, B:99:0x0297, B:101:0x029d, B:109:0x02cb, B:111:0x02d6, B:113:0x02e0, B:115:0x02e6, B:116:0x0303, B:125:0x034c, B:141:0x03ba, B:142:0x03c5, B:28:0x008d, B:96:0x0273, B:29:0x0092, B:92:0x0257, B:32:0x00ab, B:87:0x022f, B:89:0x0235, B:93:0x025c, B:35:0x00c4, B:82:0x0202, B:84:0x020c, B:38:0x00d5, B:77:0x01e6, B:79:0x01ec, B:41:0x00e5, B:70:0x01b7, B:72:0x01bd, B:73:0x01ca, B:44:0x00fb, B:64:0x019a, B:66:0x01a0, B:74:0x01cb, B:47:0x010e, B:55:0x0150, B:57:0x0156, B:58:0x0170, B:61:0x017c, B:51:0x0123), top: B:155:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:118:0x0326 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:121:0x032d A[Catch: all -> 0x03c6, CancellationException -> 0x03f3, TryCatch #2 {CancellationException -> 0x03f3, all -> 0x03c6, blocks: (B:6:0x0012, B:139:0x03b0, B:140:0x03b3, B:9:0x0023, B:136:0x0391, B:12:0x002e, B:131:0x0378, B:133:0x037e, B:15:0x0041, B:124:0x0342, B:127:0x0352, B:18:0x004c, B:119:0x0327, B:121:0x032d, B:22:0x005c, B:105:0x02b7, B:107:0x02bd, B:108:0x02ca, B:25:0x0074, B:99:0x0297, B:101:0x029d, B:109:0x02cb, B:111:0x02d6, B:113:0x02e0, B:115:0x02e6, B:116:0x0303, B:125:0x034c, B:141:0x03ba, B:142:0x03c5, B:28:0x008d, B:96:0x0273, B:29:0x0092, B:92:0x0257, B:32:0x00ab, B:87:0x022f, B:89:0x0235, B:93:0x025c, B:35:0x00c4, B:82:0x0202, B:84:0x020c, B:38:0x00d5, B:77:0x01e6, B:79:0x01ec, B:41:0x00e5, B:70:0x01b7, B:72:0x01bd, B:73:0x01ca, B:44:0x00fb, B:64:0x019a, B:66:0x01a0, B:74:0x01cb, B:47:0x010e, B:55:0x0150, B:57:0x0156, B:58:0x0170, B:61:0x017c, B:51:0x0123), top: B:155:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:123:0x0341 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:125:0x034c A[Catch: all -> 0x03c6, CancellationException -> 0x03f3, TryCatch #2 {CancellationException -> 0x03f3, all -> 0x03c6, blocks: (B:6:0x0012, B:139:0x03b0, B:140:0x03b3, B:9:0x0023, B:136:0x0391, B:12:0x002e, B:131:0x0378, B:133:0x037e, B:15:0x0041, B:124:0x0342, B:127:0x0352, B:18:0x004c, B:119:0x0327, B:121:0x032d, B:22:0x005c, B:105:0x02b7, B:107:0x02bd, B:108:0x02ca, B:25:0x0074, B:99:0x0297, B:101:0x029d, B:109:0x02cb, B:111:0x02d6, B:113:0x02e0, B:115:0x02e6, B:116:0x0303, B:125:0x034c, B:141:0x03ba, B:142:0x03c5, B:28:0x008d, B:96:0x0273, B:29:0x0092, B:92:0x0257, B:32:0x00ab, B:87:0x022f, B:89:0x0235, B:93:0x025c, B:35:0x00c4, B:82:0x0202, B:84:0x020c, B:38:0x00d5, B:77:0x01e6, B:79:0x01ec, B:41:0x00e5, B:70:0x01b7, B:72:0x01bd, B:73:0x01ca, B:44:0x00fb, B:64:0x019a, B:66:0x01a0, B:74:0x01cb, B:47:0x010e, B:55:0x0150, B:57:0x0156, B:58:0x0170, B:61:0x017c, B:51:0x0123), top: B:155:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:129:0x0375 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:130:0x0376  */
    /* JADX WARN: Code duplicated, block: B:133:0x037e A[Catch: all -> 0x03c6, CancellationException -> 0x03f3, TryCatch #2 {CancellationException -> 0x03f3, all -> 0x03c6, blocks: (B:6:0x0012, B:139:0x03b0, B:140:0x03b3, B:9:0x0023, B:136:0x0391, B:12:0x002e, B:131:0x0378, B:133:0x037e, B:15:0x0041, B:124:0x0342, B:127:0x0352, B:18:0x004c, B:119:0x0327, B:121:0x032d, B:22:0x005c, B:105:0x02b7, B:107:0x02bd, B:108:0x02ca, B:25:0x0074, B:99:0x0297, B:101:0x029d, B:109:0x02cb, B:111:0x02d6, B:113:0x02e0, B:115:0x02e6, B:116:0x0303, B:125:0x034c, B:141:0x03ba, B:142:0x03c5, B:28:0x008d, B:96:0x0273, B:29:0x0092, B:92:0x0257, B:32:0x00ab, B:87:0x022f, B:89:0x0235, B:93:0x025c, B:35:0x00c4, B:82:0x0202, B:84:0x020c, B:38:0x00d5, B:77:0x01e6, B:79:0x01ec, B:41:0x00e5, B:70:0x01b7, B:72:0x01bd, B:73:0x01ca, B:44:0x00fb, B:64:0x019a, B:66:0x01a0, B:74:0x01cb, B:47:0x010e, B:55:0x0150, B:57:0x0156, B:58:0x0170, B:61:0x017c, B:51:0x0123), top: B:155:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:135:0x0390 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:138:0x03af A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:141:0x03ba A[Catch: all -> 0x03c6, CancellationException -> 0x03f3, TryCatch #2 {CancellationException -> 0x03f3, all -> 0x03c6, blocks: (B:6:0x0012, B:139:0x03b0, B:140:0x03b3, B:9:0x0023, B:136:0x0391, B:12:0x002e, B:131:0x0378, B:133:0x037e, B:15:0x0041, B:124:0x0342, B:127:0x0352, B:18:0x004c, B:119:0x0327, B:121:0x032d, B:22:0x005c, B:105:0x02b7, B:107:0x02bd, B:108:0x02ca, B:25:0x0074, B:99:0x0297, B:101:0x029d, B:109:0x02cb, B:111:0x02d6, B:113:0x02e0, B:115:0x02e6, B:116:0x0303, B:125:0x034c, B:141:0x03ba, B:142:0x03c5, B:28:0x008d, B:96:0x0273, B:29:0x0092, B:92:0x0257, B:32:0x00ab, B:87:0x022f, B:89:0x0235, B:93:0x025c, B:35:0x00c4, B:82:0x0202, B:84:0x020c, B:38:0x00d5, B:77:0x01e6, B:79:0x01ec, B:41:0x00e5, B:70:0x01b7, B:72:0x01bd, B:73:0x01ca, B:44:0x00fb, B:64:0x019a, B:66:0x01a0, B:74:0x01cb, B:47:0x010e, B:55:0x0150, B:57:0x0156, B:58:0x0170, B:61:0x017c, B:51:0x0123), top: B:155:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:147:0x03d7  */
    /* JADX WARN: Code duplicated, block: B:148:0x03de  */
    /* JADX WARN: Code duplicated, block: B:150:0x03e4  */
    /* JADX WARN: Code duplicated, block: B:156:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:157:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x0156 A[Catch: all -> 0x03c6, CancellationException -> 0x03f3, TryCatch #2 {CancellationException -> 0x03f3, all -> 0x03c6, blocks: (B:6:0x0012, B:139:0x03b0, B:140:0x03b3, B:9:0x0023, B:136:0x0391, B:12:0x002e, B:131:0x0378, B:133:0x037e, B:15:0x0041, B:124:0x0342, B:127:0x0352, B:18:0x004c, B:119:0x0327, B:121:0x032d, B:22:0x005c, B:105:0x02b7, B:107:0x02bd, B:108:0x02ca, B:25:0x0074, B:99:0x0297, B:101:0x029d, B:109:0x02cb, B:111:0x02d6, B:113:0x02e0, B:115:0x02e6, B:116:0x0303, B:125:0x034c, B:141:0x03ba, B:142:0x03c5, B:28:0x008d, B:96:0x0273, B:29:0x0092, B:92:0x0257, B:32:0x00ab, B:87:0x022f, B:89:0x0235, B:93:0x025c, B:35:0x00c4, B:82:0x0202, B:84:0x020c, B:38:0x00d5, B:77:0x01e6, B:79:0x01ec, B:41:0x00e5, B:70:0x01b7, B:72:0x01bd, B:73:0x01ca, B:44:0x00fb, B:64:0x019a, B:66:0x01a0, B:74:0x01cb, B:47:0x010e, B:55:0x0150, B:57:0x0156, B:58:0x0170, B:61:0x017c, B:51:0x0123), top: B:155:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x017b  */
    /* JADX WARN: Code duplicated, block: B:63:0x0199 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:66:0x01a0 A[Catch: all -> 0x03c6, CancellationException -> 0x03f3, TryCatch #2 {CancellationException -> 0x03f3, all -> 0x03c6, blocks: (B:6:0x0012, B:139:0x03b0, B:140:0x03b3, B:9:0x0023, B:136:0x0391, B:12:0x002e, B:131:0x0378, B:133:0x037e, B:15:0x0041, B:124:0x0342, B:127:0x0352, B:18:0x004c, B:119:0x0327, B:121:0x032d, B:22:0x005c, B:105:0x02b7, B:107:0x02bd, B:108:0x02ca, B:25:0x0074, B:99:0x0297, B:101:0x029d, B:109:0x02cb, B:111:0x02d6, B:113:0x02e0, B:115:0x02e6, B:116:0x0303, B:125:0x034c, B:141:0x03ba, B:142:0x03c5, B:28:0x008d, B:96:0x0273, B:29:0x0092, B:92:0x0257, B:32:0x00ab, B:87:0x022f, B:89:0x0235, B:93:0x025c, B:35:0x00c4, B:82:0x0202, B:84:0x020c, B:38:0x00d5, B:77:0x01e6, B:79:0x01ec, B:41:0x00e5, B:70:0x01b7, B:72:0x01bd, B:73:0x01ca, B:44:0x00fb, B:64:0x019a, B:66:0x01a0, B:74:0x01cb, B:47:0x010e, B:55:0x0150, B:57:0x0156, B:58:0x0170, B:61:0x017c, B:51:0x0123), top: B:155:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x01b5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:69:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:72:0x01bd A[Catch: all -> 0x03c6, CancellationException -> 0x03f3, TryCatch #2 {CancellationException -> 0x03f3, all -> 0x03c6, blocks: (B:6:0x0012, B:139:0x03b0, B:140:0x03b3, B:9:0x0023, B:136:0x0391, B:12:0x002e, B:131:0x0378, B:133:0x037e, B:15:0x0041, B:124:0x0342, B:127:0x0352, B:18:0x004c, B:119:0x0327, B:121:0x032d, B:22:0x005c, B:105:0x02b7, B:107:0x02bd, B:108:0x02ca, B:25:0x0074, B:99:0x0297, B:101:0x029d, B:109:0x02cb, B:111:0x02d6, B:113:0x02e0, B:115:0x02e6, B:116:0x0303, B:125:0x034c, B:141:0x03ba, B:142:0x03c5, B:28:0x008d, B:96:0x0273, B:29:0x0092, B:92:0x0257, B:32:0x00ab, B:87:0x022f, B:89:0x0235, B:93:0x025c, B:35:0x00c4, B:82:0x0202, B:84:0x020c, B:38:0x00d5, B:77:0x01e6, B:79:0x01ec, B:41:0x00e5, B:70:0x01b7, B:72:0x01bd, B:73:0x01ca, B:44:0x00fb, B:64:0x019a, B:66:0x01a0, B:74:0x01cb, B:47:0x010e, B:55:0x0150, B:57:0x0156, B:58:0x0170, B:61:0x017c, B:51:0x0123), top: B:155:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x01cb A[Catch: all -> 0x03c6, CancellationException -> 0x03f3, TryCatch #2 {CancellationException -> 0x03f3, all -> 0x03c6, blocks: (B:6:0x0012, B:139:0x03b0, B:140:0x03b3, B:9:0x0023, B:136:0x0391, B:12:0x002e, B:131:0x0378, B:133:0x037e, B:15:0x0041, B:124:0x0342, B:127:0x0352, B:18:0x004c, B:119:0x0327, B:121:0x032d, B:22:0x005c, B:105:0x02b7, B:107:0x02bd, B:108:0x02ca, B:25:0x0074, B:99:0x0297, B:101:0x029d, B:109:0x02cb, B:111:0x02d6, B:113:0x02e0, B:115:0x02e6, B:116:0x0303, B:125:0x034c, B:141:0x03ba, B:142:0x03c5, B:28:0x008d, B:96:0x0273, B:29:0x0092, B:92:0x0257, B:32:0x00ab, B:87:0x022f, B:89:0x0235, B:93:0x025c, B:35:0x00c4, B:82:0x0202, B:84:0x020c, B:38:0x00d5, B:77:0x01e6, B:79:0x01ec, B:41:0x00e5, B:70:0x01b7, B:72:0x01bd, B:73:0x01ca, B:44:0x00fb, B:64:0x019a, B:66:0x01a0, B:74:0x01cb, B:47:0x010e, B:55:0x0150, B:57:0x0156, B:58:0x0170, B:61:0x017c, B:51:0x0123), top: B:155:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x01e5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:79:0x01ec A[Catch: all -> 0x03c6, CancellationException -> 0x03f3, TryCatch #2 {CancellationException -> 0x03f3, all -> 0x03c6, blocks: (B:6:0x0012, B:139:0x03b0, B:140:0x03b3, B:9:0x0023, B:136:0x0391, B:12:0x002e, B:131:0x0378, B:133:0x037e, B:15:0x0041, B:124:0x0342, B:127:0x0352, B:18:0x004c, B:119:0x0327, B:121:0x032d, B:22:0x005c, B:105:0x02b7, B:107:0x02bd, B:108:0x02ca, B:25:0x0074, B:99:0x0297, B:101:0x029d, B:109:0x02cb, B:111:0x02d6, B:113:0x02e0, B:115:0x02e6, B:116:0x0303, B:125:0x034c, B:141:0x03ba, B:142:0x03c5, B:28:0x008d, B:96:0x0273, B:29:0x0092, B:92:0x0257, B:32:0x00ab, B:87:0x022f, B:89:0x0235, B:93:0x025c, B:35:0x00c4, B:82:0x0202, B:84:0x020c, B:38:0x00d5, B:77:0x01e6, B:79:0x01ec, B:41:0x00e5, B:70:0x01b7, B:72:0x01bd, B:73:0x01ca, B:44:0x00fb, B:64:0x019a, B:66:0x01a0, B:74:0x01cb, B:47:0x010e, B:55:0x0150, B:57:0x0156, B:58:0x0170, B:61:0x017c, B:51:0x0123), top: B:155:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:81:0x0201 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:84:0x020c A[Catch: all -> 0x03c6, CancellationException -> 0x03f3, TryCatch #2 {CancellationException -> 0x03f3, all -> 0x03c6, blocks: (B:6:0x0012, B:139:0x03b0, B:140:0x03b3, B:9:0x0023, B:136:0x0391, B:12:0x002e, B:131:0x0378, B:133:0x037e, B:15:0x0041, B:124:0x0342, B:127:0x0352, B:18:0x004c, B:119:0x0327, B:121:0x032d, B:22:0x005c, B:105:0x02b7, B:107:0x02bd, B:108:0x02ca, B:25:0x0074, B:99:0x0297, B:101:0x029d, B:109:0x02cb, B:111:0x02d6, B:113:0x02e0, B:115:0x02e6, B:116:0x0303, B:125:0x034c, B:141:0x03ba, B:142:0x03c5, B:28:0x008d, B:96:0x0273, B:29:0x0092, B:92:0x0257, B:32:0x00ab, B:87:0x022f, B:89:0x0235, B:93:0x025c, B:35:0x00c4, B:82:0x0202, B:84:0x020c, B:38:0x00d5, B:77:0x01e6, B:79:0x01ec, B:41:0x00e5, B:70:0x01b7, B:72:0x01bd, B:73:0x01ca, B:44:0x00fb, B:64:0x019a, B:66:0x01a0, B:74:0x01cb, B:47:0x010e, B:55:0x0150, B:57:0x0156, B:58:0x0170, B:61:0x017c, B:51:0x0123), top: B:155:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x022e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:89:0x0235 A[Catch: all -> 0x03c6, CancellationException -> 0x03f3, TryCatch #2 {CancellationException -> 0x03f3, all -> 0x03c6, blocks: (B:6:0x0012, B:139:0x03b0, B:140:0x03b3, B:9:0x0023, B:136:0x0391, B:12:0x002e, B:131:0x0378, B:133:0x037e, B:15:0x0041, B:124:0x0342, B:127:0x0352, B:18:0x004c, B:119:0x0327, B:121:0x032d, B:22:0x005c, B:105:0x02b7, B:107:0x02bd, B:108:0x02ca, B:25:0x0074, B:99:0x0297, B:101:0x029d, B:109:0x02cb, B:111:0x02d6, B:113:0x02e0, B:115:0x02e6, B:116:0x0303, B:125:0x034c, B:141:0x03ba, B:142:0x03c5, B:28:0x008d, B:96:0x0273, B:29:0x0092, B:92:0x0257, B:32:0x00ab, B:87:0x022f, B:89:0x0235, B:93:0x025c, B:35:0x00c4, B:82:0x0202, B:84:0x020c, B:38:0x00d5, B:77:0x01e6, B:79:0x01ec, B:41:0x00e5, B:70:0x01b7, B:72:0x01bd, B:73:0x01ca, B:44:0x00fb, B:64:0x019a, B:66:0x01a0, B:74:0x01cb, B:47:0x010e, B:55:0x0150, B:57:0x0156, B:58:0x0170, B:61:0x017c, B:51:0x0123), top: B:155:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x0256 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:93:0x025c A[Catch: all -> 0x03c6, CancellationException -> 0x03f3, TryCatch #2 {CancellationException -> 0x03f3, all -> 0x03c6, blocks: (B:6:0x0012, B:139:0x03b0, B:140:0x03b3, B:9:0x0023, B:136:0x0391, B:12:0x002e, B:131:0x0378, B:133:0x037e, B:15:0x0041, B:124:0x0342, B:127:0x0352, B:18:0x004c, B:119:0x0327, B:121:0x032d, B:22:0x005c, B:105:0x02b7, B:107:0x02bd, B:108:0x02ca, B:25:0x0074, B:99:0x0297, B:101:0x029d, B:109:0x02cb, B:111:0x02d6, B:113:0x02e0, B:115:0x02e6, B:116:0x0303, B:125:0x034c, B:141:0x03ba, B:142:0x03c5, B:28:0x008d, B:96:0x0273, B:29:0x0092, B:92:0x0257, B:32:0x00ab, B:87:0x022f, B:89:0x0235, B:93:0x025c, B:35:0x00c4, B:82:0x0202, B:84:0x020c, B:38:0x00d5, B:77:0x01e6, B:79:0x01ec, B:41:0x00e5, B:70:0x01b7, B:72:0x01bd, B:73:0x01ca, B:44:0x00fb, B:64:0x019a, B:66:0x01a0, B:74:0x01cb, B:47:0x010e, B:55:0x0150, B:57:0x0156, B:58:0x0170, B:61:0x017c, B:51:0x0123), top: B:155:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x0272 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:98:0x0296 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM514constructorimpl;
        Throwable thM517exceptionOrNullimpl;
        InitializeSDK initializeSDK;
        CoroutineScope coroutineScope;
        Object value;
        InitializeSDK initializeSDK2;
        Throwable thM517exceptionOrNullimpl2;
        Configuration configuration;
        Configuration configuration2;
        Object value2;
        Object value3;
        ErrorState errorState;
        Throwable thM517exceptionOrNullimpl3;
        Object obj2;
        Throwable thM517exceptionOrNullimpl4;
        CoroutineScope coroutineScope2;
        InitializeSDK initializeSDK3;
        Object obj3;
        InitializationException initializationExceptionOrThrow;
        Object value4;
        InitializationException initializationExceptionOrThrow2;
        Object value5;
        Object value6;
        InitializeStateLoadCache.LoadCacheResult loadCacheResult;
        String webViewData;
        Object value7;
        ErrorState errorState2;
        Throwable thM517exceptionOrNullimpl5;
        Object obj4;
        Throwable thM517exceptionOrNullimpl6;
        Object obj5;
        InitializationException initializationExceptionOrThrow3;
        Object value8;
        Object obj6;
        InitializeSDK initializeSDK4;
        InitializationException initializationExceptionOrThrow4;
        Object value9;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
                    initializeSDK = this.this$0;
                    Result.Companion companion = Result.INSTANCE;
                    InitializeEventsMetricSender.getInstance().didInitStart();
                    CachedLifecycle.register();
                    DeviceLog.debug("Unity Ads Init: Loading Config File From Local Storage");
                    ConfigFileFromLocalStorage configFileFromLocalStorage = initializeSDK.configFileFromLocalStorage;
                    ConfigFileFromLocalStorage.Params params = new ConfigFileFromLocalStorage.Params();
                    this.L$0 = coroutineScope3;
                    this.L$1 = initializeSDK;
                    this.label = 1;
                    Object obj7 = configFileFromLocalStorage.mo489invokegIAlus(params, this);
                    if (obj7 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    coroutineScope = coroutineScope3;
                    value = obj7;
                    initializeSDK2 = initializeSDK;
                    thM517exceptionOrNullimpl2 = Result.m517exceptionOrNullimpl(value);
                    if (thM517exceptionOrNullimpl2 != null) {
                        DeviceLog.debug("Unity Ads Init: Could not load config file from local storage: " + thM517exceptionOrNullimpl2.getMessage());
                    }
                    configuration = new Configuration();
                    if (Result.m520isFailureimpl(value)) {
                        value = configuration;
                    }
                    configuration2 = (Configuration) value;
                    InitializeStateReset initializeStateReset = initializeSDK2.initializeStateReset;
                    InitializeStateReset.Params params2 = new InitializeStateReset.Params(configuration2);
                    this.L$0 = coroutineScope;
                    this.L$1 = initializeSDK2;
                    this.L$2 = configuration2;
                    this.label = 2;
                    value2 = initializeStateReset.mo489invokegIAlus(params2, this);
                    if (value2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (!Result.m520isFailureimpl(value2)) {
                        InitializeStateConfig initializeStateConfig = initializeSDK2.initializeStateConfig;
                        InitializeStateConfig.Params params3 = new InitializeStateConfig.Params(configuration2);
                        this.L$0 = coroutineScope;
                        this.L$1 = initializeSDK2;
                        this.L$2 = configuration2;
                        this.label = 4;
                        value3 = initializeStateConfig.mo489invokegIAlus(params3, this);
                        if (value3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        coroutineScope2 = coroutineScope;
                        initializeSDK3 = initializeSDK2;
                        obj3 = value3;
                        if (Result.m520isFailureimpl(obj3)) {
                            initializationExceptionOrThrow = ResultExtensionsKt.getInitializationExceptionOrThrow(obj3);
                            this.L$0 = coroutineScope2;
                            this.L$1 = initializeSDK3;
                            this.L$2 = obj3;
                            this.L$3 = configuration2;
                            this.label = 5;
                            if (initializeSDK3.handleInitializationException(initializationExceptionOrThrow, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        if (configuration2.getExperiments().isNativeWebViewCacheEnabled()) {
                            InitializeStateCreateWithRemote initializeStateCreateWithRemote = initializeSDK3.initializeStateCreateWithRemote;
                            ResultKt.throwOnFailure(obj3);
                            InitializeStateCreateWithRemote.Params params4 = new InitializeStateCreateWithRemote.Params((Configuration) obj3);
                            this.L$0 = coroutineScope2;
                            this.L$1 = initializeSDK3;
                            this.L$2 = obj3;
                            this.L$3 = configuration2;
                            this.label = 6;
                            value4 = initializeStateCreateWithRemote.mo489invokegIAlus(params4, this);
                            if (value4 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            if (Result.m521isSuccessimpl(value4)) {
                                InitializeStateComplete initializeStateComplete = initializeSDK3.initializeStateComplete;
                                ResultKt.throwOnFailure(obj3);
                                InitializeStateComplete.Params params5 = new InitializeStateComplete.Params((Configuration) obj3);
                                this.L$0 = null;
                                this.L$1 = null;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.label = 7;
                                value5 = initializeStateComplete.mo489invokegIAlus(params5, this);
                                if (value5 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                ResultKt.throwOnFailure(value5);
                                objM514constructorimpl = Result.m514constructorimpl(Unit.INSTANCE);
                                if (Result.m521isSuccessimpl(objM514constructorimpl)) {
                                    Result.Companion companion2 = Result.INSTANCE;
                                    objM514constructorimpl = Result.m514constructorimpl(objM514constructorimpl);
                                } else {
                                    thM517exceptionOrNullimpl = Result.m517exceptionOrNullimpl(objM514constructorimpl);
                                    if (thM517exceptionOrNullimpl != null) {
                                        Result.Companion companion3 = Result.INSTANCE;
                                        objM514constructorimpl = Result.m514constructorimpl(ResultKt.createFailure(thM517exceptionOrNullimpl));
                                    }
                                }
                                return Result.m513boximpl(objM514constructorimpl);
                            }
                            initializationExceptionOrThrow2 = ResultExtensionsKt.getInitializationExceptionOrThrow(value4);
                            this.L$0 = coroutineScope2;
                            this.L$1 = initializeSDK3;
                            this.L$2 = obj3;
                            this.L$3 = configuration2;
                            this.label = 8;
                            if (initializeSDK3.handleInitializationException(initializationExceptionOrThrow2, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        InitializeStateLoadCache initializeStateLoadCache = initializeSDK3.initializeStateLoadCache;
                        ResultKt.throwOnFailure(obj3);
                        InitializeStateLoadCache.Params params6 = new InitializeStateLoadCache.Params((Configuration) obj3);
                        this.L$0 = coroutineScope2;
                        this.L$1 = initializeSDK3;
                        this.L$2 = obj3;
                        this.L$3 = configuration2;
                        this.label = 9;
                        value6 = initializeStateLoadCache.mo489invokegIAlus(params6, this);
                        if (value6 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (Result.m520isFailureimpl(value6)) {
                            errorState2 = ErrorState.LoadCache;
                            thM517exceptionOrNullimpl5 = Result.m517exceptionOrNullimpl(value6);
                            this.L$0 = value6;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.label = 10;
                            if (initializeSDK3.m493executeErrorStateBWLJW6A(errorState2, thM517exceptionOrNullimpl5, configuration2, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj4 = value6;
                            thM517exceptionOrNullimpl6 = Result.m517exceptionOrNullimpl(obj4);
                            if (thM517exceptionOrNullimpl6 == null) {
                                throw new Exception(ErrorState.LoadCache.toString());
                            }
                            throw thM517exceptionOrNullimpl6;
                        }
                        ResultKt.throwOnFailure(value6);
                        loadCacheResult = (InitializeStateLoadCache.LoadCacheResult) value6;
                        if (loadCacheResult.getHasHashMismatch()) {
                            if (!configuration2.getExperiments().isWebViewAsyncDownloadEnabled() && loadCacheResult.getWebViewData() != null) {
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope2, new CoroutineName("LaunchLoadWeb"), null, new InitializeSDK$doWork$2$1$webViewData$1(initializeSDK3, obj3, null), 2, null);
                                webViewData = loadCacheResult.getWebViewData();
                            } else {
                                InitializeStateLoadWeb initializeStateLoadWeb = initializeSDK3.initializeStateLoadWeb;
                                ResultKt.throwOnFailure(obj3);
                                InitializeStateLoadWeb.Params params7 = new InitializeStateLoadWeb.Params((Configuration) obj3);
                                this.L$0 = initializeSDK3;
                                this.L$1 = obj3;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.label = 11;
                                value7 = initializeStateLoadWeb.mo489invokegIAlus(params7, this);
                                if (value7 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                obj5 = value7;
                                if (Result.m520isFailureimpl(obj5)) {
                                    initializationExceptionOrThrow3 = ResultExtensionsKt.getInitializationExceptionOrThrow(obj5);
                                    this.L$0 = initializeSDK3;
                                    this.L$1 = obj3;
                                    this.L$2 = obj5;
                                    this.label = 12;
                                    if (initializeSDK3.handleInitializationException(initializationExceptionOrThrow3, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                                ResultKt.throwOnFailure(obj5);
                                webViewData = ((InitializeStateLoadWeb.LoadWebResult) obj5).getWebViewDataString();
                            }
                        } else {
                            webViewData = loadCacheResult.getWebViewData();
                            if (webViewData == null) {
                                throw new IllegalStateException("WebView is missing.".toString());
                            }
                        }
                        InitializeStateCreate initializeStateCreate = initializeSDK3.initializeStateCreate;
                        ResultKt.throwOnFailure(obj3);
                        InitializeStateCreate.Params params8 = new InitializeStateCreate.Params((Configuration) obj3, webViewData);
                        this.L$0 = initializeSDK3;
                        this.L$1 = obj3;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 13;
                        value8 = initializeStateCreate.mo489invokegIAlus(params8, this);
                        if (value8 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj6 = obj3;
                        initializeSDK4 = initializeSDK3;
                        if (Result.m520isFailureimpl(value8)) {
                            initializationExceptionOrThrow4 = ResultExtensionsKt.getInitializationExceptionOrThrow(value8);
                            this.L$0 = initializeSDK4;
                            this.L$1 = obj6;
                            this.label = 14;
                            if (initializeSDK4.handleInitializationException(initializationExceptionOrThrow4, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        InitializeStateComplete initializeStateComplete2 = initializeSDK4.initializeStateComplete;
                        ResultKt.throwOnFailure(obj6);
                        InitializeStateComplete.Params params9 = new InitializeStateComplete.Params((Configuration) obj6);
                        this.L$0 = null;
                        this.L$1 = null;
                        this.label = 15;
                        value9 = initializeStateComplete2.mo489invokegIAlus(params9, this);
                        if (value9 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        ResultKt.throwOnFailure(value9);
                        objM514constructorimpl = Result.m514constructorimpl(Unit.INSTANCE);
                        if (Result.m521isSuccessimpl(objM514constructorimpl)) {
                            Result.Companion companion4 = Result.INSTANCE;
                            objM514constructorimpl = Result.m514constructorimpl(objM514constructorimpl);
                        } else {
                            thM517exceptionOrNullimpl = Result.m517exceptionOrNullimpl(objM514constructorimpl);
                            if (thM517exceptionOrNullimpl != null) {
                                Result.Companion companion5 = Result.INSTANCE;
                                objM514constructorimpl = Result.m514constructorimpl(ResultKt.createFailure(thM517exceptionOrNullimpl));
                            }
                        }
                        return Result.m513boximpl(objM514constructorimpl);
                    }
                    errorState = ErrorState.ResetWebApp;
                    thM517exceptionOrNullimpl3 = Result.m517exceptionOrNullimpl(value2);
                    this.L$0 = value2;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 3;
                    if (initializeSDK2.m493executeErrorStateBWLJW6A(errorState, thM517exceptionOrNullimpl3, configuration2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj2 = value2;
                    thM517exceptionOrNullimpl4 = Result.m517exceptionOrNullimpl(obj2);
                    if (thM517exceptionOrNullimpl4 == null) {
                        throw new Exception(ErrorState.ResetWebApp.toString());
                    }
                    throw thM517exceptionOrNullimpl4;
                case 1:
                    initializeSDK = (InitializeSDK) this.L$1;
                    CoroutineScope coroutineScope4 = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    value = ((Result) obj).getValue();
                    coroutineScope = coroutineScope4;
                    initializeSDK2 = initializeSDK;
                    thM517exceptionOrNullimpl2 = Result.m517exceptionOrNullimpl(value);
                    if (thM517exceptionOrNullimpl2 != null) {
                        DeviceLog.debug("Unity Ads Init: Could not load config file from local storage: " + thM517exceptionOrNullimpl2.getMessage());
                    }
                    configuration = new Configuration();
                    if (Result.m520isFailureimpl(value)) {
                        value = configuration;
                    }
                    configuration2 = (Configuration) value;
                    InitializeStateReset initializeStateReset2 = initializeSDK2.initializeStateReset;
                    InitializeStateReset.Params params10 = new InitializeStateReset.Params(configuration2);
                    this.L$0 = coroutineScope;
                    this.L$1 = initializeSDK2;
                    this.L$2 = configuration2;
                    this.label = 2;
                    value2 = initializeStateReset2.mo489invokegIAlus(params10, this);
                    if (value2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (!Result.m520isFailureimpl(value2)) {
                        InitializeStateConfig initializeStateConfig2 = initializeSDK2.initializeStateConfig;
                        InitializeStateConfig.Params params11 = new InitializeStateConfig.Params(configuration2);
                        this.L$0 = coroutineScope;
                        this.L$1 = initializeSDK2;
                        this.L$2 = configuration2;
                        this.label = 4;
                        value3 = initializeStateConfig2.mo489invokegIAlus(params11, this);
                        if (value3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        coroutineScope2 = coroutineScope;
                        initializeSDK3 = initializeSDK2;
                        obj3 = value3;
                        if (Result.m520isFailureimpl(obj3)) {
                            initializationExceptionOrThrow = ResultExtensionsKt.getInitializationExceptionOrThrow(obj3);
                            this.L$0 = coroutineScope2;
                            this.L$1 = initializeSDK3;
                            this.L$2 = obj3;
                            this.L$3 = configuration2;
                            this.label = 5;
                            if (initializeSDK3.handleInitializationException(initializationExceptionOrThrow, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        if (configuration2.getExperiments().isNativeWebViewCacheEnabled()) {
                            InitializeStateCreateWithRemote initializeStateCreateWithRemote2 = initializeSDK3.initializeStateCreateWithRemote;
                            ResultKt.throwOnFailure(obj3);
                            InitializeStateCreateWithRemote.Params params12 = new InitializeStateCreateWithRemote.Params((Configuration) obj3);
                            this.L$0 = coroutineScope2;
                            this.L$1 = initializeSDK3;
                            this.L$2 = obj3;
                            this.L$3 = configuration2;
                            this.label = 6;
                            value4 = initializeStateCreateWithRemote2.mo489invokegIAlus(params12, this);
                            if (value4 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            if (Result.m521isSuccessimpl(value4)) {
                                InitializeStateComplete initializeStateComplete3 = initializeSDK3.initializeStateComplete;
                                ResultKt.throwOnFailure(obj3);
                                InitializeStateComplete.Params params13 = new InitializeStateComplete.Params((Configuration) obj3);
                                this.L$0 = null;
                                this.L$1 = null;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.label = 7;
                                value5 = initializeStateComplete3.mo489invokegIAlus(params13, this);
                                if (value5 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                ResultKt.throwOnFailure(value5);
                                objM514constructorimpl = Result.m514constructorimpl(Unit.INSTANCE);
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
                            initializationExceptionOrThrow2 = ResultExtensionsKt.getInitializationExceptionOrThrow(value4);
                            this.L$0 = coroutineScope2;
                            this.L$1 = initializeSDK3;
                            this.L$2 = obj3;
                            this.L$3 = configuration2;
                            this.label = 8;
                            if (initializeSDK3.handleInitializationException(initializationExceptionOrThrow2, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        InitializeStateLoadCache initializeStateLoadCache2 = initializeSDK3.initializeStateLoadCache;
                        ResultKt.throwOnFailure(obj3);
                        InitializeStateLoadCache.Params params14 = new InitializeStateLoadCache.Params((Configuration) obj3);
                        this.L$0 = coroutineScope2;
                        this.L$1 = initializeSDK3;
                        this.L$2 = obj3;
                        this.L$3 = configuration2;
                        this.label = 9;
                        value6 = initializeStateLoadCache2.mo489invokegIAlus(params14, this);
                        if (value6 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (Result.m520isFailureimpl(value6)) {
                            errorState2 = ErrorState.LoadCache;
                            thM517exceptionOrNullimpl5 = Result.m517exceptionOrNullimpl(value6);
                            this.L$0 = value6;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.label = 10;
                            if (initializeSDK3.m493executeErrorStateBWLJW6A(errorState2, thM517exceptionOrNullimpl5, configuration2, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj4 = value6;
                            thM517exceptionOrNullimpl6 = Result.m517exceptionOrNullimpl(obj4);
                            if (thM517exceptionOrNullimpl6 == null) {
                                throw new Exception(ErrorState.LoadCache.toString());
                            }
                            throw thM517exceptionOrNullimpl6;
                        }
                        ResultKt.throwOnFailure(value6);
                        loadCacheResult = (InitializeStateLoadCache.LoadCacheResult) value6;
                        if (loadCacheResult.getHasHashMismatch()) {
                            if (!configuration2.getExperiments().isWebViewAsyncDownloadEnabled()) {
                            }
                            InitializeStateLoadWeb initializeStateLoadWeb2 = initializeSDK3.initializeStateLoadWeb;
                            ResultKt.throwOnFailure(obj3);
                            InitializeStateLoadWeb.Params params15 = new InitializeStateLoadWeb.Params((Configuration) obj3);
                            this.L$0 = initializeSDK3;
                            this.L$1 = obj3;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.label = 11;
                            value7 = initializeStateLoadWeb2.mo489invokegIAlus(params15, this);
                            if (value7 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj5 = value7;
                            if (Result.m520isFailureimpl(obj5)) {
                                initializationExceptionOrThrow3 = ResultExtensionsKt.getInitializationExceptionOrThrow(obj5);
                                this.L$0 = initializeSDK3;
                                this.L$1 = obj3;
                                this.L$2 = obj5;
                                this.label = 12;
                                if (initializeSDK3.handleInitializationException(initializationExceptionOrThrow3, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            ResultKt.throwOnFailure(obj5);
                            webViewData = ((InitializeStateLoadWeb.LoadWebResult) obj5).getWebViewDataString();
                            break;
                        } else {
                            webViewData = loadCacheResult.getWebViewData();
                            if (webViewData == null) {
                                throw new IllegalStateException("WebView is missing.".toString());
                            }
                        }
                        InitializeStateCreate initializeStateCreate2 = initializeSDK3.initializeStateCreate;
                        ResultKt.throwOnFailure(obj3);
                        InitializeStateCreate.Params params16 = new InitializeStateCreate.Params((Configuration) obj3, webViewData);
                        this.L$0 = initializeSDK3;
                        this.L$1 = obj3;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 13;
                        value8 = initializeStateCreate2.mo489invokegIAlus(params16, this);
                        if (value8 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj6 = obj3;
                        initializeSDK4 = initializeSDK3;
                        if (Result.m520isFailureimpl(value8)) {
                            initializationExceptionOrThrow4 = ResultExtensionsKt.getInitializationExceptionOrThrow(value8);
                            this.L$0 = initializeSDK4;
                            this.L$1 = obj6;
                            this.label = 14;
                            if (initializeSDK4.handleInitializationException(initializationExceptionOrThrow4, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        InitializeStateComplete initializeStateComplete4 = initializeSDK4.initializeStateComplete;
                        ResultKt.throwOnFailure(obj6);
                        InitializeStateComplete.Params params17 = new InitializeStateComplete.Params((Configuration) obj6);
                        this.L$0 = null;
                        this.L$1 = null;
                        this.label = 15;
                        value9 = initializeStateComplete4.mo489invokegIAlus(params17, this);
                        if (value9 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        ResultKt.throwOnFailure(value9);
                        objM514constructorimpl = Result.m514constructorimpl(Unit.INSTANCE);
                        if (Result.m521isSuccessimpl(objM514constructorimpl)) {
                            Result.Companion companion8 = Result.INSTANCE;
                            objM514constructorimpl = Result.m514constructorimpl(objM514constructorimpl);
                        } else {
                            thM517exceptionOrNullimpl = Result.m517exceptionOrNullimpl(objM514constructorimpl);
                            if (thM517exceptionOrNullimpl != null) {
                                Result.Companion companion9 = Result.INSTANCE;
                                objM514constructorimpl = Result.m514constructorimpl(ResultKt.createFailure(thM517exceptionOrNullimpl));
                            }
                        }
                        return Result.m513boximpl(objM514constructorimpl);
                    }
                    errorState = ErrorState.ResetWebApp;
                    thM517exceptionOrNullimpl3 = Result.m517exceptionOrNullimpl(value2);
                    this.L$0 = value2;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 3;
                    if (initializeSDK2.m493executeErrorStateBWLJW6A(errorState, thM517exceptionOrNullimpl3, configuration2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj2 = value2;
                    thM517exceptionOrNullimpl4 = Result.m517exceptionOrNullimpl(obj2);
                    if (thM517exceptionOrNullimpl4 == null) {
                        throw new Exception(ErrorState.ResetWebApp.toString());
                    }
                    throw thM517exceptionOrNullimpl4;
                case 2:
                    configuration2 = (Configuration) this.L$2;
                    initializeSDK2 = (InitializeSDK) this.L$1;
                    coroutineScope = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    value2 = ((Result) obj).getValue();
                    if (!Result.m520isFailureimpl(value2)) {
                        InitializeStateConfig initializeStateConfig3 = initializeSDK2.initializeStateConfig;
                        InitializeStateConfig.Params params18 = new InitializeStateConfig.Params(configuration2);
                        this.L$0 = coroutineScope;
                        this.L$1 = initializeSDK2;
                        this.L$2 = configuration2;
                        this.label = 4;
                        value3 = initializeStateConfig3.mo489invokegIAlus(params18, this);
                        if (value3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        coroutineScope2 = coroutineScope;
                        initializeSDK3 = initializeSDK2;
                        obj3 = value3;
                        if (Result.m520isFailureimpl(obj3)) {
                            initializationExceptionOrThrow = ResultExtensionsKt.getInitializationExceptionOrThrow(obj3);
                            this.L$0 = coroutineScope2;
                            this.L$1 = initializeSDK3;
                            this.L$2 = obj3;
                            this.L$3 = configuration2;
                            this.label = 5;
                            if (initializeSDK3.handleInitializationException(initializationExceptionOrThrow, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        if (configuration2.getExperiments().isNativeWebViewCacheEnabled()) {
                            InitializeStateCreateWithRemote initializeStateCreateWithRemote3 = initializeSDK3.initializeStateCreateWithRemote;
                            ResultKt.throwOnFailure(obj3);
                            InitializeStateCreateWithRemote.Params params19 = new InitializeStateCreateWithRemote.Params((Configuration) obj3);
                            this.L$0 = coroutineScope2;
                            this.L$1 = initializeSDK3;
                            this.L$2 = obj3;
                            this.L$3 = configuration2;
                            this.label = 6;
                            value4 = initializeStateCreateWithRemote3.mo489invokegIAlus(params19, this);
                            if (value4 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            if (Result.m521isSuccessimpl(value4)) {
                                InitializeStateComplete initializeStateComplete5 = initializeSDK3.initializeStateComplete;
                                ResultKt.throwOnFailure(obj3);
                                InitializeStateComplete.Params params110 = new InitializeStateComplete.Params((Configuration) obj3);
                                this.L$0 = null;
                                this.L$1 = null;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.label = 7;
                                value5 = initializeStateComplete5.mo489invokegIAlus(params110, this);
                                if (value5 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                ResultKt.throwOnFailure(value5);
                                objM514constructorimpl = Result.m514constructorimpl(Unit.INSTANCE);
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
                            initializationExceptionOrThrow2 = ResultExtensionsKt.getInitializationExceptionOrThrow(value4);
                            this.L$0 = coroutineScope2;
                            this.L$1 = initializeSDK3;
                            this.L$2 = obj3;
                            this.L$3 = configuration2;
                            this.label = 8;
                            if (initializeSDK3.handleInitializationException(initializationExceptionOrThrow2, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        InitializeStateLoadCache initializeStateLoadCache3 = initializeSDK3.initializeStateLoadCache;
                        ResultKt.throwOnFailure(obj3);
                        InitializeStateLoadCache.Params params111 = new InitializeStateLoadCache.Params((Configuration) obj3);
                        this.L$0 = coroutineScope2;
                        this.L$1 = initializeSDK3;
                        this.L$2 = obj3;
                        this.L$3 = configuration2;
                        this.label = 9;
                        value6 = initializeStateLoadCache3.mo489invokegIAlus(params111, this);
                        if (value6 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (Result.m520isFailureimpl(value6)) {
                            errorState2 = ErrorState.LoadCache;
                            thM517exceptionOrNullimpl5 = Result.m517exceptionOrNullimpl(value6);
                            this.L$0 = value6;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.label = 10;
                            if (initializeSDK3.m493executeErrorStateBWLJW6A(errorState2, thM517exceptionOrNullimpl5, configuration2, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj4 = value6;
                            thM517exceptionOrNullimpl6 = Result.m517exceptionOrNullimpl(obj4);
                            if (thM517exceptionOrNullimpl6 == null) {
                                throw new Exception(ErrorState.LoadCache.toString());
                            }
                            throw thM517exceptionOrNullimpl6;
                        }
                        ResultKt.throwOnFailure(value6);
                        loadCacheResult = (InitializeStateLoadCache.LoadCacheResult) value6;
                        if (loadCacheResult.getHasHashMismatch()) {
                            if (!configuration2.getExperiments().isWebViewAsyncDownloadEnabled()) {
                            }
                            InitializeStateLoadWeb initializeStateLoadWeb3 = initializeSDK3.initializeStateLoadWeb;
                            ResultKt.throwOnFailure(obj3);
                            InitializeStateLoadWeb.Params params112 = new InitializeStateLoadWeb.Params((Configuration) obj3);
                            this.L$0 = initializeSDK3;
                            this.L$1 = obj3;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.label = 11;
                            value7 = initializeStateLoadWeb3.mo489invokegIAlus(params112, this);
                            if (value7 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj5 = value7;
                            if (Result.m520isFailureimpl(obj5)) {
                                initializationExceptionOrThrow3 = ResultExtensionsKt.getInitializationExceptionOrThrow(obj5);
                                this.L$0 = initializeSDK3;
                                this.L$1 = obj3;
                                this.L$2 = obj5;
                                this.label = 12;
                                if (initializeSDK3.handleInitializationException(initializationExceptionOrThrow3, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            ResultKt.throwOnFailure(obj5);
                            webViewData = ((InitializeStateLoadWeb.LoadWebResult) obj5).getWebViewDataString();
                            break;
                        } else {
                            webViewData = loadCacheResult.getWebViewData();
                            if (webViewData == null) {
                                throw new IllegalStateException("WebView is missing.".toString());
                            }
                        }
                        InitializeStateCreate initializeStateCreate3 = initializeSDK3.initializeStateCreate;
                        ResultKt.throwOnFailure(obj3);
                        InitializeStateCreate.Params params113 = new InitializeStateCreate.Params((Configuration) obj3, webViewData);
                        this.L$0 = initializeSDK3;
                        this.L$1 = obj3;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 13;
                        value8 = initializeStateCreate3.mo489invokegIAlus(params113, this);
                        if (value8 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj6 = obj3;
                        initializeSDK4 = initializeSDK3;
                        if (Result.m520isFailureimpl(value8)) {
                            initializationExceptionOrThrow4 = ResultExtensionsKt.getInitializationExceptionOrThrow(value8);
                            this.L$0 = initializeSDK4;
                            this.L$1 = obj6;
                            this.label = 14;
                            if (initializeSDK4.handleInitializationException(initializationExceptionOrThrow4, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        InitializeStateComplete initializeStateComplete6 = initializeSDK4.initializeStateComplete;
                        ResultKt.throwOnFailure(obj6);
                        InitializeStateComplete.Params params114 = new InitializeStateComplete.Params((Configuration) obj6);
                        this.L$0 = null;
                        this.L$1 = null;
                        this.label = 15;
                        value9 = initializeStateComplete6.mo489invokegIAlus(params114, this);
                        if (value9 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        ResultKt.throwOnFailure(value9);
                        objM514constructorimpl = Result.m514constructorimpl(Unit.INSTANCE);
                        if (Result.m521isSuccessimpl(objM514constructorimpl)) {
                            Result.Companion companion12 = Result.INSTANCE;
                            objM514constructorimpl = Result.m514constructorimpl(objM514constructorimpl);
                        } else {
                            thM517exceptionOrNullimpl = Result.m517exceptionOrNullimpl(objM514constructorimpl);
                            if (thM517exceptionOrNullimpl != null) {
                                Result.Companion companion13 = Result.INSTANCE;
                                objM514constructorimpl = Result.m514constructorimpl(ResultKt.createFailure(thM517exceptionOrNullimpl));
                            }
                        }
                        return Result.m513boximpl(objM514constructorimpl);
                    }
                    errorState = ErrorState.ResetWebApp;
                    thM517exceptionOrNullimpl3 = Result.m517exceptionOrNullimpl(value2);
                    this.L$0 = value2;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 3;
                    if (initializeSDK2.m493executeErrorStateBWLJW6A(errorState, thM517exceptionOrNullimpl3, configuration2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj2 = value2;
                    thM517exceptionOrNullimpl4 = Result.m517exceptionOrNullimpl(obj2);
                    if (thM517exceptionOrNullimpl4 == null) {
                        throw new Exception(ErrorState.ResetWebApp.toString());
                    }
                    throw thM517exceptionOrNullimpl4;
                case 3:
                    obj2 = this.L$0;
                    ResultKt.throwOnFailure(obj);
                    ((Result) obj).getValue();
                    thM517exceptionOrNullimpl4 = Result.m517exceptionOrNullimpl(obj2);
                    if (thM517exceptionOrNullimpl4 == null) {
                        throw new Exception(ErrorState.ResetWebApp.toString());
                    }
                    throw thM517exceptionOrNullimpl4;
                case 4:
                    configuration2 = (Configuration) this.L$2;
                    initializeSDK2 = (InitializeSDK) this.L$1;
                    coroutineScope = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    value3 = ((Result) obj).getValue();
                    coroutineScope2 = coroutineScope;
                    initializeSDK3 = initializeSDK2;
                    obj3 = value3;
                    if (Result.m520isFailureimpl(obj3)) {
                        initializationExceptionOrThrow = ResultExtensionsKt.getInitializationExceptionOrThrow(obj3);
                        this.L$0 = coroutineScope2;
                        this.L$1 = initializeSDK3;
                        this.L$2 = obj3;
                        this.L$3 = configuration2;
                        this.label = 5;
                        if (initializeSDK3.handleInitializationException(initializationExceptionOrThrow, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    if (configuration2.getExperiments().isNativeWebViewCacheEnabled()) {
                        InitializeStateCreateWithRemote initializeStateCreateWithRemote4 = initializeSDK3.initializeStateCreateWithRemote;
                        ResultKt.throwOnFailure(obj3);
                        InitializeStateCreateWithRemote.Params params115 = new InitializeStateCreateWithRemote.Params((Configuration) obj3);
                        this.L$0 = coroutineScope2;
                        this.L$1 = initializeSDK3;
                        this.L$2 = obj3;
                        this.L$3 = configuration2;
                        this.label = 6;
                        value4 = initializeStateCreateWithRemote4.mo489invokegIAlus(params115, this);
                        if (value4 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (Result.m521isSuccessimpl(value4)) {
                            InitializeStateComplete initializeStateComplete7 = initializeSDK3.initializeStateComplete;
                            ResultKt.throwOnFailure(obj3);
                            InitializeStateComplete.Params params116 = new InitializeStateComplete.Params((Configuration) obj3);
                            this.L$0 = null;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.label = 7;
                            value5 = initializeStateComplete7.mo489invokegIAlus(params116, this);
                            if (value5 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            ResultKt.throwOnFailure(value5);
                            objM514constructorimpl = Result.m514constructorimpl(Unit.INSTANCE);
                            if (Result.m521isSuccessimpl(objM514constructorimpl)) {
                                Result.Companion companion14 = Result.INSTANCE;
                                objM514constructorimpl = Result.m514constructorimpl(objM514constructorimpl);
                            } else {
                                thM517exceptionOrNullimpl = Result.m517exceptionOrNullimpl(objM514constructorimpl);
                                if (thM517exceptionOrNullimpl != null) {
                                    Result.Companion companion15 = Result.INSTANCE;
                                    objM514constructorimpl = Result.m514constructorimpl(ResultKt.createFailure(thM517exceptionOrNullimpl));
                                }
                            }
                            return Result.m513boximpl(objM514constructorimpl);
                        }
                        initializationExceptionOrThrow2 = ResultExtensionsKt.getInitializationExceptionOrThrow(value4);
                        this.L$0 = coroutineScope2;
                        this.L$1 = initializeSDK3;
                        this.L$2 = obj3;
                        this.L$3 = configuration2;
                        this.label = 8;
                        if (initializeSDK3.handleInitializationException(initializationExceptionOrThrow2, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    InitializeStateLoadCache initializeStateLoadCache4 = initializeSDK3.initializeStateLoadCache;
                    ResultKt.throwOnFailure(obj3);
                    InitializeStateLoadCache.Params params117 = new InitializeStateLoadCache.Params((Configuration) obj3);
                    this.L$0 = coroutineScope2;
                    this.L$1 = initializeSDK3;
                    this.L$2 = obj3;
                    this.L$3 = configuration2;
                    this.label = 9;
                    value6 = initializeStateLoadCache4.mo489invokegIAlus(params117, this);
                    if (value6 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (Result.m520isFailureimpl(value6)) {
                        errorState2 = ErrorState.LoadCache;
                        thM517exceptionOrNullimpl5 = Result.m517exceptionOrNullimpl(value6);
                        this.L$0 = value6;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 10;
                        if (initializeSDK3.m493executeErrorStateBWLJW6A(errorState2, thM517exceptionOrNullimpl5, configuration2, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj4 = value6;
                        thM517exceptionOrNullimpl6 = Result.m517exceptionOrNullimpl(obj4);
                        if (thM517exceptionOrNullimpl6 == null) {
                            throw new Exception(ErrorState.LoadCache.toString());
                        }
                        throw thM517exceptionOrNullimpl6;
                    }
                    ResultKt.throwOnFailure(value6);
                    loadCacheResult = (InitializeStateLoadCache.LoadCacheResult) value6;
                    if (loadCacheResult.getHasHashMismatch()) {
                        if (!configuration2.getExperiments().isWebViewAsyncDownloadEnabled()) {
                        }
                        InitializeStateLoadWeb initializeStateLoadWeb4 = initializeSDK3.initializeStateLoadWeb;
                        ResultKt.throwOnFailure(obj3);
                        InitializeStateLoadWeb.Params params118 = new InitializeStateLoadWeb.Params((Configuration) obj3);
                        this.L$0 = initializeSDK3;
                        this.L$1 = obj3;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 11;
                        value7 = initializeStateLoadWeb4.mo489invokegIAlus(params118, this);
                        if (value7 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj5 = value7;
                        if (Result.m520isFailureimpl(obj5)) {
                            initializationExceptionOrThrow3 = ResultExtensionsKt.getInitializationExceptionOrThrow(obj5);
                            this.L$0 = initializeSDK3;
                            this.L$1 = obj3;
                            this.L$2 = obj5;
                            this.label = 12;
                            if (initializeSDK3.handleInitializationException(initializationExceptionOrThrow3, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        ResultKt.throwOnFailure(obj5);
                        webViewData = ((InitializeStateLoadWeb.LoadWebResult) obj5).getWebViewDataString();
                        break;
                    } else {
                        webViewData = loadCacheResult.getWebViewData();
                        if (webViewData == null) {
                            throw new IllegalStateException("WebView is missing.".toString());
                        }
                    }
                    InitializeStateCreate initializeStateCreate4 = initializeSDK3.initializeStateCreate;
                    ResultKt.throwOnFailure(obj3);
                    InitializeStateCreate.Params params119 = new InitializeStateCreate.Params((Configuration) obj3, webViewData);
                    this.L$0 = initializeSDK3;
                    this.L$1 = obj3;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.label = 13;
                    value8 = initializeStateCreate4.mo489invokegIAlus(params119, this);
                    if (value8 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj6 = obj3;
                    initializeSDK4 = initializeSDK3;
                    if (Result.m520isFailureimpl(value8)) {
                        initializationExceptionOrThrow4 = ResultExtensionsKt.getInitializationExceptionOrThrow(value8);
                        this.L$0 = initializeSDK4;
                        this.L$1 = obj6;
                        this.label = 14;
                        if (initializeSDK4.handleInitializationException(initializationExceptionOrThrow4, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    InitializeStateComplete initializeStateComplete8 = initializeSDK4.initializeStateComplete;
                    ResultKt.throwOnFailure(obj6);
                    InitializeStateComplete.Params params1110 = new InitializeStateComplete.Params((Configuration) obj6);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 15;
                    value9 = initializeStateComplete8.mo489invokegIAlus(params1110, this);
                    if (value9 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ResultKt.throwOnFailure(value9);
                    objM514constructorimpl = Result.m514constructorimpl(Unit.INSTANCE);
                    if (Result.m521isSuccessimpl(objM514constructorimpl)) {
                        Result.Companion companion16 = Result.INSTANCE;
                        objM514constructorimpl = Result.m514constructorimpl(objM514constructorimpl);
                    } else {
                        thM517exceptionOrNullimpl = Result.m517exceptionOrNullimpl(objM514constructorimpl);
                        if (thM517exceptionOrNullimpl != null) {
                            Result.Companion companion17 = Result.INSTANCE;
                            objM514constructorimpl = Result.m514constructorimpl(ResultKt.createFailure(thM517exceptionOrNullimpl));
                        }
                    }
                    return Result.m513boximpl(objM514constructorimpl);
                case 5:
                    configuration2 = (Configuration) this.L$3;
                    obj3 = this.L$2;
                    initializeSDK3 = (InitializeSDK) this.L$1;
                    coroutineScope2 = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    if (configuration2.getExperiments().isNativeWebViewCacheEnabled()) {
                        InitializeStateCreateWithRemote initializeStateCreateWithRemote5 = initializeSDK3.initializeStateCreateWithRemote;
                        ResultKt.throwOnFailure(obj3);
                        InitializeStateCreateWithRemote.Params params1111 = new InitializeStateCreateWithRemote.Params((Configuration) obj3);
                        this.L$0 = coroutineScope2;
                        this.L$1 = initializeSDK3;
                        this.L$2 = obj3;
                        this.L$3 = configuration2;
                        this.label = 6;
                        value4 = initializeStateCreateWithRemote5.mo489invokegIAlus(params1111, this);
                        if (value4 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (Result.m521isSuccessimpl(value4)) {
                            InitializeStateComplete initializeStateComplete9 = initializeSDK3.initializeStateComplete;
                            ResultKt.throwOnFailure(obj3);
                            InitializeStateComplete.Params params1112 = new InitializeStateComplete.Params((Configuration) obj3);
                            this.L$0 = null;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.label = 7;
                            value5 = initializeStateComplete9.mo489invokegIAlus(params1112, this);
                            if (value5 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            ResultKt.throwOnFailure(value5);
                            objM514constructorimpl = Result.m514constructorimpl(Unit.INSTANCE);
                            if (Result.m521isSuccessimpl(objM514constructorimpl)) {
                                Result.Companion companion18 = Result.INSTANCE;
                                objM514constructorimpl = Result.m514constructorimpl(objM514constructorimpl);
                            } else {
                                thM517exceptionOrNullimpl = Result.m517exceptionOrNullimpl(objM514constructorimpl);
                                if (thM517exceptionOrNullimpl != null) {
                                    Result.Companion companion19 = Result.INSTANCE;
                                    objM514constructorimpl = Result.m514constructorimpl(ResultKt.createFailure(thM517exceptionOrNullimpl));
                                }
                            }
                            return Result.m513boximpl(objM514constructorimpl);
                        }
                        initializationExceptionOrThrow2 = ResultExtensionsKt.getInitializationExceptionOrThrow(value4);
                        this.L$0 = coroutineScope2;
                        this.L$1 = initializeSDK3;
                        this.L$2 = obj3;
                        this.L$3 = configuration2;
                        this.label = 8;
                        if (initializeSDK3.handleInitializationException(initializationExceptionOrThrow2, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    InitializeStateLoadCache initializeStateLoadCache5 = initializeSDK3.initializeStateLoadCache;
                    ResultKt.throwOnFailure(obj3);
                    InitializeStateLoadCache.Params params1113 = new InitializeStateLoadCache.Params((Configuration) obj3);
                    this.L$0 = coroutineScope2;
                    this.L$1 = initializeSDK3;
                    this.L$2 = obj3;
                    this.L$3 = configuration2;
                    this.label = 9;
                    value6 = initializeStateLoadCache5.mo489invokegIAlus(params1113, this);
                    if (value6 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (Result.m520isFailureimpl(value6)) {
                        errorState2 = ErrorState.LoadCache;
                        thM517exceptionOrNullimpl5 = Result.m517exceptionOrNullimpl(value6);
                        this.L$0 = value6;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 10;
                        if (initializeSDK3.m493executeErrorStateBWLJW6A(errorState2, thM517exceptionOrNullimpl5, configuration2, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj4 = value6;
                        thM517exceptionOrNullimpl6 = Result.m517exceptionOrNullimpl(obj4);
                        if (thM517exceptionOrNullimpl6 == null) {
                            throw new Exception(ErrorState.LoadCache.toString());
                        }
                        throw thM517exceptionOrNullimpl6;
                    }
                    ResultKt.throwOnFailure(value6);
                    loadCacheResult = (InitializeStateLoadCache.LoadCacheResult) value6;
                    if (loadCacheResult.getHasHashMismatch()) {
                        if (!configuration2.getExperiments().isWebViewAsyncDownloadEnabled()) {
                        }
                        InitializeStateLoadWeb initializeStateLoadWeb5 = initializeSDK3.initializeStateLoadWeb;
                        ResultKt.throwOnFailure(obj3);
                        InitializeStateLoadWeb.Params params1114 = new InitializeStateLoadWeb.Params((Configuration) obj3);
                        this.L$0 = initializeSDK3;
                        this.L$1 = obj3;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 11;
                        value7 = initializeStateLoadWeb5.mo489invokegIAlus(params1114, this);
                        if (value7 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj5 = value7;
                        if (Result.m520isFailureimpl(obj5)) {
                            initializationExceptionOrThrow3 = ResultExtensionsKt.getInitializationExceptionOrThrow(obj5);
                            this.L$0 = initializeSDK3;
                            this.L$1 = obj3;
                            this.L$2 = obj5;
                            this.label = 12;
                            if (initializeSDK3.handleInitializationException(initializationExceptionOrThrow3, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        ResultKt.throwOnFailure(obj5);
                        webViewData = ((InitializeStateLoadWeb.LoadWebResult) obj5).getWebViewDataString();
                        break;
                    } else {
                        webViewData = loadCacheResult.getWebViewData();
                        if (webViewData == null) {
                            throw new IllegalStateException("WebView is missing.".toString());
                        }
                    }
                    InitializeStateCreate initializeStateCreate5 = initializeSDK3.initializeStateCreate;
                    ResultKt.throwOnFailure(obj3);
                    InitializeStateCreate.Params params1115 = new InitializeStateCreate.Params((Configuration) obj3, webViewData);
                    this.L$0 = initializeSDK3;
                    this.L$1 = obj3;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.label = 13;
                    value8 = initializeStateCreate5.mo489invokegIAlus(params1115, this);
                    if (value8 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj6 = obj3;
                    initializeSDK4 = initializeSDK3;
                    if (Result.m520isFailureimpl(value8)) {
                        initializationExceptionOrThrow4 = ResultExtensionsKt.getInitializationExceptionOrThrow(value8);
                        this.L$0 = initializeSDK4;
                        this.L$1 = obj6;
                        this.label = 14;
                        if (initializeSDK4.handleInitializationException(initializationExceptionOrThrow4, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    InitializeStateComplete initializeStateComplete10 = initializeSDK4.initializeStateComplete;
                    ResultKt.throwOnFailure(obj6);
                    InitializeStateComplete.Params params1116 = new InitializeStateComplete.Params((Configuration) obj6);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 15;
                    value9 = initializeStateComplete10.mo489invokegIAlus(params1116, this);
                    if (value9 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ResultKt.throwOnFailure(value9);
                    objM514constructorimpl = Result.m514constructorimpl(Unit.INSTANCE);
                    if (Result.m521isSuccessimpl(objM514constructorimpl)) {
                        Result.Companion companion110 = Result.INSTANCE;
                        objM514constructorimpl = Result.m514constructorimpl(objM514constructorimpl);
                    } else {
                        thM517exceptionOrNullimpl = Result.m517exceptionOrNullimpl(objM514constructorimpl);
                        if (thM517exceptionOrNullimpl != null) {
                            Result.Companion companion111 = Result.INSTANCE;
                            objM514constructorimpl = Result.m514constructorimpl(ResultKt.createFailure(thM517exceptionOrNullimpl));
                        }
                    }
                    return Result.m513boximpl(objM514constructorimpl);
                case 6:
                    configuration2 = (Configuration) this.L$3;
                    obj3 = this.L$2;
                    initializeSDK3 = (InitializeSDK) this.L$1;
                    coroutineScope2 = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    value4 = ((Result) obj).getValue();
                    if (Result.m521isSuccessimpl(value4)) {
                        InitializeStateComplete initializeStateComplete11 = initializeSDK3.initializeStateComplete;
                        ResultKt.throwOnFailure(obj3);
                        InitializeStateComplete.Params params1117 = new InitializeStateComplete.Params((Configuration) obj3);
                        this.L$0 = null;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 7;
                        value5 = initializeStateComplete11.mo489invokegIAlus(params1117, this);
                        if (value5 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        ResultKt.throwOnFailure(value5);
                        objM514constructorimpl = Result.m514constructorimpl(Unit.INSTANCE);
                        if (Result.m521isSuccessimpl(objM514constructorimpl)) {
                            Result.Companion companion112 = Result.INSTANCE;
                            objM514constructorimpl = Result.m514constructorimpl(objM514constructorimpl);
                        } else {
                            thM517exceptionOrNullimpl = Result.m517exceptionOrNullimpl(objM514constructorimpl);
                            if (thM517exceptionOrNullimpl != null) {
                                Result.Companion companion113 = Result.INSTANCE;
                                objM514constructorimpl = Result.m514constructorimpl(ResultKt.createFailure(thM517exceptionOrNullimpl));
                            }
                        }
                        return Result.m513boximpl(objM514constructorimpl);
                    }
                    initializationExceptionOrThrow2 = ResultExtensionsKt.getInitializationExceptionOrThrow(value4);
                    this.L$0 = coroutineScope2;
                    this.L$1 = initializeSDK3;
                    this.L$2 = obj3;
                    this.L$3 = configuration2;
                    this.label = 8;
                    if (initializeSDK3.handleInitializationException(initializationExceptionOrThrow2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    InitializeStateLoadCache initializeStateLoadCache6 = initializeSDK3.initializeStateLoadCache;
                    ResultKt.throwOnFailure(obj3);
                    InitializeStateLoadCache.Params params1118 = new InitializeStateLoadCache.Params((Configuration) obj3);
                    this.L$0 = coroutineScope2;
                    this.L$1 = initializeSDK3;
                    this.L$2 = obj3;
                    this.L$3 = configuration2;
                    this.label = 9;
                    value6 = initializeStateLoadCache6.mo489invokegIAlus(params1118, this);
                    if (value6 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (Result.m520isFailureimpl(value6)) {
                        errorState2 = ErrorState.LoadCache;
                        thM517exceptionOrNullimpl5 = Result.m517exceptionOrNullimpl(value6);
                        this.L$0 = value6;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 10;
                        if (initializeSDK3.m493executeErrorStateBWLJW6A(errorState2, thM517exceptionOrNullimpl5, configuration2, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj4 = value6;
                        thM517exceptionOrNullimpl6 = Result.m517exceptionOrNullimpl(obj4);
                        if (thM517exceptionOrNullimpl6 == null) {
                            throw new Exception(ErrorState.LoadCache.toString());
                        }
                        throw thM517exceptionOrNullimpl6;
                    }
                    ResultKt.throwOnFailure(value6);
                    loadCacheResult = (InitializeStateLoadCache.LoadCacheResult) value6;
                    if (loadCacheResult.getHasHashMismatch()) {
                        if (!configuration2.getExperiments().isWebViewAsyncDownloadEnabled()) {
                        }
                        InitializeStateLoadWeb initializeStateLoadWeb6 = initializeSDK3.initializeStateLoadWeb;
                        ResultKt.throwOnFailure(obj3);
                        InitializeStateLoadWeb.Params params1119 = new InitializeStateLoadWeb.Params((Configuration) obj3);
                        this.L$0 = initializeSDK3;
                        this.L$1 = obj3;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 11;
                        value7 = initializeStateLoadWeb6.mo489invokegIAlus(params1119, this);
                        if (value7 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj5 = value7;
                        if (Result.m520isFailureimpl(obj5)) {
                            initializationExceptionOrThrow3 = ResultExtensionsKt.getInitializationExceptionOrThrow(obj5);
                            this.L$0 = initializeSDK3;
                            this.L$1 = obj3;
                            this.L$2 = obj5;
                            this.label = 12;
                            if (initializeSDK3.handleInitializationException(initializationExceptionOrThrow3, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        ResultKt.throwOnFailure(obj5);
                        webViewData = ((InitializeStateLoadWeb.LoadWebResult) obj5).getWebViewDataString();
                        break;
                    } else {
                        webViewData = loadCacheResult.getWebViewData();
                        if (webViewData == null) {
                            throw new IllegalStateException("WebView is missing.".toString());
                        }
                    }
                    InitializeStateCreate initializeStateCreate6 = initializeSDK3.initializeStateCreate;
                    ResultKt.throwOnFailure(obj3);
                    InitializeStateCreate.Params params11110 = new InitializeStateCreate.Params((Configuration) obj3, webViewData);
                    this.L$0 = initializeSDK3;
                    this.L$1 = obj3;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.label = 13;
                    value8 = initializeStateCreate6.mo489invokegIAlus(params11110, this);
                    if (value8 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj6 = obj3;
                    initializeSDK4 = initializeSDK3;
                    if (Result.m520isFailureimpl(value8)) {
                        initializationExceptionOrThrow4 = ResultExtensionsKt.getInitializationExceptionOrThrow(value8);
                        this.L$0 = initializeSDK4;
                        this.L$1 = obj6;
                        this.label = 14;
                        if (initializeSDK4.handleInitializationException(initializationExceptionOrThrow4, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    InitializeStateComplete initializeStateComplete12 = initializeSDK4.initializeStateComplete;
                    ResultKt.throwOnFailure(obj6);
                    InitializeStateComplete.Params params11111 = new InitializeStateComplete.Params((Configuration) obj6);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 15;
                    value9 = initializeStateComplete12.mo489invokegIAlus(params11111, this);
                    if (value9 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ResultKt.throwOnFailure(value9);
                    objM514constructorimpl = Result.m514constructorimpl(Unit.INSTANCE);
                    if (Result.m521isSuccessimpl(objM514constructorimpl)) {
                        Result.Companion companion114 = Result.INSTANCE;
                        objM514constructorimpl = Result.m514constructorimpl(objM514constructorimpl);
                    } else {
                        thM517exceptionOrNullimpl = Result.m517exceptionOrNullimpl(objM514constructorimpl);
                        if (thM517exceptionOrNullimpl != null) {
                            Result.Companion companion115 = Result.INSTANCE;
                            objM514constructorimpl = Result.m514constructorimpl(ResultKt.createFailure(thM517exceptionOrNullimpl));
                        }
                    }
                    return Result.m513boximpl(objM514constructorimpl);
                case 7:
                    ResultKt.throwOnFailure(obj);
                    value5 = ((Result) obj).getValue();
                    ResultKt.throwOnFailure(value5);
                    objM514constructorimpl = Result.m514constructorimpl(Unit.INSTANCE);
                    if (Result.m521isSuccessimpl(objM514constructorimpl)) {
                        Result.Companion companion116 = Result.INSTANCE;
                        objM514constructorimpl = Result.m514constructorimpl(objM514constructorimpl);
                    } else {
                        thM517exceptionOrNullimpl = Result.m517exceptionOrNullimpl(objM514constructorimpl);
                        if (thM517exceptionOrNullimpl != null) {
                            Result.Companion companion117 = Result.INSTANCE;
                            objM514constructorimpl = Result.m514constructorimpl(ResultKt.createFailure(thM517exceptionOrNullimpl));
                        }
                    }
                    return Result.m513boximpl(objM514constructorimpl);
                case 8:
                    configuration2 = (Configuration) this.L$3;
                    obj3 = this.L$2;
                    initializeSDK3 = (InitializeSDK) this.L$1;
                    coroutineScope2 = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    InitializeStateLoadCache initializeStateLoadCache7 = initializeSDK3.initializeStateLoadCache;
                    ResultKt.throwOnFailure(obj3);
                    InitializeStateLoadCache.Params params11112 = new InitializeStateLoadCache.Params((Configuration) obj3);
                    this.L$0 = coroutineScope2;
                    this.L$1 = initializeSDK3;
                    this.L$2 = obj3;
                    this.L$3 = configuration2;
                    this.label = 9;
                    value6 = initializeStateLoadCache7.mo489invokegIAlus(params11112, this);
                    if (value6 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (Result.m520isFailureimpl(value6)) {
                        errorState2 = ErrorState.LoadCache;
                        thM517exceptionOrNullimpl5 = Result.m517exceptionOrNullimpl(value6);
                        this.L$0 = value6;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 10;
                        if (initializeSDK3.m493executeErrorStateBWLJW6A(errorState2, thM517exceptionOrNullimpl5, configuration2, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj4 = value6;
                        thM517exceptionOrNullimpl6 = Result.m517exceptionOrNullimpl(obj4);
                        if (thM517exceptionOrNullimpl6 == null) {
                            throw new Exception(ErrorState.LoadCache.toString());
                        }
                        throw thM517exceptionOrNullimpl6;
                    }
                    ResultKt.throwOnFailure(value6);
                    loadCacheResult = (InitializeStateLoadCache.LoadCacheResult) value6;
                    if (loadCacheResult.getHasHashMismatch()) {
                        if (!configuration2.getExperiments().isWebViewAsyncDownloadEnabled()) {
                        }
                        InitializeStateLoadWeb initializeStateLoadWeb7 = initializeSDK3.initializeStateLoadWeb;
                        ResultKt.throwOnFailure(obj3);
                        InitializeStateLoadWeb.Params params11113 = new InitializeStateLoadWeb.Params((Configuration) obj3);
                        this.L$0 = initializeSDK3;
                        this.L$1 = obj3;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 11;
                        value7 = initializeStateLoadWeb7.mo489invokegIAlus(params11113, this);
                        if (value7 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj5 = value7;
                        if (Result.m520isFailureimpl(obj5)) {
                            initializationExceptionOrThrow3 = ResultExtensionsKt.getInitializationExceptionOrThrow(obj5);
                            this.L$0 = initializeSDK3;
                            this.L$1 = obj3;
                            this.L$2 = obj5;
                            this.label = 12;
                            if (initializeSDK3.handleInitializationException(initializationExceptionOrThrow3, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        ResultKt.throwOnFailure(obj5);
                        webViewData = ((InitializeStateLoadWeb.LoadWebResult) obj5).getWebViewDataString();
                        break;
                    } else {
                        webViewData = loadCacheResult.getWebViewData();
                        if (webViewData == null) {
                            throw new IllegalStateException("WebView is missing.".toString());
                        }
                    }
                    InitializeStateCreate initializeStateCreate7 = initializeSDK3.initializeStateCreate;
                    ResultKt.throwOnFailure(obj3);
                    InitializeStateCreate.Params params11114 = new InitializeStateCreate.Params((Configuration) obj3, webViewData);
                    this.L$0 = initializeSDK3;
                    this.L$1 = obj3;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.label = 13;
                    value8 = initializeStateCreate7.mo489invokegIAlus(params11114, this);
                    if (value8 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj6 = obj3;
                    initializeSDK4 = initializeSDK3;
                    if (Result.m520isFailureimpl(value8)) {
                        initializationExceptionOrThrow4 = ResultExtensionsKt.getInitializationExceptionOrThrow(value8);
                        this.L$0 = initializeSDK4;
                        this.L$1 = obj6;
                        this.label = 14;
                        if (initializeSDK4.handleInitializationException(initializationExceptionOrThrow4, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    InitializeStateComplete initializeStateComplete13 = initializeSDK4.initializeStateComplete;
                    ResultKt.throwOnFailure(obj6);
                    InitializeStateComplete.Params params11115 = new InitializeStateComplete.Params((Configuration) obj6);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 15;
                    value9 = initializeStateComplete13.mo489invokegIAlus(params11115, this);
                    if (value9 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ResultKt.throwOnFailure(value9);
                    objM514constructorimpl = Result.m514constructorimpl(Unit.INSTANCE);
                    if (Result.m521isSuccessimpl(objM514constructorimpl)) {
                        Result.Companion companion118 = Result.INSTANCE;
                        objM514constructorimpl = Result.m514constructorimpl(objM514constructorimpl);
                    } else {
                        thM517exceptionOrNullimpl = Result.m517exceptionOrNullimpl(objM514constructorimpl);
                        if (thM517exceptionOrNullimpl != null) {
                            Result.Companion companion119 = Result.INSTANCE;
                            objM514constructorimpl = Result.m514constructorimpl(ResultKt.createFailure(thM517exceptionOrNullimpl));
                        }
                    }
                    return Result.m513boximpl(objM514constructorimpl);
                case 9:
                    configuration2 = (Configuration) this.L$3;
                    obj3 = this.L$2;
                    initializeSDK3 = (InitializeSDK) this.L$1;
                    coroutineScope2 = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    value6 = ((Result) obj).getValue();
                    if (Result.m520isFailureimpl(value6)) {
                        errorState2 = ErrorState.LoadCache;
                        thM517exceptionOrNullimpl5 = Result.m517exceptionOrNullimpl(value6);
                        this.L$0 = value6;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 10;
                        if (initializeSDK3.m493executeErrorStateBWLJW6A(errorState2, thM517exceptionOrNullimpl5, configuration2, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj4 = value6;
                        thM517exceptionOrNullimpl6 = Result.m517exceptionOrNullimpl(obj4);
                        if (thM517exceptionOrNullimpl6 == null) {
                            throw new Exception(ErrorState.LoadCache.toString());
                        }
                        throw thM517exceptionOrNullimpl6;
                    }
                    ResultKt.throwOnFailure(value6);
                    loadCacheResult = (InitializeStateLoadCache.LoadCacheResult) value6;
                    if (loadCacheResult.getHasHashMismatch()) {
                        if (!configuration2.getExperiments().isWebViewAsyncDownloadEnabled()) {
                        }
                        InitializeStateLoadWeb initializeStateLoadWeb8 = initializeSDK3.initializeStateLoadWeb;
                        ResultKt.throwOnFailure(obj3);
                        InitializeStateLoadWeb.Params params11116 = new InitializeStateLoadWeb.Params((Configuration) obj3);
                        this.L$0 = initializeSDK3;
                        this.L$1 = obj3;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 11;
                        value7 = initializeStateLoadWeb8.mo489invokegIAlus(params11116, this);
                        if (value7 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj5 = value7;
                        if (Result.m520isFailureimpl(obj5)) {
                            initializationExceptionOrThrow3 = ResultExtensionsKt.getInitializationExceptionOrThrow(obj5);
                            this.L$0 = initializeSDK3;
                            this.L$1 = obj3;
                            this.L$2 = obj5;
                            this.label = 12;
                            if (initializeSDK3.handleInitializationException(initializationExceptionOrThrow3, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        ResultKt.throwOnFailure(obj5);
                        webViewData = ((InitializeStateLoadWeb.LoadWebResult) obj5).getWebViewDataString();
                        break;
                    } else {
                        webViewData = loadCacheResult.getWebViewData();
                        if (webViewData == null) {
                            throw new IllegalStateException("WebView is missing.".toString());
                        }
                    }
                    InitializeStateCreate initializeStateCreate8 = initializeSDK3.initializeStateCreate;
                    ResultKt.throwOnFailure(obj3);
                    InitializeStateCreate.Params params11117 = new InitializeStateCreate.Params((Configuration) obj3, webViewData);
                    this.L$0 = initializeSDK3;
                    this.L$1 = obj3;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.label = 13;
                    value8 = initializeStateCreate8.mo489invokegIAlus(params11117, this);
                    if (value8 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj6 = obj3;
                    initializeSDK4 = initializeSDK3;
                    if (Result.m520isFailureimpl(value8)) {
                        initializationExceptionOrThrow4 = ResultExtensionsKt.getInitializationExceptionOrThrow(value8);
                        this.L$0 = initializeSDK4;
                        this.L$1 = obj6;
                        this.label = 14;
                        if (initializeSDK4.handleInitializationException(initializationExceptionOrThrow4, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    InitializeStateComplete initializeStateComplete14 = initializeSDK4.initializeStateComplete;
                    ResultKt.throwOnFailure(obj6);
                    InitializeStateComplete.Params params11118 = new InitializeStateComplete.Params((Configuration) obj6);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 15;
                    value9 = initializeStateComplete14.mo489invokegIAlus(params11118, this);
                    if (value9 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ResultKt.throwOnFailure(value9);
                    objM514constructorimpl = Result.m514constructorimpl(Unit.INSTANCE);
                    if (Result.m521isSuccessimpl(objM514constructorimpl)) {
                        Result.Companion companion1110 = Result.INSTANCE;
                        objM514constructorimpl = Result.m514constructorimpl(objM514constructorimpl);
                    } else {
                        thM517exceptionOrNullimpl = Result.m517exceptionOrNullimpl(objM514constructorimpl);
                        if (thM517exceptionOrNullimpl != null) {
                            Result.Companion companion1111 = Result.INSTANCE;
                            objM514constructorimpl = Result.m514constructorimpl(ResultKt.createFailure(thM517exceptionOrNullimpl));
                        }
                    }
                    return Result.m513boximpl(objM514constructorimpl);
                case 10:
                    obj4 = this.L$0;
                    ResultKt.throwOnFailure(obj);
                    ((Result) obj).getValue();
                    thM517exceptionOrNullimpl6 = Result.m517exceptionOrNullimpl(obj4);
                    if (thM517exceptionOrNullimpl6 == null) {
                        throw new Exception(ErrorState.LoadCache.toString());
                    }
                    throw thM517exceptionOrNullimpl6;
                case 11:
                    Object obj8 = this.L$1;
                    InitializeSDK initializeSDK5 = (InitializeSDK) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    value7 = ((Result) obj).getValue();
                    initializeSDK3 = initializeSDK5;
                    obj3 = obj8;
                    obj5 = value7;
                    if (Result.m520isFailureimpl(obj5)) {
                        initializationExceptionOrThrow3 = ResultExtensionsKt.getInitializationExceptionOrThrow(obj5);
                        this.L$0 = initializeSDK3;
                        this.L$1 = obj3;
                        this.L$2 = obj5;
                        this.label = 12;
                        if (initializeSDK3.handleInitializationException(initializationExceptionOrThrow3, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    ResultKt.throwOnFailure(obj5);
                    webViewData = ((InitializeStateLoadWeb.LoadWebResult) obj5).getWebViewDataString();
                    InitializeStateCreate initializeStateCreate9 = initializeSDK3.initializeStateCreate;
                    ResultKt.throwOnFailure(obj3);
                    InitializeStateCreate.Params params11119 = new InitializeStateCreate.Params((Configuration) obj3, webViewData);
                    this.L$0 = initializeSDK3;
                    this.L$1 = obj3;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.label = 13;
                    value8 = initializeStateCreate9.mo489invokegIAlus(params11119, this);
                    if (value8 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj6 = obj3;
                    initializeSDK4 = initializeSDK3;
                    if (Result.m520isFailureimpl(value8)) {
                        initializationExceptionOrThrow4 = ResultExtensionsKt.getInitializationExceptionOrThrow(value8);
                        this.L$0 = initializeSDK4;
                        this.L$1 = obj6;
                        this.label = 14;
                        if (initializeSDK4.handleInitializationException(initializationExceptionOrThrow4, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    InitializeStateComplete initializeStateComplete15 = initializeSDK4.initializeStateComplete;
                    ResultKt.throwOnFailure(obj6);
                    InitializeStateComplete.Params params111110 = new InitializeStateComplete.Params((Configuration) obj6);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 15;
                    value9 = initializeStateComplete15.mo489invokegIAlus(params111110, this);
                    if (value9 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ResultKt.throwOnFailure(value9);
                    objM514constructorimpl = Result.m514constructorimpl(Unit.INSTANCE);
                    if (Result.m521isSuccessimpl(objM514constructorimpl)) {
                        Result.Companion companion1112 = Result.INSTANCE;
                        objM514constructorimpl = Result.m514constructorimpl(objM514constructorimpl);
                    } else {
                        thM517exceptionOrNullimpl = Result.m517exceptionOrNullimpl(objM514constructorimpl);
                        if (thM517exceptionOrNullimpl != null) {
                            Result.Companion companion1113 = Result.INSTANCE;
                            objM514constructorimpl = Result.m514constructorimpl(ResultKt.createFailure(thM517exceptionOrNullimpl));
                        }
                    }
                    return Result.m513boximpl(objM514constructorimpl);
                case 12:
                    obj5 = this.L$2;
                    obj3 = this.L$1;
                    initializeSDK3 = (InitializeSDK) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    ResultKt.throwOnFailure(obj5);
                    webViewData = ((InitializeStateLoadWeb.LoadWebResult) obj5).getWebViewDataString();
                    InitializeStateCreate initializeStateCreate10 = initializeSDK3.initializeStateCreate;
                    ResultKt.throwOnFailure(obj3);
                    InitializeStateCreate.Params params111111 = new InitializeStateCreate.Params((Configuration) obj3, webViewData);
                    this.L$0 = initializeSDK3;
                    this.L$1 = obj3;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.label = 13;
                    value8 = initializeStateCreate10.mo489invokegIAlus(params111111, this);
                    if (value8 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj6 = obj3;
                    initializeSDK4 = initializeSDK3;
                    if (Result.m520isFailureimpl(value8)) {
                        initializationExceptionOrThrow4 = ResultExtensionsKt.getInitializationExceptionOrThrow(value8);
                        this.L$0 = initializeSDK4;
                        this.L$1 = obj6;
                        this.label = 14;
                        if (initializeSDK4.handleInitializationException(initializationExceptionOrThrow4, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    InitializeStateComplete initializeStateComplete16 = initializeSDK4.initializeStateComplete;
                    ResultKt.throwOnFailure(obj6);
                    InitializeStateComplete.Params params111112 = new InitializeStateComplete.Params((Configuration) obj6);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 15;
                    value9 = initializeStateComplete16.mo489invokegIAlus(params111112, this);
                    if (value9 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ResultKt.throwOnFailure(value9);
                    objM514constructorimpl = Result.m514constructorimpl(Unit.INSTANCE);
                    if (Result.m521isSuccessimpl(objM514constructorimpl)) {
                        Result.Companion companion1114 = Result.INSTANCE;
                        objM514constructorimpl = Result.m514constructorimpl(objM514constructorimpl);
                    } else {
                        thM517exceptionOrNullimpl = Result.m517exceptionOrNullimpl(objM514constructorimpl);
                        if (thM517exceptionOrNullimpl != null) {
                            Result.Companion companion1115 = Result.INSTANCE;
                            objM514constructorimpl = Result.m514constructorimpl(ResultKt.createFailure(thM517exceptionOrNullimpl));
                        }
                    }
                    return Result.m513boximpl(objM514constructorimpl);
                case 13:
                    obj6 = this.L$1;
                    initializeSDK4 = (InitializeSDK) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    value8 = ((Result) obj).getValue();
                    if (Result.m520isFailureimpl(value8)) {
                        initializationExceptionOrThrow4 = ResultExtensionsKt.getInitializationExceptionOrThrow(value8);
                        this.L$0 = initializeSDK4;
                        this.L$1 = obj6;
                        this.label = 14;
                        if (initializeSDK4.handleInitializationException(initializationExceptionOrThrow4, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    InitializeStateComplete initializeStateComplete17 = initializeSDK4.initializeStateComplete;
                    ResultKt.throwOnFailure(obj6);
                    InitializeStateComplete.Params params111113 = new InitializeStateComplete.Params((Configuration) obj6);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 15;
                    value9 = initializeStateComplete17.mo489invokegIAlus(params111113, this);
                    if (value9 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ResultKt.throwOnFailure(value9);
                    objM514constructorimpl = Result.m514constructorimpl(Unit.INSTANCE);
                    if (Result.m521isSuccessimpl(objM514constructorimpl)) {
                        Result.Companion companion1116 = Result.INSTANCE;
                        objM514constructorimpl = Result.m514constructorimpl(objM514constructorimpl);
                    } else {
                        thM517exceptionOrNullimpl = Result.m517exceptionOrNullimpl(objM514constructorimpl);
                        if (thM517exceptionOrNullimpl != null) {
                            Result.Companion companion1117 = Result.INSTANCE;
                            objM514constructorimpl = Result.m514constructorimpl(ResultKt.createFailure(thM517exceptionOrNullimpl));
                        }
                    }
                    return Result.m513boximpl(objM514constructorimpl);
                case 14:
                    obj6 = this.L$1;
                    initializeSDK4 = (InitializeSDK) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    InitializeStateComplete initializeStateComplete18 = initializeSDK4.initializeStateComplete;
                    ResultKt.throwOnFailure(obj6);
                    InitializeStateComplete.Params params111114 = new InitializeStateComplete.Params((Configuration) obj6);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 15;
                    value9 = initializeStateComplete18.mo489invokegIAlus(params111114, this);
                    if (value9 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ResultKt.throwOnFailure(value9);
                    objM514constructorimpl = Result.m514constructorimpl(Unit.INSTANCE);
                    if (Result.m521isSuccessimpl(objM514constructorimpl)) {
                        Result.Companion companion1118 = Result.INSTANCE;
                        objM514constructorimpl = Result.m514constructorimpl(objM514constructorimpl);
                    } else {
                        thM517exceptionOrNullimpl = Result.m517exceptionOrNullimpl(objM514constructorimpl);
                        if (thM517exceptionOrNullimpl != null) {
                            Result.Companion companion1119 = Result.INSTANCE;
                            objM514constructorimpl = Result.m514constructorimpl(ResultKt.createFailure(thM517exceptionOrNullimpl));
                        }
                    }
                    return Result.m513boximpl(objM514constructorimpl);
                case 15:
                    ResultKt.throwOnFailure(obj);
                    value9 = ((Result) obj).getValue();
                    ResultKt.throwOnFailure(value9);
                    objM514constructorimpl = Result.m514constructorimpl(Unit.INSTANCE);
                    if (Result.m521isSuccessimpl(objM514constructorimpl)) {
                        Result.Companion companion11110 = Result.INSTANCE;
                        objM514constructorimpl = Result.m514constructorimpl(objM514constructorimpl);
                    } else {
                        thM517exceptionOrNullimpl = Result.m517exceptionOrNullimpl(objM514constructorimpl);
                        if (thM517exceptionOrNullimpl != null) {
                            Result.Companion companion11111 = Result.INSTANCE;
                            objM514constructorimpl = Result.m514constructorimpl(ResultKt.createFailure(thM517exceptionOrNullimpl));
                        }
                    }
                    return Result.m513boximpl(objM514constructorimpl);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (CancellationException e) {
            throw e;
        } catch (Throwable th) {
            Result.Companion companion20 = Result.INSTANCE;
            objM514constructorimpl = Result.m514constructorimpl(ResultKt.createFailure(th));
        }
    }
}
