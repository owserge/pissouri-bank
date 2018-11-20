import Currencies from '../constants/Currencies'

export function normalizeBalance (x) {
  return parseFloat(x).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}
export function addressObjectToString(data) {
  return  (data.country ? data.country + " ":"") +
          (data.postal_code ? data.postal_code + " ":"") +
          (data.state ? data.state + " ":"") +
          (data.city ? data.city + " ":"") +
          (data.street ? data.street + " ":"");
}
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
