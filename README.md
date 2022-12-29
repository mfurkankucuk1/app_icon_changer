
# Dynamic App Icon Change

If you want to dynamically change the icon of your application, just follow the steps below.

First of all, the changes we need to make in the `AndroidManifet.xml` file


## Disable the original activity app icon in launcher

```kotlin
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

## We need to add as many `activity-alias` as we want to add icons later.

```kotlin
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

What we need to pay attention to here is `android:enabled="true"` in the first activity-alias tag and `android:enabled="false"` in the other added `activity-alias` tags.


## What to do in MainActivity.

```kotlin
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

## Enum Class

```kotlin
 enum class ICON_COLOUR { RED, GREEN, BLUE }
```

## Button Click

```kotlin
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
## 🔗 Links
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/muhammed-furkan-kucuk-40897111a/)
[![google](https://img.shields.io/badge/google-0A66C2?style=for-the-badge&logo=google&logoColor=orange)](https://g.dev/mfurkankck)
