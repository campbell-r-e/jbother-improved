/*
 *  Copyright (C) 2003 Adam Olsen
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 1, or (at your option)
 *  any later version.
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */
package main.java.com.valhalla.jbother.actions;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import main.java.com.valhalla.jbother.*;
import main.java.com.valhalla.settings.*;

import java.util.*;

/**
 *  Description of the Class
 *
 *@author     synic
 *@created    May 13, 2005
 */
public class ShowAwayAction implements ActionListener {
    private static ShowAwayAction instance = new ShowAwayAction();
    private static Vector items = new Vector();


    /**
     *  Constructor for the ShowOfflineAction object
     */
    private ShowAwayAction() { }


    /**
     *  Adds a feature to the Item attribute of the ShowOfflineAction class
     *
     *@param  button  The feature to be added to the Item attribute
     */
    public static void addItem(AbstractButton button) {
        items.add(button);
        button.addActionListener(instance);
    }


    /**
     *  Description of the Method
     *
     *@param  e  Description of the Parameter
     */
    public void actionPerformed(ActionEvent e) {
        AbstractButton button = (AbstractButton) e.getSource();
        BuddyList.getInstance().getBuddyListTree().setShowAwayBuddies(button.isSelected());

        for (int i = 0; i < items.size(); i++) {
            AbstractButton b = (AbstractButton) items.get(i);
            if (button != b) {
                b.setSelected(button.isSelected());
            }
        }
    }
}

