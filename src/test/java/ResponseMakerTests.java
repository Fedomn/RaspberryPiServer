import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by fedomn on 2015/5/31.
 */
public class ResponseMakerTests {

    @Test
    public void GIVEN_playFirst_SHOULD_SayOmxPlay() throws Exception {
        assertEquals("Failure - given playFirst should say /home/pi/server/omx_control.sh play",
                "/home/pi/server/omx_control.sh play", ResponseMaker.translate("playFirst"));
    }
}
