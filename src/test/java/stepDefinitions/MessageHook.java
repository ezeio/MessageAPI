package stepDefinitions;

import com.message.app.messageapi.model.Message;
import com.message.app.messageapi.service.MessageService;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


public class MessageHook {
    private static List<Message> messages = new ArrayList<>();
    @Autowired
    private MessageService messageService;
    private Message message1 = new Message();
    private Message message2 = new Message();
    private Message message3 = new Message();
    private Message message4 = new Message();
    private Message message5 = new Message();
    private Message message6 = new Message();
    private Message message7 = new Message();

    @Before("@Getter")
    public void beforeScenario() {

        message1.setTitle("Acceptance test");
        message1.setMessage("cukes library is still being supported by JetBrains for now according to the CTO");
        message2.setTitle("Home alone 2");
        message2.setMessage("You need to watch home alone 2");
        message3.setTitle("Brazilian nut");
        message3.setMessage("Currently trending on twitter - very healthy nuts");
        message4.setTitle("State of Spring boot");
        message4.setMessage("There so many ways to do the same thing - when options becomes an issue");
        message5.setTitle("Exam day headline");
        message5.setMessage("Running out of headlines so I resulted to this?");
        message6.setTitle("African safari");
        message6.setMessage("Just typing African safari made me realise what MAC OS default browser got its name from");
        message7.setTitle("Messages in string");
        message7.setMessage("Finally the last massage");

        messages.add(message1);
        messages.add(message2);
        messages.add(message3);
        messages.add(message4);
        messages.add(message5);
        messages.add(message6);
        messages.add(message7);

        for (Message message : messages) {
            messageService.createMessage(message);
        }
    }


    @After
    public void afterScenario() {

    }

}
