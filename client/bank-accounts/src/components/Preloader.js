import React from 'react';
import { Text, View, StyleSheet, Image, ActivityIndicator } from 'react-native';

import Colors from '../constants/Colors';
import FontStyle from '../constants/FontStyle';

/**
 * Renders preloader component showed while fetching data from the gateway.
 */
export default class Preloader extends React.Component {
  render() {
    return  (
      <View style={styles.preloader}>
      <ActivityIndicator size="large" color={Colors.backgroundBlueColor} />
      <Image style={styles.logo} source={require('../assets/images/logo.png')} />
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
    marginLeft: 10,
    paddingBottom: 20
  },
  logo: {
    marginBottom: 50,
    width: 200, 
    height: 200,
    marginTop: 50
  }
});
