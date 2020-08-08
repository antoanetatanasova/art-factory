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
public class ActivityManageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "admin@example.com", roles = {"USER", "ADMIN"})
    public void testNewActivity() throws Exception {
        mockMvc.perform(
                post("/administration/activities/add").
                        with(csrf()).
                        contentType(MediaType.APPLICATION_FORM_URLENCODED).
                        param("name", "Some title here").
                        param("description", "This is the most useless description ever seen."))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/administration/activities"));
    }

    @Test
    @WithMockUser(username = "admin@example.com", roles = {"USER", "ADMIN"})
    public void testNewActivityFailed() throws Exception {
        mockMvc.perform(
                post("/administration/activities/add").
                        with(csrf()).
                        contentType(MediaType.APPLICATION_FORM_URLENCODED).
                        param("name", "So").
                        param("description", "short"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:add"));
    }

}