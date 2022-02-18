public class StringMethods {

    public static boolean startsWithDayOfWeek(String[] daysOfWeek){

        boolean[] days = new boolean[daysOfWeek.length];
        boolean isDay = false;
        for(int i = 0; i < daysOfWeek.length; i++){
            if(daysOfWeek[i].substring(0, 2) == "Mon" || daysOfWeek[i].substring(0, 3) == "Tues" ||  daysOfWeek[i].substring(0, 3) == "Weds" || daysOfWeek[i].substring(0, 4) == "Thurs" || daysOfWeek[i].substring(0, 2) == "Fri" || daysOfWeek[i].substring(0, 2) == "Sat" || daysOfWeek[i].substring(0, 2) == "Sun"){
                days[i] = true;
            }
        }
        for(int i = 0; i < days.length; i++){
            if(days[i] == false){
                return isDay;
            }else{
                isDay = true;

            }
        }
        return isDay;
    }
}
