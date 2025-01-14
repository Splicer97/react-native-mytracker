import React, { useEffect } from 'react';

import MyTracker from '@splicer97/react-native-mytracker';
import { StyleSheet, Text, View } from 'react-native';

export default function App() {
  MyTracker.initTracker('initTracker');
  useEffect(() => {
    const instanceId = MyTracker.getInstanceId();
    console.log('🚀 ~ getId ~ instanceId:', instanceId);
  }, []);

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
