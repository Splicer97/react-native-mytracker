# react-native-mytracker [![npm version](https://img.shields.io/npm/v/@splicer97/react-native-mytracker.svg?style=flat)](https://www.npmjs.com/package/@splicer97/react-native-mytracker) [![Downloads](https://img.shields.io/npm/dm/@splicer97/react-native-mytracker.svg)](http://www.npmtrends.com/@splicer97/react-native-mytracker)

This is unofficial React Native wrapper for myTrackerSDK

## Installation

```sh
npm install @splicer97/react-native-mytracker
```

or

```sh
yarn add @splicer97/react-native-mytracker
```

then install pod

```sh
cd ios && pod install
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
// 0 = MRLocationTrackingModeNone — location is not tracked
// 1 = MRLocationTrackingModeCached — uses the system's cached value
// 2 = MRLocationTrackingModeActive — uses a request for the current location (default)
// for Android:
// 0 = false - do not track the user's location (default)
// 1 or 2 = true - track the user's location
MyTracker.trackLocation(0);

//for IOS:
// 0 = MRRegionNotSet — default value
// 1 = MRRegionRu — server located on the territory of the Russian Federation
// 2 = MRRegionEu — server located in Europe
// for Android:
// 0 - default value
// 1 = Region.RU — server located on the territory of the Russian Federation
// 2 = Region.EU — server located in Europe
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
