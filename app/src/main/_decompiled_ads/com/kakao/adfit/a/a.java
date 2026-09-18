package com.kakao.adfit.a;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: compiled from: Ad.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R$\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR$\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR$\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/kakao/adfit/a/a;", "", "Lcom/kakao/adfit/a/e;", "a", "()Lcom/kakao/adfit/a/e;", "tracker", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "c", "()Ljava/util/ArrayList;", "renderedTrackers", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "viewableTrackers", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "clickTrackers", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public interface a {

    /* JADX INFO: renamed from: com.kakao.adfit.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Ad.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class C0442a {
        public static ArrayList<String> a(a aVar) {
            return aVar.a().a();
        }

        public static ArrayList<String> b(a aVar) {
            return aVar.a().c();
        }

        public static ArrayList<String> c(a aVar) {
            return aVar.a().d();
        }
    }

    e a();

    ArrayList<String> b();

    ArrayList<String> c();

    ArrayList<String> d();
}
