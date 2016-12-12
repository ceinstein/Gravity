class Vec2D{
	
	public float x;
	public float y;

	public Vec2D(){
		this.x = 0;
		this.y = 0;
	}

	public Vec2D(float _x, float _y){
		this.x = _x;
		this.y = _y;
	}

	public Vec2D add(Vec2D _vec2){
		Vec2D ret = new Vec2D();
		ret.x = this.x + _vec2.x;
		ret.y = this.y + _vec2.y;
		return ret;
	}

	public Vec2D average(Vec2D _vec2){
		Vec2D ret = new Vec2D();
		ret.x = (this.x + _vec2.x)/2;
		ret.y = (this.x + _vec2.x)/2;
		return ret;
	}

	public float distance(Vec2D _vec2){
		float x_dist = (this.x - _vec2.x);
		float y_dist = (this.y - _vec2.y);
		return (float)Math.sqrt((x_dist * x_dist) + (y_dist * y_dist));
	}


}