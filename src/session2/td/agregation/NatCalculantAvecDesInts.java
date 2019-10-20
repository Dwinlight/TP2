package session2.td.agregation;

public class NatCalculantAvecDesInts extends NatDeleguantEtat implements Nat {
	
	
	public NatCalculantAvecDesInts(EtatNaturelPur etat) {
		super(etat);
	}

	@Override
	public Nat creerNatAvecEtat(EtatNaturelPur etat) {
		return new NatCalculantAvecDesInts(etat);
	}

	public Nat zero() {
		return this.creerNatAvecValeur(0);
	}

	public Nat somme(Nat x) {
		return this.creerNatAvecValeur(this.val() + x.val());
	}

	public Nat un() {
		return this.creerNatAvecValeur(1);
	}

	public Nat produit(Nat x) {
		return this.creerNatAvecValeur(this.val() * x.val());
	}

	@Override
	public Nat modulo(Nat x) {
		return this.creerNatAvecValeur(this.val() % x.val());
	}

	@Override
	public Nat div(Nat x) {
		return this.creerNatAvecValeur(this.val() / x.val());
	}

	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Nat))
			return false;
		Nat x = (Nat)obj;
		return this.val() == x.val();
	}

	@Override
	public String toString() {
		return Integer.toString(this.val());
	}


}
