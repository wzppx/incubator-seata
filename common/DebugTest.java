import com.alibaba.fescar.common.util.StringUtils;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class DebugTest {
    public static void main(String[] args) throws Exception {
        InputStream is = DebugTest.class.getClassLoader().getResourceAsStream("test.txt");
        String result = StringUtils.inputStream2String(is);
        System.out.println("Result: [" + result + "]");
        System.out.println("Bytes:");
        for (byte b : result.getBytes(StandardCharsets.UTF_8)) {
            System.out.print(b & 0xFF);
            System.out.print(" ");
        }
        System.out.println();
        
        String expected = "abc\n"
                + ":\"klsdf\n"
                + "2ks,x:\".,-3sd˚ø≤ø¬≥";
        System.out.println("Expected bytes:");
        for (byte b : expected.getBytes(StandardCharsets.UTF_8)) {
            System.out.print(b & 0xFF);
            System.out.print(" ");
        }
        System.out.println();
        System.out.println("Equal: " + expected.equals(result));
    }
}
