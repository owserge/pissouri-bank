# The Client side

## How to run locally?

#### 1. Pull the fresh version of BE and FE from the github.

#### 2. Run the Back End locally, e.g. on port 8765
* cd ./server/bank-accounts/
* mvn clean install
* mvn spring-boot:run

wait until "com.pissouri.App : Started App"

#### 3. Go to the client folder, gather all the packages using yarn or npm and run the app.
* cd ./pissouri-bank/client/bank-accounts/
* npm install
* npm start

It will start Expo, Metro Builder on a browser, wait until it says 'Tunnel ready.'.

From Metro Builder Android/iOS simulators can be started (requiered Xcode, Android SDK etc.).

#### 4. To start the App on the physical device, runtime variables should be changed:
* vi ./client/bank-accounts/src/constants/RuntimeConfig.js

Set your Back End API's IP and PORT e.g. IP 192.168.0.101 on PORT 8765
* apiHost: 'http://192.168.0.101:8765'

Expo client app can be installed on [iOS](https://itunes.apple.com/us/app/expo-client/id982107779?mt=8) or [Android](https://play.google.com/store/apps/details?id=host.exp.exponent&hl=en).

It will allow you to scan QR code on the Metro Builder page, or even on the terminal screen you have launched the front.

#### 5. If you see 'Network error, please, try again'
* Make sure your mobile device and laptop with BackEnd and Expo Tunnel on the same WiFi.
* Check if the Back End is ready.
* Check RuntimeConfig.js for the right ip:port.
* Check if Network Settings, Firewall(s), VPN are not influencing the apps networks.
* Try to restart Back and Front.
* Pull fresh version of BE and FE from the github and restart the apps.
* If it does not help, please, contact owserge@gmail.com

### ...
