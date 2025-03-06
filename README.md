# react-native-mytracker [![npm version](https://img.shields.io/npm/v/@splicer97/react-native-mytracker.svg?style=flat)](https://www.npmjs.com/package/@splicer97/react-native-mytracker) [![Downloads](https://img.shields.io/npm/dm/@splicer97/react-native-mytracker.svg)](http://www.npmtrends.com/@splicer97/react-native-mytracker)

This is unofficial React Native wrapper for myTrackerSDK

## React Native Support

Since version 1.0.0 the library can only be used on the new architecture

| version | react-native version |
| ------- | -------------------- |
| < 1.0.0 | < 0.76.0             |
| 1.0.0   | 0.76.*               |
| 2.0.0+  | 0.77.0+              |

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

// 0  — location is not tracked
// 1  — uses the system's cached value
// 2  — uses a request for the current location (default)
MyTracker.trackLocation(0);

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

const instanceId = MyTracker.getInstanceId();
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT

---

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)
