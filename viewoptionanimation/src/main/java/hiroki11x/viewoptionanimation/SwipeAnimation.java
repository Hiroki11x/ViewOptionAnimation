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
    public static void slideInAnimation(View v) {


        v.setVisibility(View.VISIBLE);
        AlphaAnimation alpha = new AlphaAnimation(0.0f, 1.0f);
        alpha.setDuration(300);

        TranslateAnimation trans = new TranslateAnimation(
                0, 0, v.getHeight() + 500, 0
        );
        trans.setDuration(300);
        trans.setInterpolator(new DecelerateInterpolator());

        AnimationSet set = new AnimationSet(false);
        set.addAnimation(alpha);
        set.addAnimation(trans);

        set.setFillEnabled(true);
        set.setFillAfter(true);

        v.startAnimation(set);
    }

    public static void slideOutAnimation(final View v) {

        AlphaAnimation alpha = new AlphaAnimation(1.0f, 0.0f);
        alpha.setDuration(250);

        TranslateAnimation trans = new TranslateAnimation(
                0, 0, 0, v.getHeight() + 500
        );
        trans.setDuration(250);
        trans.setInterpolator(new AccelerateInterpolator());

        AnimationSet set = new AnimationSet(false);
        set.addAnimation(alpha);
        set.addAnimation(trans);

        set.setFillEnabled(true);
        set.setFillAfter(true);

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

        AlphaAnimation alpha = new AlphaAnimation(1.0f, 0.0f);
        alpha.setDuration(200);

        AnimationSet set = new AnimationSet(false);
        set.addAnimation(alpha);

        set.setFillEnabled(true);
        set.setFillAfter(true);

        v.startAnimation(set);
    }

    public static void appearAnimation(View v) {

        AlphaAnimation alpha = new AlphaAnimation(0.0f, 0.5f);
        alpha.setDuration(200);

        AnimationSet set = new AnimationSet(false);
        set.addAnimation(alpha);

        set.setFillEnabled(true);
        set.setFillAfter(true);

        v.startAnimation(set);
        v.setVisibility(View.VISIBLE);
    }
}
