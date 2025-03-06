package com.mytracker

import com.facebook.react.module.annotations.ReactModule
import com.facebook.react.bridge.ReactApplicationContext
import android.app.Application
import com.my.tracker.MyTracker
import com.facebook.react.bridge.ReadableMap
import java.util.HashMap

@ReactModule(name = MytrackerModule.NAME)
class MytrackerModule(reactContext: ReactApplicationContext) :
    NativeMytrackerSpec(reactContext) {
    private val application: Application

    init {
        application = reactContext.applicationContext as Application
    }

    override fun getName(): String {
        return NAME
    }

    override fun initTracker(SDK_KEY: String) {
        MyTracker.initTracker(SDK_KEY, application)
    }


   override fun trackEvent(name: String) {
        MyTracker.trackEvent(name)
    }


   override fun trackLoginEvent(userId: String, vkConnectId: String?) {
        MyTracker.trackLoginEvent(userId, vkConnectId)
    }


  override fun trackLoginEventWithParams(userId: String, vkConnectId: String?, attributes: ReadableMap) {
        val map: HashMap<String, Any?> = attributes.toHashMap()
        val params: MutableMap<String, String> = HashMap()
        for ((key, value) in map) {
            if (value is String) {
                params[key] = value
            }
        }
        MyTracker.trackLoginEvent(userId, vkConnectId, params)
    }


   override fun trackEventWithParams(name: String, attributes: ReadableMap) {
        val map: HashMap<String, Any?> = attributes.toHashMap()
        val params: MutableMap<String, String> = HashMap()
        for ((key, value) in map) {
            if (value is String) {
                params[key] = value
            }
        }
        MyTracker.trackEvent(name, params)
    }


   override fun setCustomUserId(USER_ID: String?) {
        val trackerParams = MyTracker.getTrackerParams()
        trackerParams.setCustomUserId(USER_ID)
    }


   override fun trackInviteEvent() {
        MyTracker.trackInviteEvent()
    }


   override fun trackInviteEventWithParams(attributes: ReadableMap) {
        val map: HashMap<String, Any?> = attributes.toHashMap()
        val params: MutableMap<String, String> = HashMap()
        for ((key, value) in map) {
            if (value is String) {
                params[key] = value
            }
            MyTracker.trackInviteEvent(params)
        }
    }


   override fun flush() {
        MyTracker.flush()
    }


   override fun trackRegistrationEvent(userId: String, vkConnectId: String?) {
        MyTracker.trackRegistrationEvent(userId, vkConnectId)
    }


   override fun trackRegistrationEventWithParams(
        userId: String,
        vkConnectId: String?,
        attributes: ReadableMap
    ) {
        val map: HashMap<String, Any?> = attributes.toHashMap()
        val params: MutableMap<String, String> = HashMap()
        for ((key, value) in map) {
            if (value is String) {
                params[key] = value
            }
        }
        MyTracker.trackRegistrationEvent(userId, vkConnectId, params)
    }


   override fun trackLevel() {
        MyTracker.trackLevelEvent()
    }


   override fun trackLevelWithLevel(level: Double) {
        MyTracker.trackLevelEvent(level.toInt(), null as Map<String?, String?>?)
    }


   override fun trackLevelWithLevelWithParams(level: Double, attributes: ReadableMap) {
        val map: HashMap<String, Any?> = attributes.toHashMap()
        val params: MutableMap<String, String> = HashMap()
        for ((key, value) in map) {
            if (value is String) {
                params[key] = value
            }
        }
        MyTracker.trackLevelEvent(level.toInt(), params)
    }


   override fun trackLaunchEnable(enable: Boolean) {
        val trackerConfig = MyTracker.getTrackerConfig()
        trackerConfig.isTrackingLaunchEnabled = enable
    }


   override fun trackLaunchTimeout(seconds: Double) {
        val trackerConfig = MyTracker.getTrackerConfig()
        trackerConfig.launchTimeout = seconds.toInt()
    }


   override fun bufferingPeriod(seconds: Double) {
        val trackerConfig = MyTracker.getTrackerConfig()
        trackerConfig.bufferingPeriod = seconds.toInt()
    }


   override fun forcingPeriod(seconds: Double) {
        val trackerConfig = MyTracker.getTrackerConfig()
        trackerConfig.forcingPeriod = seconds.toInt()
    }


   override fun autotrackPurchase(enable: Boolean) {
        val trackerConfig = MyTracker.getTrackerConfig()
        trackerConfig.isAutotrackingPurchaseEnabled = enable
    }


   override fun trackLocation(number: Double) {
        val trackerConfig = MyTracker.getTrackerConfig()
        trackerConfig.setLocationTrackingMode(number.toInt())
    }


   override fun setDebugMode(enable: Boolean) {
        MyTracker.setDebugMode(enable)
    }

   override fun getInstanceId(): String {
      val id = MyTracker.getInstanceId(reactApplicationContext)
      return id
    }

  companion object {
        const val NAME = "Mytracker"
    }
}
