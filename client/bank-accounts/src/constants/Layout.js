import { Dimensions } from 'react-native';

const width = Dimensions.get('window').width;
const height = Dimensions.get('window').height;

/**
 * General layout settings.
 */
export default {
  paddingStep: 5,
  window: {
    width,
    height
  },
  isSmallDevice: width < 375
};
