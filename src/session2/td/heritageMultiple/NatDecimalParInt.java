package session2.td.heritageMultiple;

import session1.td.Nat;

public class NatDecimalParInt extends NombreDecimal implements AlgebreNatParInt {

	public NatDecimalParInt(String rep) {
		super(rep);
	}

	@Override
	public Nat creerNatAvecRepresentation(String rep) {
		return new NatDecimalParInt(rep);
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
