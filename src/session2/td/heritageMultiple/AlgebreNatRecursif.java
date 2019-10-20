package session2.td.heritageMultiple;

import session1.td.Nat;

public interface AlgebreNatRecursif extends AlgebreNatRecursifZero, AlgebreNatRecursifSuccesseur {

	@Override
	default public Nat somme(Nat x) {
		if(this.estNul())
			return AlgebreNatRecursifZero.super.somme(x);
		return AlgebreNatRecursifSuccesseur.super.somme(x);
	}

	@Override
	default public Nat zero() {
		return AlgebreNatRecursifZero.super.zero();
	}

	@Override
	default public Nat produit(Nat x) {
		if(this.estNul())
			return AlgebreNatRecursifZero.super.produit(x);
		return AlgebreNatRecursifSuccesseur.super.produit(x);
	}

	@Override
	default public Nat un() {
		return AlgebreNatRecursifZero.super.un();
	}
	
	@Override
	default Nat modulo(Nat x) {
		if(this.estNul())
			return AlgebreNatRecursifZero.super.modulo(x);
		return AlgebreNatRecursifSuccesseur.super.modulo(x);
	}

	@Override
	default Nat div(Nat x) {
		if(this.estNul())
			return AlgebreNatRecursifZero.super.div(x);
		return AlgebreNatRecursifSuccesseur.super.div(x);
	}
	
	@Override
	default public boolean estEgal(Object obj) {
		if(this.estNul())
			return AlgebreNatRecursifZero.super.estEgal(obj);
		return AlgebreNatRecursifSuccesseur.super.estEgal(obj);
	}

	@Override
	default public String representer() {
		if(this.estNul())
			return AlgebreNatRecursifZero.super.representer();
		return AlgebreNatRecursifSuccesseur.super.representer();
	}

}
