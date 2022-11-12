# react-native-mytracker

This is unofficial React Native wrapper for myTrackerSDK

## Installation

```sh
npm install @splicer97/react-native-mytracker
```

or

```sh
yarn add @splicer97/react-native-mytracker
```

## Usage

```js
import MyTracker from '@splicer97/react-native-mytracker';

// ...

MyTracker.initTracker('SDK_KEY');

//MyTracker Parameters
MyTracker.setCustomUserId('USER_ID');

//MyTracker Configurations
MyTracker.trackLaunchEnable(true);

MyTracker.autotrackPurchase(true);

MyTracker.trackLaunchTimeout(30);

MyTracker.bufferingPeriod(30);

MyTracker.forcingPeriod(30);

//for IOS:
// 0 = MRLocationTrackingModeNone — отслеживание местоположения не производится
// 1 = MRLocationTrackingModeCached — используется закэшированное системой значение
// 2 = MRLocationTrackingModeActive — используется запрос текущего местоположения (по умолчанию)
// for Android:
// 0 = false - не отслеживать местоположение пользователя (по умолчанию)
// 1 or 2 = true - отслеживать местоположение пользователя
MyTracker.trackLocation(0);

//for IOS:
// 0 = MRRegionNotSet — значение по умолчанию
// 1 = MRRegionRu — сервер, расположенный на территории Российской Федерации
// 2 = MRRegionEu — сервер, расположенный на территории Европы
// for Android:
// 0 - значение по умолчанию
// 1 = Region.RU — сервер, расположенный на территории Российской Федерации
// 2 = Region.EU — сервер, расположенный на территории Европы
MyTracker.region(0);

MyTracker.setDebugMode(false);

//MyTracker Events
MyTracker.trackEvent('name');

MyTracker.trackEventWithParams('name', {
  param1: 'name1',
  param2: 'name2',
});

MyTracker.trackLoginEvent('userId', 'vkConnectId');

MyTracker.trackLoginEventWithParams('userId', 'vkConnectId', {
  param1: 'name1',
  param2: 'name2',
});

MyTracker.trackInviteEvent();

MyTracker.trackInviteEventWithParams({
  param1: 'name1',
  param2: 'name2',
});

MyTracker.flush();

MyTracker.trackRegistrationEvent('userId', 'vkConnectId');

MyTracker.trackRegistrationEventWithParams('userId', 'vkConnectId', {
  param1: 'name1',
  param2: 'name2',
});

MyTracker.trackLevel();

MyTracker.trackLevelWithLevel(1);

MyTracker.trackLevelWithLevelWithParams(1, {
  param1: 'name1',
  param2: 'name2',
});
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT

---

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)
