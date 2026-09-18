package com.mbridge.msdk.dycreator.bus;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class PendingPost {
    private static final List<PendingPost> d = new ArrayList();
    Object a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Subscription f2000b;
    PendingPost c;

    private PendingPost(Object obj, Subscription subscription) {
        this.a = obj;
        this.f2000b = subscription;
    }

    static PendingPost a(Subscription subscription, Object obj) {
        List<PendingPost> list = d;
        synchronized (list) {
            int size = list.size();
            if (size > 0) {
                PendingPost pendingPostRemove = list.remove(size - 1);
                pendingPostRemove.a = obj;
                pendingPostRemove.f2000b = subscription;
                pendingPostRemove.c = null;
                return pendingPostRemove;
            }
            return new PendingPost(obj, subscription);
        }
    }

    static void a(PendingPost pendingPost) {
        pendingPost.a = null;
        pendingPost.f2000b = null;
        pendingPost.c = null;
        List<PendingPost> list = d;
        synchronized (list) {
            if (list.size() < 10000) {
                list.add(pendingPost);
            }
        }
    }
}
