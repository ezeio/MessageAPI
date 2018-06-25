package config;

import com.message.app.messageapi.MessageApiApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(classes = MessageApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("Integration_Test")
@ContextConfiguration
public class SpringIntegrationTest {




}
