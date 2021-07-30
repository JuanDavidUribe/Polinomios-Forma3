package polynomials;

import javax.swing.JOptionPane;

public class PolinomioForma3 {
	private Nodo cab;

	public PolinomioForma3() {
		cab = null;
	}

	public Nodo getCab() {
		return this.cab;
	}

	public void ingresarPolinomio(String cadena) {			
		int coef = 0, exp = 0, i=0;
		cadena = cadena.toUpperCase();
		char[] vec = cadena.toCharArray();
		do {
			while ((vec[i] != '+' && vec[i] != '-') && (i != vec.length-1)) {
				switch (vec[i]) {
				case 'X':
					try {
						if (vec[i - 1] == '+' || vec[i - 1] == '-') {
							if (vec [i-1] == '-') {
								coef = -1;
							}
							coef = 1;
						} else {
							coef = Character.getNumericValue(vec[i - 1]);
							if (vec [i-2] == '-') {
								coef = coef * -1;
							}
						}
						
					} catch (Exception e) {}
					try {
						if (Character.isDigit(vec[i - 2])) {
							String n3 = String.valueOf(vec[i - 2]) + String.valueOf(vec[i - 1]);
							coef = Integer.parseInt(n3);
							try {
								if (vec [i-3] == '-') {
									coef = coef *-1;
								}
							} catch (Exception e) {}
						}
					} catch (Exception e) {}
					break;
				case '^':
					exp = Character.getNumericValue(vec [i+1]);
					break;
				default:
					break;
				}
				i++;
			}
			if (!(vec[i] != '+' && vec[i] != '-')) {
				i++;
			}
			if (i != 0) {
				llenarPol(coef, exp);
				coef = 0;
				exp = 0;
			}
		} while (i < vec.length-1);
	}
	
	public void llenarPol (int coef, int exp) {
		Nodo x, p, ant = null;
		if (cab == null) {
			cab = new Nodo (coef, exp);
		}
		else {
			p = cab;
			while (p.getLiga() != null && p.getExp() > exp) {
				ant = p;
				p = p.getLiga();
			}
			if (p.getExp() == exp) {
				p.setCoef(p.getCoef() + coef);
			}
			else {
				if (exp > p.getExp()) {
					x = new Nodo(coef, exp);
					x.setLiga(p);				
					if (p == cab) {
						cab = x;
					} else {
						ant.setLiga(x);
					}
				}
				else {
					x = new Nodo (coef,exp);
					x.setLiga(p.getLiga());
					p.setLiga(x);
				}
			}	
		}
		
	}


	public void mostrar() {
		Nodo recorrer = cab;
		if (recorrer == null) {
			JOptionPane.showMessageDialog(null, "el polinomio esta vacio");
		} else {
			while (recorrer != null) {
				if (recorrer.getCoef() > 0 && recorrer != cab) {
					System.out.print("+" + recorrer.getCoef() + "X^" + recorrer.getExp());
				} else {
					System.out.print(recorrer.getCoef() + "X^" + recorrer.getExp());
				}
				recorrer = recorrer.getLiga();
			}
		}
	}

}
