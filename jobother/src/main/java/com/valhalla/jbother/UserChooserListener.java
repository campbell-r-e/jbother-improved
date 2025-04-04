/*
 * UserChooser.java
 *
 * Created on October 28, 2005, 7:27 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package main.java.com.valhalla.jbother;

public interface UserChooserListener
{
	public void usersChosen(UserChooser.Item[] users);
}