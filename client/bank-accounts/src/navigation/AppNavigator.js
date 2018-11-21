import { createStackNavigator } from 'react-navigation';

import HomeScreen from '../screens/HomeScreen';
import ProfileScreen from '../screens/ProfileScreen';
import DetailsScreen from '../screens/DetailsScreen';

/**
 * Navigation heart of the application.
 */
export default createStackNavigator({
  Home: {screen: HomeScreen},
  Profile: {screen: ProfileScreen},
  Details: {screen: DetailsScreen}
});
