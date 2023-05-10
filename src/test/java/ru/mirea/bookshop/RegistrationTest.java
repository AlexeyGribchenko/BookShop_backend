package ru.mirea.bookshop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.mirea.bookshop.controllers.RegistrationController;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RegistrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RegistrationController registrationController;

    @Test
    public void contextLoadsTest() throws Exception {
        assertThat(registrationController).isNotNull();
    }

    @Test
    public void getRegistrationPageTest() throws Exception {
        this.mockMvc.perform(get("/registration"))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andExpect(content().string(containsString("Страница регистрации")));
    }

    @Test
    public void registerNewUserTest() throws Exception {
        this.mockMvc.perform(post("/registration")
                .param("username", "1212")
                .param("password", "1212")
                .param("firstName", "1212")
                .param("lastName", "1212")
                .param("birthDateString", "1212-12-12"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
