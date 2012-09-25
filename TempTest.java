//ECSE-321
//Assignment-2
//Xinchi Chen
//260376222
//2012-09-23

package temperature;

import static org.junit.Assert.*;
import org.junit.*;

/*in the testcase, random values are chosen to ensure the program can deal with any kind of situations*/
/*more than one data are chosed per test case to ensure the stability of the system*/
/*this will avoid random errors that not being detected*/

public class TempTest {
	
	final static double epislonx = 1e-8; //used for 

// PART I getUnits() and getValue() TEST
// three test cases are made to each type of the temperature

/* In Temperature.java, all the data will roundup to 2 decimal places. Due to this reason,
 * all test data are chosen to be with 2 decimal places to avoid roundup precision error
 * an example might be: if we set a temperature to be 100.123 and assert if it's value is 100.123
 * it would give error because its getvalue() is 100.12 due to the round up function.
 * Therefore only datas with 2decimal places are chosen in our test
 * this will also apply to the latter number-involved functions(changeUnits() and equals())*/	
	
	//getvalue()
	@Test
	public void testgetvalue(){
		Temperature temp =  new Temperature(100.14,Temperature.Units.CELCIUS); //define a new temperature
		assertEquals(100.14,temp.getValue(),epislonx); //test if the value agrees with the one we assigned
	}//the following methods functions in the similar way
	
	public void testgetvalue2(){
		Temperature temp =  new Temperature(150.23,Temperature.Units.FAHRENHEIT); 
		assertEquals(150.23,temp.getValue(),epislonx);
	}
	
	public void testgetvalue3(){
		Temperature temp =  new Temperature(-50.57,Temperature.Units.KELVIN); 
		assertEquals(-50.57,temp.getValue(),epislonx); 
	}
	
	
	//getunits()
	@Test
	public void testgetunits1(){
		Temperature temp =  new Temperature(100.14,Temperature.Units.CELCIUS); //define a new temperature
		assertEquals(Temperature.Units.CELCIUS,temp.units); //test if the value agrees with the one we assigned
	}//the following methods functions in the similar way

	@Test
	public void testgetunits2(){
		Temperature temp =  new Temperature(150.233,Temperature.Units.FAHRENHEIT); 
		assertEquals(Temperature.Units.FAHRENHEIT,temp.units); 
	}
	
	@Test
	public void testgetunits3(){
		Temperature temp =  new Temperature(-50.57,Temperature.Units.KELVIN); 
		assertEquals(Temperature.Units.KELVIN,temp.units); 
	}
	
// PART II changeUnits() TEST	
	//convert C to K
	@Test
	public void testU_CtoK1(){
		Temperature temp =  new Temperature(100.45,Temperature.Units.CELCIUS); //define a new temperature
		temp.changeUnits(Temperature.Units.KELVIN); //change the unit to another unit
		assertEquals(Temperature.Units.KELVIN,temp.units); //check if the unit is successfully changed
		assertEquals(373.6,temp.getValue(),epislonx);//check if the converted value is correct
	}//the following methods functions in the similar way
	
	@Test
	public void testU_CtoK2(){
		Temperature temp =  new Temperature(34.67,Temperature.Units.CELCIUS); 
		temp.changeUnits(Temperature.Units.KELVIN);
		assertEquals(Temperature.Units.KELVIN,temp.units);
		assertEquals(307.82,temp.getValue(),epislonx);
	}
	
	@Test
	public void testU_CtoK3(){
		Temperature temp =  new Temperature(-27.18,Temperature.Units.CELCIUS); 
		temp.changeUnits(Temperature.Units.KELVIN);
		assertEquals(Temperature.Units.KELVIN,temp.units);
		assertEquals(245.97,temp.getValue(),epislonx);
	}
	
	//convert C to F
	@Test
	public void testU_CtoF1(){
		Temperature temp =  new Temperature(100.45,Temperature.Units.CELCIUS);
		temp.changeUnits(Temperature.Units.FAHRENHEIT);
		assertEquals(Temperature.Units.FAHRENHEIT,temp.units);
		assertEquals(212.81,temp.getValue(),epislonx);
	}

