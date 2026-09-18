package com.kakao.adfit.i;

import com.kakao.adfit.common.matrix.MatrixItemType;
import com.kakao.adfit.e.MatrixEvent;
import java.io.Closeable;
import kotlin.Metadata;

/* JADX INFO: compiled from: ITransport.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&¨\u0006\t"}, d2 = {"Lcom/kakao/adfit/i/e;", "Ljava/io/Closeable;", "Lcom/kakao/adfit/e/h;", "event", "Lcom/kakao/adfit/i/j;", "a", "Lcom/kakao/adfit/common/matrix/MatrixItemType;", "itemType", "", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public interface e extends Closeable {
    j a(MatrixEvent event);

    boolean a(MatrixItemType itemType);
}
