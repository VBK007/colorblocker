package com.withcodeplays;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.withcodeplays.databinding.ActivityEditImageBindingImpl;
import com.withcodeplays.databinding.ActivityMainBindingImpl;
import com.withcodeplays.databinding.BottomAddPhoneNumberBindingImpl;
import com.withcodeplays.databinding.GridTypeRecylserviewBindingImpl;
import com.withcodeplays.databinding.HomeFragmentDashboardBindingImpl;
import com.withcodeplays.databinding.ImagelistBindingImpl;
import com.withcodeplays.databinding.LayoutForEditorBindingImpl;
import com.withcodeplays.databinding.LayoutForProfileBindingImpl;
import com.withcodeplays.databinding.ListTypeRecylervirewLayoutBindingImpl;
import com.withcodeplays.databinding.OnboardingBindingImpl;
import com.withcodeplays.databinding.SplashBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYEDITIMAGE = 1;

  private static final int LAYOUT_ACTIVITYMAIN = 2;

  private static final int LAYOUT_BOTTOMADDPHONENUMBER = 3;

  private static final int LAYOUT_GRIDTYPERECYLSERVIEW = 4;

  private static final int LAYOUT_HOMEFRAGMENTDASHBOARD = 5;

  private static final int LAYOUT_IMAGELIST = 6;

  private static final int LAYOUT_LAYOUTFOREDITOR = 7;

  private static final int LAYOUT_LAYOUTFORPROFILE = 8;

  private static final int LAYOUT_LISTTYPERECYLERVIREWLAYOUT = 9;

  private static final int LAYOUT_ONBOARDING = 10;

  private static final int LAYOUT_SPLASH = 11;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(11);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.withcodeplays.R.layout.activity_edit_image, LAYOUT_ACTIVITYEDITIMAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.withcodeplays.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.withcodeplays.R.layout.bottom_add_phone_number, LAYOUT_BOTTOMADDPHONENUMBER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.withcodeplays.R.layout.grid_type_recylserview, LAYOUT_GRIDTYPERECYLSERVIEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.withcodeplays.R.layout.home_fragment_dashboard, LAYOUT_HOMEFRAGMENTDASHBOARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.withcodeplays.R.layout.imagelist, LAYOUT_IMAGELIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.withcodeplays.R.layout.layout_for_editor, LAYOUT_LAYOUTFOREDITOR);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.withcodeplays.R.layout.layout_for_profile, LAYOUT_LAYOUTFORPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.withcodeplays.R.layout.list_type_recylervirew_layout, LAYOUT_LISTTYPERECYLERVIREWLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.withcodeplays.R.layout.onboarding, LAYOUT_ONBOARDING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.withcodeplays.R.layout.splash, LAYOUT_SPLASH);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYEDITIMAGE: {
          if ("layout/activity_edit_image_0".equals(tag)) {
            return new ActivityEditImageBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_edit_image is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_BOTTOMADDPHONENUMBER: {
          if ("layout/bottom_add_phone_number_0".equals(tag)) {
            return new BottomAddPhoneNumberBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for bottom_add_phone_number is invalid. Received: " + tag);
        }
        case  LAYOUT_GRIDTYPERECYLSERVIEW: {
          if ("layout/grid_type_recylserview_0".equals(tag)) {
            return new GridTypeRecylserviewBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for grid_type_recylserview is invalid. Received: " + tag);
        }
        case  LAYOUT_HOMEFRAGMENTDASHBOARD: {
          if ("layout/home_fragment_dashboard_0".equals(tag)) {
            return new HomeFragmentDashboardBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for home_fragment_dashboard is invalid. Received: " + tag);
        }
        case  LAYOUT_IMAGELIST: {
          if ("layout/imagelist_0".equals(tag)) {
            return new ImagelistBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for imagelist is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTFOREDITOR: {
          if ("layout/layout_for_editor_0".equals(tag)) {
            return new LayoutForEditorBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_for_editor is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTFORPROFILE: {
          if ("layout/layout_for_profile_0".equals(tag)) {
            return new LayoutForProfileBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_for_profile is invalid. Received: " + tag);
        }
        case  LAYOUT_LISTTYPERECYLERVIREWLAYOUT: {
          if ("layout/list_type_recylervirew_layout_0".equals(tag)) {
            return new ListTypeRecylervirewLayoutBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for list_type_recylervirew_layout is invalid. Received: " + tag);
        }
        case  LAYOUT_ONBOARDING: {
          if ("layout/onboarding_0".equals(tag)) {
            return new OnboardingBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for onboarding is invalid. Received: " + tag);
        }
        case  LAYOUT_SPLASH: {
          if ("layout/splash_0".equals(tag)) {
            return new SplashBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for splash is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(3);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "actions");
      sKeys.put(2, "showProgress");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(11);

    static {
      sKeys.put("layout/activity_edit_image_0", com.withcodeplays.R.layout.activity_edit_image);
      sKeys.put("layout/activity_main_0", com.withcodeplays.R.layout.activity_main);
      sKeys.put("layout/bottom_add_phone_number_0", com.withcodeplays.R.layout.bottom_add_phone_number);
      sKeys.put("layout/grid_type_recylserview_0", com.withcodeplays.R.layout.grid_type_recylserview);
      sKeys.put("layout/home_fragment_dashboard_0", com.withcodeplays.R.layout.home_fragment_dashboard);
      sKeys.put("layout/imagelist_0", com.withcodeplays.R.layout.imagelist);
      sKeys.put("layout/layout_for_editor_0", com.withcodeplays.R.layout.layout_for_editor);
      sKeys.put("layout/layout_for_profile_0", com.withcodeplays.R.layout.layout_for_profile);
      sKeys.put("layout/list_type_recylervirew_layout_0", com.withcodeplays.R.layout.list_type_recylervirew_layout);
      sKeys.put("layout/onboarding_0", com.withcodeplays.R.layout.onboarding);
      sKeys.put("layout/splash_0", com.withcodeplays.R.layout.splash);
    }
  }
}
