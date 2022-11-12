import * as React from 'react';

import { StyleSheet, Text, View } from 'react-native';
import MyTracker from 'react-native-mytracker';

export default function App() {
  MyTracker.initTracker('initTracker');

  // MyTracker.trackEvent('trackEvent');

  // MyTracker.trackEvent('trackEventWithParams', {
  //   event1: '1',
  //   event2: '2',
  // });
  return (
    <View style={styles.container}>
      <Text>Result</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
