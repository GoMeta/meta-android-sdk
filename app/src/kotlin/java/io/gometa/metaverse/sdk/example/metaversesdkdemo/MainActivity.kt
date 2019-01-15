package io.gometa.metaverse.sdk.example.metaversesdkdemo

import android.app.Activity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import android.widget.Toast
import io.gometa.sdk.Meta
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), StoryboardSummaryAdapter.StoryboardSummaryClickListener {

    private val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this)[MainViewModel::class.java]
    }
    private val adapter = StoryboardSummaryAdapter().also {
        it.storyboardSummaryClickListener = this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "${getString(R.string.app_name)} (${BuildConfig.LANGUAGE})"
        recycler_view.apply {
            adapter = this@MainActivity.adapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(StoryboardSummaryDecoration(this@MainActivity))
        }
        resources.getStringArray(R.array.storyboard_ids).forEach { storyboardId ->
            viewModel[storyboardId].observe(this, Observer {
                if (it != null) adapter[storyboardId] = it
            })
            viewModel.loadStoryboardSummary(storyboardId)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 1000) {
            val sb = StringBuilder("Storyboard ")
                .append(data?.getStringExtra(Meta.StoryboardResult.STORYBOARD_ID))
            if (resultCode == Activity.RESULT_CANCELED) {
                sb.append(" CANCELED")
            } else {
                sb.append(" OK")
            }
            sb.append(" with cause: ")
                .append(data?.getIntExtra(Meta.StoryboardResult.CLOSE_REASON, -1))
            Toast.makeText(this, sb.toString(), Toast.LENGTH_LONG).show()
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // StoryboardSummaryAdapter.StoryboardSummaryClickListener

    override fun onReloadStoryboard(storyboardId: String) {
        viewModel.loadStoryboardSummary(storyboardId)
    }

    override fun onLaunchStoryboard(storyboardId: String) {
        startActivityForResult(Meta.getStoryboardIntent(this, storyboardId), 1000)
    }
}
