import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        try (BufferedReader bfr = new BufferedReader(new FileReader(new File("Countries.csv")))) {
            Map<String, Country> countriesMap = read(bfr);
            getInfo(countriesMap);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void getInfo(Map<String, Country> countriesMap) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj kod kraju, którego informacje chcesz wyświetlić.");
        String inputCode = scanner.nextLine();
        scanner.close();
        Country country = countriesMap.get(inputCode);
        if (country != null) {
            System.out.println(country.toString());
        } else System.out.println("Źle wpisany kod");
    }

    private static Map<String, Country> read(BufferedReader bfr) throws IOException {
        String line;
        Map<String, Country> countriesMap = new HashMap<>();
        while ((line = bfr.readLine()) != null) {
            String[] country = line.split(";");
            countriesMap.put(country[0], new Country(country[0], country[1], country[2]));
        }
        return countriesMap;
    }
}