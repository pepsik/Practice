import org.junit.Test;
import task2.Task2;

import static org.assertj.core.api.Assertions.*;

import java.util.*;

/**
 * Created by Berezovyi Aleksandr on 7/19/2016.
 */
public class practice {

    @Test
    public void tests() {
        assertThatThrownBy(() -> new DummyService().throwException())
                .isInstanceOf(RuntimeException.class);
    }
}

class DummyService {
    public void throwException() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        new Thread(() -> System.out.println("lol")).start();

        Collections.sort(new ArrayList<>(), Integer::compare);

        Arrays.sort(new String[5],
                (firstStr, secondStr) -> Integer.compare(firstStr.length(), secondStr.length()));
    }
}