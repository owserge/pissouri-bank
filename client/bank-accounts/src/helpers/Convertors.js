export function normalizeBalance (x) {
  return parseFloat(x).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
};
 