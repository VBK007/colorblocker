// Generated by data binding compiler. Do not edit!
package com.withcodeplays.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.withcodeplays.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class BottomAddPhoneNumberBinding extends ViewDataBinding {
  @NonNull
  public final Button btnCancel;

  @NonNull
  public final Button btnOk;

  @NonNull
  public final RelativeLayout editNickName;

  @NonNull
  public final EditText etNickName;

  @NonNull
  public final TextView txtHint;

  @Bindable
  protected Boolean mShowProgress;

  protected BottomAddPhoneNumberBinding(Object _bindingComponent, View _root, int _localFieldCount,
      Button btnCancel, Button btnOk, RelativeLayout editNickName, EditText etNickName,
      TextView txtHint) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnCancel = btnCancel;
    this.btnOk = btnOk;
    this.editNickName = editNickName;
    this.etNickName = etNickName;
    this.txtHint = txtHint;
  }

  public abstract void setShowProgress(@Nullable Boolean showProgress);

  @Nullable
  public Boolean getShowProgress() {
    return mShowProgress;
  }

  @NonNull
  public static BottomAddPhoneNumberBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.bottom_add_phone_number, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static BottomAddPhoneNumberBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<BottomAddPhoneNumberBinding>inflateInternal(inflater, R.layout.bottom_add_phone_number, root, attachToRoot, component);
  }

  @NonNull
  public static BottomAddPhoneNumberBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.bottom_add_phone_number, null, false, component)
   */
  @NonNull
  @Deprecated
  public static BottomAddPhoneNumberBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<BottomAddPhoneNumberBinding>inflateInternal(inflater, R.layout.bottom_add_phone_number, null, false, component);
  }

  public static BottomAddPhoneNumberBinding bind(@NonNull View view) {
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
  public static BottomAddPhoneNumberBinding bind(@NonNull View view, @Nullable Object component) {
    return (BottomAddPhoneNumberBinding)bind(component, view, R.layout.bottom_add_phone_number);
  }
}
