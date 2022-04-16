
import com.mycompany.bookshop.DAO.Book;
import com.mycompany.bookshop.DataSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nikita
 */
public class HomeTask2Test {
    
     @Test
    public void testDataSource(){
        // given
        DataSource ds = Mockito.mock(DataSource.class);
        // when
          //   Mockito.doReturn(data).when(ds).getData();


        // then
       // assertEquals(mirArrayList.size(),3,"Size of ArrayList is incorrect");
    }
    
      @Test
    public void testBook(){
        // given
       // Book book = Mockito.mock(Book.class);
         Book book = Mockito.spy(Book.class);

        book.setBookId(1L);
        book.setName("Game of Thrones");
       
        // when
        when(book.getBookId()).thenReturn(1L);

        // then
        //assertEquals(book.getBookId(), 1);
         assertEquals(book.getName(), "Game of Thrones");

       // assertEquals(mirArrayList.size(),3,"Size of ArrayList is incorrect");
    }
    
}
