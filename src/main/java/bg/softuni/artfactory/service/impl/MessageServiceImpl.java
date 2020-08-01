package bg.softuni.artfactory.service.impl;

import bg.softuni.artfactory.model.entity.Message;
import bg.softuni.artfactory.model.service.MessageServiceModel;
import bg.softuni.artfactory.model.view.MessageViewModel;
import bg.softuni.artfactory.repository.MessageRepository;
import bg.softuni.artfactory.service.MessageService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final ModelMapper modelMapper;

    public MessageServiceImpl(MessageRepository messageRepository, ModelMapper modelMapper) {
        this.messageRepository = messageRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addMessage(MessageServiceModel messageServiceModel) {
        Message message = this.modelMapper
                .map(messageServiceModel, Message.class);
        this.messageRepository.saveAndFlush(message);
    }

    @Override
    public List<MessageViewModel> findAllMessages() {
        return null;
    }

    @Override
    public MessageServiceModel findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
