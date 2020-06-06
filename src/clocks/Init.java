package clocks;

public class Init {
    public static void main(String[] args) {
        AlarmClockModel alarmClockModel = new AlarmClockModel();
        Clock clock = new Clock();
        AlarmClockModel.getAlarmClockThread().start();
    }
}
