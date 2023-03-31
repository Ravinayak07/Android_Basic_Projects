> STEP 1 (Add dependencies)

- Add this in build.gradle(Module:app) file

```
implementation 'com.jmedeisis:draglinearlayout:1.1.0'
```

- Add **jcenter()** in settings.gradle file
- Sync Now.

> STEP 3 (Modify Strings.xml)

```xml
<resources>
    <string name="app_name">DragLinearLayout</string>
    <string name="image_desc">Image</string>
    <string name="my_name">Ravi Shankar Nayak</string>
    <string name="clg_name">LPU</string>
</resources>
```

> STEP 4 (activity_main.xml)

```xml
<?xml version="1.0" encoding="utf-8"?>
<com.jmedeisis.draglinearlayout.DragLinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/container"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">


    <ImageView
        android:id="@+id/profile"
        android:layout_width="match_parent"
        android:layout_height="150dp"
        android:contentDescription="@string/image_desc"
        android:src="@drawable/profile" />

    <TextView
        android:id="@+id/name"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="@color/purple_500"
        android:padding="20dp"
        android:text="@string/my_name"
        android:textAlignment="center"
        android:textColor="@color/white"
        android:textSize="20sp"
        android:textStyle="bold"/>

    <TextView
        android:id="@+id/collge"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/clg_name"
        android:background="@color/purple_500"
        android:padding="20dp"
        android:textAlignment="center"
        android:textColor="@color/white"
        android:textSize="20sp"
        android:textStyle="bold"
        />


</com.jmedeisis.draglinearlayout.DragLinearLayout>
```

> STEP 5(MainActivity.kt)

```kotlin
package application.example.draglinearlayout

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.jmedeisis.draglinearlayout.DragLinearLayout


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // below lines is to initialize our Drag linear layout
        val dragLayout = findViewById<DragLinearLayout>(R.id.container)

        // we are creating for loop for dragging and dropping of child items.
        for (i in 0 until dragLayout.childCount) {

            // below is the child inside dragger layout
            val child: View = dragLayout.getChildAt(i)

            // below line will set all children draggable
            // except the header layout.
            // the child is its own drag handle.
            dragLayout.setViewDraggable(child, child)
        }
    }
}
```
