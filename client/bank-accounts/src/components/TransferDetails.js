import React from 'react';
import { Text, View, StyleSheet } from 'react-native';

import FontStyle from '../constants/FontStyle';
import Layout from '../constants/Layout';
import Colors from '../constants/Colors';

/**
 * Renders details (originator/beneficiary) of the transfer.
 */
export default class AccountInfo extends React.Component {

  componentWillMount(){
    this.setState({
      iban: this.props.iban,
      bic: this.props.bic,
      swiftCode: this.props.swiftCode,
      sortCode: this.props.sortCode,
      address: this.props.address
    });
  }

  render() {
    return (
      <View style={[styles.view, styles.line]}>
        <Text style={styles.accountInfoViewTitle}>Route information</Text>
        <Text style={styles.acountInfoText}>IBAN: {this.state.iban}</Text>
        <Text style={styles.acountInfoText}>BIC: {this.state.bic}</Text>
        <Text style={styles.acountInfoText}>SWIFT Code: {this.state.swiftCode}</Text>
        <Text style={styles.acountInfoText}>Sort Code: {this.state.sortCode}</Text>
        <Text style={styles.acountInfoText}>Address: {this.state.address}</Text>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  view: {
    paddingTop: Layout.paddingStep * 3,
    paddingBottom: Layout.paddingStep * 3,
    paddingLeft: Layout.paddingStep * 3,
    paddingRight: Layout.paddingStep * 3,
    backgroundColor: Colors.backgroundGrayColor
  },
  acountInfoText: {
    fontFamily: FontStyle.regularFontFamily,
    marginTop: Layout.paddingStep,
    fontSize: FontStyle.defaultTextSize,
    color: Colors.textBlackColor
  }, 
  accountInfoViewTitle: {
    fontFamily: FontStyle.boldFontFamily,
    marginBottom: Layout.paddingStep,
    fontSize: FontStyle.defaultTitleSize,
    color: Colors.textBlackColor
  },
  line: {
    borderBottomColor: Colors.lineColor,
    borderBottomWidth: 1
  }
});
