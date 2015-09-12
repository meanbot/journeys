package journeys.yellowpyjamas.com.journeys;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class SquareRelativeLayout extends RelativeLayout {

    public SquareRelativeLayout(final Context context)
    {
        super(context);
    }

    public SquareRelativeLayout(final Context context, final AttributeSet attrs)
    {
        super(context, attrs);
    }

    public SquareRelativeLayout(final Context context, final AttributeSet attrs, final int defStyle)
    {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}
