package session2.td.heritageMultiple;

import session1.td.Nat;

public class ZeroDecimal extends EtatZero implements AlgebreNatDecimal {

	@Override
	public Nat creerZero() {
		return this;
	}

	@Override
	public Nat creerSuccesseur(Nat predecesseur) {
		return new SuccDecimal(predecesseur);
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
