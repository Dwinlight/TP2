package session2.td.heritageMultiple;

import session1.td.Nat;

public class NatDecimal extends NombreDecimal implements AlgebreNatDecimal {

	public NatDecimal(String rep) {
		super(rep);
	}

	@Override
	public Nat creerNatAvecRepresentation(String rep) {
		return new NatDecimal(rep);
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
