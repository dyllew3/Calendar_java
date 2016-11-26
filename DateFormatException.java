import java.io.*;


class DateFormatException extends Exception{
    
    static final String[] MONTHS = {"January","February","March","April",
    "May","June","July","August","September","October","November","December"}; 
        
    public DateFormatException(int day, int month, int year){
        
        System.out.println("You put in : " + day + " / " + month + " / " + year );
        if(day > 31){
            
            System.out.println("No month has more than 31 days");            
    
        }
        else if (day < 1) {
            System.out.println("No month has less than 1 days");
        }

       else if( month > 12 || month < 1){
            
            System.out.println("There are 12 months in the year (1 - 12)");
        }
        else if(year < 0) {
            
            System.out.println("Negative years don't exist ");

        }
        else {
            
            System.out.println("" + MONTHS[month - 1]  + " doesn't have that many days");

        }           
    }    
    
    





}
