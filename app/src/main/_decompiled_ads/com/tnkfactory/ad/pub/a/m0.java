package com.tnkfactory.ad.pub.a;

import com.gomfactory.adpie.sdk.common.Constants;
import com.igaworks.adpopcorn.style.ApStyleManager;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class m0 {
    public static m0 i;
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2878b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;

    public static class a extends m0 {
        public a() {
            this.c = "Internet browser is not installed.";
            this.a = "Confirm";
            this.f2878b = "Cancel";
            this.d = "Go";
            this.e = "<span style='color:#0087f5'>Close Video?</span>";
            this.f = "You will lose your reward.";
            this.g = "<span style='color:gray'>Close Video</span>";
            this.h = "<span style='color:#0087f5'>Resume Video</span>";
        }
    }

    public static class b extends m0 {
        public b() {
            this.c = "인터넷브라우저가 설치되어 있지 않습니다.";
            this.a = Constants.DEFAULT_DIALOG_THIRD_BUTTON_TEXT;
            this.f2878b = Constants.DEFAULT_DIALOG_FIRST_BUTTON_TEXT;
            this.d = "이동하기";
            this.e = "<span style='color:#0087f5'>동영상을 닫겠습니까?</span>";
            this.f = "리워드가 지급되지 않습니다.";
            this.g = "<span style='color:gray'>동영상 닫기</span>";
            this.h = "<span style='color:#0087f5'>계속 보기</span>";
        }
    }

    public static m0 a() {
        m0 aVar;
        if (i == null) {
            String language = Locale.getDefault().getLanguage();
            if ("ko,en".contains(language)) {
                if (ApStyleManager.Language.KO.equals(language)) {
                    aVar = new b();
                } else {
                    aVar = ApStyleManager.Language.EN.equals(language) ? new a() : null;
                }
                i = aVar;
            }
            if (i == null) {
                i = new a();
            }
        }
        return i;
    }
}
