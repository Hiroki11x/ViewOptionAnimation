package hiroki11x.viewoptionanimation;

import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;

/**
 * Created by hirokinaganuma on 16/09/03.
 */
public class SwipeAnimation {
    // 透過と移動のアニメーションを組み合わせる
    public static void slideInAnimation(View v) {


        v.setVisibility(View.VISIBLE);
        // 透過アニメーション
        AlphaAnimation alpha = new AlphaAnimation(0.0f, 1.0f);
        alpha.setDuration(300);

        // 移動アニメーション
        TranslateAnimation trans = new TranslateAnimation(
                0, 0, v.getHeight() + 500, 0
        );
        trans.setDuration(300);
        trans.setInterpolator(new DecelerateInterpolator());

        // アニメーションの組み合わせ
        AnimationSet set = new AnimationSet(false);
        set.addAnimation(alpha);
        set.addAnimation(trans);

        // アニメーション終了時の表示状態を維持する
        set.setFillEnabled(true);
        set.setFillAfter(true);

        // アニメーションを開始
        v.startAnimation(set);
    }

    // 透過と移動のアニメーションを組み合わせる
    public static void slideOutAnimation(final View v) {


        // 透過アニメーション
        AlphaAnimation alpha = new AlphaAnimation(1.0f, 0.0f);
        alpha.setDuration(250);

        // 移動アニメーション
        TranslateAnimation trans = new TranslateAnimation(
                0, 0, 0, v.getHeight() + 500
        );
        trans.setDuration(250);
        trans.setInterpolator(new AccelerateInterpolator());

        // アニメーションの組み合わせ
        AnimationSet set = new AnimationSet(false);
        set.addAnimation(alpha);
        set.addAnimation(trans);

        // アニメーション終了時の表示状態を維持する
        set.setFillEnabled(true);
        set.setFillAfter(true);

        // アニメーションを開始
        v.startAnimation(set);
        set.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationEnd(Animation animation) {
                v.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationStart(Animation animation) {
            }
        });
    }

    public static void disappearAnimation(View v) {

        // 透過アニメーション
        AlphaAnimation alpha = new AlphaAnimation(1.0f, 0.0f);
        alpha.setDuration(200);


        // アニメーションの組み合わせ
        AnimationSet set = new AnimationSet(false);
        set.addAnimation(alpha);

        // アニメーション終了時の表示状態を維持する
        set.setFillEnabled(true);
        set.setFillAfter(true);

        // アニメーションを開始
        v.startAnimation(set);
    }

    public static void appearAnimation(View v) {
        // 透過アニメーション
        AlphaAnimation alpha = new AlphaAnimation(0.0f, 0.5f);
        alpha.setDuration(200);


        // アニメーションの組み合わせ
        AnimationSet set = new AnimationSet(false);
        set.addAnimation(alpha);

        // アニメーション終了時の表示状態を維持する
        set.setFillEnabled(true);
        set.setFillAfter(true);

        // アニメーションを開始
        v.startAnimation(set);
        v.setVisibility(View.VISIBLE);
    }
}
