import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import states.GameStateManager
import states.MenuGame
import states.Pause

/** [com.badlogic.gdx.ApplicationListener] implementation shared by all platforms. */
class Jpong : ApplicationAdapter() {
    private var gsm: GameStateManager? = null
    private var batch: SpriteBatch? = null

    override fun create() {
        batch = SpriteBatch()
        gsm = GameStateManager()
        gsm?.push(MenuGame(gsm))
    }

    override fun render() {
        gsm?.update()
        gsm?.render(batch!!)
    }

    override fun dispose() {
        gsm?.clean()
        batch!!.dispose()
    }

    override fun pause() {
        gsm?.push(Pause(gsm))
    }

}
