//ECSE-321
//Assignment-2
//Xinchi Chen
//260376222
//2012-09-23

package temperature;

import static org.junit.Assert.*;
import org.junit.*;

/*in this testcase, random values are chosen to ensure the program can deal with any kind of situations*/


public class TempTest {
	
	final static double epislonx = 1e-8; //used for 

// PART I getUnits() and getValue() TEST
	
	@Test
	public void testgetvalue(){
		Temperature temp =  new Temperature(100,Temperature.Units.CELCIUS);
		assertEquals(100,temp.getValue(),epislonx);
	}
	
	@Test
	public void testgetunits(){
		Temperature temp =  new Temperature(100,Temperature.Units.CELCIUS);
		assertEquals(Temperature.Units.CELCIUS,temp.units);
	}

// PART II changeUnits() TEST	
	
	@Test
	public void testU_CtoK(){
		Temperature temp =  new Temperature(100,Temperature.Units.CELCIUS);
		temp.changeUnits(Temperature.Units.KELVIN);
		assertEquals(Temperature.Units.KELVIN,temp.units);
		assertEquals(373.15,temp.getValue(),epislonx);
	}
	
	@Test
	public void testU_CtoF(){
		Temperature temp =  new Temperature(100,Temperature.Units.CELCIUS);
		temp.changeUnits(Temperature.Units.FAHRENHEIT);
		assertEquals(Temperature.Units.FAHRENHEIT,temp.units);
		assertEquals(212,temp.getValue(),epislonx);
	}

	@Test
	public void testU_FtoC(){
		Temperature temp =  new Temperature(180,Temperature.Units.FAHRENHEIT);
		temp.changeUnits(Temperature.Units.CELCIUS);
		assertEquals(Temperature.Units.CELCIUS,temp.units);
		assertEquals(82.22,temp.getValue(),epislonx);
	}
	
	@Test
	public void testU_FtoK(){
		Temperature temp =  new Temperature(180,Temperature.Units.FAHRENHEIT);
		temp.changeUnits(Temperature.Units.KELVIN);
		assertEquals(Temperature.Units.KELVIN,temp.units);
		assertEquals(355.37,temp.getValue(),epislonx);
	}
	
	@Test
	public void testU_KtoC(){
		Temperature temp =  new Temperature(373.15,Temperature.Units.KELVIN);
		temp.changeUnits(Temperature.Units.CELCIUS);
		assertEquals(Temperature.Units.CELCIUS,temp.units);
		assertEquals(100,temp.getValue(),epislonx);
	}
	
	@Test
	public void testU_KtoF(){
		Temperature temp =  new Temperature(200,Temperature.Units.KELVIN);
		temp.changeUnits(Temperature.Units.FAHRENHEIT);
		assertEquals(Temperature.Units.FAHRENHEIT,temp.units);
		assertEquals(-99.67,temp.getValue(),epislonx);
	}
	
// PART III  TEST		
	
	@Test
	public void testEquals_KtoF(){
		Temperature temp =  new Temperature(200,Temperature.Units.KELVIN);
		Temperature temp_equaltest= new Temperature(-99.67,Temperature.Units.FAHRENHEIT);
		assertTrue(temp.equals(temp_equaltest));
		assertEquals(Temperature.Units.KELVIN,temp.getUnits());
	}
	
	//stophere
	
	@Test
	public void testEquals_KtoC(){
		Temperature temp =  new Temperature(200,Temperature.Units.KELVIN);
		Temperature temp_equaltest= new Temperature(-73.15,Temperature.Units.CELCIUS);
		assertTrue(temp.equals(temp_equaltest));
		assertEquals(Temperature.Units.KELVIN,temp.getUnits());
	}
	
	@Test
	public void testEquals_CtoF(){
		Temperature temp =  new Temperature(200,Temperature.Units.CELCIUS);
		Temperature temp_equaltest= new Temperature(392,Temperature.Units.FAHRENHEIT);
		assertTrue(temp.equals(temp_equaltest));
		assertEquals(Temperature.Units.CELCIUS,temp.getUnits());
	}
	
	@Test
	public void testEquals_CtoK(){
		Temperature temp =  new Temperature(200.23,Temperature.Units.CELCIUS);
		Temperature temp_equaltest= new Temperature(473.38,Temperature.Units.KELVIN);
		assertTrue(temp.equals(temp_equaltest));
		assertEquals(Temperature.Units.CELCIUS,temp.getUnits());
	}
	
	@Test
	public void testEquals_FtoK(){
		Temperature temp =  new Temperature(198,Temperature.Units.FAHRENHEIT);
		Temperature temp_equaltest= new Temperature(365.37,Temperature.Units.KELVIN);
		assertTrue(temp.equals(temp_equaltest));
		assertEquals(Temperature.Units.FAHRENHEIT,temp.getUnits());
	}
	
	@Test
	public void testEquals_FtoC(){
		Temperature temp =  new Temperature(200,Temperature.Units.FAHRENHEIT);
		Temperature temp_equaltest= new Temperature(93.33,Temperature.Units.CELCIUS);
		assertTrue(temp.equals(temp_equaltest));
		assertEquals(Temperature.Units.FAHRENHEIT,temp.getUnits());
	}
	
}
