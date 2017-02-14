package Mail;

import models.Car;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by bse71 on 14.02.2017.
 */
public class MyLayout extends PatternLayout {
    public String format(LoggingEvent event) {

        StringBuffer sb = new StringBuffer(event.getLevel().toString());

        sb.append(": \nTime: ").append(new Date(event.getTimeStamp()).toString())
                .append("\n[Thread: ").append(event.getThreadName()).append("]\n");
        sb.append(event.getMessage());

        return sb.toString();
    }
}
