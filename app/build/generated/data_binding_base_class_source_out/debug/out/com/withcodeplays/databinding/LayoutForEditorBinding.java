// Generated by data binding compiler. Do not edit!
package com.withcodeplays.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.withcodeplays.R;
import com.withcodeplays.enuming.FilterAverageStatus;
import ja.burhanrashid52.photoeditor.PhotoEditorView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class LayoutForEditorBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout addImageLayout;

  @NonNull
  public final AppBarLayout appBarLayout;

  @NonNull
  public final Guideline guideline;

  @NonNull
  public final ImageView imgCamera;

  @NonNull
  public final ImageView imgClose;

  @NonNull
  public final ImageView imgGallery;

  @NonNull
  public final ImageView imgRedo;

  @NonNull
  public final ImageView imgSave;

  @NonNull
  public final ImageView imgShare;

  @NonNull
  public final ImageView imgUndo;

  @NonNull
  public final PhotoEditorView photoEditorView;

  @NonNull
  public final RecyclerView rvConstraintTools;

  @NonNull
  public final RecyclerView rvFilterView;

  @NonNull
  public final ConstraintLayout topLayouts;

  @NonNull
  public final TextView txtCurrentTool;

  @NonNull
  public final ImageView userAddImage;

  @Bindable
  protected FilterAverageStatus mActions;

  protected LayoutForEditorBinding(Object _bindingComponent, View _root, int _localFieldCount,
      LinearLayout addImageLayout, AppBarLayout appBarLayout, Guideline guideline,
      ImageView imgCamera, ImageView imgClose, ImageView imgGallery, ImageView imgRedo,
      ImageView imgSave, ImageView imgShare, ImageView imgUndo, PhotoEditorView photoEditorView,
      RecyclerView rvConstraintTools, RecyclerView rvFilterView, ConstraintLayout topLayouts,
      TextView txtCurrentTool, ImageView userAddImage) {
    super(_bindingComponent, _root, _localFieldCount);
    this.addImageLayout = addImageLayout;
    this.appBarLayout = appBarLayout;
    this.guideline = guideline;
    this.imgCamera = imgCamera;
    this.imgClose = imgClose;
    this.imgGallery = imgGallery;
    this.imgRedo = imgRedo;
    this.imgSave = imgSave;
    this.imgShare = imgShare;
    this.imgUndo = imgUndo;
    this.photoEditorView = photoEditorView;
    this.rvConstraintTools = rvConstraintTools;
    this.rvFilterView = rvFilterView;
    this.topLayouts = topLayouts;
    this.txtCurrentTool = txtCurrentTool;
    this.userAddImage = userAddImage;
  }

  public abstract void setActions(@Nullable FilterAverageStatus actions);

  @Nullable
  public FilterAverageStatus getActions() {
    return mActions;
  }

  @NonNull
  public static LayoutForEditorBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.layout_for_editor, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static LayoutForEditorBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<LayoutForEditorBinding>inflateInternal(inflater, R.layout.layout_for_editor, root, attachToRoot, component);
  }

  @NonNull
  public static LayoutForEditorBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.layout_for_editor, null, false, component)
   */
  @NonNull
  @Deprecated
  public static LayoutForEditorBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<LayoutForEditorBinding>inflateInternal(inflater, R.layout.layout_for_editor, null, false, component);
  }

  public static LayoutForEditorBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static LayoutForEditorBinding bind(@NonNull View view, @Nullable Object component) {
    return (LayoutForEditorBinding)bind(component, view, R.layout.layout_for_editor);
  }
}
