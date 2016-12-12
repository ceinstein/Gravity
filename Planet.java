class Planet{
	
	private char p_char = 'O';
	private Vec2D position;
	private int mass;

	public Planet(int _x, int _y, int _mass){
		this.position = new Vec2D(_x, _y);
		this.mass = _mass;
	}

	public Vec2D getPlanetPosition(){
		return this.position;
	}

	public int getPlanetMass(){
		return this.mass;
	}

	public char getPlanetChar(){
		return this.p_char;
	}


}