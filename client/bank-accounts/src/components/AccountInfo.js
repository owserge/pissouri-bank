import React from 'react';
import { Text, View, StyleSheet } from 'react-native';

import Currencies from '../constants/Currencies';
import FontStyle from '../constants/FontStyle';
import Layout from '../constants/Layout';
import Colors from '../constants/Colors';

import { normalizeBalance } from '../helpers/Convertors';

/**
 * Renders account profile and credentials details with current balance.
 */
export default class AccountInfo extends React.Component {

  componentWillMount(){
    this.setState({
      firstName: this.props.firstName,
      lastName: this.props.lastName,
      number: this.props.number,
      iban: this.props.iban,
      bic: this.props.bic,
      swiftCode: this.props.swiftCode,
      sortCode: this.props.sortCode,
      address: this.props.address,
      balance: this.props.balance,
      currency: this.props.currency,
    });
  }

  render() {
    return (
      <View style={styles.line}>
        <View style={styles.accountInfoView}>
          <View style={styles.accountInfoLeftSide}>
            <Text style={[styles.accountInfoViewTitle, styles.accountInfoLeftAlignment]}>
              {this.state.firstName} {this.state.lastName}
            </Text>
            <Text style={[styles.accountInfoText, styles.accountInfoLeftAlignment]}>{this.state.number}</Text>
          </View>
            <Text style={styles.accountInfoViewTitle}>Route information</Text>
            <Text style={styles.accountInfoText}>IBAN: {this.state.iban}</Text>
            <Text style={styles.accountInfoText}>BIC: {this.state.bic}</Text>
            <Text style={styles.accountInfoText}>SWIFT Code: {this.state.swiftCode}</Text>
            <Text style={styles.accountInfoText}>Sort Code: {this.state.sortCode}</Text>
            <Text style={styles.accountInfoText}>Address: {this.state.address}</Text>
          </View>
        <View style={styles.accountInfoBalance}>
          <Text style={styles.accountInfoBalanceTitle}>Current Balance: </Text>
          <Text style={styles.accountInfoBalanceAmount}>
            {Currencies[this.state.currency].symbol}{' '}
            {normalizeBalance(this.state.balance)}
          </Text>
        </View>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  accountInfoView: {
    paddingTop: Layout.paddingStep * 3,
    paddingBottom: Layout.paddingStep * 3,
    paddingLeft: Layout.paddingStep * 3,
    paddingRight: Layout.paddingStep * 3,
    backgroundColor: Colors.backgroundBlueColor
  },
  accountInfoLeftSide: {
    paddingTop: Layout.paddingStep * 3,
    paddingLeft: Layout.paddingStep * 3,
    position: "absolute"
  },
  accountInfoLeftAlignment: {
    textAlign: 'left',
  },
  accountInfoText: {
    fontFamily: FontStyle.regularFontFamily,
    marginTop: Layout.paddingStep,
    fontSize: FontStyle.defaultTextSize,
    textAlign: 'right',
    color: Colors.textLightColor
  }, 
  accountInfoViewTitle: {
    fontFamily: FontStyle.boldFontFamily,
    marginBottom: Layout.paddingStep,
    fontSize: FontStyle.defaultTitleSize,
    textAlign: 'right',
    color: Colors.textLightColor
  },
  accountInfoBalance: {
    fontFamily: FontStyle.boldFontFamily,
    height: 72
  },
  accountInfoBalanceTitle: {
    fontFamily: FontStyle.regularFontFamily,
    fontSize: FontStyle.defaultTitleSize,
    color: Colors.textGrayColor,
    position: 'absolute',
    top: 24,
    left: Layout.paddingStep * 3,
  },
  accountInfoBalanceAmount: {
    fontFamily: FontStyle.regularFontFamily,
    fontSize: FontStyle.defaultXXLSize,
    color: Colors.textBlackColor,
    position: 'absolute',
    top: 22,
    right: Layout.paddingStep * 3,
  },
  line: {
    borderBottomColor: Colors.lineColor,
    borderBottomWidth: 1,
  }
});
