# Dynamic App Icon Changer

**If you want to dynamically change the icon of your application, just follow the steps below.**


**First of all, the changes we need to make in the _AndroidManifet.xml_ file**

**Disable the original activity app icon in launcher**
---
   ```
   <activity
         android:name=".MainActivity"
         android:exported="true">
         <intent-filter>
             <action android:name="android.intent.action.MAIN" />
             // Disable the original activity app icon in launcher
             <!--<category android:name="android.intent.category.LAUNCHER" />-->
         </intent-filter>
   </activity>
   ```
---
   We need to add as many ```activity-alias``` as we want to add icons later.
   ---
   
   ```
           <activity-alias
            android:name=".RED"
            android:enabled="true"
            android:exported="true"
            android:icon="@mipmap/first"
            android:label="@string/app_name"
            android:roundIcon="@mipmap/first"
            android:targetActivity=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity-alias>

        <activity-alias
            android:name=".GREEN"
            android:enabled="false"
            android:exported="true"
            android:icon="@mipmap/second"
            android:label="@string/app_name"
            android:roundIcon="@mipmap/second"
            android:targetActivity=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity-alias>

        <activity-alias
            android:name=".BLUE"
            android:enabled="false"
            android:roundIcon="@mipmap/fourth"
            android:exported="true"
            android:icon="@mipmap/fourth"
            android:label="@string/app_name"
            android:targetActivity=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity-alias>
        
 ```
 ---
**What we need to pay attention to here is ```android:enabled="true"``` in the first ```activity-alias``` tag and ```android:enabled="false"``` in the other added ```activity-alias``` tags.**

**What to do in MainActivity.**
---
```
 private fun setIcon(targetColour: ICON_COLOUR) {
        for (value in ICON_COLOUR.values()) {
            val action = if (value == targetColour) {
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED
            } else {
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED
            }
            packageManager.setComponentEnabledSetting(
                ComponentName(BuildConfig.APPLICATION_ID, "${BuildConfig.APPLICATION_ID}.${value.name}"),
                action, PackageManager.DONT_KILL_APP
            )
        }
    }
```
---

```
 enum class ICON_COLOUR { RED, GREEN, BLUE }
```

---
```
 btnFirst.setOnClickListener {
        setIcon(ICON_COLOUR.BLUE)
        }
        btnSecond.setOnClickListener {
            setIcon(ICON_COLOUR.RED)
        }
        btnThird.setOnClickListener {
            setIcon(ICON_COLOUR.GREEN)
        }
   }
 ```
 ---

 
   
   

