package com.framgia.fdms.utils.binding;

import android.content.res.Resources;
import android.databinding.BindingAdapter;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.framgia.fdms.R;
import com.framgia.fdms.screen.newmain.NewMainViewModel;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.formatter.PercentFormatter;

import static com.framgia.fdms.screen.newmain.NewMainViewModel.Tab.TAB_DASH_BOARD;
import static com.framgia.fdms.screen.newmain.NewMainViewModel.Tab.TAB_DEVICE_MANAGER;
import static com.framgia.fdms.screen.newmain.NewMainViewModel.Tab.TAB_PROFILE;
import static com.framgia.fdms.screen.newmain.NewMainViewModel.Tab.TAB_REQUEST_MANAGER;
import static com.framgia.fdms.utils.Constant.PERCENT;

/**
 * Created by Age on 4/3/2017.
 */
public final class BindingUtils {
    private BindingUtils() {
        // No-op
    }

    @BindingAdapter({ "recyclerAdapter" })
    public static void setAdapterForRecyclerView(RecyclerView recyclerView,
            RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter("app:imageUrl")
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext()).load(imageUrl).placeholder(R.drawable.img_framgia).into(view);
    }

    @BindingAdapter("errorText")
    public static void setErrorText(TextInputLayout layout, String text) {
        layout.setError(text);
    }

    @BindingAdapter({ "spinnerAdapter" })
    public static void setAdapterForSpinner(AppCompatSpinner spinner,
            ArrayAdapter<String> adapter) {
        spinner.setAdapter(adapter);
    }

    @BindingAdapter({ "bind:font" })
    public static void setFont(TextView textView, String fontName) {
        textView.setTypeface(Typeface.createFromAsset(textView.getContext().getAssets(), fontName));
    }

    @BindingAdapter({ "scrollListenner" })
    public static void setScrollListenner(RecyclerView recyclerView,
            RecyclerView.OnScrollListener listener) {
        recyclerView.addOnScrollListener(listener);
    }

    @BindingAdapter({ "bind:adapter", "model" })
    public static void setupViewPager(final ViewPager viewPager, FragmentPagerAdapter adapter,
            final NewMainViewModel viewModel) {
        viewPager.setAdapter(adapter);
        if (viewModel == null) return;
        viewPager.setOffscreenPageLimit(adapter.getCount());
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset,
                    int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                viewModel.setTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    @BindingAdapter("tabPostion")
    public static void onChangeTint(ImageView image, int tab) {
        changeImageColor(image, R.color.color_black);
        switch (tab) {
            case TAB_DASH_BOARD:
                if (image.getId() == R.id.image_dash_board) {
                    changeImageColor(image, R.color.colorPrimaryDark);
                }
                break;
            case TAB_REQUEST_MANAGER:
                if (image.getId() == R.id.image_request_manager) {
                    changeImageColor(image, R.color.colorPrimaryDark);
                }
                break;
            case TAB_DEVICE_MANAGER:
                if (image.getId() == R.id.image_device_manager) {
                    changeImageColor(image, R.color.colorPrimaryDark);
                }
                break;
            case TAB_PROFILE:
                if (image.getId() == R.id.image_profile) {
                    changeImageColor(image, R.color.colorPrimaryDark);
                }
                break;
            default:
                break;
        }
    }

    private static void changeImageColor(ImageView image, int colorRes) {
        image.getDrawable()
                .setColorFilter(image.getContext().getResources().getColor(colorRes),
                        PorterDuff.Mode.SRC_IN);
    }

    @BindingAdapter({ "bind:activity" })
    public static void setupViewPager(Toolbar view, AppCompatActivity activity) {
        activity.setSupportActionBar(view);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @BindingAdapter({ "pieData", "totalValue" })
    public static void setData(PieChart view, PieData pieData, int total) {
        Resources resources = view.getContext().getResources();

        if (pieData.getDataSetCount() > 0) {
            pieData.setValueFormatter(new PercentFormatter());
            pieData.setValueTextColor(Color.BLACK);
            pieData.setValueTextSize(resources.getDimension(R.dimen.sp_8));

            view.setData(pieData);
            view.setTransparentCircleRadius(resources.getDimension(R.dimen.dp_30));
            view.setHoleRadius(resources.getDimension(R.dimen.dp_30));
            view.setDescription(null);
            view.setDrawEntryLabels(false);
            view.setCenterText(resources.getString(R.string.title_total) + total);
            view.setCenterTextSize(resources.getDimension(R.dimen.sp_17));
            view.setCenterTextColor(Color.BLUE);

            Legend legend = view.getLegend();
            legend.setEnabled(false);
        }
    }

}