package Utils;

import javax.swing.text.DateFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtil {

    public static long dateStrToUnix(String birthDate)  {
        String dateFormat = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        try {
            Date date = sdf.parse(birthDate);
            return date.getTime();
        }
        catch (ParseException e){
            throw new IllegalArgumentException("birthDate can not be parsed");
        }

    }

    public static String dateUnixToStr(long birthDate)  {
        Date dt = new Date(birthDate);
        String dateFormat = "dd/MM/yyyy";
        String a = "";
        try{
            DateTimeFormatter sdf = DateTimeFormatter.ofPattern(dateFormat);
            LocalDate ldt = convertDateToLocal(dt);
            a = ldt.format(sdf);
        } catch (Exception e){
            e.printStackTrace();
        }
        return a;
    }



    public static LocalDate convertDateToLocal(Date dateToConvert)  {
        return Instant.ofEpochMilli(dateToConvert.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

}
