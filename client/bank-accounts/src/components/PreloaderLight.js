import React from 'react';
import { View, StyleSheet, ActivityIndicator } from 'react-native';

import Colors from '../constants/Colors';

/**
 * Renders lightweight preloader component showed
 * while fetching data from the gateway.
 */
export default class PreloaderLight extends React.Component {
  render() {
      return (
        <View style={styles.preloader}>
          <ActivityIndicator size="large" color={Colors.textGrayColor}/>
        </View>
      );
  }
}

const styles = StyleSheet.create({
  preloader: {
    flex: 1,
    flexDirection: 'column',
    justifyContent: 'center',
    alignItems: 'center'
  }
});
