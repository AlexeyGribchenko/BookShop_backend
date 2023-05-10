package ru.mirea.bookshop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.mirea.bookshop.controllers.MainController;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.yml")
@Sql(value = {"/create-user-before.sql", "/create-book-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/create-book-after.sql", "/create-user-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class HomeTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MainController mainController;

    @Test
    public void contextLoadsTest() throws Exception {
        assertThat(mainController).isNotNull();
    }

    @Test
    public void getMainPageTest() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("2023 РТУ МИРЭА")));
    }

    @Test
    public void getBookPageTest() throws Exception {
        this.mockMvc.perform(get("/book_page/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Ведьмак. Последнее желание.")));
    }

    @Test
    public void bookSearchTest1() throws Exception {
        this.mockMvc.perform(get("/search_books?searchPrompt=ни"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(xpath("//div[@id='book-list-main-page']/div").nodeCount(2));
    }

    @Test
    public void bookSearchTest2() throws Exception {
        this.mockMvc.perform(get("/search_books?searchPrompt="))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(xpath("//div[@id='book-list-main-page']/div").nodeCount(3));
    }
}
