/*
 Copyright (C) 2003 Adam Olsen
 This program is free software; you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation; either version 1, or (at your option)
 any later version.
 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.
 You should have received a copy of the GNU General Public License
 along with this program; if not, write to the Free Software
 Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */
package main.java.com.valhalla.pluginmanager;

/**
 * All events fired in the plugin chain must inherit PluginEvent
 * 
 * @author Adam Olsen
 * @created October 31, 2004
 */
public class PluginEvent {
    protected Object source;

    /**
     * The default constructor
     * 
     * @param source
     *            The source of this event
     */
    public PluginEvent(Object source) {
        this.source = source;
    }

    /**
     * @return The source event
     */
    public Object getSource() {
        return source;
    }
}

