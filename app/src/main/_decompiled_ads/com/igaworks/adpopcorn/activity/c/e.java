package com.igaworks.adpopcorn.activity.c;

import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class e extends GridView {
    public static boolean j = false;
    private AdapterView.OnItemClickListener a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AdapterView.OnItemLongClickListener f1568b;
    private int c;
    private View d;
    private int e;
    private ArrayList<b> f;
    private ArrayList<b> g;
    private ListAdapter h;
    private C0424e i;

    private static class b {
        public View a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ViewGroup f1569b;
        public Object c;
        public boolean d;

        private b() {
        }
    }

    private class c extends FrameLayout {
        public c(Context context) {
            super(context);
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            int paddingLeft = e.this.getPaddingLeft() + getPaddingLeft();
            if (paddingLeft != i) {
                offsetLeftAndRight(paddingLeft - i);
            }
            super.onLayout(z, i, i2, i3, i4);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec((e.this.getMeasuredWidth() - e.this.getPaddingLeft()) - e.this.getPaddingRight(), View.MeasureSpec.getMode(i)), i2);
        }
    }

    private static class d implements WrapperListAdapter, Filterable {
        static final ArrayList<b> k = new ArrayList<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ListAdapter f1570b;
        ArrayList<b> c;
        ArrayList<b> d;
        boolean g;
        private final boolean h;
        private final DataSetObservable a = new DataSetObservable();
        private int e = 1;
        private int f = -1;
        private boolean i = true;
        private boolean j = false;

        public d(ArrayList<b> arrayList, ArrayList<b> arrayList2, ListAdapter listAdapter) {
            this.f1570b = listAdapter;
            this.h = listAdapter instanceof Filterable;
            this.c = arrayList == null ? k : arrayList;
            if (arrayList2 == null) {
                this.d = k;
            } else {
                this.d = arrayList2;
            }
            this.g = a(this.c) && a(this.d);
        }

        private int a() {
            return (int) (Math.ceil((this.f1570b.getCount() * 1.0f) / this.e) * ((double) this.e));
        }

        private boolean a(ArrayList<b> arrayList) {
            if (arrayList == null) {
                return true;
            }
            Iterator<b> it = arrayList.iterator();
            while (it.hasNext()) {
                if (!it.next().d) {
                    return false;
                }
            }
            return true;
        }

        public void a(int i) {
            if (i >= 1 && this.e != i) {
                this.e = i;
                d();
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f1570b;
            return listAdapter == null || (this.g && listAdapter.areAllItemsEnabled());
        }

        public int b() {
            return this.d.size();
        }

        public void b(int i) {
            this.f = i;
        }

        public int c() {
            return this.c.size();
        }

        public void d() {
            this.a.notifyChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f1570b != null ? ((b() + c()) * this.e) + a() : (b() + c()) * this.e;
        }

        @Override // android.widget.Filterable
        public Filter getFilter() {
            if (this.h) {
                return ((Filterable) this.f1570b).getFilter();
            }
            return null;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            int iC = c();
            int i2 = this.e;
            int i3 = iC * i2;
            if (i < i3) {
                if (i % i2 == 0) {
                    return this.c.get(i / i2).c;
                }
                return null;
            }
            int i4 = i - i3;
            int iA = 0;
            if (this.f1570b != null && i4 < (iA = a())) {
                if (i4 < this.f1570b.getCount()) {
                    return this.f1570b.getItem(i4);
                }
                return null;
            }
            int i5 = i4 - iA;
            if (i5 % this.e == 0) {
                return this.d.get(i5).c;
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            int i2;
            int iC = c() * this.e;
            ListAdapter listAdapter = this.f1570b;
            if (listAdapter == null || i < iC || (i2 = i - iC) >= listAdapter.getCount()) {
                return -1L;
            }
            return this.f1570b.getItemId(i2);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i) {
            int iA;
            int i2;
            int iC = c() * this.e;
            ListAdapter listAdapter = this.f1570b;
            int viewTypeCount = listAdapter == null ? 0 : listAdapter.getViewTypeCount() - 1;
            int size = -2;
            if (this.i && i < iC) {
                if (i == 0 && this.j) {
                    size = this.c.size() + viewTypeCount + this.d.size() + 1 + 1;
                }
                int i3 = this.e;
                if (i % i3 != 0) {
                    size = (i / i3) + 1 + viewTypeCount;
                }
            }
            int i4 = i - iC;
            if (this.f1570b != null) {
                iA = a();
                if (i4 >= 0 && i4 < iA) {
                    if (i4 < this.f1570b.getCount()) {
                        size = this.f1570b.getItemViewType(i4);
                    } else if (this.i) {
                        size = this.c.size() + viewTypeCount + 1;
                    }
                }
            } else {
                iA = 0;
            }
            if (this.i && (i2 = i4 - iA) >= 0 && i2 < getCount() && i2 % this.e != 0) {
                size = viewTypeCount + this.c.size() + 1 + (i2 / this.e) + 1;
            }
            if (e.j) {
                Log.d("GridViewHeaderAndFooter", String.format("getItemViewType: pos: %s, result: %s", Integer.valueOf(i), Integer.valueOf(size), Boolean.valueOf(this.i), Boolean.valueOf(this.j)));
            }
            return size;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewGroup viewGroup2;
            int height;
            int iA = 0;
            if (e.j) {
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(i);
                objArr[1] = Boolean.valueOf(view == null);
                Log.d("GridViewHeaderAndFooter", String.format("getView: %s, reused: %s", objArr));
            }
            int iC = c();
            int i2 = this.e;
            int i3 = iC * i2;
            if (i >= i3) {
                int i4 = i - i3;
                if (this.f1570b == null || i4 >= (iA = a())) {
                    int i5 = i4 - iA;
                    if (i5 >= getCount()) {
                        throw new ArrayIndexOutOfBoundsException(i);
                    }
                    viewGroup2 = this.d.get(i5 / this.e).f1569b;
                    if (i % this.e == 0) {
                        return viewGroup2;
                    }
                    if (view == null) {
                        view = new View(viewGroup.getContext());
                    }
                } else {
                    if (i4 < this.f1570b.getCount()) {
                        return this.f1570b.getView(i4, view, viewGroup);
                    }
                    if (view == null) {
                        view = new View(viewGroup.getContext());
                    }
                    view.setVisibility(4);
                    height = this.f;
                }
                view.setMinimumHeight(height);
                return view;
            }
            viewGroup2 = this.c.get(i / i2).f1569b;
            if (i % this.e == 0) {
                return viewGroup2;
            }
            if (view == null) {
                view = new View(viewGroup.getContext());
            }
            view.setVisibility(4);
            height = viewGroup2.getHeight();
            view.setMinimumHeight(height);
            return view;
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            ListAdapter listAdapter = this.f1570b;
            int viewTypeCount = listAdapter == null ? 1 : listAdapter.getViewTypeCount();
            if (this.i) {
                int size = this.c.size() + 1 + this.d.size();
                if (this.j) {
                    size++;
                }
                viewTypeCount += size;
            }
            if (e.j) {
                Log.d("GridViewHeaderAndFooter", String.format("getViewTypeCount: %s", Integer.valueOf(viewTypeCount)));
            }
            return viewTypeCount;
        }

        @Override // android.widget.WrapperListAdapter
        public ListAdapter getWrappedAdapter() {
            return this.f1570b;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            ListAdapter listAdapter = this.f1570b;
            return listAdapter != null && listAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            ListAdapter listAdapter = this.f1570b;
            return listAdapter == null || listAdapter.isEmpty();
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i) {
            int iA;
            int iC = c();
            int i2 = this.e;
            int i3 = iC * i2;
            if (i < i3) {
                return i % i2 == 0 && this.c.get(i / i2).d;
            }
            int i4 = i - i3;
            if (this.f1570b != null) {
                iA = a();
                if (i4 < iA) {
                    return i4 < this.f1570b.getCount() && this.f1570b.isEnabled(i4);
                }
            } else {
                iA = 0;
            }
            int i5 = i4 - iA;
            int i6 = this.e;
            return i5 % i6 == 0 && this.d.get(i5 / i6).d;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.a.registerObserver(dataSetObserver);
            ListAdapter listAdapter = this.f1570b;
            if (listAdapter != null) {
                listAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.a.unregisterObserver(dataSetObserver);
            ListAdapter listAdapter = this.f1570b;
            if (listAdapter != null) {
                listAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    /* JADX INFO: renamed from: com.igaworks.adpopcorn.activity.c.e$e, reason: collision with other inner class name */
    private class C0424e implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
        private C0424e() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            int headerViewCount;
            if (e.this.a == null || (headerViewCount = i - (e.this.getHeaderViewCount() * e.this.getNumColumnsCompatible())) < 0) {
                return;
            }
            e.this.a.onItemClick(adapterView, view, headerViewCount, j);
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            int headerViewCount;
            if (e.this.f1568b == null || (headerViewCount = i - (e.this.getHeaderViewCount() * e.this.getNumColumnsCompatible())) < 0) {
                return true;
            }
            e.this.f1568b.onItemLongClick(adapterView, view, headerViewCount, j);
            return true;
        }
    }

    public e(Context context) {
        super(context);
        this.c = -1;
        this.d = null;
        this.e = -1;
        this.f = new ArrayList<>();
        this.g = new ArrayList<>();
        a();
    }

    private void a() {
    }

    private int getColumnWidthCompatible() {
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getColumnWidth();
        }
        try {
            Field declaredField = GridView.class.getDeclaredField("mColumnWidth");
            declaredField.setAccessible(true);
            return declaredField.getInt(this);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e2) {
            throw new RuntimeException(e2);
        }
    }

    private C0424e getItemClickHandler() {
        if (this.i == null) {
            this.i = new C0424e();
        }
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNumColumnsCompatible() {
        if (Build.VERSION.SDK_INT >= 11) {
            return super.getNumColumns();
        }
        try {
            Field declaredField = GridView.class.getDeclaredField("mNumColumns");
            declaredField.setAccessible(true);
            return declaredField.getInt(this);
        } catch (Exception unused) {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            throw new RuntimeException("Can not determine the mNumColumns for this API platform, please call setNumColumns to set it.");
        }
    }

    public int a(int i) {
        if (i >= 0) {
            return this.f.get(i).a.getMeasuredHeight();
        }
        return 0;
    }

    public void a(View view) {
        a(view, null, true);
    }

    public void a(View view, Object obj, boolean z) {
        ListAdapter adapter = getAdapter();
        if (adapter != null && !(adapter instanceof d)) {
            throw new IllegalStateException("Cannot add header view to grid -- setAdapter has already been called.");
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        b bVar = new b();
        c cVar = new c(getContext());
        if (layoutParams != null) {
            view.setLayoutParams(new FrameLayout.LayoutParams(layoutParams.width, layoutParams.height));
            cVar.setLayoutParams(new AbsListView.LayoutParams(layoutParams.width, layoutParams.height));
        }
        cVar.addView(view);
        bVar.a = view;
        bVar.f1569b = cVar;
        bVar.c = obj;
        bVar.d = z;
        this.g.add(bVar);
        if (adapter != null) {
            ((d) adapter).d();
        }
    }

    public void b(View view) {
        b(view, null, true);
    }

    public void b(View view, Object obj, boolean z) {
        ListAdapter adapter = getAdapter();
        if (adapter != null && !(adapter instanceof d)) {
            throw new IllegalStateException("Cannot add header view to grid -- setAdapter has already been called.");
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        b bVar = new b();
        c cVar = new c(getContext());
        if (layoutParams != null) {
            view.setLayoutParams(new FrameLayout.LayoutParams(layoutParams.width, layoutParams.height));
            cVar.setLayoutParams(new AbsListView.LayoutParams(layoutParams.width, layoutParams.height));
        }
        cVar.addView(view);
        bVar.a = view;
        bVar.f1569b = cVar;
        bVar.c = obj;
        bVar.d = z;
        this.f.add(bVar);
        if (adapter != null) {
            ((d) adapter).d();
        }
    }

    public int getFooterViewCount() {
        return this.g.size();
    }

    public int getHeaderViewCount() {
        return this.f.size();
    }

    @Override // android.widget.GridView
    public int getHorizontalSpacing() {
        int horizontalSpacing;
        try {
            if (Build.VERSION.SDK_INT < 16) {
                Field declaredField = GridView.class.getDeclaredField("mHorizontalSpacing");
                declaredField.setAccessible(true);
                horizontalSpacing = declaredField.getInt(this);
            } else {
                horizontalSpacing = super.getHorizontalSpacing();
            }
            return horizontalSpacing;
        } catch (Exception unused) {
            return 0;
        }
    }

    public ListAdapter getOriginalAdapter() {
        return this.h;
    }

    public int getRowHeight() {
        int i = this.e;
        if (i > 0) {
            return i;
        }
        ListAdapter adapter = getAdapter();
        int numColumnsCompatible = getNumColumnsCompatible();
        if (adapter == null || adapter.getCount() <= (this.f.size() + this.g.size()) * numColumnsCompatible) {
            return -1;
        }
        int columnWidthCompatible = getColumnWidthCompatible();
        View view = getAdapter().getView(numColumnsCompatible * this.f.size(), this.d, this);
        AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new AbsListView.LayoutParams(-1, -2, 0);
            view.setLayoutParams(layoutParams);
        }
        view.measure(GridView.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(columnWidthCompatible, 1073741824), 0, layoutParams.width), GridView.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(0, 0), 0, layoutParams.height));
        this.d = view;
        int measuredHeight = view.getMeasuredHeight();
        this.e = measuredHeight;
        return measuredHeight;
    }

    @Override // android.widget.GridView
    public int getVerticalSpacing() {
        int verticalSpacing;
        try {
            if (Build.VERSION.SDK_INT < 16) {
                Field declaredField = GridView.class.getDeclaredField("mVerticalSpacing");
                declaredField.setAccessible(true);
                verticalSpacing = declaredField.getInt(this);
            } else {
                verticalSpacing = super.getVerticalSpacing();
            }
            return verticalSpacing;
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.d = null;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        ListAdapter adapter = getAdapter();
        if (adapter == null || !(adapter instanceof d)) {
            return;
        }
        d dVar = (d) adapter;
        dVar.a(getNumColumnsCompatible());
        dVar.b(getRowHeight());
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        this.h = listAdapter;
        if (this.f.size() <= 0 && this.g.size() <= 0) {
            super.setAdapter(listAdapter);
            return;
        }
        d dVar = new d(this.f, this.g, listAdapter);
        int numColumnsCompatible = getNumColumnsCompatible();
        if (numColumnsCompatible > 1) {
            dVar.a(numColumnsCompatible);
        }
        dVar.b(getRowHeight());
        super.setAdapter((ListAdapter) dVar);
    }

    @Override // android.view.ViewGroup
    public void setClipChildren(boolean z) {
    }

    public void setClipChildrenSupper(boolean z) {
        super.setClipChildren(false);
    }

    @Override // android.widget.GridView
    public void setNumColumns(int i) {
        super.setNumColumns(i);
        this.c = i;
        ListAdapter adapter = getAdapter();
        if (adapter == null || !(adapter instanceof d)) {
            return;
        }
        ((d) adapter).a(i);
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.a = onItemClickListener;
        super.setOnItemClickListener(getItemClickHandler());
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.f1568b = onItemLongClickListener;
        super.setOnItemLongClickListener(getItemClickHandler());
    }
}
