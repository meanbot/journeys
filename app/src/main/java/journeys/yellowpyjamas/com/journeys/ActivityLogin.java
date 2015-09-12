package journeys.yellowpyjamas.com.journeys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class ActivityLogin extends Activity {

    Button prototypeLoginButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loadPage();
    }

    private void loadPage() {
        setContentView(R.layout.layout_login);

        prototypeLoginButton = (Button)findViewById(R.id.prototypeLoginButton);

        prototypeLoginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Go to the main screen
                startMain();
            }
        });
    }

    private void startMain() {
        Intent mainIntent = new Intent(ActivityLogin.this, ActivityMain.class);
        startActivity(mainIntent);
    }

}
