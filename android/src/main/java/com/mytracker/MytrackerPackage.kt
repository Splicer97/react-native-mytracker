package com.mytracker

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.NativeModule
import com.facebook.react.module.model.ReactModuleInfoProvider

import com.facebook.react.TurboReactPackage
import com.facebook.react.module.model.ReactModuleInfo
import java.util.HashMap

class MytrackerPackage : TurboReactPackage() {

  override fun getModule(name: String, reactContext: ReactApplicationContext): NativeModule? {
    return if (name == MytrackerModule.NAME) {
      MytrackerModule(reactContext)
    } else {
      null
    }
  }

  override fun getReactModuleInfoProvider(): ReactModuleInfoProvider {
    return ReactModuleInfoProvider {
      val moduleInfos: MutableMap<String, ReactModuleInfo> = HashMap()
      moduleInfos[MytrackerModule.NAME] = ReactModuleInfo(
        MytrackerModule.NAME,
        MytrackerModule.NAME,
        false,  // canOverrideExistingModule
        false,  // needsEagerInit
        true,  // hasConstants
        false,  // isCxxModule
        true // isTurboModule
      )
      moduleInfos
    }
  }
}
