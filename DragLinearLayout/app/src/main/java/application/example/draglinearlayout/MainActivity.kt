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