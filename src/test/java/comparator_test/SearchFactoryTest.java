package comparator_test;

import comparator.SearchFactory;
import comparator.search_type.SearchType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

import static comparator.search_type.SearchType.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)

@DisplayName("Search factory test")
public class SearchFactoryTest {

    private SearchFactory searchFactory;
    private List <SearchType> allTypes;

    @BeforeEach
    void prepare(){
        searchFactory = new SearchFactory();
        allTypes = new ArrayList();
        allTypes.add(Regular);
        allTypes.add(Mask);
        allTypes.add(Equals);
        allTypes.add(Full);
    }

    @DisplayName("Create with all correct SearchType test")
    @Test
    void createWithCorrectTypeTest(){

        for (SearchType filter: allTypes) {
            try {
                searchFactory.create(filter);
            } catch (IllegalStateException e) {
                System.out.println("Unexpected type: " + filter);
            }
        }
    }
}
