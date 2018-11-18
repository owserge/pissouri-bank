import React from 'react';
import { Text, ScrollView, Image, StyleSheet, View, TouchableOpacity } from 'react-native';

import TransferItem from '../components/TransferItem'
import HeaderStyle from '../constants/HeaderStyle';
import ContainerStyle from '../constants/ContainerStyle';
import TransferDetails from '../components/TransferDetails';

export default class ProfileScreen extends React.Component {

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
    return (
      <View style={styles.container}>
        <ScrollView style={styles.container} contentContainerStyle={styles.contentContainer}>
          <TransferItem
            title="T-Mobile"
            status="Rejected"
            amount="20.32"
            currency="USD"
          />
          <TransferDetails />
        </ScrollView>
      </View>
    );
  }
}

const styles = StyleSheet.create(ContainerStyle);
