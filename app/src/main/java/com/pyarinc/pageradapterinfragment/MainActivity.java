package com.pyarinc.pageradapterinfragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.pyarinc.pageradapterinfragment.bottom_sheet.ItemListDialogFragment;

public class MainActivity extends AppCompatActivity implements ImageLoadingFragment.OnFragmentInteractionListener,ItemListDialogFragment.Listener{

    public static final int REQUEST_CODE_FOR_IMAGE_SELECTION = 1;
    private ViewPager mViewPager ;
    private String[] mUrls = null;
    private Button btUpdate;
    private ImageAdapter mImageAdapter;
    private EditText etEdit;
    private FrameLayout mContainer;
    private FragmentRefreshListener fragmentRefreshListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContainer = (FrameLayout) findViewById(R.id.container);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction  =manager.beginTransaction();
        MainFragment fragment = new MainFragment();
        transaction.add(R.id.container,fragment,"main_fragment");
        transaction.commit();


    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onItemClicked(int position) {
        Toast.makeText(this, "bottom sheet item clicked!"+position, Toast.LENGTH_SHORT).show();
            startActivityForResult(new Intent(MainActivity.this,ImageSelectionActivity.class),REQUEST_CODE_FOR_IMAGE_SELECTION);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this, "date set changed!", Toast.LENGTH_SHORT).show();

        if(getFragmentRefreshListener()!=null){
            getFragmentRefreshListener().onRefresh();
        }

    }

    public interface FragmentRefreshListener{
        void onRefresh();
    }

    public FragmentRefreshListener getFragmentRefreshListener() {
        return fragmentRefreshListener;
    }

    public void setFragmentRefreshListener(FragmentRefreshListener fragmentRefreshListener) {
        this.fragmentRefreshListener = fragmentRefreshListener;
    }
}
