import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class NewClass
{

    static char[] get_Password(int len)
    {   String ascii_art = " _.........._\n" +
            "| |Made By | |\n" +
            "| |PRANAV  | |\n" +
            "| |SHIRGUR | |\n" +
            "| |________| |\n" +
            "|   ______   |\n" +
            "|  |    | |  |\n" +
            "|__|____|_|__|";
        System.out.println("Generating password\n"+ascii_art);
        System.out.print("Your password is : ");


        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*_=+-/.?<>)";


        String values = Capital_chars + Small_chars +
                numbers + symbols;

        // Using random method
        Random rndm_method = new Random();

        char[] password = new char[len];

        for (int i = 0; i < len; i++)
        {
            // Use of charAt() method : to get character value
            // Use of nextInt() as it is scanning the value as int
            password[i] =
                    values.charAt(rndm_method.nextInt(values.length()));

        }
        return password;
    }








}
class Salt extends NewClass
{
    public static void main(String[] args) throws IOException {

        int length = 10;
        //  int first_placement = 2;
        //  int second_placement = 7;
        char X[] = get_Password(length + 2);

        for (int first_placement = 2; first_placement <= length; first_placement++) {
            X[first_placement] = X[first_placement + 1];
            X[2] = '2';
        }

        for (int second_placement = 7; second_placement <= length; second_placement++) {
            X[second_placement] = X[second_placement + 1];
            X[7] = '7';

        }

        for (int i = 0; i <= 10; i++) {
            System.out.print(X[i]);

        }
        String output_string = new String(X);

        BufferedWriter out = null;

        try {
            FileWriter fstream = new FileWriter("password.txt", true); //true tells to append data.
            out = new BufferedWriter(fstream);
            out.write(output_string);
        }

        catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

        finally {
            if(out != null) {
                out.close();
            }
        }
    }
}
