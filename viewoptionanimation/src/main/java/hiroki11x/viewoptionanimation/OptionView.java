package hiroki11x.viewoptionanimation;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by hirokinaganuma on 16/09/03.
 */
public class OptionView extends FrameLayout {


    private int optionnum =3;
    private @DrawableRes int srcImageId;
    private @DrawableRes int optionImgResoureceId[] = new int[3];

    private ImageButton imgbutton[] = new ImageButton[3];
    private ImageView srcImage;

    public void setSrcImage(ImageView srcImage) {
        this.srcImage = srcImage;
    }

    public void setSrcImageResource(@DrawableRes int srcImageId) {
        this.srcImageId = srcImageId;
    }

    View.OnLongClickListener longclicklistener = new OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            Toast.makeText(getContext(),"OnLongClicked",Toast.LENGTH_LONG).show();
            Log.d("onLongClick","longclick");
            return true;
        }
    };

    // for api 21 ~
    /*
    public OptionView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    */

    //Call しない想定
    public OptionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.OptionView,
                defStyleAttr, 0);
        optionnum = typedArray.getInt(R.styleable.OptionView_option_num, 0);//XML設定された項目はここで読み取れる
        srcImageId = typedArray.getInt(R.styleable.OptionView_src_image_id, 0);//XML設定された項目はここで読み取れる
        typedArray.recycle();
        init();
    }


    //ここがデフォで呼ばれてる
    public OptionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.d("Call", "OptionView(Context context, AttributeSet attrs)");
        View layout = LayoutInflater.from(context).inflate(R.layout.optionviewlayout, this);

        imgbutton[0] = (ImageButton)layout.findViewById(R.id.imageButton);
        imgbutton[1] = (ImageButton)layout.findViewById(R.id.imageButton2);
        imgbutton[2] = (ImageButton)layout.findViewById(R.id.imageButton3);
        srcImage = (ImageView)layout.findViewById(R.id.imageView);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.OptionView);
        optionnum = typedArray.getInt(R.styleable.OptionView_option_num, 0);
        srcImageId = typedArray.getResourceId(R.styleable.OptionView_src_image_id, 0);
        optionImgResoureceId[0] = typedArray.getResourceId(R.styleable.OptionView_option_image_id1, 0);
        optionImgResoureceId[1] = typedArray.getResourceId(R.styleable.OptionView_option_image_id2, 0);
        optionImgResoureceId[2] = typedArray.getResourceId(R.styleable.OptionView_option_image_id3, 0);//
        Log.d("RESID 0: ",typedArray.getResourceId(R.styleable.OptionView_option_image_id1, 0)+"");
        Log.d("RESID 1: ",optionImgResoureceId[1]+"");
        Log.d("RESID 2: ",optionImgResoureceId[2]+"");
        typedArray.recycle();
        init();
    }

    //Call しない想定
    public OptionView(Context context) {
        super(context);
        init();
    }

    //各種初期化
    public void init(){
        Log.d("Call", "init()");
        this.setOnLongClickListener(longclicklistener);
        srcImage.setImageResource(srcImageId);
        for(int i = 0; i<optionnum ;i++){
            this.imgbutton[i].setImageResource(optionImgResoureceId[i]);
        }
    }

//    @Override
//    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//
//    }

    public void setOptionnum(int optionnum) {
        this.optionnum = optionnum;
    }

    public void setOptionImgResourece(@DrawableRes int[] resId) {
        optionImgResoureceId = resId;
    }


//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        // このViewGroupに指定されているレイアウトのモードを取得する
//        final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
//        final int heightMode = MeasureSpec.getMode(heightMeasureSpec);
//
//        if (widthMode != MeasureSpec.EXACTLY || heightMode != MeasureSpec.EXACTLY) {
//            // レイアウトモードがEXACTLY以外のときはエラーにする
//            throw new IllegalStateException("Must measure with an exact width");
//        }
//
//        // このViewGroupに割り当てられているサイズを取得する
//        final int widthSize = MeasureSpec.getSize(widthMeasureSpec);
//        final int heightSize = MeasureSpec.getSize(heightMeasureSpec);
//
//        // このViewGroupのサイズをセットする
//        setMeasuredDimension(widthSize, heightSize);
//    }

    /**
     * 画面サイズ変更時の通知
     * @param w, h, oldw, oldh
     */
    protected void onSizeChanged(int w, int h, int oldw, int oldh){
        Log.v("View", "onSizeChanged Width:" + w + ",Height:" + h);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }
}
