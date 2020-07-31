package bg.softuni.artfactory.service.impl;

import bg.softuni.artfactory.model.service.MessageServiceModel;
import bg.softuni.artfactory.model.view.MessageViewModel;
import bg.softuni.artfactory.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Override
    public void addMessage(MessageServiceModel messageServiceModel) {

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
