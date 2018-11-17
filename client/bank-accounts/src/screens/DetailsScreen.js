import React from 'react';
import { Text, ScrollView, StyleSheet, View } from 'react-native';

import HeaderStyle from '../constants/HeaderStyle';
import ContainerStyle from '../constants/ContainerStyle';

export default class ProfileScreen extends React.Component {

  static navigationOptions = {
    ...HeaderStyle.mainStyle,
    title: 'Details'
  };  

  render() {
    return (
      <View style={styles.container}>
        <ScrollView style={styles.container} contentContainerStyle={styles.contentContainer}>
          <Text> Details... </Text>
        </ScrollView>
      </View>
    );
  }
}

const styles = StyleSheet.create(ContainerStyle);
