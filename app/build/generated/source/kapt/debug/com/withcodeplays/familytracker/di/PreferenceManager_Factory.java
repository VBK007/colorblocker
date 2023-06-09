// Generated by Dagger (https://dagger.dev).
package com.withcodeplays.familytracker.di;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class PreferenceManager_Factory implements Factory<PreferenceManager> {
  private final Provider<Context> contextProvider;

  public PreferenceManager_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public PreferenceManager get() {
    return newInstance(contextProvider.get());
  }

  public static PreferenceManager_Factory create(Provider<Context> contextProvider) {
    return new PreferenceManager_Factory(contextProvider);
  }

  public static PreferenceManager newInstance(Context context) {
    return new PreferenceManager(context);
  }
}
