package session2.td.agregation;

import session1.td.Outils;

public class Test {

	private static void test(session1.td.FabriqueNaturels<Nat> fab) {
		System.out.println("************************************************");
		System.out.println(fab.getClass());
		System.out.println("************************************************");
		Nat zero = fab.creerNatAvecValeur(0);
		System.out.println("0 ? " + zero);
		System.out.println("true ? " + zero.equals(zero.zero()));
		Nat un = fab.creerSuccesseur(zero);
		System.out.println("1 ? " + un);
		zero = un.predecesseur();
		System.out.println("0 ? " + zero);
		System.out.println("true ? " + un.equals(un.un()));
		Nat cinq = fab.creerNatAvecValeur(5);
		System.out.println("5 ? " + cinq);
		Nat six = fab.creerNatAvecValeur(6);
		System.out.println("11 ? " + cinq.somme(six));
		System.out.println("30 ? " + cinq.produit(six));
		System.out.println("3 ? " + cinq.produit(six).somme(six.div(un.somme(un))).modulo(six));
		System.out.println("5 ? " + cinq.produit(six).somme(six.div(un.somme(un))).div(six));
		System.out.println("30 ? " + Outils.produitRusse(cinq, six, cinq.somme(cinq)));
	}

	public static void main(String[] args) {
		test(new NatCalculantAvecDesInts(new NombreDecimal("0")));
		test(new NatCalculantAvecDesInts(new IntPositif(0)));
		test(new NatCalculantAvecDesInts(new ZeroInductif()));
		test(new NatCalculantAvecDesInts(new SuccInductif(new ZeroInductif())));
		
		test(new NatCalculantAvecDesNombresDecimaux(new NombreDecimal("0")));
		test(new NatCalculantAvecDesNombresDecimaux(new IntPositif(0)));
		test(new NatCalculantAvecDesNombresDecimaux(new ZeroInductif()));
		test(new NatCalculantAvecDesNombresDecimaux(new SuccInductif(new ZeroInductif())));

		test(new NatCalculantRecursivement(new NombreDecimal("0")));
		test(new NatCalculantRecursivement(new IntPositif(0)));
		test(new NatCalculantRecursivement(new ZeroInductif()));
		test(new NatCalculantRecursivement(new SuccInductif(new ZeroInductif())));
	}
}
