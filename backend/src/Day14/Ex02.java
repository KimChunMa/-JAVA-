package Day14;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class Ex02 {
	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now); // .toString 생략가능
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd/hh:mm:ss");
		System.out.println(sdf.format(now));
		
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR);  year = cal.get(1); // 2023
		
		int month = cal.get(Calendar.MONTH)+1; month = cal.get(2)+1; 
		int day = cal.get(Calendar.DAY_OF_MONTH);
		System.out.printf("%d %d %d",year,month,day );
		System.out.println("\n---");
		
		int week = cal.get(Calendar.DAY_OF_WEEK); 
		if(week == Calendar.SUNDAY) {System.out.println("일");}
		if(week == Calendar.MONDAY) {System.out.println("월");}
		if(week == 3) {System.out.println("화");}
		if(week == 4) {System.out.println("수");}
		if(week == 5) {System.out.println("목");}
		if(week == 6) {System.out.println("금");}
		if(week == 7) {System.out.println("토");}
		
		int am_pm = cal.get(Calendar.AM_PM);
		System.out.println(am_pm);
		if(am_pm == 0) {System.out.println("오전");}
		if(am_pm == 1) {System.out.println("오후");}
		
		int hour = cal.get(Calendar.HOUR);
		int min = cal.get(Calendar.MINUTE);
		int seo = cal.get(Calendar.SECOND);
		System.out.printf("%d시 %d분 %d초\n",hour,min ,seo);
		
		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy MM dd a HH:mm:ss");
		System.out.println(dtf.format(ldt));
		
		System.out.println("1년 뒤 "+ ldt.plusYears(1));
		System.out.println("2개월 전 "+ ldt.minusMonths(2));
		System.out.println("7일 후 "+ ldt.plusDays(7));
		
		
		LocalDateTime 시작일 = LocalDateTime.of(2021, 1,1,0,0,0);
		LocalDateTime 종료일 = LocalDateTime.of(2021, 12,31,0,0,0);
		System.out.println("종료일이 시작일 이후"+시작일.isBefore(종료일));
		System.out.println("시작일이 종료일 이전"+시작일.isAfter(종료일));
		System.out.println("시작일==종료일"+시작일.isEqual(종료일));
		
		System.out.println("연도 차 : " + (시작일.until(종료일, ChronoUnit.YEARS)) );
		System.out.println("월 차 : " + (시작일.until(종료일, ChronoUnit.MONTHS)) );
		System.out.println("일 차 : " + (시작일.until(종료일, ChronoUnit.DAYS)) );
		System.out.println("시간 차 : " + (시작일.until(종료일, ChronoUnit.HOURS)) );
		System.out.println("분 차 : " + (시작일.until(종료일, ChronoUnit.MINUTES)) );
		System.out.println("초 차 : " + (시작일.until(종료일, ChronoUnit.SECONDS)) );
		
		
		//6
		double num = 1234567.89;
		DecimalFormat df = new DecimalFormat("#,###");
		System.out.println(df.format(num));
		
		
		df=new DecimalFormat("#,###.0");
		System.out.println(df.format(1234));
		
		df=new DecimalFormat("#,##0원");
		System.out.println(df.format(123456));
		System.out.println(df.format(1));
		
		//7
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(dateFormat.format(date));
		
		dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
		System.out.println(dateFormat.format(date));
		
		dateFormat = new SimpleDateFormat("yyyy. MM. dd a HH:mm:ss");
		System.out.println(dateFormat.format(date));
		
		dateFormat = new SimpleDateFormat("오늘은 E 요일");
		System.out.println(dateFormat.format(date));
		
		dateFormat = new SimpleDateFormat("오늘은 D번째 날");
		System.out.println(dateFormat.format(date));
		
		dateFormat = new SimpleDateFormat("오늘은 d번째 요일");
		System.out.println(dateFormat.format(date));
		
	}
}
