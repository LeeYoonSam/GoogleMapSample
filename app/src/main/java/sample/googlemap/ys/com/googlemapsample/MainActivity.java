package sample.googlemap.ys.com.googlemapsample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ArrayList<String> alMenus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initMenu();
    }

    private void initMenu() {
        alMenus = new ArrayList<>();
        alMenus.add("GoogleMap Full");
        alMenus.add("GoogleMap Inner");

        RecyclerView rvMenu = (RecyclerView)findViewById(R.id.rvMenu);
        rvMenu.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rvMenu.setLayoutManager(layoutManager);

        RecyclerView.Adapter adapter = new MainAdapter(alMenus);
        rvMenu.setAdapter(adapter);

        rvMenu.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            GestureDetector gestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {

                @Override public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

            });
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

                View child = rv.findChildViewUnder(e.getX(), e.getY());
                if(child != null && gestureDetector.onTouchEvent(e)) {
                    int position = rv.getChildAdapterPosition(child);
                    moveActivity(position);
                }

                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
    }

    private void moveActivity(int position) {
        Intent intent = null;

        switch (position) {
            case 0:
                intent = new Intent(MainActivity.this, FullMapsActivity.class);
                break;

            case 1:
                intent = new Intent(MainActivity.this, InnerMapsActivity.class);
                break;
        }

        if(intent != null)
            startActivity(intent);
    }
}
