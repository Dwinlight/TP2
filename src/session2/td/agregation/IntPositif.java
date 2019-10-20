package session2.td.agregation;

import session2.td.heritageDescendant.NatParInt;

public class IntPositif implements EtatNaturelPur {

	private int val;

	public IntPositif(int val) {
		if(val < 0)
			throw new IllegalArgumentException("Pas de naturel à patir d'un int négatif.");
		this.val = val;
	}
	@Override
	public int val() {
		return this.val;
	}
	@Override
	public boolean estNul() {
		return this.val() == 0;
	}
	@Override
	public EtatNaturelPur predecesseur() {
		if(estNul())
			throw new UnsupportedOperationException("Pas de prédécesseur.");
		return new IntPositif(val - 1);
	}
	@Override
	public int chiffre(int i) {
		return (i == 0) ? this.val()%10 : (new NatParInt(this.val()/10)).chiffre(i-1);
	}

	@Override
	public int taille() {
		return (this.val() < 10) ? 1 : 1 + (new NatParInt(this.val() / 10)).taille();
	}
	@Override
	public EtatNaturelPur creerNatAvecValeur(int val) {
		return new IntPositif(val);
	}
	@Override
	public String toString() {
		return Integer.toString(this.val());
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof EtatNaturelPur))
			return false;
		EtatNaturelPur x = (EtatNaturelPur)obj;
		return this.val() == x.val();
	}


}
