package serviceProducer;

import org.junit.Assert;
import org.junit.Test;
import service.Fault;
import service.ObjectFactory;
import service.Request;
import service.Response;

import java.math.BigInteger;

/**
 * Created by Mitchell on 12/03/2017.
 */
public class SolarPositionServiceTest {
    ObjectFactory o = new ObjectFactory();
    Request request = o.createRequest();
    SolarPositionService sps = new SolarPositionService();
    private Response output;

    @Test
    public void testSolarPositionService() throws Fault {
        request.setYear(BigInteger.valueOf(1998));
        request.setMonth(BigInteger.valueOf(5));
        request.setDayofmonth(BigInteger.valueOf(12));

        request.setHour(BigInteger.valueOf(11));
        request.setMinute(BigInteger.valueOf(30));

        request.setLatitude(5000);
        request.setLongitude(5000);
        request.setElevation(11);

        output = sps.calculateSolarPosition(request);
        Assert.assertEquals(64.41979147001237, output.getAzimuth(), 0);
        Assert.assertEquals(95.71404597537062, output.getZenithAngle(), 0);
    }

}
