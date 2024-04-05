import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fInicio = LocalDate.of(2024, 3, 1);
        System.out.println("Fecha: "+fInicio.format(formato));
    }
}
