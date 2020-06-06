package clocks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//一个计算时间的工具类
public class TimeUtil {

    /**
     * 获取当前时间距离传入的to这个时间的时分秒
     * @param to
     * @return
     */
    protected static Map<String, String> getTimeDifference(String to){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        try {
            String now = simpleDateFormat.format(new Date());
            Date toDate = simpleDateFormat.parse(to);
            Date fromDate = simpleDateFormat.parse(now);
            int hours = (int) ((toDate.getTime() - fromDate.getTime()) / (1000 * 60 * 60));
            int minutes = (int) ((toDate.getTime() - fromDate.getTime()) / (1000 * 60) - 60 * hours);
            long seconds = (toDate.getTime() - fromDate.getTime())/1000 - hours * 3600 - minutes *60 ;
            Map<String,String> timeMap = new HashMap<>(3);
            timeMap.put("hour", String.valueOf(hours));
            timeMap.put("minute", String.valueOf(minutes));
            timeMap.put("second", String.valueOf(seconds));
            return timeMap;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
