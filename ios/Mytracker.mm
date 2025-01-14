#import "Mytracker.h"
#import <MyTrackerSDK/MyTrackerSDK.h>

@implementation Mytracker
RCT_EXPORT_MODULE()

- (void)initTracker:(NSString *)SDK_KEY
{
    [MRMyTracker setupTracker:SDK_KEY];
}

- (void)trackEvent:(NSString *)name
{
    [MRMyTracker trackEventWithName:name];
}

- (void)trackLoginEvent:(NSString *)userId vkConnectId:(NSString *)vkConnectId
{
    [MRMyTracker trackLoginEvent:userId withVkConnectId:vkConnectId];
}

- (void)trackLoginEventWithParams:(NSString *)userId vkConnectId:(NSString *)vkConnectId eventParams:(nullable NSDictionary *) eventParams
{
    [MRMyTracker trackLoginEvent:userId  withVkConnectId:vkConnectId params:eventParams];
}

- (void)trackEventWithParams:(NSString *)name eventParams:(nullable NSDictionary *) eventParams
{
    [MRMyTracker trackEventWithName:name eventParams:eventParams];
}

- (void)setCustomUserId:(NSString *)USER_ID
{
    MRMyTrackerParams *trackerParams = [MRMyTracker trackerParams];
    trackerParams.customUserId = USER_ID;
}

- (void)trackLaunchEnable:(BOOL)enable
{
    MRMyTrackerConfig *trackerConfig = [MRMyTracker trackerConfig];
    trackerConfig.trackLaunch = enable;
}

- (void)trackInviteEvent
{
   [MRMyTracker trackInviteEvent];
}

- (void)trackInviteEventWithParams:(nullable NSDictionary *) eventParams
{
    [MRMyTracker trackInviteEventWithParams:eventParams];
}

- (void)flush
{
    [MRMyTracker flush];
}

- (void)trackRegistrationEvent:(NSString *)userId vkConnectId:(NSString *)vkConnectId
{
    [MRMyTracker trackRegistrationEvent:userId withVkConnectId:vkConnectId];
}

- (void)trackRegistrationEventWithParams:(NSString *)userId vkConnectId:(NSString *)vkConnectId eventParams:(nullable NSDictionary *) eventParams
{
    [MRMyTracker trackRegistrationEvent:userId  withVkConnectId:vkConnectId params:eventParams];
}

- (void)trackLevel
{
    [MRMyTracker trackLevelAchieved];
}

- (void)trackLevelWithLevel:(nonnull NSNumber *)level
{
  [MRMyTracker trackLevelAchievedWithLevel:level];
}

- (void)trackLevelWithLevelWithParams:(nonnull NSNumber *)level params:(nullable NSDictionary *)params
{
  [MRMyTracker trackLevelAchievedWithLevel:level eventParams:params];
}

- (void)trackLaunchTimeout:(double)seconds
{
    MRMyTrackerConfig *trackerConfig = [MRMyTracker trackerConfig];
    trackerConfig.launchTimeout = seconds;
}

- (void)bufferingPeriod:(double)seconds
{
    MRMyTrackerConfig *trackerConfig = [MRMyTracker trackerConfig];
    trackerConfig.bufferingPeriod = seconds;
}

- (void)forcingPeriod:(double)seconds
{
    MRMyTrackerConfig *trackerConfig = [MRMyTracker trackerConfig];
    trackerConfig.forcingPeriod = seconds;
}

- (void)autotrackPurchase:(BOOL)enable
{
    MRMyTrackerConfig *trackerConfig = [MRMyTracker trackerConfig];
    trackerConfig.autotrackPurchase = enable;
}

- (void)trackLocation:(double)number
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

- (void)setDebugMode:(BOOL)enable
{
  [MRMyTracker setDebugMode:enable];
}



- (NSString *)getInstanceId
{

    NSString *instanceId = [MRMyTracker instanceId];

    return instanceId;
}



- (std::shared_ptr<facebook::react::TurboModule>)getTurboModule:
    (const facebook::react::ObjCTurboModule::InitParams &)params
{
    return std::make_shared<facebook::react::NativeMytrackerSpecJSI>(params);
}

@end
