package com.kakao.adfit.j;

import com.kakao.adfit.e.MatrixEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: JsonSerializer.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\f"}, d2 = {"Lcom/kakao/adfit/j/e;", "Lcom/kakao/adfit/j/d;", "Ljava/io/Reader;", "reader", "Lcom/kakao/adfit/e/h;", "a", "event", "Ljava/io/Writer;", "writer", "", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class e implements d {
    @Override // com.kakao.adfit.j.d
    public MatrixEvent a(Reader reader) throws IOException {
        Intrinsics.checkNotNullParameter(reader, "reader");
        String line = (reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, 8192)).readLine();
        if (line == null || StringsKt.isBlank(line)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullExpressionValue(line, "line");
            return MatrixEvent.INSTANCE.a(new JSONObject(line));
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.kakao.adfit.j.d
    public void a(MatrixEvent event, Writer writer) throws IOException {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(writer, "writer");
        String string = event.p().toString();
        Intrinsics.checkNotNullExpressionValue(string, "event.toJsonObject().toString()");
        BufferedWriter bufferedWriter = writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer, 8192);
        bufferedWriter.write(string);
        bufferedWriter.flush();
    }
}
