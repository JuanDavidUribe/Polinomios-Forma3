package run;

import operations.CalculadoraForma3;
import polynomials.PolinomioForma3;

public class main {

	public static void main(String[] args) {
		PolinomioForma3 polinomio = new PolinomioForma3(), polinomio2 = new PolinomioForma3(), resultado;
		CalculadoraForma3 res = new CalculadoraForma3 ();
		System.out.println("iniciando programa\n");
		polinomio.ingresarPolinomio("2x^3+5x^2-4x^1");  		
		polinomio2.ingresarPolinomio("3x^1");
		System.out.println("polinomio 1:");
		polinomio.mostrar();
		System.out.println("polinomio 2:");
		polinomio2.mostrar();
		resultado = res.sumar(polinomio, polinomio2);
		System.out.println("Suma:");
		resultado.mostrar();
		resultado = res.multilpicar(polinomio, polinomio2);
		System.out.println("multiplicacion:");
		resultado.mostrar();
	}
}
