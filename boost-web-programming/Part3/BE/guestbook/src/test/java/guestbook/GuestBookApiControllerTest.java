package guestbook;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.ggyool.guestbook.config.ApplicationConfig;
import org.ggyool.guestbook.config.WebMvcContextConfiguration;
import org.ggyool.guestbook.controller.GuestBookApiController;
import org.ggyool.guestbook.dto.GuestBook;
import org.ggyool.guestbook.service.GuestBookService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebMvcContextConfiguration.class, ApplicationConfig.class })
public class GuestBookApiControllerTest {

	//Test target
	@InjectMocks
	public GuestBookApiController guestBookApiController;
	
	@Mock
	GuestBookService guestBookService;
	
	private MockMvc mockMvc;
	
	@Before
    public void createController() {
		// @Mock 붙어있는 객체들 mock으로 초기화
        MockitoAnnotations.initMocks(this);
        // 테스트 객체 생성 
        mockMvc = MockMvcBuilders.standaloneSetup(guestBookApiController).build();
    }
	
	@Test
	public void getGuestBooks() throws Exception { 
		GuestBook guestBook = new GuestBook();
		guestBook.setId(1L);
		guestBook.setRegdate(new Date());
		guestBook.setContent("hello");
		guestBook.setName("kim");
		
		List<GuestBook> list = Arrays.asList(guestBook);
		when(guestBookService.getGuestBooks(0)).thenReturn(list);
		RequestBuilder reqBuilder = MockMvcRequestBuilders.get("/guestbooks").contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(reqBuilder).andExpect(status().isOk()).andDo(print());

        verify(guestBookService).getGuestBooks(0);
        
	}
	
	@Test
    public void deleteGuestbook() throws Exception {
        Long id = 1L;

        when(guestBookService.deleteGuestBook(id, "127.0.0.1")).thenReturn(1);

        RequestBuilder reqBuilder = MockMvcRequestBuilders.delete("/guestbooks/" + id).contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(reqBuilder).andExpect(status().isOk()).andDo(print());
        

        verify(guestBookService).deleteGuestBook(id, "127.0.0.1");
    }
}
