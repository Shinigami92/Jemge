/*
 * Copyright [2014] @author file
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.jemge.box2d;

import java.io.Serializable;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class PolygonObject extends PhysicObject implements Serializable {
	private float height;
	private float width;

	public PolygonObject(float x, float y, float width, float height,
			BodyDef.BodyType type) {
		this.height = height;
		this.width = width;

		BODYDEF.type = type;
		BODYDEF.position.set(x, y).add(this.width / 2, this.height / 2);

		this.body = Physics2D.getMainWorld().createBody(BODYDEF);

		PolygonShape polygonShape = new PolygonShape();
		polygonShape.setAsBox(width / 2, height / 2);

		this.fixture = this.body.createFixture(this
				.setupFixtureDef(polygonShape));

		polygonShape.dispose();
	}

	public PolygonObject(float x, float y, float width, float height,
			Filter filter, BodyDef.BodyType type) {
		this.height = height;
		this.width = width;

		BODYDEF.type = type;
		BODYDEF.position.set(x, y).add(this.width / 2, this.height / 2);

		this.body = Physics2D.getMainWorld().createBody(BODYDEF);

		PolygonShape polygonShape = new PolygonShape();
		polygonShape.setAsBox(width / 2, height / 2);

		this.fixture = this.body.createFixture(this.setupFixtureDef(
				polygonShape, filter));

		polygonShape.dispose();
	}

	public PolygonObject(float x, float y, float size, FileHandle fileHandle,
			String name, BodyDef.BodyType type) {
		final BoxEditorLoader loader = new BoxEditorLoader(fileHandle);

		BODYDEF.type = type;
		BODYDEF.position.set(x, y);

		Body body = Physics2D.getMainWorld().createBody(BODYDEF);

		loader.attachFixture(body, name,
				this.setupFixtureDef(null, 1.0f, 0.5f, 0.3f), size);
	}

	public PolygonObject(float x, float y, float size, FileHandle fileHandle,
			String name, Filter filter, BodyDef.BodyType type) {
		final BoxEditorLoader loader = new BoxEditorLoader(fileHandle);

		BODYDEF.type = type;
		BODYDEF.position.set(x, y);

		Body body = Physics2D.getMainWorld().createBody(BODYDEF);

		loader.attachFixture(body, name,
				this.setupFixtureDef(null, filter, 1.0f, 0.5f, 0.3f), size);
	}

	public PolygonObject(float x, float y, Texture texture,
			FileHandle fileHandle, String name, BodyDef.BodyType type) {
		final BoxEditorLoader loader = new BoxEditorLoader(fileHandle);

		BODYDEF.type = type;
		BODYDEF.position.set(x, y);

		Body body = Physics2D.getMainWorld().createBody(BODYDEF);

		loader.attachFixture(body, texture, name,
				this.setupFixtureDef(null, 1.0f, 0.5f, 0.3f));
	}

	public PolygonObject(float x, float y, Texture texture,
			FileHandle fileHandle, String name, Filter filter,
			BodyDef.BodyType type) {
		final BoxEditorLoader loader = new BoxEditorLoader(fileHandle);

		BODYDEF.type = type;
		BODYDEF.position.set(x, y);

		Body body = Physics2D.getMainWorld().createBody(BODYDEF);

		loader.attachFixture(body, texture, name,
				this.setupFixtureDef(null, filter, 1.0f, 0.5f, 0.3f));
	}

	public void savePosition() {
		this.position = this.body.getPosition();
		this.position.sub(this.width / 2, this.height / 2);
	}

	public Vector2 getPosition() {
		if (this.body != null) {
			this.position = this.body.getPosition();
			this.position.sub(this.width / 2, this.height / 2);
		}
		return this.position;
	}

	public float getHeight() {
		return this.height;
	}

	public float getWidth() {
		return this.width;
	}
}