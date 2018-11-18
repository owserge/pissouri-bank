import Colors from '../constants/Colors';
import FontStyle from '../constants/FontStyle';

export default {
  avatarImageStyle: {  
    width: 40, 
    height: 40,
    borderRadius: 20,
    right: 20
  },
  mainStyle: {
    headerStyle: {
      height: 70,
      marginTop:-10,
      backgroundColor: Colors.backgroundBlueColor,
    },
    headerTitleStyle: {
      fontFamily: FontStyle.regularFontFamily,
    },
    headerTintColor: Colors.textLigthColor
  }
}