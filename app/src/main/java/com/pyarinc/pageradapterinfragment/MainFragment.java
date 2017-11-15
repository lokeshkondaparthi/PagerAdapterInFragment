package com.pyarinc.pageradapterinfragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.pyarinc.pageradapterinfragment.bottom_sheet.ItemListDialogFragment;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A fragment with a Google +1 button.
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {


    private ViewPager mViewPager ;
    private String[] mUrls = null;
    private Button btUpdate;
    private  ImageAdapter mImageAdapter;
    private EditText etEdit;
    public MainFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((MainActivity)getActivity()).setFragmentRefreshListener(new MainActivity.FragmentRefreshListener() {
            @Override
            public void onRefresh() {

                // Refresh Your Fragment
                mUpdateAdapter();
            }
        });


        mViewPager = (ViewPager) view.findViewById(R.id.image_container);
        btUpdate = (Button)view.findViewById(R.id.update_bt);
        etEdit = (EditText) view.findViewById(R.id.edit_image_et);
        mUrls = new String[]{"http://photos2.insidercdn.com/iphone4scamera-111004-full.JPG",
                "https://farm8.staticflickr.com/7569/15578888220_cd9b3d37df_b.jpg",
                "http://www.fujifilmusa.com/products/digital_cameras/x/fujifilm_x20/sample_images/img/index/ff_x20_008.JPG",
                "https://dummyimage.com/600x400/3668d6/e81783","https://image.rewardme.in/Assets/Modules/multisample/register_sample_new.jpg",
                "https://thumb1.shutterstock.com/display_pic_with_logo/356014/300246737/stock-vector-free-sample-red-stamp-text-on-white-300246737.jpg",
                "http://www.paisebachaoindia.com/wp-content/uploads/2016/02/616.png",
                "https://4.bp.blogspot.com/-v-BUjM_0WiE/Wbd3tNtZLCI/AAAAAAAAmY4/b-HyEskQzHIQ1a-hGMiim5HQonBRxleNwCLcBGAs/s1600/free%2Bsample%2Bmargo%2Bneam%2Bsoap.jpg",
                "https://cdn03.lucidsamples.com/c/14-category_default/free-sample-packs.jpg"};

        Singleton.mUrls.addAll( new ArrayList<>(Arrays.asList(mUrls)));
        mImageAdapter = new ImageAdapter(getActivity().getSupportFragmentManager());

        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           /*     if (etEdit.length() > 0) {
                    Singleton.mUrls.set(0, etEdit.getText().toString());
                }
                mImageAdapter.notifyDataSetChanged();*/
            showBottomSheetDialog();
            }
        });
        mViewPager.setAdapter(mImageAdapter);



    }

    public void showBottomSheetDialog() {
        ItemListDialogFragment.newInstance(1).show(getActivity().getSupportFragmentManager(), "dialog");
    }

    public void mUpdateAdapter() {
        mImageAdapter.notifyDataSetChanged();
    }

    @Override
    public void onResume() {
        super.onResume();
    }




}
