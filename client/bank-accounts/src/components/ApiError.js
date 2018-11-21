import React from 'react';
import { Text, View, StyleSheet, Button, Image } from 'react-native';

import Colors from '../constants/Colors';
import FontStyle from '../constants/FontStyle';

/**
 * Renders an error screen with button "Try again" and error message,
 * as soon as any error occurs.
 */
export default class ApiError extends React.Component {
 
  componentWillMount(){
    this.setState({
      errorMessage: this.props.errorMessage,
      reFetchHandler: this.props.reFetchHandler
    });
  }

  render() {
    return  (
      <View style={styles.apiError}>
      <Text style={styles.apiErrorText}>{this.state.errorMessage}</Text>
      <Image style={styles.errorIcon} source={require('../assets/images/error.png')} />
      <Button 
        buttonStyle={styles.reFetchButton}
        title="Try again" 
        onPress={this.state.reFetchHandler} 
      />  
      </View>
    );
  }
}

const styles = StyleSheet.create({
  apiError: {
    flex: 1,
    flexDirection: 'column',
    justifyContent: 'center',
    alignItems: 'center'
  },
  apiErrorText: {
    fontFamily: FontStyle.boldFontFamily,
    color: Colors.textBlackColor,
    fontSize: FontStyle.defaultTitleSize,
    marginLeft: 10,
    paddingBottom: 20
  },
  errorIcon: {
    marginBottom: 50,
    width: 100, 
    height: 100,
    marginTop: 50
  },
  reFetchButton: {
    marginRight:40,
    marginLeft:40,
    marginTop:10,
    paddingTop:10,
    paddingBottom:10,
    backgroundColor: Colors.backgroundBlueColor,
    borderRadius:10,
    borderWidth: 1,
    borderColor: Colors.backgroundBlueColor
  }
});
