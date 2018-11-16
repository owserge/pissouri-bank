import React from 'react';
import { Text, View, StyleSheet } from 'react-native';

import Colors from '../constants/Colors';
import FontStyle from '../constants/FontStyle';
import Currencies from '../constants/Currencies';
import Layout from '../constants/Layout';

import {normalizeBalance} from '../helpers/Convertors'

export class AccountInfo extends React.Component {

  constructor(props) {
    super(props);
    
    this.state = {
      data: {
        registration: {
          address: {}
        },
        bank_route: {
          address: {}
        },
      }, 
      isLoading: true, 
      isError: false,
      errorMessage: ''
    };
  }

  componentDidMount() {
    this.setState({isLoading: true});

    fetch('http://localhost:8080/account')
      .then(response => response.json())
      .then(data => {
        if (data.status_code == 2000) {
          this.setState({data: data.data, isLoading: false, isError: false});
        } else if (data.status_code == 4000) {
          this.setState({isLoading: false, isError: true, errorMessage: data.status_text});
        }
      });

  }

  render() {
    const {data, isLoading, isError, errorMessage} = this.state;
    
    const userName =  <Text style={[styles.accountInfoViewTitle, styles.accountInfoLeftAligment]}>
                        {data.registration.first_name && data.registration.first_name + ' '} 
                        {data.registration.last_name && data.registration.last_name}
                      </Text>;

    const userNumber = data.number && <Text style={[styles.acountInfoText, styles.accountInfoLeftAligment]}>
                                        {data.number}
                                      </Text>;

    const bankRouteIBAN = data.bank_route.iban && <Text style={styles.acountInfoText}>
                                                    IBAN: {data.bank_route.iban}
                                                  </Text>;

    const bankRouteBIC = data.bank_route.bic &&  <Text style={styles.acountInfoText}>
                                                  BIC: {data.bank_route.bic}
                                                </Text>;

    const bankRouteSWIFTCode = data.bank_route.swift_code &&  <Text style={styles.acountInfoText}>
                                                            SWIFT Code: {data.bank_route.swift_code}
                                                          </Text>;

    const bankRouteSortCode = data.bank_route.sort_code &&  <Text style={styles.acountInfoText}>
                                                          Sort Code: {data.bank_route.sort_code}
                                                        </Text>;

    const bankRouteAddress = data.bank_route.address && 
              <Text style={styles.acountInfoText}>Address:{' '} +
                {data.bank_route.address.postal_code && data.bank_route.address.postal_code + ' '}
                {data.bank_route.address.state && data.bank_route.address.state + ' '}
                {data.bank_route.address.city && data.bank_route.address.city + ' '}
                {data.bank_route.address.street && data.bank_route.address.street} 
              </Text>

    const userBalance = <Text style={styles.acountInfoText}>
                          Current Balance:{' '}
                          {data.currency && Currencies[data.currency].symbol + ' '}
                          {data.balance && normalizeBalance(data.balance)}
                        </Text>

    if (isLoading) {
      return  <Text>
                Loading...
              </Text>;

    } else if (isError) {
      return  <Text>
                {errorMessage}
              </Text>;
              
    } else {
      return  <View>
                <View style={styles.accountInfoView}>
                  <View style={styles.accountInfoLeftSide}>
                    <Text style={[styles.accountInfoViewTitle, styles.accountInfoLeftAligment]}>{userName}</Text>
                    <Text style={[styles.acountInfoText, styles.accountInfoLeftAligment]}>{userNumber}</Text>
                  </View>
                  <Text style={styles.accountInfoViewTitle}>Route information</Text>
                  {bankRouteIBAN}
                  {bankRouteBIC}
                  {bankRouteSWIFTCode}
                  {bankRouteSortCode}
                  {bankRouteAddress} 
                </View>  
                {userBalance}
              </View>
    }
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
  accountInfoLeftAligment: {
    textAlign: 'left',
  },
  acountInfoText: {
    fontFamily: FontStyle.regularFontFamily,
    marginTop: Layout.paddingStep,
    fontSize: FontStyle.defaultTextSize,
    textAlign: 'right',
    color: Colors.textLigthColor
  }, 
  accountInfoViewTitle: {
    fontFamily: FontStyle.boldFontFamily,
    marginBottom: Layout.paddingStep,
    fontSize: FontStyle.defaultTitleSize,
    textAlign: 'right',
    color: Colors.textLigthColor
  }
});
