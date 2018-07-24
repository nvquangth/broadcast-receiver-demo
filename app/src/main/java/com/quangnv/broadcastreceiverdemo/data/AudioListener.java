package com.quangnv.broadcastreceiverdemo.data;

import com.quangnv.broadcastreceiverdemo.data.Audio;

import java.util.List;

public interface AudioListener {

    void onTitleAudio(String title);

    void onTotalTime(int totalTime);

    void onCurrentTime(int currentTime);

    void onPauseAudio();

    void onStartAudio();

    void onUpdateAudio(Audio audio);

    void onUpdateAudios(List<Audio> audios);
}
