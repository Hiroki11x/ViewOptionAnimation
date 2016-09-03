package hiroki11x.viewoptionanimation.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import hiroki11x.viewoptionanimation.OptionView;

public class MainActivity extends AppCompatActivity{

    public OptionView optionView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        optionView = (OptionView)findViewById(R.id.optionView);
//        int resIdArray[] = {R.drawable.copy_link_white,R.drawable.share_symbol_white,R.drawable.eye_white};
//        optionView.setOptionnum(3);
//        optionView.setOptionImgResourece(resIdArray);
//        optionView.setSrcImageResource(R.drawable.sample_image);
//        optionView.init();
    }
}
