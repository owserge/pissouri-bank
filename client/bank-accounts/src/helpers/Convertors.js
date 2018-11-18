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
