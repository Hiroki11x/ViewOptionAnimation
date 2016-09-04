[![License](https://img.shields.io/badge/license-Apache%202-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0)
 [ ![Download](https://api.bintray.com/packages/hiroki11x/maven/optionviewanimation/images/download.svg) ](https://bintray.com/hiroki11x/maven/optionviewanimation/_latestVersion)

Screenshot

<img src="https://media.giphy.com/media/26uf70we2A1FnWccE/giphy.gif" width="50%">

Inspired by [Afnizar Nur Ghifari](https://dribbble.com/flamekaizar) 's UX [design](https://dribbble.com/shots/2935434-Visval-Blog-Shorthand-Animation) Thank you.


How do I use it?
---

### Setup

##### Dependencies
```groovy
dependencies {
    compile 'jp.hiroki11x:optionviewanimation:0.0.1'
}
```

### Functions

There is a simple initialization step which occurs in your Activity class:  
**Simple**
```java
public class MyActivity extends Activity {
  public void onCreate() {
    super.onCreate();

    listeners[0] = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Function which option is clicked
            }
    };

    listeners[1] = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Function which option is clicked
            }
    };

    listeners[2] = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Function which option is clicked
            }
    };

    optionView = (OptionView) findViewById(R.id.optionView);
    optionView.setSrcImageResource(R.drawable.sample_image);

    //it is possible to set params from builder
    optionView.addOption()
              .resId(R.drawable.share_symbol_white)
              .listener(listeners[0])
              .text("Share")
              .build();

    //it is possible to set params from XML attribute without listner
    optionView.addOption()
              .listener(listeners[1])
              .build();

    //it is possible to set image from Uri
    optionView.addOption()
             .imageUri(Uri.parse("http://hoge.com.png"))
             .listener(listeners[2])
             .text("Copy Link")
             .build();

  }
}
```

then you use `OptionView` in `activity_main.xml`

```XML
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:optionview="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context="hiroki11x.viewoptionanimation.example.MainActivity">

    <hiroki11x.viewoptionanimation.OptionView
        android:id="@+id/optionView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:paddingBottom="@dimen/activity_vertical_margin"
        android:paddingLeft="@dimen/activity_horizontal_margin"
        android:paddingRight="@dimen/activity_horizontal_margin"
        android:paddingTop="@dimen/activity_vertical_margin"
        optionview:option_image_id1="@drawable/share_symbol_white"
        optionview:option_image_id2="@drawable/eye_white"
        optionview:option_image_id3="@drawable/copy_link_white"
        optionview:option_num="3"
        optionview:option_text_id1="Share"
        optionview:option_text_id2="View Detail"
        optionview:option_text_id3="Copy Link"
        optionview:src_image_id="@drawable/sample_image" />
</FrameLayout>

```

**Java Options**

- `resId(@DrawableRes int resId)` is a resource id of drawable
- `listener(View.OnClickListener listener)` is a listener
- `text(String text) ` is a text.
- `imageUri(Uri uri) ` is a uri of image resource.

```java
optionView.addOption()
                .resId(R.drawable.copy_link_white)
                .listener(listener)
                .text("Copy Link")
                .build();
```

**Listener**

```java
optionView.addOption()
          .listener(listener)
          .build();
```

**XML Options**

At first, you have to insert

```XML
xmlns:optionview="http://schemas.android.com/apk/res-auto"
```

in your layout xml file

- `optionview:option_image_id1` is a first option image's resource reference
- `optionview:option_image_id2` is a second option image's resource reference
- `optionview:option_image_id3` is a third option image's resource reference
- `optionview:option_text_id1` is a first option's title
- `optionview:option_text_id2` is a second option's title
- `optionview:option_text_id3` is a third option's title
- `optionview:option_num` is a num of option, but you have to set 3 now. default is 3.
- `optionview:src_image_id` is a main image's resource reference
- `optionview:option_text_sp` is a option's text size dimension
- `optionview:option_image_width` is a option image's width (it is valid when you get option's image from Uri)
- `optionview:option_image_height` is a option image's height (it is valid when you get option's image from Uri)

```java
optionView.addOption()
                .resId(R.drawable.copy_link_white)
                .listener(listener)
                .text("Copy Link")
                .build();
```

**Tips**
you can set option's image from uri

```java
optionView.addOption()
                .imageUri(Uri.parse("http://hoge.com.png"))
                .listener(listener)
                .text("Copy Link")
                .build();
```



Requirements
--------------
Android 4.1+

License
-------

    Copyright 2016 Hiroki11x (Hiroki Naganuma)

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
