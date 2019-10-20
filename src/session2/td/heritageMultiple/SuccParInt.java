package session2.td.heritageMultiple;

import session1.td.Nat;

public class SuccParInt extends EtatSucc implements AlgebreNatParInt {
	public SuccParInt(Nat predecesseur) {
		super(predecesseur);
	}

	@Override
	public Nat creerZero() {
		return new ZeroParInt();
	}

	@Override
	public Nat creerSuccesseur(Nat predecesseur) {
		return new SuccParInt(predecesseur);
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
