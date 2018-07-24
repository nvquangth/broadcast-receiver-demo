package com.quangnv.broadcastreceiverdemo.data;

import java.util.List;

public interface TaskListener {

    void onProgressUpdateTask(Audio audio);

    void onCompleteTask(List<Audio> audios);
}
