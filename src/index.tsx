import { NativeModules } from 'react-native';

interface IMyTracker {
  /**
   * Initializing the tracker
   */
  initTracker(SDK_KEY: string): void;
  /**
   * An arbitrary event with a given name.
   */
  trackEvent(name: string): void;
  /**
   * An arbitrary event with a given name. The optional attributes parameter allows you to set arbitrary key-value parameters for the event. Maximum length of name, key and value is 255 characters.
   */
  trackEventWithParams(name: string, attributes: Object): void;
  /**
   * To track statistics not only by device, but also by user, set the customUserId parameter. This is the unique identifier of the user in your project, which you assign to him at the moment of registration. It must remain unchanged even if the user logs in on a different device. By setting this parameter, you can estimate the size and activity of the app's audience, regardless of how many devices the user has your app on. And you won't lose the history of accumulated data on the user if he decides to switch devices.
   * It is important to set the parameter before event tracking to pass the user ID with each tracked event.
   */
  setCustomUserId(USER_ID: string): void;
  /**
   * Authorization event. The method must be called immediately after the user registers with the application. vkConnectId can be empty string.
   */
  trackLoginEvent(userId: string, vkConnectId: string): void;
  /**
   * Authorization event. The method must be called immediately after the user registers with the application. vkConnectId can be empty string. The user ID must be passed in the userId parameter.
   */
  trackLoginEventWithParams(
    userId: string,
    vkConnectId: string,
    attributes: Object
  ): void;
  /**
   * An event to send an invitation.
   */
  trackInviteEvent(): void;
  /**
   * An event to send an invitation. The optional eventParams parameter allows you to set arbitrary key-value parameters for the event. The maximum length of key and value is 255 characters.
   */
  trackInviteEventWithParams(attributes: Object): void;
  /**
   * Forcing all events to be sent and resetting the send timer.
To reduce the channel load and minimize the impact on application performance, the SDK buffers all events on the device before sending them to the server, and regularly sends the collected data in a compressed packet. By default, data is sent to the server every 15 minutes. This interval can be set via the bufferingPeriod parameter from 1 second to 1 day. If the user has closed the application, it will be sent the next time it is started. But some events are very important to get to the analytics as early as possible, especially in the first sessions after the installation of the application. The flush() method will help here.
   */
  flush(): void;
  /**
   * Registration event. The method must be called immediately after the user registers with the application. vkConnectId can be empty string.
   */
  trackRegistrationEvent(userId: string, vkConnectId: string): void;
  /**
   * Registration event. The method must be called immediately after the user registers with the application. vkConnectId can be empty string. The user ID must be passed in the userId parameter.
   */
  trackRegistrationEventWithParams(
    userId: string,
    vkConnectId: string,
    attributes: Object
  ): void;
  /**
   *  The event of reaching a level without level number (level parameter).
   */
  trackLevel(): void;
  /**
   *  The event of reaching a level with  level number (level parameter).
   */
  trackLevelWithLevel(level: number): void;
  /**
   *  The event of reaching a level with  level number (level parameter). Additional parameter eventParams allows to set arbitrary key-value parameters for event. Maximum length of key and value is 255 characters.
   */
  trackLevelWithLevelWithParams(level: number, params: Object): void;
  /**
   * Tracking application launches. The default is true.
   * @default true
   */
  trackLaunchEnable(enable: boolean): void;
  /**
   * Interval in seconds during which a new startup will not be counted and the session will be interrupted when the application is minimized. The default is 30 seconds. You can set the value in the range of 30-7200 seconds.
   * @default 30
   */
  trackLaunchTimeout(seconds: number): void;
  /**
   * Interval in seconds during which events will be accumulated on the device before being sent to the server. The default setting is 900 seconds. You can set the value in the range of 1-86400 seconds (1 day).
   * @default 900
   */
  bufferingPeriod(seconds: number): void;
  /**
   * Interval in seconds after installing or updating an application, during which events will be immediately sent to the server without local buffering. The default is 0 seconds (immediate sending is disabled). You can set a value in the range of 0-432000 seconds (5 days).
   */
  forcingPeriod(seconds: number): void;
  /**
   * Automatic in-app purchase tracking. The default is true.
   * @default true
   */
  autotrackPurchase(enable: boolean): void;
  /**
   * Tracking the user's location. The default is false.
If your application requests access to the device's location, you can enable this option to improve the accuracy of statistics related to the user's geography. In some cases, location tracking also improves attribution and predictive model performance.
  * @default 0
  * @platform IOS:
  * 0 — location is not tracked;
  * 1 — uses the system's cached value;
  * 2 — uses a request for the current location (default);
  * @platform Android:
  * 0 - do not track the user's location (default);
  * 1 or 2 - track the user's location;
   */
  trackLocation(number: 0 | 1 | 2): void;
  /**
   * The region where the statistics collection server is located. The need to change the region may arise, for example, due to legal requirements. Available values:
   * @default 0
   * 0 — region not set(default value)
   * 1 — server located on the territory of the Russian Federation
   * 2 — server located in Europe
   */
  region(region: 0 | 1 | 2): void;
  /**
   *   Enables/disables debug mode. The default is false.
   * @default 0
   */
  setDebugMode(enable: boolean): void;
}
const MyTracker: IMyTracker = NativeModules.MyTracker;
export default MyTracker;
