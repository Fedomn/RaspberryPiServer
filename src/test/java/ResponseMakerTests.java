import com.fedomn.ResponseMaker;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Created by fedomn on 2015/5/31.
 */
public class ResponseMakerTests {

    @Test
    public void GIVEN_playFirst_SHOULD_SayOmxPlay() throws Exception {
        assertEquals("Failure - given playFirst should say /home/pi/server/omx_control.sh play",
                "/home/pi/server/omx_control.sh play", ResponseMaker.translate("playfirst"));
    }

    @Test
    public void GIVEN_play_SHOULD_SayOmx() throws Exception {
        assertEquals("Failure - given play should say /home/pi/server/omx_control.sh",
                "/home/pi/server/omx_control.sh", ResponseMaker.translate("play"));
    }

    @Test
    public void GIVEN_officeFirst_SHOULD_SayLibreoffice() throws Exception {
        assertEquals("Failure - given officeFirst should say libreoffice",
                    "libreoffice", ResponseMaker.translate("officefirst"));
    }

    @Test
    public void GIVEN_office_SHOULD_SayAIntNum() throws Exception {
        assertThat("Failure - given office should say a int number",
                ResponseMaker.translate("office next"), anything());
    }
}
