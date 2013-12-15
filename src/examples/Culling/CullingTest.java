package examples.Culling;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.Texture;
import com.jemge.core.JAppLWJGL;
import com.jemge.core.JConfig;
import com.jemge.core.JGame;
import com.jemge.core.Jemge;
import com.jemge.j2d.JSprite;
import com.jemge.j2d.Renderer2D;
import com.jemge.resource.TextureResource;


public class CullingTest extends JGame {
    private FPSLogger logger;

    /**
     * Called when the {@link JGame} is first created.
     */

    @Override
    public void create() {
        super.create(); //important call, don't forget it!

        Jemge.manager.addResource("tile", new TextureResource("erdeundgras.jpg"));

        logger = new FPSLogger();

        for(int x = 0; x < 500; x++){
            for(int y = 0; y < 500; y++){
                Renderer2D.getRenderer2D().add(new JSprite(Jemge.manager.getTexture("tile"),x * 64, y * 64, 64, 64).setStatic(true));

            }
        }

    }


    @Override
    public void render() {
        super.render();  //never forget to call "super.render"!

        getCamera().position.add(5f, 0f, 0);

        logger.log();
    }

    public static void main(String[] args){
        JConfig config = new JConfig();
        config.setGL(JConfig.Version.GL_20);
        config.vSyncEnabled = true;

        new JAppLWJGL(new CullingTest(), config);   //finally create the lwjgl application.
    }
}
