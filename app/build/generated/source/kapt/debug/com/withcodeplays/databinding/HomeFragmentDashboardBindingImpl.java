package com.withcodeplays.databinding;
import com.withcodeplays.R;
import com.withcodeplays.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class HomeFragmentDashboardBindingImpl extends HomeFragmentDashboardBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.appBarLayout, 4);
        sViewsWithIds.put(R.id.mainRecyler, 5);
        sViewsWithIds.put(R.id.btnRetry, 6);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @NonNull
    private final androidx.core.widget.NestedScrollView mboundView1;
    @NonNull
    private final android.widget.LinearLayout mboundView3;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public HomeFragmentDashboardBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private HomeFragmentDashboardBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.appbar.AppBarLayout) bindings[4]
            , (android.widget.Button) bindings[6]
            , (androidx.recyclerview.widget.RecyclerView) bindings[5]
            , (android.widget.ProgressBar) bindings[2]
            );
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (androidx.core.widget.NestedScrollView) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView3 = (android.widget.LinearLayout) bindings[3];
        this.mboundView3.setTag(null);
        this.progressBar.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.actions == variableId) {
            setActions((com.withcodeplays.enuming.FilterAverageStatus) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setActions(@Nullable com.withcodeplays.enuming.FilterAverageStatus Actions) {
        this.mActions = Actions;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.actions);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        com.withcodeplays.enuming.FilterAverageStatus actions = mActions;
        int actionsFilterAverageStatusShowDataViewVISIBLEViewGONE = 0;
        boolean actionsFilterAverageStatusShowData = false;
        int actionsFilterAverageStatusLoaderViewVISIBLEViewGONE = 0;
        boolean actionsFilterAverageStatusLoader = false;
        boolean actionsFilterAverageStatusNoData = false;
        int actionsFilterAverageStatusNoDataViewVISIBLEViewGONE = 0;

        if ((dirtyFlags & 0x3L) != 0) {



                // read actions == FilterAverageStatus.ShowData
                actionsFilterAverageStatusShowData = (actions) == (com.withcodeplays.enuming.FilterAverageStatus.ShowData);
                // read actions == FilterAverageStatus.Loader
                actionsFilterAverageStatusLoader = (actions) == (com.withcodeplays.enuming.FilterAverageStatus.Loader);
                // read actions == FilterAverageStatus.NoData
                actionsFilterAverageStatusNoData = (actions) == (com.withcodeplays.enuming.FilterAverageStatus.NoData);
            if((dirtyFlags & 0x3L) != 0) {
                if(actionsFilterAverageStatusShowData) {
                        dirtyFlags |= 0x8L;
                }
                else {
                        dirtyFlags |= 0x4L;
                }
            }
            if((dirtyFlags & 0x3L) != 0) {
                if(actionsFilterAverageStatusLoader) {
                        dirtyFlags |= 0x20L;
                }
                else {
                        dirtyFlags |= 0x10L;
                }
            }
            if((dirtyFlags & 0x3L) != 0) {
                if(actionsFilterAverageStatusNoData) {
                        dirtyFlags |= 0x80L;
                }
                else {
                        dirtyFlags |= 0x40L;
                }
            }


                // read actions == FilterAverageStatus.ShowData ? View.VISIBLE : View.GONE
                actionsFilterAverageStatusShowDataViewVISIBLEViewGONE = ((actionsFilterAverageStatusShowData) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
                // read actions == FilterAverageStatus.Loader ? View.VISIBLE : View.GONE
                actionsFilterAverageStatusLoaderViewVISIBLEViewGONE = ((actionsFilterAverageStatusLoader) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
                // read actions == FilterAverageStatus.NoData ? View.VISIBLE : View.GONE
                actionsFilterAverageStatusNoDataViewVISIBLEViewGONE = ((actionsFilterAverageStatusNoData) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            this.mboundView1.setVisibility(actionsFilterAverageStatusShowDataViewVISIBLEViewGONE);
            this.mboundView3.setVisibility(actionsFilterAverageStatusNoDataViewVISIBLEViewGONE);
            this.progressBar.setVisibility(actionsFilterAverageStatusLoaderViewVISIBLEViewGONE);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): actions
        flag 1 (0x2L): null
        flag 2 (0x3L): actions == FilterAverageStatus.ShowData ? View.VISIBLE : View.GONE
        flag 3 (0x4L): actions == FilterAverageStatus.ShowData ? View.VISIBLE : View.GONE
        flag 4 (0x5L): actions == FilterAverageStatus.Loader ? View.VISIBLE : View.GONE
        flag 5 (0x6L): actions == FilterAverageStatus.Loader ? View.VISIBLE : View.GONE
        flag 6 (0x7L): actions == FilterAverageStatus.NoData ? View.VISIBLE : View.GONE
        flag 7 (0x8L): actions == FilterAverageStatus.NoData ? View.VISIBLE : View.GONE
    flag mapping end*/
    //end
}