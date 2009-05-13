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
package com.googlecode.sarasvati.example;

import java.util.Random;

import com.googlecode.sarasvati.Arc;
import com.googlecode.sarasvati.CustomNode;
import com.googlecode.sarasvati.Engine;
import com.googlecode.sarasvati.Env;
import com.googlecode.sarasvati.NodeToken;

public class InitNode extends CustomNode
{
  @Override
  public void execute (Engine engine, NodeToken token)
  {
    long iter = 0;

    Env env = token.getEnv();
    if ( env.hasAttribute( "iter" ) )
    {
      iter = env.getLongAttribute( "iter" );
    }

    env.setLongAttribute( "iter", ++iter );
    env.setLongAttribute( "rand", ( new Random().nextInt() % 2 ) + 1 );
    engine.completeExecution( token, Arc.DEFAULT_ARC );
  }
}