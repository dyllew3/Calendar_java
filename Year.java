class Year{
    
    private boolean leapYear;
    private int days;
    private int year;


    public Year(int year){
        this.year = year;
        this.leapYear = deterIfLeapYear();
        this.days = (leapYear ? 366 : 365);

    }
    
    public boolean deterIfLeapYear(){
        
         
        if((this.year % 4 != 0) ||( (this.year % 400 != 0) 
            && this.year % 100 == 0) ) return false;
        else return true;
        
    }

    public int getYear(){
        return this.year;
    }

    public boolean isLeapYear(){
        return this.leapYear;
    }





}
