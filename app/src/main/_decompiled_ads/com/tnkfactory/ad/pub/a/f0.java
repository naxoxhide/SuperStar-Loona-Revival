package com.tnkfactory.ad.pub.a;

import android.content.Context;
import android.widget.RelativeLayout;
import com.tnkfactory.ad.AdError;

/* JADX INFO: loaded from: classes4.dex */
public final class f0 implements Runnable {
    public final /* synthetic */ e0 a;

    public f0(e0 e0Var) {
        this.a = e0Var;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.lang.Runnable
    public final void run() {
        e0 e0Var = this.a;
        e0Var.f.getWidth();
        e0Var.f.getHeight();
        Context context = e0Var.f.getContext();
        com.tnkfactory.ad.pub.a aVar = e0Var.e;
        int i = aVar.M;
        aVar.Z = (int) e0Var.j;
        float f = e0Var.k;
        aVar.a0 = (int) f;
        d0 d0Var = null;
        if (f < e0Var.g) {
            e0Var.a(e0Var.f, AdError.FAIL_BANNER_HEIGHT_100DP);
        } else {
            d0 d0VarA = d0.a(context, aVar);
            if (d0VarA == null || !d0VarA.j) {
                e0Var.a(e0Var.f, AdError.FAIL_AD_FRAME);
            } else {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) e0Var.j, (int) e0Var.k);
                layoutParams.addRule(13);
                d0VarA.setLayoutParams(layoutParams);
                d0Var = d0VarA;
            }
        }
        if (d0Var != null) {
            e0Var.f.addView(d0Var);
        }
    }
}
