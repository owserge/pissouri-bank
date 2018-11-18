import React from 'react';
import { Text, View, StyleSheet, TouchableHighlight } from 'react-native';
import { withNavigation } from 'react-navigation';

import TransferItem from '../components/TransferItem';

import Colors from '../constants/Colors';
import FontStyle from '../constants/FontStyle';
import Layout from '../constants/Layout';


class Transfers extends React.Component {
  
  componentWillMount(){
    this.setState({
      
    });
  }

  render() {
    return  (
      <View>
        <Text style={styles.lastTransactionText}>Last transactions</Text>
        <View style={styles.line}></View>
        <TouchableHighlight 
          underlayColor={Colors.backgroundGrayColor}
          onPress={() => { this.props.navigation.navigate('Details') }}>
          <TransferItem
            title="Apple New York 45st"
            status="Pending"
            amount="100500"
            currency="EUR"
          />
        </TouchableHighlight>
        <TouchableHighlight 
          underlayColor={Colors.backgroundGrayColor}
          onPress={() => { this.props.navigation.navigate('Details') }}>
          <TransferItem
            title="Souvlaki Paphos"
            status="Pending"
            amount="-100"
            currency="EUR"
          />
        </TouchableHighlight>
        <TouchableHighlight 
          underlayColor={Colors.backgroundGrayColor}
          onPress={() => { this.props.navigation.navigate('Details') }}>
          <TransferItem
            title="F Jeans"
            status="Pending"
            amount="-83.22"
            currency="EUR"
          />
        </TouchableHighlight>
        <TouchableHighlight 
          underlayColor={Colors.backgroundGrayColor}
          onPress={() => { this.props.navigation.navigate('Details') }}>
          <TransferItem
            title="T-Mobile"
            status="Rejected"
            amount="20.32"
            currency="USD"
          />
        </TouchableHighlight>
        <TouchableHighlight 
          underlayColor={Colors.backgroundGrayColor}
          onPress={() => { this.props.navigation.navigate('Details') }}>
          <TransferItem
            title="Apple New York 45st"
            status="Pending"
            amount="100500"
            currency="EUR"
          />
        </TouchableHighlight>
        <TouchableHighlight 
          underlayColor={Colors.backgroundGrayColor}
          onPress={() => { this.props.navigation.navigate('Details') }}>
          <TransferItem
            title="Souvlaki Paphos"
            status="Pending"
            amount="-100"
            currency="EUR"
          />
        </TouchableHighlight>
        <TouchableHighlight 
          underlayColor={Colors.backgroundGrayColor}
          onPress={() => { this.props.navigation.navigate('Details') }}>
          <TransferItem
            title="F Jeans"
            status="Pending"
            amount="-83.22"
            currency="EUR"
          />
        </TouchableHighlight>
        <TouchableHighlight 
          underlayColor={Colors.backgroundGrayColor}
          onPress={() => { this.props.navigation.navigate('Details') }}>
          <TransferItem
            title="T-Mobile"
            status="Rejected"
            amount="20.32"
            currency="USD"
          />
        </TouchableHighlight>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  lastTransactionText: {
    paddingLeft: Layout.paddingStep * 3,
    paddingTop: Layout.paddingStep * 3,
    paddingBottom: Layout.paddingStep * 2,
    fontFamily: FontStyle.regularFontFamily,
    fontSize: FontStyle.defaultTextSize,
    color: Colors.textGrayColor,
    backgroundColor: Colors.backgroundGrayColor,
  },
  line: {
    borderBottomColor: Colors.lineColor,
    borderBottomWidth: 1,
  }
});

export default withNavigation(Transfers);