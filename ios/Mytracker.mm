#import "Mytracker.h"
#import <MyTrackerSDK/MyTrackerSDK.h>

@implementation Mytracker
RCT_EXPORT_MODULE(MyTracker)

// Example method
// See // https://reactnative.dev/docs/native-modules-ios
RCT_EXPORT_METHOD(initTracker:(NSString *)SDK_KEY)
{
    [MRMyTracker setupTracker:SDK_KEY];
}

RCT_EXPORT_METHOD(trackEvent:(NSString *)name)
{
    [MRMyTracker trackEventWithName:name];
}

RCT_EXPORT_METHOD(trackLoginEvent:(NSString *)userId vkConnectId:(NSString *)vkConnectId)
{
    [MRMyTracker trackLoginEvent:userId withVkConnectId:vkConnectId];
}

RCT_EXPORT_METHOD(trackLoginEventWithParams:(NSString *)userId vkConnectId:(NSString *)vkConnectId eventParams:(nullable NSDictionary *) eventParams)
{
    [MRMyTracker trackLoginEvent:userId  withVkConnectId:vkConnectId params:eventParams];
}

RCT_EXPORT_METHOD(trackEventWithParams:(NSString *)name eventParams:(nullable NSDictionary *) eventParams)
{
    [MRMyTracker trackEventWithName:name eventParams:eventParams];
}

RCT_EXPORT_METHOD(setCustomUserId:(NSString *)USER_ID)
{
    MRMyTrackerParams *trackerParams = [MRMyTracker trackerParams];
    trackerParams.customUserId = USER_ID;
}

RCT_EXPORT_METHOD(trackLaunchEnable:(BOOL *)enable)
{
    MRMyTrackerConfig *trackerConfig = [MRMyTracker trackerConfig];
    trackerConfig.trackLaunch = enable;
}

RCT_EXPORT_METHOD(trackInviteEvent)
{
   [MRMyTracker trackInviteEvent];
}

RCT_EXPORT_METHOD(trackInviteEventWithParams:(nullable NSDictionary *) eventParams)
{
    [MRMyTracker trackInviteEventWithParams:eventParams];
}

RCT_EXPORT_METHOD(flush)
{
    [MRMyTracker flush];
}

RCT_EXPORT_METHOD(trackRegistrationEvent:(NSString *)userId vkConnectId:(NSString *)vkConnectId)
{
    [MRMyTracker trackRegistrationEvent:userId withVkConnectId:vkConnectId];
}

RCT_EXPORT_METHOD(trackRegistrationEventWithParams:(NSString *)userId vkConnectId:(NSString *)vkConnectId eventParams:(nullable NSDictionary *) eventParams)
{
    [MRMyTracker trackRegistrationEvent:userId  withVkConnectId:vkConnectId params:eventParams];
}

RCT_EXPORT_METHOD(trackLevel)
{
    [MRMyTracker trackLevelAchieved];
}

RCT_EXPORT_METHOD(trackLevelWithLevel:(nonnull NSNumber *)level)
{
  [MRMyTracker trackLevelAchievedWithLevel:level];
}

RCT_EXPORT_METHOD(trackLevelWithLevelWithParams:(nonnull NSNumber *)level params:(nullable NSDictionary *)params)
{
  [MRMyTracker trackLevelAchievedWithLevel:level eventParams:params];
}

RCT_EXPORT_METHOD(trackLaunchTimeout:(double)seconds)
{
    MRMyTrackerConfig *trackerConfig = [MRMyTracker trackerConfig];
    trackerConfig.launchTimeout = seconds;
}

RCT_EXPORT_METHOD(bufferingPeriod:(double)seconds)
{
    MRMyTrackerConfig *trackerConfig = [MRMyTracker trackerConfig];
    trackerConfig.bufferingPeriod = seconds;
}

RCT_EXPORT_METHOD(forcingPeriod:(double)seconds)
{
    MRMyTrackerConfig *trackerConfig = [MRMyTracker trackerConfig];
    trackerConfig.forcingPeriod = seconds;
}

RCT_EXPORT_METHOD(autotrackPurchase:(BOOL *)enable)
{
    MRMyTrackerConfig *trackerConfig = [MRMyTracker trackerConfig];
    trackerConfig.autotrackPurchase = enable;
}

RCT_EXPORT_METHOD(trackLocation:(double)number)
{
    MRMyTrackerConfig *trackerConfig = [MRMyTracker trackerConfig];
    if(number == 0) {
        trackerConfig.locationTrackingMode = MRLocationTrackingModeNone;
    }
    if (number == 1) {
        trackerConfig.locationTrackingMode = MRLocationTrackingModeCached;
    }
    if (number == 2) {
        trackerConfig.locationTrackingMode = MRLocationTrackingModeActive;
    }
}

RCT_EXPORT_METHOD(region:(double)number)
{
    MRMyTrackerConfig *trackerConfig = [MRMyTracker trackerConfig];
    if(number == 0) {
        trackerConfig.region = MRRegionNotSet;
    }
    if (number == 1) {
        trackerConfig.region = MRRegionRu;
    }
    if (number == 2) {
        trackerConfig.region = MRRegionEu;
    }
}

RCT_EXPORT_METHOD(setDebugMode:(BOOL *)enable)
{
  [MRMyTracker setDebugMode:enable];
}

// Don't compile this code when we build for the old architecture.
#ifdef RCT_NEW_ARCH_ENABLED
- (std::shared_ptr<facebook::react::TurboModule>)getTurboModule:
    (const facebook::react::ObjCTurboModule::InitParams &)params
{
    return std::make_shared<facebook::react::NativeMytrackerSpecJSI>(params);
}
#endif

@end
