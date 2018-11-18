import React from 'react';
import { Text, View, StyleSheet } from 'react-native';

import { normalizeBalance } from '../helpers/Convertors'

import Currencies from '../constants/Currencies'
import Colors from '../constants/Colors';
import FontStyle from '../constants/FontStyle';

import Layout from '../constants/Layout';

export default class TransferItem extends React.Component {

  componentWillMount(){
    this.setState({
      title: this.props.title,
      status: this.props.status,
      amount: this.props.amount,
      currency: this.props.currency
    });
  }

  render() {
    return  (
      <View style={[styles.transferItem, styles.line]}>
        <Text style={styles.title}>{this.state.title}</Text>
        <Text style={styles.status}>{this.state.status}</Text>
        <Text style={styles.amount}>
          -{' '}
          {Currencies[this.state.currency].symbol}{' '}
          {normalizeBalance(this.state.amount)}
        </Text>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  transferItem: {
    fontFamily: FontStyle.boldFontFamily,
    height: 82
  },
  title: {
    fontFamily: FontStyle.regularFontFamily,
    fontSize: FontStyle.defaultXLSize,
    color: Colors.textBlackColor,
    position: 'absolute',
    top: 15,
    left: Layout.paddingStep * 3,
  },
  status: {
    fontFamily: FontStyle.regularFontFamily,
    fontSize: FontStyle.defaultTitleSize,
    color: Colors.textGrayColor,
    position: 'absolute',
    top: 45,
    left: Layout.paddingStep * 3,
  },
  amount: {
    fontFamily: FontStyle.regularFontFamily,
    fontSize: FontStyle.defaultXLSize,
    color: Colors.textGrayColor,
    position: 'absolute',
    top: 27,
    right: Layout.paddingStep * 3,
  },
  line: {
    borderBottomColor: Colors.lineColor,
    borderBottomWidth: 1,
  }
});
