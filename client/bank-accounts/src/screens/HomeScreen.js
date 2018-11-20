import React from 'react';
import { Image, ScrollView, StyleSheet, View, TouchableOpacity } from 'react-native';

import { getAccount, getTransfers } from '../gateway/Api';

import Transfers from '../components/Transfers';
import AccountInfo from '../components/AccountInfo';
import Preloader from '../components/Preloader'
import ApiError from '../components/ApiError'

import { addressObjectToString } from '../helpers/Convertors';

import ContainerStyle from '../constants/ContainerStyle';
import HeaderStyle from '../constants/HeaderStyle';

export default class HomeScreen extends React.Component {
  
  constructor(props) {
    super(props);
    this.state = {
      isAccountDataLoading: true,
      isTransfersDataLoading: true,
      isError: false
    }
  }

  _apiRequest = () => {
    this.setState({
      isAccountDataLoading: true,
      isTransfersDataLoading: true,
      isError: false
    })

    getAccount().then((res) => {
      this.setState({
        accountData: res.data,
        isAccountDataLoading: false
      })
    }, (errorMessage) => {
      this.setState({
        isError: true,
        lastErrorMessage: errorMessage
      })
    })
 
    getTransfers().then((res) => {
      this.setState({
        transfersData: res.data,
        isTransfersDataLoading: false
      })
    }).catch((errorMessage) => {
      this.setState({
        isError: true,
        lastErrorMessage: errorMessage
      })
    })
  }
  
  componentWillMount() {
    this._apiRequest();
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

    if (this.state.isError == true) {
      return ( 
        <ApiError 
          errorMessage={this.state.lastErrorMessage}
          reFetchHandler={this._apiRequest} 
        /> 
      );

    } else if (this.state.isAccountDataLoading || this.state.isTransfersDataLoading) {
      return ( <Preloader /> ); 
      
    } else {
      const accountData = this.state.accountData;
      const transfersData = this.state.transfersData;
      return (
        <View style={styles.container}>
          <ScrollView style={styles.container} contentContainerStyle={styles.contentContainer}>
            <AccountInfo 
              firstName={accountData.registration.first_name}
              lastName={accountData.registration.last_name}
              number={accountData.number}
              iban={accountData.bank_route.iban}
              bic={accountData.bank_route.bic}
              swiftCode={accountData.bank_route.swift_code}
              sortCode={accountData.bank_route.sort_code}
              address={addressObjectToString(accountData.registration.address)}
              balance={accountData.balance}
              currency={accountData.currency}
            />
            <Transfers transfers={transfersData}/>
          </ScrollView>
        </View>
      );
    }
  }
}

const styles = StyleSheet.create({
  ...ContainerStyle,
});
