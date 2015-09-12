package journeys.yellowpyjamas.com.journeys;

import android.app.Activity;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import journeys.yellowpyjamas.com.journeys.support.Constants;

public class ActivityMain extends Activity {

    EditText searchJourneyEdit;

    Button requestJourneyButton;
    Button recordJourneyButton;

    ListView journeyList;

    Button prototypeJoinButton;
    Button prototypeStartButton;

    private static final int REQUEST_VISIBLE = 0;
    private static final int RECORD_VISIBLE = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loadPage();
    }

    private void loadPage() {
        setContentView(R.layout.layout_main);

        searchJourneyEdit = (EditText)findViewById(R.id.searchJourneyEdit);
        journeyList = (ListView)findViewById(R.id.journeyList);
        requestJourneyButton = (Button)findViewById(R.id.requestJourneyButton);
        recordJourneyButton = (Button)findViewById(R.id.recordJourneyButton);
        prototypeJoinButton = (Button)findViewById(R.id.prototypeJoinButton);
        prototypeStartButton = (Button)findViewById(R.id.prototypeStartButton);

        // Initially hide the requestJourneyButton
        toggleVisibility(RECORD_VISIBLE);

        // Text watcher for the edit text
        searchJourneyEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(searchJourneyEdit.getText().toString().length() >= 1) {
                    toggleVisibility(REQUEST_VISIBLE);
                }
                else {
                    toggleVisibility(RECORD_VISIBLE);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

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

    private void toggleVisibility(int visibility) {
        if(visibility == REQUEST_VISIBLE) {
            requestJourneyButton.setVisibility(Button.VISIBLE);
            recordJourneyButton.setVisibility(Button.GONE);
            // Set button color
            requestJourneyButton.getBackground().setColorFilter(Constants.BUTTON_COLOR, PorterDuff.Mode.MULTIPLY);
        }
        if(visibility == RECORD_VISIBLE) {
            requestJourneyButton.setVisibility(Button.GONE);
            recordJourneyButton.setVisibility(Button.VISIBLE);
        }
    }

    private void doJoin() {
        Toast.makeText(this, "Joining a cast", Toast.LENGTH_SHORT).show();
    }

    private void doStart() {
        Toast.makeText(this, "Starting a cast", Toast.LENGTH_SHORT).show();
    }

}
