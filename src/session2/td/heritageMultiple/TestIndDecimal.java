package session2.td.heritageMultiple;

import session1.td.FabriqueNaturels;
import session1.td.Nat;

public class TestIndDecimal {

	public static void main(String[] args) {
		test(new ZeroDecimal());
		test(new SuccDecimal(new ZeroDecimal()));
	}

	private static void test(FabriqueNaturels<Nat> fab) {
	
		System.out.println("************************************************");
		System.out.println(fab.getClass());
		System.out.println("************************************************");
		Nat x = fab.creerNatAvecRepresentation("1999");
		System.out.println("1999 ? " + x);
		System.out.println("4 ? " + x.taille());
		
	}

}
