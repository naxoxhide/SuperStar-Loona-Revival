package com.kakao.adfit.j;

import com.kakao.adfit.e.MatrixEvent;
import java.io.Reader;
import java.io.Writer;
import kotlin.Metadata;

/* JADX INFO: compiled from: ISerializer.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\n"}, d2 = {"Lcom/kakao/adfit/j/d;", "", "Ljava/io/Reader;", "reader", "Lcom/kakao/adfit/e/h;", "a", "event", "Ljava/io/Writer;", "writer", "", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public interface d {
    MatrixEvent a(Reader reader);

    void a(MatrixEvent event, Writer writer);
}
