package com.pyarinc.pageradapterinfragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ImageSelectionActivity extends AppCompatActivity {

    public static final int RESULT_CODE_BACK_RESULT = 2;
    private EditText etImageNumber;

    String [] mUrls = new String[]{"http://photos2.insidercdn.com/iphone4scamera-111004-full.JPG",
            "https://farm8.staticflickr.com/7569/15578888220_cd9b3d37df_b.jpg",
            "http://www.fujifilmusa.com/products/digital_cameras/x/fujifilm_x20/sample_images/img/index/ff_x20_008.JPG",
            "https://dummyimage.com/600x400/3668d6/e81783","https://image.rewardme.in/Assets/Modules/multisample/register_sample_new.jpg",
            "https://thumb1.shutterstock.com/display_pic_with_logo/356014/300246737/stock-vector-free-sample-red-stamp-text-on-white-300246737.jpg",
            "http://www.paisebachaoindia.com/wp-content/uploads/2016/02/616.png",
            "https://4.bp.blogspot.com/-v-BUjM_0WiE/Wbd3tNtZLCI/AAAAAAAAmY4/b-HyEskQzHIQ1a-hGMiim5HQonBRxleNwCLcBGAs/s1600/free%2Bsample%2Bmargo%2Bneam%2Bsoap.jpg",
            "https://cdn03.lucidsamples.com/c/14-category_default/free-sample-packs.jpg"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_selection);
        etImageNumber  = (EditText) findViewById(R.id.etSetImageNumber);

    }

    public void setImage(View view) {
        if (Integer.parseInt(etImageNumber.getText().toString()) < 9) {
            Singleton.mUrls.set(0,mUrls[Integer.parseInt(etImageNumber.getText().toString())]);
            finish();
        }
        else{
            Toast.makeText(this, "Please select lessthan 10 number", Toast.LENGTH_SHORT).show();
        }

    }
}
