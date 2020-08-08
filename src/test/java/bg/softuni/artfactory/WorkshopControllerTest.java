package bg.softuni.artfactory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
public class WorkshopControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "admin@example.com", roles = {"USER", "ADMIN"})
    public void testNewWorkshop() throws Exception {
        mockMvc.perform(
                post("/workshops/add").
                        with(csrf()).
                        contentType(MediaType.APPLICATION_FORM_URLENCODED).
                        param("name", "Some title here").
                        param("description", "Some long description with no useful information here.").
                        param("imageUrl", "https://res.cloudinary.com/the-potential/image/upload/v1595087221/art-factory/workshops/photo-of-cookies-on-string-3334477_eg34lh.jpg").
                        param("price", String.valueOf(25)).
                        param("startsOn", String.valueOf(LocalDateTime.of(2020, 8, 29, 5,0, 0))).
                        param("endsOn", String.valueOf(LocalDateTime.of(2020, 8, 29, 11,0, 0))).
                        param("maxPlaces", String.valueOf(3)))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/"));
    }

    @Test
    @WithMockUser(username = "admin@example.com", roles = {"USER", "ADMIN"})
    public void testNewWorkshopFailed() throws Exception {
        mockMvc.perform(
                post("/workshops/add").
                        with(csrf()).
                        contentType(MediaType.APPLICATION_FORM_URLENCODED).
                        param("name", "Some title here").
                        param("description", "short"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:add"));
    }

}