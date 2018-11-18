import React from 'react';
import { Text, View, StyleSheet } from 'react-native';

import Colors from '../constants/Colors';
import FontStyle from '../constants/FontStyle';

export default class Preloader extends React.Component {
  render() {
    return  (
      <View style={styles.preloader}>
        <Text style={styles.preloaderText}>Loading...</Text>
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
  },
  preloaderText: {
    fontFamily: FontStyle.boldFontFamily,
    color: Colors.textBlackColor,
    fontSize: FontStyle.defaultTitleSize,
  },
});
