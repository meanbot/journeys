package journeys.yellowpyjamas.com.journeys;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivityMain extends Activity {

    Button prototypeJoinButton;
    Button prototypeStartButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loadPage();
    }

    private void loadPage() {
        setContentView(R.layout.layout_main);

        prototypeJoinButton = (Button)findViewById(R.id.prototypeJoinButton);
        prototypeStartButton = (Button)findViewById(R.id.prototypeStartButton);

        prototypeJoinButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // join a cast
                doJoin();
            }
        });
        prototypeStartButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // start a cast
                doStart();
            }
        });
    }

    private void doJoin() {
        Toast.makeText(this, "Joining a cast", Toast.LENGTH_SHORT).show();
    }

    private void doStart() {
        Toast.makeText(this, "Starting a cast", Toast.LENGTH_SHORT).show();
    }

}
