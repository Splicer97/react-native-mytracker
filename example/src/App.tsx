import React from 'react';

import MyTracker from '@splicer97/react-native-mytracker';
import { StyleSheet, Text, View } from 'react-native';

export default function App() {
  MyTracker.initTracker('initTracker');
  const instanceId = MyTracker.getInstanceId();

  return (
    <View style={styles.container}>
      <Text>instanceId</Text>
      <Text>{instanceId}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
    backgroundColor: 'white',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
