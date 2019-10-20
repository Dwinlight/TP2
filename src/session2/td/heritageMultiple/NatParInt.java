package session2.td.heritageMultiple;

import session1.td.Nat;

public class NatParInt extends IntPositif implements AlgebreNatParInt {

	public NatParInt(int val) {
		super(val);
	}

	@Override
	public Nat creerNatAvecValeur(int val) {
		return new NatParInt(val);
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
