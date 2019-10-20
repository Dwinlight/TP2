package session2.td.heritageMultiple;

import session1.td.Nat;

public class SuccDecimal extends EtatSucc implements AlgebreNatDecimal {
	public SuccDecimal(Nat predecesseur) {
		super(predecesseur);
	}

	@Override
	public Nat creerZero() {
		return new ZeroDecimal();
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
