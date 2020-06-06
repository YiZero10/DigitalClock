package clocks;

import javax.swing.*;
import java.awt.*;

/**
 * 数字钟的主要窗口类 加入时钟面板跟闹钟设置面板
 */
public class Clock{

    private JFrame jFrame;
    private JLayeredPane jLayeredPane = new JLayeredPane();
    private ClockPanel clockPanel;//时钟面板
    private AlarmClockPanel alarmClockPanel;//闹钟面板

    private static final ImageIcon bg = new ImageIcon("resource/bg.png");

    private static final Toolkit toolkit = Toolkit.getDefaultToolkit();
    protected static final Image ICON = toolkit.getImage("resource/icon.png") ;

    public Clock() {
        jFrame = new JFrame("多功能数字钟");

        //设置icon
        jFrame.setIconImage(ICON);

        //设置背景
        JLabel bgLabel = new JLabel(bg);
        JPanel bgPanel = new JPanel();
        bgPanel.setBounds(0,-15,bg.getIconWidth(), bg.getIconHeight());
        bgPanel.add(bgLabel);

        //添加数字时钟显示面板
        clockPanel = new ClockPanel();
        clockPanel.setBounds(-32,20,440,260);
        clockPanel.setOpaque(false);
        clockPanel.setLayout(null);

        //添加闹钟面板
        alarmClockPanel = new AlarmClockPanel();
        alarmClockPanel.setBounds(60,200,300,50);
        alarmClockPanel.setOpaque(false);

        //设置层次面板 将背景图设置在最底层 其他面板设置在高层次
        jLayeredPane.add(bgPanel,JLayeredPane.DEFAULT_LAYER);
        jLayeredPane.add(clockPanel,JLayeredPane.MODAL_LAYER);
        jLayeredPane.add(alarmClockPanel, JLayeredPane.MODAL_LAYER);
        jFrame.setLayeredPane(jLayeredPane);

        jFrame.setBounds(600, 230, bg.getIconWidth(),bg.getIconHeight());
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

    }
}
