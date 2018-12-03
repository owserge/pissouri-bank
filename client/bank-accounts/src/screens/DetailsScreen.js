import React from 'react';
import { ScrollView, Image, StyleSheet, View, TouchableOpacity } from 'react-native';

import { getTransferById } from '../gateway/Api';

import ApiError from '../components/ApiError';
import PreloaderLight from '../components/PreloaderLight'
import TransferItem from '../components/TransferItem';
import TransferDetails from '../components/TransferDetails';

import { addressObjectToString } from '../helpers/Convertors';

import HeaderStyle from '../constants/HeaderStyle';
import ContainerStyle from '../constants/ContainerStyle';

/**
 * Renders the screen with details of the transfer.
 */
export default class DetailsScreen extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      isTransfersDataLoading: true,
      isError: false
    }
  }

  _apiRequest = () => {
    this.setState({
      isTransfersDataLoading: true,
      isError: false
    })
    getTransferById(this.props.navigation.state.params.transferId).then((res) => {
      this.setState({
        data: res.data,
        isTransfersDataLoading: false
      })
    }, (errorMessage) => {
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
    if (this.state.isError) {
      return ( 
        <ApiError 
          errorMessage={this.state.lastErrorMessage} 
          reFetchHandler={this._apiRequest}
        /> 
      );

    } else if (this.state.isTransfersDataLoading) {
      return ( <PreloaderLight /> );
      
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
