package hiroki11x.viewoptionanimation;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;

/**
 * Created by hirokinaganuma on 16/09/03.
 */
public class OptionView extends ImageView {



    public OptionView(Context context) {
        super(context);
    }

    // for api 21 ~
    /*
    public OptionView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    */

    public OptionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public OptionView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    // タッチされた時の処理
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //押された瞬間に一度だけアニメーションしたい
                break;
        }
        return true;
    }

    /**
     * 画面サイズ変更時の通知
     * @param w, h, oldw, oldh
     */
    protected void onSizeChanged(int w, int h, int oldw, int oldh){
        Log.v("View", "onSizeChanged Width:" + w + ",Height:" + h);

        //キャンバス作成
//        mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
//        mCanvas = new Canvas(mBitmap);
    }

}
