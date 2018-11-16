import React from 'react';
import { Image, ScrollView, StyleSheet, View, TouchableOpacity } from 'react-native';

import { AccountInfo } from '../components/AccountInfo';

import HeaderStyle from '../constants/HeaderStyle';
import ContainerStyle from '../constants/ContainerStyle';

export default class HomeScreen extends React.Component {

  static navigationOptions = ({ navigation, screenProps }) => ({
    ...HeaderStyle.mainStyle,
    title: 'Overview',
    headerRight: (
      <TouchableOpacity onPress={() => { navigation.navigate('Profile')}}>
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
          <AccountInfo />
        </ScrollView>
      </View>
    );
  }
}

const styles = StyleSheet.create(ContainerStyle);
