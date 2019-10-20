package session2.td.heritageMultiple;

import session1.td.Nat;

public class NatParIntDecimal extends IntPositif implements AlgebreNatDecimal {

	public NatParIntDecimal(int val) {
		super(val);
	}

	@Override
	public Nat creerNatAvecValeur(int val) {
		return new NatParIntDecimal(val);
	}

	@Override 
	public String toString() {
		return this.representer();
	}
	@Override
	public boolean equals(Object obj) {
		return this.estEgal(obj);
	}
}
