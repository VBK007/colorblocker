package com.withcodeplays.databinding;
import com.withcodeplays.R;
import com.withcodeplays.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityEditImageBindingImpl extends ActivityEditImageBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.appBarLayout, 3);
        sViewsWithIds.put(R.id.userAddImage, 4);
        sViewsWithIds.put(R.id.guideline, 5);
        sViewsWithIds.put(R.id.photoEditorView, 6);
        sViewsWithIds.put(R.id.imgUndo, 7);
        sViewsWithIds.put(R.id.imgRedo, 8);
        sViewsWithIds.put(R.id.imgGallery, 9);
        sViewsWithIds.put(R.id.imgCamera, 10);
        sViewsWithIds.put(R.id.imgClose, 11);
        sViewsWithIds.put(R.id.rvConstraintTools, 12);
        sViewsWithIds.put(R.id.rvFilterView, 13);
        sViewsWithIds.put(R.id.txtCurrentTool, 14);
        sViewsWithIds.put(R.id.imgSave, 15);
        sViewsWithIds.put(R.id.imgShare, 16);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityEditImageBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 17, sIncludes, sViewsWithIds));
    }
    private ActivityEditImageBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.LinearLayout) bindings[1]
            , (com.google.android.material.appbar.AppBarLayout) bindings[3]
            , (androidx.constraintlayout.widget.Guideline) bindings[5]
            , (android.widget.ImageView) bindings[10]
            , (android.widget.ImageView) bindings[11]
            , (android.widget.ImageView) bindings[9]
            , (android.widget.ImageView) bindings[8]
            , (android.widget.ImageView) bindings[15]
            , (android.widget.ImageView) bindings[16]
            , (android.widget.ImageView) bindings[7]
            , (ja.burhanrashid52.photoeditor.PhotoEditorView) bindings[6]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[2]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[0]
            , (androidx.recyclerview.widget.RecyclerView) bindings[12]
            , (androidx.recyclerview.widget.RecyclerView) bindings[13]
            , (android.widget.TextView) bindings[14]
            , (android.widget.ImageView) bindings[4]
            );
        this.addImageLayout.setTag(null);
        this.rootView.setTag(null);
        this.rootViews.setTag(null);
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
        int actionsFilterAverageStatusShowDataViewVISIBLEViewGONE = 0;
        boolean actionsFilterAverageStatusShowData = false;
        boolean actionsFilterAverageStatusNoData = false;
        int actionsFilterAverageStatusNoDataViewVISIBLEViewGONE = 0;
        com.withcodeplays.enuming.FilterAverageStatus actions = mActions;

        if ((dirtyFlags & 0x3L) != 0) {



                // read actions == FilterAverageStatus.ShowData
                actionsFilterAverageStatusShowData = (actions) == (com.withcodeplays.enuming.FilterAverageStatus.ShowData);
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
                if(actionsFilterAverageStatusNoData) {
                        dirtyFlags |= 0x20L;
                }
                else {
                        dirtyFlags |= 0x10L;
                }
            }


                // read actions == FilterAverageStatus.ShowData ? View.VISIBLE : View.GONE
                actionsFilterAverageStatusShowDataViewVISIBLEViewGONE = ((actionsFilterAverageStatusShowData) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
                // read actions == FilterAverageStatus.NoData ? View.VISIBLE : View.GONE
                actionsFilterAverageStatusNoDataViewVISIBLEViewGONE = ((actionsFilterAverageStatusNoData) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            this.addImageLayout.setVisibility(actionsFilterAverageStatusNoDataViewVISIBLEViewGONE);
            this.rootView.setVisibility(actionsFilterAverageStatusShowDataViewVISIBLEViewGONE);
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
        flag 4 (0x5L): actions == FilterAverageStatus.NoData ? View.VISIBLE : View.GONE
        flag 5 (0x6L): actions == FilterAverageStatus.NoData ? View.VISIBLE : View.GONE
    flag mapping end*/
    //end
}