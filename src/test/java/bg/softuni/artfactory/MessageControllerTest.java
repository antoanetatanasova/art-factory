package bg.softuni.artfactory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
public class MessageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "admin@example.com", roles = {"USER", "ADMIN"})
    public void testNewMessage() throws Exception {
        mockMvc.perform(
                post("/contact").
                        with(csrf()).
                        contentType(MediaType.APPLICATION_FORM_URLENCODED).
                        param("sender", "John Doe").
                        param("email", "user@user.com").
                        param("subject", "Test subject").
                        param("body", "This is only a test message body. New sentence in the same test message body."))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/contact"));
    }

    @Test
    @WithMockUser(username = "admin@example.com", roles = {"USER", "ADMIN"})
    public void testNewMessageFailed() throws Exception {
        mockMvc.perform(
                post("/contact").
                        with(csrf()).
                        contentType(MediaType.APPLICATION_FORM_URLENCODED).
                        param("sender", "John Doe").
                        param("email", "not an email"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/contact"));
    }

}