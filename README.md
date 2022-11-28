# Dynamic App Icon Changer

**If you want to dynamically change the icon of your application, just follow the steps below.**


**First of all, the changes we need to make in the _AndroidManifet.xml_ file**

**Disable the original activity app icon in launcher**

   ```<activity
         android:name=".MainActivity"
         android:exported="true">
         <intent-filter>
             <action android:name="android.intent.action.MAIN" />
             <!--<category android:name="android.intent.category.LAUNCHER" />-->
         </intent-filter>
   </activity>```

