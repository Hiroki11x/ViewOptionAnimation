package hiroki11x.viewoptionanimation;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Build;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by hirokinaganuma on 16/09/04.
 */

public class URLImageloader extends AsyncTask<String,Void,Bitmap> {
    private ImageView image;
    private int width,height;

    public URLImageloader(ImageButton _image, int w, int h) {
        image = _image;
        width = w;
        height = h;
    }
    @Override
    protected Bitmap doInBackground(String... params) {
        Bitmap image;
        BitmapFactory.Options options = new  BitmapFactory.Options();
        options.inMutable = true;
        try {
            URL imageUrl = new URL(params[0]);
            InputStream imageIs;
            imageIs = imageUrl.openStream();
            image = BitmapFactory.decodeStream(imageIs,null,options);

            return image;
        } catch (MalformedURLException e) {
            return null;
        } catch (IOException e) {
            return null;
        }
    }
    @Override
    protected void onPostExecute(Bitmap result) {
        /** for API 19~ **/
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            result.setWidth(width);
            result.setHeight(height);
        }
        image.setImageBitmap(result);
    }
}