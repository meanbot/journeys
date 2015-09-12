package journeys.yellowpyjamas.com.journeys;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {

    private Context context;
    private final String[] gridImages;

    //Constructor to initialize values
    public GridAdapter(Context context, String[ ] gridImages) {

        this.context        = context;
        this.gridImages     = gridImages;
    }

    @Override
    public int getCount() {
        // Number of times getView method call depends upon gridValues.length
        return gridImages.length;
    }

    @Override
    public Object getItem(int position) {

        return null;
    }

    @Override
    public long getItemId(int position) {

        return 0;
    }


    // Number of times getView method call depends upon gridValues.length

    public View getView(int position, View convertView, ViewGroup parent) {

        // LayoutInflator to call external grid_item.xml file

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {

            gridView = new View(context);

            // get layout from grid_item.xml ( Defined Below )

            gridView = inflater.inflate( R.layout.rowlayout_journeys, null);

            // set value into textview

            ImageView liveImage = (ImageView) gridView.findViewById(R.id.liveImage);
            if(position == 0) {
                liveImage.setVisibility(ImageView.VISIBLE);
            }
            else {
                liveImage.setVisibility(ImageView.GONE);
            }

            // set image based on selected text

            ImageView rowTileVideo = (ImageView) gridView.findViewById(R.id.rowTileVideo);
            int resID;
            if(position == 0) {
                resID = R.drawable.image1;
            }
            else if(position == 1) {
                resID = R.drawable.image2;
            }
            else if(position == 2) {
                resID = R.drawable.image3;
            }
            else if(position == 3) {
                resID = R.drawable.image4;
            }
            else if(position == 4) {
                resID = R.drawable.image5;
            }
            else if(position == 5) {
                resID = R.drawable.image6;
            }
            else if(position == 6) {
                resID = R.drawable.image7;
            }
            else if(position == 7) {
                resID = R.drawable.image8;
            }
            else if(position == 8) {
                resID = R.drawable.image9;
            }
            else if(position == 9) {
                resID = R.drawable.image10;
            }
            else {
                resID = R.drawable.image11;
            }

            rowTileVideo.setImageDrawable(context.getResources().getDrawable(resID));
            rowTileVideo.setImageResource(context.getResources().getIdentifier("drawable/" + gridImages[position], null, null));

            TextView durationText = (TextView) gridView.findViewById(R.id.durationText);
            durationText.setText("1:06:10");

        } else {
            gridView = (View) convertView;
        }
        return gridView;
    }
}