	@Test
	public void testU_CtoF2(){
		Temperature temp =  new Temperature(34.67,Temperature.Units.CELCIUS);
		temp.changeUnits(Temperature.Units.FAHRENHEIT);
		assertEquals(Temperature.Units.FAHRENHEIT,temp.units);
		assertEquals(94.41,temp.getValue(),epislonx);
	}

	@Test
	public void testU_CtoF3(){
		Temperature temp =  new Temperature(-27.18,Temperature.Units.CELCIUS);
		temp.changeUnits(Temperature.Units.FAHRENHEIT);
		assertEquals(Temperature.Units.FAHRENHEIT,temp.units);
		assertEquals(-16.92,temp.getValue(),epislonx);
	}

	//convert F to C
	@Test
	public void testU_FtoC1(){
		Temperature temp =  new Temperature(180.12,Temperature.Units.FAHRENHEIT);
		temp.changeUnits(Temperature.Units.CELCIUS);
		assertEquals(Temperature.Units.CELCIUS,temp.units);
		assertEquals(82.29,temp.getValue(),epislonx);
	}
	
	@Test
	public void testU_FtoC2(){
		Temperature temp =  new Temperature(270.34,Temperature.Units.FAHRENHEIT);
		temp.changeUnits(Temperature.Units.CELCIUS);
		assertEquals(Temperature.Units.CELCIUS,temp.units);
		assertEquals(132.41,temp.getValue(),epislonx);
	}
	
	@Test
	public void testU_FtoC3(){
		Temperature temp =  new Temperature(360.56,Temperature.Units.FAHRENHEIT);
		temp.changeUnits(Temperature.Units.CELCIUS);
		assertEquals(Temperature.Units.CELCIUS,temp.units);
		assertEquals(182.53,temp.getValue(),epislonx);
	}
	
	//convert F to K
	@Test
	public void testU_FtoK1(){
		Temperature temp =  new Temperature(180.12,Temperature.Units.FAHRENHEIT);
		temp.changeUnits(Temperature.Units.KELVIN);
		assertEquals(Temperature.Units.KELVIN,temp.units);
		assertEquals(355.44,temp.getValue(),epislonx);
	}
	
	@Test
	public void testU_FtoK2(){
		Temperature temp =  new Temperature(270.34,Temperature.Units.FAHRENHEIT);
		temp.changeUnits(Temperature.Units.KELVIN);
		assertEquals(Temperature.Units.KELVIN,temp.units);
		assertEquals(405.56,temp.getValue(),epislonx);
	}
	
	@Test
	public void testU_FtoK3(){
		Temperature temp =  new Temperature(360.56,Temperature.Units.FAHRENHEIT);
		temp.changeUnits(Temperature.Units.KELVIN);
		assertEquals(Temperature.Units.KELVIN,temp.units);
		assertEquals(455.68,temp.getValue(),epislonx);
	}
	
	//convert K to C
	@Test
	public void testU_KtoC1(){
		Temperature temp =  new Temperature(180.12,Temperature.Units.KELVIN);
		temp.changeUnits(Temperature.Units.CELCIUS);
		assertEquals(Temperature.Units.CELCIUS,temp.units);
		assertEquals(-93.03,temp.getValue(),epislonx);
	}
	
	@Test
	public void testU_KtoC2(){
		Temperature temp =  new Temperature(270.34,Temperature.Units.KELVIN);
		temp.changeUnits(Temperature.Units.CELCIUS);
		assertEquals(Temperature.Units.CELCIUS,temp.units);
		assertEquals(-2.81,temp.getValue(),epislonx);
	}
	
	
	@Test
	public void testU_KtoC3(){
		Temperature temp =  new Temperature(360.56,Temperature.Units.KELVIN);
		temp.changeUnits(Temperature.Units.CELCIUS);
		assertEquals(Temperature.Units.CELCIUS,temp.units);
		assertEquals(87.41,temp.getValue(),epislonx);
	}
	
