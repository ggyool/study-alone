package org.ggyool.calculatorcli;

import org.ggyool.calculatorcli.config.ApplicationConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {ApplicationConfig.class})
public class CalculatorServiceTest {
	
	@Autowired
	CalculatorService calculatorService;
	
	/*
	@Before
	public void init() {
		this.calculatorService = new CalculatorService();
	}*/
	
	 @Test
    public void plus() throws Exception{
        // given
        int v1 = 10;
        int v2 = 5;
        // when
        int res = calculatorService.plus(v1, v2);
        // then
        Assert.assertEquals(15, res); // 결과와 15가 같을 경우에만 성공
    }

    @Test
    public void divide() throws Exception{
        // given
        int v1 = 10;
        int v2 = 5;
        // when
        int res = calculatorService. divide (v1, v2);
        // then
        Assert.assertEquals(2,res); // 결과와 2가 같을 경우에만 성공
    }
    @Test
    public void divideExceptionTest() throws Exception{
    	int v1 = 10;
    	int v2 = 0;
    	try {
    		calculatorService.divide(v1, v2);
    	}catch (ArithmeticException ae){
            Assert.assertTrue(true); // 이부분이 실행되었다면 성공
            return; // 메소드를 더이상 실행하지 않는다.
        }
    	Assert.fail("asd");
    }
}
