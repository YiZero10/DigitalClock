package clocks;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 数字时钟显示面板
 */
public class ClockPanel extends JPanel implements Runnable {
    private final SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy-MM-dd E");
    private final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    Calendar now;

    public ClockPanel() {
        Thread thread = new Thread(this::run);
        thread.start();
    }

    @Override
    public void paint(Graphics g) {
        now = Calendar.getInstance();
        g.setColor(new Color(0xE63C3C3C, true));
        g.setFont(new Font("楷体", Font.PLAIN, 80));
        g.drawString(timeFormat.format(now.getTime()), 82, 100);
        g.setFont(new Font("宋体", Font.BOLD, 30));
        g.drawString(yearFormat.format(now.getTime()), 113, 148);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.repaint();
        }
    }
}