	//convert K to F
	@Test
	public void testU_KtoF1(){
		Temperature temp =  new Temperature(180.12,Temperature.Units.KELVIN);
		temp.changeUnits(Temperature.Units.FAHRENHEIT);
		assertEquals(Temperature.Units.FAHRENHEIT,temp.units);
		assertEquals(-135.45,temp.getValue(),epislonx);
	}
	
	@Test
	public void testU_KtoF2(){
		Temperature temp =  new Temperature(270.34,Temperature.Units.KELVIN);
		temp.changeUnits(Temperature.Units.FAHRENHEIT);
		assertEquals(Temperature.Units.FAHRENHEIT,temp.units);
		assertEquals(26.94,temp.getValue(),epislonx);
	}
	
	@Test
	public void testU_KtoF3(){
		Temperature temp =  new Temperature(360.56,Temperature.Units.KELVIN);
		temp.changeUnits(Temperature.Units.FAHRENHEIT);
		assertEquals(Temperature.Units.FAHRENHEIT,temp.units);
		assertEquals(189.34,temp.getValue(),epislonx);
	}
// PART III  Equals() TEST		
	//test K equals to F
	@Test
	public void testEquals_KtoF1(){
		Temperature temp =  new Temperature(180.12,Temperature.Units.KELVIN); //define a new temperature
		Temperature temp_equaltest= new Temperature(-135.45,Temperature.Units.FAHRENHEIT); //define this temperature in another unit
		assertTrue(temp.equals(temp_equaltest)); //check if they euqals each other
		assertEquals(Temperature.Units.KELVIN,temp.getUnits()); // check if the origin temperature has been changed
	} //the following methods functions in the similar way
	
	@Test
	public void testEquals_KtoF2(){
		Temperature temp =  new Temperature(270.34,Temperature.Units.KELVIN);
		Temperature temp_equaltest= new Temperature(26.94,Temperature.Units.FAHRENHEIT);
		assertTrue(temp.equals(temp_equaltest));
		assertEquals(Temperature.Units.KELVIN,temp.getUnits());
	}
	
	@Test
	public void testEquals_KtoF3(){
		Temperature temp =  new Temperature(360.56,Temperature.Units.KELVIN);
		Temperature temp_equaltest= new Temperature(189.34,Temperature.Units.FAHRENHEIT);
		assertTrue(temp.equals(temp_equaltest));
		assertEquals(Temperature.Units.KELVIN,temp.getUnits());
	}
	
	//test K equals to C
	@Test
	public void testEquals_KtoC1(){
		Temperature temp =  new Temperature(180.12,Temperature.Units.KELVIN);
		Temperature temp_equaltest= new Temperature(-93.03,Temperature.Units.CELCIUS);
		assertTrue(temp.equals(temp_equaltest));
		assertEquals(Temperature.Units.KELVIN,temp.getUnits());
	}
	
	@Test
	public void testEquals_KtoC2(){
		Temperature temp =  new Temperature(270.34,Temperature.Units.KELVIN);
		Temperature temp_equaltest= new Temperature(-2.81,Temperature.Units.CELCIUS);
		assertTrue(temp.equals(temp_equaltest));
		assertEquals(Temperature.Units.KELVIN,temp.getUnits());
	}
	
	@Test
	public void testEquals_KtoC3(){
		Temperature temp =  new Temperature(360.56,Temperature.Units.KELVIN);
		Temperature temp_equaltest= new Temperature(87.41,Temperature.Units.CELCIUS);
		assertTrue(temp.equals(temp_equaltest));
		assertEquals(Temperature.Units.KELVIN,temp.getUnits());
	}
	
	//test C equals to F
	@Test
	public void testEquals_CtoF1(){
		Temperature temp =  new Temperature(180.12,Temperature.Units.CELCIUS);
		Temperature temp_equaltest= new Temperature(356.22,Temperature.Units.FAHRENHEIT);
		assertTrue(temp.equals(temp_equaltest));
		assertEquals(Temperature.Units.CELCIUS,temp.getUnits());
	}
	
	@Test
	public void testEquals_CtoF2(){
		Temperature temp =  new Temperature(270.34,Temperature.Units.CELCIUS);
		Temperature temp_equaltest= new Temperature(518.61,Temperature.Units.FAHRENHEIT);
		assertTrue(temp.equals(temp_equaltest));
		assertEquals(Temperature.Units.CELCIUS,temp.getUnits());
	}
	
