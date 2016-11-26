import java.io.*;
import java.util.Scanner;
import java.util.*;

public class Date{
    static final int[] MONTHS = {31,28,31,30,31,30,31,31,30,31,30,31};
    static final String [] DAYS = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"}; 
      
    private int  week_day = -1;
    private int day;
    private int month;
    private  Year year;
    
    
    
     

    public Date(int day, int month, int year) throws DateFormatException {
        this.day = day;
        this.month = month;
        this.year = new Year( year);
        
        MONTHS[1] = (this.year.isLeapYear() ? 29  : MONTHS[1]  );
        if(year < 0 || day < 1 || month > 12 || month < 1  
         || day > MONTHS[month - 1] ){
            throw new DateFormatException(day,month,year);
        }
        this.week_day = getWeekDay();
    }
   public int dateInDays(){
        double days = this.year.getYear() * 365.25;
        days += this.day;
        days += daysInMonths(month -1);  
    
        return (int) (days);

   }
    
    public int getDay(){
        return this.day;


    }
    public int daysInMonths(int toMonth){
        int result = 0;
        for(int i = 0 ; i < toMonth; i++){
            
            result += MONTHS[i];
            if(i == 1 && year.isLeapYear()) result +=1;

        }
        return result;
    }
    
    
    public int daysApart(Date otherDate){
        int goFrom = otherDate.dateInDays();
        int goTo = dateInDays();

        return Math.abs(goFrom - goTo);
        
        
        
    }   
    
        
    public int getWeekDay(){
        if(week_day == -1){
            int temp = this.day;
            int year = this.year.getYear();
            int shiftMonth = this.month + 10;
            double firstDigs = (month < 2 ? (year %100) -1  : year%100);
            if(shiftMonth > 12) shiftMonth -= 12;
            temp += (int) Math.floor((shiftMonth * 2.6) - 0.2); 
            temp += firstDigs;
            
            int secDigs = year/100;
            
            temp += (int)Math.floor(firstDigs /4 );
            temp += (int)Math.floor((year /100)/4);
            temp -= (secDigs * 2);
            this.week_day =(int) (((temp  %7) + 7) % 7 );
        
            
        }
        return week_day; 
    }
    

    public String printNumDate(){
        
        
        return (DAYS[this.week_day] + "  " + this.day + "/" + this.month  + "/" + this.year  );    
    
    }
    
    public int getYear(){
        return this.year.getYear();


    } 
    
    public String printDate(){
        String postfix = "";
        if(day % 10 == 1 && day != 11){
            postfix = "st";
        }
        else if(day % 10 == 2 && day != 12){
            postfix = "nd";
        }
        else if(day % 10 == 3 && day != 13){
            postfix = "rd";
        }
        else {
            postfix = "th";
        }
        String month = DateFormatException.MONTHS[this.month -1];
        String date = (day + postfix + " of " + month + " " + year );
        return date;
    }
        
    public static void main(String[] args){
        
        int day, month, year; 
        Date test;
        Scanner inputScanner = new Scanner(System.in);
        boolean correctDate = false;
        while(!correctDate){
            System.out.println("Please enter a date in dd/mm/yyyy form");
            inputScanner = new Scanner(System.in);
            inputScanner = new Scanner(inputScanner.nextLine());
            inputScanner.useDelimiter("/"); 
             
            try {
                
                day = inputScanner.nextInt();
                month = inputScanner.nextInt();
                year = inputScanner.nextInt();
                test = new Date(day,year,month);
                System.out.println("Date is :" + test.printDate());
                correctDate = true;                               
                

            }catch(NoSuchElementException e){
                
                System.out.println("Not enough values entered");                


            }
            catch(NumberFormatException e){
                
                System.out.println("A non-integer value was entered");
                
            }
            catch(DateFormatException e){


            }
        
        }
                inputScanner.close();

    }


}
