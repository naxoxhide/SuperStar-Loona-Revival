package b.b.a.a.d.g;

import android.net.Uri;
import android.text.TextUtils;

/* JADX INFO: compiled from: UrlUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: compiled from: UrlUtils.java */
    public enum a {
        HTML("text/html"),
        CSS("text/css"),
        JS("application/x-javascript"),
        IMAGE("image/*");

        private String a;

        a(String str) {
            this.a = str;
        }

        public String b() {
            return this.a;
        }
    }

    public static a a(String str) {
        a aVar;
        a aVar2 = a.IMAGE;
        if (TextUtils.isEmpty(str)) {
            return aVar2;
        }
        try {
            String path = Uri.parse(str).getPath();
            if (path == null) {
                return aVar2;
            }
            if (path.endsWith(".css")) {
                aVar = a.CSS;
            } else if (path.endsWith(".js")) {
                aVar = a.JS;
            } else {
                if (path.endsWith(".jpg") || path.endsWith(".gif") || path.endsWith(".png") || path.endsWith(".jpeg") || path.endsWith(".webp") || path.endsWith(".bmp") || path.endsWith(".ico") || !path.endsWith(".html")) {
                    return aVar2;
                }
                aVar = a.HTML;
            }
            return aVar;
        } catch (Throwable unused) {
            return aVar2;
        }
    }
}
