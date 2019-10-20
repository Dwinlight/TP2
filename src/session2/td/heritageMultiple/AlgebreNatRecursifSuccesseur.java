package session2.td.heritageMultiple;

import session1.td.Nat;

public interface AlgebreNatRecursifSuccesseur extends Nat {

	
	@Override
	default public Nat somme(Nat x) {
		return this.creerSuccesseur(this.predecesseur().somme(x));
	}

	@Override
	default public Nat zero() {
		return this.creerZero();
	}

	@Override
	default public Nat produit(Nat x) {
		return x.somme(this.predecesseur().produit(x));
	}

	@Override
	default public Nat un() {
		return this.creerSuccesseur(this.creerZero());
	}
	
	@Override
	default Nat modulo(Nat x) {
		Nat r = this.predecesseur().modulo(x);
		return this.creerSuccesseur(r).equals(x) ? this.creerZero() : this.creerSuccesseur(r);
	}

	@Override
	default Nat div(Nat x) {
		Nat r = this.predecesseur().modulo(x);
		Nat q = this.predecesseur().div(x);
		return this.creerSuccesseur(r).equals(x) ? this.creerSuccesseur(q) : q;
	}
	
	default public boolean estEgal(Object obj) {
		if(!(obj instanceof Nat))
			return false;
		Nat x = (Nat)obj;
		if(x.estNul())
			return false;
		return this.predecesseur().equals(x.predecesseur());
	}

	default public String representer() {
		return "S^" + this.val() + "(0)";
	}

}
