package hiroki11x.viewoptionanimation;

/**
 * Created by hirokinaganuma on 16/09/03.
 */
public class SwipeAnimation {
}

/*
public class AttackAnimation extends AnimationSet {

    protected Context context;
    protected ImageView dragonImageView;
    protected TextView damageTextView;

    public AttackAnimation(Context ctx, ImageView dragon, TextView damage) {
        super(false);
        this.context = ctx;
        this.dragonImageView = dragon;
        this.damageTextView = damage;

        // アニメーションオブジェクトを構成
        addAnimation(new VibrateAnimation());
        addAnimation(new WhiteoutAnimation());
        addAnimation(new DamageAnimation());
    }

    // 振動のアニメーション
    private class VibrateAnimation extends AnimationSet {
        public VibrateAnimation() {
            super(false);

            TranslateAnimation vibrateAnim;
            vibrateAnim = new TranslateAnimation(-8f, 16f, 0, 0);
            vibrateAnim.setRepeatCount(1);
            vibrateAnim.setRepeatMode(Animation.RESTART);

            addAnimation(vibrateAnim);
        }
    }

    // ホワイトアウトアニメーション
    private class WhiteoutAnimation extends AnimationSet {

        FrameLayout parentLayout ;
        ImageView whiteImageView ;
        Bitmap b ;

        public WhiteoutAnimation() {
            super(false);

            parentLayout = (FrameLayout) dragonImageView.getParent();

            BitmapDrawable drawable = (BitmapDrawable)dragonImageView.getDrawable() ;
            Bitmap bitmap = drawable.getBitmap() ;
            b = bitmap.copy(Bitmap.Config.ARGB_8888, true) ;

            int width  = b.getWidth() ;
            int height = b.getHeight() ;

            int[] pixels = new int[width*height];
            b.getPixels(pixels, 0, width, 0, 0, width, height) ;

            for (int i=0;i<width;i++) {
                for (int j=0;j<height;j++){
                    pixels[width*j+i] |= 0x00FFFFFF ;
                }
            }

            b.setPixels(pixels, 0, width, 0, 0, width, height);

            whiteImageView = new ImageView(context) ;
            whiteImageView.setImageBitmap(b) ;

            dragonImageView.post(new Runnable() {
                public void run() {
                    parentLayout.addView(whiteImageView) ;
                }
            });

            AlphaAnimation whiteoutAnim = new AlphaAnimation(0.8f, 0.0f);
            whiteoutAnim.setDuration(200);

            AnimationSet whiteVibrateSet = new AnimationSet(false) ;
            whiteVibrateSet.addAnimation(whiteoutAnim) ;
            whiteVibrateSet.addAnimation(new VibrateAnimation()) ;

            whiteVibrateSet.setAnimationListener(new AnimationListener() {
                @Override
                public void onAnimationStart(Animation anim) { }
                @Override
                public void onAnimationRepeat(Animation anim) { }

                @Override
                public void onAnimationEnd(Animation anim) {
                    parentLayout.post(new Runnable() {
                        public void run() {
                            parentLayout.removeViewInLayout(whiteImageView) ;
                        }
                    });
                }
            }) ;

            whiteImageView.startAnimation(whiteVibrateSet) ;
        }
    }

    // 数字のアニメーション
    private class DamageAnimation extends AnimationSet {

        FrameLayout parentLayout;
        LinearLayout damageLayout;
        private TextView[] damageTextViewSplit;

        public DamageAnimation() {
            super(false);

            // 新しく作った数字を配置するレイアウトdamageLayoutを作成
            parentLayout = (FrameLayout) damageTextView.getParent();
            damageLayout = new LinearLayout(context);
            damageLayout.setOrientation(LinearLayout.HORIZONTAL);

            damageLayout.setGravity(Gravity.CENTER);

            parentLayout.addView(damageLayout);

            String damageString = damageTextView.getText().toString();
            damageTextViewSplit = new TextView[damageString.length()];

            for (int idx = 0; idx < damageString.length(); idx++) {
                damageTextViewSplit[idx] = new TextView(context);
                damageTextViewSplit[idx].setText(String.valueOf(damageString
                        .charAt(idx)));
                damageTextViewSplit[idx].setTextSize(
                        TypedValue.COMPLEX_UNIT_PX,
                        damageTextView.getTextSize());
                damageTextViewSplit[idx].setTextColor(damageTextView
                        .getCurrentTextColor());

                damageLayout.addView(damageTextViewSplit[idx]);

                Animation damageAnim = new DamageValueAnimation(100 * idx,
                        100 * (8 + damageString.length() - idx));

                if (idx == damageString.length() - 1) {
                    damageAnim
                            .setAnimationListener(new RemoveSplitViewsAnimListener());
                }

                damageTextViewSplit[idx].startAnimation(damageAnim);
            }
        }

        private class DamageValueAnimation extends AnimationSet {
            public DamageValueAnimation(long startOffset, long duration) {
                super(false);
                // 数字の落下
                TranslateAnimation dropAnim = new TranslateAnimation(0, 0, 0,
                        40f);
                dropAnim.setDuration(duration);
                dropAnim.setStartOffset(startOffset);
                addAnimation(dropAnim);
                // + 数字の出現
                AlphaAnimation appearAnim = new AlphaAnimation(0.0f, 1.0f);
                appearAnim.setDuration(duration);
                appearAnim.setStartOffset(startOffset);
                addAnimation(appearAnim);

                // 数字の消失
                AlphaAnimation disappearAnim = new AlphaAnimation(1.0f, 0.0f);
                disappearAnim.setDuration(1000);
                disappearAnim.setStartOffset(startOffset + duration);
                addAnimation(disappearAnim);
            }
        }

        private class RemoveSplitViewsAnimListener implements AnimationListener {
            @Override
            public void onAnimationStart(Animation anim) {
            }

            @Override
            public void onAnimationRepeat(Animation anim) {
            }

            @Override
            public void onAnimationEnd(Animation anim) {
                damageLayout.post(new Runnable() {
                    public void run() {
                        damageLayout.removeAllViewsInLayout() ;
                    }
                });

                parentLayout.post(new Runnable() {
                    public void run() {
                        parentLayout.removeViewInLayout(damageLayout) ;
                    }
                });
            }
        }

    }

}
*/

// How to Use

/*
*
* // 攻撃アニメーション
    public void damageAnimation() {
        if (power > 0) {
            damageTextView.setText(String.valueOf(power));
        } else {
            damageTextView.setText("miss");
        }
        AttackAnimation attackAnim = new AttackAnimation(
                this.getApplicationContext(),
                dragonImageView, damageTextView);
        dragonImageView.startAnimation(attackAnim);
    }
*
* */