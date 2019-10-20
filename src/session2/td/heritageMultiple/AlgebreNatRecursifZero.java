package session2.td.heritageMultiple;

import session1.td.Nat;

public interface AlgebreNatRecursifZero extends Nat {

	@Override
	default Nat zero() {
		return this.creerZero();
	}

	@Override
	default Nat somme(Nat x) {
		return x;
	}

	@Override
	default Nat un() {
		return this.creerSuccesseur(this.creerZero());
	}

	@Override
	default Nat produit(Nat x) {
		return this.creerZero();
	}

	@Override
	default Nat modulo(Nat x) {
		return this.creerZero();
	}

	@Override
	default Nat div(Nat x) {
		return this.creerZero();
	}

	default public boolean estEgal(Object obj) {
		if (!(obj instanceof Nat))
			return false;
		Nat x = (Nat) obj;
		return x.estNul();
	}

	default public String representer() {
		return "0";
	}

}
