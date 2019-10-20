package session2.td.heritageMultiple;

import session1.td.Nat;

public class NatDecimalRecursif extends NombreDecimal implements AlgebreNatRecursif {

	public NatDecimalRecursif(String rep) {
		super(rep);
	}

	@Override
	public Nat creerNatAvecRepresentation(String rep) {
		return new NatDecimalRecursif(rep);
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
