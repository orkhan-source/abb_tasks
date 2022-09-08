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
        String dateFormat = "dd/MM/yyyy";
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern(dateFormat);
        Date dt = new Date(birthDate);
        LocalDate ldt = convertDateToLocal(dt);
        String a = ldt.format(sdf);
        return a;
    }


    public static String convertCorrectFormat(LocalDate birthDate){
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = birthDate.format(formatters);
        return  date;
    }



    public static LocalDate convertDateToLocal(Date dateToConvert)  {
        return Instant.ofEpochMilli(dateToConvert.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

}
