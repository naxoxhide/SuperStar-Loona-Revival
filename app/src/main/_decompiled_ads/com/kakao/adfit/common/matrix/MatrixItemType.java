package com.kakao.adfit.common.matrix;

import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;

/* JADX INFO: compiled from: MatrixItemType.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0003B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/kakao/adfit/common/matrix/MatrixItemType;", "", "", "a", "Ljava/lang/String;", "getItemType", "()Ljava/lang/String;", "itemType", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "Session", "Event", "Attachment", "Transaction", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public enum MatrixItemType {
    Session("session"),
    Event("event"),
    Attachment("attachment"),
    Transaction("transaction"),
    Unknown("__unknown__");


    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final String itemType;

    MatrixItemType(String str) {
        this.itemType = str;
    }

    public final String getItemType() {
        return this.itemType;
    }
}
