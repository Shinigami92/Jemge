package com.jemge.core.system.predefined;

import com.jemge.core.system.UpdateListener;
import com.jemge.input.InputManager;
import com.jemge.j2d.JSprite;

public class FollowMouse implements UpdateListener<JSprite> {
    @Override
    public void update(JSprite object) {
        object.setPosition(InputManager.getPositionByCam().x - object.getWidth() / 2,
                0);
    }

}
