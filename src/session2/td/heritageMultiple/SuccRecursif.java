package session2.td.heritageMultiple;

import session1.td.Nat;

public class SuccRecursif extends EtatSucc implements AlgebreNatRecursifSuccesseur {
	public SuccRecursif(Nat predecesseur) {
		super(predecesseur);
	}

	@Override
	public Nat creerZero() {
		return new ZeroRecursif();
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
