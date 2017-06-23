package serviceProducer;

import Calculator.AzimuthZenithAngle;
import Calculator.DeltaT;
import Calculator.SPA;
import com.sun.xml.ws.developer.SchemaValidation;
import service.*;

import javax.jws.WebService;
import java.util.GregorianCalendar;

/**
 * Created by Mitchell on 11/03/2017.
 */
@WebService ( endpointInterface = "service.WSInterface")
@SchemaValidation(handler = SchemaValidationErrorHandler.class)
public class SolarPositionService implements WSInterface {
    @Override
    public Response calculateSolarPosition(Request request) throws Fault {

        ObjectFactory factory = new ObjectFactory();
        Response response = factory.createResponse();

        try {
            final int year = request.getYear().intValue();
            final int month = request.getMonth().intValue();
            final int dayOfMonth = request.getDayofmonth().intValue();
            final int hour = request.getHour().intValue();
            final int minute = request.getMinute().intValue();

            final GregorianCalendar dateTime = new GregorianCalendar(year, month, dayOfMonth, hour, minute);

            AzimuthZenithAngle position = SPA.calculateSolarPosition(
                    dateTime,
                    request.getLatitude(), // latitude (degrees)
                    request.getLongitude(), // longitude (degrees)
                    request.getElevation(), // elevation (m)
                    DeltaT.estimate(dateTime) // delta T (s)
            );
            System.out.println("SPA: " + position);

            response.setAzimuth(position.getAzimuth());
            response.setZenithAngle(position.getZenithAngle());

        } catch (Exception e) {
            Fault x = factory.createFault();
            x.setErrorCode((short) 1);
            x.setMessage("Kan de Azimuth en/of Zenith angle niet berekenen met de volgende waarden:" +
                    "\ndatetime: " + request.getDayofmonth() + "/" + request.getMonth() + "/" + request.getYear() + " " + request.getHour() + ":" + request.getMinute() +
                    "\nlatitude: " + request.getLatitude() +
                    "\nlongitude: " + request.getLongitude() +
                    "\nelevation: " + request.getElevation());
            throw x;
        }
        return response;
    }
}
