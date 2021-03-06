/* Copyright (C) 2001, 2012 United States Government as represented by
the Administrator of the National Aeronautics and Space Administration.
All Rights Reserved.
*/
package gov.nasa.worldwind.kml;

import gov.nasa.worldwind.event.Message;
import gov.nasa.worldwind.util.Logging;

/**
 * Represents the KML <i>LatLonBox</i> element and provides access to its contents.
 *
 * @author tag
 * @version $Id: KMLAbstractLatLonBoxType.java 822 2012-09-28 03:16:15Z dcollins $
 */
public abstract class KMLAbstractLatLonBoxType extends KMLAbstractObject
{
    /**
     * Construct an instance.
     *
     * @param namespaceURI the qualifying namespace URI. May be null to indicate no namespace qualification.
     */
    protected KMLAbstractLatLonBoxType(String namespaceURI)
    {
        super(namespaceURI);
    }

    public Double getNorth()
    {
        return (Double) this.getField("north");
    }

    public Double getSouth()
    {
        return (Double) this.getField("south");
    }

    public Double getEast()
    {
        return (Double) this.getField("east");
    }

    public Double getWest()
    {
        return (Double) this.getField("west");
    }

    @Override
    public void applyChange(KMLAbstractObject sourceValues)
    {
        if (!(sourceValues instanceof KMLAbstractLatLonBoxType))
        {
            String msg = Logging.getMessage("nullValue.SourceIsNull");
            Logging.error(msg);
            throw new IllegalArgumentException(msg);
        }

        super.applyChange(sourceValues);

        this.onChange(new Message(KMLAbstractObject.MSG_BOX_CHANGED, this));
    }
}
