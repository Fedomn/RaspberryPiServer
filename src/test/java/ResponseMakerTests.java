import com.fedomn.ResponseMaker;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by fedomn on 2015/5/31.
 */
public class ResponseMakerTests {

    @Test
    public void GIVEN_playFirst_SHOULD_SayOmxPlay() throws Exception {
        assertEquals("Failure - given playFirst should say /home/pi/server/omx_control.sh play",
                "/home/pi/server/omx_control.sh play", ResponseMaker.translate("playFirst"));
    }

    @Test
    public void GIVEN_play_SHOULD_SayOmx() throws Exception {
        assertEquals("Failure - given play should say /home/pi/server/omx_control.sh",
                "/home/pi/server/omx_control.sh", ResponseMaker.translate("play"));
    }
}
