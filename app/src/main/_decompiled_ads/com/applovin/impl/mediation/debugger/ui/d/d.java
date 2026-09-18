package com.applovin.impl.mediation.debugger.ui.d;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.applovin.impl.sdk.utils.g;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class d extends BaseAdapter implements View.OnClickListener {
    protected Context E;
    private List<c> asG = new ArrayList();
    private Map<Integer, Integer> asH = new HashMap();
    private a asI;

    public interface a {
        void onClick(com.applovin.impl.mediation.debugger.ui.d.a aVar, c cVar);
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    protected abstract int gg(int i);

    protected abstract c gh(int i);

    protected abstract List<c> gi(int i);

    protected abstract int tM();

    protected c wZ() {
        return null;
    }

    protected d(Context context) {
        this.E = context.getApplicationContext();
    }

    public void a(a aVar) {
        this.asI = aVar;
    }

    public void wY() {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.mediation.debugger.ui.d.-$$Lambda$Y0lJBbjuwGrgRkximN0hNuRvBrA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.notifyDataSetChanged();
            }
        });
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return getItem(i).isEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return c.getViewTypeCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).wR();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.asG.size();
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: go, reason: merged with bridge method [inline-methods] */
    public c getItem(int i) {
        return this.asG.get(i);
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        int i;
        this.asG = new ArrayList();
        int iTM = tM();
        this.asH = new HashMap(iTM);
        c cVarWZ = wZ();
        if (cVarWZ != null) {
            this.asG.add(cVarWZ);
            i = 1;
        } else {
            i = 0;
        }
        for (int i2 = 0; i2 < iTM; i2++) {
            int iGg = gg(i2);
            if (iGg != 0) {
                this.asG.add(gh(i2));
                this.asG.addAll(gi(i2));
                this.asH.put(Integer.valueOf(i2), Integer.valueOf(i));
                i += iGg + 1;
            }
        }
        this.asG.add(new e(""));
        super.notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        c item = getItem(i);
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(item.wS(), viewGroup, false);
            bVar = new b();
            bVar.asn = (TextView) view.findViewById(R.id.text1);
            bVar.aso = (TextView) view.findViewById(R.id.text2);
            bVar.imageView = (ImageView) view.findViewById(com.applovin.sdk.R.id.imageView);
            bVar.asp = (ImageView) view.findViewById(com.applovin.sdk.R.id.detailImageView);
            view.setTag(bVar);
            view.setOnClickListener(this);
            view.setBackground(q(view));
        } else {
            bVar = (b) view.getTag();
        }
        bVar.fx(i);
        bVar.a(item);
        view.setEnabled(item.isEnabled());
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b bVar = (b) view.getTag();
        c cVarWQ = bVar.wQ();
        com.applovin.impl.mediation.debugger.ui.d.a aVarGp = gp(bVar.il());
        a aVar = this.asI;
        if (aVar == null || aVarGp == null) {
            return;
        }
        aVar.onClick(aVarGp, cVarWQ);
    }

    private com.applovin.impl.mediation.debugger.ui.d.a gp(int i) {
        for (int i2 = 0; i2 < tM(); i2++) {
            Integer num = this.asH.get(Integer.valueOf(i2));
            if (num != null) {
                if (i <= num.intValue() + gg(i2)) {
                    return new com.applovin.impl.mediation.debugger.ui.d.a(i2, i - (num.intValue() + 1));
                }
            }
        }
        return null;
    }

    private Drawable q(View view) {
        Drawable background = view.getBackground();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(g.a(com.applovin.sdk.R.color.applovin_sdk_highlightListItemColor, this.E));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, gradientDrawable);
        stateListDrawable.addState(new int[0], background);
        return stateListDrawable;
    }
}
