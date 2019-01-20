package com.ifwaxtel.newsapp.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

import com.ifwaxtel.newsapp.R;
import com.ifwaxtel.newsapp.util.GetDeviceMetrics;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

/**
 * The type Play video.
 */
public class PlayVideo extends DialogFragment {

    /**
     * The Video view.
     */
    VideoView videoView;
    /**
     * The Activity.
     */
    Activity activity;

    /**
     * Add context.
     *
     * @param ctx the ctx
     */
    public void addContext(Activity ctx) {
        this.activity = ctx;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, 0);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        videoView = (VideoView) view.findViewById(R.id.videoView);
        String path = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.funny;
        videoView.setVideoURI(Uri.parse(path));
        videoView.setZOrderOnTop(true);
        videoView.requestFocus();
        MediaController controller = new MediaController(activity);
        controller.setAnchorView(videoView);
        videoView.setMediaController(controller);
        videoView.start();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_video, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            WindowManager.LayoutParams param = dialog.getWindow().getAttributes();
            param.width = (int) (new GetDeviceMetrics(getActivity()).getMetrics().widthPixels * 0.98);
            dialog.getWindow().setAttributes(param);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        }
    }
}
