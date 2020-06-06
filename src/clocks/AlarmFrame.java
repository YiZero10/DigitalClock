package clocks;

import javax.swing.*;
import java.awt.*;


/**
 * 到达闹钟响起时间的弹窗提醒
 */
public class AlarmFrame extends JFrame{

    private static final Font SONG_PLAIN = new Font("宋体", Font.PLAIN, 16);
    private static final Font SONG_PLAIN_M = new Font("宋体", Font.PLAIN, 20);
    private JPanel jPanel;
    private JButton label;
    private JButton close;
    private JButton delay;

    public AlarmFrame(){
        super("Time to Alarm!");
        this.setBounds(500,400,320,180);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setIconImage(Clock.ICON);

        jPanel = new JPanel();
        jPanel.setBounds(5,10,this.getWidth(),this.getHeight());
        jPanel.setLayout(null);
        this.add(jPanel);

        label = new JButton("时间到啦！时间到啦！");
        label.setFont(SONG_PLAIN_M);
        label.setForeground(Color.BLACK);
        label.setBounds(20,28,280,40);
        label.setBorderPainted(false);
        label.setEnabled(false);
        jPanel.add(label);

        close = new JButton("Close");
        close.setFont(SONG_PLAIN);
        close.setFocusPainted(false);
        close.setBounds(20,80,120,40);
        jPanel.add(close);
        close.addActionListener(e -> {
            AlarmClockModel.setIsOpen(false);
            AlarmClockModel.getAlarmClockThread().interrupt();
            this.setVisible(false);
        });


        delay = new JButton("Snooze");
        delay.setFocusPainted(false);
        delay.setFont(SONG_PLAIN);
        delay.setBounds(165,80,130,40);
        jPanel.add(delay);
        delay.addActionListener(e -> {
            AlarmClockModel.getAlarmClockThread().interrupt();
            String time = AlarmClockModel.getWakeUpTime();
            String[] times = time.split(":");
            Integer hour = Integer.parseInt(times[0]);
            Integer minute = Integer.parseInt(times[1]);
            String newHour, newMinute;
            if (minute >= 50 ){
                newMinute = "0" + (minute + 10 - 60);
                if (hour + 1 < 10)
                    newHour = "0" + (hour + 1);
                else
                    newHour = String.valueOf(hour + 1);
            }else if (minute < 10){
                newMinute = String.valueOf(minute + 10);
                if (hour + 1 < 10)
                    newHour = "0" + hour;
                else
                    newHour = String.valueOf(hour);
            }else {
                newMinute = String.valueOf(minute + 10);
                if (hour + 1 < 10)
                    newHour = "0" + hour;
                else
                    newHour = String.valueOf(hour);
            }
            AlarmClockModel.setWakeUpTime(newHour + ":" + newMinute);
            AlarmClockModel.setIsOpen(true);
            this.setVisible(false);
        });
    }
}
