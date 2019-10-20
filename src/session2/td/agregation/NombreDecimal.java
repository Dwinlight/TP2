package session2.td.agregation;

public class NombreDecimal implements EtatNaturelPur {
	
	private String chiffres; // au moins un chiffre - aucun 0 superflu en tête
	
	public NombreDecimal(String rep) {
		this.chiffres = rep;
	}
	
	@Override
    public int chiffre(int i){
    	if(i < this.taille())
    		return Character.getNumericValue(chiffres.charAt(chiffres.length() -1 -i));
    	return 0;
    }
	@Override
    public int taille(){
    	return chiffres.length();
    }
	@Override
	public int val() {
		return Integer.parseInt(this.chiffres);
	}
	
	@Override
	public boolean estNul() {
		// Peut être simplifié du fait du nettoyage ("0" pour zéro)
		for(int i = 0; i < this.taille(); i++){
			if(this.chiffre(i) != 0){
				return false;
			}
		}
		return true;
	}

	@Override
	public EtatNaturelPur predecesseur() {
		if(this.estNul()){
			throw new UnsupportedOperationException();
		}
		int t = this.taille();
		StringBuilder rep = new StringBuilder();
		int retenue = -1;
		for(int i = 0; i < t; i++){
			int chiffre = this.chiffre(i) + retenue;
			if(chiffre == -1){
				chiffre = 9;
				retenue = -1;
			}else{
				retenue = 0;
			}
			rep.append(Integer.toString(chiffre));
		}
		return this.creerNatAvecRepresentation(rep.reverse().toString());
	}
	
	@Override 
	public EtatNaturelPur creerNatAvecRepresentation(String repDecimale){
		return new NombreDecimal(repDecimale);
	}
	
}
