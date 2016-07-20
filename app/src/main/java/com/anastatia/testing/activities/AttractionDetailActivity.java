package com.anastatia.testing.activities;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.anastatia.testing.R;
import com.anastatia.testing.TestingApp;
import com.anastatia.testing.data.agents.model.AttractionModel;
import com.anastatia.testing.data.vos.AttractionVO;
import com.anastatia.testing.utils.MyanmarAttractionsConstants;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AttractionDetailActivity extends AppCompatActivity {

    private static final String IE_ATTRACTION_TITLE = "IE_ATTRACTION_TITLE";
    @BindView(R.id.toolbar)
    Toolbar toolbar;

//    @BindView(R.id.tv_title)
//    TextView tvAttractionTitle;

    @BindView(R.id.tv_detailDesc)
    TextView tvAttractionDesc;


    @BindView(R.id.iv_detailImg)
    ImageView ivAttraction;


//    @BindView(R.id.pager_attraction_images)
//    ViewPager pagerAttractionImages;

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;

//    @BindView(R.id.pi_attraction_image_slider)
//    PageIndicatorView piAttractionImageSlider;

    private AttractionVO mAttraction;
    private String mAttractionTitle;

    public static Intent newIntent(String attractionTitle){
        Intent intent = new Intent(TestingApp.getContext(), AttractionDetailActivity.class);
        intent.putExtra(IE_ATTRACTION_TITLE, attractionTitle);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);

        ButterKnife.bind(this, this);

        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        mAttractionTitle = getIntent().getStringExtra(IE_ATTRACTION_TITLE);

        AttractionVO attractionVO = AttractionModel.getInstance().getAttractionByTitle(mAttractionTitle);
        if(attractionVO == null) {
            throw new RuntimeException("Can't find Event obj with the title : "+mAttractionTitle);
        } else {
            collapsingToolbar.setTitle(attractionVO.getTitle());
            tvAttractionDesc.setText(attractionVO.getDesc() + "\n\n" +
                    attractionVO.getDesc());

            String imageUrl = MyanmarAttractionsConstants.IMAGE_ROOT_DIR + attractionVO.getImages()[0];

        Glide.with(ivAttraction.getContext())
                .load(imageUrl)
                .centerCrop()
                .placeholder(R.drawable.cityexpresslogo)
                .error(R.drawable.cityexpresslogo)
                .into(ivAttraction);
        }
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //overridePendingTransition(R.anim.pop_enter, R.anim.pop_exit);
    }

}
