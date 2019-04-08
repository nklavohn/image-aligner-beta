package com.labcode.math;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.NumberUtils;

/* All of the methods are defined below and are typical things that vectors can do. 
 * Notice, if a method name begins with 'set', it changes the value of that Vector object, if it does not, it returns the value
 * that it would be set to. For example, a.add(b) returns a + b, but a.setAdd(b) will make a = a + b as well as return the new a;
 */

public class Vector {
	public static final Vector ihat = new Vector(1, 0);
	public static final Vector jhat = new Vector(0, 1);
	public static final Vector zero = new Vector(0, 0);
	
	public float x;  //the x component of the vector
	public float y;  //the y component of the vector
	
	public Vector() {
		
	}
	
	public Vector(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector(Vector v) {
		this.x = v.x;
		this.y = v.y;
	}
	
	/**
	 * @return Vector, a copy of this object with a new memory location
	 */
	public Vector clone() {
		return new Vector(x, y);
	}
	
	/** 
	 * dot product
	 * @param v
	 * @return float, the dot product of the two vectors
	 */
	public float dot(Vector v) {
		return dot(v.x, v.y);
	}
	
	/**
	 * dot product
	 * @param x
	 * @param y
	 * @return float, dot product of the vector with the vector represented by x and y
	 */
	public float dot(float x, float y) {
		return this.x * x + this.y * y;
	}
	
	/**
	 * cross product
	 * @param v
	 * @return float, the cross product of the two vectors
	 */
	public float crs(Vector v) {
		return crs(v.x, v.y);
	}
	
	/**
	 * cross product
	 * @param x
	 * @param y
	 * @return float, the cross product of the vector with the vector represented by x and y
	 */
	public float crs(float x, float y) {
		return this.x * y - this.y * x;
	}
	
	/**
	 * length
	 * @return float, the length of the vector
	 */
	public float len() {
		return (float)Math.sqrt(x * x + y * y);
	}
	
	/**
	 * length
	 * @return float, the square of the length of the vector
	 */
	public float len2() {
		return x * x + y * y;
	}
	
	/**
	 * Gives the result of adding these vectors without changing the original
	 * @param v
	 * @return Vector, the resultant of adding the two vectors
	 */
	public Vector add(Vector v) {
		return add(v.x, v.y);
	}
	
	/**
	 * Gives the result of adding these vectors without changing the original
	 * @param x
	 * @param y
	 * @return Vector, the resultant of adding this vector with the vector represented by x and y
	 */
	public Vector add(float x, float y) {
		return new Vector(this.x + x, this.y + y);
	}
	
	/**
	 * Returns vector as an int array of size two by truncating the floats
	 * @return int array
	 */
	public int[] castToInt() {
		int[] vec = new int[2];
		vec[0] = (int)x;
		vec[1] = (int)y;
		return vec;
	}
	
	/**
	 * Returns vector as an int array of size two by rounding the floats
	 * @return int array
	 */
	public int[] roundToInt() {
		int[] vec = new int[2];
		vec[0] = Math.round(x);
		vec[1] = Math.round(y);
		return vec;
	}
	
	/**
	 * Adds the Vector v to this Vector instance, changing it, and returns the result
	 * @param v
	 * @return Vector, the result of adding these two vectors
	 */
	public Vector setAdd(Vector v) {
		return setAdd(v.x, v.y);
	}
	
	/**
	 * Adds parameters x and y to this vector, changing it returns the result
	 * @param x
	 * @param y
	 * @return Vector, the result of the subtraction
	 */
	public Vector setAdd(float x, float y) {
		this.x += x;
		this.y += y;
		return this;
	}
	
	/**
	 * Gives the result of subtracting v from this vector without changing the original
	 * @param v
	 * @return Vector, the result of the subtraction
	 */
	public Vector sub(Vector v) {
		return new Vector(this.x - v.x, this.y - v.y);
	}
	
	/**
	 * Gives the result of subtracting the vector represented by x and y from this Vector without changing the original
	 * @param x
	 * @param y
	 * @return Vector, the result of the subtraction
	 */
	public Vector sub(float x, float y) {
		return new Vector(this.x - x, this.y - y);
	}
	
	/**
	 * Adds the vector v to this instance, changing it, then returns the result
	 * @param v
	 * @return Vector, the result of the subtraction
	 */
	public Vector setSub(Vector v) {
		return setSub(v.x, v.y);
	}
	
	/**
	 * Adds the vector represented by x and y to this instance, changing it, then returns the result
	 * @param x
	 * @param y
	 * @return
	 */
	public Vector setSub(float x, float y) {
		this.x -= x; 
		this.y -= y;
		return this;
	}
	
	/**
	 * Gives the result of scaling the vector iwhtout changing this instance
	 * @param scalar
	 * @return Vector, scaled by the parameter
	 */
	public Vector scl(float scalar) {
		return new Vector(this.x * scalar, this.y * scalar);
	}
	
	/**
	 * Scales the vector by the parameter, changing it, and returns the result
	 * @param scalar
	 * @return Vector, scaled by the parameter
	 */
	public Vector setScl(float scalar) {
		x *= scalar;
		y *= scalar;
		return this;
	}
	
	/**
	 * sets the vector components
	 * @param x
	 * @param y
	 */
	public void set(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * set the vector to have the same dimensions as vector v
	 * @param v
	 */
	public void set(Vector v) {
		this.x = v.x;
		this.y = v.y;
	}
	
	/**
	 * Scales the vector to give it a length of 1, retaining the direction
	 */
	public void unitize() {
		float length = len();
		if(length != 0) {
			x /= length;
			y /= length;
		}
	}
	
	/**
	 * distance
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return float, the distance between the two points
	 */
	public static float dst(float x1, float y1, float x2, float y2) {
		final float x_d = x2 - x1;
		final float y_d = y2 - y1;
		return (float)Math.sqrt(x_d * x_d + y_d * y_d);
	}

	/**
	 * distance
	 * @param v
	 * @return float, the distance between the vectors
	 */
	public float dst(Vector v) {
		final float x_d = v.x - x;
		final float y_d = v.y - y;
		return (float)Math.sqrt(x_d * x_d + y_d * y_d);
	}

	/**
	 * distance
	 * @param x
	 * @param y
	 * @return float, the distance between the vectors
	 */
	public float dst(float x, float y) {
		final float x_d = x - this.x;
		final float y_d = y - this.y;
		return (float)Math.sqrt(x_d * x_d + y_d * y_d);
	}

	/**
	 * distance squared
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return float, the square of the distance between the two points
	 */
	public static float dst2(float x1, float y1, float x2, float y2) {
		final float x_d = x2 - x1;
		final float y_d = y2 - y1;
		return x_d * x_d + y_d * y_d;
	}

	/**
	 * distance squared
	 * @param v
	 * @return float, the square of the distance between the two points
	 */
	public float dst2(Vector v) {
		final float x_d = v.x - x;
		final float y_d = v.y - y;
		return x_d * x_d + y_d * y_d;
	}

	/**
	 * distance squared
	 * @param x
	 * @param y
	 * @return float, the square of the distance between the two points
	 */
	public float dst2(float x, float y) {
		final float x_d = x - this.x;
		final float y_d = y - this.y;
		return x_d * x_d + y_d * y_d;
	}
	
	/**
	 * limits the length of the vector. if the lenght is smaller, it remains unchanged. otherwise it is resized
	 * @param limit
	 */
	public void limit(float limit) {
		limit2(limit * limit);
	}
	
	/**
	 * limits the square of the length of the vector. if the length is smaller, it remains unchanged. otherwise it is resized
	 * @param limit2
	 */
	public void limit2(float limit2) {
		float len2 = len2();
		if (len2 > limit2) {
			setScl((float)Math.sqrt(limit2 / len2));
		}
	}
	
	/**
	 * @return String, in form (x,y)
	 */
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	/**
	 * Gives the result of rotating the vector without changing the original
	 * @param degrees
	 * @return Vector, the result of the rotation
	 */
	public Vector rotate(float degrees) {
		return rotateRad((float)(degrees * Math.toRadians(degrees)));
	}
	
	/**
	 * Rotates the vector by the given amount, changing it, then returns the result
	 * @param degrees
	 * @return Vector, the result of the rotation
	 */
	public Vector setRotate(float degrees) {
		this.set(rotateRad(degrees * MathUtils.degreesToRadians));
		return this;
	}
	
	/**
	 * Gives the result of rotating the vector without rotating the original
	 * @param radians
	 * @return Vector, the result of the rotation
	 */
	public Vector rotateRad(float radians) {
		float cos = (float)Math.cos(radians);
		float sin = (float)Math.sin(radians);

		float newX = this.x * cos - this.y * sin;
		float newY = this.x * sin + this.y * cos;

		return new Vector(newX, newY);
	}
	
	/**
	 * Rotates the vector by the given amount, changing it, then returns the result
	 * @param radians
	 * @return Vector, the reuslt of the rotation
	 */
	public Vector setRotateRad(float radians) {
		float cos = (float)Math.cos(radians);
		float sin = (float)Math.sin(radians);

		float newX = this.x * cos - this.y * sin;
		float newY = this.x * sin + this.y * cos;

		this.x = newX;
		this.y = newY;
		return this;
	}
	
	/**
	 * Returns the vector rotated by exactly 90 degrees. If dir is >= 0, the vector is rotating counterclockwise and dir < 0 rotating clockwise.
	 * @param dir
	 * @return Vector, the result of the rotation
	 */
	public Vector rotate90(float dir) {
		float x = this.x;
		if (dir >= 0) {
			return new Vector(-y, x);
		} else {
			return new Vector(y, -x);
		}
	}
	
	/**
	 * Rotates the vector by 90 degrees, changing it, and then returns the result
	 * @param dir
	 * @return Vector, the result of the rotation
	 */
	public Vector setRotate90(int dir) {
		float x = this.x;
		if (dir >= 0) {
			this.x = -y;
			y = x;
		} else {
			this.x = y;
			y = -x;
		}
		return this;
	}
	
	/**
	 * equals
	 * @param obj the object being compared to
	 * @return boolean, true if they are equal
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Vector other = (Vector)obj;
		if (NumberUtils.floatToIntBits(x) != NumberUtils.floatToIntBits(other.x)) return false;
		if (NumberUtils.floatToIntBits(y) != NumberUtils.floatToIntBits(other.y)) return false;
		return true;
	}
	
	/**
	 * @return boolean, true if the vector has length 1
	 */
	public boolean isUnit() {
		return isUnit(0.0000001f);
	}

	/**
	 * tests if the vector is a unit vector, with the given margin of error
	 * @param margin
	 * @return boolean, true if it is a unit vector
	 */
	public boolean isUnit(final float margin) {
		return Math.abs(len2() - 1f) < margin;
	}
	
	
	/**
	 * @return boolean, true if the vector has length zero
	 */
	public boolean isZero() {
		return x == 0 && y == 0;
	}

	/**
	 * tests if the vector has length zero, with the given margin of error
	 * @param margin
	 * @return
	 */
	public boolean isZero(final float margin) {
		return len2() < margin;
	}
	
	/**
	 * sets the direction of the vector to the given angle (measured counterclockwise from the horizontal)
	 * @param radians
	 */
	public void setAngleRad(float radians) {
		this.set(len(), 0f);
		this.rotateRad(radians);
	}
	
	/**
	 * @return float, the angle in radians that the vector makes with the horizontal
	 */
	public float angleRad() {
		return (float)Math.atan2(y, x);
	}
	
	/**
	 * scales the vector to have the square length that is passed in, does not change it tho
	 * @param len2
	 * @return Vector, the result of the resizing
	 */
	public Vector resize(float len2) {
		float oldLen2 = len2();
		return (oldLen2 == 0 || oldLen2 == len2) ? this : scl((float)Math.sqrt(len2 / oldLen2));
	}
	
	/**
	 * divides the vectors component wise and returns the product, without changing this object
	 * @param v
	 * @return
	 */
	public Vector div(Vector v) {
		return new Vector(this.x/v.x, this.y/v.y);
	}
	
	/**
	 * returns the projection of this vector onto the one passed in
	 * @param v
	 * @return
	 */
	public Vector projOnto(Vector v) {
		return v.scl(this.dot(v)/v.dot(v));
	}
	
	/**
	 * divides the vectors component wise, changing the original
	 * @param v
	 */
	public void setDiv(Vector v) {
		this.x = this.x/v.x;
		this.y = this.y/v.y;
	}
	
	/**
	 * @return converts to a {@link Vector2} object
	 */
	public Vector2 toVector2() {
		return new Vector2(x, y);
	}
	
	/**
	 * finds the intersection of the two line segments, if there is one
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param x3
	 * @param y3
	 * @param x4
	 * @param y4
	 * @return Vector, represent the point of intersection, or null if there is no intersection
	 */
	public static Vector lineIntersect(float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4) {
		float denom = (y4 - y3) * (x2 - x1) - (x4 - x3) * (y2 - y1);
		if (denom == 0.0f) { // Lines are parallel.
		   return null;
		}
		float ua = ((x4 - x3) * (y1 - y3) - (y4 - y3) * (x1 - x3))/denom;
		float ub = ((x2 - x1) * (y1 - y3) - (y2 - y1) * (x1 - x3))/denom;
		  if (ua >= 0.0f && ua <= 1.0f && ub >= 0.0f && ub <= 1.0f) {
		      // Get the intersection point.
		      return new Vector((x1 + ua*(x2 - x1)), (y1 + ua*(y2 - y1)));
		  }
		return null;
	}
	
	/**
	 * finds the intersection of the two line segments, if there is on
	 * @param v1
	 * @param v2
	 * @param v3
	 * @param v4
	 * @return Vector, representing the point of intersection, or null if there is no intersection
	 */
	public static Vector lineIntersect(Vector v1, Vector v2, Vector v3, Vector v4) {
		return lineIntersect(v1.x, v1.y, v2.x, v2.y, v3.x, v3.y, v4.x, v4.y);
	}
	
	/**
	 * DEGREES finds the angle between the two vectors
	 * @param v1
	 * @param v2
	 * @return a float representing the angle between the two vectors in degrees
	 */
	public static float angleBetween(Vector v1, Vector v2) {
		return (float) Math.toDegrees(Math.acos((double)(v1.dot(v2) / (v1.len() * v2.len()))));
	}
	
	/**
	 * RADIANS finds the angle between the two vectors radians
	 * @param v1
	 * @param v2
	 * @return a float representing the angle between the two vectors in radians
	 */
	public static float angleBetweenRad(Vector v1, Vector v2) {
		return (float) Math.acos((double)(v1.dot(v2) / (v1.len() * v2.len())));
	}
 }
