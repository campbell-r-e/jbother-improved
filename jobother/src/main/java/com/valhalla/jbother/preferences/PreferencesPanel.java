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

package main.java.com.valhalla.jbother.preferences;

/**
 * The interface that all PreferencesPanels must implement
 * 
 * @author Adam Olsen
 * @version 1.0
 */
interface PreferencesPanel {
    /**
     * Gets temporary settings - in case they don't apply and instead hit cancel
     */
    public main.java.com.valhalla.settings.TempSettings getSettings();
}