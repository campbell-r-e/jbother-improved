/* ========================================================================
 * JCommon : a free general purpose class library for the Java(tm) platform
 * ========================================================================
 *
 * (C) Copyright 2000-2004, by Object Refinery Limited and Contributors.
 *
 * Project Info:  http://www.jfree.org/jcommon/index.html
 *
 * This library is free software; you can redistribute it and/or modify it under the terms
 * of the GNU Lesser General Public License as published by the Free Software Foundation;
 * either version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this
 * library; if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA 02111-1307, USA.
 *
 * [Java is a trademark or registered trademark of Sun Microsystems, Inc.
 * in the United States and other countries.]
 *
 * ---------------------
 * FontChooserPanel.java
 * ---------------------
 * (C) Copyright 2000-2004, by Object Refinery Limited.
 *
 * Original Author:  David Gilbert (for Object Refinery Limited);
 * Contributor(s):   Arnaud Lelievre;
 *
 * $Id: FontChooserPanel.java,v 1.12 2004/04/26 19:15:44 taqua Exp $
 *
 * Changes (from 26-Oct-2001)
 * --------------------------
 * 26-Oct-2001 : Changed package to com.jrefinery.ui.*;
 * 14-Oct-2002 : Fixed errors reported by Checkstyle (DG);
 * 08-Sep-2003 : Added internationalization via use of properties resourceBundle (RFE 690236) (AL);
 * 21-Feb-2004 : The FontParameter of the constructor was never used (TM);
 */

package main.java.org.jfree.ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * A panel for choosing a font from the available system fonts - still a bit of
 * a hack at the moment, but good enough for demonstration applications.
 *  
 */
public class FontChooserPanel extends JPanel {

    /** The font sizes that can be selected. */
    public static final String[] SIZES = { "9", "10", "11", "12", "14", "16",
            "18", "20", "22", "24", "28", "36", "48", "72" };

    /** The list of fonts. */
    private JList fontlist;

    /** The list of sizes. */
    private JList sizelist;

    /** The checkbox that indicates whether the font is bold. */
    private JCheckBox bold;

    /** The checkbox that indicates whether or not the font is italic. */
    private JCheckBox italic;

    /** The resourceBundle for the localization. */
    protected static ResourceBundle localizationResources = ResourceBundle
            .getBundle("JBotherBundle", Locale.getDefault());

    private SelectionListener listener = new SelectionListener();

    private JLabel testLabel = new JLabel(localizationResources
            .getString("quickFox"));

    /**
     * Standard constructor - builds a FontChooserPanel initialised with the
     * specified font.
     * 
     * @param font
     *            the initial font to display.
     */
    public FontChooserPanel(final Font font) {

        final GraphicsEnvironment g = GraphicsEnvironment
                .getLocalGraphicsEnvironment();
        final String[] fonts = g.getAvailableFontFamilyNames();

        setLayout(new BorderLayout());
        final JPanel right = new JPanel(new BorderLayout());

        final JPanel fontPanel = new JPanel(new BorderLayout());
        fontPanel
                .setBorder(BorderFactory.createTitledBorder(BorderFactory
                        .createEtchedBorder(), localizationResources
                        .getString("font")));
        this.fontlist = new JList(fonts);
        final JScrollPane fontpane = new JScrollPane(this.fontlist);
        fontpane.setBorder(BorderFactory.createEtchedBorder());
        fontPanel.add(fontpane);
        add(fontPanel, BorderLayout.CENTER);

        final JPanel testPanel = new JPanel(new BorderLayout());
        testPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory
                .createEtchedBorder(), localizationResources
                .getString("sample")));
        testPanel.add(testLabel);
        add(testPanel, BorderLayout.SOUTH);

        final JPanel sizePanel = new JPanel(new BorderLayout());
        sizePanel
                .setBorder(BorderFactory.createTitledBorder(BorderFactory
                        .createEtchedBorder(), localizationResources
                        .getString("size")));
        this.sizelist = new JList(SIZES);
        final JScrollPane sizepane = new JScrollPane(this.sizelist);
        sizepane.setBorder(BorderFactory.createEtchedBorder());
        sizePanel.add(sizepane);

        final JPanel attributes = new JPanel(new GridLayout(1, 2));
        this.bold = new JCheckBox(localizationResources.getString("bold"));
        this.italic = new JCheckBox(localizationResources.getString("italic"));
        attributes.add(this.bold);
        attributes.add(this.italic);
        attributes.setBorder(BorderFactory.createTitledBorder(BorderFactory
                .createEtchedBorder(), localizationResources
                .getString("attributes")));

        bold.addActionListener(listener);
        italic.addActionListener(listener);
        fontlist.addListSelectionListener(listener);
        sizelist.addListSelectionListener(listener);

        right.add(sizePanel, BorderLayout.CENTER);
        right.add(attributes, BorderLayout.SOUTH);

        add(right, BorderLayout.EAST);

        setSelectedFont(font);
    }

    private class SelectionListener implements ActionListener,
            ListSelectionListener {
        public void actionPerformed(ActionEvent e) {
            testLabel.setFont(getSelectedFont());
        }

        public void valueChanged(ListSelectionEvent e) {
            testLabel.setFont(getSelectedFont());
        }
    }

    /**
     * Returns a Font object representing the selection in the panel.
     * 
     * @return the font.
     */
    public Font getSelectedFont() {
        return new Font(getSelectedName(), getSelectedStyle(),
                getSelectedSize());
    }

    /**
     * Returns the selected name.
     * 
     * @return the name.
     */
    public String getSelectedName() {
        return (String) this.fontlist.getSelectedValue();
    }

    /**
     * Returns the selected style.
     * 
     * @return the style.
     */
    public int getSelectedStyle() {
        if (this.bold.isSelected() && this.italic.isSelected()) {
            return Font.BOLD + Font.ITALIC;
        }
        if (this.bold.isSelected()) {
            return Font.BOLD;
        }
        if (this.italic.isSelected()) {
            return Font.ITALIC;
        } else {
            return Font.PLAIN;
        }
    }

    /**
     * Returns the selected size.
     * 
     * @return the size.
     */
    public int getSelectedSize() {
        final String selected = (String) this.sizelist.getSelectedValue();
        if (selected != null) {
            return Integer.parseInt(selected);
        } else {
            return 10;
        }
    }

    /**
     * Initializes the contents of the dialog from the given font object.
     * 
     * @param font
     *            the font from which to read the properties.
     */
    public void setSelectedFont(final Font font) {
        if (font == null) {
            throw new NullPointerException();
        }
        this.bold.setSelected(font.isBold());
        this.italic.setSelected(font.isItalic());

        final String fontName = font.getName();
        ListModel model = this.fontlist.getModel();
        this.fontlist.clearSelection();
        for (int i = 0; i < model.getSize(); i++) {
            if (fontName.equals(model.getElementAt(i))) {
                this.fontlist.setSelectedIndex(i);
                break;
            }
        }

        final String fontSize = String.valueOf(font.getSize());
        model = this.sizelist.getModel();
        this.sizelist.clearSelection();
        for (int i = 0; i < model.getSize(); i++) {
            if (fontSize.equals(model.getElementAt(i))) {
                this.sizelist.setSelectedIndex(i);
                break;
            }
        }

        testLabel.setFont(getSelectedFont());
    }
}