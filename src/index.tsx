import type { Spec } from './NativeMytracker';

const MyTracker: Spec = require('./NativeMytracker').default;

function initTracker(SDK_KEY: string): void {
  return MyTracker.initTracker(SDK_KEY);
}

function trackEvent(name: string): void {
  return MyTracker.trackEvent(name);
}

function trackEventWithParams(name: string, attributes: Object): void {
  return MyTracker.trackEventWithParams(name, attributes);
}

function setCustomUserId(USER_ID: string): void {
  return MyTracker.setCustomUserId(USER_ID);
}

function trackLoginEvent(userId: string, vkConnectId: string): void {
  return MyTracker.trackLoginEvent(userId, vkConnectId);
}

function trackLoginEventWithParams(
  userId: string,
  vkConnectId: string,
  attributes: Object
): void {
  return MyTracker.trackLoginEventWithParams(userId, vkConnectId, attributes);
}

function trackInviteEvent(): void {
  return MyTracker.trackInviteEvent();
}

function trackInviteEventWithParams(attributes: Object): void {
  return MyTracker.trackInviteEventWithParams(attributes);
}

function flush(): void {
  return MyTracker.flush();
}

function trackRegistrationEvent(userId: string, vkConnectId: string): void {
  return MyTracker.trackRegistrationEvent(userId, vkConnectId);
}

function trackRegistrationEventWithParams(
  userId: string,
  vkConnectId: string,
  attributes: Object
): void {
  return MyTracker.trackRegistrationEventWithParams(
    userId,
    vkConnectId,
    attributes
  );
}

function trackLevel(): void {
  return MyTracker.trackLevel();
}

function trackLevelWithLevel(level: number): void {
  return MyTracker.trackLevelWithLevel(level);
}

function trackLevelWithLevelWithParams(level: number, params: Object): void {
  return MyTracker.trackLevelWithLevelWithParams(level, params);
}

function trackLaunchEnable(enable: boolean): void {
  return MyTracker.trackLaunchEnable(enable);
}

function trackLaunchTimeout(seconds: number): void {
  return MyTracker.trackLaunchTimeout(seconds);
}

function bufferingPeriod(period: number): void {
  return MyTracker.bufferingPeriod(period);
}

function forcingPeriod(period: number): void {
  return MyTracker.forcingPeriod(period);
}

function autotrackPurchase(enable: boolean): void {
  return MyTracker.autotrackPurchase(enable);
}

function trackLocation(number: 0 | 1 | 2): void {
  return MyTracker.trackLocation(number);
}

function setDebugMode(enable: boolean): void {
  return MyTracker.setDebugMode(enable);
}

function getInstanceId(): Promise<string> {
  return MyTracker.getInstanceId();
}

export default {
  initTracker,
  trackEvent,
  trackEventWithParams,
  setCustomUserId,
  trackLoginEvent,
  trackLoginEventWithParams,
  trackInviteEvent,
  trackInviteEventWithParams,
  flush,
  trackRegistrationEvent,
  trackRegistrationEventWithParams,
  trackLevel,
  trackLevelWithLevel,
  trackLevelWithLevelWithParams,
  trackLaunchEnable,
  trackLaunchTimeout,
  bufferingPeriod,
  forcingPeriod,
  autotrackPurchase,
  trackLocation,
  setDebugMode,
  getInstanceId,
};
