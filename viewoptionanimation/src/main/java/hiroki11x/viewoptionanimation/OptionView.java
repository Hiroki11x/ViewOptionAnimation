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
import android.widget.TextView;

/**
 * Created by hirokinaganuma on 16/09/03.
 */
public class OptionView extends FrameLayout {

    private static int option_index = 0;

    private boolean is_option_appear = false;
    private int optionnum = 3;
    private @DrawableRes int srcImageId;
    private @DrawableRes int optionImgResoureceId[] = new int[3];

    private ImageButton imgbutton[] = new ImageButton[3];
    private TextView textview[] = new TextView[3];
    private FrameLayout optionframe[] = new FrameLayout[3];
    private ImageView srcImage;

    private FrameLayout BlackFilter;

    public void setSrcImage(ImageView srcImage) {
        this.srcImage = srcImage;
    }

    public void setSrcImageResource(@DrawableRes int srcImageId) {
        this.srcImageId = srcImageId;
        this.srcImage.setImageResource(srcImageId);
    }

    View.OnLongClickListener longclicklistener = new OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            for(int i = 0;i<optionnum;i++){
                SwipeAnimation.slideInAnimation(imgbutton[i]);
                SwipeAnimation.slideInAnimation(textview[i]);
            }
            SwipeAnimation.appearAnimation(BlackFilter);
            is_option_appear = true;
            return true;
        }
    };

    View.OnClickListener clicklistener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            if(!is_option_appear){
                return;
            }

            is_option_appear = false;
            for(int i = 0;i<optionnum;i++){
                SwipeAnimation.slideOutAnimation(imgbutton[i]);
                SwipeAnimation.slideOutAnimation(textview[i]);
            }
            SwipeAnimation.disappearAnimation(BlackFilter);
        }
    };


    public void setOptionListeners(View.OnClickListener listeners[]){
        for(int i = 0;i<optionnum;i++){
            imgbutton[i].setOnClickListener(listeners[i]);
        }
    }

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
        initFromXML(context, attrs);
    }


    //ここがデフォで呼ばれてる
    //XMLからの設定はここ
    public OptionView(Context context, AttributeSet attrs) {
        super(context, attrs);

        initViewFromID(context);
        initFromXML(context, attrs);
        initImageResource();
    }

    //Call しない想定
    public OptionView(Context context) {
        super(context);
        initImageResource();
    }

    public void initViewFromID(Context context){
        View layout = LayoutInflater.from(context).inflate(R.layout.optionviewlayout, this);
        BlackFilter = (FrameLayout)layout.findViewById(R.id.black_filter);
        imgbutton[0] = (ImageButton)layout.findViewById(R.id.imageButton);
        imgbutton[1] = (ImageButton)layout.findViewById(R.id.imageButton2);
        imgbutton[2] = (ImageButton)layout.findViewById(R.id.imageButton3);
        textview[0] = (TextView)layout.findViewById(R.id.textView);
        textview[1] = (TextView)layout.findViewById(R.id.textView2);
        textview[2] = (TextView)layout.findViewById(R.id.textView3);
        optionframe[0] = (FrameLayout)layout.findViewById(R.id.framelayout);
        optionframe[0] = (FrameLayout)layout.findViewById(R.id.framelayout2);
        optionframe[0] = (FrameLayout)layout.findViewById(R.id.framelayout3);
        srcImage = (ImageView)layout.findViewById(R.id.imageView);
        for(int i = 0;i<optionnum;i++){
            imgbutton[i].setVisibility(View.INVISIBLE);
            textview[i].setVisibility(View.INVISIBLE);
        }
        BlackFilter.setVisibility(View.INVISIBLE);
    }


    public void initFromXML(Context context, AttributeSet attrs){
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.OptionView);
        optionnum = typedArray.getInt(R.styleable.OptionView_option_num, 0);
        srcImageId = typedArray.getResourceId(R.styleable.OptionView_src_image_id, 0);
        optionImgResoureceId[0] = typedArray.getResourceId(R.styleable.OptionView_option_image_id1, 0);
        optionImgResoureceId[1] = typedArray.getResourceId(R.styleable.OptionView_option_image_id2, 0);
        optionImgResoureceId[2] = typedArray.getResourceId(R.styleable.OptionView_option_image_id3, 0);
        typedArray.recycle();
    }

    //XMLからの各種初期化
    public void initImageResource(){
        this.setOnLongClickListener(longclicklistener);
        this.setOnClickListener(clicklistener);
        srcImage.setImageResource(srcImageId);
        for(int i = 0; i<optionnum ;i++){
            this.imgbutton[i].setImageResource(optionImgResoureceId[i]);
        }
    }

    //XML使わない場合
    public void addOption(@DrawableRes int resId,String text ,View.OnClickListener listener){
        this.optionImgResoureceId[option_index] = resId;
        this.textview[option_index].setText(text);
        imgbutton[option_index].setOnClickListener(listener);
        this.imgbutton[option_index].setImageResource(resId);
        option_index++;
    }

    public void setOptionnum(int optionnum) {
        this.optionnum = optionnum;
    }

    public void setOptionImgResourece(@DrawableRes int[] resId) {
        optionImgResoureceId = resId;
    }

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
