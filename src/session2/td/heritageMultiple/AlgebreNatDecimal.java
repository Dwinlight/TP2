package session2.td.heritageMultiple;

import session1.td.Nat;

public interface AlgebreNatDecimal extends Nat {


	@Override
	default Nat somme(Nat x) {
		int t = this.taille() < x.taille() ? x.taille() : this.taille();
		StringBuilder rep = new StringBuilder();
		int retenue = 0;
		for (int i = 0; i < t; i++) {
			int chiffre = this.chiffre(i) + x.chiffre(i) + retenue;
			if (chiffre > 9) {
				chiffre = chiffre - 10;
				retenue = 1;
			} else {
				retenue = 0;
			}
			rep.append(Integer.toString(chiffre));
		}
		rep = retenue == 0 ? rep : rep.append(1);
		return this.creerNatAvecRepresentation(rep.reverse().toString());
	}

	@Override
	default Nat zero() {
		return this.creerZero();
	}

	@Override
	default Nat produit(Nat x) {
		Nat dix = this.creerNatAvecRepresentation("10");
		if (x.equals(dix)) {
			return this.creerNatAvecRepresentation(this.toString() + "0");
		}
		Nat res = zero();
		Nat index = zero();
		while (!index.equals(x)) {
			res = res.somme(this);
			index = this.creerSuccesseur(index);
		}
		return res;
	}

	@Override
	default Nat un() {
		return this.creerNatAvecRepresentation("1");
	}

	@Override
	default Nat modulo(Nat x) {
		Nat dix = this.creerNatAvecRepresentation("10");
		if (x.equals(dix)) {
			return this.creerNatAvecValeur(this.chiffre(0));
		}
		Nat courant = zero();
		Nat q = zero();
		Nat r = zero();
		while (!courant.equals(this)) {
			r = this.creerSuccesseur(r);
			if (r.equals(x)) {
				r = zero();
				q = this.creerSuccesseur(q);
			}
			courant = this.creerSuccesseur(courant);
		}
		return r;
	}

	@Override
	default Nat div(Nat x) {
		Nat dix = this.creerNatAvecRepresentation("10");
		if (x.equals(dix)) {
			if (this.taille() == 1)
				return this.zero();
			return this.creerNatAvecRepresentation(this.toString().substring(0, this.taille() - 1));
		}
		Nat courant = zero();
		Nat q = zero();
		Nat r = zero();
		while (!courant.equals(this)) {
			r = this.creerSuccesseur(r);
			if (r.equals(x)) {
				r = zero();
				q = this.creerSuccesseur(q);
			}
			courant = this.creerSuccesseur(courant);
		}
		return q;
	}

	default boolean estEgal(Object x) {
		if (!(x instanceof Nat))
			return false;
		Nat n = (Nat) x;
		return this.toString().equals(n.toString());
	}

	default String representer() {
		StringBuilder rep = new StringBuilder();
		for(int i = this.taille(); i > 0; i--){
			rep.append(this.chiffre(i-1));
		}
		return rep.toString();
	}

}
