package org.ggyool.calculatorcli;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;

import org.ggyool.calculatorcli.service.MyService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
//@ContextConfiguration(classes = {ApplicationConfig.class})
public class MyServiceTest {

	@InjectMocks
	MyService myService;
	
	@Mock
	CalculatorService calculatorService;  
	@Test
	public void execute() throws Exception{
		int v1 = 5;
		int v2 = 10;
		given(calculatorService.plus(anyInt(), anyInt())).willReturn(15);
		
		int res = myService.execute(v1, v2);
		verify(calculatorService).plus(anyInt(), anyInt());
		Assert.assertEquals(30, res);
	}
	
}
