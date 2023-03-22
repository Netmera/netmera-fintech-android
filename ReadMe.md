# Android SDK Integration

1. Create a project on Firebase Console.
2. Add the google-services.json file inside the app folder.
3. Add Sender ID and Server API key (they can be found in Firebase → Project Settings → Cloud Messaging) to Netmera Panel (Developers → Push Backends → Android) (Only project owners can create API Keys.) 
4. Add the following configuration to your Project level **build.gradle** file. 

```groovy
buildscript {
    repositories {
         google()
         maven {url 'https://developer.huawei.com/repo/'}
    }

    dependencies {
	    classpath 'com.android.tools.build:gradle:4.2.2'
	    classpath 'com.google.gms:google-services:4.3.10'
	    classpath 'com.huawei.agconnect:agcp:1.6.3.300'
    }
}

allprojects {
    repositories {
        google()
        maven {url 'https://developer.huawei.com/repo/'}
        maven { url "https://release.netmera.com/release/android" }
    }
}
```

If you get the following error;

“**problem occurred evaluating root project. Build was configured to prefer settings repositories over project repositories but repository 'Google' was added by build file 'build.gradle’ issue while building”**

→ go to setting.gradle and remove **dependencyResolutionManagement** block. 

More info can be found here.  [https://stackoverflow.com/a/69197871](https://stackoverflow.com/a/69197871) 

5. Add netmera dependency into your app level build.gradle.

```groovy
dependencies {

implementation 'com.netmera:nmcore:3.9.11'
implementation 'com.netmera:nmfcm:3.9.4'
implementation 'com.netmera:nmhms:3.9.5'

// If your app will support GMS only. 
//   implementation 'com.netmera:nmcore:3.9.11'
//   implementation 'com.netmera:nmfcm:3.9.4'

// If your app will support HMS only. 
//   implementation 'com.netmera:nmcore:3.9.11'
//   implementation 'com.netmera:nmhms:3.9.5'

}

// Must be added at the very bottom of your build.gradle file
apply plugin: 'com.google.gms.google-services'
apply plugin: 'com.huawei.agconnect'
```

6. Create an application class if you don’t have it in your App. 
7. Initialize Netmera in the onCreate method of the application class, which you have previously created. 

Please create an init-configuration using Netmera Configuration Builder as follows.

→ Api key can be found in Netmera Panel → Developers → API → Sdk Api Key 

```kotlin
import android.app.Application
import com.netmera.Netmera
import com.netmera.NetmeraConfiguration

class FintechApp : Application() {

    override fun onCreate() {
        super.onCreate()

        val configBuilder = NetmeraConfiguration.Builder()
        configBuilder
		.apiKey(<YOUR API KEY>)
		.baseUrl(<YOUR BASE URL>)// On-premise only 
                .firebaseSenderId(<YOUR SENDER ID>)
		.huaweiSenderId(<YOUR SENDER ID>)
		// It is recommended to turn off on release mode 
                .logging(true)
		// If you want to be notified of the received In-App Messages
		.nmInAppMessageActionCallbacks(NMInAppMessageActionCallbacks{...})
		// If you want to be notified of the received Push Messages
                .nmPushActionCallbacks(NMPushActionCallbacks{...})
		// If you want to take control of Web Widgets
		.nmWebWidgetCallbacks(NMWebWidgetCallbacks{...})
		
        Netmera.init(configBuilder.build(this))
    }
}
```

8. Adding Push Notification Permission.                                                        

→**Targeting API level 33 or above**                                                                                                        

**If you are running your application on a device with Android 13 or higher API level, you can ask for granting runtime push permissions anytime you want.** 

 **→Targeting an API level lower than API 33**                                                                                            

 **If you are running your application on a device with Android 13 or higher API level, the system shows the permission dialog whenever the notification channels are created. After calling Netmera.init method, the app’s notification channels will be created automatically and this will cause the system to trigger the popup dialog for granting permissions.**

Please note that in both cases the push notification permission is already granted by the system. 

(For Targeting API Level 33 and above)

**In case the notification permission is denied by the user and the `Netmera.requestNotificationPermissions()` method is called for a second time, the Netmera SDK will redirect the user to the notification settings of the operating system. If you want to prevent this situation, you could call `Netmera.areNotificationsEnabled()` method before re-requesting the runtime push notification permissions.**

9. Using Netmera as a secondary push messaging framework.

**!!! This part is necessary if you have already your own Firebase Service inside your application !!!**                                                               

PS: Before calling `**Netmera.onNetmeraPushMessage**` method, you should check whether the received message belongs to Netmera servers with the `**Netmera.isNetmeraRemoteMessage**` method.

```kotlin
class PushMessaging : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

        if (Netmera.isNetmeraRemoteMessage(remoteMessage)) {
            Netmera.onNetmeraPushMessageReceived(remoteMessage)
        } 
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Netmera.onNetmeraNewToken(token)
    }
}
```

10. If you are going to use the geofencing feature of Netmera, please be sure that you have added the following permissions in your manifest file and that you have granted the runtime background permissions for your application. 

```groovy
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/>
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
<uses-permission android:name="android.permission.ACCESS_BACKGROUND_LOCATION"/>

```

After that, you can call `**Netmera.requestPermissionsForLocation()**` method for triggering Netmera geofence operations.

11. If you want to specify your users on the Netmera Panel, please use the update user method to send information about your application's users to Netmera. 

```
val netmeraUser = NetmeraUser()
netmeraUser.userId = userId
netmeraUser.email = email
netmeraUser.msisdn = msisdn
netmeraUser.gender = gender
netmeraUser.name = name
netmeraUser.surname = surname
netmeraUser.dateOfBirth = dateOfBirthTimeStamp
netmeraUser.externalSegments = arrayListOf(segments)
Netmera.updateUser(netmeraUser)
```

** If more than built-in user attributes are needed for the use case;

 Go to panel → Developers → Profile Attributes → Create Attribute and create an attribute, you will see the output generated. Just place it into **YourCustomUser.**class which extends **NetmeraUser** class.
