package session2.td.heritageMultiple;

import session1.td.Nat;

public class NatParIntRecursif extends IntPositif implements AlgebreNatRecursif {

	public NatParIntRecursif(int val) {
		super(val);
	}

	@Override
	public Nat creerNatAvecValeur(int val) {
		return new NatParIntRecursif(val);
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
