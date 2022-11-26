import { NativeModules } from 'react-native';

interface IMyTracker {
  initTracker(SDK_KEY: string): void;
  trackEvent(name: string): void;
  trackEventWithParams(name: string, attributes: Object): void;
  setCustomUserId(USER_ID: string): void;
  trackLoginEvent(userId: string, vkConnectId?: string): void;
  trackLoginEventWithParams(
    userId: string,
    vkConnectId: string,
    attributes: Object
  ): void;
  trackInviteEvent(): void;
  trackInviteEventWithParams(attributes: Object): void;
  flush(): void;
  trackRegistrationEvent(userId: string, vkConnectId?: string): void;
  trackRegistrationEventWithParams(
    userId: string,
    vkConnectId: string,
    attributes: Object
  ): void;
  trackLevel(): void;
  trackLevelWithLevel(level: number): void;
  trackLevelWithLevelWithParams(level: number, params: Object): void;
  trackLaunchEnable(enable: boolean): void;
  trackLaunchTimeout(seconds: number): void;
  bufferingPeriod(seconds: number): void;
  forcingPeriod(seconds: number): void;
  autotrackPurchase(enable: boolean): void;
  trackLocation(number: 0 | 1 | 2): void;
  region(region: 0 | 1 | 2): void;
  setDebugMode(enable: boolean): void;
}
const MyTracker: IMyTracker = NativeModules.MyTracker;
export default MyTracker;
