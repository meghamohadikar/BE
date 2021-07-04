import java.time.*;

public class DateAndTime {
    public static void main(String[] args) {
        LocalDate date=LocalDate.now();
        System.out.println(date);
        LocalTime time=LocalTime.now();
        System.out.println(time);
        int dd=date.getDayOfMonth();
        System.out.println(dd);
        int mm=date.getMonthValue();
        System.out.println(mm);
        int yyyy=date.getYear();
        System.out.println(yyyy);
        int hh=time.getHour();
        int min= time.getMinute();
        int ss= time.getSecond();
        System.out.printf("%d-%d-%d",hh,min,ss);

        LocalDateTime dt=LocalDateTime.now();
        System.out.println("LocalDateTime= "+dt);
        int dd1=dt.getDayOfMonth();
        System.out.println(dd1);
        int mm1=date.getMonthValue();
        System.out.println(mm1);
        int yyyy1=date.getYear();
        System.out.println(yyyy1);
        int hh1=dt.getHour();
        int min1= dt.getMinute();
        int ss1= dt.getSecond();
        System.out.printf("%d-%d-%d",hh1,min1,ss1);

        LocalDateTime dt1=LocalDateTime.of(1997,6,16,10,20,40,50);
        System.out.println(dt1);

        System.out.println("before six months="+dt1.minusMonths(6));
        System.out.println("After six months="+dt1.plusMonths(6));

        Period p=Period.between(LocalDate.of(1997,6,16),LocalDate.now());
        System.out.println(p.getYears());
        System.out.println(p.getMonths());
        System.out.println(p.getDays());

        LocalDate death=LocalDate.of(1997+60,6,16);
        Period p1=Period.between(LocalDate.now(),death);
        int days=p1.getDays()+p1.getMonths()*30+p1.getYears()*365;
        System.out.println("you are having only "+days+" days on the earth");

        //to check leap yr or not
        Year y= Year.of(1997);
        if(y.isLeap())
            System.out.println("leap year");
        else
            System.out.println("not leap year");

        ZoneId zone=ZoneId.systemDefault();
        System.out.println(zone);

        ZoneId la=ZoneId.of("America/Los_Angeles");
        ZonedDateTime ladt=ZonedDateTime.now(la);
        System.out.println(ladt);
    }
}
