package com.bytedance.sdk.openadsdk;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class FilterWord {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f373b;
    private boolean c;
    private List<FilterWord> d;

    public FilterWord(String str, String str2) {
        this.a = str;
        this.f373b = str2;
    }

    public void addOption(FilterWord filterWord) {
        if (filterWord == null) {
            return;
        }
        if (this.d == null) {
            this.d = new ArrayList();
        }
        this.d.add(filterWord);
    }

    public String getId() {
        return this.a;
    }

    public boolean getIsSelected() {
        return this.c;
    }

    public String getName() {
        return this.f373b;
    }

    public List<FilterWord> getOptions() {
        return this.d;
    }

    public boolean hasSecondOptions() {
        List<FilterWord> list = this.d;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.f373b)) ? false : true;
    }

    public void setId(String str) {
        this.a = str;
    }

    public void setIsSelected(boolean z) {
        this.c = z;
    }

    public void setName(String str) {
        this.f373b = str;
    }

    public FilterWord() {
    }
}
