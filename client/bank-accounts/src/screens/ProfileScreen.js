import React from 'react';
import { Image, Text, StyleSheet, View } from 'react-native';

import { getAccount } from '../gateway/Api'

import Preloader from '../components/Preloader'
import ApiError from '../components/ApiError'

import Colors from '../constants/Colors';
import FontStyle from '../constants/FontStyle';
import Layout from '../constants/Layout';

import HeaderStyle from '../constants/HeaderStyle';
import ContainerStyle from '../constants/ContainerStyle';

export default class ProfileScreen extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      isAccountDataLoading: true
    }
  }

  _apiRequest = () => {
    this.setState({
      isAccountDataLoading: true,
      isError: false
    })

    getAccount().then((res) => {
      console.log(res);
      this.setState({
        registration: res.data.registration,
        isAccountDataLoading: false
      })
    }, (errorMessage) => {
      this.setState({
        isError: true,
        lastErrorMessage: errorMessage
      })
    })
  }

  componentWillMount() {
    this._apiRequest()
  }

  static navigationOptions = {
    ...HeaderStyle.mainStyle,
    title: 'Profile'
  };  

  render() {
    if (this.state.isError == true) {
      return ( 
      <ApiError 
        errorMessage={this.state.lastErrorMessage} 
        reFetchHandler={this._apiRequest}
      /> );

    } else if (this.state.isAccountDataLoading) {
      return ( <Preloader /> ); 
      
    } else {
      const registration = this.state.registration;
      return (
        <View style={styles.view}>
          <Image style={styles.avatar} source={require('../assets/images/avatar.jpg')} />
          <Text style={styles.accountNameText}>{registration.first_name} {registration.last_name}</Text>
          <Text style={styles.accountDOBText}>Date of birth</Text>
          <Text style={styles.accountDOBText}>{registration.dob}</Text>
        </View>
      );
    }
  }
}

const styles = StyleSheet.create({
  ...ContainerStyle,
  view: {
    flex: 1,
    flexDirection: 'column',
    justifyContent: 'center',
    alignItems: 'center'
  },
  avatar: {
    width: 100, 
    height: 100,
    borderRadius: 50
  },
  accountNameText: {
    marginTop: Layout.paddingStep*2,
    marginBottom: Layout.paddingStep,
    fontFamily: FontStyle.boldFontFamily,
    fontSize: FontStyle.defaultTitleSize,
    color: Colors.textBlackColor
  },
  accountDOBText: {
    marginTop: Layout.paddingStep/2,
    fontFamily: FontStyle.regularFontFamily,
    fontSize: FontStyle.defaultTextSize,
    color: Colors.textGrayColor
  }
});
