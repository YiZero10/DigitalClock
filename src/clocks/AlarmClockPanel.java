package clocks;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

/**
 * 主面板中--闹钟设置面板
 */
public class AlarmClockPanel extends JPanel implements Runnable {

    private static final Font SONG_PLAIN_S = new Font("宋体", Font.BOLD, 16);

    private JButton addButton;
    private JButton closeButton;

    public AlarmClockPanel() {
        this.setLayout(new GridLayout(1, 1, 0, 0));
        addButton = new JButton("添加闹钟");
        addButton.setFont(SONG_PLAIN_S);
        addButton.setFocusPainted(false);
        addButton.setBounds(0, 0, 300, 50);
        addButton.addActionListener(e -> new AlarmClockSetFrame(this));
        closeButton = new JButton(("关闭/重置闹钟"));
        closeButton.addActionListener(e -> {
            AlarmClockModel.setIsOpen(false);
            addButton.setEnabled(true);
            addButton.setText("添加闹钟");
            closeButton.setEnabled(false);
        });
        closeButton.setFont(SONG_PLAIN_S);
        closeButton.setFocusPainted(false);
        closeButton.setBounds(0, 0, 300, 50);
        this.add(addButton);
        this.add(closeButton);
        Thread checkButtonThread = new Thread(this::run);
        checkButtonThread.setName("Check-Button-Status-Thread");
        checkButtonThread.start();
    }

    /**
     * 实现添加闹钟按钮的动态显示，显示闹钟状态或者倒计时
     */
    @Override
    public void run() {
        while (true) {
            if (AlarmClockModel.isIsOpen()) {
                Map<String,String> timeDiff = TimeUtil.getTimeDifference(AlarmClockModel.getWakeUpTime() + ":00");
                addButton.setEnabled(false);
                addButton.setForeground(Color.BLACK);
                Integer hour = Integer.parseInt(timeDiff.get("hour"));
                Integer minute = Integer.parseInt( timeDiff.get("minute") );
                Integer seconds = Integer.parseInt( timeDiff.get("second")) + 60 * minute;
                if (hour == 0 && minute >= 0 && minute <= 10){
                    addButton.setText(
                            "倒计时:" + seconds +"秒") ;
                }else {
                    addButton.setText("将在" +  AlarmClockModel.getWakeUpTime() + "响起") ;
                }
                addButton.setFont(SONG_PLAIN_S);
                closeButton.setEnabled(true);
            } else {
                addButton.setEnabled(true);
                addButton.setText("添加闹钟");
                closeButton.setEnabled(false);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getCloseButton() {
        return closeButton;
    }

}
