import React from 'react';
import { Image, Text, ScrollView, StyleSheet, View, TouchableOpacity, TouchableHighlight } from 'react-native';

import { getAccount } from '../gateway/Api';

import Transfers from '../components/Transfers';
import AccountInfo from '../components/AccountInfo';
import Preloader from '../components/Preloader'

import { addressObjectToString } from '../helpers/Convertors';

import ContainerStyle from '../constants/ContainerStyle';
import HeaderStyle from '../constants/HeaderStyle';

export default class HomeScreen extends React.Component {
  
  constructor(props) {
    super(props);
    this.state = {
      isLoading: true
    }
  }
  
  componentWillMount() {
    getAccount().then((res) => {
      this.setState({
        data: res.data,
        isLoading: false
      })
    })
  }
 
  static navigationOptions = ({ navigation }) => ({
    ...HeaderStyle.mainStyle,
    title: 'Overview',
    headerRight: (
      <TouchableOpacity onPress={() => { navigation.navigate('Profile') }}>
        <Image
          source={require('../assets/images/avatar.jpg')} 
          style={HeaderStyle.avatarImageStyle} 
        />
      </TouchableOpacity>
    ),
  }); 
  
  render() {

    if (this.state.isLoading) {
      return ( <Preloader /> );
    } else {
      return (
        <View style={styles.container}>
          <ScrollView style={styles.container} contentContainerStyle={styles.contentContainer}>
            <AccountInfo 
              firstName={this.state.data.registration.first_name}
              lastName={this.state.data.registration.last_name}
              number={this.state.data.number}
              iban={this.state.data.bank_route.iban}
              bic={this.state.data.bank_route.bic}
              swiftCode={this.state.data.bank_route.swift_code}
              sortCode={this.state.data.bank_route.sort_code}
              address={addressObjectToString(this.state.data.registration.address)}
              balance={this.state.data.balance}
              currency={this.state.data.currency}
            />
            <Transfers />
          </ScrollView>
        </View>
      );
    }
  }
}

const styles = StyleSheet.create({
  ...ContainerStyle,
});
