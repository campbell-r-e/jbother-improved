/*
 * Copyright (C) 2003 Adam Olsen This program is free software; you can
 * redistribute it and/or modify it under the terms of the GNU General Public
 * License as published by the Free Software Foundation; either version 1, or
 * (at your option) any later version. This program is distributed in the hope
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details. You should have received a copy of
 * the GNU General Public License along with this program; if not, write to the
 * Free Software Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

package main.java.com.valhalla.jbother.plugins.events;

import org.jivesoftware.smack.packet.*;

import main.java.com.valhalla.pluginmanager.PluginEvent;

public class MessageReceivedEvent extends PluginEvent {
    private Message message;

    public MessageReceivedEvent(Object source) {
        super(source);
    }

    public void setMessage( Message message ) { this.message = message; }
    public Message getMessage() { return message; }
}