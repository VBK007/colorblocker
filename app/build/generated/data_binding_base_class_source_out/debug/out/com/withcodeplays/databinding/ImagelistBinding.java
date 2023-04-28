// Generated by data binding compiler. Do not edit!
package com.withcodeplays.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.withcodeplays.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ImagelistBinding extends ViewDataBinding {
  @NonNull
  public final ImageView localImages;

  protected ImagelistBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView localImages) {
    super(_bindingComponent, _root, _localFieldCount);
    this.localImages = localImages;
  }

  @NonNull
  public static ImagelistBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.imagelist, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ImagelistBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ImagelistBinding>inflateInternal(inflater, R.layout.imagelist, root, attachToRoot, component);
  }

  @NonNull
  public static ImagelistBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.imagelist, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ImagelistBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ImagelistBinding>inflateInternal(inflater, R.layout.imagelist, null, false, component);
  }

  public static ImagelistBinding bind(@NonNull View view) {
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
  public static ImagelistBinding bind(@NonNull View view, @Nullable Object component) {
    return (ImagelistBinding)bind(component, view, R.layout.imagelist);
  }
}
