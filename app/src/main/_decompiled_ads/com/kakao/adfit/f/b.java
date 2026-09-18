package com.kakao.adfit.f;

import android.content.Context;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.kakao.adfit.e.MatrixEvent;
import com.kakao.adfit.e.i;
import com.kakao.adfit.k.f;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DiskBasedEventCache.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001d2\u00020\u0001:\u0002\u0005\u000bB\u001f\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\n\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0019B!\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u0013\u001a\u00020\n\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0002¢\u0006\u0004\b\u0005\u0010\u0007J\u0012\u0010\u0005\u001a\u00020\t2\b\b\u0002\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0005\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000fH\u0096\u0002R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001e"}, d2 = {"Lcom/kakao/adfit/f/b;", "Lcom/kakao/adfit/f/c;", "", "eventId", "Ljava/io/File;", "a", "", "()[Ljava/io/File;", "directory", "", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/kakao/adfit/e/h;", "event", "", "", "iterator", "Ljava/io/File;", "I", SDKConstants.PARAM_CONTEXT_MAX_SIZE, "Lcom/kakao/adfit/j/d;", "c", "Lcom/kakao/adfit/j/d;", "serializer", "<init>", "(Ljava/io/File;ILcom/kakao/adfit/j/d;)V", "Landroid/content/Context;", "context", "(Landroid/content/Context;ILcom/kakao/adfit/j/d;)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class b implements c {

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final File directory;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int maxSize;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final com.kakao.adfit.j.d serializer;

    /* JADX INFO: renamed from: com.kakao.adfit.f.b$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: DiskBasedEventCache.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0003R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/kakao/adfit/f/b$a;", "", "Ljava/io/File;", "", "a", "", "DEFAULT_DIRECTORY_NAME", "Ljava/lang/String;", "FILE_SUFFIX", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean a(File file) {
            try {
                return file.delete();
            } catch (Exception unused) {
                return false;
            }
        }
    }

    public b(File directory, int i, com.kakao.adfit.j.d serializer) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        this.directory = directory;
        this.maxSize = i;
        this.serializer = serializer;
    }

    @Override // com.kakao.adfit.f.c
    public void a(MatrixEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        i id = event.getId();
        String string = id != null ? id.toString() : null;
        if (string == null || string.length() == 0) {
            f.b("Event ID is empty");
            return;
        }
        File fileA = a(string);
        if (!fileA.exists()) {
            f.a("Event was not cached: " + fileA.getAbsolutePath());
        } else {
            if (INSTANCE.a(fileA)) {
                return;
            }
            f.b("Failed to delete Event: " + fileA.getAbsolutePath());
        }
    }

    @Override // com.kakao.adfit.f.c
    public void b(MatrixEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        i id = event.getId();
        String string = id != null ? id.toString() : null;
        if (string == null || string.length() == 0) {
            f.b("Event ID is empty");
            return;
        }
        if (b() >= this.maxSize) {
            f.e("Disk cache full (respecting maxSize). Not storing event: " + string);
            return;
        }
        File fileA = a(string);
        if (fileA.exists()) {
            f.e("Not adding Event to offline storage because it already exists: " + fileA.getAbsolutePath());
            return;
        }
        try {
            Writer outputStreamWriter = new OutputStreamWriter(new FileOutputStream(fileA), Charsets.UTF_8);
            BufferedWriter bufferedWriter = outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192);
            try {
                this.serializer.a(event, bufferedWriter);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(bufferedWriter, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(bufferedWriter, th);
                    throw th2;
                }
            }
        } catch (Exception e) {
            f.b("Error writing Event to offline storage: " + string, e);
            INSTANCE.a(fileA);
        }
    }

    @Override // java.lang.Iterable
    public Iterator<MatrixEvent> iterator() {
        return new C0458b(ArrayIteratorKt.iterator(a()), this.serializer);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(Context context, int i, com.kakao.adfit.j.d serializer) {
        this(new File(context.getCacheDir(), "com.kakao.adfit.matrix.cache"), i, serializer);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
    }

    /* JADX INFO: renamed from: com.kakao.adfit.f.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DiskBasedEventCache.kt */
    @Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0001\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0004\u001a\u0004\u0018\u00010\u0002*\u00020\u0003H\u0002J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0002J\t\u0010\u0004\u001a\u00020\u0002H\u0096\u0002R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/kakao/adfit/f/b$b;", "", "Lcom/kakao/adfit/e/h;", "Ljava/io/File;", "a", "", "hasNext", "Ljava/util/Iterator;", "files", "Lcom/kakao/adfit/j/d;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/kakao/adfit/j/d;", "serializer", "c", "Lcom/kakao/adfit/e/h;", "next", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "Z", "done", "<init>", "(Ljava/util/Iterator;Lcom/kakao/adfit/j/d;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class C0458b implements Iterator<MatrixEvent>, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final Iterator<File> files;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final com.kakao.adfit.j.d serializer;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private MatrixEvent next;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        private boolean done;

        /* JADX WARN: Multi-variable type inference failed */
        public C0458b(Iterator<? extends File> files, com.kakao.adfit.j.d serializer) {
            Intrinsics.checkNotNullParameter(files, "files");
            Intrinsics.checkNotNullParameter(serializer, "serializer");
            this.files = files;
            this.serializer = serializer;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MatrixEvent next() {
            if (this.next == null && !hasNext()) {
                throw new NoSuchElementException();
            }
            MatrixEvent matrixEvent = this.next;
            Intrinsics.checkNotNull(matrixEvent);
            this.next = null;
            return matrixEvent;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.done) {
                return false;
            }
            MatrixEvent matrixEvent = this.next;
            if (matrixEvent != null) {
                return matrixEvent != null;
            }
            while (this.files.hasNext()) {
                File next = this.files.next();
                MatrixEvent matrixEventA = a(next);
                if (matrixEventA != null) {
                    this.next = matrixEventA;
                    return true;
                }
                b.INSTANCE.a(next);
            }
            this.done = true;
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        private final MatrixEvent a(File file) {
            try {
                Reader inputStreamReader = new InputStreamReader(new FileInputStream(file), Charsets.UTF_8);
                BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                try {
                    MatrixEvent matrixEventA = this.serializer.a(bufferedReader);
                    if ((matrixEventA != null ? matrixEventA.getId() : null) == null) {
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(bufferedReader, null);
                        return null;
                    }
                    CloseableKt.closeFinally(bufferedReader, null);
                    return matrixEventA;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(bufferedReader, th);
                        throw th2;
                    }
                }
            } catch (FileNotFoundException unused) {
                f.a("Event file '" + file.getAbsolutePath() + "' disappeared while converting all cached files to events.");
            } catch (IOException e) {
                f.b("Error while reading cached event from file " + file.getAbsolutePath(), e);
            }
        }
    }

    private final File a(String eventId) {
        return new File(this.directory.getAbsolutePath(), eventId + ".matrix-event");
    }

    private final File[] a() {
        if (!a(this, null, 1, null)) {
            return new File[0];
        }
        File[] fileArrListFiles = this.directory.listFiles(new FilenameFilter() { // from class: com.kakao.adfit.f.-$$Lambda$b$uUHliOvxjsOtTP23sHcKEqTj0ok
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                return b.a(file, str);
            }
        });
        Intrinsics.checkNotNullExpressionValue(fileArrListFiles, "directory.listFiles { di…e.endsWith(FILE_SUFFIX) }");
        return fileArrListFiles;
    }

    private final int b() {
        return a().length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(File file, String name) {
        Intrinsics.checkNotNullExpressionValue(name, "name");
        return StringsKt.endsWith$default(name, ".matrix-event", false, 2, (Object) null);
    }

    static /* synthetic */ boolean a(b bVar, File file, int i, Object obj) {
        if ((i & 1) != 0) {
            file = bVar.directory;
        }
        return bVar.a(file);
    }

    private final boolean a(File directory) {
        if (((directory.exists() && directory.isDirectory()) || directory.mkdirs()) && directory.canWrite() && directory.canRead()) {
            return true;
        }
        f.b("The directory for caching Matrix events is inaccessible: " + directory.getAbsolutePath());
        return false;
    }
}
