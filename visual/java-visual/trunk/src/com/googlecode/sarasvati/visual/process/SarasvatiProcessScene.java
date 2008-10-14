/*
    This file is part of Sarasvati.

    Sarasvati is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as
    published by the Free Software Foundation, either version 3 of the
    License, or (at your option) any later version.

    Sarasvati is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public
    License along with Sarasvati.  If not, see <http://www.gnu.org/licenses/>.

    Copyright 2008 Paul Lorenz
*/
package com.googlecode.sarasvati.visual.process;

import javax.swing.JLabel;

import org.netbeans.api.visual.widget.ComponentWidget;
import org.netbeans.api.visual.widget.Widget;

import com.googlecode.sarasvati.visual.DefaultNodeIcon;
import com.googlecode.sarasvati.visual.GraphSceneImpl;
import com.googlecode.sarasvati.visual.TaskIcon;

public class SarasvatiProcessScene extends GraphSceneImpl<ProcessTreeNode, ProcessTreeArc>
{
  @Override
  protected Widget widgetForNode (ProcessTreeNode ptNode)
  {
    JLabel label = null;

    if ( "task".equals( ptNode.getNode().getType() ) )
    {
      label =  new JLabel( new TaskIcon( ptNode.getNode(), ptNode.getToken() ) );
    }
    else
    {
      label = new JLabel( new DefaultNodeIcon( ptNode.getNode(), ptNode.getToken() ) );
    }

    return new ComponentWidget( this, label );
  }
}