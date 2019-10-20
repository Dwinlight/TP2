package session2.td.heritageMultiple;

import session1.td.Nat;

public class ZeroRecursif extends EtatZero implements AlgebreNatRecursifZero {

	@Override
	public Nat creerZero() {
		return this;
	}

	@Override
	public Nat creerSuccesseur(Nat predecesseur) {
		return new SuccRecursif(predecesseur);
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
