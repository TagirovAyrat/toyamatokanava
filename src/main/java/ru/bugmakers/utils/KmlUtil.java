package ru.bugmakers.utils;

import com.sun.xml.bind.marshaller.NamespacePrefixMapper;
import de.micromata.opengis.kml.v_2_2_0.*;
import ru.bugmakers.entity.Point;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by ivan
 */
public class KmlUtil {

    private static final String GREEN = "ff387109";
    private static final String YELLOW = "ff00eaff";
    private static final String RED = "ff5252ff";


    public static String createKml(List<Point> points) {

        String green = "green";
        String yellow = "yellow";
        String red = "red";
        String greenMap = "greenMap";
        String yellowMap = "yellowMap";
        String redMap = "redMap";
        double width = 1.2;

        Kml kml = KmlFactory.createKml();

        Document document = kml.createAndSetDocument().withName("Name").withDescription("Description");
        LineStyle lineStyleGreen = KmlFactory.createLineStyle()
                .withColor(GREEN)
                .withWidth(width);
        document.createAndAddStyle().withId(green).withLineStyle(lineStyleGreen);

        LineStyle lineStyleYellow = KmlFactory.createLineStyle()
                .withColor(YELLOW)
                .withWidth(width);
        document.createAndAddStyle().withId(yellow).withLineStyle(lineStyleYellow);

        LineStyle lineStyleRed = KmlFactory.createLineStyle()
                .withColor(RED)
                .withWidth(width);
        document.createAndAddStyle().withId(red).withLineStyle(lineStyleRed);

        document.createAndAddStyleMap().withId(greenMap).withPair(Collections.singletonList(new Pair().withKey(StyleState.NORMAL).withStyleUrl("#" + green)));
        document.createAndAddStyleMap().withId(yellowMap).withPair(Collections.singletonList(new Pair().withKey(StyleState.NORMAL).withStyleUrl("#" + yellow)));
        document.createAndAddStyleMap().withId(redMap).withPair(Collections.singletonList(new Pair().withKey(StyleState.NORMAL).withStyleUrl("#" + red)));

        Folder folder = document.createAndAddFolder();

        for (int i = 1; i < points.size(); i++) {

            Point fPoint = points.get(i - 1);
            Point sPoint = points.get(i);
            Placemark placemark = folder.createAndAddPlacemark();
            List<Coordinate> coordinates = new ArrayList<>();
            coordinates.add(new Coordinate(Double.parseDouble(fPoint.getLng()), Double.parseDouble(fPoint.getLat())));
            coordinates.add(new Coordinate(Double.parseDouble(sPoint.getLng()), Double.parseDouble(sPoint.getLat())));
            placemark.createAndSetLineString().withCoordinates(coordinates).withTessellate(Boolean.TRUE);
            switch (fPoint.getLevel()) {
                case "1":
                    placemark.setStyleUrl("#" + greenMap);
                    break;
                case "2":
                    placemark.setStyleUrl("#" + yellowMap);
                    break;
                case "3":
                    placemark.setStyleUrl("#" + redMap);
                    break;
            }

        }

        String fileName = new SimpleDateFormat("HHmmss").format(new Date()) + ".kml";
        File file = new File(fileName);

        try {
            Marshaller marshaller = JAXBContext.newInstance(new Class[]{Kml.class}).createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new NamespacePrefixMapper() {
                @Override
                public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {
                    return namespaceUri.matches("http://www.w3.org/\\d{4}/Atom") ? "atom"
                            : (
                            namespaceUri.matches("urn:oasis:names:tc:ciq:xsdschema:xAL:.*?") ? "xal"
                                    : (
                                    namespaceUri.matches("http://www.google.com/kml/ext/.*?") ? "gx"
                                            : (
                                            namespaceUri.matches("http://www.opengis.net/kml/.*?") ? ""
                                                    : (
                                                    null
                                            )
                                    )
                            )
                    );
                }
            });
            marshaller.marshal(kml, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return fileName;
    }

//    public static void main(String[] args) {
//        List<Point> points = new ArrayList<>();
////        points.add(new Point("48.7431836", "55.7504848", "1"));
////        points.add(new Point("48.7444282", "55.751789", "1"));
//        points.add(new Point("48.7478828", "55.7512456", "1"));
//        points.add(new Point("48.7472177", "55.7502916", "2"));
//        points.add(new Point("48.747164", "55.750207", "3"));
//        points.add(new Point("48.7467456", "55.7496274", "1"));
//        createKml(points);
//    }

}
