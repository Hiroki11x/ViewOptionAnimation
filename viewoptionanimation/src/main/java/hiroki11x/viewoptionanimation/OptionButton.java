package hiroki11x.viewoptionanimation;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by hirokinaganuma on 16/09/03.
 *
 * Legacy Code
 */
public class OptionButton extends ImageButton {

    public ImageButton imgButton;
    private View.OnClickListener listener;
    private @DrawableRes int resId;

    public OptionButton(Context context) {
        super(context);
    }

    public void setImgButton(ImageButton imgButton) {
        this.imgButton = imgButton;
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
        this.setListener(this.listener);
    }

    public void setImageResource(@DrawableRes int resId) {
        this.resId = resId;
    }
}
