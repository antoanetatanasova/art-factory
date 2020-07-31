package bg.softuni.artfactory.service;

import bg.softuni.artfactory.model.service.MessageServiceModel;
import bg.softuni.artfactory.model.view.MessageViewModel;

import java.util.List;

public interface MessageService {

    void addMessage(MessageServiceModel messageServiceModel);

    List<MessageViewModel> findAllMessages();

    MessageServiceModel findById(Long id);

    void delete(Long id);

}