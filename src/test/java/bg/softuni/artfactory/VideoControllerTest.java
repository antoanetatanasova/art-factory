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
public class VideoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "admin@example.com", roles = {"USER", "ADMIN"})
    public void testNewVideo() throws Exception {
        mockMvc.perform(
                post("/video/add").
                        with(csrf()).
                        contentType(MediaType.APPLICATION_FORM_URLENCODED).
                        param("thumbnail", "https://res.cloudinary.com/the-potential/image/upload/v1595087223/art-factory/workshops/top-view-photo-of-person-weaving-using-hand-loom-4219651_agzxhb.jpg").
                        param("title", "Some title here").
                        param("youtubeStamp", "UdCCmhq_Xco"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/"));
    }

    @Test
    @WithMockUser(username = "admin@example.com", roles = {"USER", "ADMIN"})
    public void testNewVideoFailed() throws Exception {
        mockMvc.perform(
                post("/video/add").
                        with(csrf()).
                        contentType(MediaType.APPLICATION_FORM_URLENCODED).
                        param("title", "Some title here").
                        param("thumbnail", "notAnUrl"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:add"));
    }

}