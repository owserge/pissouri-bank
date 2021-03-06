import React from 'react';
import { Text, View, StyleSheet } from 'react-native';

import { prettifyBalance } from '../helpers/Convertors';

import Colors from '../constants/Colors';
import FontStyle from '../constants/FontStyle';
import Layout from '../constants/Layout';

/**
 * Renders an item for one transfer.
 */
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
        <Text style={styles.status}>{this.state.status.toLowerCase()}</Text>
        <Text style={(this.state.amount > 0 ? [styles.amount, styles.amountGreen] : styles.amount)}>
          {prettifyBalance(this.state.amount, this.state.currency)}
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
  amountGreen: {
    color: "#009900",
  },
  line: {
    borderBottomColor: Colors.lineColor,
    borderBottomWidth: 1,
  }
});
