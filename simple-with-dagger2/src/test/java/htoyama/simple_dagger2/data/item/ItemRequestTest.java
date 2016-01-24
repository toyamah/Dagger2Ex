package htoyama.simple_dagger2.data.item;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class ItemRequestTest {

    private ItemRequest mRequest;
    @Mock private ItemParser mParser;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mRequest = new ItemRequest(mParser);
    }

    @Test
    public void request_通常時はモデルを取得できる() {
        Item expected = new Item(1, "name", 100);
        when(mParser.parse(anyString()))
                .thenReturn(expected);

        Item actual = mRequest.execute();

        assertThat(actual, is(expected));
    }

    @Test(expected = RuntimeException.class)
    public void request_パース失敗時は例外が投げられる() {
        when(mParser.parse(anyString()))
                .thenThrow(new RuntimeException());

        mRequest.execute();
    }

}