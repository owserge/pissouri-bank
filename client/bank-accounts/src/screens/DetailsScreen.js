import React from 'react';
import { ScrollView, Image, StyleSheet, View, TouchableOpacity } from 'react-native';

import { getTransferById } from '../gateway/Api';

import { addressObjectToString } from '../helpers/Convertors';

import TransferItem from '../components/TransferItem'
import HeaderStyle from '../constants/HeaderStyle';
import ContainerStyle from '../constants/ContainerStyle';
import TransferDetails from '../components/TransferDetails';

import Preloader from '../components/Preloader'

export default class ProfileScreen extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      isLoading: true
    }
  }
 
  componentWillMount() {
    getTransferById(this.props.navigation.state.params.transferId).then((res) => {
      this.setState({
        data: res.data,
        isLoading: false
      })
    })
  }

  static navigationOptions = ({ navigation }) => ({
    ...HeaderStyle.mainStyle,
    title: 'Details',
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
      const data = this.state.data;
      const remoteDetails = (data.amount < 0 ? data.beneficiary : data.originator )
      return (
        <View style={styles.container}>
          <ScrollView style={styles.container} contentContainerStyle={styles.contentContainer}>
            <TransferItem
              title={remoteDetails.full_name}
              status={data.status}
              amount={data.amount}
              currency={data.currency}
            />
            <TransferDetails
              iban={remoteDetails.iban}
              bic={remoteDetails.bic}
              swiftCode={remoteDetails.swift_code}
              sortCode={remoteDetails.sort_code}
              address={addressObjectToString(remoteDetails.address)}
            />
          </ScrollView>
        </View>
      );
    }
  }
}

const styles = StyleSheet.create(ContainerStyle);
