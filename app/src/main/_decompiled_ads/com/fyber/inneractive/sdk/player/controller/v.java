package com.fyber.inneractive.sdk.player.controller;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.util.m0;

/* JADX INFO: loaded from: classes2.dex */
public class v {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f1028b;
    public final Dialog c;
    public final com.fyber.inneractive.sdk.config.global.features.b d;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            v.this.c.dismiss();
            r rVar = (r) v.this.f1028b;
            rVar.f1026b.f(rVar.a);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            v.this.c.dismiss();
            v.this.f1028b.getClass();
        }
    }

    public interface c {
    }

    public v(Context context, com.fyber.inneractive.sdk.config.global.features.b bVar, c cVar) {
        this.a = context;
        this.d = bVar;
        this.f1028b = cVar;
        this.c = new Dialog(context);
        a();
    }

    public final void a() {
        this.c.requestWindowFeature(1);
        this.c.setContentView(R.layout.skip_rewarded_dialog);
        Button button = (Button) this.c.findViewById(R.id.keep_watching_button);
        Button button2 = (Button) this.c.findViewById(R.id.close_button);
        TextView textView = (TextView) this.c.findViewById(R.id.skip_dialog_title_textview);
        TextView textView2 = (TextView) this.c.findViewById(R.id.skip_dialog_sub_title_textview);
        String string = this.a.getString(R.string.skip_rewarded_dialog_keep_watching);
        String string2 = this.a.getString(R.string.skip_rewarded_dialog_close_button);
        String string3 = this.a.getString(R.string.skip_rewarded_dialog_title);
        String string4 = this.a.getString(R.string.skip_rewarded_dialog_sub_title);
        com.fyber.inneractive.sdk.config.global.features.b bVar = this.d;
        if (bVar != null) {
            String strA = bVar.a("skip_reward_dialog_keep_watching_button", "KEEP WATCHING");
            String strTrim = strA.trim().length() > 0 ? strA.trim() : "KEEP WATCHING";
            if (!TextUtils.isEmpty(strTrim)) {
                string = strTrim;
            }
            String strA2 = this.d.a("skip_reward_dialog_close_button", "CLOSE");
            String strTrim2 = strA2.trim().length() > 0 ? strA2.trim() : "CLOSE";
            if (!TextUtils.isEmpty(strTrim2)) {
                string2 = strTrim2;
            }
            String strA3 = this.d.a("skip_reward_dialog_title", "Close Video?");
            String strTrim3 = strA3.trim().length() > 0 ? strA3.trim() : "Close Video?";
            if (!TextUtils.isEmpty(strTrim3)) {
                string3 = strTrim3;
            }
            String strA4 = this.d.a("skip_reward_dialog_sub_title", "Reward will not be received before video completion.");
            String strTrim4 = strA4.trim().length() > 0 ? strA4.trim() : "Reward will not be received before video completion.";
            if (!TextUtils.isEmpty(strTrim4)) {
                string4 = strTrim4;
            }
        }
        button.setText(m0.a(string, 13));
        button2.setText(m0.a(string2, 13));
        textView.setText(m0.a(string3, 20));
        textView2.setText(m0.a(string4, 100));
        button2.setOnClickListener(new a());
        button.setOnClickListener(new b());
    }
}
