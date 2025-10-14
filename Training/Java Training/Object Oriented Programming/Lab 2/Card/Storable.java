import java.io.FileNotFoundException;
import java.io.IOException;

public interface Storable {
    void store(String file) throws FileNotFoundException;
    void read(String file) throws IOException;
}
