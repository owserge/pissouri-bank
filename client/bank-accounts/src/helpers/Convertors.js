import Currencies from '../constants/Currencies';

/**
 * Trim amount field if needed and add comas to it.
 * @param x
 * @returns {string}
 */
export function normalizeBalance (x) {
  return parseFloat(x).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

/**
 * Converts address object to a readable string.
 * @param data
 * @returns {string}
 */
export function addressObjectToString(data) {
  return  (data.country ? data.country + " ":"") +
          (data.postal_code ? data.postal_code + " ":"") +
          (data.state ? data.state + " ":"") +
          (data.city ? data.city + " ":"") +
          (data.street ? data.street + " ":"");
}

/**
 * Makes the amount, the currency and the type (IN or OUT) of the transfer
 * nice and clean according to the UI requirements.
 * @param amount
 * @param currency
 * @returns {string}
 */
export function prettifyBalance(amount, currency) {
  let sign = "";
  currency = Currencies[currency].symbol;
  if (amount < 0) {
    sign = '- ';
    amount = amount * -1;
  }
  amount = normalizeBalance(amount);
  return sign + " " + currency + " " + amount;
}
