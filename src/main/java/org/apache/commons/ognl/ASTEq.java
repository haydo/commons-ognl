package org.apache.commons.ognl;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/**
 * $Id$
 * @author Luke Blanshard (blanshlu@netscape.net)
 * @author Drew Davidson (drew@ognl.org)
 */
class ASTEq
    extends ComparisonExpression
{
    public ASTEq( int id )
    {
        super( id );
    }

    public ASTEq( OgnlParser p, int id )
    {
        super( p, id );
    }

    protected Object getValueBody( OgnlContext context, Object source )
        throws OgnlException
    {
        Object v1 = _children[0].getValue( context, source );
        Object v2 = _children[1].getValue( context, source );
        return OgnlOps.equal( v1, v2 ) ? Boolean.TRUE : Boolean.FALSE;
    }

    public String getExpressionOperator( int index )
    {
        return "==";
    }

    public String getComparisonFunction()
    {
        return "org.apache.commons.ognl.OgnlOps.equal";
    }
    
    public <R, P> R accept( NodeVisitor<? extends R, ? super P> visitor, P data ) 
    {
        return visitor.visit( this, data );
    }
}
