import java.util.List;

public class Main {
    public static void main(String[] args) {
        var rationals = List.of(
                new Rational(1, 4),
                new Rational(1, 8),
                new Rational(3, 4),
                new Rational(7, 8));
        //Imperativo
        var unMedio = new Rational(1, 2);
        for(Rational r : rationals){
            if(r.isLessThan(unMedio)){
                System.out.println(r);
            }
        }
        //obtener todos los números racionales menores a 1/2
        System.out.println("números racionales menores a 1/2");
        rationals.stream()
                .filter(r->r.isLessThan(unMedio))
                .forEach(System.out::println);
        //sumar todos los racionales
        System.out.println("Suma de los números racionales");
        var suma=rationals.stream().reduce(Rational::plus);
        System.out.println(suma);
        //obtener el número racional mayor
        System.out.println("Número racional mayor");
        Rational rmayor =rationals.stream().reduce(unMedio,(a,b) -> a.getGreater(b));
        System.out.println(rmayor);
        //sumar numeradores
        System.out.println("Suma numeradores");
        int sumaNumeradores = rationals.
                stream().mapToInt(Rational::getNumerator).sum();
        System.out.println(sumaNumeradores);

        System.out.println("Promedio numeradores");
        double promNume = rationals.stream().mapToInt(Rational::getNumerator).average().getAsDouble();
        System.out.println(promNume);

        System.out.println("Calcular el Mayor y menor");
        int mayor;
        int menor;

        mayor = rationals.stream().mapToInt(Rational::getNumerator).max().getAsInt();
        System.out.println("Numerador Mayor"+ mayor);
        menor = rationals.stream().mapToInt(Rational::getNumerator).min().getAsInt();
        System.out.println("Numerador Menor"+ menor);
    }
    }

