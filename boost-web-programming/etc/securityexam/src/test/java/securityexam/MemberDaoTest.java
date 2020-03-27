package securityexam;

import java.sql.Connection;

import javax.sql.DataSource;

import org.ggyool.securityexam.config.ApplicationConfig;
import org.ggyool.securityexam.dao.MemberDao;
import org.ggyool.securityexam.dao.MemberRoleDao;
import org.ggyool.securityexam.dto.Member;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
// Dao Test 할 것이기 떄문에, ApplicationConfig 만 넣으면 된다.
@ContextConfiguration(classes = {ApplicationConfig.class})
public class MemberDaoTest {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	MemberDao memberDao;
	
	@Autowired
	MemberRoleDao memberRoleDao;
	
	@Test
    public void configTest() throws Exception{
        // 아무 작업도 하지 않는다. 실행이 잘된다는 것은 Spring 설정이 잘 되어 있다는 것을 의미한다.
    }
	
	@Test
    public void connnectionTest() throws Exception{
        Connection connection = dataSource.getConnection();
        Assert.assertNotNull(connection);
    }
	
	@Test
    public void getUser() throws Exception{
        Member member = memberDao.getMemberByEmail("carami@example.com");
        Assert.assertNotNull(member);
        Assert.assertEquals("귝귝이", member.getName());
    }

}
