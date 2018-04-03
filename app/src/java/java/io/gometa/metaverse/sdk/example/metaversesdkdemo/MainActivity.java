package io.gometa.metaverse.sdk.example.metaversesdkdemo;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import io.gometa.metaverse.storyboard.sdk.Meta;
import io.gometa.metaverse.storyboard.sdk.Result;
import io.gometa.metaverse.storyboard.sdk.model.StoryboardSummary;

/**
 *
 */
public class MainActivity extends AppCompatActivity
        implements StoryboardSummaryAdapter.StoryboardSummaryClickListener {

    private MainViewModel mViewModel;
    private StoryboardSummaryAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.app_name) + " (" + BuildConfig.LANGUAGE + ")");
        }

        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mAdapter = new StoryboardSummaryAdapter();
        mAdapter.setStoryboardSummaryClickListener(this);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new StoryboardSummaryDecoration(this));

        for (String storyboardId : getResources().getStringArray(R.array.storyboard_ids)) {
            mViewModel.get(storyboardId).observe(this, storyboardSummaryResult -> {
                if (storyboardSummaryResult != null) {
                    mAdapter.set(storyboardId, storyboardSummaryResult);
                }
            });
            mViewModel.loadStoryboardSummary(storyboardId);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1000) {
            String storyboardId = null;
            String cause = null;
            if (data != null) {
                storyboardId = data.getStringExtra(Meta.StoryboardResult.STORYBOARD_ID);
                if (data.hasExtra(Meta.StoryboardResult.CLOSE_REASON)) {
                    cause = Integer.toString(
                            data.getIntExtra(Meta.StoryboardResult.CLOSE_REASON, -1));
                }
            }
            StringBuilder sb = new StringBuilder("Storyboard ")
                    .append(storyboardId);
            if (resultCode == Activity.RESULT_CANCELED) {
                sb.append(" CANCELED");
            } else {
                sb.append(" OK");
            }
            sb.append(" with cause: ")
                    .append(cause);
            Toast.makeText(this, sb.toString(), Toast.LENGTH_LONG).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // StoryboardSummaryAdapter.StoryboardSummaryClickListener

    @Override
    public void onReloadStoryboard(@NotNull String storyboardId) {
        mViewModel.loadStoryboardSummary(storyboardId);
    }

    @Override
    public void onLaunchStoryboard(@NotNull String storyboardId) {
        startActivityForResult(Meta.getStoryboardIntent(this, storyboardId), 1000);
    }
}
