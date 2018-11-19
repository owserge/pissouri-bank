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
      transfers: this.props.transfers,
    });
  }

  render() {

    const transferItems = this.state.transfers.map((item) => 
      <TouchableHighlight 
        key={item.id}
        underlayColor={Colors.backgroundGrayColor}
        onPress={() => { this.props.navigation.navigate('Details', {transferId: item.id}) }}>
        <TransferItem
          key={item.id}
          title={item.amount < 0 ? item.beneficiary.account_number : item.originator.account_number }
          status={item.status}
          amount={item.amount}
          currency={item.currency}
        />
      </TouchableHighlight>
    );

    return  (
      <View>
        <Text style={styles.lastTransactionText}>Last transactions</Text>
        <View style={styles.line}></View>
        {transferItems}
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
