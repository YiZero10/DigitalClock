package clocks;

import javax.swing.*;
import java.awt.*;

/**
 * 添加闹钟的弹窗
 */
public class AlarmClockSetFrame extends JFrame {

    private static final Font SONG_PLAIN = new Font("宋体", Font.PLAIN, 16);
    private JPanel jPanel;
    private JComboBox<String> hourBox;
    private JComboBox<String> minuteBox;
    private JButton set;
    private JButton cancel;

    public AlarmClockSetFrame(AlarmClockPanel alarmClockPanel){
        super("Set Alarm Clock");
        this.setBounds(500,400,300,180);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setIconImage(Clock.ICON);

        jPanel = new JPanel();
        jPanel.setBounds(10,10,this.getWidth(),this.getHeight());
        jPanel.setLayout(null);

        hourBox = new JComboBox<>();
        for (int i = 0; i < 24; i++) {
            if (i < 10)
                hourBox.addItem("0" + i);
            else
                hourBox.addItem(String.valueOf(i));
        }
        hourBox.setBounds(70,25,80,40);
        hourBox.setFont(SONG_PLAIN);
        jPanel.add(hourBox);

        JLabel symbol = new JLabel(":");
        symbol.setBounds(152,22,10,38);
        symbol.setFont(SONG_PLAIN);
        jPanel.add(symbol);

        minuteBox = new JComboBox<>();
        for (int i = 0; i < 60; i++) {
            if (i < 10)
                minuteBox.addItem("0" + i);
            else
                minuteBox.addItem(String.valueOf(i));
        }
        minuteBox.setBounds(163,25,80,40);
        minuteBox.setFont(SONG_PLAIN);
        jPanel.add(minuteBox);

        set = new JButton("SET");
        set.setBounds(50,90,100,42);
        set.setFont(SONG_PLAIN);
        set.addActionListener(e -> {
            String hour = (String) hourBox.getSelectedItem();
            String minute = (String) minuteBox.getSelectedItem();
            AlarmClockModel.setIsOpen(true);
            AlarmClockModel.setWakeUpTime(hour + ":" + minute);

            //显示在闹钟面板
            alarmClockPanel.getAddButton().setEnabled(false);
            alarmClockPanel.getAddButton().setText("将" + AlarmClockModel.getWakeUpTime() + " 响起");
            alarmClockPanel.getCloseButton().setEnabled(true);

            this.setVisible(false);
        });
        jPanel.add(set);

        cancel = new JButton(("Cancel"));
        cancel.setBounds(163,90,100,42);
        cancel.setFont(SONG_PLAIN);
        cancel.addActionListener(e -> this.setVisible(false));
        jPanel.add(cancel);

        this.add(jPanel);
    }

}
