package com.jemge.resource;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class AudioResource implements IResource {
	private final String name;
	private final Sound sound;

	public AudioResource(String name) {
		this.name = name;
		this.sound = Gdx.audio.newSound(Gdx.files.internal(name));
	}

	@Override
	public ResourceType getType() {
		return ResourceType.SOUND;
	}

	@Override
	public String getName() {
		return this.name;
	}

	public Sound getSound() {
		return this.sound;
	}
}
