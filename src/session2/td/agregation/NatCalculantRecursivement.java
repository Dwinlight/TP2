package session2.td.agregation;

public class NatCalculantRecursivement extends NatDeleguantEtat implements Nat {

	public NatCalculantRecursivement(EtatNaturelPur etat) {
		super(etat);
	}

	@Override
	public Nat creerNatAvecEtat(EtatNaturelPur etat) {
		return new NatCalculantRecursivement(etat);
	}

	public Nat zero() {
		return this.creerZero();
	}

	public Nat somme(Nat x) {
		if (this.estNul())
			return x;
		return this.creerSuccesseur(this.predecesseur().somme(x));
	}

	public Nat un() {
		return this.creerSuccesseur(this.creerZero());
	}

	public Nat produit(Nat x) {
		if (this.estNul())
			return this.zero();
		return x.somme(this.predecesseur().produit(x));
	}

	@Override
	public Nat modulo(Nat x) {
		if (this.estNul())
			return this.zero();
		Nat r = this.predecesseur().modulo(x);
		return this.creerSuccesseur(r).equals(x) ? this.creerZero() : this.creerSuccesseur(r);
	}

	@Override
	public Nat div(Nat x) {
		if (this.estNul())
			return this.zero();
		Nat r = this.predecesseur().modulo(x);
		Nat q = this.predecesseur().div(x);
		return this.creerSuccesseur(r).equals(x) ? this.creerSuccesseur(q) : q;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Nat))
			return false;
		Nat x = (Nat) obj;
		if (this.estNul())
			return x.estNul();
		if (x.estNul())
			return false;
		return this.predecesseur().equals(x.predecesseur());
	}

	public String toString() {
		if (this.estNul())
			return "0";
		return "S^" + this.val() + "(0)";
	}

}
