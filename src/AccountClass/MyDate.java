package AccountClass;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class MyDate extends BankAccount {

        private int year;
        private int month;
        private int day;

        Scanner input = new Scanner(System.in);

        public MyDate(){
        }

        public MyDate(Date myDate){
            Calendar cal = new GregorianCalendar();
            cal.set(2021, 1,13);
            myDate = cal.getTime();
        }

        public MyDate(int y, int MM, int dd){
            Calendar cal = new GregorianCalendar();
            y = year;
            MM = month;
            dd = day;
        }

        //Mutators and accessors
        public void setDay(int day) {
            this.day = day;
            Calendar cal = new GregorianCalendar();
            day = cal.get(Calendar.DATE);
        }

        public int getDay() {
            System.out.print("Enter day (dd): ");
            return day = input.nextInt();
        }

        public void setMonth(int month) {
            this.month = month;
            Calendar cal = new GregorianCalendar();
            month = cal.get(Calendar.MONTH);
        }

        public int getMonth() {
            System.out.print("Enter month (mm): ");
            return month = input.nextInt();
        }

        public void setYear(int year) {
            this.year = year;
            Calendar cal = new GregorianCalendar();
            year = cal.get(Calendar.YEAR);
        }

        public int getYear() {
            System.out.print("Enter year (yyyy): ");
            return year=input.nextInt();
        }

        @Override
        public String getDateCreated() {
            return super.getDateCreated() + getYear()+"/"+ getMonth() +"/"+ getDay();
        }

}
