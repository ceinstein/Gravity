class Space{
	
	private int rows;
	private int cols;
	private Player players[];
	private Planet planets[];
	private int pixels[][];

	public Space(int _rows, int _cols, int _numPlayers, int _numPlanets){
		this.rows = _rows;
		this.cols = _cols;
		this.pixels = new int[this.rows][this.cols];
		this.players = new Player[_numPlayers];
		for(int i = 0; i < this.players.length; i++){
			this.players[i] = new Player(0, 0);
		}
		this.planets = new Planet[_numPlanets];
		for(int i = 0; i < this.planets.length; i++){
			this.planets[i] = new Planet(this.rows/2, this.cols/2, 10);
		}
	}

	public void display(){
		for(int i = 0; i < this.rows; i++){
			for(int j = 0; j < this.cols; j++){
				Vec2D ppos = this.players[0].getPlayerPosition();
				Vec2D plan_pos = this.planets[0].getPlanetPosition();
				if(i == (int)ppos.y && j == (int)ppos.x){
					System.out.print("[" + this.players[0].getPlayerChar() + "]");
				}else if(i == (int)plan_pos.y && j == (int)plan_pos.x){
					System.out.print("[" + this.planets[0].getPlanetChar() + "]");
				}else{
					System.out.print("[ ]");
				}
				
			} 
			System.out.println();


		}
		
	}

	public void updatePlayerInfo(int _playerNum, char _keyPressed){
		Vec2D velocityUpdate = new Vec2D();
		float speed = 0.2f;
		switch (_keyPressed){
			case('w'):
				velocityUpdate = new Vec2D(0, speed);
				System.out.println("up!");
				break;
			case('s'):
				velocityUpdate = new Vec2D(0, -speed);
				System.out.println("down!");
				break;
			case('a'):
				velocityUpdate = new Vec2D(speed, 0);
				System.out.println("left!");
				break;
			case('d'):
				velocityUpdate = new Vec2D(-speed, 0);
				System.out.println("right!");
				break;
			case('\0'):
				velocityUpdate = new Vec2D(0, 0);
				//System.out.println("nothing!");
				break;
		}
		this.players[_playerNum].updatePlayerVelocity(this.players[_playerNum].getPlayerVelocity().add(velocityUpdate));
		this.players[_playerNum].updatePlayerPosition(this.players[_playerNum].getPlayerPosition().add(this.players[_playerNum].getPlayerVelocity()));
		this.gravityInfluence(_playerNum);
		this.players[_playerNum].updatePlayerPosition(this.players[_playerNum].getPlayerPosition().add(this.players[_playerNum].getGInfluence()));

	}

	private void gravityInfluence(int _playerNum){
		this.players[_playerNum].updateGInfluence(new Vec2D());
		for(int i = 0; i < this.planets.length; i++){
			float grav_const = -8;
			float distance = this.players[_playerNum].getPlayerPosition().distance(this.planets[i].getPlanetPosition());
			float x = grav_const * (this.players[_playerNum].getPlayerMass() * this.planets[i].getPlanetMass());
			x /= (distance * distance * distance);
			x *= (this.players[_playerNum].getPlayerPosition().x - this.planets[i].getPlanetPosition().x);

			float y = grav_const * (this.players[_playerNum].getPlayerMass() * this.planets[i].getPlanetMass());
			y /= (distance * distance * distance);
			y *= (this.players[_playerNum].getPlayerPosition().y - this.planets[i].getPlanetPosition().y);

			System.out.println(x + " " + y);

			Vec2D g_inf = new Vec2D(x, y);

			this.players[_playerNum].updateGInfluence(this.players[_playerNum].getGInfluence().add(g_inf));
			
		}
	}


}