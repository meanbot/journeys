package journeys.yellowpyjamas.com.journeys;

import journeys.yellowpyjamas.com.journeys.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

public class ActivityStartup extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_startup);

        loadPage();
    }

    private void loadPage() {
        // Just go to the login page for now, more logic to follow later
        Intent loginIntent = new Intent(ActivityStartup.this, ActivityLogin.class);
        startActivity(loginIntent);
    }
}
