package com.mytracker;

import android.app.Application;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.my.tracker.MyTracker;
import com.my.tracker.MyTrackerConfig;
import com.my.tracker.MyTrackerParams;

import java.util.HashMap;
import java.util.Map;

@ReactModule(name = MytrackerModule.NAME)
public class MytrackerModule extends ReactContextBaseJavaModule {
  public static final String NAME = "MyTracker";
  private final Application application;

  public MytrackerModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.application = (Application) reactContext.getApplicationContext();
  }

  @Override
  @NonNull
  public String getName() {
    return NAME;
  }

  @ReactMethod
  public void initTracker(String SDK_KEY) {
    MyTracker.initTracker(SDK_KEY, application);
  }

  @ReactMethod
  public void trackEvent(String name) {
    MyTracker.trackEvent(name);
  }

  @ReactMethod
  public void trackLoginEvent(String userId, String vkConnectId) {
    MyTracker.trackLoginEvent(userId, vkConnectId);
  }

  @ReactMethod
  public void trackLoginEventWithParams(String userId, String vkConnectId, ReadableMap attributes) {
    Map<String, Object> map = attributes.toHashMap();
    Map<String, String> params = new HashMap<>();
    for (Map.Entry<String, Object> entry : map.entrySet()) {
      if (entry.getValue() instanceof String) {
        params.put(entry.getKey(), (String) entry.getValue());
      }
    }
    MyTracker.trackLoginEvent(userId, vkConnectId, params);
  }

  @ReactMethod
  public void trackEventWithParams(String name, ReadableMap attributes) {
    Map<String, Object> map = attributes.toHashMap();
    Map<String, String> params = new HashMap<>();
    for (Map.Entry<String, Object> entry : map.entrySet()) {
      if (entry.getValue() instanceof String) {
        params.put(entry.getKey(), (String) entry.getValue());
      }
    }
    MyTracker.trackEvent(name, params);
  }

  @ReactMethod
  public void setCustomUserId(String USER_ID) {
    MyTrackerParams trackerParams = MyTracker.getTrackerParams();
    trackerParams.setCustomUserId(USER_ID);
  }

  @ReactMethod
  public void trackInviteEvent() {
    MyTracker.trackInviteEvent();
  }

  @ReactMethod
  public void trackInviteEventWithParams(ReadableMap attributes) {
    Map<String, Object> map = attributes.toHashMap();
    Map<String, String> params = new HashMap<>();
    for (Map.Entry<String, Object> entry : map.entrySet()) {
      if (entry.getValue() instanceof String) {
        params.put(entry.getKey(), (String) entry.getValue());
      }
      MyTracker.trackInviteEvent(params);
    }
  }

  @ReactMethod
  public void flush() {
    MyTracker.flush();
  }

  @ReactMethod
  public void trackRegistrationEvent(String userId, String vkConnectId) {
    MyTracker.trackRegistrationEvent(userId, vkConnectId);
  }

  @ReactMethod
  public void trackRegistrationEventWithParams(String userId, String vkConnectId, ReadableMap attributes) {
    Map<String, Object> map = attributes.toHashMap();
    Map<String, String> params = new HashMap<>();
    for (Map.Entry<String, Object> entry : map.entrySet()) {
      if (entry.getValue() instanceof String) {
        params.put(entry.getKey(), (String) entry.getValue());
      }
    }
    MyTracker.trackRegistrationEvent(userId, vkConnectId, params);
  }

  @ReactMethod
  public void trackLevel() {
    MyTracker.trackLevelEvent();
  }

  @ReactMethod
  public void trackLevelWithLevel(int level) {
    MyTracker.trackLevelEvent(level, (Map<String, String>) null);
  }

  @ReactMethod
  public void trackLevelWithLevelWithParams(int level, ReadableMap attributes) {
    Map<String, Object> map = attributes.toHashMap();
    Map<String, String> params = new HashMap<>();
    for (Map.Entry<String, Object> entry : map.entrySet()) {
      if (entry.getValue() instanceof String) {
        params.put(entry.getKey(), (String) entry.getValue());
      }
    }
    MyTracker.trackLevelEvent(level, params);
  }

  @ReactMethod
  public void trackLaunchEnable(boolean enable) {
    MyTrackerConfig trackerConfig = MyTracker.getTrackerConfig();
    trackerConfig.setTrackingLaunchEnabled(enable);
  }

  @ReactMethod
  public void trackLaunchTimeout(int seconds) {
    MyTrackerConfig trackerConfig = MyTracker.getTrackerConfig();
    trackerConfig.setLaunchTimeout(seconds);
  }

  @ReactMethod
  public void bufferingPeriod(int seconds) {
    MyTrackerConfig trackerConfig = MyTracker.getTrackerConfig();
    trackerConfig.setBufferingPeriod(seconds);
  }

  @ReactMethod
  public void forcingPeriod(int seconds) {
    MyTrackerConfig trackerConfig = MyTracker.getTrackerConfig();
    trackerConfig.setForcingPeriod(seconds);
  }

  @ReactMethod
  public void autotrackPurchase(boolean enable) {
    MyTrackerConfig trackerConfig = MyTracker.getTrackerConfig();
    trackerConfig.setAutotrackingPurchaseEnabled(enable);
  }

  @ReactMethod
  public void trackLocation(int number) {
    MyTrackerConfig trackerConfig = MyTracker.getTrackerConfig();
    if (number == 0) {
      trackerConfig.setTrackingLocationEnabled(false);
    }
    if (number == 1 || number == 2) {
      trackerConfig.setTrackingLocationEnabled(true);
    }
  }

  @ReactMethod
  public void region(int number) {
    MyTrackerConfig trackerConfig = MyTracker.getTrackerConfig();
    if (number == 1) {
      trackerConfig.setRegion(MyTrackerConfig.Region.RU);
    }
    if (number == 2) {
      trackerConfig.setRegion(MyTrackerConfig.Region.EU);
    }
  }

  @ReactMethod
  public void setDebugMode(boolean enable) {
    MyTracker.setDebugMode(enable);
  }
}
