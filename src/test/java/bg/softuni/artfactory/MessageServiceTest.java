package bg.softuni.artfactory;

import bg.softuni.artfactory.model.entity.Message;
import bg.softuni.artfactory.model.view.MessageViewModel;
import bg.softuni.artfactory.repository.MessageRepository;
import bg.softuni.artfactory.service.MessageService;
import bg.softuni.artfactory.service.impl.MessageServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MessageServiceTest {

    private MessageService serviceToTest;

    @Mock
    MessageRepository mockMessageRepository;

    @BeforeEach
    public void setUp() {
        this.serviceToTest = new MessageServiceImpl(mockMessageRepository, new ModelMapper());
    }

    @Test
    public void testFindAll() {
        //Arrange
        Message messageEntity = new Message();
        messageEntity.setSender("John");
        messageEntity.setEmail("john@example.com");
        messageEntity.setSubject("Test subject");
        messageEntity.setBody("This is only a test message body. New sentence in the same test message body.");

        when(mockMessageRepository.findAll()).
                thenReturn(List.of(messageEntity));

        // act
        List<MessageViewModel> messageModel = serviceToTest.findAllMessages();

        // assert
        Assertions.assertEquals(1, messageModel.size());
        MessageViewModel actualModel = messageModel.get(0);

        Assertions.assertEquals(messageEntity.getSender(), actualModel.getSender());
        Assertions.assertEquals(messageEntity.getEmail(), actualModel.getEmail());
        Assertions.assertEquals(messageEntity.getSubject(), actualModel.getSubject());
        Assertions.assertEquals(messageEntity.getBody(), actualModel.getBody());
    }


}