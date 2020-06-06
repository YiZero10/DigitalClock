package clocks;

/**
 * 定义的闹钟类
 */
public class AlarmClockModel {
    private static String wakeUpTime = "00:00";

    private static String music;

    private static boolean isOpen;

    private static Thread alarmClockThread = new AlarmThread();

    public AlarmClockModel() {
    }

    public static String getWakeUpTime() {
        return wakeUpTime;
    }

    public static void setWakeUpTime(String wakeUpTime) {
        AlarmClockModel.wakeUpTime = wakeUpTime;
    }

    public static String getMusic() {
        return music;
    }

    public static void setMusic(String music) {
        AlarmClockModel.music = music;
    }

    public static boolean isIsOpen() {
        return isOpen;
    }

    public static void setIsOpen(boolean isOpen) {
        AlarmClockModel.isOpen = isOpen;
    }

    public static Thread getAlarmClockThread() {
        return alarmClockThread;
    }

    public static void setAlarmClockThread(Thread alarmClockThread) {
        AlarmClockModel.alarmClockThread = alarmClockThread;
    }
}
