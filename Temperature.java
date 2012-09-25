package temperature;
//ECSE-321
//Assignment 1
//Xinchi Chen
//260376222
//2012-09-23


public class Temperature implements Comparable<Temperature> {
/** Enumerator for different temperature units */
	
public static double round2(double num) { // the round up method will provide two decimal places for double values
	double result = num * 100;
	result = Math.round(result);
	result = result / 100;
	return result;
	}
	
    double Temp;
    Units units;
    
public static enum Units { FAHRENHEIT, CELCIUS, KELVIN }


public Temperature (double value, Temperature.Units unit) {
    this.Temp = value;  //initial variables
    this.units = unit;  //initial variables
}


public double getValue() {   //get the temperature of an object Temperature
    return round2(Temp);             //return the temperature value of the object
}



public Units getUnits() {    //get the unit of an object Temperature
    return units;			 //return the unit of the object
}




public void changeUnits(Units units) {
	
	
	if (this.units == units){	//if the desired unit is the current unit, keep this unit
		return;
	}
	
    if (this.units == Units.CELCIUS && units == Units.KELVIN){ //change unit from celcius to kelvin
    	
        this.Temp = (Temp +273.15); // K = C + 273.15
        this.units = Units.KELVIN; //convert unit
    }
    
    if (this.units == Units.FAHRENHEIT && units == Units.KELVIN){ //change from fahrenheit to kelvin
    	
    	this.Temp = (double)((this.Temp - 32) / (9.0/5.0) + 273.15); // K = (F-32)*9/5 + 273.15
    	this.units = Units.KELVIN; //convert unit
    }
    
	if (this.units == Units.KELVIN && units==Units.CELCIUS) {  //change unit from kelvin to celcius
		
        this.Temp= (double)(Temp - 273.15); //C = K-273.15
        this.units=Units.CELCIUS; //convert unit
    }
    
	if (this.units == Units.FAHRENHEIT && units == Units.CELCIUS){ //change unit from fahrenheit to celcius

    	this.Temp =(double) ((Temp - 32)*(5.0/9.0)); //C = (F-32)*5/9
    	this.units = Units.CELCIUS; //convert unit
    }
    
    if (this.units == Units.CELCIUS && units == Units.FAHRENHEIT){ //change from celcius to fahrenheit

    	this.Temp = (double)(Temp *(9.0/5.0) + 32); // F = C*9/5 + 32
    	this.units = Units.FAHRENHEIT; //convert unit
    }
    
    if (this.units == Units.KELVIN && units == Units.FAHRENHEIT){ //change from kelvin to fahrenheit

    	this.Temp = (double)((this.Temp - 273.15)*(9.0/5.0) + 32); // F = (K-273.15)*9/5 + 32
    	this.units = Units.FAHRENHEIT; //convert unit
    }
}



public String toString() {
    if (units == Units.CELCIUS){ 
        return "" + round2(Temp) + " °„C"; //use the round up method
    }

    else if(units == Units.FAHRENHEIT){        
        return "" + round2(Temp) + " °„F";
    }

    else{        
        return "" + round2(Temp) +" °„K";
    }
    
}



public int compareTo (Temperature temperature) {
    
    double intermediatevalue = 0.0; //we define this to let our current temperature convert to the target unit
    

        if(this.units == Units.CELCIUS && temperature.getUnits() == Units.FAHRENHEIT){ //change unit from C to F
            intermediatevalue = (this.Temp *(9.0/5.0) + 32); //F = C*9/5+32
        }
        
        else  if (this.getUnits() == Units.KELVIN && temperature.getUnits() == Units.FAHRENHEIT){ //change unit from C to F   	
        	intermediatevalue = ((this.getValue() - 273.15) * (9.0/5.0) +32);} //F = C*9/5+32

        
        else if (this.units == Units.FAHRENHEIT && temperature.getUnits() == Units.CELCIUS){ //change unit from C to F  	
        	intermediatevalue = (double)(this.Temp - 32) * (5.0/9.0);} //C = (F-32)
        
        else if (this.units == Units.CELCIUS && temperature.getUnits() == Units.KELVIN){ //change unit from C to K   	
       	 intermediatevalue = (this.Temp + 273.15);} //K=C+273.15
        
      
        else if (this.getUnits() == Units.KELVIN && temperature.getUnits() == Units.CELCIUS){ //change unit from K to C        	
        	intermediatevalue = (this.getValue() - 273.15);} // C = F - 273.15
        
        
        else if (this.units == Units.FAHRENHEIT && temperature.getUnits() == Units.KELVIN){ //change unit from F to K        	
        	intermediatevalue = (double)((this.getValue() - 32)*(5.0/9.0) +273.15);} //K = (F-32)*(5/9)+273.15
        
        else {
        	intermediatevalue = this.getValue(); //this indicates the target unit is the current unit
     }
        
        //comparison
        if(intermediatevalue == temperature.getValue() || (Math.abs(temperature.getValue() - intermediatevalue)/intermediatevalue)<0.001) //if the two values equal, or their relative error is smaller than 0.1%
            return 0;
        
        else if (intermediatevalue < temperature.getValue()) // current temperature > target temperature
            return -1; 
        
        else
            
            return 1; // current temperature < target temperature
    
}



public boolean equals (Object o) {
    Temperature temps=(Temperature)o; //convert the type
    if (this.compareTo(temps) == 0 ) // 0 indicates equal (from equalto method)
        return true;
    else 
        return false;
}


public int hashCode(){
int hash = 7;
    hash = 31 * hash + (int)this.Temp;
    hash = 31 * hash + (null == this.units ? 0 : this.units.hashCode());
    return hash;

}

public static void main(String[] args){
	System.out.println("Test Case: 180F");
	Temperature temp1 = new Temperature(180, Temperature.Units.FAHRENHEIT);
	Temperature temp2 = new Temperature(170, Temperature.Units.FAHRENHEIT);
	Temperature temp3 = new Temperature(180, Temperature.Units.FAHRENHEIT);
	System.out.println("Let's convert it to KELVIN...");
	temp1.changeUnits(Temperature.Units.KELVIN);
	System.out.println("Conversion Completed");
	System.out.println("This Temperature in K is: "+ round2(temp1.getValue()));
	System.out.println("The unit of this Temperature is: "+ temp1.getUnits());
	System.out.println("We can express it as:" + temp1.toString());
	System.out.println("Is this temprature equal to 170F? the answer is: " + temp1.equals (temp2));
	System.out.println("Is this temprature equal to 180F? the answer is: " + temp1.equals (temp3));
	System.out.println("The hashcode of this Temperature is:" + temp1.hashCode());
}
}