	@Test
	public void testEquals_CtoF3(){
		Temperature temp =  new Temperature(360.56,Temperature.Units.CELCIUS);
		Temperature temp_equaltest= new Temperature(681.01,Temperature.Units.FAHRENHEIT);
		assertTrue(temp.equals(temp_equaltest));
		assertEquals(Temperature.Units.CELCIUS,temp.getUnits());
	}
	
	//test C equals to K
	@Test
	public void testEquals_CtoK1(){
		Temperature temp =  new Temperature(180.12,Temperature.Units.CELCIUS);
		Temperature temp_equaltest= new Temperature(453.27,Temperature.Units.KELVIN);
		assertTrue(temp.equals(temp_equaltest));
		assertEquals(Temperature.Units.CELCIUS,temp.getUnits());
	}
	
	public void testEquals_CtoK2(){
		Temperature temp =  new Temperature(270.34,Temperature.Units.CELCIUS);
		Temperature temp_equaltest= new Temperature(543.49,Temperature.Units.KELVIN);
		assertTrue(temp.equals(temp_equaltest));
		assertEquals(Temperature.Units.CELCIUS,temp.getUnits());
	}
	
	public void testEquals_CtoK3(){
		Temperature temp =  new Temperature(360.56,Temperature.Units.CELCIUS);
		Temperature temp_equaltest= new Temperature(633.71,Temperature.Units.KELVIN);
		assertTrue(temp.equals(temp_equaltest));
		assertEquals(Temperature.Units.CELCIUS,temp.getUnits());
	}
	
	//test F equals to K
	@Test
	public void testEquals_FtoK1(){
		Temperature temp =  new Temperature(180.12,Temperature.Units.FAHRENHEIT);
		Temperature temp_equaltest= new Temperature(355.44,Temperature.Units.KELVIN);
		assertTrue(temp.equals(temp_equaltest));
		assertEquals(Temperature.Units.FAHRENHEIT,temp.getUnits());
	}
	
	@Test
	public void testEquals_FtoK2(){
		Temperature temp =  new Temperature(270.34,Temperature.Units.FAHRENHEIT);
		Temperature temp_equaltest= new Temperature(405.56,Temperature.Units.KELVIN);
		assertTrue(temp.equals(temp_equaltest));
		assertEquals(Temperature.Units.FAHRENHEIT,temp.getUnits());
	}
	
	@Test
	public void testEquals_FtoK3(){
		Temperature temp =  new Temperature(360.56,Temperature.Units.FAHRENHEIT);
		Temperature temp_equaltest= new Temperature(455.68,Temperature.Units.KELVIN);
		assertTrue(temp.equals(temp_equaltest));
		assertEquals(Temperature.Units.FAHRENHEIT,temp.getUnits());
	}
	
	//test F equals to C
	@Test
	public void testEquals_FtoC1(){
		Temperature temp =  new Temperature(180.12,Temperature.Units.FAHRENHEIT);
		Temperature temp_equaltest= new Temperature(82.29,Temperature.Units.CELCIUS);
		assertTrue(temp.equals(temp_equaltest));
		assertEquals(Temperature.Units.FAHRENHEIT,temp.getUnits());
	}
	
	@Test
	public void testEquals_FtoC2(){
		Temperature temp =  new Temperature(270.34,Temperature.Units.FAHRENHEIT);
		Temperature temp_equaltest= new Temperature(132.41,Temperature.Units.CELCIUS);
		assertTrue(temp.equals(temp_equaltest));
		assertEquals(Temperature.Units.FAHRENHEIT,temp.getUnits());
	}
	
	@Test
	public void testEquals_FtoC3(){
		Temperature temp =  new Temperature(360.56,Temperature.Units.FAHRENHEIT);
		Temperature temp_equaltest= new Temperature(182.53,Temperature.Units.CELCIUS);
		assertTrue(temp.equals(temp_equaltest));
		assertEquals(Temperature.Units.FAHRENHEIT,temp.getUnits());
	}

}
