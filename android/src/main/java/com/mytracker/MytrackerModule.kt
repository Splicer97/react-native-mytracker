package com.mytracker

import com.facebook.react.module.annotations.ReactModule
import com.mytracker.MytrackerModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import android.app.Application
import com.facebook.react.bridge.ReactMethod
import com.my.tracker.MyTracker
import com.facebook.react.bridge.ReadableMap
import java.util.HashMap
import com.my.tracker.MyTrackerParams
import com.my.tracker.MyTrackerConfig

@ReactModule(name = MytrackerModule.NAME)
class MytrackerModule(reactContext: ReactApplicationContext) :
    ReactContextBaseJavaModule(reactContext) {
    private val application: Application

    init {
        application = reactContext.applicationContext as Application
    }

    override fun getName(): String {
        return NAME
    }

    @ReactMethod
    fun initTracker(SDK_KEY: String?) {
        MyTracker.initTracker(SDK_KEY, application)
    }

    @ReactMethod
    fun trackEvent(name: String?) {
        MyTracker.trackEvent(name)
    }

    @ReactMethod
    fun trackLoginEvent(userId: String?, vkConnectId: String?) {
        MyTracker.trackLoginEvent(userId, vkConnectId)
    }

    @ReactMethod
    fun trackLoginEventWithParams(userId: String?, vkConnectId: String?, attributes: ReadableMap) {
        val map: Map<String, Any> = attributes.toHashMap()
        val params: MutableMap<String, String> = HashMap()
        for ((key, value) in map) {
            if (value is String) {
                params[key] = value
            }
        }
        MyTracker.trackLoginEvent(userId, vkConnectId, params)
    }

    @ReactMethod
    fun trackEventWithParams(name: String?, attributes: ReadableMap) {
        val map: Map<String, Any> = attributes.toHashMap()
        val params: MutableMap<String, String> = HashMap()
        for ((key, value) in map) {
            if (value is String) {
                params[key] = value
            }
        }
        MyTracker.trackEvent(name, params)
    }

    @ReactMethod
    fun setCustomUserId(USER_ID: String?) {
        val trackerParams = MyTracker.getTrackerParams()
        trackerParams.customUserId = USER_ID
    }

    @ReactMethod
    fun trackInviteEvent() {
        MyTracker.trackInviteEvent()
    }

    @ReactMethod
    fun trackInviteEventWithParams(attributes: ReadableMap) {
        val map: Map<String, Any> = attributes.toHashMap()
        val params: MutableMap<String, String> = HashMap()
        for ((key, value) in map) {
            if (value is String) {
                params[key] = value
            }
            MyTracker.trackInviteEvent(params)
        }
    }

    @ReactMethod
    fun flush() {
        MyTracker.flush()
    }

    @ReactMethod
    fun trackRegistrationEvent(userId: String?, vkConnectId: String?) {
        MyTracker.trackRegistrationEvent(userId, vkConnectId)
    }

    @ReactMethod
    fun trackRegistrationEventWithParams(
        userId: String?,
        vkConnectId: String?,
        attributes: ReadableMap
    ) {
        val map: Map<String, Any> = attributes.toHashMap()
        val params: MutableMap<String, String> = HashMap()
        for ((key, value) in map) {
            if (value is String) {
                params[key] = value
            }
        }
        MyTracker.trackRegistrationEvent(userId, vkConnectId, params)
    }

    @ReactMethod
    fun trackLevel() {
        MyTracker.trackLevelEvent()
    }

    @ReactMethod
    fun trackLevelWithLevel(level: Int) {
        MyTracker.trackLevelEvent(level, null as Map<String?, String?>?)
    }

    @ReactMethod
    fun trackLevelWithLevelWithParams(level: Int, attributes: ReadableMap) {
        val map: Map<String, Any> = attributes.toHashMap()
        val params: MutableMap<String, String> = HashMap()
        for ((key, value) in map) {
            if (value is String) {
                params[key] = value
            }
        }
        MyTracker.trackLevelEvent(level, params)
    }

    @ReactMethod
    fun trackLaunchEnable(enable: Boolean) {
        val trackerConfig = MyTracker.getTrackerConfig()
        trackerConfig.isTrackingLaunchEnabled = enable
    }

    @ReactMethod
    fun trackLaunchTimeout(seconds: Int) {
        val trackerConfig = MyTracker.getTrackerConfig()
        trackerConfig.launchTimeout = seconds
    }

    @ReactMethod
    fun bufferingPeriod(seconds: Int) {
        val trackerConfig = MyTracker.getTrackerConfig()
        trackerConfig.bufferingPeriod = seconds
    }

    @ReactMethod
    fun forcingPeriod(seconds: Int) {
        val trackerConfig = MyTracker.getTrackerConfig()
        trackerConfig.forcingPeriod = seconds
    }

    @ReactMethod
    fun autotrackPurchase(enable: Boolean) {
        val trackerConfig = MyTracker.getTrackerConfig()
        trackerConfig.isAutotrackingPurchaseEnabled = enable
    }

    @ReactMethod
    fun trackLocation(number: Int) {
        val trackerConfig = MyTracker.getTrackerConfig()
        if (number == 0) {
            trackerConfig.isTrackingLocationEnabled = false
        }
        if (number == 1 || number == 2) {
            trackerConfig.isTrackingLocationEnabled = true
        }
    }

    @ReactMethod
    fun region(number: Int) {
        val trackerConfig = MyTracker.getTrackerConfig()
        if (number == 1) {
            trackerConfig.setRegion(MyTrackerConfig.Region.RU)
        }
        if (number == 2) {
            trackerConfig.setRegion(MyTrackerConfig.Region.EU)
        }
    }

    @ReactMethod
    fun setDebugMode(enable: Boolean) {
        MyTracker.setDebugMode(enable)
    }

    companion object {
        const val NAME = "MyTracker"
    }
}
