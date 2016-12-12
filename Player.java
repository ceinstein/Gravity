class Player{
	
	private char p_char = '*';
	private Vec2D position;
	private Vec2D velocity;
	private Vec2D g_influence;
	private int health;
	private int mass;


	public Player(int _x, int _y){
		this.position = new Vec2D(_x, _y);
		this.velocity = new Vec2D();
		this.health = 100;
		this.mass = 1;
	}

	public Vec2D getPlayerPosition(){
		return this.position;
	}

	public void updatePlayerPosition(Vec2D _position){
		this.position = _position;
	}

	public Vec2D getPlayerVelocity(){
		return this.velocity;
	}

	public void updatePlayerVelocity(Vec2D _velocity){
		this.velocity = _velocity;
	}

	public int getPlayerHealth(){
		return this.health;
	}

	public void updatePlayerHealth(int _health){
		this.health = _health;
	}

	public char getPlayerChar(){
		return this.p_char;
	}

	public int getPlayerMass(){
		return this.mass;
	}

	public Vec2D getGInfluence(){
		return this.g_influence;
	}

	public void updateGInfluence(Vec2D _g_influence){
		this.g_influence = _g_influence;
	}


}