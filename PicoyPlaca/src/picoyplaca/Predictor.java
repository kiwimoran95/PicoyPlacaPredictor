package picoyplaca;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author martin_moran
 */
public class Predictor {
    private String plate;
    private String date;
    private String time;
    
    public Predictor(String plate, String date, String time){
        this.plate = plate;
        this.date = date;
        this.time = time;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    public boolean timePredictor(){
        //Code to obtain time as a number
        String[] timearray = this.time.split(":");
        int timeinput = Integer.parseInt(timearray[0]+timearray[1]);
        return (timeinput>=700 && timeinput <=930)||(timeinput>=1600 && timeinput <=1930);
    }
    
    public boolean picoyplacaPredictor() throws ParseException{
        boolean result = true;
        //Code to get the last digit of the license plate
        int platenumber = Integer.parseInt(String.valueOf(this.plate.charAt(this.plate.length()-1)));
        //Code to get the day of the given date
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dateinput = sdf.parse(this.date);
        sdf = new SimpleDateFormat("EEEE");
        String day = sdf.format(dateinput);
        System.out.println(day);
        
        switch(day)
        {
            case "lunes":
                if(platenumber == 1 || platenumber == 2)
                {
                    if(timePredictor())
                        result = false;
                }
                break;
            case "martes":
                if(platenumber == 3 || platenumber == 4)
                {
                    if(timePredictor())
                        result = false;
                }
                break;
            case "miercoles":
                if(platenumber == 5 || platenumber == 6)
                {
                    if(timePredictor())
                        result = false;
                }
                break;
            case "jueves":
                if(platenumber == 7 || platenumber == 8)
                {
                   if(timePredictor())
                        result = false;
                }
                break;
            case "viernes":
                if(platenumber == 9 || platenumber == 0)
                {
                    if(timePredictor())
                        result = false;
                }
                break;
            default:
                result =true;
                break;       
        }
        return result;
    }   
}