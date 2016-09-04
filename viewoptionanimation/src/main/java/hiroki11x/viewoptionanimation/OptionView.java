package hiroki11x.viewoptionanimation;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.net.Uri;
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

    private final Builder builder = new Builder();

    private int option_index = 0;

    private boolean is_option_appear = false;
    private int optionnum = 3;
    @DrawableRes
    private int srcImageId;
    @DrawableRes
    private int optionImgResoureceId[] = new int[3];
    private String titles[] = new String[3];

    private ImageButton imgbuttons[] = new ImageButton[3];
    private TextView textviews[] = new TextView[3];
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
            for (int i = 0; i < optionnum; i++) {
                SwipeAnimation.slideInAnimation(imgbuttons[i]);
                SwipeAnimation.slideInAnimation(textviews[i]);
            }
            SwipeAnimation.appearAnimation(BlackFilter);
            is_option_appear = true;
            return true;
        }
    };

    View.OnClickListener clicklistener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            if (!is_option_appear) {
                return;
            }

            is_option_appear = false;
            for (int i = 0; i < optionnum; i++) {
                SwipeAnimation.slideOutAnimation(imgbuttons[i]);
                SwipeAnimation.slideOutAnimation(textviews[i]);
            }
            SwipeAnimation.disappearAnimation(BlackFilter);
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
    }


    //ここがデフォで呼ばれてる
    public OptionView(Context context, AttributeSet attrs) {
        super(context, attrs);

        initViewFromID(context);
        initFromXML(context, attrs);
        initResource();
    }

    //Call しない想定
    public OptionView(Context context) {
        super(context);
        initResource();
    }

    //IDの関連づけなど
    public void initViewFromID(Context context) {
        View layout = LayoutInflater.from(context).inflate(R.layout.optionviewlayout, this);
        BlackFilter = (FrameLayout) layout.findViewById(R.id.black_filter);
        imgbuttons[0] = (ImageButton) layout.findViewById(R.id.imageButton);
        imgbuttons[1] = (ImageButton) layout.findViewById(R.id.imageButton2);
        imgbuttons[2] = (ImageButton) layout.findViewById(R.id.imageButton3);
        textviews[0] = (TextView) layout.findViewById(R.id.textView);
        textviews[1] = (TextView) layout.findViewById(R.id.textView2);
        textviews[2] = (TextView) layout.findViewById(R.id.textView3);
        srcImage = (ImageView) layout.findViewById(R.id.imageView);
        for (int i = 0; i < optionnum; i++) {
            imgbuttons[i].setVisibility(View.INVISIBLE);
            textviews[i].setVisibility(View.INVISIBLE);
        }
        BlackFilter.setVisibility(View.INVISIBLE);
    }


    public void initFromXML(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.OptionView);
        optionnum = typedArray.getInt(R.styleable.OptionView_option_num, 0);
        srcImageId = typedArray.getResourceId(R.styleable.OptionView_src_image_id, 0);
        optionImgResoureceId[0] = typedArray.getResourceId(R.styleable.OptionView_option_image_id1, 0);
        optionImgResoureceId[1] = typedArray.getResourceId(R.styleable.OptionView_option_image_id2, 0);
        optionImgResoureceId[2] = typedArray.getResourceId(R.styleable.OptionView_option_image_id3, 0);
        titles[0] = typedArray.getString(R.styleable.OptionView_option_text_id1);
        titles[1] = typedArray.getString(R.styleable.OptionView_option_text_id2);
        titles[2] = typedArray.getString(R.styleable.OptionView_option_text_id3);
        typedArray.recycle();
    }

    //XMLからの各種初期化
    public void initResource() {
        this.setOnLongClickListener(longclicklistener);
        this.setOnClickListener(clicklistener);
        srcImage.setImageResource(srcImageId);
        for (int i = 0; i < optionnum; i++) {
            this.imgbuttons[i].setImageResource(optionImgResoureceId[i]);
        }
    }

    //XML使わない場合(Builder経由で呼ばれたい)
    private void addOption(@DrawableRes int resId, String text, View.OnClickListener listener) {
        this.optionImgResoureceId[option_index] = resId;
        this.textviews[option_index].setText(text);
        imgbuttons[option_index].setOnClickListener(listener);
        this.imgbuttons[option_index].setImageResource(resId);
        option_index++;
    }

    private void addOption(Uri imageUri, String text, View.OnClickListener listener) {
        this.optionImgResoureceId[option_index] = -1;
        this.textviews[option_index].setText(text);
        imgbuttons[option_index].setOnClickListener(listener);
        URLImageloader task = new URLImageloader(this.imgbuttons[option_index],10,10);
        task.execute(imageUri.toString());
        option_index++;
    }

    public void setOptionImgResourece(@DrawableRes int[] resId) {
        optionImgResoureceId = resId;
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        Log.v("View", "onSizeChanged Width:" + w + ",Height:" + h);
    }

    // Regacy Code
    /*
    public void setOptionnum(int optionnum) {
        this.optionnum = optionnum;
    }

     public void setOptionListeners(View.OnClickListener listeners[]){
        for(int i = 0;i<optionnum;i++){
            imgbuttons[i].setOnClickListener(listeners[i]);
        }
    }
    */

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    //XMLから入ってる情報を初期値としてセット
    public Builder addOption() {
        builder.text(titles[option_index]);
        builder.resId(optionImgResoureceId[option_index]);
        return builder;
    }

    public class Builder {

        @DrawableRes
        private int resId;
        private String text;
        private Uri imageUri;
        private View.OnClickListener listener;

        public Builder resId(@DrawableRes int resId) {
            this.resId = resId;
            return this;
        }

        public Builder listener(View.OnClickListener listener) {
            this.listener = listener;
            return this;
        }

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public Builder imageUri(Uri uri) {
            this.imageUri = uri;
            return this;
        }

        public void build() {
            if(imageUri == null){
                addOption(resId, text, listener);
            }else{
                addOption(imageUri,text, listener);
            }
        }
    }

}
