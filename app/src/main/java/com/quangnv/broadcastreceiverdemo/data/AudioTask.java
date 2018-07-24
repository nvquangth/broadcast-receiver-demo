package com.quangnv.broadcastreceiverdemo.data;

import android.os.AsyncTask;
import android.os.Handler;

import com.quangnv.broadcastreceiverdemo.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AudioTask extends AsyncTask<File, Audio, List<Audio>> {

    private static final String TAG_MP3 = ".mp3";
    private static final String TAG_ZING = "zing";
    private static final int IMAGE_RES = R.drawable.ic_launcher_background;

    private TaskListener mTaskListener;
    private List<Audio> mAudios;

    public AudioTask(TaskListener taskListener) {
        mTaskListener = taskListener;
        mAudios = new ArrayList<>();
    }

    @Override
    protected List<Audio> doInBackground(File... files) {
        loadAudio(files[0]);
        return mAudios;
    }

    @Override
    protected void onProgressUpdate(Audio... values) {
        super.onProgressUpdate(values);
        mTaskListener.onProgressUpdateTask(values[0]);
        mAudios.add(values[0]);
    }

    @Override
    protected void onPostExecute(List<Audio> audios) {
        super.onPostExecute(audios);
        mTaskListener.onCompleteTask(audios);
//        cancel(true);
    }

    private void loadAudio(File dir) {
        File[] listFile = dir.listFiles();
        if (listFile != null) {
            for (int i = 0; i < listFile.length; i++) {
                if (listFile[i].isDirectory()) {
                    loadAudio(listFile[i]);
                } else {
                    if (listFile[i].getName().endsWith(TAG_MP3) &&
                            !listFile[i].getName().contains(TAG_ZING)) {
                        File file = listFile[i];

                        Audio audio = new Audio();
                        audio.setImage(IMAGE_RES);
                        audio.setName(file.getName());
                        audio.setPath(file.getAbsolutePath());

                        publishProgress(audio);
                    }
                }
            }
        }
    }
}
