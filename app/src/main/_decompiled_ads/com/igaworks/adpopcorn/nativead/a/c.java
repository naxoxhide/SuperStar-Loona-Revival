package com.igaworks.adpopcorn.nativead.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.igaworks.adpopcorn.R;
import com.igaworks.adpopcorn.cores.common.d;
import com.igaworks.adpopcorn.style.ApStyleManager;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class c extends RecyclerView.Adapter<b> {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<com.igaworks.adpopcorn.cores.model.a> f1631b;
    private GradientDrawable c;
    private View.OnClickListener d;

    public c(Context context, List<com.igaworks.adpopcorn.cores.model.a> list, View.OnClickListener onClickListener) {
        this.a = context;
        this.f1631b = list;
        this.d = onClickListener;
        int iA = d.a(context, 6);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1, -1});
        this.c = gradientDrawable;
        gradientDrawable.setShape(0);
        float f = iA;
        this.c.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, f, f, f, f});
        this.c.setGradientType(0);
        this.c.setStroke(d.a(context, 1), Color.parseColor("#eeeeee"));
    }

    private int a(int i) {
        return (int) ((((double) i) / 312.0d) * 164.0d);
    }

    private View a() {
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        linearLayout.setGravity(1);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundResource(R.drawable.rcpm_card_round_bg);
        if (Build.VERSION.SDK_INT > 21) {
            linearLayout.setClipToOutline(true);
        }
        int iC = d.c() - d.a(this.a, 48);
        int iA = a(iC);
        ImageView imageView = new ImageView(this.a);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(iC, iA));
        imageView.setId(0);
        linearLayout.addView(imageView);
        LinearLayout linearLayout2 = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iC, d.a(this.a, 75));
        layoutParams.bottomMargin = d.a(this.a, 12);
        linearLayout2.setLayoutParams(layoutParams);
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(16);
        linearLayout2.setId(1);
        if (com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.NATIVE_RCPM_ENABLE_TEXT_BOX_OUTLINE)) {
            linearLayout2.setBackgroundDrawable(this.c);
        } else {
            linearLayout2.setBackgroundColor(Color.parseColor("#ffffff"));
        }
        linearLayout.addView(linearLayout2);
        TextView textView = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(iC, d.a(this.a, 19));
        layoutParams2.bottomMargin = d.a(this.a, 8);
        textView.setPadding(d.a(this.a, 16), 0, d.a(this.a, 16), 0);
        textView.setLayoutParams(layoutParams2);
        textView.setGravity(16);
        textView.setIncludeFontPadding(false);
        textView.setId(2);
        textView.setSingleLine();
        linearLayout2.addView(textView);
        TextView textView2 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(iC, d.a(this.a, 16));
        textView2.setPadding(d.a(this.a, 16), 0, d.a(this.a, 16), 0);
        textView2.setLayoutParams(layoutParams3);
        textView2.setGravity(16);
        textView2.setIncludeFontPadding(false);
        textView2.setSingleLine();
        textView2.setId(3);
        linearLayout2.addView(textView2);
        TextView textView3 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, d.a(this.a, 36));
        layoutParams4.gravity = 5;
        textView3.setLayoutParams(layoutParams4);
        textView3.setMinWidth(d.a(this.a, 111));
        textView3.setGravity(17);
        textView3.setId(4);
        linearLayout.addView(textView3);
        return linearLayout;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new b(viewGroup.getContext(), a());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b bVar, int i) {
        if (bVar instanceof b) {
            bVar.itemView.setOnClickListener(this.d);
            bVar.a(this.f1631b.get(i));
        }
    }

    public void a(List<com.igaworks.adpopcorn.cores.model.a> list) {
        this.f1631b = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<com.igaworks.adpopcorn.cores.model.a> list = this.f1631b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }
}
