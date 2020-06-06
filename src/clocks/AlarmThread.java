package clocks;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 判断是否到达预设时间线程
 */
public class AlarmThread extends Thread {
    private static final String MUSIC_PATH = "resource/mayday.mp3";
    private static Player player;

    @Override
    public void run() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        String now;
        while (true) {
            now = dateFormat.format(new Date());
            if (AlarmClockModel.isIsOpen() && now.equals(AlarmClockModel.getWakeUpTime())) {
                System.out.println("time to this");
                AlarmClockModel.setIsOpen(false);
                AlarmFrame alarmFrame = new AlarmFrame();
                playMusic();
            }
            try {
                Thread.sleep(1000);//休息1s
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void interrupt() {
        stopMusic();
        super.interrupt();
    }

    protected static void playMusic() {
        File file = new File(MUSIC_PATH);
        try {
            player = new Player(new FileInputStream(file));
            player.play();
        } catch (JavaLayerException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected static void stopMusic(){
        player.close();
    }
}
