import * as React from 'react';

import MyTracker from '@splicer97/react-native-mytracker';
import { StyleSheet, Text, View } from 'react-native';

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
